package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.WriteMode;
import nb.AbstractC4951d;
import nb.AbstractC4952e;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import nb.C4949b;
import qb.AbstractC5171a;
import sb.AbstractC5465c;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lqb/a;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.JSON_KEY_DESC, "Lkotlinx/serialization/json/internal/WriteMode;", Const.INTENT_KEY_PKGNAME, "(Lqb/a;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/WriteMode;", "Lsb/c;", "module", Const.INTENT_KEY_APIKEY, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lsb/c;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class T {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, AbstractC5465c module) {
        SerialDescriptor serialDescriptorA;
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(module, "module");
        if (!kotlin.jvm.internal.p.d(serialDescriptor.getKind(), AbstractC4959l.a.f37291a)) {
            return serialDescriptor.getIsInline() ? a(serialDescriptor.g(0), module) : serialDescriptor;
        }
        SerialDescriptor serialDescriptorB = C4949b.b(module, serialDescriptor);
        return (serialDescriptorB == null || (serialDescriptorA = a(serialDescriptorB, module)) == null) ? serialDescriptor : serialDescriptorA;
    }

    public static final WriteMode b(AbstractC5171a abstractC5171a, SerialDescriptor desc) {
        kotlin.jvm.internal.p.i(abstractC5171a, "<this>");
        kotlin.jvm.internal.p.i(desc, "desc");
        AbstractC4959l kind = desc.getKind();
        if (kind instanceof AbstractC4951d) {
            return WriteMode.POLY_OBJ;
        }
        if (kotlin.jvm.internal.p.d(kind, AbstractC4960m.b.f37294a)) {
            return WriteMode.LIST;
        }
        if (!kotlin.jvm.internal.p.d(kind, AbstractC4960m.c.f37295a)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor serialDescriptorA = a(desc.g(0), abstractC5171a.getSerializersModule());
        AbstractC4959l kind2 = serialDescriptorA.getKind();
        if ((kind2 instanceof AbstractC4952e) || kotlin.jvm.internal.p.d(kind2, AbstractC4959l.b.f37292a)) {
            return WriteMode.MAP;
        }
        if (abstractC5171a.getConfiguration().getAllowStructuredMapKeys()) {
            return WriteMode.LIST;
        }
        throw C5268s.d(serialDescriptorA);
    }
}
