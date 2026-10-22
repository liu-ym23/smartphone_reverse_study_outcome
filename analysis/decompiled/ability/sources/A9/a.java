package A9;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlinx.serialization.SerializationException;
import x9.InterfaceC2123a;
import z9.g;

/* loaded from: classes4.dex */
public abstract class a implements e, c {
    public static /* synthetic */ Object decodeSerializableValue$default(a aVar, InterfaceC2123a interfaceC2123a, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        return aVar.decodeSerializableValue(interfaceC2123a, obj);
    }

    @Override // A9.e
    public c beginStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        return this;
    }

    @Override // A9.e
    public boolean decodeBoolean() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objDecodeValue).booleanValue();
    }

    @Override // A9.c
    public final boolean decodeBooleanElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeBoolean();
    }

    @Override // A9.e
    public byte decodeByte() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objDecodeValue).byteValue();
    }

    @Override // A9.c
    public final byte decodeByteElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeByte();
    }

    @Override // A9.e
    public char decodeChar() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objDecodeValue).charValue();
    }

    @Override // A9.c
    public final char decodeCharElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeChar();
    }

    @Override // A9.e
    public double decodeDouble() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override // A9.c
    public final double decodeDoubleElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeDouble();
    }

    @Override // A9.e
    public int decodeEnum(g enumDescriptor) {
        k.f(enumDescriptor, "enumDescriptor");
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // A9.e
    public float decodeFloat() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objDecodeValue).floatValue();
    }

    @Override // A9.c
    public final float decodeFloatElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeFloat();
    }

    @Override // A9.e
    public e decodeInline(g descriptor) {
        k.f(descriptor, "descriptor");
        return this;
    }

    @Override // A9.c
    public e decodeInlineElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeInline(descriptor.g(i));
    }

    @Override // A9.e
    public int decodeInt() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // A9.c
    public final int decodeIntElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeInt();
    }

    @Override // A9.e
    public long decodeLong() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objDecodeValue).longValue();
    }

    @Override // A9.c
    public final long decodeLongElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeLong();
    }

    @Override // A9.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // A9.e
    public Void decodeNull() {
        return null;
    }

    @Override // A9.c
    public final <T> T decodeNullableSerializableElement(g descriptor, int i, InterfaceC2123a deserializer, T t9) {
        k.f(descriptor, "descriptor");
        k.f(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializer, t9) : (T) decodeNull();
    }

    @Override // A9.c
    public <T> T decodeSerializableElement(g descriptor, int i, InterfaceC2123a deserializer, T t9) {
        k.f(descriptor, "descriptor");
        k.f(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer, t9);
    }

    public <T> T decodeSerializableValue(InterfaceC2123a deserializer, T t9) {
        k.f(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }

    @Override // A9.e
    public short decodeShort() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objDecodeValue).shortValue();
    }

    @Override // A9.c
    public final short decodeShortElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeShort();
    }

    @Override // A9.e
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        k.d(objDecodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeValue;
    }

    @Override // A9.c
    public final String decodeStringElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return decodeString();
    }

    public Object decodeValue() {
        throw new SerializationException(m.f4928a.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // A9.c
    public void endStructure(g descriptor) {
        k.f(descriptor, "descriptor");
    }
}
