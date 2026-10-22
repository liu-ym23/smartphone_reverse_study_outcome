package e8;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class j implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4385a;
    public final PrimitiveType b;

    public /* synthetic */ j(PrimitiveType primitiveType, int i) {
        this.f4385a = i;
        this.b = primitiveType;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4385a;
        PrimitiveType primitiveType = this.b;
        switch (i) {
            case 0:
                Set set = PrimitiveType.e;
                return o.l.c(primitiveType.f4943a);
            default:
                Set set2 = PrimitiveType.e;
                return o.l.c(primitiveType.b);
        }
    }
}
