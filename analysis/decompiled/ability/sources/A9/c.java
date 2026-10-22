package A9;

import kotlin.jvm.internal.k;
import x9.InterfaceC2123a;
import z9.g;

/* loaded from: classes4.dex */
public interface c {
    boolean decodeBooleanElement(g gVar, int i);

    byte decodeByteElement(g gVar, int i);

    char decodeCharElement(g gVar, int i);

    default int decodeCollectionSize(g descriptor) {
        k.f(descriptor, "descriptor");
        return -1;
    }

    double decodeDoubleElement(g gVar, int i);

    int decodeElementIndex(g gVar);

    float decodeFloatElement(g gVar, int i);

    e decodeInlineElement(g gVar, int i);

    int decodeIntElement(g gVar, int i);

    long decodeLongElement(g gVar, int i);

    Object decodeNullableSerializableElement(g gVar, int i, InterfaceC2123a interfaceC2123a, Object obj);

    default boolean decodeSequentially() {
        return false;
    }

    Object decodeSerializableElement(g gVar, int i, InterfaceC2123a interfaceC2123a, Object obj);

    short decodeShortElement(g gVar, int i);

    String decodeStringElement(g gVar, int i);

    void endStructure(g gVar);

    E9.e getSerializersModule();
}
