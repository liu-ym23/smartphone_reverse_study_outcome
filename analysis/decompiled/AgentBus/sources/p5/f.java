package p5;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f8435f;

    /* renamed from: g, reason: collision with root package name */
    public List f8436g;

    /* renamed from: h, reason: collision with root package name */
    public List f8437h;

    /* renamed from: i, reason: collision with root package name */
    public List f8438i;

    /* renamed from: j, reason: collision with root package name */
    public Iterator f8439j;

    /* renamed from: k, reason: collision with root package name */
    public i5.p f8440k;

    /* renamed from: l, reason: collision with root package name */
    public ra.b f8441l;

    /* renamed from: m, reason: collision with root package name */
    public Iterator f8442m;

    /* renamed from: n, reason: collision with root package name */
    public d5.e f8443n;

    /* renamed from: o, reason: collision with root package name */
    public int f8444o;

    /* renamed from: p, reason: collision with root package name */
    public int f8445p;

    /* renamed from: q, reason: collision with root package name */
    public /* synthetic */ Object f8446q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ h f8447r;

    /* renamed from: s, reason: collision with root package name */
    public int f8448s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, i7.c cVar) {
        super(cVar);
        this.f8447r = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8446q = obj;
        this.f8448s |= Integer.MIN_VALUE;
        return h.a(this.f8447r, null, this);
    }
}
