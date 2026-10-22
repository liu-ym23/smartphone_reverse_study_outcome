package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import x5.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080\u0080\u0004\u001a\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u000e\u0010\f\u001a\u00020\u0007*\u00020\u0007H\u0082\u0080\u0004\u001a&\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u0003\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u0002H\u0080\u0080\u0004\"#\u0010\u0000\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"BUILTIN_SERIALIZERS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.KIND, "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkNameIsNotAPrimitive", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "capitalize", "builtinSerializerOrNull", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrimitivesKt {
    private static final Map<v5.c, KSerializer<?>> BUILTIN_SERIALIZERS = PlatformKt.initBuiltins();

    public static final SerialDescriptor PrimitiveDescriptorSafe(String serialName, PrimitiveKind kind) {
        p.e(serialName, "serialName");
        p.e(kind, "kind");
        checkNameIsNotAPrimitive(serialName);
        return new PrimitiveSerialDescriptor(serialName, kind);
    }

    public static final <T> KSerializer<T> builtinSerializerOrNull(v5.c cVar) {
        p.e(cVar, "<this>");
        return (KSerializer) BUILTIN_SERIALIZERS.get(cVar);
    }

    private static final String capitalize(String str) {
        String strValueOf;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            String strValueOf2 = String.valueOf(cCharAt);
            p.c(strValueOf2, "null cannot be cast to non-null type java.lang.String");
            Locale locale = Locale.ROOT;
            strValueOf = strValueOf2.toUpperCase(locale);
            p.d(strValueOf, "toUpperCase(...)");
            if (strValueOf.length() <= 1) {
                strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
            } else if (cCharAt != 329) {
                char cCharAt2 = strValueOf.charAt(0);
                String strSubstring = strValueOf.substring(1);
                p.d(strSubstring, "substring(...)");
                String lowerCase = strSubstring.toLowerCase(locale);
                p.d(lowerCase, "toLowerCase(...)");
                strValueOf = cCharAt2 + lowerCase;
            }
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring2 = str.substring(1);
        p.d(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static final void checkNameIsNotAPrimitive(String serialName) {
        p.e(serialName, "serialName");
        for (KSerializer<?> kSerializer : BUILTIN_SERIALIZERS.values()) {
            if (serialName.equals(kSerializer.getDescriptor().getSerialName())) {
                throw new IllegalArgumentException(o.Q0("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + serialName + " there already exists " + z.a(kSerializer.getClass()).b() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
