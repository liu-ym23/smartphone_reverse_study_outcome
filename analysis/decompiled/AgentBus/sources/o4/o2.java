package o4;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class o2 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public t2 f7496f;

    /* renamed from: g, reason: collision with root package name */
    public Iterator f7497g;

    /* renamed from: h, reason: collision with root package name */
    public a2 f7498h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7499i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t2 f7500j;

    /* renamed from: k, reason: collision with root package name */
    public int f7501k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o2(t2 t2Var, i7.c cVar) {
        super(cVar);
        this.f7500j = t2Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7499i = obj;
        this.f7501k |= Integer.MIN_VALUE;
        return this.f7500j.n(this);
    }
}
