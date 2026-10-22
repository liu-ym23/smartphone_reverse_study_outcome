package ch4;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.m;
import com.bytedance.crash.upload.n;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fh4.g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import zg4.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f23766b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f23767a;

    /* JADX INFO: loaded from: classes15.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f23769b;

        @Override // java.lang.Runnable
        public final void run() {
            if (CrashUploader.h(this.f23768a, this.f23769b) == false) goto L9;
            m.b().d();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        public a(String r100, JSONObject r101) {
            this.f23768a = r100;
            this.f23769b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f23770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f23771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f23772c;

        public final void a() {
            c r100 = c.f23766b;
            if (r100 == null) goto L9;
            com.bytedance.crash.monitor.a r101 = j.f203315a;
            if (r101 == null) goto L7;
            HashMap r102 = new HashMap();
            r102.put("aid", r101.a());
            r102.put("device_id", r101.d("0"));
            r102.put("update_version_code", String.valueOf(r101.f()));
            r102.put("version_code", String.valueOf(r101.i()));
            r102.put("app_version", String.valueOf(r101.j()));
            r102.put("channel", r101.b());
            r102.put("npth_version", h.f572084a);
            com.bytedance.crash.util.j.i(this.f23770a, r102);
        L7:
            r100.f23767a.k(this.f23772c, 1, this.f23770a, this.f23771b);
            return;
        }

        public b(String r100) {
            this.f23771b = new JSONObject();
            this.f23772c = r100;
            this.f23770a = new JSONObject();
        }

        public b(JSONObject r100) {
            this.f23771b = new JSONObject();
            this.f23772c = "crash_data_check";
            this.f23770a = r100;
        }
    }

    public c(Context r100) {
        f r101 = j.a(r100, AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON, 4020259, 4020259, h.f572084a);
        this.f23767a = r101;
        r101.f203295g = "release";
        com.bytedance.crash.monitor.a r102 = j.f203315a;
        if (r102 == null) goto L6;
        r101.f203294f = r102.d("0");
        return;
    }

    public static void c(Throwable r100) {
        b("NPTH_CATCH_NEW", r100);
    }

    public static void a(String r110, Throwable r111) {
        c r100 = f23766b;
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = r100.f23767a;
        g r102 = new g(r111, null, 0, r110, null, ThreadMethodProxy.currentThread().getName(), "core_exception_monitor");     // Catch: Throwable -> L10
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L10
        JSONArray r113 = new JSONArray();     // Catch: Throwable -> L10
        r113.put(r102.e(r101));     // Catch: Throwable -> L10
        r112.put("data", r113);     // Catch: Throwable -> L10
        int r114 = Process.myPid();     // Catch: Throwable -> L10
        JSONObject r115 = Header.b(r101, System.currentTimeMillis(), CrashType.ENSURE, r114).f203195a;     // Catch: Throwable -> L10
        r112.put("header", r115);     // Catch: Throwable -> L10
        String r116 = n.d(zg4.g.f572072l.f572076d, r115);     // Catch: Throwable -> L10
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L13;
        wh4.b.post(new a(r116, r112));     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    public static void b(String r100, Throwable r101) {
        c r102 = f23766b;
        if (r102 == null) goto L6;
        r102.f23767a.e().g(r100, null, r101, "core_exception_monitor");
        return;
    }

    public static void d(String r100, Throwable r101) {
        long r102 = new StatFs(Environment.getDataDirectory().getPath()).getFreeBytes();     // Catch: Throwable -> L4
    L6:
        if (r102 >= 25165824) goto L8;
        boolean r103 = true;
    L9:
        c r104 = f23766b;
        if (r104 == null) goto L15;
        String r105 = r100 + "_" + r103;
        r104.f23767a.e().g(r105, null, r101, "core_exception_monitor");
        return;
    L15:
        return;
    L8:
        r103 = false;
    L4:
        r102 = 0;
        goto L6
    }
}
