package w2;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import v2.e;
import y2.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a extends JsonGenerator {
    public static final int h = (JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.f3551b | JsonGenerator.Feature.ESCAPE_NON_ASCII.f3551b) | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.f3551b;

    /* renamed from: b, reason: collision with root package name */
    public v2.c f13555b;

    /* renamed from: c, reason: collision with root package name */
    public int f13556c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13557d;

    /* renamed from: e, reason: collision with root package name */
    public d f13558e;

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final d K() {
        return this.f13558e;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final boolean P(JsonGenerator.Feature feature) {
        return (this.f13556c & feature.f3551b) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void Q(Object obj) {
        d dVar = this.f13558e;
        if (dVar != null) {
            dVar.f13989g = obj;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void X0(String str) {
        k1("write raw value");
        U0(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void Y0(e eVar) {
        k1("write raw value");
        V0(eVar);
    }

    public final String j1(BigDecimal bigDecimal) throws JsonGenerationException {
        if (!JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.a(this.f13556c)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -9999 && iScale <= 9999) {
            return bigDecimal.toPlainString();
        }
        a(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999));
        throw null;
    }

    public abstract void k1(String str);

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeObject(Object obj) {
        if (obj == null) {
            J0();
            return;
        }
        v2.c cVar = this.f13555b;
        if (cVar != null) {
            cVar.a(this, obj);
            return;
        }
        if (obj instanceof String) {
            f1((String) obj);
            return;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof Integer) {
                M0(number.intValue());
                return;
            }
            if (number instanceof Long) {
                N0(number.longValue());
                return;
            }
            if (number instanceof Double) {
                K0(number.doubleValue());
                return;
            }
            if (number instanceof Float) {
                L0(number.floatValue());
                return;
            }
            if (number instanceof Short) {
                R0(number.shortValue());
                return;
            }
            if (number instanceof Byte) {
                R0(number.byteValue());
                return;
            }
            if (number instanceof BigInteger) {
                Q0((BigInteger) number);
                return;
            }
            if (number instanceof BigDecimal) {
                P0((BigDecimal) number);
                return;
            } else if (number instanceof AtomicInteger) {
                M0(((AtomicInteger) number).get());
                return;
            } else if (number instanceof AtomicLong) {
                N0(((AtomicLong) number).get());
                return;
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            c0(v2.a.f13372b, bArr, 0, bArr.length);
            return;
        } else if (obj instanceof Boolean) {
            g0(((Boolean) obj).booleanValue());
            return;
        } else if (obj instanceof AtomicBoolean) {
            g0(((AtomicBoolean) obj).get());
            return;
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
    }
}
