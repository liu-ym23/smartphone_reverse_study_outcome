package s4;

import x4.C1294F;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    private static final C1294F f20384a = new C1294F("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    public static final C1294F f20385b = new C1294F("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    private static final C1294F f20386c = new C1294F("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    private static final C1294F f20387d = new C1294F("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    private static final C1294F f20388e = new C1294F("SEALED");

    /* renamed from: f, reason: collision with root package name */
    private static final Z f20389f = new Z(false);

    /* renamed from: g, reason: collision with root package name */
    private static final Z f20390g = new Z(true);

    public static final Object g(Object obj) {
        return obj instanceof InterfaceC1077i0 ? new C1079j0((InterfaceC1077i0) obj) : obj;
    }

    public static final Object h(Object obj) {
        InterfaceC1077i0 interfaceC1077i0;
        C1079j0 c1079j0 = obj instanceof C1079j0 ? (C1079j0) obj : null;
        return (c1079j0 == null || (interfaceC1077i0 = c1079j0.f20352a) == null) ? obj : interfaceC1077i0;
    }
}
