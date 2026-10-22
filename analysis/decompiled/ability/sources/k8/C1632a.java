package k8;

import X8.AbstractC0272c;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* renamed from: k8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1632a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4843a;
    public final /* synthetic */ AbstractC1633b b;

    public /* synthetic */ C1632a(AbstractC1633b abstractC1633b, int i) {
        this.f4843a = i;
        this.b = abstractC1633b;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4843a;
        AbstractC1633b abstractC1633b = this.b;
        switch (i) {
            case 0:
                Q8.o oVarR = abstractC1633b.R();
                J4.b bVar = new J4.b(this, 12);
                Z8.g gVar = X8.S.f1527a;
                if (Z8.i.f(abstractC1633b)) {
                    return Z8.i.c(ErrorTypeKind.k, abstractC1633b.toString());
                }
                X8.K kM = abstractC1633b.m();
                if (kM == null) {
                    X8.S.a(12);
                    throw null;
                }
                if (oVarR == null) {
                    X8.S.a(13);
                    throw null;
                }
                List listD = X8.S.d(kM.getParameters());
                X8.H.b.getClass();
                return AbstractC0272c.w(X8.H.c, kM, listD, false, oVarR, bVar);
            case 1:
                return new Q8.i(abstractC1633b.R());
            default:
                return new u(abstractC1633b);
        }
    }
}
