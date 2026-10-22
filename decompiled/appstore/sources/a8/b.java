package a8;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.island.IIslandTaskProvider;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.NotificationInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.o;
import com.bytedanceos.common.ui.myapplist.MyAppListData;
import java.util.Iterator;
import java.util.List;
import s8.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f67c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a f68a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppFilter f69b;

    public final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f70a;

        public a(b r10, Looper r11) {
            this.f70a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 == 1) goto L10;
            switch(r11) {
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L7;
                default: goto L16;
            };
        L6:
            a8.a.N().B((AppInfo) r10.obj);
            return;
        L7:
            a8.a.N().a(o.f10069c);
            return;
        L8:
            a8.a.N().R((NotificationInfo) r10.obj);
            return;
        L9:
            b.b(this.f70a, (Intent) r10.obj);
            return;
        L16:
            return;
        L10:
            b.a(this.f70a);
        }
    }

    public b() {
        HandlerThread r10 = new HandlerThread("NotificationThread");
        r10.start();
        this.f68a = new a(this, r10.getLooper());
        this.f69b = new s8.a(new AppFilter[]{MyAppListData.activeFilter(), new c(s8.b.c())});
    }

    public static /* synthetic */ void a(b r10) {
        r10.f();
    }

    public static /* synthetic */ void b(b r10, Intent r11) {
        r10.g(r11);
    }

    public static b e() {
        if (f67c != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f67c != null) goto L11;
        f67c = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f67c;
    }

    public final NotificationInfo c() {
        NotificationInfo r10 = new NotificationInfo();
        List r11 = com.bytedanceos.appstore.datacache.a.N0().v("DOWNLOAD");
        if (r11 != null) goto L5;
    L14:
        return r10;
    L5:
        if (r11.isEmpty() == true) goto L14;
        r11.sort(AppInfo.getComparator());
        StringBuilder r12 = new StringBuilder();
        Iterator r13 = r11.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L12;
        AppInfo r15 = (AppInfo) r13.next();
        if (this.f69b.filter(r15) == false) goto L8;
        r14 = r14 + 1;
        r12.append(r15.appName);
        r12.append("、");
        goto L8
    L12:
        if (r14 <= 0) goto L14;
        r10.setDownloadAppsName(r12.subSequence(0, r12.length() - 1).toString());
        r10.setDownloadCount(r14);
        goto L14
    }

    public final AppInfo d() {
        Iterator r10 = com.bytedanceos.appstore.datacache.a.N0().v("DOWNLOAD").iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        AppInfo r11 = (AppInfo) r10.next();
        if (this.f69b.filter(r11) == false) goto L4;
        return r11;
    L8:
        return null;
    }

    public final void f() {
        List r10 = com.bytedanceos.appstore.datacache.a.N0().v("UPDATE");
        if (r10 != null) goto L5;
    L7:
        a8.a.N().c(false);
        return;
    L5:
        if (r10.size() <= 0) goto L7;
        a8.a.N().W(r10);
    }

    public final void g(Intent r10) {
        AppInfo r11 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r11 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r10.getAction(), "bytedanceos.appstore.install.success") == false) goto L13;
        a8.a.N().U(r11);
        if (r11.mIsPushReservation == true) goto L10;
        return;
    L10:
        if (AccountDataCache.b().n() == false) goto L38;
        new g8.c(BaseApplication.c()).h(r11.appPackageName, r11.appName);
        return;
    L38:
        return;
    L13:
        int r12 = r10.getIntExtra(WsConstants.ERROR_CODE, -1);
        if (TextUtils.equals(r10.getAction(), "bytedanceos.appstore.install.failed") == false) goto L17;
        a8.a.N().T(r11, r12);
        return;
    L17:
        if ("local".equals(r11.appSource) == false) goto L19;
    L35:
        a8.a.N().P(r11, r12);
        return;
    L19:
        if ("gloable_search".equals(r11.appSource) == true) goto L35;
        if ("sys_app_force".equals(r11.appSource) == true) goto L35;
        if ("sys_app_default".equals(r11.appSource) == true) goto L35;
        if (AppInfo.SEARCH_SOURCE_EXTENAL.equals(r11.appSource) == false) goto L28;
    L34:
        a8.a.N().Q(r11, r12);
        return;
    L28:
        if ("backup".equals(r11.appSource) == true) goto L34;
        if ("gms".equals(r11.appSource) == false) goto L33;
        a8.a.N().O(r11, r12);
        return;
    L33:
        j.e("umkown appSource:" + r11.appSource);
    }

    public void h(Intent r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        String r11 = r10.getAction();
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        r11.hashCode();
        byte r12 = -1;
        switch(r11.hashCode()) {
            case -1854603679: goto L32;
            case -1697213921: goto L28;
            case -1351967724: goto L24;
            case -1004601253: goto L20;
            case 1632233699: goto L16;
            case 1935149217: goto L12;
            default: goto L35;
        };
    L35:
        switch(r12) {
            case 0: goto L65;
            case 1: goto L65;
            case 2: goto L65;
            case 3: goto L56;
            case 4: goto L38;
            case 5: goto L37;
            default: goto L84;
        };
    L37:
        this.f68a.removeMessages(1);
        this.f68a.sendEmptyMessage(1);
        return;
    L38:
        IIslandTaskProvider.onTaskProgressUpdate(r11, null);
        NotificationInfo r13 = c();
        if (r13.getDownloadCount() != 0) goto L47;
        if (this.f68a.hasMessages(6) == true) goto L44;
        this.f68a.sendEmptyMessage(6);
    L44:
        if (this.f68a.hasMessages(8) == true) goto L73;
        this.f68a.sendEmptyMessage(8);
        return;
    L73:
        return;
    L47:
        if (r13.getDownloadCount() != 1) goto L54;
        AppInfo r14 = d();
        if (r14 != null) goto L51;
        return;
    L51:
        if (r14.isAutoDownload == true) goto L76;
        this.f68a.sendMessage(this.f68a.obtainMessage(7, r14));
        return;
    L76:
        return;
    L54:
        if (this.f68a.hasMessages(5, r13) == true) goto L78;
        this.f68a.sendMessage(this.f68a.obtainMessage(5, r13));
        return;
    L78:
        return;
    L56:
        AppInfo r15 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r15 != null) goto L59;
        return;
    L59:
        if (e.x0(r15.appPackageName) == false) goto L61;
        return;
    L61:
        if (e.r0(r15) == true) goto L85;
        IIslandTaskProvider.onTaskCancel(r15);
        return;
    L85:
        return;
    L84:
        return;
    L65:
        if (o.w() == false) goto L67;
        Message r16 = this.f68a.obtainMessage(4);
        r16.obj = r10;
        this.f68a.sendMessage(r16);
    L68:
        AppInfo r17 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r17 == null) goto L83;
        IIslandTaskProvider.onTaskProgressUpdate(r11, r17);
        return;
    L83:
        return;
    L67:
        g(r10);
        goto L68
    L12:
        if (r11.equals("update_notification") == false) goto L35;
        r12 = 5;
        goto L35
    L16:
        if (r11.equals("bytedanceos.appstore.download.downloading") == false) goto L35;
        r12 = 4;
        goto L35
    L20:
        if (r11.equals("bytedanceos.appstore.download.remove") == false) goto L35;
        r12 = 3;
        goto L35
    L24:
        if (r11.equals("bytedanceos.appstore.download.failed") == false) goto L35;
        r12 = 2;
        goto L35
    L28:
        if (r11.equals("bytedanceos.appstore.install.failed") == false) goto L35;
        r12 = 1;
        goto L35
    L32:
        if (r11.equals("bytedanceos.appstore.install.success") == false) goto L35;
        r12 = 0;
        goto L35
    }
}
