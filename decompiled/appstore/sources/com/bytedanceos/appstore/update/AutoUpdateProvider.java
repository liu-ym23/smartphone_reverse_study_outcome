package com.bytedanceos.appstore.update;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedanceos.appstore.datacache.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;

/* JADX INFO: loaded from: classes2.dex */
public class AutoUpdateProvider extends ContentProvider {
    private static final String AUTHORITY = "com.obric.appstore.theme_download";
    private static final String TAG = "AutoUpdateProvider";
    private AutoUpdateManager mAutoUpdateManager;
    private final AutoUpdateProviderKt mKt;

    public AutoUpdateProvider() {
        this.mAutoUpdateManager = null;
        this.mKt = new AutoUpdateProviderKt();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        Bundle r13 = null;
        if (this.mKt.checkPermission(requireContext()) == true) goto L5;
        return null;
    L5:
        BaseApplication.u(TAG, false);
        int r14 = -1;
    L14:
        e = e;
    L53:
        j.j("[AutoUpdate] AutoUpdateProvider call error:" + r14 + " | " + r10 + " | " + r12, e);     // Catch: Throwable -> L12
    L52:
        BaseApplication.u(TAG, true);
        return r13;
    L12:
        th = move-exception;
        BaseApplication.u(TAG, true);
        throw th;
    L8:
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L16;
        j.k("[AutoUpdate] AutoUpdateProvider call " + r10 + " privacy policy not agreed");     // Catch: Throwable -> L12 Exception -> L14
        BaseApplication.u(TAG, true);
        return null;
    L16:
        if (r12 != null) goto L18;
    L21:
        int r15 = -1;
    L61:
        if (r15 != (-1)) goto L27;
        j.h("[AutoUpdate] AutoUpdateProvider call " + r10 + " client version is -1");     // Catch: Throwable -> L12 Exception -> L24
    L51:
        j.h("[AutoUpdate] AutoUpdateProvider call " + r15 + " | " + r10 + " | " + r12 + " | " + r13);     // Catch: Throwable -> L12 Exception -> L24
        goto L52
    L27:
        if (TextUtils.equals(r10, "checkAppUpdate") == false) goto L30;
        r13 = this.mAutoUpdateManager.findNewVersion(getContext(), r12);     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L30:
        if (TextUtils.equals(r10, "getDownloadProgress") == false) goto L33;
        r13 = a.N0().L0(r12);     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L33:
        if (TextUtils.equals(r10, "startDownload") == false) goto L36;
        this.mAutoUpdateManager.downloadApp(getContext(), r12, 1);     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L36:
        if (TextUtils.equals(r10, "stopDownload") == false) goto L39;
        this.mAutoUpdateManager.stopDownload(getContext(), r12);     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L39:
        if (TextUtils.equals(r10, "delayUpdate") == false) goto L42;
        this.mAutoUpdateManager.delayUpdate(getContext(), r12);     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L42:
        if (TextUtils.equals(r10, "installApp") == false) goto L45;
        this.mAutoUpdateManager.installApp(getContext(), r12, "sys_app_force");     // Catch: Throwable -> L12 Exception -> L24
        goto L51
    L45:
        if (TextUtils.equals(r10, "checkAppStoreAutoUpdateEnable") == false) goto L51;
        j.h("[AutoUpdate] AutoUpdateProvider call " + r10 + " extras" + r12.getString("query_package"));     // Catch: Throwable -> L12 Exception -> L24
        Bundle r16 = new Bundle();     // Catch: Throwable -> L12 Exception -> L24
        r16.putBoolean("is_appstore_auto_update_enable", s.g(getContext()));     // Catch: Throwable -> L12 Exception -> L49
        r13 = r16;
    L49:
        e = e;
        r13 = r16;
    L25:
        r14 = r15;
    L24:
        e = e;
        goto L25
    L18:
        if (r12.isEmpty() == true) goto L21;
        r15 = r12.getInt("client_ver", -1);     // Catch: Throwable -> L12 Exception -> L14
        goto L61
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "vnd.android.cursor.item/vnd.com.obric.appstore.theme_download";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mAutoUpdateManager = new AutoUpdateManager();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return 0;
    }
}
