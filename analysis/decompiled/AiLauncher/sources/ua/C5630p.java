package ua;

/* renamed from: ua.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5630p implements InterfaceC5623i {

    /* renamed from: a, reason: collision with root package name */
    public final E9.F f42642a;

    public C5630p(E9.F packageFragmentProvider) {
        kotlin.jvm.internal.p.i(packageFragmentProvider, "packageFragmentProvider");
        this.f42642a = packageFragmentProvider;
    }

    @Override // ua.InterfaceC5623i
    public C5622h a(ga.b classId) {
        C5622h c5622hA;
        kotlin.jvm.internal.p.i(classId, "classId");
        for (E9.E e10 : E9.J.c(this.f42642a, classId.f())) {
            if ((e10 instanceof AbstractC5631q) && (c5622hA = ((AbstractC5631q) e10).A0().a(classId)) != null) {
                return c5622hA;
            }
        }
        return null;
    }
}
