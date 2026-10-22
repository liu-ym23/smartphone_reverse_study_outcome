package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.scene.SceneUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class LegacyAppOpStateParser {
    private static final int NO_FILE_VERSION = -2;
    private static final int NO_VERSION = -1;
    static final String TAG = null;

    LegacyAppOpStateParser() {
    }

    static {
        TAG = LegacyAppOpStateParser.class.getSimpleName();
    }

    public int readState(AtomicFile file, SparseArray<SparseIntArray> uidModes, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) {
        FileInputStream stream = file.openRead();     // Catch: Exception -> L46 FileNotFoundException -> L48
        SparseArray<SparseIntArray> parsedUidModes = new SparseArray();     // Catch: Throwable -> L17
        SparseArray<ArrayMap<String, SparseIntArray>> parsedUserPackageModes = new SparseArray();     // Catch: Throwable -> L17
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L17
    L4:
        int type = parser.next();     // Catch: Throwable -> L17
        if (type == 2) goto L8;
        if (type != 1) goto L4;
    L8:
        if (type != 2) goto L52;
        int versionAtBoot = parser.getAttributeInt(null, "v", -1);     // Catch: Throwable -> L17
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L17
    L10:
        int type2 = parser.next();     // Catch: Throwable -> L17
        if (type2 == 1) goto L35;
        if (type2 == 3) goto L15;
    L20:
        if (type2 == 3) goto L10;
        if (type2 == 4) goto L10;
        String tagName = parser.getName();     // Catch: Throwable -> L17
        if (tagName.equals(SceneUtils.KEY_PKG) == false) goto L28;
        readPackage(parser, parsedUserPackageModes);     // Catch: Throwable -> L17
        goto L10
    L28:
        if (tagName.equals("uid") == false) goto L31;
        readUidOps(parser, parsedUidModes);     // Catch: Throwable -> L17
        goto L10
    L31:
        if (tagName.equals("user") == false) goto L33;
        readUser(parser, parsedUserPackageModes);     // Catch: Throwable -> L17
        goto L10
    L33:
        Slog.w(TAG, "Unknown element under <app-ops>: " + parser.getName());     // Catch: Throwable -> L17
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L17
        goto L10
    L15:
        if (parser.getDepth() > outerDepth) goto L20;
    L35:
        int parsedUidModesSize = parsedUidModes.size();     // Catch: Throwable -> L17
        int i = 0;
    L36:
        if (i >= parsedUidModesSize) goto L38;
        uidModes.put(parsedUidModes.keyAt(i), parsedUidModes.valueAt(i));     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        goto L36
    L38:
        int parsedUserPackageModesSize = parsedUserPackageModes.size();     // Catch: Throwable -> L17
        int i2 = 0;
    L39:
        if (i2 >= parsedUserPackageModesSize) goto L43;
        userPackageModes.put(parsedUserPackageModes.keyAt(i2), parsedUserPackageModes.valueAt(i2));     // Catch: Throwable -> L17
        i2 = i2 + 1;
        goto L39
    L43:
        if (stream == null) goto L50;
        stream.close();     // Catch: Exception -> L46 FileNotFoundException -> L48
    L50:
        return versionAtBoot;
    L52:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (stream != null) goto L64;
    L59:
        throw th;     // Catch: Exception -> L46 FileNotFoundException -> L48
    L64:
        stream.close();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L46 FileNotFoundException -> L48
    L46:
        e = move-exception;
        Slog.wtf(TAG, "Failed parsing " + e);
        return -2;
    L61:
        Slog.i(TAG, "No existing app ops " + file.getBaseFile() + "; starting empty");
        return -2;
    }

    private void readPackage(TypedXmlPullParser parser, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) throws NumberFormatException, XmlPullParserException, IOException {
        String pkgName = parser.getAttributeValue(null, "n");
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
        readPackageUid(parser, pkgName, userPackageModes);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readPackageUid(TypedXmlPullParser parser, String pkgName, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) throws NumberFormatException, XmlPullParserException, IOException {
        int userId = UserHandle.getUserId(parser.getAttributeInt(null, "n"));
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readOp(parser, userId, pkgName, userPackageModes);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readUidOps(TypedXmlPullParser parser, SparseArray<SparseIntArray> uidModes) throws NumberFormatException, XmlPullParserException, IOException {
        int uid = parser.getAttributeInt(null, "n");
        SparseIntArray modes = uidModes.get(uid);
        if (modes != null) goto L5;
        modes = new SparseIntArray();
        uidModes.put(uid, modes);
    L5:
        int outerDepth = parser.getDepth();
    L6:
        int type = parser.next();
        if (type == 1) goto L25;
        if (type == 3) goto L11;
    L13:
        if (type == 3) goto L6;
        if (type == 4) goto L6;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L19;
        Slog.w(TAG, "Unknown element under <uid>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L6
    L19:
        int code = parser.getAttributeInt(null, "n");
        int mode = parser.getAttributeInt(null, "m");
        if (mode == AppOpsManager.opToDefaultMode(code)) goto L6;
        modes.put(code, mode);
        goto L6
    L11:
        if (parser.getDepth() > outerDepth) goto L13;
        return;
    }

    private void readUser(TypedXmlPullParser parser, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) throws NumberFormatException, XmlPullParserException, IOException {
        int userId = parser.getAttributeInt(null, "n");
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(SceneUtils.KEY_PKG) == true) goto L16;
        Slog.w(TAG, "Unknown element under <user>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readPackageOp(parser, userId, userPackageModes);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readPackageOp(TypedXmlPullParser parser, int userId, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) throws NumberFormatException, XmlPullParserException, IOException {
        String pkgName = parser.getAttributeValue(null, "n");
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readOp(parser, userId, pkgName, userPackageModes);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readOp(TypedXmlPullParser parser, int userId, String pkgName, SparseArray<ArrayMap<String, SparseIntArray>> userPackageModes) throws NumberFormatException, XmlPullParserException {
        int opCode = parser.getAttributeInt(null, "n");
        int defaultMode = AppOpsManager.opToDefaultMode(opCode);
        int mode = parser.getAttributeInt(null, "m", defaultMode);
        if (mode == defaultMode) goto L12;
        ArrayMap<String, SparseIntArray> packageModes = userPackageModes.get(userId);
        if (packageModes != null) goto L7;
        packageModes = new ArrayMap();
        userPackageModes.put(userId, packageModes);
    L7:
        SparseIntArray modes = packageModes.get(pkgName);
        if (modes != null) goto L10;
        modes = new SparseIntArray();
        packageModes.put(pkgName, modes);
    L10:
        modes.put(opCode, mode);
        return;
    }
}
