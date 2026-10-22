package com.bytedance.reparo;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReparoConfigExternalAdapter extends IReparoConfig {
    private static final String META_KEY_MARS_APP_ID = "MARS_APP_ID";
    private static final String META_KEY_UPDATE_VERSION_CODE = "UPDATE_VERSION_CODE";
    private static final String TAG = "FrankieConfigExternalAdapter";
    private static final String UNKNOWN = "unknown";

    public abstract String getAppKey();

    public abstract String getAppSecretKey();

    public ReparoConfigExternalAdapter() {
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getAppId() {
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        Bundle r6 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData;     // Catch: Throwable -> L13
        if (r6 == null) goto L12;
        String r7 = String.valueOf(r6.get(META_KEY_MARS_APP_ID));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r7) == true) goto L10;
        return r7;
    L10:
        throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_MARS_APP_ID}));     // Catch: Throwable -> L13
    L12:
        throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_MARS_APP_ID}));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        com.bytedance.reparo.c.e.a(TAG, "get app id failed. ", th);
        return "unknown";
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getUpdateVersionCode() {
        Application r5 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        Bundle r6 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData;     // Catch: Throwable -> L13
        if (r6 == null) goto L12;
        String r7 = String.valueOf(r6.get(META_KEY_UPDATE_VERSION_CODE));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r7) == true) goto L10;
        return r7;
    L10:
        throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_UPDATE_VERSION_CODE}));     // Catch: Throwable -> L13
    L12:
        throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_UPDATE_VERSION_CODE}));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        com.bytedance.reparo.c.e.a(TAG, "get update version code failed. ", th);
        return "unknown";
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int r3, String r4, byte[] r5, String r6) {
        String r7 = buildUrlParameters(r4);
        x r8 = x.c(r6);
        String r0 = new String(r5);
        ab.a r9 = new ab.a().a(r7);
        com.bytedance.reparo.core.i.e.a().a(r9, r0, getAppKey(), getAppSecretKey());
        ab r2 = r9.b(DownloadHelper.CONTENT_TYPE, r6).a(ac.a(r8, r0)).b();
        return com.bytedance.reparo.core.i.e.a().b().a(r2).b().g().f();
    }

    private String buildUrlParameters(String r4) {
        Uri.Builder r5 = Uri.parse(r4).buildUpon();
        r5.appendQueryParameter("device_id", getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter(WsConstants.KEY_APP_ID, getAppId()).appendQueryParameter("device_platform", "android").appendQueryParameter(RomInfo.KEY_ROM_OS_API, String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("version_code", String.valueOf(getVersionCode())).appendQueryParameter("update_version_code", getUpdateVersionCode());
        String r3 = Build.VERSION.RELEASE;     // Catch: Exception -> L10
        if (r3 != null) goto L6;
    L8:
        r5.appendQueryParameter(RomInfo.KEY_ROM_OS_VERSION, r3);     // Catch: Exception -> L10
    L13:
        return r5.build().toString();
    L6:
        if (r3.length() <= 10) goto L8;
        r3 = r3.substring(0, 10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.reparo.c.e.a(TAG, e.getMessage(), e);
        goto L13
    }

    public long getVersionCode() {
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        PackageInfo r3 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 28) goto L7;
        long r0 = r3.getLongVersionCode();     // Catch: Throwable -> L8
    L10:
        return r0;
    L7:
        r0 = r3.versionCode;     // Catch: Throwable -> L8
    L8:
        return -1;
    }
}
