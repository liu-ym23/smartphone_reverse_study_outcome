package m8;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Set f8526c;

    /* renamed from: f, reason: collision with root package name */
    public Map f8527f;

    /* renamed from: g, reason: collision with root package name */
    public LocalDate f8528g;

    /* renamed from: h, reason: collision with root package name */
    public LocalDate f8529h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f8530j;

    /* renamed from: k, reason: collision with root package name */
    public int f8531k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8530j = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f8531k |= Integer.MIN_VALUE;
        return k0.j(this.f8530j, null, this);
    }
}
