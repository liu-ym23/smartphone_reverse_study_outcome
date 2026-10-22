package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.Environment;
import android.os.FileUtils;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class DiscreteOpsXmlRegistry extends DiscreteOpsRegistry {
    private static final String ATTR_ATTRIBUTION_FLAGS = "af";
    private static final String ATTR_CHAIN_ID = "ci";
    private static final String ATTR_DEVICE_ID = "di";
    private static final String ATTR_FLAGS = "f";
    private static final String ATTR_LARGEST_CHAIN_ID = "lc";
    private static final String ATTR_NOTE_DURATION = "nd";
    private static final String ATTR_NOTE_TIME = "nt";
    private static final String ATTR_OP_ID = "op";
    private static final String ATTR_PACKAGE_NAME = "pn";
    private static final String ATTR_TAG = "at";
    private static final String ATTR_UID = "ui";
    private static final String ATTR_UID_STATE = "us";
    private static final String ATTR_VERSION = "v";
    private static final int CURRENT_VERSION = 1;
    static final String DISCRETE_HISTORY_FILE_SUFFIX = "tl";
    private static final String TAG = null;
    private static final String TAG_ENTRY = "e";
    private static final String TAG_HISTORY = "h";
    private static final String TAG_OP = "o";
    private static final String TAG_PACKAGE = "p";
    private static final String TAG_TAG = "a";
    private static final String TAG_UID = "u";
    private DiscreteOps mCachedOps;
    private File mDiscreteAccessDir;
    private DiscreteOps mDiscreteOps;
    private final Object mInMemoryLock;
    private final Object mOnDiskLock;

    private static final class AttributionChain {
        ArrayList<OpEvent> mChain;
        Set<String> mExemptPkgs;
        OpEvent mLastVisibleEvent;
        OpEvent mStartEvent;

        private static final class OpEvent {
            String mAttributionTag;
            int mOpCode;
            DiscreteOpEvent mOpEvent;
            String mPkgName;
            int mUid;

            OpEvent(String pkgName, int uid, String attributionTag, int opCode, DiscreteOpEvent event) {
                this.mPkgName = pkgName;
                this.mUid = uid;
                this.mAttributionTag = attributionTag;
                this.mOpCode = opCode;
                this.mOpEvent = event;
            }

            public boolean matches(String pkgName, int uid, String attributionTag, int opCode, DiscreteOpEvent event) {
                if (Objects.equals(pkgName, this.mPkgName) == true) goto L5;
            L17:
                return false;
            L5:
                if (this.mUid != uid) goto L17;
                if (Objects.equals(attributionTag, this.mAttributionTag) == false) goto L17;
                if (this.mOpCode != opCode) goto L17;
                if (this.mOpEvent.mAttributionChainId != event.mAttributionChainId) goto L17;
                if (this.mOpEvent.mAttributionFlags != event.mAttributionFlags) goto L17;
                if (this.mOpEvent.mNoteTime != event.mNoteTime) goto L17;
                return true;
            }

            public boolean packageOpEquals(OpEvent other) {
                if (Objects.equals(other.mPkgName, this.mPkgName) == true) goto L5;
            L11:
                return false;
            L5:
                if (other.mUid != this.mUid) goto L11;
                if (Objects.equals(other.mAttributionTag, this.mAttributionTag) == false) goto L11;
                if (this.mOpCode != other.mOpCode) goto L11;
                return true;
            }

            public boolean equalsExceptDuration(OpEvent other) {
                if (other.mOpEvent.mNoteDuration != this.mOpEvent.mNoteDuration) goto L6;
                return false;
            L6:
                if (packageOpEquals(other) == true) goto L8;
                return false;
            L8:
                if (this.mOpEvent.equalsExceptDuration(other.mOpEvent) == false) goto L12;
                return true;
            L12:
                return false;
            }
        }

        AttributionChain(Set<String> exemptPkgs) {
            this.mChain = new ArrayList();
            this.mStartEvent = null;
            this.mLastVisibleEvent = null;
            this.mExemptPkgs = exemptPkgs;
        }

        boolean isComplete() {
            if (this.mChain.isEmpty() == false) goto L5;
        L9:
            return false;
        L5:
            if (getStart() == null) goto L9;
            if (isEnd(this.mChain.get(this.mChain.size() - 1)) == false) goto L9;
            return true;
        }

        boolean isStart(String pkgName, int uid, String attributionTag, int op, DiscreteOpEvent opEvent) {
            if (this.mStartEvent == null) goto L9;
            if (opEvent != null) goto L7;
            return false;
        L7:
            return this.mStartEvent.matches(pkgName, uid, attributionTag, op, opEvent);
        L9:
            return false;
        }

        private OpEvent getStart() {
            if (this.mChain.isEmpty() == false) goto L5;
        L8:
            return null;
        L5:
            if (isStart(this.mChain.get(0)) == false) goto L8;
            return this.mChain.get(0);
        }

        private OpEvent getLastVisible() {
            int i = this.mChain.size() - 1;
        L3:
            if (i <= 0) goto L8;
            OpEvent event = this.mChain.get(i);
            if (this.mExemptPkgs.contains(event.mPkgName) == false) goto L6;
            i = i - 1;
            goto L3
        L6:
            return event;
        L8:
            return null;
        }

        void addEvent(String pkgName, int uid, String attributionTag, int op, DiscreteOpEvent opEvent) {
            OpEvent event = new OpEvent(pkgName, uid, attributionTag, op, opEvent);
            int i = 0;
        L4:
            if (i >= this.mChain.size()) goto L13;
            OpEvent item = this.mChain.get(i);
            if (item.equalsExceptDuration(event) == true) goto L8;
            i = i + 1;
            goto L4
        L8:
            if (event.mOpEvent.mNoteDuration == (-1)) goto L52;
            item.mOpEvent = event.mOpEvent;
            return;
        L52:
            return;
        L13:
            if (this.mChain.isEmpty() == false) goto L15;
        L36:
            this.mChain.add(event);
        L37:
            OpEvent r10 = null;
            if (isComplete() == false) goto L40;
            OpEvent r9 = getStart();
        L41:
            this.mStartEvent = r9;
            if (isComplete() == false) goto L44;
            r10 = getLastVisible();
        L44:
            this.mLastVisibleEvent = r10;
            return;
        L40:
            r9 = null;
            goto L41
        L15:
            if (isEnd(event) == true) goto L36;
            if (isStart(event) == false) goto L20;
            this.mChain.add(0, event);
            goto L37
        L20:
            int i2 = 0;
        L22:
            if (i2 >= this.mChain.size()) goto L37;
            OpEvent currEvent = this.mChain.get(i2);
            if (isStart(currEvent) == true) goto L28;
            if (currEvent.mOpEvent.mNoteTime <= event.mOpEvent.mNoteTime) goto L28;
        L31:
            this.mChain.add(i2, event);
        L28:
            if (i2 != (this.mChain.size() - 1)) goto L33;
            if (isEnd(currEvent) == true) goto L31;
        L33:
            if (i2 == (this.mChain.size() - 1)) goto L34;
            i2 = i2 + 1;
            goto L22
        L34:
            this.mChain.add(event);
            goto L37
        }

        private boolean isEnd(OpEvent event) {
            if (event != null) goto L4;
        L6:
            return false;
        L4:
            if ((event.mOpEvent.mAttributionFlags & 1) == 0) goto L6;
            return true;
        }

        private boolean isStart(OpEvent event) {
            if (event != null) goto L4;
        L6:
            return false;
        L4:
            if ((event.mOpEvent.mAttributionFlags & 4) == 0) goto L6;
            return true;
        }
    }

    static final class DiscreteDeviceOp {
        ArrayMap<String, List<DiscreteOpEvent>> mAttributedOps;

        public static /* synthetic */ List $r8$lambda$82ZxdHWtqc58qAvslomzoHk9Yz8(String r0) {
            return lambda$getOrCreateDiscreteOpEventsList$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mapplyToHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1794$$Nest$mapplyToHistory(DiscreteDeviceOp r0, AppOpsManager.HistoricalOps r1, int r2, String r3, int r4, ArrayMap r5) {
            r0.applyToHistory(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1795$$Nest$mdump(DiscreteDeviceOp r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4, int r5) {
            r0.dump(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mfilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1796$$Nest$mfilter(DiscreteDeviceOp r0, long r1, long r3, int r5, String r6, int r7, int r8, String r9, int r10, ArrayMap r11) {
            r0.filter(r1, r3, r5, r6, r7, r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOrCreateDiscreteOpEventsList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m1797$$Nest$mgetOrCreateDiscreteOpEventsList(DiscreteDeviceOp r0, String r1) {
            return r0.getOrCreateDiscreteOpEventsList(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$moffsetHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1798$$Nest$moffsetHistory(DiscreteDeviceOp r0, long r1) {
            r0.offsetHistory(r1);
        }

        DiscreteDeviceOp() {
            this.mAttributedOps = new ArrayMap();
        }

        boolean isEmpty() {
            return this.mAttributedOps.isEmpty();
        }

        void merge(DiscreteDeviceOp other) {
            int nTags = other.mAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nTags) goto L6;
            String tag = other.mAttributedOps.keyAt(i);
            List<DiscreteOpEvent> otherEvents = other.mAttributedOps.valueAt(i);
            List<DiscreteOpEvent> events = getOrCreateDiscreteOpEventsList(tag);
            this.mAttributedOps.put(tag, DiscreteOpsXmlRegistry.m1793$$Nest$smstableListMerge(events, otherEvents));
            i = i + 1;
            goto L3
        }

        private void filter(long beginTimeMillis, long endTimeMillis, int filter, String attributionTagFilter, int flagsFilter, int currentUid, String currentPkgName, int currentOp, ArrayMap<Integer, AttributionChain> attributionChains) {
            if ((filter & 4) == 0) goto L5;
            ArrayMap<String, List<DiscreteOpEvent>> attributedOps = new ArrayMap();
            attributedOps.put(attributionTagFilter, getOrCreateDiscreteOpEventsList(attributionTagFilter));
            this.mAttributedOps = attributedOps;
        L5:
            int nTags = this.mAttributedOps.size();
            int i = nTags - 1;
        L6:
            if (i < 0) goto L12;
            String tag = this.mAttributedOps.keyAt(i);
            List<DiscreteOpEvent> list = DiscreteOpsXmlRegistry.m1792$$Nest$smfilterEventsList(this.mAttributedOps.valueAt(i), beginTimeMillis, endTimeMillis, flagsFilter, currentUid, currentPkgName, currentOp, this.mAttributedOps.keyAt(i), attributionChains);
            this.mAttributedOps.put(tag, list);
            if (list.isEmpty() == false) goto L10;
            this.mAttributedOps.removeAt(i);
        L10:
            i = i - 1;
            goto L6
        }

        private void offsetHistory(long offset) {
            int nTags = this.mAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nTags) goto L9;
            List<DiscreteOpEvent> list = this.mAttributedOps.valueAt(i);
            int n = list.size();
            int j = 0;
        L5:
            if (j >= n) goto L7;
            DiscreteOpEvent event = list.get(j);
            list.set(j, new DiscreteOpEvent(event.mNoteTime - offset, event.mNoteDuration, event.mUidState, event.mOpFlag, event.mAttributionFlags, event.mAttributionChainId));
            j = j + 1;
            goto L5
        L7:
            i = i + 1;
            goto L3
        }

        void addDiscreteAccess(String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
            List<DiscreteOpEvent> attributedOps = getOrCreateDiscreteOpEventsList(attributionTag);
            int i = attributedOps.size();
        L3:
            if (i <= 0) goto L23;
            DiscreteOpEvent previousOp = attributedOps.get(i - 1);
            if (DiscreteOpsRegistry.discretizeTimeStamp(previousOp.mNoteTime) < DiscreteOpsRegistry.discretizeTimeStamp(accessTime)) goto L6;
            if (previousOp.mOpFlag != flags) goto L22;
            int r9 = uidState;
            if (previousOp.mUidState != r9) goto L22;
            int r11 = attributionFlags;
            if (previousOp.mAttributionFlags != r11) goto L22;
            int r12 = attributionChainId;
            if (previousOp.mAttributionChainId != r12) goto L22;
            if (DiscreteOpsRegistry.discretizeDuration(accessDuration) != DiscreteOpsRegistry.discretizeDuration(previousOp.mNoteDuration)) goto L24;
            return;
        L24:
            attributedOps.add(i, new DiscreteOpEvent(accessTime, accessDuration, r9, flags, r11, r12));
            return;
        L22:
            i = i - 1;
            goto L3
        L6:
            r9 = uidState;
            r11 = attributionFlags;
            r12 = attributionChainId;
            goto L24
        L23:
            r9 = uidState;
            r11 = attributionFlags;
            r12 = attributionChainId;
            goto L24
        }

        private List<DiscreteOpEvent> getOrCreateDiscreteOpEventsList(String attributionTag) {
            return this.mAttributedOps.computeIfAbsent(attributionTag, new DiscreteOpsXmlRegistry$DiscreteDeviceOp$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ List lambda$getOrCreateDiscreteOpEventsList$0(String k) {
            return new ArrayList();
        }

        private void applyToHistory(AppOpsManager.HistoricalOps result, int uid, String packageName, int op, ArrayMap<Integer, AttributionChain> attributionChains) {
            DiscreteDeviceOp r0 = this;
            int j = r0.mAttributedOps.size();
            int i = 0;
        L3:
            if (i >= j) goto L23;
            String tag = r0.mAttributedOps.keyAt(i);
            List<DiscreteOpEvent> events = r0.mAttributedOps.valueAt(i);
            int nEvents = events.size();
            int j2 = 0;
        L5:
            if (j2 >= nEvents) goto L21;
            DiscreteOpEvent event = events.get(j2);
            AppOpsManager.OpEventProxyInfo proxy = null;
            if (event.mAttributionChainId == (-1)) goto L18;
            AttributionChain chain = attributionChains.get(Integer.valueOf(event.mAttributionChainId));
            if (chain != null) goto L11;
        L17:
            DiscreteOpEvent event2 = event;
        L20:
            int r9 = event2.mUidState;
            int nEvents2 = nEvents;
            int nEvents3 = event2.mOpFlag;
            int nOps = j;
            String tag2 = tag;
            result.addDiscreteAccess(op, uid, packageName, tag2, r9, nEvents3, DiscreteOpsRegistry.discretizeTimeStamp(event2.mNoteTime), DiscreteOpsRegistry.discretizeDuration(event2.mNoteDuration), proxy);
            tag = tag2;
            j2 = j2 + 1;
            nEvents = nEvents2;
            j = nOps;
            goto L5
        L11:
            if (chain.isComplete() == false) goto L17;
            boolean r14 = chain.isStart(packageName, uid, tag, op, event);
            event2 = event;
            if (r14 == false) goto L20;
            if (chain.mLastVisibleEvent == null) goto L20;
            AttributionChain.OpEvent proxyEvent = chain.mLastVisibleEvent;
            proxy = new AppOpsManager.OpEventProxyInfo(proxyEvent.mUid, proxyEvent.mPkgName, proxyEvent.mAttributionTag);
            goto L20
        L18:
            event2 = event;
            goto L20
        L21:
            int nOps2 = j;
            i = i + 1;
            r0 = this;
            j = nOps2;
            goto L3
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
            int nAttributions = this.mAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nAttributions) goto L13;
            pw.print(prefix);
            pw.print("Attribution: ");
            pw.print(this.mAttributedOps.keyAt(i));
            pw.println();
            List<DiscreteOpEvent> ops = this.mAttributedOps.valueAt(i);
            int nOps = ops.size();
            int first = 0;
            if (nDiscreteOps < 1) goto L8;
            first = Math.max(0, nOps - nDiscreteOps);
        L8:
            int j = first;
        L9:
            if (j >= nOps) goto L11;
            DiscreteOpEvent.m1804$$Nest$mdump(ops.get(j), pw, sdf, date, prefix + "  ");
            j = j + 1;
            goto L9
        L11:
            i = i + 1;
            goto L3
        }

        void serialize(TypedXmlSerializer out, String deviceId) throws Exception {
            int nAttributions = this.mAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nAttributions) goto L12;
            out.startTag(null, "a");
            String tag = this.mAttributedOps.keyAt(i);
            if (tag == null) goto L7;
            out.attribute(null, DiscreteOpsXmlRegistry.ATTR_TAG, tag);
        L7:
            List<DiscreteOpEvent> ops = this.mAttributedOps.valueAt(i);
            int nOps = ops.size();
            int j = 0;
        L8:
            if (j >= nOps) goto L10;
            out.startTag(null, DiscreteOpsXmlRegistry.TAG_ENTRY);
            DiscreteOpEvent.m1805$$Nest$mserialize(ops.get(j), out, deviceId);
            out.endTag(null, DiscreteOpsXmlRegistry.TAG_ENTRY);
            j = j + 1;
            goto L8
        L10:
            out.endTag(null, "a");
            i = i + 1;
            goto L3
        }
    }

    static final class DiscreteOp {
        ArrayMap<String, DiscreteDeviceOp> mDeviceAttributedOps;

        /* JADX INFO: renamed from: $r8$lambda$KIUzMWym-uYkJZD6G7D31bKzWj8, reason: not valid java name */
        public static /* synthetic */ long m1799$r8$lambda$KIUzMWymuYkJZD6G7D31bKzWj8(DiscreteOpEvent r2) {
            return lambda$deserialize$1(r2);
        }

        public static /* synthetic */ DiscreteDeviceOp $r8$lambda$RBwqZ7tw9wvT2UiW_Baft6zOUaY(String r0) {
            return lambda$getOrCreateDiscreteDeviceOp$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mapplyToHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1800$$Nest$mapplyToHistory(DiscreteOp r0, AppOpsManager.HistoricalOps r1, int r2, String r3, int r4, ArrayMap r5) {
            r0.applyToHistory(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1801$$Nest$mdump(DiscreteOp r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4, int r5) {
            r0.dump(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mfilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1802$$Nest$mfilter(DiscreteOp r0, long r1, long r3, int r5, String r6, int r7, int r8, String r9, int r10, ArrayMap r11) {
            r0.filter(r1, r3, r5, r6, r7, r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$moffsetHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1803$$Nest$moffsetHistory(DiscreteOp r0, long r1) {
            r0.offsetHistory(r1);
        }

        DiscreteOp() {
            this.mDeviceAttributedOps = new ArrayMap();
        }

        boolean isEmpty() {
            return this.mDeviceAttributedOps.isEmpty();
        }

        void merge(DiscreteOp other) {
            int nDevices = other.mDeviceAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nDevices) goto L6;
            String deviceId = other.mDeviceAttributedOps.keyAt(i);
            DiscreteDeviceOp otherDeviceOps = other.mDeviceAttributedOps.valueAt(i);
            getOrCreateDiscreteDeviceOp(deviceId).merge(otherDeviceOps);
            i = i + 1;
            goto L3
        }

        private void filter(long beginTimeMillis, long endTimeMillis, int filter, String attributionTagFilter, int flagsFilter, int currentUid, String currentPkgName, int currentOp, ArrayMap<Integer, AttributionChain> attributionChains) {
            int nDevices = this.mDeviceAttributedOps.size();
            int i = nDevices - 1;
        L3:
            if (i < 0) goto L9;
            DiscreteDeviceOp.m1796$$Nest$mfilter(this.mDeviceAttributedOps.valueAt(i), beginTimeMillis, endTimeMillis, filter, attributionTagFilter, flagsFilter, currentUid, currentPkgName, currentOp, attributionChains);
            if (this.mDeviceAttributedOps.valueAt(i).isEmpty() == false) goto L7;
            this.mDeviceAttributedOps.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        }

        private void offsetHistory(long offset) {
            int nDevices = this.mDeviceAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nDevices) goto L6;
            DiscreteDeviceOp.m1798$$Nest$moffsetHistory(this.mDeviceAttributedOps.valueAt(i), offset);
            i = i + 1;
            goto L3
        }

        void addDiscreteAccess(String deviceId, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
            getOrCreateDiscreteDeviceOp(deviceId).addDiscreteAccess(attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);
        }

        private DiscreteDeviceOp getOrCreateDiscreteDeviceOp(String deviceId) {
            return this.mDeviceAttributedOps.computeIfAbsent(deviceId, new DiscreteOpsXmlRegistry$DiscreteOp$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ DiscreteDeviceOp lambda$getOrCreateDiscreteDeviceOp$0(String k) {
            return new DiscreteDeviceOp();
        }

        private void applyToHistory(AppOpsManager.HistoricalOps result, int uid, String packageName, int op, ArrayMap<Integer, AttributionChain> attributionChains) {
            if (this.mDeviceAttributedOps.get("default:0") == null) goto L6;
            DiscreteDeviceOp.m1794$$Nest$mapplyToHistory(this.mDeviceAttributedOps.get("default:0"), result, uid, packageName, op, attributionChains);
            return;
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
            int nDevices = this.mDeviceAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nDevices) goto L6;
            pw.print(prefix);
            pw.print("Device: ");
            pw.print(this.mDeviceAttributedOps.keyAt(i));
            pw.println();
            DiscreteDeviceOp.m1795$$Nest$mdump(this.mDeviceAttributedOps.valueAt(i), pw, sdf, date, prefix + "  ", nDiscreteOps);
            i = i + 1;
            goto L3
        }

        void serialize(TypedXmlSerializer out) throws Exception {
            int nDevices = this.mDeviceAttributedOps.size();
            int i = 0;
        L3:
            if (i >= nDevices) goto L6;
            String deviceId = this.mDeviceAttributedOps.keyAt(i);
            this.mDeviceAttributedOps.valueAt(i).serialize(out, deviceId);
            i = i + 1;
            goto L3
        }

        void deserialize(TypedXmlPullParser parser, long beginTimeMillis) throws Exception {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L21;
            if ("a".equals(parser.getName()) == false) goto L4;
            String r4 = null;
            String attributionTag = parser.getAttributeValue(null, DiscreteOpsXmlRegistry.ATTR_TAG);
            int innerDepth = parser.getDepth();
        L9:
            if (XmlUtils.nextElementWithin(parser, innerDepth) == false) goto L4;
            if (DiscreteOpsXmlRegistry.TAG_ENTRY.equals(parser.getName()) == true) goto L12;
            r4 = null;
            goto L9
        L12:
            long noteTime = parser.getAttributeLong(r4, DiscreteOpsXmlRegistry.ATTR_NOTE_TIME);
            long noteDuration = parser.getAttributeLong(r4, DiscreteOpsXmlRegistry.ATTR_NOTE_DURATION, -1);
            int uidState = parser.getAttributeInt(r4, DiscreteOpsXmlRegistry.ATTR_UID_STATE);
            int opFlags = parser.getAttributeInt(r4, DiscreteOpsXmlRegistry.ATTR_FLAGS);
            int attributionFlags = parser.getAttributeInt(r4, DiscreteOpsXmlRegistry.ATTR_ATTRIBUTION_FLAGS, 0);
            int attributionChainId = parser.getAttributeInt(r4, DiscreteOpsXmlRegistry.ATTR_CHAIN_ID, -1);
            String deviceId = parser.getAttributeValue(r4, DiscreteOpsXmlRegistry.ATTR_DEVICE_ID);
            if (deviceId != null) goto L16;
            deviceId = "default:0";
        L16:
            if ((noteTime + noteDuration) < beginTimeMillis) goto L9;
            DiscreteDeviceOp deviceOps = getOrCreateDiscreteDeviceOp(deviceId);
            List<DiscreteOpEvent> events = DiscreteDeviceOp.m1797$$Nest$mgetOrCreateDiscreteOpEventsList(deviceOps, attributionTag);
            DiscreteOpEvent event = new DiscreteOpEvent(noteTime, noteDuration, uidState, opFlags, attributionFlags, attributionChainId);
            events.add(event);
            r4 = null;
            goto L9
        L21:
            int nDeviceOps = this.mDeviceAttributedOps.size();
            int i = 0;
        L22:
            if (i >= nDeviceOps) goto L28;
            DiscreteDeviceOp deviceOp = this.mDeviceAttributedOps.valueAt(i);
            int nAttrOps = deviceOp.mAttributedOps.size();
            int j = 0;
        L24:
            if (j >= nAttrOps) goto L26;
            List<DiscreteOpEvent> events2 = deviceOp.mAttributedOps.valueAt(j);
            events2.sort(Comparator.comparingLong(new DiscreteOpsXmlRegistry$DiscreteOp$$ExternalSyntheticLambda1()));
            j = j + 1;
            goto L24
        L26:
            i = i + 1;
            goto L22
        }

        private static /* synthetic */ long lambda$deserialize$1(DiscreteOpEvent a) {
            return a.mNoteTime;
        }
    }

    static final class DiscreteOpEvent {
        final int mAttributionChainId;
        final int mAttributionFlags;
        final long mNoteDuration;
        final long mNoteTime;
        final int mOpFlag;
        final int mUidState;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1804$$Nest$mdump(DiscreteOpEvent r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4) {
            r0.dump(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mserialize, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1805$$Nest$mserialize(DiscreteOpEvent r0, TypedXmlSerializer r1, String r2) {
            r0.serialize(r1, r2);
        }

        DiscreteOpEvent(long noteTime, long noteDuration, int uidState, int opFlag, int attributionFlags, int attributionChainId) {
            this.mNoteTime = noteTime;
            this.mNoteDuration = noteDuration;
            this.mUidState = uidState;
            this.mOpFlag = opFlag;
            this.mAttributionFlags = attributionFlags;
            this.mAttributionChainId = attributionChainId;
        }

        public boolean equalsExceptDuration(DiscreteOpEvent o) {
            if (this.mNoteTime == o.mNoteTime) goto L5;
        L13:
            return false;
        L5:
            if (this.mUidState != o.mUidState) goto L13;
            if (this.mOpFlag != o.mOpFlag) goto L13;
            if (this.mAttributionFlags != o.mAttributionFlags) goto L13;
            if (this.mAttributionChainId != o.mAttributionChainId) goto L13;
            return true;
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix) {
            pw.print(prefix);
            pw.print("Access [");
            pw.print(AppOpsManager.getUidStateName(this.mUidState));
            pw.print("-");
            pw.print(AppOpsManager.flagsToString(this.mOpFlag));
            pw.print("] at ");
            date.setTime(this.mNoteTime);
            pw.print(sdf.format(date));
            if (this.mNoteDuration == (-1)) goto L6;
            pw.print(" for ");
            pw.print(this.mNoteDuration);
            pw.print(" milliseconds ");
        L6:
            if (this.mAttributionFlags == 0) goto L8;
            pw.print(" attribution flags=");
            pw.print(this.mAttributionFlags);
            pw.print(" with chainId=");
            pw.print(this.mAttributionChainId);
        L8:
            pw.println();
        }

        private void serialize(TypedXmlSerializer out, String deviceId) throws Exception {
            out.attributeLong(null, DiscreteOpsXmlRegistry.ATTR_NOTE_TIME, this.mNoteTime);
            if (this.mNoteDuration == (-1)) goto L6;
            out.attributeLong(null, DiscreteOpsXmlRegistry.ATTR_NOTE_DURATION, this.mNoteDuration);
        L6:
            if (this.mAttributionFlags == 0) goto L9;
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_ATTRIBUTION_FLAGS, this.mAttributionFlags);
        L9:
            if (this.mAttributionChainId == (-1)) goto L12;
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_CHAIN_ID, this.mAttributionChainId);
        L12:
            if (Objects.equals(deviceId, "default:0") == true) goto L14;
            out.attribute(null, DiscreteOpsXmlRegistry.ATTR_DEVICE_ID, deviceId);
        L14:
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_UID_STATE, this.mUidState);
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_FLAGS, this.mOpFlag);
        }
    }

    static final class DiscreteOps {
        int mChainIdOffset;
        int mLargestChainId;
        ArrayMap<Integer, DiscreteUidOps> mUids;

        /* JADX INFO: renamed from: -$$Nest$mapplyToHistoricalOps, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1806$$Nest$mapplyToHistoricalOps(DiscreteOps r0, AppOpsManager.HistoricalOps r1, ArrayMap r2) {
            r0.applyToHistoricalOps(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mclearHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1807$$Nest$mclearHistory(DiscreteOps r0, int r1, String r2) {
            r0.clearHistory(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1808$$Nest$mdump(DiscreteOps r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4, int r5) {
            r0.dump(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mfilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1809$$Nest$mfilter(DiscreteOps r0, long r1, long r3, int r5, int r6, String r7, String[] r8, String r9, int r10, ArrayMap r11) {
            r0.filter(r1, r3, r5, r6, r7, r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$moffsetHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1810$$Nest$moffsetHistory(DiscreteOps r0, long r1) {
            r0.offsetHistory(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mreadFromFile, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1811$$Nest$mreadFromFile(DiscreteOps r0, File r1, long r2) {
            r0.readFromFile(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mwriteToStream, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1812$$Nest$mwriteToStream(DiscreteOps r0, FileOutputStream r1) {
            r0.writeToStream(r1);
        }

        DiscreteOps(int chainIdOffset) {
            this.mUids = new ArrayMap();
            this.mChainIdOffset = chainIdOffset;
            this.mLargestChainId = chainIdOffset;
        }

        boolean isEmpty() {
            return this.mUids.isEmpty();
        }

        void merge(DiscreteOps other) {
            this.mLargestChainId = Math.max(this.mLargestChainId, other.mLargestChainId);
            int nUids = other.mUids.size();
            int i = 0;
        L3:
            if (i >= nUids) goto L6;
            int uid = other.mUids.keyAt(i).intValue();
            DiscreteUidOps uidOps = other.mUids.valueAt(i);
            getOrCreateDiscreteUidOps(uid).merge(uidOps);
            i = i + 1;
            goto L3
        }

        void addDiscreteAccess(int op, int uid, String packageName, String deviceId, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
            if (attributionChainId == (-1)) goto L10;
            int offsetChainId = attributionChainId + this.mChainIdOffset;
            if (offsetChainId <= this.mLargestChainId) goto L7;
            this.mLargestChainId = offsetChainId;
        L9:
            int offsetChainId2 = offsetChainId;
        L11:
            getOrCreateDiscreteUidOps(uid).addDiscreteAccess(op, packageName, deviceId, attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, offsetChainId2);
            return;
        L7:
            if (offsetChainId >= 0) goto L9;
            this.mLargestChainId = 0;
            this.mChainIdOffset = attributionChainId * (-1);
            offsetChainId2 = 0;
            goto L11
        L10:
            offsetChainId2 = attributionChainId;
            goto L11
        }

        private void filter(long beginTimeMillis, long endTimeMillis, int filter, int uidFilter, String packageNameFilter, String[] opNamesFilter, String attributionTagFilter, int flagsFilter, ArrayMap<Integer, AttributionChain> attributionChains) {
            if ((filter & 1) == 0) goto L6;
            ArrayMap<Integer, DiscreteUidOps> uids = new ArrayMap();
            uids.put(Integer.valueOf(uidFilter), getOrCreateDiscreteUidOps(uidFilter));
            this.mUids = uids;
        L6:
            int nUids = this.mUids.size();
            int i = nUids - 1;
        L7:
            if (i < 0) goto L13;
            DiscreteUidOps.m1820$$Nest$mfilter(this.mUids.valueAt(i), beginTimeMillis, endTimeMillis, filter, packageNameFilter, opNamesFilter, attributionTagFilter, flagsFilter, this.mUids.keyAt(i).intValue(), attributionChains);
            if (this.mUids.valueAt(i).isEmpty() == false) goto L11;
            this.mUids.removeAt(i);
        L11:
            i = i - 1;
            goto L7
        }

        private void offsetHistory(long offset) {
            int nUids = this.mUids.size();
            int i = 0;
        L3:
            if (i >= nUids) goto L6;
            DiscreteUidOps.m1821$$Nest$moffsetHistory(this.mUids.valueAt(i), offset);
            i = i + 1;
            goto L3
        }

        private void clearHistory(int uid, String packageName) {
            if (this.mUids.containsKey(Integer.valueOf(uid)) == false) goto L8;
            DiscreteUidOps.m1818$$Nest$mclearPackage(this.mUids.get(Integer.valueOf(uid)), packageName);
            if (this.mUids.get(Integer.valueOf(uid)).isEmpty() == false) goto L9;
            this.mUids.remove(Integer.valueOf(uid));
            return;
        L9:
            return;
        }

        private void applyToHistoricalOps(AppOpsManager.HistoricalOps result, ArrayMap<Integer, AttributionChain> attributionChains) {
            int nUids = this.mUids.size();
            int i = 0;
        L3:
            if (i >= nUids) goto L6;
            DiscreteUidOps.m1817$$Nest$mapplyToHistory(this.mUids.valueAt(i), result, this.mUids.keyAt(i).intValue(), attributionChains);
            i = i + 1;
            goto L3
        }

        private void writeToStream(FileOutputStream stream) throws Exception {
            TypedXmlSerializer out = Xml.resolveSerializer(stream);
            out.startDocument(null, true);
            out.startTag(null, DiscreteOpsXmlRegistry.TAG_HISTORY);
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_VERSION, 1);
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_LARGEST_CHAIN_ID, this.mLargestChainId);
            int nUids = this.mUids.size();
            int i = 0;
        L3:
            if (i >= nUids) goto L5;
            out.startTag(null, DiscreteOpsXmlRegistry.TAG_UID);
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_UID, this.mUids.keyAt(i).intValue());
            this.mUids.valueAt(i).serialize(out);
            out.endTag(null, DiscreteOpsXmlRegistry.TAG_UID);
            i = i + 1;
            goto L3
        L5:
            out.endTag(null, DiscreteOpsXmlRegistry.TAG_HISTORY);
            out.endDocument();
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
            int nUids = this.mUids.size();
            int i = 0;
        L3:
            if (i >= nUids) goto L6;
            pw.print(prefix);
            pw.print("Uid: ");
            pw.print(this.mUids.keyAt(i));
            pw.println();
            DiscreteUidOps.m1819$$Nest$mdump(this.mUids.valueAt(i), pw, sdf, date, prefix + "  ", nDiscreteOps);
            i = i + 1;
            goto L3
        }

        private DiscreteUidOps getOrCreateDiscreteUidOps(int uid) {
            DiscreteUidOps result = this.mUids.get(Integer.valueOf(uid));
            if (result != null) goto L6;
            DiscreteUidOps result2 = new DiscreteUidOps();
            this.mUids.put(Integer.valueOf(uid), result2);
            return result2;
        L6:
            return result;
        }

        private void readFromFile(File f, long beginTimeMillis) {
            FileInputStream stream = new FileInputStream(f);     // Catch: FileNotFoundException -> L32
            TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L13
            XmlUtils.beginDocument(parser, DiscreteOpsXmlRegistry.TAG_HISTORY);     // Catch: Throwable -> L13
            int version = parser.getAttributeInt(null, DiscreteOpsXmlRegistry.ATTR_VERSION);     // Catch: Throwable -> L13
            if (version != 1) goto L21;
            int depth = parser.getDepth();     // Catch: Throwable -> L13
        L8:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L16;
            if (DiscreteOpsXmlRegistry.TAG_UID.equals(parser.getName()) == false) goto L8;
            int uid = parser.getAttributeInt(null, DiscreteOpsXmlRegistry.ATTR_UID, -1);     // Catch: Throwable -> L13
            getOrCreateDiscreteUidOps(uid).deserialize(parser, beginTimeMillis);     // Catch: Throwable -> L13
            goto L8
        L16:
            stream.close();     // Catch: IOException -> L18
            return;
        L21:
            throw new IllegalStateException("Dropping unsupported discrete history " + f);     // Catch: Throwable -> L13
        L13:
            t = move-exception;
            Slog.e(DiscreteOpsXmlRegistry.m1791$$Nest$sfgetTAG(), "Failed to read file " + f.getName() + " " + t.getMessage() + " " + Arrays.toString(t.getStackTrace()));     // Catch: Throwable -> L27
            stream.close();     // Catch: IOException -> L18
            return;
        L27:
            th = move-exception;
            stream.close();     // Catch: IOException -> L30
        L31:
            throw th;
        L33:
            return;
        }
    }

    static final class DiscretePackageOps {
        ArrayMap<Integer, DiscreteOp> mPackageOps;

        /* JADX INFO: renamed from: -$$Nest$mapplyToHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1813$$Nest$mapplyToHistory(DiscretePackageOps r0, AppOpsManager.HistoricalOps r1, int r2, String r3, ArrayMap r4) {
            r0.applyToHistory(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1814$$Nest$mdump(DiscretePackageOps r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4, int r5) {
            r0.dump(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mfilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1815$$Nest$mfilter(DiscretePackageOps r0, long r1, long r3, int r5, String[] r6, String r7, int r8, int r9, String r10, ArrayMap r11) {
            r0.filter(r1, r3, r5, r6, r7, r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$moffsetHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1816$$Nest$moffsetHistory(DiscretePackageOps r0, long r1) {
            r0.offsetHistory(r1);
        }

        DiscretePackageOps() {
            this.mPackageOps = new ArrayMap();
        }

        boolean isEmpty() {
            return this.mPackageOps.isEmpty();
        }

        void addDiscreteAccess(int op, String deviceId, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
            getOrCreateDiscreteOp(op).addDiscreteAccess(deviceId, attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);
        }

        void merge(DiscretePackageOps other) {
            int nOps = other.mPackageOps.size();
            int i = 0;
        L3:
            if (i >= nOps) goto L6;
            int opId = other.mPackageOps.keyAt(i).intValue();
            DiscreteOp op = other.mPackageOps.valueAt(i);
            getOrCreateDiscreteOp(opId).merge(op);
            i = i + 1;
            goto L3
        }

        private void filter(long beginTimeMillis, long endTimeMillis, int filter, String[] opNamesFilter, String attributionTagFilter, int flagsFilter, int currentUid, String currentPkgName, ArrayMap<Integer, AttributionChain> attributionChains) {
            int nOps = this.mPackageOps.size();
            int i = nOps - 1;
        L3:
            if (i < 0) goto L15;
            int opId = this.mPackageOps.keyAt(i).intValue();
            if ((filter & 8) == 0) goto L10;
            if (ArrayUtils.contains(opNamesFilter, AppOpsManager.opToPublicName(opId)) == true) goto L10;
            this.mPackageOps.removeAt(i);
        L13:
            i = i - 1;
        L10:
            DiscreteOp.m1802$$Nest$mfilter(this.mPackageOps.valueAt(i), beginTimeMillis, endTimeMillis, filter, attributionTagFilter, flagsFilter, currentUid, currentPkgName, this.mPackageOps.keyAt(i).intValue(), attributionChains);
            if (this.mPackageOps.valueAt(i).isEmpty() == false) goto L13;
            this.mPackageOps.removeAt(i);
            goto L13
        }

        private void offsetHistory(long offset) {
            int nOps = this.mPackageOps.size();
            int i = 0;
        L3:
            if (i >= nOps) goto L6;
            DiscreteOp.m1803$$Nest$moffsetHistory(this.mPackageOps.valueAt(i), offset);
            i = i + 1;
            goto L3
        }

        private DiscreteOp getOrCreateDiscreteOp(int op) {
            DiscreteOp result = this.mPackageOps.get(Integer.valueOf(op));
            if (result != null) goto L6;
            DiscreteOp result2 = new DiscreteOp();
            this.mPackageOps.put(Integer.valueOf(op), result2);
            return result2;
        L6:
            return result;
        }

        private void applyToHistory(AppOpsManager.HistoricalOps result, int uid, String packageName, ArrayMap<Integer, AttributionChain> attributionChains) {
            int nPackageOps = this.mPackageOps.size();
            int i = 0;
        L3:
            if (i >= nPackageOps) goto L6;
            DiscreteOp.m1800$$Nest$mapplyToHistory(this.mPackageOps.valueAt(i), result, uid, packageName, this.mPackageOps.keyAt(i).intValue(), attributionChains);
            i = i + 1;
            goto L3
        }

        void serialize(TypedXmlSerializer out) throws Exception {
            int nOps = this.mPackageOps.size();
            int i = 0;
        L3:
            if (i >= nOps) goto L6;
            out.startTag(null, DiscreteOpsXmlRegistry.TAG_OP);
            out.attributeInt(null, DiscreteOpsXmlRegistry.ATTR_OP_ID, this.mPackageOps.keyAt(i).intValue());
            this.mPackageOps.valueAt(i).serialize(out);
            out.endTag(null, DiscreteOpsXmlRegistry.TAG_OP);
            i = i + 1;
            goto L3
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
            int nOps = this.mPackageOps.size();
            int i = 0;
        L3:
            if (i >= nOps) goto L6;
            pw.print(prefix);
            pw.print(AppOpsManager.opToName(this.mPackageOps.keyAt(i).intValue()));
            pw.println();
            DiscreteOp.m1801$$Nest$mdump(this.mPackageOps.valueAt(i), pw, sdf, date, prefix + "  ", nDiscreteOps);
            i = i + 1;
            goto L3
        }

        void deserialize(TypedXmlPullParser parser, long beginTimeMillis) throws Exception {
            int depth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L8;
            if (DiscreteOpsXmlRegistry.TAG_OP.equals(parser.getName()) == false) goto L4;
            int op = parser.getAttributeInt(null, DiscreteOpsXmlRegistry.ATTR_OP_ID);
            getOrCreateDiscreteOp(op).deserialize(parser, beginTimeMillis);
            goto L4
        }
    }

    static final class DiscreteUidOps {
        ArrayMap<String, DiscretePackageOps> mPackages;

        /* JADX INFO: renamed from: -$$Nest$mapplyToHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1817$$Nest$mapplyToHistory(DiscreteUidOps r0, AppOpsManager.HistoricalOps r1, int r2, ArrayMap r3) {
            r0.applyToHistory(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mclearPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1818$$Nest$mclearPackage(DiscreteUidOps r0, String r1) {
            r0.clearPackage(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1819$$Nest$mdump(DiscreteUidOps r0, PrintWriter r1, SimpleDateFormat r2, Date r3, String r4, int r5) {
            r0.dump(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mfilter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1820$$Nest$mfilter(DiscreteUidOps r0, long r1, long r3, int r5, String r6, String[] r7, String r8, int r9, int r10, ArrayMap r11) {
            r0.filter(r1, r3, r5, r6, r7, r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: -$$Nest$moffsetHistory, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1821$$Nest$moffsetHistory(DiscreteUidOps r0, long r1) {
            r0.offsetHistory(r1);
        }

        DiscreteUidOps() {
            this.mPackages = new ArrayMap();
        }

        boolean isEmpty() {
            return this.mPackages.isEmpty();
        }

        void merge(DiscreteUidOps other) {
            int nPackages = other.mPackages.size();
            int i = 0;
        L3:
            if (i >= nPackages) goto L6;
            String packageName = other.mPackages.keyAt(i);
            DiscretePackageOps p = other.mPackages.valueAt(i);
            getOrCreateDiscretePackageOps(packageName).merge(p);
            i = i + 1;
            goto L3
        }

        private void filter(long beginTimeMillis, long endTimeMillis, int filter, String packageNameFilter, String[] opNamesFilter, String attributionTagFilter, int flagsFilter, int currentUid, ArrayMap<Integer, AttributionChain> attributionChains) {
            if ((filter & 2) == 0) goto L5;
            ArrayMap<String, DiscretePackageOps> packages = new ArrayMap();
            packages.put(packageNameFilter, getOrCreateDiscretePackageOps(packageNameFilter));
            this.mPackages = packages;
        L5:
            int nPackages = this.mPackages.size();
            int i = nPackages - 1;
        L6:
            if (i < 0) goto L12;
            DiscretePackageOps.m1815$$Nest$mfilter(this.mPackages.valueAt(i), beginTimeMillis, endTimeMillis, filter, opNamesFilter, attributionTagFilter, flagsFilter, currentUid, this.mPackages.keyAt(i), attributionChains);
            if (this.mPackages.valueAt(i).isEmpty() == false) goto L10;
            this.mPackages.removeAt(i);
        L10:
            i = i - 1;
            goto L6
        }

        private void offsetHistory(long offset) {
            int nPackages = this.mPackages.size();
            int i = 0;
        L3:
            if (i >= nPackages) goto L6;
            DiscretePackageOps.m1816$$Nest$moffsetHistory(this.mPackages.valueAt(i), offset);
            i = i + 1;
            goto L3
        }

        private void clearPackage(String packageName) {
            this.mPackages.remove(packageName);
        }

        void addDiscreteAccess(int op, String packageName, String deviceId, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
            getOrCreateDiscretePackageOps(packageName).addDiscreteAccess(op, deviceId, attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);
        }

        private DiscretePackageOps getOrCreateDiscretePackageOps(String packageName) {
            DiscretePackageOps result = this.mPackages.get(packageName);
            if (result != null) goto L6;
            DiscretePackageOps result2 = new DiscretePackageOps();
            this.mPackages.put(packageName, result2);
            return result2;
        L6:
            return result;
        }

        private void applyToHistory(AppOpsManager.HistoricalOps result, int uid, ArrayMap<Integer, AttributionChain> attributionChains) {
            int nPackages = this.mPackages.size();
            int i = 0;
        L3:
            if (i >= nPackages) goto L6;
            DiscretePackageOps.m1813$$Nest$mapplyToHistory(this.mPackages.valueAt(i), result, uid, this.mPackages.keyAt(i), attributionChains);
            i = i + 1;
            goto L3
        }

        void serialize(TypedXmlSerializer out) throws Exception {
            int nPackages = this.mPackages.size();
            int i = 0;
        L3:
            if (i >= nPackages) goto L6;
            out.startTag(null, DiscreteOpsXmlRegistry.TAG_PACKAGE);
            out.attribute(null, DiscreteOpsXmlRegistry.ATTR_PACKAGE_NAME, this.mPackages.keyAt(i));
            this.mPackages.valueAt(i).serialize(out);
            out.endTag(null, DiscreteOpsXmlRegistry.TAG_PACKAGE);
            i = i + 1;
            goto L3
        }

        private void dump(PrintWriter pw, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
            int nPackages = this.mPackages.size();
            int i = 0;
        L3:
            if (i >= nPackages) goto L6;
            pw.print(prefix);
            pw.print("Package: ");
            pw.print(this.mPackages.keyAt(i));
            pw.println();
            DiscretePackageOps.m1814$$Nest$mdump(this.mPackages.valueAt(i), pw, sdf, date, prefix + "  ", nDiscreteOps);
            i = i + 1;
            goto L3
        }

        void deserialize(TypedXmlPullParser parser, long beginTimeMillis) throws Exception {
            int depth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L8;
            if (DiscreteOpsXmlRegistry.TAG_PACKAGE.equals(parser.getName()) == false) goto L4;
            String packageName = parser.getAttributeValue(null, DiscreteOpsXmlRegistry.ATTR_PACKAGE_NAME);
            getOrCreateDiscretePackageOps(packageName).deserialize(parser, beginTimeMillis);
            goto L4
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1791$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smfilterEventsList, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m1792$$Nest$smfilterEventsList(List r0, long r1, long r3, int r5, int r6, String r7, int r8, String r9, ArrayMap r10) {
        return filterEventsList(r0, r1, r3, r5, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: -$$Nest$smstableListMerge, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m1793$$Nest$smstableListMerge(List r0, List r1) {
        return stableListMerge(r0, r1);
    }

    static {
        TAG = DiscreteOpsXmlRegistry.class.getSimpleName();
    }

    DiscreteOpsXmlRegistry(Object inMemoryLock) {
        this(inMemoryLock, getDiscreteOpsDir());
    }

    DiscreteOpsXmlRegistry(Object inMemoryLock, File discreteAccessDir) {
        this.mOnDiskLock = new Object();
        this.mCachedOps = null;
        this.mInMemoryLock = inMemoryLock;
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        this.mDiscreteAccessDir = discreteAccessDir;     // Catch: Throwable -> L10
        createDiscreteAccessDirLocked();     // Catch: Throwable -> L10
        int largestChainId = readLargestChainIdFromDiskLocked();     // Catch: Throwable -> L10
        Object r2 = this.mInMemoryLock;     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        this.mDiscreteOps = new DiscreteOps(largestChainId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    static File getDiscreteOpsDir() {
        return new File(new File(Environment.getDataSystemDirectory(), "appops"), "discrete");
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void recordDiscreteAccess(int uid, String packageName, String deviceId, int op, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
        if (DiscreteOpsRegistry.isDiscreteOp(op, flags) == true) goto L5;
        return;
    L5:
        Object r2 = this.mInMemoryLock;
        monitor-enter(r2);
        this.mDiscreteOps.addDiscreteAccess(op, uid, packageName, "default:0", attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = th;
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L13
        throw th;
    L15:
        th = th;
        goto L17
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void writeAndClearOldAccessHistory() {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDiscreteAccessDir != null) goto L11;
        Slog.d(TAG, "State not saved - persistence not initialized.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L9
        monitor-enter(r1);     // Catch: Throwable -> L9
        DiscreteOps discreteOps = this.mDiscreteOps;     // Catch: Throwable -> L20
        this.mDiscreteOps = new DiscreteOps(discreteOps.mChainIdOffset);     // Catch: Throwable -> L20
        this.mCachedOps = null;     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        deleteOldDiscreteHistoryFilesLocked();     // Catch: Throwable -> L9
        if (discreteOps.isEmpty() == true) goto L18;
        persistDiscreteOpsLocked(discreteOps);     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }

    void migrateSqliteData(DiscreteOps sqliteOps) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDiscreteAccessDir != null) goto L11;
        Slog.d(TAG, "State not saved - persistence not initialized.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L9
        monitor-enter(r1);     // Catch: Throwable -> L9
        DiscreteOps r2 = this.mDiscreteOps;     // Catch: Throwable -> L20
        r2.mLargestChainId = sqliteOps.mLargestChainId;     // Catch: Throwable -> L20
        DiscreteOps r3 = this.mDiscreteOps;     // Catch: Throwable -> L20
        r3.mChainIdOffset = sqliteOps.mChainIdOffset;     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
    L16:
        if (sqliteOps.isEmpty() == true) goto L18;
        persistDiscreteOpsLocked(sqliteOps);     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void addFilteredDiscreteOpsToHistoricalOps(AppOpsManager.HistoricalOps result, long beginTimeMillis, long endTimeMillis, int filter, int uidFilter, String packageNameFilter, String[] opNamesFilter, String attributionTagFilter, int flagsFilter, Set<String> attributionExemptPkgs) {
        if (attributionExemptPkgs == null) goto L5;
        boolean assembleChains = true;
    L6:
        DiscreteOps discreteOps = getAllDiscreteOps();
        ArrayMap<Integer, AttributionChain> attributionChains = new ArrayMap();
        if (assembleChains == false) goto L9;
        ArrayMap<Integer, AttributionChain> attributionChains2 = createAttributionChains(discreteOps, attributionExemptPkgs);
        ArrayMap<Integer, AttributionChain> attributionChains3 = attributionChains2;
    L10:
        DiscreteOps.m1809$$Nest$mfilter(discreteOps, Math.max(beginTimeMillis, Instant.now().minus(DiscreteOpsRegistry.sDiscreteHistoryCutoff, ChronoUnit.MILLIS).toEpochMilli()), endTimeMillis, filter, uidFilter, packageNameFilter, opNamesFilter, attributionTagFilter, flagsFilter, attributionChains3);
        DiscreteOps.m1806$$Nest$mapplyToHistoricalOps(discreteOps, result, attributionChains3);
        return;
    L9:
        attributionChains3 = attributionChains;
        goto L10
    L5:
        assembleChains = false;
        goto L6
    }

    int readLargestChainIdFromDiskLocked() {
        File[] files = this.mDiscreteAccessDir.listFiles();
        if (files != null) goto L5;
    L30:
        return 0;
    L5:
        if (files.length <= 0) goto L30;
        File latestFile = null;
        long latestFileTimestamp = 0;
        int r5 = files.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L15;
        File f = files[r6];
        String fileName = f.getName();
        if (fileName.endsWith(DISCRETE_HISTORY_FILE_SUFFIX) == false) goto L14;
        long timestamp = Long.valueOf(fileName.substring(0, fileName.length() - DISCRETE_HISTORY_FILE_SUFFIX.length())).longValue();
        if (latestFileTimestamp >= timestamp) goto L14;
        latestFile = f;
        latestFileTimestamp = timestamp;
    L14:
        r6 = r6 + 1;
        goto L7
    L15:
        if (latestFile != null) goto L37;
        return 0;
    L37:
        FileInputStream stream = new FileInputStream(latestFile);     // Catch: FileNotFoundException -> L28
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L23
        XmlUtils.beginDocument(parser, TAG_HISTORY);     // Catch: Throwable -> L23
        int largestChainId = parser.getAttributeInt(null, ATTR_LARGEST_CHAIN_ID, 0);     // Catch: Throwable -> L23
        stream.close();     // Catch: IOException -> L21
    L22:
        return largestChainId;
    L31:
        stream.close();     // Catch: IOException -> L26
    L27:
        return 0;
    L29:
        return 0;
    }

    private ArrayMap<Integer, AttributionChain> createAttributionChains(DiscreteOps discreteOps, Set<String> attributionExemptPkgs) {
        DiscreteOps r0 = discreteOps;
        ArrayMap<Integer, AttributionChain> chains = new ArrayMap();
        int nDeviceOps = r0.mUids.size();
        int deviceNum = 0;
    L3:
        if (deviceNum >= nDeviceOps) goto L35;
        ArrayMap<String, DiscretePackageOps> pkgs = r0.mUids.valueAt(deviceNum).mPackages;
        int uid = r0.mUids.keyAt(deviceNum).intValue();
        int nPackages = pkgs.size();
        int pkgNum = 0;
    L5:
        if (pkgNum >= nPackages) goto L33;
        ArrayMap<Integer, DiscreteOp> ops = pkgs.valueAt(pkgNum).mPackageOps;
        String pkg = pkgs.keyAt(pkgNum);
        int nOps = ops.size();
        int opNum = 0;
    L7:
        if (opNum >= nOps) goto L32;
        int op = ops.keyAt(opNum).intValue();
        ArrayMap<String, DiscreteDeviceOp> deviceOps = ops.valueAt(opNum).mDeviceAttributedOps;
        int nDeviceOps2 = deviceOps.size();
        int deviceNum2 = 0;
    L9:
        if (deviceNum2 >= nDeviceOps2) goto L31;
        ArrayMap<String, List<DiscreteOpEvent>> attrOps = deviceOps.valueAt(deviceNum2).mAttributedOps;
        int nUids = nDeviceOps;
        int nDeviceOps3 = attrOps.size();
        int uidNum = deviceNum;
        int deviceNum3 = 0;
    L11:
        if (deviceNum3 >= nDeviceOps3) goto L30;
        int nAttrOps = nDeviceOps3;
        List<DiscreteOpEvent> opEvents = attrOps.valueAt(deviceNum3);
        String attributionTag = attrOps.keyAt(deviceNum3);
        ArrayMap<String, List<DiscreteOpEvent>> attrOps2 = attrOps;
        int nOpEvents = opEvents.size();
        int attrOpNum = deviceNum3;
        int deviceNum4 = 0;
    L13:
        if (deviceNum4 >= nOpEvents) goto L29;
        int nOpEvents2 = nOpEvents;
        DiscreteOpEvent event = opEvents.get(deviceNum4);
        if (event == null) goto L27;
        List<DiscreteOpEvent> opEvents2 = opEvents;
        int opEventNum = deviceNum4;
        if (event.mAttributionChainId != (-1)) goto L19;
        pkgs = pkgs;
        String attributionTag2 = attributionTag;
    L28:
        deviceNum2 = deviceNum2;
        deviceNum4 = opEventNum + 1;
        attributionTag = attributionTag2;
        pkgs = pkgs;
        deviceOps = deviceOps;
        nDeviceOps2 = nDeviceOps2;
        opEvents = opEvents2;
        nOpEvents = nOpEvents2;
        goto L13
    L19:
        if ((event.mAttributionFlags & 8) != 0) goto L22;
        pkgs = pkgs;
        attributionTag2 = attributionTag;
        goto L28
    L22:
        if (chains.containsKey(Integer.valueOf(event.mAttributionChainId)) == true) goto L25;
        chains.put(Integer.valueOf(event.mAttributionChainId), new AttributionChain(attributionExemptPkgs));
    L25:
        attributionTag2 = attributionTag;
        chains.get(Integer.valueOf(event.mAttributionChainId)).addEvent(pkg, uid, attributionTag2, op, event);
        goto L28
    L27:
        opEvents2 = opEvents;
        opEventNum = deviceNum4;
        pkgs = pkgs;
        attributionTag2 = attributionTag;
        goto L28
    L29:
        nDeviceOps2 = nDeviceOps2;
        deviceNum3 = attrOpNum + 1;
        nDeviceOps3 = nAttrOps;
        pkgs = pkgs;
        deviceOps = deviceOps;
        attrOps = attrOps2;
        goto L11
    L30:
        int attrOpNum2 = deviceNum2;
        deviceNum2 = attrOpNum2 + 1;
        nDeviceOps = nUids;
        deviceNum = uidNum;
        pkgs = pkgs;
        goto L9
    L31:
        int nUids2 = nDeviceOps;
        int uidNum2 = deviceNum;
        opNum = opNum + 1;
        nDeviceOps = nUids2;
        deviceNum = uidNum2;
        pkgs = pkgs;
        goto L7
    L32:
        pkgNum = pkgNum + 1;
        pkgs = pkgs;
        goto L5
    L33:
        int uidNum3 = deviceNum;
        deviceNum = uidNum3 + 1;
        r0 = discreteOps;
        goto L3
    L35:
        return chains;
    }

    private void readDiscreteOpsFromDisk(DiscreteOps discreteOps) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        long beginTimeMillis = Instant.now().minus(DiscreteOpsRegistry.sDiscreteHistoryCutoff, ChronoUnit.MILLIS).toEpochMilli();     // Catch: Throwable -> L18
        File[] files = this.mDiscreteAccessDir.listFiles();     // Catch: Throwable -> L18
        if (files != null) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L7:
        if (files.length <= 0) goto L20;
        int r4 = files.length;     // Catch: Throwable -> L18
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L20;
        File f = files[r6];     // Catch: Throwable -> L18
        String fileName = f.getName();     // Catch: Throwable -> L18
        if (fileName.endsWith(DISCRETE_HISTORY_FILE_SUFFIX) == false) goto L17;
        long timestamp = Long.valueOf(fileName.substring(0, fileName.length() - DISCRETE_HISTORY_FILE_SUFFIX.length())).longValue();     // Catch: Throwable -> L18
        if (timestamp < beginTimeMillis) goto L17;
        DiscreteOps.m1811$$Nest$mreadFromFile(discreteOps, f, beginTimeMillis);     // Catch: Throwable -> L18
    L17:
        r6 = r6 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory() {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        this.mDiscreteOps = new DiscreteOps(0);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        clearOnDiskHistoryLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    void deleteDiscreteOpsDir() {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        this.mCachedOps = null;     // Catch: Throwable -> L8
        FileUtils.deleteContentsAndDir(this.mDiscreteAccessDir);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory(int uid, String packageName) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        DiscreteOps discreteOps = getAllDiscreteOps();     // Catch: Throwable -> L13
        clearHistory();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        DiscreteOps.m1807$$Nest$mclearHistory(discreteOps, uid, packageName);     // Catch: Throwable -> L11
        persistDiscreteOpsLocked(discreteOps);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void offsetHistory(long offset) {
        Object r0 = this.mOnDiskLock;
        monitor-enter(r0);
        Object r1 = this.mInMemoryLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        DiscreteOps discreteOps = getAllDiscreteOps();     // Catch: Throwable -> L13
        clearHistory();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        DiscreteOps.m1810$$Nest$moffsetHistory(discreteOps, offset);     // Catch: Throwable -> L11
        persistDiscreteOpsLocked(discreteOps);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void dump(PrintWriter pw, int uidFilter, String packageNameFilter, String attributionTagFilter, int filter, int dumpOp, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
        DiscreteOps discreteOps = getAllDiscreteOps();
        if (dumpOp != (-1)) goto L5;
        String[] opNamesFilter = null;
    L6:
        DiscreteOps.m1809$$Nest$mfilter(discreteOps, 0, Instant.now().toEpochMilli(), filter, uidFilter, packageNameFilter, opNamesFilter, attributionTagFilter, 31, new ArrayMap());
        pw.print(prefix);
        pw.print("Largest chain id: ");
        pw.print(this.mDiscreteOps.mLargestChainId);
        pw.println();
        DiscreteOps.m1808$$Nest$mdump(discreteOps, pw, sdf, date, prefix, nDiscreteOps);
        return;
    L5:
        opNamesFilter = new String[]{AppOpsManager.opToPublicName(dumpOp)};
        goto L6
    }

    private void clearOnDiskHistoryLocked() {
        this.mCachedOps = null;
        FileUtils.deleteContentsAndDir(this.mDiscreteAccessDir);
        createDiscreteAccessDir();
    }

    DiscreteOps getAllDiscreteOps() {
        DiscreteOps discreteOps = new DiscreteOps(0);
        Object r2 = this.mOnDiskLock;
        monitor-enter(r2);
        Object r3 = this.mInMemoryLock;     // Catch: Throwable -> L11
        monitor-enter(r3);     // Catch: Throwable -> L11
        discreteOps.merge(this.mDiscreteOps);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
    L9:
        if (this.mCachedOps != null) goto L13;
        this.mCachedOps = new DiscreteOps(0);     // Catch: Throwable -> L11
        readDiscreteOpsFromDisk(this.mCachedOps);     // Catch: Throwable -> L11
    L13:
        discreteOps.merge(this.mCachedOps);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return discreteOps;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void createDiscreteAccessDir() {
        if (this.mDiscreteAccessDir.exists() == false) goto L5;
        return;
    L5:
        if (this.mDiscreteAccessDir.mkdirs() == true) goto L7;
        Slog.e(TAG, "Failed to create DiscreteRegistry directory");
    L7:
        FileUtils.setPermissions(this.mDiscreteAccessDir.getPath(), 505, -1, -1);
    }

    private void persistDiscreteOpsLocked(DiscreteOps discreteOps) {
        long currentTimeStamp = Instant.now().toEpochMilli();
        AtomicFile file = new AtomicFile(new File(this.mDiscreteAccessDir, currentTimeStamp + DISCRETE_HISTORY_FILE_SUFFIX));
        FileOutputStream stream = null;
        stream = file.startWrite();     // Catch: Throwable -> L5
        DiscreteOps.m1812$$Nest$mwriteToStream(discreteOps, stream);     // Catch: Throwable -> L5
        file.finishWrite(stream);     // Catch: Throwable -> L5
        return;
    L5:
        t = move-exception;
        Slog.e(TAG, "Error writing timeline state: " + t.getMessage() + " " + Arrays.toString(t.getStackTrace()));
        if (stream == null) goto L12;
        file.failWrite(stream);
        return;
    }

    private void deleteOldDiscreteHistoryFilesLocked() {
        File[] files = this.mDiscreteAccessDir.listFiles();
        if (files != null) goto L5;
        return;
    L5:
        if (files.length <= 0) goto L30;
        int r1 = files.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L31;
        File f = files[r3];
        String fileName = f.getName();
        if (fileName.endsWith(DISCRETE_HISTORY_FILE_SUFFIX) == false) goto L21;
        long timestamp = Long.valueOf(fileName.substring(0, fileName.length() - DISCRETE_HISTORY_FILE_SUFFIX.length())).longValue();     // Catch: Throwable -> L17
        if (Instant.now().minus(DiscreteOpsRegistry.sDiscreteHistoryCutoff, ChronoUnit.MILLIS).toEpochMilli() <= timestamp) goto L21;
        f.delete();     // Catch: Throwable -> L17
        Slog.e(TAG, "Deleting file " + fileName);     // Catch: Throwable -> L17
    L17:
        t = move-exception;
        Slog.e(TAG, "Error while cleaning timeline files: ", t);
    L21:
        r3 = r3 + 1;
        goto L8
    L31:
        return;
    }

    private void createDiscreteAccessDirLocked() {
        if (this.mDiscreteAccessDir.exists() == false) goto L5;
        return;
    L5:
        if (this.mDiscreteAccessDir.mkdirs() == true) goto L7;
        Slog.e(TAG, "Failed to create DiscreteRegistry directory");
    L7:
        FileUtils.setPermissions(this.mDiscreteAccessDir.getPath(), 505, -1, -1);
    }

    private static List<DiscreteOpEvent> stableListMerge(List<DiscreteOpEvent> a, List<DiscreteOpEvent> b) {
        int nA = a.size();
        int nB = b.size();
        int i = 0;
        int k = 0;
        List<DiscreteOpEvent> result = new ArrayList(nA + nB);
    L3:
        if (i < nA) goto L7;
        if (k < nB) goto L7;
        return result;
    L7:
        if (i == nA) goto L8;
        if (k == nB) goto L10;
        if (a.get(i).mNoteTime < b.get(k).mNoteTime) goto L13;
        int i2 = k + 1;
        result.add(b.get(k));
        k = i2;
        goto L3
    L13:
        int i3 = i + 1;
        result.add(a.get(i));
        i = i3;
        goto L3
    L10:
        int i4 = i + 1;
        result.add(a.get(i));
        i = i4;
        goto L3
    L8:
        int k2 = k + 1;
        result.add(b.get(k));
        k = k2;
        goto L3
    }

    private static List<DiscreteOpEvent> filterEventsList(List<DiscreteOpEvent> list, long beginTimeMillis, long endTimeMillis, int flagsFilter, int currentUid, String currentPackageName, int currentOp, String currentAttrTag, ArrayMap<Integer, AttributionChain> attributionChains) {
        int n = list.size();
        List<DiscreteOpEvent> result = new ArrayList(n);
        int i = 0;
    L3:
        if (i >= n) goto L22;
        DiscreteOpEvent event = list.get(i);
        AttributionChain chain = attributionChains.get(Integer.valueOf(event.mAttributionChainId));
        if (chain == null) goto L14;
        if (chain.isStart(currentPackageName, currentUid, currentAttrTag, currentOp, event) == true) goto L14;
        if (chain.isComplete() == false) goto L14;
        if (event.mAttributionChainId == (-1)) goto L14;
    L20:
        i = i + 1;
    L14:
        if ((event.mOpFlag & flagsFilter) == 0) goto L20;
        if ((event.mNoteTime + event.mNoteDuration) <= beginTimeMillis) goto L20;
        if (event.mNoteTime >= endTimeMillis) goto L20;
        result.add(event);
        goto L20
    L22:
        return result;
    }
}
