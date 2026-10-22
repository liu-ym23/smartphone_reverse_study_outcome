package F9;

import E9.InterfaceC0797b;
import E9.W;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ma.AbstractC4927g;
import ya.S;

/* loaded from: classes5.dex */
public interface c {

    public static final class a {
        public static ga.c a(c cVar) {
            InterfaceC0797b interfaceC0797bL = DescriptorUtilsKt.l(cVar);
            if (interfaceC0797bL != null) {
                if (Aa.i.m(interfaceC0797bL)) {
                    interfaceC0797bL = null;
                }
                if (interfaceC0797bL != null) {
                    return DescriptorUtilsKt.k(interfaceC0797bL);
                }
            }
            return null;
        }
    }

    Map<ga.e, AbstractC4927g<?>> a();

    W e();

    ga.c f();

    S getType();
}
