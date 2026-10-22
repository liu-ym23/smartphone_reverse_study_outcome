package I8;

import X8.N;
import X8.w;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class f implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f812a;
    public final g b;

    public /* synthetic */ f(g gVar, int i) {
        this.f812a = i;
        this.b = gVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) throws IOException {
        switch (this.f812a) {
            case 0:
                N it = (N) obj;
                kotlin.jvm.internal.k.f(it, "it");
                if (it.c()) {
                    return "*";
                }
                w wVarB = it.b();
                kotlin.jvm.internal.k.e(wVarB, "getType(...)");
                String strW = this.b.W(wVarB);
                if (it.a() == Variance.c) {
                    return strW;
                }
                return it.a() + ' ' + strW;
            default:
                w wVar = (w) obj;
                kotlin.jvm.internal.k.c(wVar);
                return this.b.W(wVar);
        }
    }
}
