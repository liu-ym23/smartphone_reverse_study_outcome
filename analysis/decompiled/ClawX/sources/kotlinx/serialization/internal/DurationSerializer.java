package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import m0.f;
import y5.d;
import y5.g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/DurationSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Duration;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-HG0u8IE", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-5sfh64U", "(Lkotlinx/serialization/encoding/Decoder;)J", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DurationSerializer implements KSerializer<y5.b> {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    private static final SerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.INSTANCE);

    private DurationSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* synthetic */ Object deserialize(Decoder decoder) {
        return new y5.b(m1deserialize5sfh64U(decoder));
    }

    /* renamed from: deserialize-5sfh64U, reason: not valid java name */
    public long m1deserialize5sfh64U(Decoder decoder) {
        p.e(decoder, "decoder");
        y5.a aVar = y5.b.f6335b;
        String value = decoder.decodeString();
        p.e(value, "value");
        try {
            long jF = g.f(value);
            if (jF == y5.b.f6337e) {
                throw new IllegalStateException("invariant failed");
            }
            return jF;
        } catch (IllegalArgumentException e9) {
            throw new IllegalArgumentException(f.d("Invalid ISO duration string format: '", value, "'."), e9);
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m2serializeHG0u8IE(encoder, ((y5.b) obj).f6338a);
    }

    /* renamed from: serialize-HG0u8IE, reason: not valid java name */
    public void m2serializeHG0u8IE(Encoder encoder, long value) {
        long j4;
        long j8;
        int iF;
        p.e(encoder, "encoder");
        y5.a aVar = y5.b.f6335b;
        StringBuilder sb = new StringBuilder();
        if (value < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z = true;
        if (value < 0) {
            j4 = ((-(value >> 1)) << 1) + (((int) value) & 1);
            int i8 = y5.c.f6339a;
        } else {
            j4 = value;
        }
        long jF = y5.b.f(j4, d.f6343f);
        if (y5.b.d(j4)) {
            j8 = 0;
            iF = 0;
        } else {
            j8 = 0;
            iF = (int) (y5.b.f(j4, d.f6342e) % 60);
        }
        int iF2 = y5.b.d(j4) ? 0 : (int) (y5.b.f(j4, d.d) % 60);
        int iC = y5.b.c(j4);
        if (y5.b.d(value)) {
            jF = 9999999999999L;
        }
        boolean z2 = jF != j8;
        boolean z8 = (iF2 == 0 && iC == 0) ? false : true;
        if (iF == 0 && (!z8 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(jF);
            sb.append('H');
        }
        if (z) {
            sb.append(iF);
            sb.append('M');
        }
        if (z8 || (!z2 && !z)) {
            y5.b.b(sb, iF2, iC, 9, "S", true);
        }
        encoder.encodeString(sb.toString());
    }
}
