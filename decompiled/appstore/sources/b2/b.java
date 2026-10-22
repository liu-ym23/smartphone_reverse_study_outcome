package b2;

import com.bytedance.apm.samplers.ISampleCheck;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ISampleCheck f5924a;

    static {
        f5924a = new a();
    }

    public static boolean a(String r10) {
        return f5924a.getLogTypeSwitch(r10);
    }

    public static boolean b(String r10) {
        return f5924a.getMetricSwitch(r10);
    }

    public static boolean c(String r10) {
        return f5924a.getPerfAllowSwitch(r10);
    }

    public static boolean d(String r10, String r11) {
        return f5924a.getPerfFpsAllowSwitch(r10, r11);
    }

    public static boolean e(String r10) {
        return f5924a.getPerfSecondStageSwitch(r10);
    }

    public static boolean f(String r10) {
        return f5924a.getServiceSwitch(r10);
    }

    public static void g(ISampleCheck r10) {
        f5924a = r10;
    }
}
