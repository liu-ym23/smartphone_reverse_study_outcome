package s0;

import java.util.Set;
import java.util.UUID;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public UUID f14160a;

    /* renamed from: b, reason: collision with root package name */
    public B0.r f14161b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f14162c;

    public H(Class workerClass) {
        Intrinsics.checkNotNullParameter(workerClass, "workerClass");
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.f14160a = uuidRandomUUID;
        String id = this.f14160a.toString();
        Intrinsics.checkNotNullExpressionValue(id, "id.toString()");
        String workerClassName_ = workerClass.getName();
        Intrinsics.checkNotNullExpressionValue(workerClassName_, "workerClass.name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workerClassName_, "workerClassName_");
        this.f14161b = new B0.r(id, (G) null, workerClassName_, (String) null, (C0850h) null, (C0850h) null, 0L, 0L, 0L, (C0847e) null, 0, (EnumC0843a) null, 0L, 0L, 0L, 0L, false, (C) null, 0, 0L, 0, 0, 8388602);
        String name = workerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
        this.f14162c = SetsKt.mutableSetOf(name);
    }

    public final I a() {
        I iB = b();
        C0847e c0847e = this.f14161b.f176j;
        boolean z4 = (c0847e.f14192h.isEmpty() ^ true) || c0847e.f14188d || c0847e.f14186b || c0847e.f14187c;
        B0.r rVar = this.f14161b;
        if (rVar.f183q) {
            if (!(!z4)) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
            }
            if (rVar.f173g > 0) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
            }
        }
        UUID id = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(id, "randomUUID()");
        Intrinsics.checkNotNullParameter(id, "id");
        this.f14160a = id;
        String newId = id.toString();
        Intrinsics.checkNotNullExpressionValue(newId, "id.toString()");
        B0.r other = this.f14161b;
        Intrinsics.checkNotNullParameter(newId, "newId");
        Intrinsics.checkNotNullParameter(other, "other");
        this.f14161b = new B0.r(newId, other.f168b, other.f169c, other.f170d, new C0850h(other.f171e), new C0850h(other.f172f), other.f173g, other.f174h, other.f175i, new C0847e(other.f176j), other.f177k, other.f178l, other.f179m, other.f180n, other.f181o, other.f182p, other.f183q, other.f184r, other.f185s, other.f187u, other.f188v, other.f189w, 524288);
        return iB;
    }

    public abstract I b();
}
