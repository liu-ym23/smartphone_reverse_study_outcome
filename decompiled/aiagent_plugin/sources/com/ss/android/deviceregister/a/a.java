package com.ss.android.deviceregister.a;

import com.bytedance.common.utility.j;

/* JADX INFO: compiled from: DeviceRegisterConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f37302a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f37303b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static InterfaceC1017a f37304c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f37305d = "ib.snssdk.com";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f37306e = false;

    /* JADX INFO: renamed from: com.ss.android.deviceregister.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DeviceRegisterConfig.java */
    public interface InterfaceC1017a {
        boolean a();
    }

    static {
    }

    public static String[] a() {
        String[] r0 = f37303b;
        if (r0 == null) goto L11;
        if (r0.length <= 0) goto L11;
        if (j.a(r0[0]) == true) goto L11;
        return f37303b;
    L11:
        return new String[]{"https://" + f37305d + "/service/2/device_register/", "https://" + f37305d + "/service/2/device_register/"};
    }

    public static void a(boolean r0) {
        f37306e = r0;
    }

    public static boolean b() {
        return f37306e;
    }

    public static boolean c() {
        InterfaceC1017a r0 = f37304c;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.a();
    }
}
