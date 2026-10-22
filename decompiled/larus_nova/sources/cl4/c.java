package cl4;

import com.bytedance.dora.wlan.model.DoraWifiScene;
import java.util.HashMap;
import pk4.l;
import zk4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static void a(k r110) {
        long r100 = r110.f572648i;
        long r101 = 0;
        if (r100 <= 0) goto L7;
        long r102 = r110.f572649j;
        if (r102 <= 0) goto L7;
        long r103 = r102 - r100;
    L8:
        long r104 = r110.f572650k;
        if (r104 <= 0) goto L13;
        long r105 = r110.f572651l;
        if (r105 <= 0) goto L13;
        r101 = r105 - r104;
    L13:
        long r106 = r110.f572652m;
        long r107 = r110.f572653n;
        long r108 = ((r103 + r101) + r106) + r107;
        r110.f572654o = r108;
        String r111 = r110.f572644e;
        int r112 = r110.f572647h;
        String r113 = r110.f572646g;
        DoraWifiScene r114 = r110.f572645f;
        if (r114 != null) goto L16;
        String r115 = "";
    L17:
        String r109 = r110.b();
        pk4.j.d("DoraWifiSoftApTracker", "reportConnectSpend() called with: connectionId = [" + r111 + "], t0 = [" + r103 + "], t1 = [" + r101 + "], t2 = [" + r106 + "], t3 = [" + r107 + "], connectCost = [" + r108 + "], result = [" + r112 + "], scene = [" + r115 + "], reason = [" + r113 + "], events = [" + r109 + "]");
        HashMap r116 = new HashMap();
        r116.put("connectionID", r111);
        r116.put("t0", Long.valueOf(r103));
        r116.put("t1", Long.valueOf(r101));
        r116.put("t2", Long.valueOf(r106));
        r116.put("t3", Long.valueOf(r107));
        r116.put("connect_cost", Long.valueOf(r108));
        r116.put("result", Integer.valueOf(r112));
        r116.put("reason", r113);
        r116.put("scene", r115);
        r116.put("events", r109);
        l.c("d_wifi_softap_connect_spend", r116);
        return;
    L16:
        r115 = r114.name();
    L7:
        r103 = 0;
        goto L8
    }

    public static void b(k r100) {
        DoraWifiScene r101 = r100.f572645f;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.f572644e;
        long r104 = r100.f572656q - r100.f572655p;
        String r105 = r100.f572643d;
        String r106 = r100.b();
        pk4.j.d("DoraWifiSoftApTracker", "reportDisconnect() called with: connectionId = [" + r103 + "], duration = [" + r104 + "], reason = [" + r105 + "], scene = [" + r102 + "], events = [" + r106 + "]");
        HashMap r107 = new HashMap();
        r107.put("scene", r102);
        r107.put("connectionID", r103);
        r107.put("duration", Long.valueOf(r104));
        r107.put("reason", r105);
        r107.put("events", r106);
        l.c("d_wifi_softap_disconnect", r107);
        return;
    L5:
        r102 = r101.name();
        goto L6
    }
}
