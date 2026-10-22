package y4;

import java.util.List;
import o4.y1;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public y1 f11632f;

    /* renamed from: g, reason: collision with root package name */
    public List f11633g;

    /* renamed from: h, reason: collision with root package name */
    public List f11634h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11635i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y1 f11636j;

    /* renamed from: k, reason: collision with root package name */
    public int f11637k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(y1 y1Var, i7.c cVar) {
        super(cVar);
        this.f11636j = y1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11635i = obj;
        this.f11637k |= Integer.MIN_VALUE;
        return y1.b(this.f11636j, null, null, this);
    }
}
