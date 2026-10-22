package A1;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class o extends j {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f66b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a, reason: collision with root package name */
    private Object f67a;

    public o(Boolean bool) {
        A(bool);
    }

    private static boolean w(o oVar) {
        Object obj = oVar.f67a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean y(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f66b) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    void A(Object obj) {
        if (obj instanceof Character) {
            this.f67a = String.valueOf(((Character) obj).charValue());
        } else {
            C1.a.a((obj instanceof Number) || y(obj));
            this.f67a = obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f67a == null) {
            return oVar.f67a == null;
        }
        if (w(this) && w(oVar)) {
            return t().longValue() == oVar.t().longValue();
        }
        Object obj2 = this.f67a;
        if (!(obj2 instanceof Number) || !(oVar.f67a instanceof Number)) {
            return obj2.equals(oVar.f67a);
        }
        double dDoubleValue = t().doubleValue();
        double dDoubleValue2 = oVar.t().doubleValue();
        return dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2));
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f67a == null) {
            return 31;
        }
        if (w(this)) {
            jDoubleToLongBits = t().longValue();
        } else {
            Object obj = this.f67a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(t().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean o() {
        return v() ? p().booleanValue() : Boolean.parseBoolean(u());
    }

    Boolean p() {
        return (Boolean) this.f67a;
    }

    public double q() {
        return x() ? t().doubleValue() : Double.parseDouble(u());
    }

    public int r() {
        return x() ? t().intValue() : Integer.parseInt(u());
    }

    public long s() {
        return x() ? t().longValue() : Long.parseLong(u());
    }

    public Number t() {
        Object obj = this.f67a;
        return obj instanceof String ? new C1.g((String) obj) : (Number) obj;
    }

    public String u() {
        return x() ? t().toString() : v() ? p().toString() : (String) this.f67a;
    }

    public boolean v() {
        return this.f67a instanceof Boolean;
    }

    public boolean x() {
        return this.f67a instanceof Number;
    }

    public boolean z() {
        return this.f67a instanceof String;
    }

    public o(Number number) {
        A(number);
    }

    public o(String str) {
        A(str);
    }
}
