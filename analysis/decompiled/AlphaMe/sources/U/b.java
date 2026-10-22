package U;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t0.J;
import z0.AbstractC0998f;

/* loaded from: classes.dex */
public final class b extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1877b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1878c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i4, Object obj, Object obj2) {
        super(0);
        this.f1876a = i4;
        this.f1877b = obj;
        this.f1878c = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f1876a) {
            case 0:
                Context applicationContext = (Context) this.f1877b;
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                return J.E(applicationContext, ((c) this.f1878c).f1879a);
            default:
                AbstractC0998f abstractC0998f = ((y0.d) this.f1877b).f16170a;
                y0.b listener = (y0.b) this.f1878c;
                abstractC0998f.getClass();
                Intrinsics.checkNotNullParameter(listener, "listener");
                synchronized (abstractC0998f.f16399c) {
                    if (abstractC0998f.f16400d.remove(listener) && abstractC0998f.f16400d.isEmpty()) {
                        abstractC0998f.d();
                    }
                }
                return Unit.INSTANCE;
        }
    }
}
