package A9;

import kotlin.jvm.internal.k;
import x9.InterfaceC2123a;
import z9.g;

/* loaded from: classes4.dex */
public interface e {
    c beginStructure(g gVar);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(g gVar);

    float decodeFloat();

    e decodeInline(g gVar);

    int decodeInt();

    long decodeLong();

    boolean decodeNotNullMark();

    Void decodeNull();

    default Object decodeSerializableValue(InterfaceC2123a deserializer) {
        k.f(deserializer, "deserializer");
        return deserializer.deserialize(this);
    }

    short decodeShort();

    String decodeString();
}
