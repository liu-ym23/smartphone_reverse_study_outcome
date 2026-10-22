package y9;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.e;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\"\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lw9/n;", "Lw9/d;", Const.INTENT_KEY_PKGNAME, "(Lw9/n;)Lw9/d;", "getJvmErasure$annotations", "(Lw9/n;)V", "jvmErasure", "Lw9/e;", Const.INTENT_KEY_APIKEY, "(Lw9/e;)Lw9/d;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {
    public static final InterfaceC5745d<?> a(InterfaceC5746e interfaceC5746e) {
        Object obj;
        InterfaceC5745d<?> interfaceC5745dB;
        p.i(interfaceC5746e, "<this>");
        if (interfaceC5746e instanceof InterfaceC5745d) {
            return (InterfaceC5745d) interfaceC5746e;
        }
        if (!(interfaceC5746e instanceof InterfaceC5756o)) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + interfaceC5746e);
        }
        List<InterfaceC5755n> upperBounds = ((InterfaceC5756o) interfaceC5746e).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC5746e interfaceC5746eC = ((InterfaceC5755n) next).getClassifier();
            e eVar = interfaceC5746eC instanceof e ? (e) interfaceC5746eC : null;
            if (eVar != null && eVar.b0() != ClassKind.INTERFACE && eVar.b0() != ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        InterfaceC5755n interfaceC5755n = (InterfaceC5755n) obj;
        if (interfaceC5755n == null) {
            interfaceC5755n = (InterfaceC5755n) F.s0(upperBounds);
        }
        return (interfaceC5755n == null || (interfaceC5745dB = b(interfaceC5755n)) == null) ? t.b(Object.class) : interfaceC5745dB;
    }

    public static final InterfaceC5745d<?> b(InterfaceC5755n interfaceC5755n) {
        InterfaceC5745d<?> interfaceC5745dA;
        p.i(interfaceC5755n, "<this>");
        InterfaceC5746e interfaceC5746eC = interfaceC5755n.getClassifier();
        if (interfaceC5746eC != null && (interfaceC5745dA = a(interfaceC5746eC)) != null) {
            return interfaceC5745dA;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + interfaceC5755n);
    }
}
