package androidx.compose.ui.layout;

import java.lang.invoke.VarHandle;
import p.u;
import s1.c1;
import s1.d1;
import s1.e1;
import s1.o;
import s1.p;
import s1.v0;
import u1.l0;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final u f977a;

    /* renamed from: b, reason: collision with root package name */
    public static final d1[] f978b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f979c;

    static {
        u uVar = new u(8);
        d1.f11233a.getClass();
        e1 e1Var = c1.f11229g;
        uVar.h(1, e1Var);
        e1 e1Var2 = c1.f11228f;
        uVar.h(2, e1Var2);
        e1 e1Var3 = c1.f11224b;
        uVar.h(4, e1Var3);
        e1 e1Var4 = c1.f11226d;
        uVar.h(8, e1Var4);
        e1 e1Var5 = c1.f11230h;
        uVar.h(16, e1Var5);
        e1 e1Var6 = c1.f11227e;
        uVar.h(32, e1Var6);
        e1 e1Var7 = c1.i;
        uVar.h(64, e1Var7);
        f977a = uVar;
        f978b = new d1[]{e1Var, e1Var2, e1Var3, e1Var7, e1Var5, e1Var6, e1Var4, c1.f11231j, c1.f11225c};
        u uVar2 = new u(7);
        uVar2.h(1, e1Var);
        uVar2.h(2, e1Var2);
        uVar2.h(4, e1Var3);
        uVar2.h(16, e1Var5);
        uVar2.h(64, e1Var7);
        uVar2.h(32, e1Var6);
        uVar2.h(8, e1Var4);
        f979c = uVar2;
    }

    public static final void a(l0 l0Var, o oVar, long j10, int i, int i3) {
        if (v0.h(j10, -1L)) {
            return;
        }
        l0Var.b(oVar.b(), (int) ((j10 >>> 48) & 65535));
        l0Var.b(oVar.d(), (int) ((j10 >>> 32) & 65535));
        l0Var.b(oVar.c(), i - ((int) ((j10 >>> 16) & 65535)));
        l0Var.b(oVar.a(), i3 - ((int) (j10 & 65535)));
    }

    public static final m b(p pVar) {
        RulerProviderModifierElement rulerProviderModifierElement = new RulerProviderModifierElement();
        rulerProviderModifierElement.f976c = pVar;
        VarHandle.storeStoreFence();
        return rulerProviderModifierElement;
    }
}
