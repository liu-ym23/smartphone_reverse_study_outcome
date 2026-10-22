package com.bytedanceos.common.toolbox;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.widget.RemoteViews;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.utils.ReflectTool;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10069c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f10070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NotificationManager f10071b;

    static {
        f10069c = BaseApplication.c().getPackageName() + ".notification.downloading";
    }

    public o() {
        this.f10070a = new ArrayMap();
    }

    public static boolean w() {
        return !DeviceType.isOldDeviceType();
    }

    public abstract void A();

    public void B(AppInfo r10) {
        I(19, r10, 0, null);
    }

    public final void C(String r10, AppInfo r11, int r12) {
        byte r13 = 0;
        if (r11 == null) goto L8;
        if (r11.isAutoDownload == false) goto L8;
        r11.isAutoDownload = false;
    L8:
        if (ie.a.b(r12) == false) goto L10;
    L35:
        y();
        return;
    L10:
        if ((-4) == r12) goto L35;
        String r14 = l(r11.appName, r12);
        String r15 = m(r12);
        PendingIntent r16 = PendingIntent.getActivity(BaseApplication.c(), p(), r(r10, r11), 167772160);
        int r17 = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_icon_size);
        Bitmap r18 = k(r11.appIcon, r17, r17);
        if (r18 != null) goto L15;
        r18 = BitmapFactory.decodeResource(BaseApplication.c().getResources(), R$drawable.icon_store_launcher);
    L15:
        this.f10071b.cancel(f10069c, p());
        M(r11.appPackageName, r18, R$drawable.stat_sys_download_done, r14, r15, r16);
        r10.hashCode();
        switch(r10.hashCode()) {
            case -1655058423: goto L27;
            case -1652133970: goto L23;
            case -837480341: goto L19;
            default: goto L17;
        };
    L17:
        r13 = -1;
    L29:
        switch(r13) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            default: goto L42;
        };
    L31:
        z("exposure_notifications", "notifications_download_failed_gms");
        return;
    L32:
        z("exposure_notifications", "notifications_download_failed_other");
        return;
    L33:
        z("exposure_notifications", "notifications_download_failed_local");
        return;
    L42:
        return;
    L19:
        if (r10.equals("appstore.intent.download.gms") == false) goto L37;
        r13 = 2;
        goto L29
    L37:
        r13 = -1;
        goto L29
    L23:
        if (r10.equals("appstore.intent.download.other") == false) goto L38;
        r13 = 1;
        goto L29
    L38:
        r13 = -1;
        goto L29
    L27:
        if (r10.equals("appstore.intent.download.local") == true) goto L29;
        r13 = -1;
        goto L29
    }

    public final void D(Bundle r10) {
        j.n("NotificationUtils skip sendDownloadingCount");
    }

    public final void E(AppInfo r10) {
        j.n("NotificationUtils skip sendDownloadingProgress");
    }

    public final void F(AppInfo r10, int r11) {
        j.n("NotificationUtils sendInstallFailed code " + r11 + " appInfo " + r10);
        if (ie.a.b(r11) == false) goto L5;
    L20:
        y();
        return;
    L5:
        if (r11 == (-4)) goto L20;
        String r12 = m(r11);
        if (r11 != (-7)) goto L12;
        String r13 = BaseApplication.c().getString(R$string.failed_task3, new Object[]{r10.appName});
        PendingIntent r14 = null;
    L10:
        String r15 = r13;
        PendingIntent r16 = r14;
        int r17 = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_icon_size);
        Bitmap r18 = k(r10.appIcon, r17, r17);
        this.f10071b.cancel(f10069c, p());
        M(r10.appPackageName, r18, R$drawable.stat_sys_download_done, r15, r12, r16);
        z("exposure_notifications", "notifications_install_failed");
        return;
    L12:
        if (r10.appState != 64) goto L14;
    L17:
        r13 = t(r10.appName, r11);
        AppInfo r19 = r10.clone();
        r19.downloadId = 0;
        r14 = q("appstore.intent.download.local", r19);
        goto L10
    L14:
        if (r10.isAppUpdate == true) goto L17;
        r13 = o(r10.appName, r11);
        AppInfo r20 = r10.clone();
        r20.downloadId = 0;
        r14 = q("appstore.intent.download.local", r20);
        goto L10
    }

    public final void G(AppInfo r10) {
        j.n("NotificationUtils skip sendInstallSuccess");
    }

    public void H(int r10, AppInfo r11, int r12) {
        I(r10, r11, r12, null);
    }

    public void I(int r10, AppInfo r11, int r12, Bundle r13) {
        switch(r10) {
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L12;
            case 15: goto L10;
            case 16: goto L8;
            case 17: goto L6;
            case 18: goto L3;
            case 19: goto L4;
            default: goto L3;
        };
    L3:
        return;
    L4:
        E(r11);
        return;
    L6:
        D(r13);
        return;
    L8:
        K(r11.appPackageName);
        return;
    L10:
        C("appstore.intent.download.gms", r11, r12);
        return;
    L12:
        C("appstore.intent.download.other", r11, r12);
        return;
    L14:
        C("appstore.intent.download.local", r11, r12);
        return;
    L16:
        F(r11, r12);
        return;
    L18:
        G(r11);
        return;
    L20:
        A();
    }

    public void J(String r10, String r11, String r12, String r13, Intent r14) {
        if (r14 != null) goto L5;
        this.f10071b.cancel(r10, p());
        return;
    L5:
        AppInfo r15 = new AppInfo();
        r15.appIcon = r13;
        r15.appPackageName = r12;
        M(r10, i(r15, true), R.drawable.stat_sys_download_done, r10, r11, PendingIntent.getService(BaseApplication.c(), 0, r14, 201326592));
    }

    public final void K(String r10) {
        M(r10 + "_16", null, R$drawable.stat_sys_download_done, BaseApplication.c().getString(R$string.notify_signature_ticker), BaseApplication.c().getString(R$string.notify_signature_content, new Object[]{r10}), null);
        z("exposure_notifications", "notifications_signature_error");
    }

    public void L(List r10) {
        if (r10 != null) goto L4;
    L22:
        j.n("NtfAppUpdate no update apps and not not notification");
        return;
    L4:
        if (r10.size() == 0) goto L22;
        if (s.i(BaseApplication.c()) == true) goto L11;
        j.n("NtfAppUpdate the notification update is closed");
        return;
    L11:
        if (e.M0() == true) goto L15;
        j.n("NtfAppUpdate An inappropriate time");
        return;
    L15:
        if (m.b() == false) goto L18;
        j.n("NtfAppUpdate notified today");
        return;
    L18:
        Notification r11 = h(r10);
        if (r11 == null) goto L24;
        this.f10071b.notify(v(), r11);
        z("exposure_notifications", "notifications_update_tips");
        m.c();
        return;
    }

    public void M(String r10, Bitmap r11, int r12, String r13, String r14, PendingIntent r15) {
        if (w() == false) goto L5;
        this.f10071b.notify(n(), p(), g());
        Notification r16 = f(r11, r12, r13, r14, r15);
    L6:
        this.f10071b.notify(r10, p(), r16);
        return;
    L5:
        r16 = e(d(r11, r13, r14), r12, System.currentTimeMillis(), r13, r15);
        goto L6
    }

    public void a(String r10) {
    L7:
        e = move-exception;
        e.printStackTrace();
        j.n("cancelNotification " + r10 + " reason: " + e.toString());
        return;
    L3:
        if (TextUtils.isEmpty(r10) == false) goto L5;
        this.f10071b.cancel(v());     // Catch: Exception -> L7
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L14;
    L15:
        this.f10070a.remove(f10069c);     // Catch: Exception -> L7
        return;
    L14:
        if (r10.equals(f10069c) == true) goto L15;
        return;
    L5:
        if (x(r10) == false) goto L9;
        this.f10071b.cancel(n(), p());     // Catch: Exception -> L7
    L9:
        this.f10071b.cancel(r10, p());     // Catch: Exception -> L7
        goto L12
    }

    public void b(String r10, int r11) {
        this.f10071b.cancel(r10, r11);
    }

    public void c(boolean r10) {
        this.f10071b.cancel(v());
        if (r10 == false) goto L6;
        ((StatusBarManager) BaseApplication.c().getSystemService("statusbar")).collapsePanels();
        return;
    }

    public final RemoteViews d(Bitmap r10, String r11, String r12) {
        RemoteViews r13 = new RemoteViews(BaseApplication.c().getPackageName(), R$layout.notification_item_for_white);
        r13.setViewVisibility(R$id.subtitle, 0);
        r13.setTextViewText(R$id.sub_title, r12);
        r13.setTextViewText(R$id.title, r11);
        if (r10 == null) goto L5;
        r13.setImageViewBitmap(R$id.icon, r10);
    L5:
        return r13;
    }

    public Notification e(RemoteViews r10, int r11, long r12, String r13, PendingIntent r14) {
        Notification.Builder r15 = new Notification.Builder(BaseApplication.c());
        r15.setAutoCancel(true);
        if (r12 <= 0) goto L6;
        r15.setWhen(r12);
    L6:
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r15.setTicker(r13);
    L8:
        r15.setSmallIcon(r11);
        r15.setContent(r10);
        r15.setContentIntent(r14);
        return new n().a(r15).build();
    }

    public Notification f(Bitmap r10, int r11, String r12, String r13, PendingIntent r14) {
        Notification.Builder r15 = new Notification.Builder(BaseApplication.c());
        r15.setAutoCancel(true);
        r15.setWhen(System.currentTimeMillis());
        r15.setTicker(r12);
        r15.setContentText(r13);
        r15.setContentTitle(r12);
        if (r10 != null) goto L14;
        if (r11 <= 0) goto L12;
        r15.setSmallIcon(r11);
    L12:
        r15.setContentIntent(r14);
        r15.setGroupSummary(false);
        r15.setGroup(n());
        return new n().a(r15).build();
    L14:
        Object r16 = Class.forName("android.graphics.drawable.Icon").getDeclaredMethod("createWithBitmap", new Class[]{Bitmap.class}).invoke(null, new Object[]{r10});     // Catch: Exception -> L6
        r15.getClass().getDeclaredMethod("setSmallIcon", new Class[]{r16.getClass()}).invoke(r15, new Object[]{r16});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        if (r11 <= 0) goto L12;
        r15.setSmallIcon(r11);
        goto L12
    }

    public Notification g() {
        androidx.core.app.h r10 = new androidx.core.app.h(BaseApplication.c()).l(R$drawable.icon_store_launcher).h(BaseApplication.c().getResources().getString(R$string.app_name)).g("").k(true).j(n()).f(j()).d(true);
        return new n().b(r10).a();
    }

    public Notification h(List r10) {
        Notification.Builder r11 = new Notification.Builder(BaseApplication.c());
        r11.setAutoCancel(true);
        r11.setContentTitle(BaseApplication.c().getString(R$string.app_name));
        r11.setSmallIcon(R$drawable.icon_store_launcher);
        r11.setContentText(m.a(r10));
        r11.setContentIntent(u());
        r11.setStyle(ReflectTool.getButtonStyle(BaseApplication.c()));
        r11.setShowWhen(false);
        r11.setContentIntent(s());
        return new n().a(r11).build();
    }

    public Bitmap i(AppInfo r10, boolean r11) {
        Bitmap r12 = null;
        if (r10 != null) goto L19;
        return null;
    L19:
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        if (TextUtils.isEmpty(r10.appIcon) == true) goto L10;
        int r13 = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.app_icon_size);     // Catch: Exception -> L8
        String r14 = ImageLoader.j(r10.appIcon, r13, r13);     // Catch: Exception -> L8
        r12 = x8.b.c().getBitmap(r14);     // Catch: Exception -> L8
    L10:
        boolean r15 = false;
        if (r12 != null) goto L15;
        PackageInfo r16 = BaseApplication.c().getPackageManager().getPackageInfo(r10.appPackageName, 0);     // Catch: Exception -> L8
        if (r16 == null) goto L15;
        r12 = e.Y(e.p(r16.applicationInfo.loadIcon(BaseApplication.c().getPackageManager())), BaseApplication.c().getResources().getFloat(R$dimen.app_list_icon_corner_radius));     // Catch: Exception -> L8
        r15 = true;
    L15:
        return com.bytedanceos.common.utils.f.c(r12, 90, r15);
    }

    public final PendingIntent j() {
        Intent r10 = BaseApplication.c().getPackageManager().getLaunchIntentForPackage(n());
        if (r10 != null) goto L6;
        j.a("openIntent is null");
        return null;
    L6:
        r10.setFlags(270532608);
        return PendingIntent.getActivity(BaseApplication.c(), 0, r10, 167772160);
    }

    public final Bitmap k(String r10, int r11, int r12) {
        return null;
    }

    public String l(String r10, int r11) {
        if (r11 == 198) goto L12;
        if (r11 == 199) goto L15;
        if (r11 == 701) goto L14;
        return BaseApplication.c().getString(R$string.app_download_failed, new Object[]{r10});
    L14:
        return BaseApplication.c().getString(R$string.install_failed_file_no_find, new Object[]{r10});
    L15:
        return BaseApplication.c().getString(R$string.download_failed_no_sdcard, new Object[]{r10});
    L12:
        return BaseApplication.c().getString(R$string.download_failed_no_enough_sdcard, new Object[]{r10});
    }

    public final String m(int r10) {
        if (r10 == (-115)) goto L28;
        if (r10 == (-26)) goto L35;
        if (r10 == (-7)) goto L34;
        if (r10 == (-4)) goto L33;
        if (r10 == 1) goto L32;
        if (r10 == 4) goto L31;
        if (r10 == 404) goto L30;
        if (r10 == 1004) goto L30;
        if (r10 == 1008) goto L30;
        return BaseApplication.c().getString(R$string.download_failed_network_exception);
    L30:
        return BaseApplication.c().getString(R$string.download_failed_network_exception);
    L31:
        return BaseApplication.c().getString(R$string.download_failed_package_null);
    L32:
        return BaseApplication.c().getString(R$string.download_failed_package_error);
    L33:
        return BaseApplication.c().getString(R$string.install_failed_insufficent_storage);
    L34:
        return BaseApplication.c().getString(R$string.update_failed_sign_content);
    L35:
        return BaseApplication.c().getString(R$string.download_failed_target_sdk_down);
    L28:
        return BaseApplication.c().getString(R$string.install_failed_unknown);
    }

    public abstract String n();

    public String o(String r10, int r11) {
        if (r11 == (-4)) goto L9;
        if (r11 == 701) goto L11;
        return BaseApplication.c().getString(R$string.install_failed_try_again, new Object[]{r10});
    L11:
        return BaseApplication.c().getString(R$string.install_failed_file_no_find, new Object[]{r10});
    L9:
        return BaseApplication.c().getString(R$string.install_failed_no_enough_space, new Object[]{r10});
    }

    public abstract int p();

    public final PendingIntent q(String r10, AppInfo r11) {
        Intent r12 = r(r10, r11);
        r12.setAction(r10);
        if (r11 != null) goto L5;
    L7:
        r12.putExtra(DownloadInfoColumns.TABLE, r11);
        return PendingIntent.getActivity(BaseApplication.c(), 0, r12, 167772160);
    L5:
        if (r11.isAutoDownload == false) goto L7;
        r11.isAutoDownload = false;
        goto L7
    }

    public abstract Intent r(String r10, AppInfo r11);

    public abstract PendingIntent s();

    public String t(String r10, int r11) {
        if (r11 == (-115)) goto L11;
        if (r11 == (-4)) goto L11;
        if (r11 == 701) goto L13;
        return BaseApplication.c().getString(R$string.failed_task2, new Object[]{r10});
    L13:
        return BaseApplication.c().getString(R$string.update_failed_file_no_find, new Object[]{r10});
    L11:
        return BaseApplication.c().getString(R$string.update_failed_no_enough_space, new Object[]{r10});
    }

    public abstract PendingIntent u();

    public abstract int v();

    public final boolean x(String r10) {
        StatusBarNotification[] r11 = ReflectTool.getActiveNotifications(this.f10071b);     // Catch: Exception -> L24
        if (r11 != null) goto L6;
    L18:
        int r12 = 0;
        boolean r13 = false;
    L20:
        if (r12 != 2) goto L32;
        if (r13 == true) goto L23;
        return false;
    L23:
        return true;
    L32:
        return false;
    L6:
        if (r11.length <= 0) goto L18;
        int r14 = 0;
        r12 = 0;
        r13 = false;
    L9:
        if (r14 >= r11.length) goto L20;
        if (n().equals(r11[r14].getNotification().getGroup()) == false) goto L17;
        r12 = r12 + 1;     // Catch: Exception -> L24
        if (r13 == true) goto L17;
        if (r10.equals(r11[r14].getTag()) == false) goto L17;
        r13 = true;
    L17:
        r14 = r14 + 1;
    L34:
        return false;
    }

    public abstract void y();

    public void z(String r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putString("exposure_notifications_type", r11);
        f9.b.b(r10, r12);
    }
}
