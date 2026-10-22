package m8;

import java.time.LocalDate;
import java.time.ZoneId;
import s8.d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public d1 f8401c;

    /* renamed from: f, reason: collision with root package name */
    public ZoneId f8402f;

    /* renamed from: g, reason: collision with root package name */
    public LocalDate f8403g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8404h;
    public final /* synthetic */ k0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f8405j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k0 k0Var, nb.c cVar) {
        super(cVar);
        this.i = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8404h = obj;
        this.f8405j |= Integer.MIN_VALUE;
        return this.i.m(this);
    }
}
