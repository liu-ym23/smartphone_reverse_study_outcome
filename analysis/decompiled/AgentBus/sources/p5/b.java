package p5;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public c f8415f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f8416g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f8417h;

    /* renamed from: i, reason: collision with root package name */
    public d5.e f8418i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8419j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c f8420k;

    /* renamed from: l, reason: collision with root package name */
    public int f8421l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f8420k = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8419j = obj;
        this.f8421l |= Integer.MIN_VALUE;
        return this.f8420k.b(null, null, this);
    }
}
