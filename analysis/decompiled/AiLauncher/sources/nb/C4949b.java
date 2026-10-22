package nb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.S0;
import sb.AbstractC5465c;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\"$\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsb/c;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", Const.INTENT_KEY_PKGNAME, "(Lsb/c;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lw9/d;", "context", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lw9/d;)Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_APIKEY, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lw9/d;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "capturedKClass", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: nb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4949b {
    public static final InterfaceC5745d<?> a(SerialDescriptor serialDescriptor) {
        p.i(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).kClass;
        }
        if (serialDescriptor instanceof S0) {
            return a(((S0) serialDescriptor).getOriginal());
        }
        return null;
    }

    public static final SerialDescriptor b(AbstractC5465c abstractC5465c, SerialDescriptor descriptor) {
        KSerializer kSerializerC;
        p.i(abstractC5465c, "<this>");
        p.i(descriptor, "descriptor");
        InterfaceC5745d<?> interfaceC5745dA = a(descriptor);
        if (interfaceC5745dA == null || (kSerializerC = AbstractC5465c.c(abstractC5465c, interfaceC5745dA, null, 2, null)) == null) {
            return null;
        }
        return kSerializerC.getDescriptor();
    }

    public static final SerialDescriptor c(SerialDescriptor serialDescriptor, InterfaceC5745d<?> context) {
        p.i(serialDescriptor, "<this>");
        p.i(context, "context");
        return new ContextDescriptor(serialDescriptor, context);
    }
}
