package s2;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class v extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f9438f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9439g;

    /* renamed from: h, reason: collision with root package name */
    public Serializable f9440h;

    /* renamed from: i, reason: collision with root package name */
    public q7.v f9441i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9442j;

    /* renamed from: k, reason: collision with root package name */
    public int f9443k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f9444l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z f9445m;

    /* renamed from: n, reason: collision with root package name */
    public int f9446n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(z zVar, i7.c cVar) {
        super(cVar);
        this.f9445m = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9444l = obj;
        this.f9446n |= Integer.MIN_VALUE;
        return z.c(this.f9445m, false, this);
    }
}
