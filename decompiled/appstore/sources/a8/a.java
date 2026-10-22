package a8;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedanceos.appstore.AppStoreGlobalReceiver;
import com.bytedanceos.appstore.buss.entity.ApiType;
import com.bytedanceos.appstore.ui.MainActivity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.NotificationInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.n;
import com.bytedanceos.common.toolbox.o;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.R;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f65e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f66d;

    public a() {
        this.f66d = 1000;
        this.f10071b = (NotificationManager) BaseApplication.c().getSystemService("notification");
    }

    public static synchronized a N() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f65e != null) goto L9;
        f65e = new a();     // Catch: Throwable -> L7
    L9:
        a r10 = f65e;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }

    @Override // com.bytedanceos.common.toolbox.o
    public void A() {
        Intent r10 = new Intent("com.bytedanceos.appstore.full_storage").setClass(BaseApplication.c(), AppStoreGlobalReceiver.class);
        PendingIntent r11 = PendingIntent.getBroadcast(BaseApplication.c(), 12, r10, 167772160);
        M("show_disk_full", null, R.drawable.stat_sys_download_done, BaseApplication.c().getString(R.string.clear_notify_ticket), BaseApplication.c().getString(R.string.clear_notify_msg), r11);
        z("exposure_notifications", "notifications_full_disk");
    }

    public void O(AppInfo r10, int r11) {
        H(15, r10, r11);
    }

    public void P(AppInfo r10, int r11) {
        H(13, r10, r11);
    }

    public void Q(AppInfo r10, int r11) {
        H(14, r10, r11);
    }

    public void R(NotificationInfo r10) {
        if (r10 == null) goto L7;
        int r11 = r10.getDownloadCount();
        if (r11 <= 0) goto L8;
        Intent r12 = new Intent(BaseApplication.c(), MainActivity.class).setAction("com.bytedanceos.common.my").putExtra("fragment_tag", "main").putExtra("show_list", 1);
        Bundle r13 = new Bundle();
        r13.putParcelable(MemorySourceLinkType.INTENT, r12);
        r13.putInt("download_count", r11);
        r13.putString("download_apps_name", r10.getDownloadAppsName());
        I(17, null, 0, r13);
        return;
    L8:
        return;
    }

    public void S() {
        H(10, null, 0);
    }

    public void T(AppInfo r10, int r11) {
        H(12, r10, r11);
    }

    public void U(AppInfo r10) {
        H(11, r10, 0);
    }

    public void V(g8.a r10, String r11) {
        if (r10.o() == false) goto L6;
        String r12 = r10.h();
    L5:
        String r13 = r12;
        if (r10.o() == false) goto L11;
        String r14 = r10.g();
    L10:
        String r15 = r14;
        Intent r16 = new Intent("bytedanceos.appstore.recommend.app.action");
        r16.setPackage("com.obric.appstore");
        r16.setFlags(335544320);
        r16.setAction("bytedanceos.appstore.recommend.app.detail.internal");
        if (r10.n() == false) goto L15;
        r16.setClass(BaseApplication.c(), MainActivity.class);
        r16.putExtra("type", ApiType.gift);
    L16:
        J(r13, r15, r11, r10.d(), r16);
        return;
    L15:
        r16.putExtra("type", AppInfo.SEARCH_SOURCE_EXTENAL);
        r16.putExtra(AppPermissionActivity.EXTRA_APP_PKG, r10.f());
        r16.putExtra("from_package", BaseApplication.c().getPackageName());
        r16.putExtra("from_position", "source_position_notification");
        goto L16
    L11:
        r14 = r10.i();
        goto L10
    L6:
        r12 = r10.j();
        goto L5
    }

    public void W(List r10) {
        L(r10);
    }

    @Override // com.bytedanceos.common.toolbox.o
    public String n() {
        return "com.obric.appstore";
    }

    @Override // com.bytedanceos.common.toolbox.o
    public int p() {
        return 1;
    }

    @Override // com.bytedanceos.common.toolbox.o
    public Intent r(String r10, AppInfo r11) {
        Intent r12 = new Intent();
        MainActivity.a r13 = MainActivity.f9436c;     // Catch: ClassNotFoundException -> L8
        r12.setClass(BaseApplication.c(), MainActivity.class);     // Catch: ClassNotFoundException -> L8
        r12.putExtra("notification_param_key", "myapp_tab");     // Catch: ClassNotFoundException -> L8
        if (r10 != null) goto L6;
    L10:
        if (r11 == null) goto L14;
        r12.putExtra(DownloadInfoColumns.TABLE, r11);     // Catch: ClassNotFoundException -> L8
    L14:
        return r12;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r12.putExtra("Action", r10);     // Catch: ClassNotFoundException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // com.bytedanceos.common.toolbox.o
    public PendingIntent s() {
        Intent r10 = new Intent();
        r10.setPackage("com.obric.appstore");
        r10.setClass(BaseApplication.c(), MainActivity.class);
        r10.setFlags(335544320);
        r10.setAction("bytedanceos.appstore.recommend.app.detail.internal.update_all");
        r10.putExtra("type", "update");
        r10.putExtra("is_update_all_apps", true);
        return PendingIntent.getActivity(BaseApplication.c(), this.f66d, r10, 167772160);
    }

    @Override // com.bytedanceos.common.toolbox.o
    public PendingIntent u() {
        Intent r10 = new Intent();
        r10.setPackage("com.obric.appstore");
        r10.setClass(BaseApplication.c(), MainActivity.class);
        r10.setFlags(335544320);
        r10.setAction("bytedanceos.appstore.recommend.app.detail.internal");
        r10.putExtra("type", "update");
        r10.putExtra("is_update_all_apps", false);
        return PendingIntent.getActivity(BaseApplication.c(), this.f66d, r10, 167772160);
    }

    @Override // com.bytedanceos.common.toolbox.o
    public int v() {
        return this.f66d;
    }

    @Override // com.bytedanceos.common.toolbox.o
    public void y() {
        BaseApplication r10 = BaseApplication.c();
        Intent r11 = new Intent(r10, AppStoreGlobalReceiver.class);
        r11.setAction("com.bytedanceos.appstore.clean_up_storage");
        Notification r12 = new n().a(new Notification.Builder(r10).setContentTitle(r10.getString(R.string.app_name)).setContentText(r10.getString(R.string.install_fail_insufficient_storage)).setContentIntent(PendingIntent.getBroadcast(r10, 0, r11, 167772160)).setTicker(r10.getString(R.string.install_fail_insufficient_storage)).setSmallIcon(R.drawable.icon_transparent).setLargeIcon(BitmapFactory.decodeResource(r10.getResources(), R.drawable.appstore_notify_icon))).build();
        r12.flags |= 16;
        this.f10071b.notify("18", 0, r12);
    }
}
