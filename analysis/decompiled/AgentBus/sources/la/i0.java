package la;

import ia.g1;

/* loaded from: classes.dex */
public final class i0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public j0 f5929f;

    /* renamed from: g, reason: collision with root package name */
    public k f5930g;

    /* renamed from: h, reason: collision with root package name */
    public l0 f5931h;

    /* renamed from: i, reason: collision with root package name */
    public g1 f5932i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f5933j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ j0 f5934k;

    /* renamed from: l, reason: collision with root package name */
    public int f5935l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(j0 j0Var, g7.d dVar) {
        super(dVar);
        this.f5934k = j0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f5933j = obj;
        this.f5935l |= Integer.MIN_VALUE;
        j0.h(this.f5934k, null, this);
        return h7.a.f4212f;
    }
}
