package fc;

import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8823b;

    public /* synthetic */ l(Object obj, int i10) {
        this.f8822a = i10;
        this.f8823b = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.coroutines.jvm.internal.RestrictedSuspendLambda, zb.p] */
    @Override // fc.i
    public final Iterator iterator() {
        switch (this.f8822a) {
            case 0:
                return a4.a.o((RestrictedSuspendLambda) this.f8823b);
            case 1:
                return new gc.f((CharSequence) this.f8823b);
            default:
                return ((Iterable) this.f8823b).iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(zb.p pVar) {
        this.f8822a = 0;
        this.f8823b = (RestrictedSuspendLambda) pVar;
    }
}
