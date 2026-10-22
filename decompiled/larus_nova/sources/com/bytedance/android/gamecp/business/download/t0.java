package com.bytedance.android.gamecp.business.download;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.format.Formatter;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wu.d3;

/* JADX INFO: loaded from: classes44.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NotificationManager f52932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p f52933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f52934c;

    public static final class a implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f52935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f52936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f52937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f52938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f52939e;

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void a(JSONObject r100) {
        }

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void b(List<p> r110) {
            Intrinsics.checkNotNullParameter(r110, "downloadList");
            Iterator<p> r100 = r110.iterator();
        L4:
            if (r100.hasNext() == false) goto L18;
            p r101 = r100.next();
            int r102 = r101.f52880w0;
            if (r102 == 6) goto L9;
            if (r102 != 3) goto L4;
        L9:
            NotificationManager r103 = t0.f52932a;
            StringBuilder r104 = new StringBuilder("showFileCacheCleanTips: ");
            int r105 = com.bytedance.android.gamecp.common.utils.o.f57249a;
            r104.append(com.bytedance.android.gamecp.common.utils.o.a(r101.f52840c0));
            r104.append(" ---- ");
            r104.append(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getExternalFilesDir("Download"));
            r104.append('/');
            r104.append(com.bytedance.android.gamecp.common.utils.o.a(r101.f52840c0));
            t0.c(r104.toString());
            PolarisFileWrapper r106 = new PolarisFileWrapper(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getExternalFilesDir("Download") + '/' + com.bytedance.android.gamecp.common.utils.o.a(r101.f52840c0));
            if (r106.exists() == true) goto L13;
            r106 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + "/ByteDownload");
        L13:
            if (r106.exists() == false) goto L4;
            if ((System.currentTimeMillis() - r106.lastModified()) <= ((((d3.f561297a.getValue().a() * 24) * 60) * 60) * 1000)) goto L17;
            this.f52935a.add(r101);
            t0.c("downloadedList size: " + this.f52935a.size() + "----data: " + this.f52935a);
        L17:
            t0.c("sysTime: " + System.currentTimeMillis() + "----lastModified: " + r106.lastModified() + "----差值: " + (System.currentTimeMillis() - r106.lastModified()));
            Ref.LongRef r107 = this.f52936b;
            r107.element = r107.element + r106.length();
            goto L4
        L18:
            NotificationManager r108 = t0.f52932a;
            t0.c("sum: " + t0.d(this.f52936b.element));
            t0.c("downloadedList size: " + this.f52935a.size() + "----data: " + this.f52935a);
            if ((!this.f52935a.isEmpty()) == false) goto L24;
            double r109 = (this.f52937c.G0.f52918b * d3.f561297a.getValue().b()) - IOUtils.getAvailableBytes(Environment.getExternalStorageDirectory().getPath());
            long r111 = this.f52936b.element;
            if ((r111 - r109) <= 0) goto L23;
            t0.a(1, this.f52937c, r111, this.f52935a, Boolean.valueOf(this.f52938d));
        L25:
            t0.f(this.f52937c.f52866p0, this.f52939e.element, true);
            return;
        L23:
            t0.a(2, this.f52937c, r111, this.f52935a, Boolean.valueOf(this.f52938d));
            goto L25
        L24:
            t0.a(3, this.f52937c, this.f52936b.element, this.f52935a, Boolean.valueOf(this.f52938d));
            goto L25
        }

        public a(ArrayList r100, Ref.LongRef r101, p r102, boolean r103, Ref.LongRef r104) {
            this.f52935a = r100;
            this.f52936b = r101;
            this.f52937c = r102;
            this.f52938d = r103;
            this.f52939e = r104;
        }
    }

    public t0() {
    }

    static {
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().y0(new s0());
    }

    public static void h() {
        if (d3.f561297a.getValue().c() == true) goto L5;
        return;
    L5:
        Activity r100 = com.bytedance.android.gamecp.common.utils.c.b();
        if (r100 == null) goto L9;
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().M0(r100);
        return;
    }

    public static void b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadInfo");
        if (d3.f561297a.getValue().c() == true) goto L5;
        return;
    L5:
        c("checkStorage: 游戏大小----" + d(r100.G0.f52918b));
        if (e(r100.G0.f52918b, Boolean.FALSE) == true) goto L9;
        h();
        ns.a.a();
        com.bytedance.gamecenter.base.q.l().getClass();
        com.bytedance.gamecenter.base.q.e();
        return;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        cs.a.a();
    }

    public static String d(long r100) {
        return StringsKt.replace$default(Formatter.formatFileSize(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext(), r100), " ", "", false, 4, null);
    }

    public static boolean e(long r100, Boolean r101) {
        c("isStorageEnable: 手机剩余空间---" + Formatter.formatFileSize(com.bytedance.android.gamecp.common.utils.c.b(), IOUtils.getAvailableBytes(Environment.getExternalStorageDirectory().getPath())));
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L5;
        double r102 = d3.f561297a.getValue().b() - ((double) 1);
    L7:
        if ((r102 * r100) >= IOUtils.getAvailableBytes(Environment.getExternalStorageDirectory().getPath())) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = d3.f561297a.getValue().b();
        goto L7
    }

    public static void g(p r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "downloadInfo");
        d3 r100 = d3.f561297a;
        if (r100.getValue().c() == true) goto L5;
        return;
    L5:
        String r101 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getSharedPreferences("gamecp.SP_FILE_CACHE_CLEAN", 0).getString(r110.f52866p0, "");
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        Ref.LongRef r102 = new Ref.LongRef();
        r102.element = System.currentTimeMillis();
        if (r101.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L24;
        JSONObject r104 = new JSONObject(r101);
        r102.element = r104.optLong("click_start_time");
        if (r104.optBoolean("is_clear") == false) goto L24;
        Intrinsics.checkNotNullParameter("showFileCacheCleanTips: 命中频控，不再弹窗", "content");
        cs.a.a();
        if (r100.getValue().g() == true) goto L18;
        return;
    L18:
        if ((System.currentTimeMillis() - f52934c) <= 500) goto L68;
        Activity r105 = com.bytedance.android.gamecp.common.utils.c.b();
        if (r105 == null) goto L22;
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().centerToast(r105, com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_space_not_enough), 3000);
    L22:
        f52934c = System.currentTimeMillis();
        return;
    L68:
        return;
    L24:
        c("showFileCacheCleanTips: DownloadInfo大小---" + d(r110.G0.f52918b) + "---点击下载的时间：" + r102.element + "----isFromInstall: " + r111);
        if ((System.currentTimeMillis() - r102.element) >= r100.getValue().f()) goto L27;
        ArrayList r106 = new ArrayList();
        Ref.LongRef r107 = new Ref.LongRef();
        r107.element = 0;
        y0 r108 = y0.f52963a;
        y0.d(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext(), "", new a(r106, r107, r110, r111, r102));
        return;
    L27:
        if (r111 == false) goto L30;
        return;
    L30:
        if (com.bytedance.android.gamecp.common.utils.e.a() == false) goto L36;
        if (r100.getValue().d() == true) goto L34;
        return;
    L34:
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().X1(new com.bytedance.android.gamecp.host_api.model.i(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_inner_push_title), com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_inner_push_content), com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_inner_push_btn), r110.f52838b0, r110.f52855k, r110.f52836a0));
    L65:
        f(r110.f52866p0, r102.element, true);
        return;
    L36:
        if (r100.getValue().e() == true) goto L38;
        return;
    L38:
        Context r109 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        c("createNotificationForHigh: 游戏名---" + r110.f52836a0);
        if (f52932a != null) goto L44;
        Object r112 = r109.getSystemService("notification");
        if ((r112 instanceof NotificationManager) == true) goto L43;
        r112 = null;
    L43:
        f52932a = (NotificationManager) r112;
    L44:
        PendingIntent r113 = PendingIntent.getActivity(r109, 0, new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"), 67108864);
        int r114 = Build.VERSION.SDK_INT;
        if (r114 < 26) goto L50;
        NotificationChannel r115 = new NotificationChannel("gamecp_push_channel", "抖音游戏", 4);
        r115.setShowBadge(true);
        r115.enableLights(true);
        r115.enableVibration(true);
        r115.setLockscreenVisibility(-1);
        NotificationManager r116 = f52932a;
        if (r116 == null) goto L50;
        r116.createNotificationChannel(r115);
    L50:
        if (r110.f52836a0.length() <= 6) goto L56;
        StringBuilder r117 = new StringBuilder();
        String r118 = r110.f52836a0;
        if (r118 == null) goto L55;
        r117.append(r118.substring(0, 7));
        r117.append("...");
        String r119 = r117.toString();
    L57:
        NotificationCompat.Builder r120 = new NotificationCompat.Builder(r109, "gamecp_push_channel");
        StringCompanionObject r121 = StringCompanionObject.INSTANCE;
        NotificationCompat.Builder r122 = r120.setContentTitle(String.format(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_pause), Arrays.copyOf(new Object[]{r119}, 1))).setContentText(com.bytedance.android.gamecp.common.utils.y0.i(R.string.gamecp_file_cache_clean_dialog_open_setting2)).setAutoCancel(true).setNumber(999);
        com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppIcon();
        NotificationCompat.Builder r123 = r122.setSmallIcon(0).setContentIntent(r113).setCategory("msg").setVisibility(0);
        if (NotificationManagerCompat.from(r109).areNotificationsEnabled() == false) goto L60;
    L62:
        NotificationManager r124 = f52932a;
        if (r124 == null) goto L65;
        r124.notify(6000, r123.build());
        goto L65
    L60:
        if (r114 < 33) goto L62;
        Activity r125 = com.bytedance.android.gamecp.common.utils.g.a(r109);
        TokenCert r126 = ru.j.f539228a;
        ru.j.b r127 = new ru.j.b(r125);
        r127.f539231c = new tu.d();
        r127.a(new r0(r123), ru.j.f539228a, new String[]{"android.permission.POST_NOTIFICATIONS"});
        goto L65
    L55:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L56:
        r119 = r110.f52836a0;
        goto L57
    L11:
        r103 = false;
        goto L12
    }

    public static void f(String r100, long r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        r103.put("click_start_time", r101);
        r103.put("is_clear", r102);
        com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getSharedPreferences("gamecp.SP_FILE_CACHE_CLEAN", 0).edit().putString(r100, r103.toString()).apply();
    }

    public static final void a(int r100, p r110, long r111, ArrayList r112, Boolean r113) {
        Activity r101 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getTopActivity();
        if (r101 == null) goto L13;
        FileCacheCleanDialog r102 = new FileCacheCleanDialog(r101, r100, r110, r111, r112, r113);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        return;
    }
}
