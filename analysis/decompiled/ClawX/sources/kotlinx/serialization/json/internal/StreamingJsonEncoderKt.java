package kotlinx.serialization.json.internal;

import b5.n;
import b5.r;
import b5.u;
import b5.y;
import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\u0003\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0019\u0010\u0006\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"unsignedNumberDescriptors", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "isUnsignedNumber", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnquotedLiteral", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StreamingJsonEncoderKt {
    private static final Set<SerialDescriptor> unsignedNumberDescriptors = l.k0(new SerialDescriptor[]{BuiltinSerializersKt.serializer(r.f911b).getDescriptor(), BuiltinSerializersKt.serializer(u.f914b).getDescriptor(), BuiltinSerializersKt.serializer(n.f905b).getDescriptor(), BuiltinSerializersKt.serializer(y.f918b).getDescriptor()});

    public static final boolean isUnquotedLiteral(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && serialDescriptor.equals(JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }
}
