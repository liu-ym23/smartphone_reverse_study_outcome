package g9;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Context f4591c;

    /* renamed from: f, reason: collision with root package name */
    public b0 f4592f;

    /* renamed from: g, reason: collision with root package name */
    public String f4593g;

    /* renamed from: h, reason: collision with root package name */
    public sc.a f4594h;
    public Context i;

    /* renamed from: j, reason: collision with root package name */
    public int f4595j;

    /* renamed from: k, reason: collision with root package name */
    public int f4596k;

    /* renamed from: l, reason: collision with root package name */
    public int f4597l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f4598m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ r0 f4599n;

    /* renamed from: o, reason: collision with root package name */
    public int f4600o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(r0 r0Var, pb.c cVar) {
        super(cVar);
        this.f4599n = r0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4598m = obj;
        this.f4600o |= Integer.MIN_VALUE;
        Object objA = this.f4599n.a(null, null, null, this);
        return objA == ob.a.f9351c ? objA : jb.i.a(objA);
    }
}
