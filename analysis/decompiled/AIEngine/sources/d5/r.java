package d5;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.internal.LazilyParsedNumber;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r extends o {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f8384a;

    public r(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f8384a = bool;
    }

    public static boolean j(r rVar) {
        Serializable serializable = rVar.f8384a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // d5.o
    public final boolean a() {
        Serializable serializable = this.f8384a;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(f());
    }

    @Override // d5.o
    public final int b() {
        return this.f8384a instanceof Number ? i().intValue() : Integer.parseInt(f());
    }

    @Override // d5.o
    public final long e() {
        return this.f8384a instanceof Number ? i().longValue() : Long.parseLong(f());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        Serializable serializable = rVar.f8384a;
        Serializable serializable2 = this.f8384a;
        if (serializable2 == null) {
            return serializable == null;
        }
        if (j(this) && j(rVar)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? g().equals(rVar.g()) : i().longValue() == rVar.i().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : b1.R(f())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : b1.R(rVar.f())) == 0;
        }
        double dH = h();
        double dH2 = rVar.h();
        if (dH != dH2) {
            return Double.isNaN(dH) && Double.isNaN(dH2);
        }
        return true;
    }

    @Override // d5.o
    public final String f() {
        Serializable serializable = this.f8384a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return i().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final BigInteger g() {
        Serializable serializable = this.f8384a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (j(this)) {
            return BigInteger.valueOf(i().longValue());
        }
        String strF = f();
        b1.k(strF);
        return new BigInteger(strF);
    }

    public final double h() {
        return this.f8384a instanceof Number ? i().doubleValue() : Double.parseDouble(f());
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f8384a;
        if (serializable == null) {
            return 31;
        }
        if (j(this)) {
            jDoubleToLongBits = i().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(i().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final Number i() {
        Serializable serializable = this.f8384a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new LazilyParsedNumber((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public r(Number number) {
        Objects.requireNonNull(number);
        this.f8384a = number;
    }

    public r(String str) {
        Objects.requireNonNull(str);
        this.f8384a = str;
    }
}
