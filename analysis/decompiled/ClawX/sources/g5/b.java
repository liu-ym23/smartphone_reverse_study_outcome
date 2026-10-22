package g5;

import a6.k1;
import h5.g;
import io.ktor.utils.io.e0;
import io.ktor.utils.io.h0;
import kotlin.jvm.internal.d0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    public int f2986a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k1 f2987b;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(k1 k1Var) {
        e0 e0Var = h0.f3201a;
        this.f2987b = k1Var;
        super(e0Var);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        int i8 = this.f2986a;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f2986a = 2;
            a.a.c0(obj);
            return obj;
        }
        this.f2986a = 1;
        a.a.c0(obj);
        k1 k1Var = this.f2987b;
        d0.a(1, k1Var);
        return k1Var.invoke(this);
    }
}
