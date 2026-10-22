package e1;

import p.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3373a;

    static {
        q qVar = d.f3346e;
        int i = qVar.f3341c;
        e eVar = new e(qVar, qVar, 1);
        int i3 = qVar.f3341c;
        l lVar = d.f3364x;
        int i10 = (lVar.f3341c << 6) | i3;
        g gVar = new g(qVar, lVar, 0);
        int i11 = (i3 << 6) | lVar.f3341c;
        g gVar2 = new g(lVar, qVar, 0);
        u uVar = p.k.f9586a;
        u uVar2 = new u();
        uVar2.h(i | (i << 6), eVar);
        uVar2.h(i10, gVar);
        uVar2.h(i11, gVar2);
        f3373a = uVar2;
    }
}
