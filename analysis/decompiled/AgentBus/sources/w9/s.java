package w9;

import v9.j0;
import v9.z0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: f, reason: collision with root package name */
    public static final q f10953f;

    /* renamed from: g, reason: collision with root package name */
    public static final o f10954g;

    /* renamed from: h, reason: collision with root package name */
    public static final r f10955h;

    /* renamed from: i, reason: collision with root package name */
    public static final p f10956i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ s[] f10957j;

    static {
        q qVar = new q();
        f10953f = qVar;
        o oVar = new o();
        f10954g = oVar;
        r rVar = new r();
        f10955h = rVar;
        p pVar = new p();
        f10956i = pVar;
        f10957j = new s[]{qVar, oVar, rVar, pVar};
    }

    public static s b(z0 z0Var) {
        q7.k.e(z0Var, "<this>");
        if (z0Var.F0()) {
            return f10954g;
        }
        if (z0Var instanceof v9.l) {
        }
        return v9.c.f(a.newTypeCheckerState(f.f10932g, false, true), v9.c.k(z0Var), j0.f10559b) ? f10956i : f10955h;
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f10957j.clone();
    }

    public abstract s a(z0 z0Var);
}
