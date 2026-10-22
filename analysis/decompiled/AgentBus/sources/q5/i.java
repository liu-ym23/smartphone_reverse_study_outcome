package q5;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8692f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f8693g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f8694h;

    /* renamed from: i, reason: collision with root package name */
    public d5.e f8695i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8696j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q f8697k;

    /* renamed from: l, reason: collision with root package name */
    public int f8698l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(q qVar, i7.c cVar) {
        super(cVar);
        this.f8697k = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8696j = obj;
        this.f8698l |= Integer.MIN_VALUE;
        return this.f8697k.f(null, null, this);
    }
}
