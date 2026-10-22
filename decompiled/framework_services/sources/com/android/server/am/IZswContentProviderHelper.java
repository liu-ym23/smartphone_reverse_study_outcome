package com.android.server.am;

import android.app.AppGlobals;
import android.app.ContentProviderHolder;
import android.content.pm.ProviderInfo;
import android.mifavor.MFVUtils;
import android.net.Uri;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.zte.ctsutils.CtsUtils;
import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes.dex */
public interface IZswContentProviderHelper {
    public static final boolean DEBUG_DOUBLEAPP = false;
    public static final String DUMP_ALL = "all";
    public static final String TAG = "ContentProviderHelperMifavor";

    public static class ContentProviderHolderWraper {
        public ContentProviderHolder mHolder;
        public int mUserId;

        public ContentProviderHolderWraper(ContentProviderHolder holder, int userId) {
            this.mHolder = holder;
            this.mUserId = userId;
        }
    }

    public static class ContentProviderRecordWraper {
        public ContentProviderRecord mCpr;
        public int mUserId;

        public ContentProviderRecordWraper(ContentProviderRecord cpr, int userId) {
            this.mCpr = cpr;
            this.mUserId = userId;
        }
    }

    void handleFreezer(int r1, String r2);

    boolean isSkipByAutoLaunch(ProviderInfo r1, ProcessRecord r2, int r3, String r4);

    void reportHolderInfo(ContentProviderHolder r1);

    static {
        if (Log.isLoggable("DoubleApp", 2) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG_DOUBLEAPP = r0;
        return;
    L5:
        if (Log.isLoggable("DoubleApp", 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    static boolean checkContentProviderPermission_DoubleApp(int userId, int callingUid, boolean checkUser) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return checkUser;
    L5:
        if (userId == 999) goto L7;
    L8:
        if (userId == 0) goto L10;
        return checkUser;
    L10:
        if (UserHandle.getUserId(callingUid) != 999) goto L15;
    L11:
        return false;
    L15:
        return checkUser;
    L7:
        if (UserHandle.getUserId(callingUid) == 0) goto L11;
        goto L8
    }

    static int getContentProviderImpl_DoubleApp(String name, int userId, ProcessRecord record) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return userId;
    L5:
        if (userId == 999) goto L7;
        return userId;
    L7:
        if (TextUtils.isEmpty(name) == false) goto L9;
        return userId;
    L9:
        if (name.equals("media") == false) goto L11;
    L36:
        Log.d(TAG, "ContentProviderHelperMifavor getContentProviderImpl(auth fallback 999 to 0) name=" + name);
        return 0;
    L11:
        if (name.equals("com.android.contacts") == true) goto L36;
        if (name.contains("com.android.providers.media") == true) goto L36;
        if (name.contains("com.google.android.providers.media") == true) goto L36;
        if (name.equals("com.android.ztescreenshot.longcapture.TestPictureProvider") == true) goto L36;
        if (name.equals("com.zte.intellitext.IntelliTextProvider") == true) goto L36;
        if (name.equals("com.android.calendar.share") == true) goto L36;
        if (name.equals("com.android.calendar") == true) goto L36;
        if (name.equals("zte.com.cn.filer.fileprovider") == true) goto L36;
        if (name.equals("zte.com.cn.pcfiler.fileprovider") == true) goto L36;
        if (name.equals("com.zte.mifavor.miboard.fileProvider") == true) goto L36;
        if (name.equals("com.android.launcher3.cornermark.unreadbadge") == true) goto L36;
        if (name.equals("com.android.badge") == true) goto L36;
        if (name.equals("cn.zte.recorder.fileProvider") == true) goto L36;
        return userId;
    }

    static int getContentProviderImpl_DoubleApp_02(String name, int userId, String callingPackage) {
        return userId;
    }

    static ContentProviderRecordWraper getContentProviderImpl_crossFallback_DoubleApp(String name, int userId, String callingPackage, ProviderMap providerMap, ContentProviderRecord cpr) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L23;
        if (cpr != null) goto L23;
        boolean needRetry = MFVUtils.isNeedFallbackRetry(callingPackage, name);
        if (needRetry == false) goto L19;
        if (userId != 0) goto L13;
        cpr = providerMap.getProviderByName(name, 999);
        if (cpr == null) goto L12;
        userId = 999;
        Slog.d(TAG, "debug_provider(0 fallback to 999) userId:999,name:" + name + ",callingPackage:" + callingPackage + ",new cpr:" + cpr);
        goto L23
    L12:
        Slog.d(TAG, "debug_provider(keep 0) userId:" + userId + ",name:" + name + ",callingPackage:" + callingPackage);
        goto L23
    L13:
        if (userId != 999) goto L23;
        cpr = providerMap.getProviderByName(name, 0);
        if (cpr == null) goto L17;
        userId = 0;
        Slog.d(TAG, "debug_provider (999 fallback to 0) userId:0,name:" + name + ",callingPackage:" + callingPackage + ",new cpr:" + cpr);
        goto L23
    L17:
        Slog.d(TAG, "debug_provider(keep 0) userId:" + userId + ",name:" + name + ",callingPackage:" + callingPackage);
        goto L23
    L19:
        if (DEBUG_DOUBLEAPP == false) goto L23;
        if (userId != 999) goto L23;
        Slog.d(TAG, "debug_provider(may be need fallback 999 to 0) userId:" + userId + ",name:" + name + ",callingPackage:" + callingPackage);
    L23:
        return new ContentProviderRecordWraper(cpr, userId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    static ContentProviderHolderWraper getMimeTypeFilterAsync_DoubleApp(ContentProviderHelper r13, ContentProviderHolder r14, int r15, Uri r16, int r17, int r18, String r19) {
        ?? r8 = r18;
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L79;
        if (r14 != null) goto L79;
        if (isCtsTesting() == true) goto L79;
        String r0 = AppGlobals.getPackageManager().getNameForUid(r15);     // Catch: Exception -> L76
        if (r16 != null) goto L90;
        String r1 = "";
    L14:
        String r10 = r1;
        boolean r2 = true;
        ContentProviderHolder r3 = null;
        if (r10.contains("cn.wps.moffice") == false) goto L18;
    L45:
        boolean r4 = true;
    L47:
        if (r4 == true) goto L52;
        if (MFVUtils.ALLOW_LIST_FOR_DOUBLELAY.contains(r0) == true) goto L52;
        r2 = false;
    L11:
        e = e;
        r3 = r14;
        r8 = r8;
    L78:
        Log.e(TAG, "getProviderMimeTypeAsync excep uri: " + r16 + ",safeUserId:" + (r8 == true ? 1 : 0) + ",e:" + e);
    L81:
        return new ContentProviderHolderWraper(r3, r8);
    L52:
        boolean r11 = r2;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L76
        r5.append("getProviderMimeTypeAsync get hold null for: ");     // Catch: Exception -> L76
        r5.append(r8 == true ? 1 : 0);     // Catch: Exception -> L76
        r5.append(",userId:");     // Catch: Exception -> L76
        r5.append(r17);     // Catch: Exception -> L65
        r5.append(",callingUid:");     // Catch: Exception -> L65
        r5.append(r15);     // Catch: Exception -> L65
        r5.append(",callingPackage:");     // Catch: Exception -> L65
        r5.append(r0);     // Catch: Exception -> L65
        r5.append(",needReTry:");     // Catch: Exception -> L65
        r5.append(r11);     // Catch: Exception -> L65
        r5.append(",uri:");     // Catch: Exception -> L65
        r5.append(r16);     // Catch: Exception -> L65
        r5.append(",name:");     // Catch: Exception -> L65
        r5.append(r19);     // Catch: Exception -> L65
        ?? r6 = r5.toString();     // Catch: Exception -> L65
        Log.d(TAG, r6);     // Catch: Exception -> L65
        ?? r7 = r6;
        if (r11 == true) goto L88;
    L74:
        r3 = r14;
        r6 = r7;
        r8 = r8;
    L82:
    L63:
        e = e;
        r8 = r6;
        goto L78
    L88:
        if (r8 != 0) goto L67;
        ContentProviderHelper r9 = r13;
        r3 = r9.getContentProviderExternalUnchecked(r19, null, r15, "*getmimetype*", 999);     // Catch: Exception -> L65
        r6 = r9;
        r8 = r8;
        if (r3 == null) goto L82;
        r6 = 999(0x3e7, float:1.4E-42);
        Log.d(TAG, "getProviderMimeTypeAsync 0 fallback to 999, success!");     // Catch: Exception -> L63
        r8 = 999(0x3e7, float:1.4E-42);
        goto L82
    L67:
        r7 = 999(0x3e7, float:1.4E-42);
        if (r8 != 999(0x3e7, float:1.4E-42)) goto L74;
        ContentProviderHelper r12 = r13;
        r3 = r12.getContentProviderExternalUnchecked(r19, null, r15, "*getmimetype*", 0);     // Catch: Exception -> L65
        r6 = r12;
        r8 = r8;
        if (r3 == null) goto L82;
        r6 = 0;
        Log.d(TAG, "getProviderMimeTypeAsync 999 fallback to 0, success!");     // Catch: Exception -> L63
        r8 = 0;
    L65:
        e = e;
    L66:
        r3 = r14;
        r8 = r8;
        goto L78
    L18:
        if (r10.contains("com.quark.browser") == true) goto L45;
        if (r10.contains("com.zte") == true) goto L45;
        if (r10.contains("com.tencent") == true) goto L45;
        if (r10.contains("com.facebook") == true) goto L45;
        if (r10.contains("jp.naver.line.android") == true) goto L45;
        if (r10.contains("com.whatsapp") == true) goto L45;
        if (r10.contains("com.twitter.android") == true) goto L45;
        if (r10.contains("com.instagram.android") == true) goto L45;
        if (r10.contains("com.viber.voip") == true) goto L45;
        if (r10.contains("com.android.contacts") == true) goto L45;
        if (r10.contains("com.document.cam.scanner") == true) goto L45;
        if (r10.contains("com.android.launcher") == true) goto L45;
        if (r10.contains("com.zte.mifavor.launcher") == true) goto L45;
        r4 = false;
        goto L47
    L90:
        r1 = r16.toString();     // Catch: Exception -> L11
    L76:
        e = e;
    L79:
        r3 = r14;
        goto L81
    }

    static int checkContentProviderAccess_DoubleApp(String authority, int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return userId;
    L5:
        if (userId == 999) goto L7;
        return userId;
    L7:
        if ("com.android.contacts".equals(authority) == false) goto L9;
    L12:
        Log.d(TAG, "checkContentProviderAccess authority=" + authority + " userId 999 to 0");
        return 0;
    L9:
        if ("sms".equals(authority) == true) goto L12;
        if ("telephony".equals(authority) == true) goto L12;
        return userId;
    }

    private static boolean isCtsTesting() {
        boolean isCts = Feature.getCtsRunningStatus();
        if (isCts == false) goto L5;
    L8:
        return true;
    L5:
        if (CtsUtils.isTopAppCtsPackage() == true) goto L8;
        return false;
    }
}
