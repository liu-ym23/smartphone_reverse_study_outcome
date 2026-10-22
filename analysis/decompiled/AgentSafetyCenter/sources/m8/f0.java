package m8;

import java.time.LocalDate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public LocalDate f8346c;

    /* renamed from: f, reason: collision with root package name */
    public LocalDate f8347f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8348g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k0 f8349h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8349h = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8348g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.f8349h.O(this);
    }
}
