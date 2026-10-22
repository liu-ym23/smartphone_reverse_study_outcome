package androidx.compose.ui.layout;

import g1.b0;
import g1.c0;
import g1.d0;
import g1.i;
import g1.j;
import i1.j0;
import k.t;
import n0.m;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final t f770a;

    /* renamed from: b, reason: collision with root package name */
    public static final c0[] f771b;

    /* renamed from: c, reason: collision with root package name */
    public static final t f772c;

    static {
        t tVar = new t(8);
        c0.f3713a.getClass();
        d0 d0Var = b0.f3707g;
        tVar.g(1, d0Var);
        d0 d0Var2 = b0.f3706f;
        tVar.g(2, d0Var2);
        d0 d0Var3 = b0.f3702b;
        tVar.g(4, d0Var3);
        d0 d0Var4 = b0.f3704d;
        tVar.g(8, d0Var4);
        d0 d0Var5 = b0.f3708h;
        tVar.g(16, d0Var5);
        d0 d0Var6 = b0.f3705e;
        tVar.g(32, d0Var6);
        d0 d0Var7 = b0.f3709i;
        tVar.g(64, d0Var7);
        f770a = tVar;
        f771b = new c0[]{d0Var, d0Var2, d0Var3, d0Var7, d0Var5, d0Var6, d0Var4, b0.f3710j, b0.f3703c};
        t tVar2 = new t(7);
        tVar2.g(1, d0Var);
        tVar2.g(2, d0Var2);
        tVar2.g(4, d0Var3);
        tVar2.g(16, d0Var5);
        tVar2.g(64, d0Var7);
        tVar2.g(32, d0Var6);
        tVar2.g(8, d0Var4);
        f772c = tVar2;
    }

    public static final void a(j0 j0Var, i iVar, long j2, int i2, int i10) {
        if (a.a.K(j2, -1L)) {
            return;
        }
        j0Var.a(iVar.b(), (int) ((j2 >>> 48) & 65535));
        j0Var.a(iVar.d(), (int) ((j2 >>> 32) & 65535));
        j0Var.a(iVar.c(), i2 - ((int) ((j2 >>> 16) & 65535)));
        j0Var.a(iVar.a(), i10 - ((int) (j2 & 65535)));
    }

    public static final m b(j jVar) {
        return new RulerProviderModifierElement(jVar);
    }
}
