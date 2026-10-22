package com.bytedance.crash.general;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.config.g;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppInfo implements Serializable {
    private static final String KEY_APP_DISPLAY_NAME = "display_name";
    private static final String KEY_APP_PACKAGE = "package";
    private static final String KEY_APP_RELEASE_BUILD = "release_build";
    private static final String KEY_APP_VERIFY_INFO = "verify_info";
    private static final String KEY_NPTH_BYTRACE_ID = "bytrace_id";
    public static final String KEY_NPTH_VERSION_CODE = "sdk_version";
    public static final String KEY_NPTH_VERSION_NAME = "sdk_version_name";
    private static final int MAX_FILE_COUNT = 3;
    private static final String SUFFIX = ".aif";
    private static final long TOW_WEEKS = 1209600000;
    private static final long serialVersionUID = 1;
    Map<String, Object> mAppExtension;
    int mAppVersionCode;
    String mAppVersionName;
    String mBitWide;
    String mDisplayName;
    long mLastUpdateTime;
    String mNpthBytraceId;
    int mNpthVersionCode;
    String mNpthVersionName;
    String mPackageName;
    String mReleaseBuild;

    public AppInfo() {
    }

    static /* synthetic */ long access$000(File r2) {
        return getLastUpdateTime(r2);
    }

    private static File[] getSortedFilesArray(File r1) {
        File[] r2 = r1.listFiles(new AnonymousClass1());
        if (r2 == null) goto L5;
        Arrays.sort(r2, new AnonymousClass2());
    L5:
        return r2;
    }

    static AppInfo findAppInfo(File r7, long r8) {
        File[] r9 = getSortedFilesArray(r7);
        if (r9 == null) goto L14;
        int r2 = r9.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L23;
        AppInfo r4 = (AppInfo) ZeusTransformUtils.preCheckCast((AppInfo) ZeusTransformUtils.preCheckCast(v.a(r9[r3]), AppInfo.class, "com.obric.aiagent.plugin"), AppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        if (r8 <= r4.mLastUpdateTime) goto L13;
        return r4;
    L13:
        r3 = r3 + 1;
        goto L5
    L23:
        return null;
    L14:
        return null;
    }

    static AppInfo get(Context r9, File r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r1 = r11.getPackageName();
        PackageInfo r3 = null;
        PackageInfo r4 = r11.getPackageManager().getPackageInfo(r1, 0);     // Catch: Throwable -> L10
        File r5 = new File(r10, r4.lastUpdateTime + SUFFIX);     // Catch: Throwable -> L8
        AppInfo r0 = (AppInfo) ZeusTransformUtils.preCheckCast((AppInfo) ZeusTransformUtils.preCheckCast(v.a(r5), AppInfo.class, "com.obric.aiagent.plugin"), AppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L12;
        return r0;
    L12:
        AppInfo r2 = new AppInfo();
        r2.mPackageName = r1;
        if (NativeBridge.g() == false) goto L15;
        String r6 = "64";
    L16:
        r2.mBitWide = r6;
        r2.mReleaseBuild = com.bytedance.crash.config.a.b();
        r2.mNpthVersionCode = 4020254;
        r2.mNpthVersionName = g.f7298a;
        r2.mNpthBytraceId = com.bytedance.crash.o.c.a();
        r2.mAppExtension = com.bytedance.crash.config.a.a();
        if (r4 == null) goto L23;
        r2.mLastUpdateTime = r4.lastUpdateTime;
        r2.mAppVersionCode = r4.versionCode;
        r2.mAppVersionName = r4.versionName;
        if (r4.applicationInfo == null) goto L23;
        int r7 = r4.applicationInfo.labelRes;
        if (r7 <= 0) goto L23;
        r2.mDisplayName = r11.getString(r7);
    L23:
        if (r5 == null) goto L25;
        clear(r10);
        v.a(r5, r2);
    L25:
        return r2;
    L15:
        r6 = "32";
    L9:
        r3 = r4;
    L11:
        r4 = r3;
    L8:
        r5 = null;
    L10:
        r5 = null;
        goto L11
    }

    private static void clear(File r8) {
        File[] r9 = getSortedFilesArray(r8);
        if (r9 == null) goto L15;
        int r1 = 3;
        if (r9.length <= 3) goto L19;
        long r2 = System.currentTimeMillis();
    L8:
        if (r1 >= r9.length) goto L20;
        long r4 = getLastUpdateTime(r9[r1]);
        if (r4 >= 0) goto L12;
    L13:
        r9[r1].delete();
    L14:
        r1 = r1 + 1;
        goto L8
    L12:
        if ((r2 - r4) <= TOW_WEEKS) goto L14;
    L20:
        return;
    L19:
        return;
    }

    private static long getLastUpdateTime(File r2) {
        String r3 = r2.getName();     // Catch: Throwable -> L4
        return Long.parseLong(r3.substring(0, r3.length() - 4));
    L4:
        return -1;
    }

    void putTo(JSONObject r5) {
        l.a(r5, KEY_APP_PACKAGE, this.mPackageName);
        l.a(r5, KEY_APP_DISPLAY_NAME, this.mDisplayName);
        l.a(r5, WsConstants.KEY_APP_VERSION, this.mAppVersionName);
        l.a(r5, "version_code", Integer.valueOf(this.mAppVersionCode));
        l.a(r5, KEY_APP_VERIFY_INFO, this.mBitWide);
        l.a(r5, KEY_APP_RELEASE_BUILD, this.mReleaseBuild);
        l.a(r5, KEY_NPTH_BYTRACE_ID, this.mNpthBytraceId);
        l.a(r5, "sdk_version", Integer.valueOf(this.mNpthVersionCode));
        l.a(r5, KEY_NPTH_VERSION_NAME, this.mNpthVersionName);
        l.a(r5, "last_update_time", Long.valueOf(this.mLastUpdateTime));
        Map<String, Object> r0 = this.mAppExtension;
        if (r0 == null) goto L8;
        Iterator<String> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        l.a(r5, r2, this.mAppExtension.get(r2));
        goto L6
    L10:
        return;
    }
}
