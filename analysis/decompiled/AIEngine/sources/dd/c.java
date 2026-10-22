package dd;

import kotlin.jvm.internal.Lambda;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Lambda f8471e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str, zb.a<Long> aVar) {
        super(str, true);
        this.f8471e = (Lambda) aVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.Lambda, zb.a] */
    @Override // dd.a
    public final long a() {
        return ((Number) this.f8471e.invoke()).longValue();
    }
}
