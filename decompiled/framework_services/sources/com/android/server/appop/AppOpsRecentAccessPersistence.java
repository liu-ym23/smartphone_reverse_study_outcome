package com.android.server.appop;

import android.app.AppOpsManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
final class AppOpsRecentAccessPersistence {
    private static final String ATTR_ACCESS_DURATION = "d";
    private static final String ATTR_ACCESS_TIME = "t";
    private static final String ATTR_DEVICE_ID = "dv";
    private static final String ATTR_ID = "id";
    private static final String ATTR_NAME = "n";
    private static final String ATTR_PROXY_ATTRIBUTION_TAG = "pc";
    private static final String ATTR_PROXY_DEVICE_ID = "pdv";
    private static final String ATTR_PROXY_PACKAGE = "pp";
    private static final String ATTR_PROXY_UID = "pu";
    private static final String ATTR_REJECT_TIME = "r";
    private static final int CURRENT_VERSION = 1;
    static final String TAG = "AppOpsRecentAccessPersistence";
    private static final String TAG_APP_OPS = "app-ops";
    private static final String TAG_ATTRIBUTION_OP = "st";
    private static final String TAG_OP = "op";
    private static final String TAG_PACKAGE = "pkg";
    private static final String TAG_UID = "uid";
    final AppOpsService mAppOpsService;
    final AtomicFile mRecentAccessesFile;

    AppOpsRecentAccessPersistence(AtomicFile recentAccessesFile, AppOpsService appOpsService) {
        this.mRecentAccessesFile = recentAccessesFile;
        this.mAppOpsService = appOpsService;
    }

    void readRecentAccesses(SparseArray<AppOpsService.UidState> uidStates) {
        AtomicFile r0 = this.mRecentAccessesFile;
        monitor-enter(r0);
        FileInputStream stream = this.mRecentAccessesFile.openRead();     // Catch: Throwable -> L42 FileNotFoundException -> L65
        goto L66
    L72:
        uidStates.clear();     // Catch: Throwable -> L42
        this.mAppOpsService.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L42
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L21 Throwable -> L23
    L8:
        int type = parser.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type != 2) goto L49;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L21 Throwable -> L23
    L14:
        int type2 = parser.next();     // Catch: Throwable -> L21 Throwable -> L23
        if (type2 == 1) goto L39;
        if (type2 == 3) goto L19;
    L26:
        if (type2 == 3) goto L14;
        if (type2 == 4) goto L14;
        String tagName = parser.getName();     // Catch: Throwable -> L21 Throwable -> L23
        if (tagName.equals("pkg") == true) goto L32;
        if (tagName.equals("uid") == true) goto L35;
        Slog.w(TAG, "Unknown element under <app-ops>: " + parser.getName());     // Catch: Throwable -> L21 Throwable -> L23
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 Throwable -> L23
        goto L14
    L35:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 Throwable -> L23
        goto L14
    L32:
        readPackage(parser, uidStates);     // Catch: Throwable -> L21 Throwable -> L23
        goto L14
    L19:
        if (parser.getDepth() > outerDepth) goto L26;
    L39:
        if (1 != 0) goto L44;
        uidStates.clear();     // Catch: Throwable -> L42
        this.mAppOpsService.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L42
    L44:
        stream.close();     // Catch: Throwable -> L42 IOException -> L46
    L71:
        goto L56
    L49:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L21 Throwable -> L23 Throwable -> L23 Throwable -> L23 Throwable -> L23 Throwable -> L23 Throwable -> L23
    L23:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L54;
        uidStates.clear();     // Catch: Throwable -> L42
        this.mAppOpsService.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L42
    L54:
        stream.close();     // Catch: Throwable -> L42 IOException -> L46
    L21:
        th = move-exception;
        if (0 != 0) goto L77;
        uidStates.clear();     // Catch: Throwable -> L42
        this.mAppOpsService.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L42
    L77:
        stream.close();     // Catch: Throwable -> L42 IOException -> L62
    L64:
        throw th;     // Catch: Throwable -> L42
    L56:
        monitor-exit(r0);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    L66:
        Slog.i(TAG, "No existing app ops " + this.mRecentAccessesFile.getBaseFile() + "; starting empty");     // Catch: Throwable -> L42
    }

    private void readPackage(TypedXmlPullParser parser, SparseArray<AppOpsService.UidState> uidStates) throws NumberFormatException, XmlPullParserException, IOException {
        String pkgName = parser.getAttributeValue(null, ATTR_NAME);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("uid") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readUid(parser, pkgName, uidStates);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readUid(TypedXmlPullParser parser, String pkgName, SparseArray<AppOpsService.UidState> uidStates) throws NumberFormatException, XmlPullParserException, IOException {
        int uid = parser.getAttributeInt(null, ATTR_NAME);
        AppOpsService r2 = this.mAppOpsService;
        r2.getClass();
        AppOpsService.UidState uidState = new AppOpsService.UidState(r2, uid);
        uidStates.put(uid, uidState);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(TAG_OP) == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readOp(parser, uidState, pkgName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readOp(TypedXmlPullParser parser, AppOpsService.UidState uidState, String pkgName) throws NumberFormatException, XmlPullParserException, IOException {
        int opCode = parser.getAttributeInt(null, ATTR_NAME);
        AppOpsService r3 = this.mAppOpsService;
        r3.getClass();
        AppOpsService.Op op = new AppOpsService.Op(r3, uidState, pkgName, opCode, uidState.uid);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(TAG_ATTRIBUTION_OP) == true) goto L16;
        Slog.w(TAG, "Unknown element under <op>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readAttributionOp(parser, op, XmlUtils.readStringAttribute(parser, ATTR_ID));
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L19:
        AppOpsService.Ops ops = uidState.pkgOps.get(pkgName);
        if (ops != null) goto L22;
        ops = new AppOpsService.Ops(pkgName, uidState);
        uidState.pkgOps.put(pkgName, ops);
    L22:
        ops.put(op.op, op);
    }

    private void readAttributionOp(TypedXmlPullParser parser, AppOpsService.Op parent, String attribution) throws NumberFormatException, IOException, XmlPullParserException {
        long key = parser.getAttributeLong(null, ATTR_NAME);
        int uidState = AppOpsManager.extractUidStateFromKey(key);
        int opFlags = AppOpsManager.extractFlagsFromKey(key);
        String deviceId = parser.getAttributeValue(null, ATTR_DEVICE_ID);
        long accessTime = parser.getAttributeLong(null, ATTR_ACCESS_TIME, 0);
        long rejectTime = parser.getAttributeLong(null, "r", 0);
        long accessDuration = parser.getAttributeLong(null, ATTR_ACCESS_DURATION, -1);
        String proxyPkg = XmlUtils.readStringAttribute(parser, ATTR_PROXY_PACKAGE);
        int proxyUid = parser.getAttributeInt(null, ATTR_PROXY_UID, -1);
        String proxyAttributionTag = XmlUtils.readStringAttribute(parser, ATTR_PROXY_ATTRIBUTION_TAG);
        String proxyDeviceId = parser.getAttributeValue(null, ATTR_PROXY_DEVICE_ID);
        if (deviceId != null) goto L5;
    L6:
        deviceId = "default:0";
    L7:
        AttributedOp attributedOp = parent.getOrCreateAttribution(parent, attribution, deviceId);
        if (accessTime <= 0) goto L12;
        attributedOp.accessed(accessTime, accessDuration, proxyUid, proxyPkg, proxyAttributionTag, proxyDeviceId, uidState, opFlags);
    L12:
        if (r20 <= 0) goto L15;
        attributedOp.rejected(rejectTime, uidState, opFlags);
        return;
    L15:
        return;
    L5:
        if (Objects.equals(deviceId, "") == false) goto L7;
        goto L6
    }

    void writeRecentAccesses(SparseArray<AppOpsService.UidState> uidStates) {
        AtomicFile r0 = this.mRecentAccessesFile;
        monitor-enter(r0);
        FileOutputStream stream = this.mRecentAccessesFile.startWrite();     // Catch: Throwable -> L15 IOException -> L27
    L35:
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L15 IOException -> L17
        out.startDocument(null, true);     // Catch: Throwable -> L15 IOException -> L17
        out.startTag(null, TAG_APP_OPS);     // Catch: Throwable -> L15 IOException -> L17
        out.attributeInt(null, "v", 1);     // Catch: Throwable -> L15 IOException -> L17
        int uidIndex = 0;
    L7:
        if (uidIndex >= uidStates.size()) goto L21;
        AppOpsService.UidState uidState = uidStates.valueAt(uidIndex);     // Catch: Throwable -> L15 IOException -> L17
        int uid = uidState.uid;     // Catch: Throwable -> L15 IOException -> L17
        int pkgIndex = 0;
    L10:
        if (pkgIndex >= uidState.pkgOps.size()) goto L20;
        String packageName = uidState.pkgOps.keyAt(pkgIndex);     // Catch: Throwable -> L15 IOException -> L17
        AppOpsService.Ops ops = uidState.pkgOps.valueAt(pkgIndex);     // Catch: Throwable -> L15 IOException -> L17
        out.startTag(null, "pkg");     // Catch: Throwable -> L15 IOException -> L17
        out.attribute(null, ATTR_NAME, packageName);     // Catch: Throwable -> L15 IOException -> L17
        out.startTag(null, "uid");     // Catch: Throwable -> L15 IOException -> L17
        out.attributeInt(null, ATTR_NAME, uid);     // Catch: Throwable -> L15 IOException -> L17
        int opIndex = 0;
    L13:
        if (opIndex >= ops.size()) goto L19;
        AppOpsService.Op op = ops.valueAt(opIndex);     // Catch: Throwable -> L15 IOException -> L17
        out.startTag(null, TAG_OP);     // Catch: Throwable -> L15 IOException -> L17
        out.attributeInt(null, ATTR_NAME, op.op);     // Catch: Throwable -> L15 IOException -> L17
        writeDeviceAttributedOps(out, op);     // Catch: Throwable -> L15 IOException -> L17
        out.endTag(null, TAG_OP);     // Catch: Throwable -> L15 IOException -> L17
        opIndex = opIndex + 1;     // Catch: Throwable -> L15 IOException -> L17
        goto L13
    L19:
        out.endTag(null, "uid");     // Catch: Throwable -> L15 IOException -> L17
        out.endTag(null, "pkg");     // Catch: Throwable -> L15 IOException -> L17
        pkgIndex = pkgIndex + 1;     // Catch: Throwable -> L15 IOException -> L17
        goto L10
    L20:
        uidIndex = uidIndex + 1;     // Catch: Throwable -> L15 IOException -> L17
        goto L7
    L21:
        out.endTag(null, TAG_APP_OPS);     // Catch: Throwable -> L15 IOException -> L17
        out.endDocument();     // Catch: Throwable -> L15 IOException -> L17
        this.mRecentAccessesFile.finishWrite(stream);     // Catch: Throwable -> L15 IOException -> L17
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L17:
        e = move-exception;
        Slog.w(TAG, "Failed to write state, restoring backup.", e);     // Catch: Throwable -> L15
        this.mRecentAccessesFile.failWrite(stream);     // Catch: Throwable -> L15
    L27:
        e = move-exception;
        Slog.w(TAG, "Failed to write state: " + e);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void writeDeviceAttributedOps(TypedXmlSerializer out, AppOpsService.Op op) throws IOException {
        AppOpsService.Op r1 = op;
        Iterator<String> r2 = r1.mDeviceAttributedOps.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L53;
        String deviceId = r2.next();
        ArrayMap<String, AttributedOp> attributedOps = r1.mDeviceAttributedOps.get(deviceId);
        int attrIndex = 0;
    L7:
        if (attrIndex >= attributedOps.size()) goto L52;
        String attributionTag = attributedOps.keyAt(attrIndex);
        AppOpsManager.AttributedOpEntry attributedOpEntry = attributedOps.valueAt(attrIndex).createAttributedOpEntryLocked();
        ArraySet<Long> keys = attributedOpEntry.collectKeys();
        int k = 0;
    L10:
        if (k >= keys.size()) goto L51;
        long key = keys.valueAt(k).longValue();
        int uidState = AppOpsManager.extractUidStateFromKey(key);
        int flags = AppOpsManager.extractFlagsFromKey(key);
        long accessTime = attributedOpEntry.getLastAccessTime(uidState, uidState, flags);
        Iterator<String> r16 = r2;
        long rejectTime = attributedOpEntry.getLastRejectTime(uidState, uidState, flags);
        ArrayMap<String, AttributedOp> attributedOps2 = attributedOps;
        int attrIndex2 = attrIndex;
        long accessDuration = attributedOpEntry.getLastDuration(uidState, uidState, flags);
        AppOpsManager.OpEventProxyInfo proxy = attributedOpEntry.getLastProxyInfo(uidState, uidState, flags);
        if (accessTime <= 0) goto L14;
    L19:
        out.startTag(null, TAG_ATTRIBUTION_OP);
        if (attributionTag == null) goto L23;
        out.attribute(null, ATTR_ID, attributionTag);
    L23:
        out.attributeLong(null, ATTR_NAME, key);
        if (Objects.equals(deviceId, "default:0") == true) goto L28;
        out.attribute(null, ATTR_DEVICE_ID, deviceId);
    L28:
        if (accessTime <= 0) goto L31;
        out.attributeLong(null, ATTR_ACCESS_TIME, accessTime);
    L31:
        if (rejectTime <= 0) goto L34;
        out.attributeLong(null, "r", rejectTime);
    L34:
        if (accessDuration <= 0) goto L36;
        out.attributeLong(null, ATTR_ACCESS_DURATION, accessDuration);
    L36:
        if (proxy == null) goto L49;
        out.attributeInt(null, ATTR_PROXY_UID, proxy.getUid());
        if (proxy.getPackageName() == null) goto L41;
        out.attribute(null, ATTR_PROXY_PACKAGE, proxy.getPackageName());
    L41:
        if (proxy.getAttributionTag() == null) goto L44;
        out.attribute(null, ATTR_PROXY_ATTRIBUTION_TAG, proxy.getAttributionTag());
    L44:
        if (proxy.getDeviceId() == null) goto L49;
        if (Objects.equals(proxy.getDeviceId(), "default:0") == true) goto L49;
        out.attribute(null, ATTR_PROXY_DEVICE_ID, proxy.getDeviceId());
    L49:
        out.endTag(null, TAG_ATTRIBUTION_OP);
    L50:
        k = k + 1;
        r2 = r16;
        attributedOps = attributedOps2;
        attrIndex = attrIndex2;
        attributedOpEntry = attributedOpEntry;
        keys = keys;
        attributionTag = attributionTag;
        goto L10
    L14:
        if (rejectTime > 0) goto L19;
        if (accessDuration > 0) goto L19;
        if (proxy != null) goto L19;
        attributionTag = attributionTag;
        k = k;
        goto L50
    L51:
        attrIndex = attrIndex + 1;
        goto L7
    L52:
        r1 = op;
        goto L4
    }
}
