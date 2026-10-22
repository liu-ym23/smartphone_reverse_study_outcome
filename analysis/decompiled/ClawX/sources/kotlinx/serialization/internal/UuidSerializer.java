package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import x5.e;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/internal/UuidSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/uuid/Uuid;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UuidSerializer implements KSerializer<z5.b> {
    public static final UuidSerializer INSTANCE = new UuidSerializer();
    private static final SerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.uuid.Uuid", PrimitiveKind.STRING.INSTANCE);

    private UuidSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public z5.b deserialize(Decoder decoder) {
        String strConcat;
        p.e(decoder, "decoder");
        String uuidString = decoder.decodeString();
        p.e(uuidString, "uuidString");
        int length = uuidString.length();
        int i8 = 0;
        if (length == 32) {
            long j4 = 0;
            while (i8 < 16) {
                long j8 = j4 << 4;
                char cCharAt = uuidString.charAt(i8);
                if ((cCharAt >>> '\b') == 0) {
                    long j9 = e.f6288b[cCharAt];
                    if (j9 >= 0) {
                        j4 = j8 | j9;
                        i8++;
                    }
                }
                x.e.B0(i8, uuidString, "a hexadecimal digit");
                throw null;
            }
            long j10 = 0;
            for (int i9 = 16; i9 < 32; i9++) {
                long j11 = j10 << 4;
                char cCharAt2 = uuidString.charAt(i9);
                if ((cCharAt2 >>> '\b') == 0) {
                    long j12 = e.f6288b[cCharAt2];
                    if (j12 >= 0) {
                        j10 = j11 | j12;
                    }
                }
                x.e.B0(i9, uuidString, "a hexadecimal digit");
                throw null;
            }
            if (j4 != 0 || j10 != 0) {
                return new z5.b(j4, j10);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if (uuidString.length() <= 64) {
                    strConcat = uuidString;
                } else {
                    String strSubstring = uuidString.substring(0, 64);
                    p.d(strSubstring, "substring(...)");
                    strConcat = strSubstring.concat("...");
                }
                sb.append(strConcat);
                sb.append("\" of length ");
                sb.append(uuidString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long j13 = 0;
            while (i8 < 8) {
                long j14 = j13 << 4;
                char cCharAt3 = uuidString.charAt(i8);
                if ((cCharAt3 >>> '\b') == 0) {
                    long j15 = e.f6288b[cCharAt3];
                    if (j15 >= 0) {
                        j13 = j14 | j15;
                        i8++;
                    }
                }
                x.e.B0(i8, uuidString, "a hexadecimal digit");
                throw null;
            }
            if (uuidString.charAt(8) != '-') {
                x.e.B0(8, uuidString, "'-' (hyphen)");
                throw null;
            }
            long j16 = 0;
            for (int i10 = 9; i10 < 13; i10++) {
                long j17 = j16 << 4;
                char cCharAt4 = uuidString.charAt(i10);
                if ((cCharAt4 >>> '\b') == 0) {
                    long j18 = e.f6288b[cCharAt4];
                    if (j18 >= 0) {
                        j16 = j17 | j18;
                    }
                }
                x.e.B0(i10, uuidString, "a hexadecimal digit");
                throw null;
            }
            if (uuidString.charAt(13) != '-') {
                x.e.B0(13, uuidString, "'-' (hyphen)");
                throw null;
            }
            long j19 = 0;
            for (int i11 = 14; i11 < 18; i11++) {
                long j20 = j19 << 4;
                char cCharAt5 = uuidString.charAt(i11);
                if ((cCharAt5 >>> '\b') == 0) {
                    long j21 = e.f6288b[cCharAt5];
                    if (j21 >= 0) {
                        j19 = j20 | j21;
                    }
                }
                x.e.B0(i11, uuidString, "a hexadecimal digit");
                throw null;
            }
            if (uuidString.charAt(18) != '-') {
                x.e.B0(18, uuidString, "'-' (hyphen)");
                throw null;
            }
            long j22 = 0;
            for (int i12 = 19; i12 < 23; i12++) {
                long j23 = j22 << 4;
                char cCharAt6 = uuidString.charAt(i12);
                if ((cCharAt6 >>> '\b') == 0) {
                    long j24 = e.f6288b[cCharAt6];
                    if (j24 >= 0) {
                        j22 = j23 | j24;
                    }
                }
                x.e.B0(i12, uuidString, "a hexadecimal digit");
                throw null;
            }
            if (uuidString.charAt(23) != '-') {
                x.e.B0(23, uuidString, "'-' (hyphen)");
                throw null;
            }
            long j25 = 0;
            for (int i13 = 24; i13 < 36; i13++) {
                long j26 = j25 << 4;
                char cCharAt7 = uuidString.charAt(i13);
                if ((cCharAt7 >>> '\b') == 0) {
                    long j27 = e.f6288b[cCharAt7];
                    if (j27 >= 0) {
                        j25 = j26 | j27;
                    }
                }
                x.e.B0(i13, uuidString, "a hexadecimal digit");
                throw null;
            }
            long j28 = (j13 << 32) | (j16 << 16) | j19;
            long j29 = (j22 << 48) | j25;
            if (j28 != 0 || j29 != 0) {
                return new z5.b(j28, j29);
            }
        }
        return z5.b.d;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, z5.b value) {
        p.e(encoder, "encoder");
        p.e(value, "value");
        encoder.encodeString(value.toString());
    }
}
