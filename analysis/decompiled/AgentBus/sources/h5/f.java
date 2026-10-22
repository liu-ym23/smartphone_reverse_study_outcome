package h5;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public g f4194f;

    /* renamed from: g, reason: collision with root package name */
    public List f4195g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f4196h;

    /* renamed from: i, reason: collision with root package name */
    public d f4197i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f4198j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g f4199k;

    /* renamed from: l, reason: collision with root package name */
    public int f4200l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, i7.c cVar) {
        super(cVar);
        this.f4199k = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f4198j = obj;
        this.f4200l |= Integer.MIN_VALUE;
        return g.a(this.f4199k, this);
    }
}
