package a6;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public a4.p f351f;

    /* renamed from: g, reason: collision with root package name */
    public s f352g;

    /* renamed from: h, reason: collision with root package name */
    public String f353h;

    /* renamed from: i, reason: collision with root package name */
    public c5.b f354i;

    /* renamed from: j, reason: collision with root package name */
    public List f355j;

    /* renamed from: k, reason: collision with root package name */
    public Iterator f356k;

    /* renamed from: l, reason: collision with root package name */
    public d5.e f357l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f358m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a4.p f359n;

    /* renamed from: o, reason: collision with root package name */
    public int f360o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(a4.p pVar, i7.c cVar) {
        super(cVar);
        this.f359n = pVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f358m = obj;
        this.f360o |= Integer.MIN_VALUE;
        return a4.p.s(this.f359n, null, this);
    }
}
