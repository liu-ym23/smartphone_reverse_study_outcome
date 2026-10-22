package A9;

import kotlin.jvm.internal.k;
import z9.g;

/* loaded from: classes4.dex */
public interface d {
    void encodeBooleanElement(g gVar, int i, boolean z10);

    void encodeByteElement(g gVar, int i, byte b);

    void encodeCharElement(g gVar, int i, char c);

    void encodeDoubleElement(g gVar, int i, double d);

    void encodeFloatElement(g gVar, int i, float f);

    f encodeInlineElement(g gVar, int i);

    void encodeIntElement(g gVar, int i, int i6);

    void encodeLongElement(g gVar, int i, long j5);

    void encodeNullableSerializableElement(g gVar, int i, x9.f fVar, Object obj);

    void encodeSerializableElement(g gVar, int i, x9.f fVar, Object obj);

    void encodeShortElement(g gVar, int i, short s5);

    void encodeStringElement(g gVar, int i, String str);

    void endStructure(g gVar);

    default boolean shouldEncodeElementDefault(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return true;
    }
}
