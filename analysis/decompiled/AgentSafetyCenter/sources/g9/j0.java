package g9;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Iterator f4495c;

    /* renamed from: f, reason: collision with root package name */
    public a1 f4496f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4497g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f4498h;
    public final /* synthetic */ p0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f4499j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(p0 p0Var, pb.c cVar) {
        super(cVar);
        this.i = p0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4498h = obj;
        this.f4499j |= Integer.MIN_VALUE;
        return this.i.b(this);
    }
}
