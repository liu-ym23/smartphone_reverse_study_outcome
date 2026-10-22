package com.bytedance.android.sdk.bdticketguard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163979a = 0;

    static {
    }

    public static String e(Throwable r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getClass().getName());
        String r103 = r100.getMessage();
        if (r103 == null) goto L10;
        String r104 = ": ".concat(r103);
        if (r104 == null) goto L10;
    L11:
        r102.append(r104);
        Throwable r105 = r100.getCause();
        if (r105 == null) goto L23;
        if (r105 == r100) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L19;
        r105 = null;
    L19:
        if (r105 == null) goto L23;
        String r107 = ", cause: [" + f0.b(r105) + ']';
        if (r107 == null) goto L23;
        r101 = r107;
        goto L23
    L15:
        r106 = false;
    L23:
        r102.append(r101);
        return r102.toString();
    L10:
        r104 = "";
        goto L11
    }

    public static void a(String r100, String r101) {
        d(3, r100, r101, null);
    }

    public static void b(String r100, String r101) {
        d(6, r100, r101, null);
    }

    public static void c(String r100, String r101) {
        d(4, r100, r101, null);
    }

    public static void f(String r100, String r101) {
        d(5, r100, r101, null);
    }

    public static void d(int r100, String r101, String r102, Throwable r103) {
        TicketGuardManager r104 = c1.f163567a;
        TicketGuardManager r105 = c1.f163567a;
        if (r105 != null) goto L5;
    L13:
        s r106 = d1.f163580a;
    L14:
        r106.log(r100, "BDTicketGuard/" + r101, r102, r103);
        return;
    L5:
        if (r105.f163526b == null) goto L10;
        b1 r107 = r105.f163526b;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("ticketGuardInitParam");
    L9:
        r106 = r107.getLogger();
    L11:
        if (r106 == null) goto L13;
    L10:
        r106 = null;
        goto L11
    }
}
