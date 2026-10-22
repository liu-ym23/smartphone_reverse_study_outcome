package cl4;

import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.model.DoraWifiType;
import java.util.HashMap;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class d {
    public static void a(xk4.a r110) {
        String r100 = r110.f564192d;
        long r101 = r110.f564193e;
        int r102 = r110.f564194f;
        long r103 = r110.f564195g;
        long r104 = r101 + r103;
        String r105 = r110.f564196h;
        String r111 = r110.f564197i;
        DoraWifiType r112 = r110.f564198j;
        String r113 = "";
        if (r112 != null) goto L5;
        String r114 = "";
    L6:
        String r115 = r110.f564199k;
        int r116 = r110.f564201m;
        DoraWifiScene r117 = r110.f564202n;
        if (r117 == null) goto L10;
        r113 = r117.name();
    L10:
        String r118 = r110.f564203o;
        String r106 = r110.b();
        pk4.j.d("DoraWifiTracker", "reportWifiConnectSpend() called with: connectionID = [" + r100 + "], p2pDuration = [" + r101 + "], p2pChannel = [" + r102 + "], softapDuration = [" + r103 + "], connectCost = [" + r104 + "], p2pReason = [" + r105 + "], softapReason = [" + r111 + "], lastLinkType = [" + r114 + "], reason = [" + r115 + "], result = [" + r116 + "], scene = [" + r113 + "], primaryWifiType = [" + r118 + "], events = [" + r106 + "]");
        HashMap r107 = new HashMap();
        r107.put("connectionID", r100);
        r107.put("p2p_duration", Long.valueOf(r101));
        r107.put("p2p_channel", Integer.valueOf(r102));
        r107.put("softap_duration", Long.valueOf(r103));
        r107.put("connect_cost", Long.valueOf(r104));
        r107.put("p2p_reason", r105);
        r107.put("softap_reason", r111);
        r107.put("last_link_type", r114);
        r107.put("reason", r115);
        r107.put("result", Integer.valueOf(r116));
        r107.put("scene", r113);
        r107.put("primary_wifi_type", r118);
        r107.put("events", r106);
        l.c("d_wifi_connect_spend", r107);
        return;
    L5:
        r114 = r112.name();
        goto L6
    }

    public static void b(xk4.a r100) {
        DoraWifiScene r101 = r100.f564202n;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.f564192d;
        long r104 = r100.f564206r - r100.f564205q;
        String r105 = r100.f564200l;
        String r106 = r100.b();
        pk4.j.d("DoraWifiTracker", "reportWifiDisconnect() called with: connectionID = [" + r103 + "], duration = [" + r104 + "], reason = [" + r105 + "], scene = [" + r102 + "], events = [" + r106 + "]");
        HashMap r107 = new HashMap();
        r107.put("scene", r102);
        r107.put("connectionID", r103);
        r107.put("duration", Long.valueOf(r104));
        r107.put("reason", r105);
        r107.put("events", r106);
        l.c("d_wifi_disconnect", r107);
        return;
    L5:
        r102 = r101.name();
        goto L6
    }
}
