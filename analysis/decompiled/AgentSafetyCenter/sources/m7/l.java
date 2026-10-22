package m7;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends g {

    /* renamed from: c, reason: collision with root package name */
    public Serializable f8267c;

    public l(String str) {
        Objects.requireNonNull(str);
        this.f8267c = str;
    }

    public static boolean k(l lVar) {
        Serializable serializable = lVar.f8267c;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // m7.g
    public final boolean b() {
        Serializable serializable = this.f8267c;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(i());
    }

    @Override // m7.g
    public final double c() {
        return this.f8267c instanceof Number ? h().doubleValue() : Double.parseDouble(i());
    }

    public final boolean equals(Object obj) {
        Serializable serializable = this.f8267c;
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        Serializable serializable2 = lVar.f8267c;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (k(this) && k(lVar)) {
            return ((serializable instanceof BigInteger) || (serializable2 instanceof BigInteger)) ? j().equals(lVar.j()) : h().longValue() == lVar.h().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        if ((serializable instanceof BigDecimal) && (serializable2 instanceof BigDecimal)) {
            return (serializable instanceof BigDecimal ? (BigDecimal) serializable : o7.h.j(i())).compareTo(serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : o7.h.j(lVar.i())) == 0;
        }
        double dC = c();
        double dC2 = lVar.c();
        if (dC != dC2) {
            return Double.isNaN(dC) && Double.isNaN(dC2);
        }
        return true;
    }

    @Override // m7.g
    public final long g() {
        return this.f8267c instanceof Number ? h().longValue() : Long.parseLong(i());
    }

    @Override // m7.g
    public final Number h() {
        Serializable serializable = this.f8267c;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new o7.j((String) serializable);
        }
        g5.f.o("Primitive is neither a number nor a string");
        return null;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f8267c;
        if (serializable == null) {
            return 31;
        }
        if (k(this)) {
            jDoubleToLongBits = h().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(h().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    @Override // m7.g
    public final String i() {
        Serializable serializable = this.f8267c;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return h().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final BigInteger j() {
        Serializable serializable = this.f8267c;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (k(this)) {
            return BigInteger.valueOf(h().longValue());
        }
        String strI = i();
        o7.h.c(strI);
        return new BigInteger(strI);
    }

    @Override // m7.g
    public final g a() {
        return this;
    }
}
