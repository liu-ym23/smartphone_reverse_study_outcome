package v3;

import java.io.FileInputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14604c;

    /* renamed from: f, reason: collision with root package name */
    public FileInputStream f14605f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14606g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b0 f14607h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.f14607h = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14606g = obj;
        this.i |= Integer.MIN_VALUE;
        return b0.a(this.f14607h, this);
    }
}
