package G2;

import f2.C0702g;
import z3.C1347a;

/* loaded from: classes.dex */
public class n extends AbstractC0293a {

    /* renamed from: c, reason: collision with root package name */
    private boolean f1899c;

    /* renamed from: d, reason: collision with root package name */
    private F2.z f1900d;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1901a;

        static {
            int[] iArr = new int[F2.z.values().length];
            f1901a = iArr;
            try {
                iArr[F2.z.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1901a[F2.z.INIT_PASSWORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1901a[F2.z.INIT_MINOR_AND_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1901a[F2.z.INIT_PARENT_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public n(F2.z zVar, v vVar) {
        super(zVar, vVar);
        this.f1899c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(F2.z zVar) {
        k().q(zVar);
        C0702g.b("InitState", "onEnter loaded");
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean c() {
        return false;
    }

    @Override // G2.AbstractC0293a, G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        super.h(dVar, uVar);
        C0702g.b("InitState", "onEnter() called with: activity = [" + dVar + "], from = [" + uVar + "]");
        k().g().A0().X(T3.a.c()).E(new D3.h() { // from class: G2.l
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f1897a.o((F2.z) obj);
            }
        }).G(C1347a.a()).T(new D3.c() { // from class: G2.m
            @Override // D3.c
            public final void accept(Object obj) {
                this.f1898a.p((F2.z) obj);
            }
        }, S1.a.b());
    }

    @Override // G2.AbstractC0293a, G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        C0702g.b("InitState", "handleOperation() called with: activity = [" + dVar + "], operation = [" + i5 + "]");
        if (this.f1899c || i5 != 7 || k().l() || this.f1900d.ordinal() < F2.z.INIT_MINOR_AND_START.ordinal() || !I2.b.a(dVar)) {
            return super.i(dVar, i5);
        }
        k().q(F2.z.VERIFY_PASSWORD_TO_START);
        return true;
    }

    protected F2.z o(F2.z zVar) {
        this.f1900d = zVar;
        int i5 = a.f1901a[zVar.ordinal()];
        F2.z zVar2 = i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? zVar : F2.z.VERIFY_PASSWORD_TO_INIT_PARENT_PHONE : F2.z.VERIFY_PASSWORD_TO_START : F2.z.INIT_PASSWORD : F2.z.GUIDE;
        this.f1899c = false;
        C0702g.b("InitState", "direct() called with: stateEnum = [" + zVar + "] result = " + zVar2);
        return zVar2;
    }
}
