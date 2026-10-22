package cl4;

import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.p2p.o;
import java.util.HashMap;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24093a = null;

        static {
            int[] r100 = new int[DoraWifiScene.values().length];
            f24093a = r100;
            r100[DoraWifiScene.VUI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f24093a[DoraWifiScene.OTA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f24093a[DoraWifiScene.ALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f24093a[DoraWifiScene.LOG_FROM_DEBUG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f24093a[DoraWifiScene.LOG_FROM_FEEDBACK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static int a(DoraWifiScene r100) {
        if (r100 != null) goto L5;
        return 5;
    L5:
        int r101 = a.f24093a[r100.ordinal()];
        if (r101 != 1) goto L8;
        return 1;
    L8:
        if (r101 != 2) goto L10;
        return 2;
    L10:
        if (r101 != 3) goto L12;
        return 3;
    L12:
        if (r101 == 4) goto L15;
        if (r101 == 5) goto L15;
        return 5;
    L15:
        return 4;
    }

    public static void b(o r110) {
        long r100 = r110.f204745n;
        long r101 = 0;
        if (r100 <= 0) goto L7;
        long r102 = r110.f204746o;
        if (r102 <= 0) goto L7;
        long r103 = r102 - r100;
    L8:
        long r104 = r110.f204747p;
        if (r104 <= 0) goto L13;
        long r105 = r110.f204748q;
        if (r105 <= 0) goto L13;
        long r106 = r105 - r104;
    L14:
        long r107 = r110.f204749r;
        if (r107 <= 0) goto L19;
        long r108 = r110.f204750s;
        if (r108 <= 0) goto L19;
        long r109 = r108 - r107;
    L20:
        long r111 = r110.f204751t;
        if (r111 <= 0) goto L25;
        long r112 = r110.f204752u;
        if (r112 <= 0) goto L25;
        r101 = r112 - r111;
    L25:
        long r113 = ((r103 + r106) + r109) + r101;
        r110.f204753v = r113;
        String r114 = r110.f204735d;
        int r115 = r110.f204740i;
        String r116 = r110.f204739h;
        int r117 = r110.f204741j;
        DoraWifiScene r118 = r110.f204736e;
        if (r118 != null) goto L28;
        String r119 = "";
    L29:
        String r120 = r119;
        int r121 = r110.f204743l;
        String r122 = r110.b();
        pk4.j.d("DoraWifiP2pTracker", "reportConnectSpend() called with: connectionId = [" + r114 + "], t0 = [" + r103 + "], t1 = [" + r106 + "], t2 = [" + r109 + "], t3 = [" + r101 + "], connectCost = [" + r113 + "], result = [" + r115 + "], reason = [" + r116 + "], channel = [" + r117 + "], scene = [" + r120 + "], preConnectResult = [" + r121 + "], events = [" + r122 + "]");
        HashMap r123 = new HashMap();
        r123.put("connectionID", r114);
        r123.put("t0", Long.valueOf(r103));
        r123.put("t1", Long.valueOf(r106));
        r123.put("t2", Long.valueOf(r109));
        r123.put("t3", Long.valueOf(r101));
        r123.put("connect_cost", Long.valueOf(r113));
        r123.put("result", Integer.valueOf(r115));
        r123.put("reason", r116);
        r123.put("channel", Integer.valueOf(r117));
        r123.put("scene", r120);
        r123.put("pre_connect_result", Integer.valueOf(r121));
        r123.put("events", r122);
        l.c("d_wifi_p2p_connect_spend", r123);
        return;
    L28:
        r119 = r118.name();
    L19:
        r109 = 0;
    L13:
        r106 = 0;
    L7:
        r103 = 0;
        goto L8
    }

    public static void d(o r100) {
        DoraWifiScene r101 = r100.f204736e;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.f204735d;
        long r104 = r100.f204755x - r100.f204754w;
        String r105 = r100.f204737f;
        String r106 = r100.b();
        pk4.j.d("DoraWifiP2pTracker", "reportDisconnect() called with: connectionId = [" + r103 + "], duration = [" + r104 + "], reason = [" + r105 + "], scene = [" + r102 + "], events = [" + r106 + "]");
        HashMap r107 = new HashMap();
        r107.put("scene", r102);
        r107.put("connectionID", r103);
        r107.put("duration", Long.valueOf(r104));
        r107.put("reason", r105);
        r107.put("events", r106);
        l.c("d_wifi_p2p_disconnect", r107);
        return;
    L5:
        r102 = r101.name();
        goto L6
    }

    public static void e(boolean r100, int r101, int r102, long r103) {
        HashMap r104 = new HashMap();
        r104.put("scene_type", Integer.valueOf(r101));
        r104.put("result", Integer.valueOf(r100 ? 1 : 0));
        r104.put("duration", Long.valueOf(r103));
        if (r100 == true) goto L5;
        r104.put("failure_reason", Integer.valueOf(r102));
    L5:
        l.c("d_wifi_p2p_remove_go", r104);
    }

    public static void c(boolean r100, int r101, int r102, long r103, boolean r104, int r105, int r106) {
        HashMap r107 = new HashMap();
        r107.put("wifi_connection_freq", Integer.valueOf(r101));
        r107.put("group_operating_freq", Integer.valueOf(r102));
        r107.put("duration", Long.valueOf(r103));
        r107.put("is_fallback", Integer.valueOf(r104 ? 1 : 0));
        r107.put("scene_type", Integer.valueOf(r105));
        r107.put("result", Integer.valueOf(r100 ? 1 : 0));
        if (r100 == true) goto L5;
        r107.put("failure_reason", Integer.valueOf(r106));
    L5:
        l.c("d_wifi_p2p_create_go", r107);
    }
}
