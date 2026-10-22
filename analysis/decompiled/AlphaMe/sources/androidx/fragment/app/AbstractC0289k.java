package androidx.fragment.app;

import java.util.HashSet;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0289k {

    /* renamed from: a, reason: collision with root package name */
    public final q0 f3775a;

    /* renamed from: b, reason: collision with root package name */
    public final G.c f3776b;

    public AbstractC0289k(q0 q0Var, G.c cVar) {
        this.f3775a = q0Var;
        this.f3776b = cVar;
    }

    public final void a() {
        q0 q0Var = this.f3775a;
        HashSet hashSet = q0Var.f3805e;
        if (hashSet.remove(this.f3776b) && hashSet.isEmpty()) {
            q0Var.b();
        }
    }

    public final boolean b() {
        q0 q0Var = this.f3775a;
        int iC = B0.g.c(q0Var.f3803c.mView);
        int i4 = q0Var.f3801a;
        return iC == i4 || !(iC == 2 || i4 == 2);
    }
}
