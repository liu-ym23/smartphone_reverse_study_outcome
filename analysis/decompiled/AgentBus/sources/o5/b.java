package o5;

import m4.u0;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public u0 f7731f;

    /* renamed from: g, reason: collision with root package name */
    public d5.e f7732g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7733h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ u0 f7734i;

    /* renamed from: j, reason: collision with root package name */
    public int f7735j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(u0 u0Var, i7.c cVar) {
        super(cVar);
        this.f7734i = u0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7733h = obj;
        this.f7735j |= Integer.MIN_VALUE;
        return u0.a(this.f7734i, null, this);
    }
}
