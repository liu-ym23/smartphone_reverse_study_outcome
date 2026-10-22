package s2;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public Object f9386f;

    /* renamed from: g, reason: collision with root package name */
    public Serializable f9387g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9388h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9389i;

    /* renamed from: j, reason: collision with root package name */
    public Iterator f9390j;

    /* renamed from: k, reason: collision with root package name */
    public int f9391k;

    /* renamed from: l, reason: collision with root package name */
    public int f9392l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z f9393m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i5.f f9394n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(z zVar, i5.f fVar, g7.d dVar) {
        super(1, dVar);
        this.f9393m = zVar;
        this.f9394n = fVar;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        return new j(this.f9393m, this.f9394n, dVar);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return ((j) create((g7.d) obj)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
