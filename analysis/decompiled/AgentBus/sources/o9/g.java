package o9;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g extends h9.m {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7919b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f7920c;

    public g(ArrayList arrayList, h hVar) {
        this.f7919b = arrayList;
        this.f7920c = hVar;
    }

    @Override // h9.m
    public final void b(f8.c cVar) {
        q7.k.e(cVar, "fakeOverride");
        h9.l.r(cVar, null);
        this.f7919b.add(cVar);
    }

    @Override // h9.m
    public final void d(f8.c cVar, f8.c cVar2) {
        q7.k.e(cVar2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f7920c.f7922b + ": " + cVar + " vs " + cVar2).toString());
    }
}
