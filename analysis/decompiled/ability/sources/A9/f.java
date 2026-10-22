package A9;

import kotlin.jvm.internal.k;
import z9.g;

/* loaded from: classes4.dex */
public interface f {
    default d beginCollection(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return beginStructure(descriptor);
    }

    d beginStructure(g gVar);

    void encodeBoolean(boolean z10);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(g gVar, int i);

    void encodeFloat(float f);

    f encodeInline(g gVar);

    void encodeInt(int i);

    void encodeLong(long j5);

    default void encodeNotNullMark() {
    }

    void encodeNull();

    default void encodeNullableSerializableValue(x9.f serializer, Object obj) {
        k.f(serializer, "serializer");
        if (serializer.getDescriptor().b()) {
            encodeSerializableValue(serializer, obj);
        } else if (obj == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(serializer, obj);
        }
    }

    default void encodeSerializableValue(x9.f serializer, Object obj) {
        k.f(serializer, "serializer");
        serializer.serialize(this, obj);
    }

    void encodeShort(short s5);

    void encodeString(String str);

    E9.e getSerializersModule();
}
