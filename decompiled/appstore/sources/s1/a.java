package s1;

import com.bytedance.apm.logging.IApmAlog;
import com.bytedance.apm6.foundation.UnSampleListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f24478a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f24479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IApmAlog f24480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IApmAlog f24481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile UnSampleListener f24482e;

    static {
    }

    public static void a(String r10, String r11) {
        if (f24478a == false) goto L8;
        IApmAlog r12 = f24480c;
        if (r12 == null) goto L9;
        r12.e(r10, r11);
        return;
    L9:
        return;
    }

    public static void b(String r10, String r11) {
        if (f24479b == false) goto L8;
        IApmAlog r12 = f24480c;
        if (r12 == null) goto L9;
        r12.i(r10, r11);
        return;
    L9:
        return;
    }

    public static IApmAlog c() {
        return f24481d;
    }

    public static void d(String r10, String r11) {
        if (f24478a == false) goto L8;
        IApmAlog r12 = f24480c;
        if (r12 == null) goto L9;
        r12.i(r10, r11);
        return;
    L9:
        return;
    }

    public static boolean e() {
        return f24479b;
    }

    public static boolean f() {
        if (f24482e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void g(String r10, String r11) {
        if (f24482e == null) goto L6;
        f24482e.onLog(r10, r11);
        return;
    }

    public static void h(IApmAlog r10) {
        f24480c = r10;
        if (r10 == null) goto L6;
        f24478a = true;
        return;
    }

    public static void i(boolean r10) {
        f24478a = r10;
    }

    public static void j(UnSampleListener r10) {
        f24482e = r10;
    }
}
