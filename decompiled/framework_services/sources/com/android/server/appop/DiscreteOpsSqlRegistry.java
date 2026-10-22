package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.LongSparseArray;
import android.util.Slog;
import com.android.server.ServiceThread;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DiscreteOpsSqlRegistry extends DiscreteOpsRegistry {
    private static final long DB_WRITE_INTERVAL = 0;
    private static final int DELETE_EXPIRED_ENTRIES = 2;
    private static final long EXPIRED_ENTRY_DELETION_INTERVAL = 0;
    private static final String TAG = "DiscreteOpsSqlRegistry";
    private static final int WRITE_DATABASE_CACHE_FULL = 3;
    private static final int WRITE_DATABASE_RECURRING = 1;
    private long mChainIdOffset;
    private final Context mContext;
    private final File mDatabaseFile;
    private final DiscreteOpCache mDiscreteOpCache;
    private final DiscreteOpsDbHelper mDiscreteOpsDbHelper;
    private final SqliteWriteHandler mSqliteWriteHandler;

    static class AttributionChain {
        List<DiscreteOp> mChain;
        Set<String> mExemptPkgs;
        DiscreteOp mLastVisibleEvent;
        DiscreteOp mStartEvent;

        /* JADX INFO: renamed from: -$$Nest$misStart, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1775$$Nest$misStart(AttributionChain r0, DiscreteOp r1) {
            return r0.isStart(r1);
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

        DiscreteOp getStart() {
            if (this.mChain.isEmpty() == false) goto L5;
        L8:
            return null;
        L5:
            if (isStart(this.mChain.get(0)) == false) goto L8;
            return this.mChain.get(0);
        }

        private boolean isEnd(DiscreteOp event) {
            if (event != null) goto L4;
        L6:
            return false;
        L4:
            if ((DiscreteOp.m1777$$Nest$fgetmAttributionFlags(event) & 1) == 0) goto L6;
            return true;
        }

        private boolean isStart(DiscreteOp event) {
            if (event != null) goto L4;
        L6:
            return false;
        L4:
            if ((DiscreteOp.m1777$$Nest$fgetmAttributionFlags(event) & 4) == 0) goto L6;
            return true;
        }

        DiscreteOp getLastVisible() {
            int i = this.mChain.size() - 1;
        L3:
            if (i <= 0) goto L8;
            DiscreteOp event = this.mChain.get(i);
            if (this.mExemptPkgs.contains(DiscreteOp.m1786$$Nest$fgetmPackageName(event)) == false) goto L6;
            i = i - 1;
            goto L3
        L6:
            return event;
        L8:
            return null;
        }

        void addEvent(DiscreteOp opEvent) {
            DiscreteOp matchingItem = null;
            int i = 0;
        L4:
            if (i >= this.mChain.size()) goto L9;
            DiscreteOp item = this.mChain.get(i);
            if (item.equalsExceptDuration(opEvent) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            matchingItem = item;
        L9:
            if (matchingItem == null) goto L18;
            if (DiscreteOp.m1783$$Nest$fgetmDuration(matchingItem) != DiscreteOp.m1783$$Nest$fgetmDuration(opEvent)) goto L13;
            return;
        L13:
            if (DiscreteOp.m1783$$Nest$fgetmDuration(matchingItem) > DiscreteOp.m1783$$Nest$fgetmDuration(opEvent)) goto L57;
            this.mChain.remove(matchingItem);
            goto L18
        L57:
            return;
        L18:
            if (this.mChain.isEmpty() == false) goto L20;
        L41:
            this.mChain.add(opEvent);
        L42:
            DiscreteOp r2 = null;
            if (isComplete() == false) goto L45;
            DiscreteOp r1 = getStart();
        L46:
            this.mStartEvent = r1;
            if (isComplete() == false) goto L49;
            r2 = getLastVisible();
        L49:
            this.mLastVisibleEvent = r2;
            return;
        L45:
            r1 = null;
            goto L46
        L20:
            if (isEnd(opEvent) == true) goto L41;
            if (isStart(opEvent) == false) goto L25;
            this.mChain.add(0, opEvent);
            goto L42
        L25:
            int i2 = 0;
        L27:
            if (i2 >= this.mChain.size()) goto L42;
            DiscreteOp currEvent = this.mChain.get(i2);
            if (isStart(currEvent) == true) goto L33;
            if (DiscreteOp.m1776$$Nest$fgetmAccessTime(currEvent) <= DiscreteOp.m1776$$Nest$fgetmAccessTime(opEvent)) goto L33;
        L36:
            this.mChain.add(i2, opEvent);
        L33:
            if (i2 != (this.mChain.size() - 1)) goto L38;
            if (isEnd(currEvent) == true) goto L36;
        L38:
            if (i2 == (this.mChain.size() - 1)) goto L39;
            i2 = i2 + 1;
            goto L27
        L39:
            this.mChain.add(opEvent);
            goto L42
        }
    }

    static class DiscreteOp {
        private final long mAccessTime;
        private final int mAttributionFlags;
        private final String mAttributionTag;
        private final long mChainId;
        private final String mDeviceId;
        private final long mDiscretizedAccessTime;
        private final long mDiscretizedDuration;
        private final long mDuration;
        private final int mOpCode;
        private final int mOpFlags;
        private final String mPackageName;
        private final int mUid;
        private final int mUidState;

        /* JADX INFO: renamed from: -$$Nest$fgetmAccessTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1776$$Nest$fgetmAccessTime(DiscreteOp r2) {
            return r2.mAccessTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAttributionFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1777$$Nest$fgetmAttributionFlags(DiscreteOp r0) {
            return r0.mAttributionFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAttributionTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1778$$Nest$fgetmAttributionTag(DiscreteOp r0) {
            return r0.mAttributionTag;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmChainId, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1779$$Nest$fgetmChainId(DiscreteOp r2) {
            return r2.mChainId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1780$$Nest$fgetmDeviceId(DiscreteOp r0) {
            return r0.mDeviceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDiscretizedAccessTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1781$$Nest$fgetmDiscretizedAccessTime(DiscreteOp r2) {
            return r2.mDiscretizedAccessTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDiscretizedDuration, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1782$$Nest$fgetmDiscretizedDuration(DiscreteOp r2) {
            return r2.mDiscretizedDuration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDuration, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1783$$Nest$fgetmDuration(DiscreteOp r2) {
            return r2.mDuration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpCode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1784$$Nest$fgetmOpCode(DiscreteOp r0) {
            return r0.mOpCode;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOpFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1785$$Nest$fgetmOpFlags(DiscreteOp r0) {
            return r0.mOpFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1786$$Nest$fgetmPackageName(DiscreteOp r0) {
            return r0.mPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1787$$Nest$fgetmUid(DiscreteOp r0) {
            return r0.mUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUidState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1788$$Nest$fgetmUidState(DiscreteOp r0) {
            return r0.mUidState;
        }

        DiscreteOp(int uid, String packageName, String attributionTag, String deviceId, int opCode, int mOpFlags, int mAttributionFlags, int uidState, long chainId, long accessTime, long duration) {
            this.mUid = uid;
            this.mPackageName = packageName.intern();
            this.mAttributionTag = attributionTag;
            this.mDeviceId = deviceId;
            this.mOpCode = opCode;
            this.mOpFlags = mOpFlags;
            this.mAttributionFlags = mAttributionFlags;
            this.mUidState = uidState;
            this.mChainId = chainId;
            this.mAccessTime = accessTime;
            this.mDiscretizedAccessTime = DiscreteOpsRegistry.discretizeTimeStamp(accessTime);
            this.mDuration = duration;
            this.mDiscretizedDuration = DiscreteOpsRegistry.discretizeDuration(duration);
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof DiscreteOp) == false) goto L42;
            DiscreteOp that = (DiscreteOp) o;
            if (this.mUid == that.mUid) goto L11;
            return false;
        L11:
            if (this.mOpCode == that.mOpCode) goto L14;
            return false;
        L14:
            if (this.mOpFlags == that.mOpFlags) goto L17;
            return false;
        L17:
            if (this.mAttributionFlags == that.mAttributionFlags) goto L20;
            return false;
        L20:
            if (this.mUidState == that.mUidState) goto L23;
            return false;
        L23:
            if (this.mChainId == that.mChainId) goto L26;
            return false;
        L26:
            if (Objects.equals(this.mPackageName, that.mPackageName) == true) goto L29;
            return false;
        L29:
            if (Objects.equals(this.mAttributionTag, that.mAttributionTag) == true) goto L32;
            return false;
        L32:
            if (Objects.equals(this.mDeviceId, that.mDeviceId) == true) goto L35;
            return false;
        L35:
            if (this.mDiscretizedAccessTime == that.mDiscretizedAccessTime) goto L38;
            return false;
        L38:
            if (this.mDiscretizedDuration != that.mDiscretizedDuration) goto L41;
            return true;
        L41:
            return false;
        L42:
            return false;
        }

        public int hashCode() {
            int result = this.mUid;
            int r1 = result * 31;
            int r3 = 0;
            if (this.mPackageName == null) goto L5;
            int r2 = this.mPackageName.hashCode();
        L6:
            int result2 = r1 + r2;
            int result3 = result2 * 31;
            if (this.mAttributionTag == null) goto L9;
            int r4 = this.mAttributionTag.hashCode();
        L10:
            int result4 = (result3 + r4) * 31;
            if (this.mDeviceId == null) goto L14;
            r3 = this.mDeviceId.hashCode();
        L14:
            return ((((((((((((((result4 + r3) * 31) + this.mOpCode) * 31) + this.mOpFlags) * 31) + this.mAttributionFlags) * 31) + this.mUidState) * 31) + Objects.hash(new Object[]{Long.valueOf(this.mChainId)})) * 31) + Objects.hash(new Object[]{Long.valueOf(this.mDiscretizedAccessTime)})) * 31) + Objects.hash(new Object[]{Long.valueOf(this.mDiscretizedDuration)});
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public boolean equalsExceptDuration(DiscreteOp that) {
            if (this.mUid == that.mUid) goto L6;
            return false;
        L6:
            if (this.mOpCode == that.mOpCode) goto L9;
            return false;
        L9:
            if (this.mOpFlags == that.mOpFlags) goto L12;
            return false;
        L12:
            if (this.mAttributionFlags == that.mAttributionFlags) goto L15;
            return false;
        L15:
            if (this.mUidState == that.mUidState) goto L18;
            return false;
        L18:
            if (this.mChainId == that.mChainId) goto L21;
            return false;
        L21:
            if (Objects.equals(this.mPackageName, that.mPackageName) == true) goto L24;
            return false;
        L24:
            if (Objects.equals(this.mAttributionTag, that.mAttributionTag) == true) goto L27;
            return false;
        L27:
            if (Objects.equals(this.mDeviceId, that.mDeviceId) == true) goto L30;
            return false;
        L30:
            if (this.mAccessTime != that.mAccessTime) goto L33;
            return true;
        L33:
            return false;
        }

        public String toString() {
            return "DiscreteOp{uid=" + this.mUid + ", packageName='" + this.mPackageName + "', attributionTag='" + this.mAttributionTag + "', deviceId='" + this.mDeviceId + "', opCode=" + AppOpsManager.opToName(this.mOpCode) + ", opFlag=" + AppOpsManager.flagsToString(this.mOpFlags) + ", attributionFlag=" + this.mAttributionFlags + ", uidState=" + AppOpsManager.getUidStateName(this.mUidState) + ", chainId=" + this.mChainId + ", accessTime=" + this.mAccessTime + ", mDiscretizedAccessTime=" + this.mDiscretizedAccessTime + ", duration=" + this.mDuration + ", mDiscretizedDuration=" + this.mDiscretizedDuration + '}';
        }

        public int getUid() {
            return this.mUid;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public String getAttributionTag() {
            return this.mAttributionTag;
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }

        public int getOpCode() {
            return this.mOpCode;
        }

        public int getOpFlags() {
            return this.mOpFlags;
        }

        public int getAttributionFlags() {
            return this.mAttributionFlags;
        }

        public int getUidState() {
            return this.mUidState;
        }

        public long getChainId() {
            return this.mChainId;
        }

        public long getAccessTime() {
            return this.mAccessTime;
        }

        public long getDuration() {
            return this.mDuration;
        }
    }

    class DiscreteOpCache {
        private static final String TAG = "DiscreteOpCache";
        private final ArraySet<DiscreteOp> mCache;
        private final int mCapacity;
        final /* synthetic */ DiscreteOpsSqlRegistry this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArraySet m1789$$Nest$fgetmCache(DiscreteOpCache r0) {
            return r0.mCache;
        }

        /* JADX INFO: renamed from: -$$Nest$mevictOldAppOpEvents, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m1790$$Nest$mevictOldAppOpEvents(DiscreteOpCache r0) {
            return r0.evictOldAppOpEvents();
        }

        DiscreteOpCache(DiscreteOpsSqlRegistry this$0, int capacity) {
            this.this$0 = this$0;
            this.mCapacity = capacity;
            this.mCache = new ArraySet();
        }

        public void add(DiscreteOp opEvent) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mCache.contains(opEvent) == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            this.mCache.add(opEvent);     // Catch: Throwable -> L7
            if (this.mCache.size() < this.mCapacity) goto L12;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessage(3);     // Catch: Throwable -> L7
        L12:
            monitor-exit(this);     // Catch: Throwable -> L7
        }

        private List<DiscreteOp> evictOldAppOpEvents() {
            monitor-enter(this);
            List<DiscreteOp> evictedEvents = new ArrayList();     // Catch: Throwable -> L9
            Set<DiscreteOp> snapshot = new ArraySet(this.mCache);     // Catch: Throwable -> L9
            long evictionTimestamp = System.currentTimeMillis() - DiscreteOpsRegistry.sDiscreteHistoryQuantization;     // Catch: Throwable -> L9
            long evictionTimestamp2 = DiscreteOpsRegistry.discretizeTimeStamp(evictionTimestamp);     // Catch: Throwable -> L9
            Iterator<DiscreteOp> r2 = snapshot.iterator();     // Catch: Throwable -> L9
        L5:
            if (r2.hasNext() == false) goto L12;
            DiscreteOp opEvent = r2.next();     // Catch: Throwable -> L9
            if (DiscreteOp.m1781$$Nest$fgetmDiscretizedAccessTime(opEvent) > evictionTimestamp2) goto L5;
            evictedEvents.add(opEvent);     // Catch: Throwable -> L9
            this.mCache.remove(opEvent);     // Catch: Throwable -> L9
            goto L5
        L12:
            monitor-exit(this);     // Catch: Throwable -> L9
            return evictedEvents;
        L9:
            th = move-exception;
            throw th;
        }

        public List<DiscreteOp> evictAllAppOpEvents() {
            monitor-enter(this);
            List<DiscreteOp> cachedOps = new ArrayList(this.mCache.size());     // Catch: Throwable -> L7
            if (this.mCache.isEmpty() == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return cachedOps;
        L9:
            cachedOps.addAll(this.mCache);     // Catch: Throwable -> L7
            this.mCache.clear();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return cachedOps;
        L7:
            th = move-exception;
            throw th;
        }

        public List<DiscreteOp> evictAppOpEvents(IntArray ops) {
            monitor-enter(this);
            List<DiscreteOp> evictedOps = new ArrayList();     // Catch: Throwable -> L7
            if (this.mCache.isEmpty() == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return evictedOps;
        L9:
            Iterator<DiscreteOp> r1 = this.mCache.iterator();     // Catch: Throwable -> L7
        L11:
            if (r1.hasNext() == false) goto L16;
            DiscreteOp discreteOp = r1.next();     // Catch: Throwable -> L7
            if (ops.contains(discreteOp.getOpCode()) == false) goto L11;
            evictedOps.add(discreteOp);     // Catch: Throwable -> L7
            goto L11
        L16:
            final ArraySet<DiscreteOp> r2 = this.mCache;     // Catch: Throwable -> L7
            r2.getClass();     // Catch: Throwable -> L7
            evictedOps.forEach(new DiscreteOpsSqlRegistry$DiscreteOpCache$$ExternalSyntheticLambda0(r2));     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return evictedOps;
        L7:
            th = move-exception;
            throw th;
        }

        int size() {
            return this.mCache.size();
        }

        int capacity() {
            return this.mCapacity;
        }

        public void clear() {
            monitor-enter(this);
            this.mCache.clear();     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void offsetTimestamp(long offsetMillis) {
            monitor-enter(this);
            List<DiscreteOp> cachedOps = new ArrayList(this.mCache);     // Catch: Throwable -> L8
            this.mCache.clear();     // Catch: Throwable -> L8
            Iterator<DiscreteOp> r2 = cachedOps.iterator();     // Catch: Throwable -> L8
        L6:
            if (r2.hasNext() == false) goto L10;
            DiscreteOp discreteOp = r2.next();     // Catch: Throwable -> L8
            add(new DiscreteOp(discreteOp.getUid(), DiscreteOp.m1786$$Nest$fgetmPackageName(discreteOp), discreteOp.getAttributionTag(), discreteOp.getDeviceId(), DiscreteOp.m1784$$Nest$fgetmOpCode(discreteOp), DiscreteOp.m1785$$Nest$fgetmOpFlags(discreteOp), discreteOp.getAttributionFlags(), discreteOp.getUidState(), discreteOp.getChainId(), DiscreteOp.m1776$$Nest$fgetmAccessTime(discreteOp) - offsetMillis, discreteOp.getDuration()));     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void clear(int uid, String packageName) {
            monitor-enter(this);
            Set<DiscreteOp> snapshot = new ArraySet(this.mCache);     // Catch: Throwable -> L11
            Iterator<DiscreteOp> r1 = snapshot.iterator();     // Catch: Throwable -> L11
        L5:
            if (r1.hasNext() == false) goto L14;
            DiscreteOp currentEvent = r1.next();     // Catch: Throwable -> L11
            if (Objects.equals(packageName, DiscreteOp.m1786$$Nest$fgetmPackageName(currentEvent)) == false) goto L5;
            if (uid != currentEvent.getUid()) goto L5;
            this.mCache.remove(currentEvent);     // Catch: Throwable -> L11
            goto L5
        L14:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    class SqliteWriteHandler extends Handler {
        final /* synthetic */ DiscreteOpsSqlRegistry this$0;

        SqliteWriteHandler(DiscreteOpsSqlRegistry this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L52;
                case 2: goto L29;
                case 3: goto L55;
                default: goto L5;
            };
        L29:
            long cutOffTimeStamp = System.currentTimeMillis() - DiscreteOpsRegistry.sDiscreteHistoryCutoff;
            DiscreteOpsSqlRegistry.m1771$$Nest$fgetmDiscreteOpsDbHelper(this.this$0).execSQL("DELETE FROM app_op_accesses WHERE access_time < ?", new Object[]{Long.valueOf(cutOffTimeStamp)});
            return;
        L55:
            DiscreteOpCache r0 = DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0);     // Catch: Throwable -> L21
            monitor-enter(r0);     // Catch: Throwable -> L21
            List<DiscreteOp> evictedEvents = DiscreteOpCache.m1790$$Nest$mevictOldAppOpEvents(DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0));     // Catch: Throwable -> L13
            if (evictedEvents.isEmpty() == true) goto L11;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            DiscreteOpsSqlRegistry.m1771$$Nest$fgetmDiscreteOpsDbHelper(this.this$0).insertDiscreteOps(evictedEvents);     // Catch: Throwable -> L21
            if (DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).hasMessages(1) == true) goto L57;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(1, DiscreteOpsSqlRegistry.m1773$$Nest$sfgetDB_WRITE_INTERVAL());
            return;
        L57:
            return;
        L11:
            if (DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0).size() < DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0).capacity()) goto L15;
            evictedEvents.addAll(DiscreteOpCache.m1789$$Nest$fgetmCache(DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0)));     // Catch: Throwable -> L13
            DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0).clear();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            if (DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).hasMessages(1) == true) goto L28;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(1, DiscreteOpsSqlRegistry.m1773$$Nest$sfgetDB_WRITE_INTERVAL());
        L28:
            throw th;
        L5:
            throw new IllegalStateException("Unexpected value: " + msg.what);
        L52:
            DiscreteOpCache r2 = DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0);     // Catch: Throwable -> L41
            monitor-enter(r2);     // Catch: Throwable -> L41
            List<DiscreteOp> evictedEvents2 = DiscreteOpCache.m1790$$Nest$mevictOldAppOpEvents(DiscreteOpsSqlRegistry.m1770$$Nest$fgetmDiscreteOpCache(this.this$0));     // Catch: Throwable -> L43
            monitor-exit(r2);     // Catch: Throwable -> L43
            DiscreteOpsSqlRegistry.m1771$$Nest$fgetmDiscreteOpsDbHelper(this.this$0).insertDiscreteOps(evictedEvents2);     // Catch: Throwable -> L41
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(1, DiscreteOpsSqlRegistry.m1773$$Nest$sfgetDB_WRITE_INTERVAL());
            if (DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).hasMessages(2) == true) goto L59;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(2, DiscreteOpsSqlRegistry.m1774$$Nest$sfgetEXPIRED_ENTRY_DELETION_INTERVAL());
            return;
        L59:
            return;
        L43:
            th = move-exception;
            throw th;     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(1, DiscreteOpsSqlRegistry.m1773$$Nest$sfgetDB_WRITE_INTERVAL());
            if (DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).hasMessages(2) == true) goto L49;
            DiscreteOpsSqlRegistry.m1772$$Nest$fgetmSqliteWriteHandler(this.this$0).sendEmptyMessageDelayed(2, DiscreteOpsSqlRegistry.m1774$$Nest$sfgetEXPIRED_ENTRY_DELETION_INTERVAL());
        L49:
            throw th;
        }

        void removeAllPendingMessages() {
            removeMessages(1);
            removeMessages(2);
            removeMessages(3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiscreteOpCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ DiscreteOpCache m1770$$Nest$fgetmDiscreteOpCache(DiscreteOpsSqlRegistry r0) {
        return r0.mDiscreteOpCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiscreteOpsDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ DiscreteOpsDbHelper m1771$$Nest$fgetmDiscreteOpsDbHelper(DiscreteOpsSqlRegistry r0) {
        return r0.mDiscreteOpsDbHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSqliteWriteHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ SqliteWriteHandler m1772$$Nest$fgetmSqliteWriteHandler(DiscreteOpsSqlRegistry r0) {
        return r0.mSqliteWriteHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDB_WRITE_INTERVAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1773$$Nest$sfgetDB_WRITE_INTERVAL() {
        return DB_WRITE_INTERVAL;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEXPIRED_ENTRY_DELETION_INTERVAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1774$$Nest$sfgetEXPIRED_ENTRY_DELETION_INTERVAL() {
        return EXPIRED_ENTRY_DELETION_INTERVAL;
    }

    static {
        DB_WRITE_INTERVAL = Duration.ofMinutes(10).toMillis();
        EXPIRED_ENTRY_DELETION_INTERVAL = Duration.ofHours(6).toMillis();
    }

    DiscreteOpsSqlRegistry(Context context) {
        this(context, DiscreteOpsDbHelper.getDatabaseFile());
    }

    DiscreteOpsSqlRegistry(Context context, File databaseFile) {
        this.mDiscreteOpCache = new DiscreteOpCache(this, 512);
        ServiceThread thread = new ServiceThread(TAG, 10, true);
        thread.start();
        this.mContext = context;
        this.mDatabaseFile = databaseFile;
        this.mSqliteWriteHandler = new SqliteWriteHandler(this, thread.getLooper());
        this.mDiscreteOpsDbHelper = new DiscreteOpsDbHelper(context, databaseFile);
        this.mChainIdOffset = this.mDiscreteOpsDbHelper.getLargestAttributionChainId();
        this.mSqliteWriteHandler.sendEmptyMessageDelayed(1, DB_WRITE_INTERVAL);
        this.mSqliteWriteHandler.sendEmptyMessageDelayed(2, EXPIRED_ENTRY_DELETION_INTERVAL);
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void recordDiscreteAccess(int uid, String packageName, String deviceId, int op, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
        if (DiscreteOpsRegistry.isDiscreteOp(op, flags) == true) goto L5;
        return;
    L5:
        long offsetChainId = attributionChainId;
        if (attributionChainId == (-1)) goto L11;
        long offsetChainId2 = ((long) attributionChainId) + this.mChainIdOffset;
        if (attributionChainId != Integer.MAX_VALUE) goto L10;
        this.mChainIdOffset = offsetChainId2;
    L10:
        long offsetChainId3 = offsetChainId2;
    L12:
        DiscreteOp discreteOpEvent = new DiscreteOp(uid, packageName, attributionTag, deviceId, op, flags, attributionFlags, uidState, offsetChainId3, accessTime, accessDuration);
        this.mDiscreteOpCache.add(discreteOpEvent);
        return;
    L11:
        offsetChainId3 = offsetChainId;
        goto L12
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void shutdown() {
        this.mSqliteWriteHandler.removeAllPendingMessages();
        this.mDiscreteOpsDbHelper.insertDiscreteOps(this.mDiscreteOpCache.evictAllAppOpEvents());
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void writeAndClearOldAccessHistory() {
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory() {
        this.mDiscreteOpCache.clear();
        this.mDiscreteOpsDbHelper.execSQL("DELETE FROM app_op_accesses");
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory(int uid, String packageName) {
        this.mDiscreteOpCache.clear(uid, packageName);
        this.mDiscreteOpsDbHelper.execSQL("DELETE FROM app_op_accesses WHERE uid = ? AND package_name = ?", new Object[]{Integer.valueOf(uid), packageName});
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void offsetHistory(long offset) {
        this.mDiscreteOpCache.offsetTimestamp(offset);
        this.mDiscreteOpsDbHelper.execSQL("UPDATE app_op_accesses SET access_time = ACCESS_TIME - ?", new Object[]{Long.valueOf(offset)});
    }

    private IntArray getAppOpCodes(int filter, String[] opNamesFilter) {
        if ((filter & 8) == 0) goto L14;
        IntArray opCodes = new IntArray(opNamesFilter.length);
        int i = 0;
    L6:
        if (i >= opNamesFilter.length) goto L13;
        int op = AppOpsManager.strOpToOp(opNamesFilter[i]);     // Catch: IllegalArgumentException -> L9
        opCodes.add(op);
    L11:
        i = i + 1;
    L10:
        Slog.w(TAG, "Appop `" + opNamesFilter[i] + "` is not recognized.");
        goto L11
    L13:
        return opCodes;
    L14:
        return null;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void addFilteredDiscreteOpsToHistoricalOps(AppOpsManager.HistoricalOps result, long beginTimeMillis, long endTimeMillis, int filter, int uidFilter, String packageNameFilter, String[] opNamesFilter, String attributionTagFilter, int opFlagsFilter, Set<String> attributionExemptPkgs) {
        IntArray opCodes = getAppOpCodes(filter, opNamesFilter);
        if (opCodes == null) goto L5;
        this.mDiscreteOpsDbHelper.insertDiscreteOps(this.mDiscreteOpCache.evictAppOpEvents(opCodes));
    L6:
        if (attributionExemptPkgs == null) goto L8;
        boolean r4 = true;
    L9:
        boolean assembleChains = r4;
        long beginTimeMillis2 = Math.max(beginTimeMillis, Instant.now().minus(DiscreteOpsRegistry.sDiscreteHistoryCutoff, ChronoUnit.MILLIS).toEpochMilli());
        List<DiscreteOp> discreteOps = this.mDiscreteOpsDbHelper.getDiscreteOps(filter, uidFilter, packageNameFilter, attributionTagFilter, opCodes, opFlagsFilter, beginTimeMillis2, endTimeMillis, -1, null, false);
        LongSparseArray<AttributionChain> attributionChains = null;
        if (assembleChains == false) goto L12;
        attributionChains = createAttributionChains(discreteOps, attributionExemptPkgs);
    L12:
        int nEvents = discreteOps.size();
        int j = 0;
    L13:
        if (j >= nEvents) goto L30;
        DiscreteOp event = discreteOps.get(j);
        AppOpsManager.OpEventProxyInfo proxy = null;
        if (assembleChains == false) goto L28;
        if (DiscreteOp.m1779$$Nest$fgetmChainId(event) == (-1)) goto L28;
        AttributionChain chain = attributionChains.get(DiscreteOp.m1779$$Nest$fgetmChainId(event));
        if (chain == null) goto L28;
        if (chain.isComplete() == false) goto L28;
        if (AttributionChain.m1775$$Nest$misStart(chain, event) == false) goto L28;
        if (chain.mLastVisibleEvent == null) goto L28;
        DiscreteOp proxyEvent = chain.mLastVisibleEvent;
        proxy = new AppOpsManager.OpEventProxyInfo(DiscreteOp.m1787$$Nest$fgetmUid(proxyEvent), DiscreteOp.m1786$$Nest$fgetmPackageName(proxyEvent), DiscreteOp.m1778$$Nest$fgetmAttributionTag(proxyEvent));
    L28:
        int r18 = DiscreteOp.m1784$$Nest$fgetmOpCode(event);
        int r19 = DiscreteOp.m1787$$Nest$fgetmUid(event);
        String r20 = DiscreteOp.m1786$$Nest$fgetmPackageName(event);
        String r21 = DiscreteOp.m1778$$Nest$fgetmAttributionTag(event);
        int r22 = DiscreteOp.m1788$$Nest$fgetmUidState(event);
        int r23 = DiscreteOp.m1785$$Nest$fgetmOpFlags(event);
        long r24 = DiscreteOp.m1781$$Nest$fgetmDiscretizedAccessTime(event);
        long r26 = DiscreteOp.m1782$$Nest$fgetmDiscretizedDuration(event);
        result.addDiscreteAccess(r18, r19, r20, r21, r22, r23, r24, r26, proxy);
        j = j + 1;
        goto L13
    L30:
        return;
    L8:
        r4 = false;
        goto L9
    L5:
        this.mDiscreteOpsDbHelper.insertDiscreteOps(this.mDiscreteOpCache.evictAllAppOpEvents());
        goto L6
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void dump(PrintWriter pw, int uidFilter, String packageNameFilter, String attributionTagFilter, int filter, int dumpOp, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
        this.mDiscreteOpsDbHelper.insertDiscreteOps(this.mDiscreteOpCache.evictAllAppOpEvents());
        IntArray opCodes = new IntArray();
        if (dumpOp == (-1)) goto L5;
        opCodes.add(dumpOp);
    L5:
        List<DiscreteOp> discreteOps = this.mDiscreteOpsDbHelper.getDiscreteOps(filter, uidFilter, packageNameFilter, attributionTagFilter, opCodes, 0, -1, -1, nDiscreteOps, "access_time", false);
        pw.print(prefix);
        pw.print("Largest chain id: ");
        pw.print(this.mDiscreteOpsDbHelper.getLargestAttributionChainId());
        pw.println();
        pw.println("UID|PACKAGE_NAME|DEVICE_ID|OP_NAME|ATTRIBUTION_TAG|UID_STATE|OP_FLAGS|ATTR_FLAGS|CHAIN_ID|ACCESS_TIME|DURATION");
        int discreteOpsCount = discreteOps.size();
        int i = 0;
    L6:
        if (i >= discreteOpsCount) goto L8;
        DiscreteOp event = discreteOps.get(i);
        date.setTime(DiscreteOp.m1776$$Nest$fgetmAccessTime(event));
        pw.println(DiscreteOp.m1787$$Nest$fgetmUid(event) + "|" + DiscreteOp.m1786$$Nest$fgetmPackageName(event) + "|" + DiscreteOp.m1780$$Nest$fgetmDeviceId(event) + "|" + AppOpsManager.opToName(DiscreteOp.m1784$$Nest$fgetmOpCode(event)) + "|" + DiscreteOp.m1778$$Nest$fgetmAttributionTag(event) + "|" + AppOpsManager.getUidStateName(DiscreteOp.m1788$$Nest$fgetmUidState(event)) + "|" + AppOpsManager.flagsToString(DiscreteOp.m1785$$Nest$fgetmOpFlags(event)) + "|" + DiscreteOp.m1777$$Nest$fgetmAttributionFlags(event) + "|" + DiscreteOp.m1779$$Nest$fgetmChainId(event) + "|" + sdf.format(date) + "|" + DiscreteOp.m1783$$Nest$fgetmDuration(event));
        i = i + 1;
        goto L6
    L8:
        pw.println();
    }

    void migrateXmlData(List<DiscreteOp> opEvents, int chainIdOffset) {
        this.mChainIdOffset = chainIdOffset;
        this.mDiscreteOpsDbHelper.insertDiscreteOps(opEvents);
    }

    LongSparseArray<AttributionChain> createAttributionChains(List<DiscreteOp> discreteOps, Set<String> attributionExemptPkgs) {
        LongSparseArray<AttributionChain> chains = new LongSparseArray();
        int count = discreteOps.size();
        int i = 0;
    L3:
        if (i >= count) goto L15;
        DiscreteOp opEvent = discreteOps.get(i);
        if (DiscreteOp.m1779$$Nest$fgetmChainId(opEvent) == (-1)) goto L13;
        if ((DiscreteOp.m1777$$Nest$fgetmAttributionFlags(opEvent) & 8) == 0) goto L13;
        AttributionChain chain = chains.get(DiscreteOp.m1779$$Nest$fgetmChainId(opEvent));
        if (chain != null) goto L12;
        chain = new AttributionChain(attributionExemptPkgs);
        chains.put(DiscreteOp.m1779$$Nest$fgetmChainId(opEvent), chain);
    L12:
        chain.addEvent(opEvent);
    L13:
        i = i + 1;
        goto L3
    L15:
        return chains;
    }

    void recordDiscreteAccess(DiscreteOp discreteOpEvent) {
        this.mDiscreteOpCache.add(discreteOpEvent);
    }

    List<DiscreteOp> getCachedDiscreteOps() {
        return new ArrayList(DiscreteOpCache.m1789$$Nest$fgetmCache(this.mDiscreteOpCache));
    }

    List<DiscreteOp> getAllDiscreteOps() {
        List<DiscreteOp> ops = new ArrayList(DiscreteOpCache.m1789$$Nest$fgetmCache(this.mDiscreteOpCache));
        ops.addAll(this.mDiscreteOpsDbHelper.getAllDiscreteOps("SELECT DISTINCT uid,package_name,device_id,op_code,attribution_tag,access_time,access_duration,uid_state,op_flags,attribution_flags,chain_id FROM app_op_accesses"));
        return ops;
    }

    long getLargestAttributionChainId() {
        return this.mDiscreteOpsDbHelper.getLargestAttributionChainId();
    }

    void deleteDatabase() {
        this.mDiscreteOpsDbHelper.close();
        this.mContext.deleteDatabase(this.mDatabaseFile.getName());
    }
}
