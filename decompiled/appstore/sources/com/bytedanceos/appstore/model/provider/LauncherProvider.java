package com.bytedanceos.appstore.model.provider;

import android.app.ActivityOptions;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedanceos.appstore.download.manager.AppsInstallManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import x8.b;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherProvider extends ContentProvider {

    public class a implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LauncherProvider f9425d;

        public a(LauncherProvider r10, int r11, boolean r12, String r13) {
            this.f9425d = r10;
            this.f9422a = r11;
            this.f9423b = r12;
            this.f9424c = r13;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            if (r11 == null) goto L5;
            j.a(this.f9424c + " msg:" + r11.getMessage());
            return;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            AppInfo r15 = c9.a.m(r12);
            if (r15 != null) goto L6;
            j.e("appInfo = " + r15);
            return;
        L6:
            r15.appSource = "launcher";
            r15.tabSource = "launcher";
            r15.mSourcePkgName = this.f9425d.getCallingPackage();
            if (this.f9422a != 3) goto L9;
        L18:
            com.bytedanceos.common.utils.j.j(this.f9425d.getContext(), r15);
            return;
        L9:
            if (r15.mAppType == 3) goto L18;
            if (com.bytedanceos.appstore.datacache.a.N0().Y(r15.appPackageName) == false) goto L14;
            com.bytedanceos.common.utils.j.c(this.f9425d.getContext(), r15, this.f9423b);
            return;
        L14:
            if (com.bytedanceos.appstore.utils.a.c(r15.appDownloadUrl) == false) goto L16;
            com.bytedanceos.common.utils.j.a(this.f9425d.getContext(), r15, this.f9423b);
            return;
        L16:
            j.a(this.f9424c + " url = " + r15.appDownloadUrl);
        }
    }

    public LauncherProvider() {
    }

    public void a(Bundle r10) {
        String r11 = r10.getString(AppPermissionActivity.EXTRA_APP_PKG);
        boolean r12 = r10.getBoolean("allowedNetworkTypes", false);
        int r13 = r10.getInt("soft_type", 0);
        int r14 = 3;
    L3:
        if (r14 > 0) goto L5;
    L16:
        CommonAPIHelper.r(2, 700001, r11, new a(this, r13, r12, r11));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (BaseApplication.c() != null) goto L16;
        j.n("sleep 10ms and waitting for Aplication init");     // Catch: Exception -> L8
        Thread.sleep(10);     // Catch: Exception -> L8
    L10:
        r14 = r14 - 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public void b(Bundle r10) {
        String[] r11 = r10.getStringArray("pkgArr");
        if (r11 != null) goto L5;
    L16:
        j.a("pkg is null ");
        return;
    L5:
        if (r11.length == 0) goto L16;
        j.a(Arrays.toString(r11));
        r10.clear();
        ArrayList<AppInfo> r12 = DataBaseManager.DownloadInfoTable.getDownloadIcons(r11);
        b r13 = b.c();
        Iterator<AppInfo> r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        AppInfo r15 = r14.next();
        Bitmap r16 = r13.getBitmap(r15.appIcon);
        if (r16 != null) goto L12;
        r10.putString(r15.appPackageName, r15.appIcon);
        goto L9
    L12:
        r10.putParcelable(r15.appIcon, r16);
        goto L9
    L14:
        j.e("apps = " + r12.size());
    }

    public final void c(Bundle r10) {
        String r11 = r10.getString(AppPermissionActivity.EXTRA_APP_PKG);
        String r12 = getCallingPackage();
        if (d(r12) == true) goto L6;
        j.n("install failed:" + r11 + ",caller:" + r12);
        return;
    L6:
        String r13 = r10.getString("filePath");
        if (TextUtils.isEmpty(r13) == false) goto L9;
    L13:
        j.n("imput file path error:" + r13);
        return;
    L9:
        if (new File(r13).exists() == false) goto L13;
        AppInfo r14 = new AppInfo();
        r14.appName = r10.getString("appname");
        r14.appPackageName = r11;
        r14.downloadFilePath = r13;
        r14.appSource = "launcher";
        r14.mSourcePkgName = r12;
        AppsInstallManager.getInstance().install(getContext(), r14, false);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        BaseApplication.u("LauncherProvider", false);
        if (r10 != null) goto L5;
    L23:
        BaseApplication.u("LauncherProvider", true);
        return null;
    L5:
        if (r10.equals("openApp") == false) goto L8;
        e(r12);
        goto L23
    L8:
        if (r10.equals("download") == false) goto L10;
    L22:
        a(r12);
        goto L23
    L10:
        if (r10.equals("downloadTheme") == true) goto L22;
        if (r10.equals("fetchIcon") == false) goto L16;
        b(r12);
        goto L23
    L16:
        if (r10.equals("removeDownload") == false) goto L19;
        f(r12);
        goto L23
    L19:
        if (r10.equals("installApp") == false) goto L21;
        c(r12);
        goto L23
    L21:
        j.e("method = " + r10);
        goto L23
    }

    public final boolean d(String r10) {
        PackageManager r11 = BaseApplication.c().getPackageManager();     // Catch: Exception -> L7
        if (r11 != null) goto L9;
        j.b("pm is null!");     // Catch: Exception -> L7
        return false;
    L9:
        PackageInfo r12 = r11.getPackageInfo(r10, 0);     // Catch: Exception -> L7
        if (r12 != null) goto L14;
        return false;
    L14:
        if ((r12.applicationInfo.flags & 129) == 0) goto L20;
        return true;
    L20:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return 0;
    }

    public void e(Bundle r10) {
        if (r10 != null) goto L6;
        j.n("openApp,Bundle is null");
        return;
    L6:
        String r11 = r10.getString(AppPermissionActivity.EXTRA_APP_PKG);
        if (TextUtils.isEmpty(r11) == false) goto L10;
        j.n("openApp,pkg is null");
        return;
    L10:
        String r12 = getCallingPackage();
        PackageManager r13 = BaseApplication.c().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L15
        if (r13 != null) goto L17;
        j.b("pm is null!");     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L17:
        PackageInfo r14 = r13.getPackageInfo(r12, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        Intent r15 = new Intent("bytedanceos.appstore.recommend.app.detail.internal");     // Catch: PackageManager.NameNotFoundException -> L15
        r15.setPackage(BaseApplication.c().getPackageName());     // Catch: PackageManager.NameNotFoundException -> L15
        r15.putExtra(AppPermissionActivity.EXTRA_APP_PKG, r11);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r14 == null) goto L22;
        int r16 = r14.applicationInfo.flags;     // Catch: PackageManager.NameNotFoundException -> L15
        int r17 = 129;
        if ((r16 & 129) == 0) goto L22;
    L23:
        r15.putExtra("flag", r17);     // Catch: PackageManager.NameNotFoundException -> L15
        r15.putExtra("from_package", r12);     // Catch: PackageManager.NameNotFoundException -> L15
        r15.putExtra("from_position", r10.getString("from_position"));     // Catch: PackageManager.NameNotFoundException -> L15
        r15.putExtra("type", AppInfo.SEARCH_SOURCE_EXTENAL);     // Catch: PackageManager.NameNotFoundException -> L15
        r15.setFlags(335544320);     // Catch: PackageManager.NameNotFoundException -> L15
        BaseApplication.c().startActivity(r15, ActivityOptions.makeCustomAnimation(BaseApplication.c(), R.anim.pop_up_in, 0).toBundle());     // Catch: PackageManager.NameNotFoundException -> L15
        j.n("openApp:flag," + r17 + " caller:" + r12 + " | download app:" + r11);     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L22:
        r17 = 0;
    L15:
        e = move-exception;
        j.n("openApp,caller:" + r12 + " | " + e.getMessage());
    }

    public void f(Bundle r10) {
        String r11 = r10.getString(AppPermissionActivity.EXTRA_APP_PKG);
        int r12 = r10.getInt("downloadId", -1);
        r10.clear();
        if (r12 != (-1)) goto L6;
        j.e("extras id: " + r12 + " / " + r11);
        r10.putInt("result", 3);
        return;
    L6:
        long r13 = r12;
        AppInfo r14 = q8.a.b().e(r13);
        if (r14 != null) goto L11;
        j.e("download_Id: " + r12 + " / " + r11);
        r10.putInt("result", 3);
        return;
    L11:
        if (r14.downloadStatus != 8) goto L15;
        j.e("installing: " + r11);
        r10.putInt("result", 2);
        return;
    L15:
        if (com.bytedanceos.common.download.b.l().q(true, new long[]{r13}) != 0) goto L17;
        j.e("remove failed: " + r11);
        r10.putInt("result", 4);
        return;
    L17:
        r10.putInt("result", 1);
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
