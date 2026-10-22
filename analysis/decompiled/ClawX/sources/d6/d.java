package d6;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1856a;

    /* renamed from: b, reason: collision with root package name */
    public int f1857b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f1858c;
    public c d;

    /* renamed from: e, reason: collision with root package name */
    public Iterator f1859e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, f5.c cVar) {
        super(cVar);
        this.f1858c = eVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f1856a = obj;
        this.f1857b |= Integer.MIN_VALUE;
        return this.f1858c.collect(null, this);
    }
}
