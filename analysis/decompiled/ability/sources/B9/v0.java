package B9;

import j9.AbstractC1610d;
import kotlin.uuid.Uuid;
import z9.C2203e;

/* loaded from: classes4.dex */
public final class v0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f261a = new v0();
    public static final Z b = new Z("kotlin.uuid.Uuid", C2203e.k);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        String strConcat;
        kotlin.jvm.internal.k.f(decoder, "decoder");
        String uuidString = decoder.decodeString();
        kotlin.jvm.internal.k.f(uuidString, "uuidString");
        int length = uuidString.length();
        if (length == 32) {
            long jB = AbstractC1610d.b(0, 16, uuidString);
            long jB2 = AbstractC1610d.b(16, 32, uuidString);
            if (jB != 0 || jB2 != 0) {
                return new Uuid(jB, jB2);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if (uuidString.length() <= 64) {
                    strConcat = uuidString;
                } else {
                    String strSubstring = uuidString.substring(0, 64);
                    kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
                    strConcat = strSubstring.concat("...");
                }
                sb.append(strConcat);
                sb.append("\" of length ");
                sb.append(uuidString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long jB3 = AbstractC1610d.b(0, 8, uuidString);
            M0.i.r(8, uuidString);
            long jB4 = AbstractC1610d.b(9, 13, uuidString);
            M0.i.r(13, uuidString);
            long jB5 = AbstractC1610d.b(14, 18, uuidString);
            M0.i.r(18, uuidString);
            long jB6 = AbstractC1610d.b(19, 23, uuidString);
            M0.i.r(23, uuidString);
            long j5 = (jB4 << 16) | (jB3 << 32) | jB5;
            long jB7 = AbstractC1610d.b(24, 36, uuidString) | (jB6 << 48);
            if (j5 != 0 || jB7 != 0) {
                return new Uuid(j5, jB7);
            }
        }
        return Uuid.c;
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        Uuid value = (Uuid) obj;
        kotlin.jvm.internal.k.f(value, "value");
        fVar.encodeString(value.toString());
    }
}
