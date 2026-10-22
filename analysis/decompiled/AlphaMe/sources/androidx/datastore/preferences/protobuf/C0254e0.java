package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0254e0 {

    /* renamed from: c, reason: collision with root package name */
    public static final C0254e0 f3467c = new C0254e0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3469b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final P f3468a = new P();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.datastore.preferences.protobuf.Z] */
    /* JADX WARN: Type inference failed for: r3v9, types: [androidx.datastore.preferences.protobuf.Z] */
    public final InterfaceC0262i0 a(Class cls) {
        Y yX;
        Y y4;
        Y z4;
        Class cls2;
        D.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f3469b;
        InterfaceC0262i0 interfaceC0262i0 = (InterfaceC0262i0) concurrentHashMap.get(cls);
        if (interfaceC0262i0 != null) {
            return interfaceC0262i0;
        }
        P p4 = this.f3468a;
        p4.getClass();
        Class cls3 = j0.f3492a;
        if (!A.class.isAssignableFrom(cls) && (cls2 = j0.f3492a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        V vA = p4.f3433a.a(cls);
        C0258g0 c0258g0 = (C0258g0) vA;
        if ((c0258g0.f3479d & 2) == 2) {
            boolean zIsAssignableFrom = A.class.isAssignableFrom(cls);
            AbstractC0247b abstractC0247b = c0258g0.f3476a;
            if (zIsAssignableFrom) {
                z4 = new Z(j0.f3495d, AbstractC0272t.f3536a, abstractC0247b);
            } else {
                r0 r0Var = j0.f3493b;
                C0271s c0271s = AbstractC0272t.f3537b;
                if (c0271s == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                z4 = new Z(r0Var, c0271s, abstractC0247b);
            }
            y4 = z4;
        } else {
            if (A.class.isAssignableFrom(cls)) {
                yX = c0258g0.d() == 1 ? Y.x(vA, AbstractC0248b0.f3463b, L.f3430b, j0.f3495d, AbstractC0272t.f3536a, U.f3440b) : Y.x(vA, AbstractC0248b0.f3463b, L.f3430b, j0.f3495d, null, U.f3440b);
            } else if (c0258g0.d() == 1) {
                C0246a0 c0246a0 = AbstractC0248b0.f3462a;
                J j4 = L.f3429a;
                r0 r0Var2 = j0.f3493b;
                C0271s c0271s2 = AbstractC0272t.f3537b;
                if (c0271s2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                yX = Y.x(vA, c0246a0, j4, r0Var2, c0271s2, U.f3439a);
            } else {
                yX = Y.x(vA, AbstractC0248b0.f3462a, L.f3429a, j0.f3494c, null, U.f3439a);
            }
            y4 = yX;
        }
        InterfaceC0262i0 interfaceC0262i02 = (InterfaceC0262i0) concurrentHashMap.putIfAbsent(cls, y4);
        return interfaceC0262i02 != null ? interfaceC0262i02 : y4;
    }
}
