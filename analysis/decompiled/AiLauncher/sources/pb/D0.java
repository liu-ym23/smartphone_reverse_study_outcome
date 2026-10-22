package pb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\t*\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0012*\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", Const.INTENT_KEY_APIKEY, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Set;", "", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lw9/d;", "", "f", "(Lw9/d;)Ljava/lang/Void;", "e", "(Lw9/d;)Ljava/lang/String;", "className", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "Lw9/n;", "", "c", "(Lw9/n;)Lw9/d;", "Lw9/p;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw9/p;)Lw9/n;", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class D0 {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptor[] f38270a = new SerialDescriptor[0];

    public static final Set<String> a(SerialDescriptor serialDescriptor) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        if (serialDescriptor instanceof InterfaceC5110n) {
            return ((InterfaceC5110n) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.getElementsCount());
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            hashSet.add(serialDescriptor.e(i10));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List<? extends SerialDescriptor> list) {
        SerialDescriptor[] serialDescriptorArr;
        List<? extends SerialDescriptor> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? f38270a : serialDescriptorArr;
    }

    public static final InterfaceC5745d<Object> c(InterfaceC5755n interfaceC5755n) {
        kotlin.jvm.internal.p.i(interfaceC5755n, "<this>");
        InterfaceC5746e interfaceC5746eC = interfaceC5755n.c();
        if (interfaceC5746eC instanceof InterfaceC5745d) {
            return (InterfaceC5745d) interfaceC5746eC;
        }
        if (!(interfaceC5746eC instanceof InterfaceC5756o)) {
            throw new IllegalArgumentException("Only KClass supported as classifier, got " + interfaceC5746eC);
        }
        throw new IllegalArgumentException("Captured type parameter " + interfaceC5746eC + " from generic non-reified function. Such functionality cannot be supported because " + interfaceC5746eC + " is erased, either specify serializer explicitly or make calling function inline with reified " + interfaceC5746eC + '.');
    }

    public static final String d(String className) {
        kotlin.jvm.internal.p.i(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final String e(InterfaceC5745d<?> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        String strT = interfaceC5745d.t();
        if (strT == null) {
            strT = "<local class name not available>";
        }
        return d(strT);
    }

    public static final Void f(InterfaceC5745d<?> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        throw new SerializationException(e(interfaceC5745d));
    }

    public static final InterfaceC5755n g(C5757p c5757p) {
        kotlin.jvm.internal.p.i(c5757p, "<this>");
        InterfaceC5755n interfaceC5755nC = c5757p.c();
        if (interfaceC5755nC != null) {
            return interfaceC5755nC;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + c5757p.c()).toString());
    }
}
