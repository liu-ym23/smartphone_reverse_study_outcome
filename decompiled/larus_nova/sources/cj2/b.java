package cj2;

import android.os.SystemClock;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f23950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f23951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f23952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f23953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f23954f;

    static {
        f23949a = "";
        f23950b = -1;
    }

    public static void c() {
        d r100 = i.f47987a.get(f23949a);
        if (r100 == null) goto L6;
        r100.a("render_end");
        return;
    }

    public static void e(boolean r100) {
        f23953e = true;
        i r101 = i.f47987a;
        d r102 = r101.get(f23949a);
        if (r102 == null) goto L9;
        if (r100 == false) goto L6;
        String r103 = "1";
    L7:
        r102.b("is_complete_load", r103);
        goto L9
    L6:
        r103 = "0";
    L9:
        if (f23950b <= 0) goto L13;
        d r104 = r101.get(f23949a);
        if (r104 == null) goto L13;
        r104.b("stay_duration", Long.valueOf(SystemClock.elapsedRealtime() - f23950b));
    L13:
        d r105 = r101.get(f23949a);
        if (r105 == null) goto L16;
        r105.report();
    L16:
        f23949a = "";
        f23950b = -1;
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        d r101 = i.f47987a.get(f23949a);
        if (r101 == null) goto L6;
        r101.b("video_preload_status", r100);
        return;
    }

    public static void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        d r102 = i.f47987a.get(f23949a);
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    public static void d(String r100, String r101) {
        i r102 = i.f47987a;
        d r103 = r102.get(f23949a);
        if (r103 == null) goto L5;
        r103.a("request_end");
    L5:
        d r104 = r102.get(f23949a);
        if (r104 == null) goto L10;
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r104.b("video_url", r100);
    L10:
        d r105 = r102.get(f23949a);
        if (r105 == null) goto L16;
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        r105.b("video_id", r101);
    L16:
        if (f23950b <= 0) goto L21;
        d r106 = r102.get(f23949a);
        if (r106 == null) goto L22;
        r106.b("init_to_request_duration", Long.valueOf(SystemClock.elapsedRealtime() - f23950b));
        return;
    L22:
        return;
    }

    public static void b(String r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "failedType");
        f("2");
        i r103 = i.f47987a;
        d r104 = r103.get(f23949a);
        if (r104 == null) goto L5;
        r104.b("video_preload_failed_type", r100);
    L5:
        d r105 = r103.get(f23949a);
        if (r105 == null) goto L11;
        if (r101 == null) goto L9;
        int r106 = r101.intValue();
    L10:
        r105.b("video_preload_error_code", Integer.valueOf(r106));
        goto L11
    L9:
        r106 = -1;
    L11:
        d r107 = r103.get(f23949a);
        if (r107 == null) goto L17;
        if (r102 != null) goto L15;
        r102 = "";
    L15:
        r107.b("video_preload_error_msg", r102);
        return;
    }
}
