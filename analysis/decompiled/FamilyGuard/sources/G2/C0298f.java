package G2;

import f2.C0702g;
import z3.C1347a;

/* renamed from: G2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0298f extends AbstractC0293a {

    /* renamed from: G2.f$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1894a;

        static {
            int[] iArr = new int[F2.z.values().length];
            f1894a = iArr;
            try {
                iArr[F2.z.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1894a[F2.z.INIT_MINOR_AND_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C0298f(F2.z zVar, v vVar) {
        super(zVar, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(F2.z zVar) {
        k().q(zVar);
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        k().g().A0().E(new D3.h() { // from class: G2.d
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1892a.o((F2.z) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: G2.e
            @Override // D3.c
            public final void accept(Object obj) {
                this.f1893a.p((F2.z) obj);
            }
        }, S1.a.b());
        C0702g.b("DebugInitState", "onEnter() called with: activity = [" + dVar + "], from = [" + uVar + "]");
    }

    protected F2.z o(F2.z zVar) {
        F2.z zVar2 = F2.z.INIT;
        F2.z zVar3 = a.f1894a[zVar.ordinal()] != 1 ? k().g().o0() ? F2.z.MINOR_MODE_ON : F2.z.MINOR_MODE_OFF : F2.z.GUIDE;
        C0702g.b("DebugInitState", "direct() called with: stateEnum = [" + zVar + "] result = " + zVar3);
        return zVar3;
    }
}
