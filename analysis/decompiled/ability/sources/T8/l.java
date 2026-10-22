package T8;

import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: classes4.dex */
public final class l implements n, p, o {
    public static final l c = new l(0);
    public static final l d = new l(1);
    public static final l e = new l(2);
    public static final l f = new l(3);
    public static final l g = new l(4);
    public final /* synthetic */ int b;

    public /* synthetic */ l(int i) {
        this.b = i;
    }

    @Override // T8.o
    public void a(InterfaceC1520c interfaceC1520c) {
        if (interfaceC1520c == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportCannotInferVisibility"));
        }
    }

    @Override // T8.p
    public X8.w b(ProtoBuf$Type proto, String flexibleId, X8.A lowerBound, X8.A upperBound) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(flexibleId, "flexibleId");
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
        throw new IllegalArgumentException("This method should not be used.");
    }

    @Override // T8.o
    public void c(InterfaceC1522e interfaceC1522e, ArrayList arrayList) {
    }

    @Override // T8.n
    public Boolean d() {
        switch (this.b) {
            case 1:
                return null;
            default:
                return Boolean.TRUE;
        }
    }
}
