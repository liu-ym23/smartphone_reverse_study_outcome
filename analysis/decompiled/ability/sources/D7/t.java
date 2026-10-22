package D7;

import j9.C1614h;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* loaded from: classes3.dex */
public final class t implements i9.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f406a;
    public final Object b;

    public /* synthetic */ t(Object obj, int i) {
        this.f406a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [S7.n, kotlin.coroutines.jvm.internal.RestrictedSuspendLambda] */
    @Override // i9.i
    public final Iterator iterator() {
        switch (this.f406a) {
            case 0:
                return kotlin.jvm.internal.k.j((Object[]) this.b);
            case 1:
                return ((Iterable) this.b).iterator();
            case 2:
                return new O7.j(this);
            case 3:
                return U7.a.K((RestrictedSuspendLambda) this.b);
            case 4:
                return (Iterator) this.b;
            case 5:
                return new g9.h(this.b, 1);
            case 6:
                return new i9.h(this);
            default:
                return new C1614h((CharSequence) this.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(S7.n nVar) {
        this.f406a = 3;
        this.b = (RestrictedSuspendLambda) nVar;
    }
}
