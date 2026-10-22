package z2;

import com.apm.insight.MonitorCrash;

/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static MonitorCrash f6931a = null;
    public static boolean b = true;
    public static int c = -1;
    public static int d;

    public static MonitorCrash a() {
        if (b && f6931a == null) {
            MonitorCrash.Config.SdkBuilder sdkBuilderSdk = MonitorCrash.Config.sdk("240740");
            sdkBuilderSdk.versionName("1.5.0").versionCode(1050090L);
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(com.apm.insight.g.f2160a, sdkBuilderSdk.keyWords("com.apm.insight").token("f81630b5764841ffbc0320ee2361b090").soList("libapminsighta.so", "libapminsightb.so").versionName("1.5.0").versionCode(1050090L).channel("release").disablePageView().build());
            f6931a = monitorCrashInitSDK;
            if (monitorCrashInitSDK != null) {
                try {
                    monitorCrashInitSDK.config().setDeviceId("240740");
                } catch (Throwable unused) {
                }
            }
        }
        return f6931a;
    }
}
