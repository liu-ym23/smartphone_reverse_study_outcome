package A9;

import B9.M;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlinx.serialization.SerializationException;
import z9.g;

/* loaded from: classes4.dex */
public abstract class b implements f, d {
    @Override // A9.f
    public d beginStructure(g descriptor) {
        k.f(descriptor, "descriptor");
        return this;
    }

    @Override // A9.f
    public abstract void encodeBoolean(boolean z10);

    @Override // A9.d
    public final void encodeBooleanElement(g descriptor, int i, boolean z10) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeBoolean(z10);
        }
    }

    @Override // A9.f
    public abstract void encodeByte(byte b);

    @Override // A9.d
    public final void encodeByteElement(g descriptor, int i, byte b) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // A9.f
    public abstract void encodeChar(char c);

    @Override // A9.d
    public final void encodeCharElement(g descriptor, int i, char c) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // A9.f
    public abstract void encodeDouble(double d);

    @Override // A9.d
    public final void encodeDoubleElement(g descriptor, int i, double d) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeDouble(d);
        }
    }

    public boolean encodeElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return true;
    }

    @Override // A9.f
    public abstract void encodeFloat(float f);

    @Override // A9.d
    public final void encodeFloatElement(g descriptor, int i, float f) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // A9.f
    public f encodeInline(g descriptor) {
        k.f(descriptor, "descriptor");
        return this;
    }

    @Override // A9.d
    public final f encodeInlineElement(g descriptor, int i) {
        k.f(descriptor, "descriptor");
        return encodeElement(descriptor, i) ? encodeInline(descriptor.g(i)) : M.f224a;
    }

    @Override // A9.f
    public abstract void encodeInt(int i);

    @Override // A9.d
    public final void encodeIntElement(g descriptor, int i, int i6) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeInt(i6);
        }
    }

    @Override // A9.f
    public abstract void encodeLong(long j5);

    @Override // A9.d
    public final void encodeLongElement(g descriptor, int i, long j5) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeLong(j5);
        }
    }

    @Override // A9.d
    public <T> void encodeNullableSerializableElement(g descriptor, int i, x9.f serializer, T t9) {
        k.f(descriptor, "descriptor");
        k.f(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeNullableSerializableValue(serializer, t9);
        }
    }

    @Override // A9.d
    public <T> void encodeSerializableElement(g descriptor, int i, x9.f serializer, T t9) {
        k.f(descriptor, "descriptor");
        k.f(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeSerializableValue(serializer, t9);
        }
    }

    @Override // A9.f
    public abstract void encodeShort(short s5);

    @Override // A9.d
    public final void encodeShortElement(g descriptor, int i, short s5) {
        k.f(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeShort(s5);
        }
    }

    @Override // A9.f
    public abstract void encodeString(String str);

    @Override // A9.d
    public final void encodeStringElement(g descriptor, int i, String value) {
        k.f(descriptor, "descriptor");
        k.f(value, "value");
        if (encodeElement(descriptor, i)) {
            encodeString(value);
        }
    }

    public void encodeValue(Object value) {
        k.f(value, "value");
        StringBuilder sb = new StringBuilder("Non-serializable ");
        Class<?> cls = value.getClass();
        n nVar = m.f4928a;
        sb.append(nVar.b(cls));
        sb.append(" is not supported by ");
        sb.append(nVar.b(getClass()));
        sb.append(" encoder");
        throw new SerializationException(sb.toString());
    }

    @Override // A9.d
    public void endStructure(g descriptor) {
        k.f(descriptor, "descriptor");
    }
}
