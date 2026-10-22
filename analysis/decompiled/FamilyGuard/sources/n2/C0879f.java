package n2;

import C4.D;
import C4.F;
import C4.x;
import f2.C0702g;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: n2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0879f implements x {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f18921c = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final String f18922a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f18923b;

    public C0879f(String str) {
        this(str, false);
    }

    @Override // C4.x
    public F a(x.a aVar) throws InterruptedException {
        AtomicInteger atomicInteger = f18921c;
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement >= 99999) {
            atomicInteger.set(1);
        }
        D dA = aVar.a();
        C0702g.y("FamilyGuardServer", "(" + andIncrement + ") --> " + dA.f() + ": " + dA.i());
        C0880g c0880g = (C0880g) dA.a();
        C0702g.y(this.f18922a, "(" + andIncrement + ") --> PARAMS: " + c0880g.i());
        F fB = aVar.b(dA);
        for (int i5 = 0; this.f18923b && i5 < 3; i5++) {
            try {
                if (fB.w()) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
        }
        if (fB.w()) {
            return new F.a().q(fB.I()).o(fB.E()).g(fB.m()).l(fB.x()).h(fB.o()).j(fB.v()).m(fB.A()).d(fB.f()).n(fB.D()).r(fB.L()).p(fB.G()).b(new i(andIncrement, c0880g.j(), fB.a().r(), fB.a().o(), fB.a().w())).c();
        }
        C0702g.p(this.f18922a, "(" + andIncrement + ") <-- CODE: " + fB.m() + " MESSAGE: " + fB.x());
        return fB;
    }

    public C0879f(String str, boolean z5) {
        this.f18922a = str;
        this.f18923b = z5;
    }
}
