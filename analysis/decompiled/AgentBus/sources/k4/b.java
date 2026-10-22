package k4;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i5.f f5595f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f5596g;

    /* renamed from: h, reason: collision with root package name */
    public String f5597h;

    /* renamed from: i, reason: collision with root package name */
    public c5.b f5598i;

    /* renamed from: j, reason: collision with root package name */
    public List f5599j;

    /* renamed from: k, reason: collision with root package name */
    public Iterator f5600k;

    /* renamed from: l, reason: collision with root package name */
    public d5.e f5601l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f5602m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ i5.f f5603n;

    /* renamed from: o, reason: collision with root package name */
    public int f5604o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(i5.f fVar, i7.c cVar) {
        super(cVar);
        this.f5603n = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5602m = obj;
        this.f5604o |= Integer.MIN_VALUE;
        return this.f5603n.A(null, this);
    }
}
