package v4;

import o4.d0;

/* loaded from: classes.dex */
public final class q extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public d0 f10504f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10505g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f10506h;

    /* renamed from: i, reason: collision with root package name */
    public int f10507i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d0 d0Var, i7.c cVar) {
        super(cVar);
        this.f10506h = d0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10505g = obj;
        this.f10507i |= Integer.MIN_VALUE;
        return this.f10506h.Q(this);
    }
}
