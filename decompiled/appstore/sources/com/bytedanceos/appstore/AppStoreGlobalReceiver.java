package com.bytedanceos.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.ReflectTool;
import java.util.ArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreGlobalReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f8257b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppStoreGlobalReceiverKtx f8258a;

    public class a extends Handler {

        /* JADX INFO: renamed from: com.bytedanceos.appstore.AppStoreGlobalReceiver$a$a, reason: collision with other inner class name */
        public class RunnableC0106a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f8259a;

            public RunnableC0106a(a r10) {
                this.f8259a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONArray r10 = e8.a.i(BaseApplication.c());
                d9.a.e().k(r10.toString());
                b0.n().F("last_report_app_lists_time", System.currentTimeMillis(), null, BaseApplication.c());
            }
        }

        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            j.n("[AutoUpdate] AppStoreGlobalReceiver AUTO_UPDATE_COLLECTION_APPS " + r10.toString());
            switch(r10.what) {
                case 1: goto L27;
                case 2: goto L21;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L6;
                default: goto L39;
            };
        L10:
            new Thread(new com.bytedanceos.appstore.network.b(BaseApplication.c())).start();
            return;
        L11:
            String r11 = (String) r10.obj;
            b0.n().H("last_day", r11, null, BaseApplication.c());
            j.a("dateTime:" + r11);
            return;
        L12:
            b8.a.f(BaseApplication.c()).e();
            return;
        L13:
            j.n("AUTO_DOWNLOAD_WIFI_APPS");
            com.bytedanceos.appstore.utils.a.G();
            return;
        L14:
            j.n("AUTO_UPDATE_MY_APPS");
            ArrayList r12 = com.bytedanceos.appstore.utils.b.h0((String) r10.obj);
            if (r12 != null) goto L17;
            return;
        L17:
            if (r12.isEmpty() == true) goto L29;
            com.bytedanceos.appstore.datacache.a.N0().q0(r12, true);
            return;
        L29:
            return;
        L21:
            j.n("AUTO_UPDATE_COLLECTION_APPS");
            AppInfo r13 = com.bytedanceos.appstore.utils.b.g0((String) r10.obj);
            if (r13 != null) goto L24;
            return;
        L24:
            if (r13.isCollected == false) goto L26;
            com.bytedanceos.appstore.datacache.a.N0().f(r13);
            return;
        L26:
            com.bytedanceos.appstore.datacache.a.N0().r0(r13);
            return;
        L27:
            boolean r14 = ((Boolean) r10.obj).booleanValue();
            j.n("[AutoUpdate] set AUTO_UPDATE_LAST_TIME_KEY, AppStoreGlobalReceiver");
            b0.n().F(ServerElements.LAST_UPDATE_TIME, System.currentTimeMillis(), null, BaseApplication.c());
            com.bytedanceos.appstore.datacache.a.N0().Y0("AppStoreGlobalReceiver", r14);
            return;
        L39:
            return;
        L6:
            if (AppStoreGlobalReceiver.a() == true) goto L9;
            j.a("no need report tracker info");
            return;
        L9:
            new Thread(new RunnableC0106a(this)).start();
        }
    }

    static {
        f8257b = new a();
    }

    public AppStoreGlobalReceiver() {
        this.f8258a = new AppStoreGlobalReceiverKtx();
    }

    public static /* synthetic */ boolean a() {
        return b();
    }

    public static boolean b() {
        long r10 = b0.n().p("last_report_app_lists_time", null, BaseApplication.c());
        long r11 = System.currentTimeMillis();
        StringBuilder r12 = new StringBuilder();
        r12.append("check report tracker lastTime[");
        r12.append(r10);
        r12.append("],nowTime[");
        r12.append(r11);
        r12.append("],(nowTime - lastTime)[");
        long r13 = r11 - r10;
        r12.append(r13);
        r12.append("]");
        j.a(r12.toString());
        if (r13 < 86400000) goto L5;
        return true;
    L5:
        return false;
    }

    public static AppInfo c(Intent r10) {
        AppInfo r11 = new AppInfo();
        r11.appDownloadUrl = r10.getStringExtra("Url");
        r11.appPackageName = r10.getStringExtra("PackageName");
        r11.appName = r10.getStringExtra("AppName");
        r11.appSource = "gloable_search";
        r11.tabSource = "gloable_search";
        r11.mSourcePkgName = "com.bytedanceos.quicksearch";
        String r12 = r10.getStringExtra("params");
        boolean r13 = false;
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r11.appCategoryName = "";
        r11.appScores = 0.0f;
        r11.mIsNeedGms = false;
        r11.mAppType = 0;
    L26:
        return r11;
    L5:
        String[] r14 = r12.split("#");
        int r15 = r14.length;
        if (r15 <= 0) goto L9;
        r11.appCategoryName = r14[0];
    L9:
        if (r15 <= 1) goto L12;
        r11.appScores = Float.valueOf(r14[1]).floatValue();
    L12:
        if (r15 <= 3) goto L18;
        if (c0.b(r14[3]) != 1) goto L16;
        r13 = true;
    L16:
        r11.mIsNeedGms = r13;
    L18:
        if (r15 <= 4) goto L21;
        r11.appIcon = r14[4];
    L21:
        if (r15 <= 5) goto L24;
        r11.mAppType = c0.b(r14[5]);
    L24:
        if (r15 <= 6) goto L26;
        r11.appBytes = c0.b(r14[6]);
        goto L26
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        j.n("Intent:" + r11);
        BaseApplication.u("AppStoreGlobalReceiver", false);
        String r12 = r11.getAction();
        if (TextUtils.equals(r12, "com.bytedanceos.appstore.AUTO_UPLOAD_APPS") == false) goto L9;
        if (f8257b.hasMessages(5) == false) goto L7;
        f8257b.removeMessages(5);
    L7:
        f8257b.sendEmptyMessageDelayed(5, 1000);
    L63:
        BaseApplication.u("AppStoreGlobalReceiver", true);
        return;
    L9:
        if (TextUtils.equals(r12, "com.bytedanceos.appstore.sync.update.apps") == false) goto L11;
    L59:
        j.n("[AutoUpdate] AppStoreGlobalReceiver onReceive ACTION_AUTO_SYNC_UPDATE_APPS_APPSTORE");
        if (f8257b.hasMessages(1) == false) goto L62;
        f8257b.removeMessages(1);
    L62:
        boolean r13 = r11.getBooleanExtra("extra_push_key", false);
        Handler r14 = f8257b;
        r14.sendMessage(r14.obtainMessage(1, Boolean.valueOf(r13)));
        goto L63
    L11:
        if (TextUtils.equals(r12, "com.bytedanceos.gamestore.sync.update.apps") == true) goto L59;
        if (TextUtils.equals(r12, "com.bytedanceos.app.store.sync.collection.apps") == false) goto L17;
        String r15 = r11.getStringExtra("apps");
        Handler r16 = f8257b;
        r16.sendMessage(r16.obtainMessage(2, r15));
        goto L63
    L17:
        if (TextUtils.equals(r12, "com.bytedanceos.app.store.sync.my.apps") == false) goto L20;
        String r17 = r11.getStringExtra("apps");
        Handler r18 = f8257b;
        r18.sendMessage(r18.obtainMessage(3, r17));
        goto L63
    L20:
        if (TextUtils.equals(r12, "com.bytedanceos.app.store.sync.last.day") == false) goto L23;
        String r19 = r11.getStringExtra("apps");
        Handler r110 = f8257b;
        r110.sendMessage(r110.obtainMessage(6, r19));
        goto L63
    L23:
        if ("com.android.quicksearchbox.search.click".equals(r12) == false) goto L26;
        this.f8258a.a(r10, r11);
        goto L63
    L26:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r12) == false) goto L44;
        NetworkInfo r20 = (NetworkInfo) r11.getParcelableExtra("networkInfo");
        if (r20 != null) goto L32;
        j.a("NetworkInfo is null");
        return;
    L32:
        if (r20.isConnected() == false) goto L63;
        if (r20.getType() != 1) goto L40;
        if (f8257b.hasMessages(5) == false) goto L38;
        f8257b.removeMessages(5);
    L38:
        f8257b.sendEmptyMessageDelayed(5, 1000);
        f8257b.sendEmptyMessage(4);
    L40:
        if (f8257b.hasMessages(7) == false) goto L42;
        f8257b.removeMessages(7);
    L42:
        f8257b.sendEmptyMessageDelayed(7, 1000);
        com.bytedanceos.appstore.utils.a.u();
        goto L63
    L44:
        if ("com.bytedanceos.appstore.auto_report_tracker_info".equalsIgnoreCase(r12) == false) goto L50;
        if (f8257b.hasMessages(8) == false) goto L48;
        f8257b.removeMessages(8);
    L48:
        f8257b.sendEmptyMessage(8);
        goto L63
    L50:
        if ("com.bytedanceos.appstore.clean_up_storage".equals(r12) == false) goto L53;
        r10.sendBroadcast(new Intent("com.bytedanceos.gamestore.dismiss_clean_up_storage_notification").setClassName("com.bytedanceos.gamestore", "com.bytedanceos.gamestore.GameStoreGlobalReceiver"));
        ReflectTool.goToCleanerSafely(r10, false);
        goto L63
    L53:
        if ("com.bytedanceos.appstore.dismiss_clean_up_storage_notification".equals(r12) == false) goto L56;
        a8.a.N().b("18", 0);
        goto L63
    L56:
        if ("com.bytedanceos.appstore.full_storage".equals(r12) == false) goto L58;
        ReflectTool.goToCleanerSafely(r10, false);
        goto L63
    L58:
        "com.android.applist.download".equals(r12);
        goto L63
    }
}
