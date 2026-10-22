package cl4;

import android.os.Handler;
import com.bytedance.dora.wlan.trace.DoraStationEvent;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f24101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cl4.a f24102b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24103a = null;

        static {
            int[] r100 = new int[DoraStationEvent.values().length];
            f24103a = r100;
            r100[DoraStationEvent.notConnected.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f24103a[DoraStationEvent.connectionSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f24104a = null;

        static {
            f24104a = new j();
        }
    }

    public j() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("background_thread_utils");
        ThreadMethodProxy.start(r100);
        this.f24101a = new Handler(r100.getLooper());
    }

    public static void b(cl4.a r100, String r101) {
        String r102 = r100.f24086a.toString();
        int r103 = (int) (System.currentTimeMillis() - r100.f24090e);
        HashMap r104 = new HashMap();
        r104.put("connectionID", r102);
        r104.put("duration", Integer.valueOf(r103));
        r104.put("reason", r101);
        l.c("d_wifi_station_disconnect", r104);
    }

    public static void a(cl4.a r100, boolean r110, String r111) {
        String r101 = r100.f24086a.toString();
        int r102 = (int) Math.max(r100.f24088c - r100.f24087b, 0);
        int r103 = (int) Math.max(r100.f24089d - r100.f24088c, 0);
        int r104 = (int) Math.max(r100.f24090e - r100.f24089d, 0);
        String r105 = r100.f24091f.toString();
        HashMap r106 = new HashMap();
        r106.put("connectionID", r101);
        r106.put("t0", Integer.valueOf(r102));
        r106.put("t1", Integer.valueOf(r103));
        r106.put("t2", Integer.valueOf(r104));
        r106.put("connect_cost", Integer.valueOf((r102 + r103) + r104));
        if (r110 == false) goto L5;
        String r112 = "1";
    L6:
        r106.put("result", r112);
        r106.put("reason", r111);
        r106.put("events", r105);
        l.c("d_wifi_station_connect_spend", r106);
        return;
    L5:
        r112 = "2";
        goto L6
    }
}
