package q5;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8739f;

    /* renamed from: g, reason: collision with root package name */
    public d5.e f8740g;

    /* renamed from: h, reason: collision with root package name */
    public c5.b f8741h;

    /* renamed from: i, reason: collision with root package name */
    public Iterator f8742i;

    /* renamed from: j, reason: collision with root package name */
    public s5.d f8743j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f8744k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q f8745l;

    /* renamed from: m, reason: collision with root package name */
    public int f8746m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, i7.c cVar) {
        super(cVar);
        this.f8745l = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8744k = obj;
        this.f8746m |= Integer.MIN_VALUE;
        return this.f8745l.m(null, null, this);
    }
}
