package m8;

import android.content.res.Resources;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Resources f8515c;

    /* renamed from: f, reason: collision with root package name */
    public String f8516f;

    /* renamed from: g, reason: collision with root package name */
    public s8.t f8517g;

    /* renamed from: h, reason: collision with root package name */
    public long f8518h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f8519j;

    /* renamed from: k, reason: collision with root package name */
    public int f8520k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8519j = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f8520k |= Integer.MIN_VALUE;
        return this.f8519j.I(null, null, null, this);
    }
}
