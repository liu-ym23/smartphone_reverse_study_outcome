package q5;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class n extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q f8729f;

    /* renamed from: g, reason: collision with root package name */
    public d5.e f8730g;

    /* renamed from: h, reason: collision with root package name */
    public Iterator f8731h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f8732i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q f8733j;

    /* renamed from: k, reason: collision with root package name */
    public int f8734k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(q qVar, g7.d dVar) {
        super(dVar);
        this.f8733j = qVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8732i = obj;
        this.f8734k |= Integer.MIN_VALUE;
        return q.b(null, this.f8733j, this);
    }
}
