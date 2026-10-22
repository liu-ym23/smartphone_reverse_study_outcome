package p0;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0893f;

/* loaded from: classes.dex */
public class z extends AbstractC0915b implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final z f19348b = new z();

    /* renamed from: c, reason: collision with root package name */
    public static final z f19349c = new z(true);

    /* renamed from: a, reason: collision with root package name */
    private boolean f19350a = false;

    public z() {
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.AbstractC0915b
    protected <T> T g(C0888a c0888a, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (this.f19350a) {
            return (T) h(c0888a, type, obj, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new java.sql.Date(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.sql.Date(u0.o.D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.sql.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new l0.d("parse error : " + obj2);
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        C0893f c0893f = new C0893f(str);
        try {
            if (c0893f.s1()) {
                timeInMillis = c0893f.F0().getTimeInMillis();
            } else {
                try {
                    T t5 = (T) new java.sql.Date(c0888a.x().parse(str).getTime());
                    c0893f.close();
                    return t5;
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            c0893f.close();
            return (T) new java.sql.Date(timeInMillis);
        } catch (Throwable th) {
            c0893f.close();
            throw th;
        }
    }

    protected <T> T h(C0888a c0888a, Type type, Object obj, Object obj2) {
        long timeInMillis;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return (T) new Timestamp(((Date) obj2).getTime());
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Timestamp(u0.o.D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new Timestamp(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new l0.d("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        C0893f c0893f = new C0893f(str);
        try {
            if (str.length() > 19 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                String strW = c0888a.w();
                if (strW.length() != str.length() && strW == AbstractC0822a.f18020e) {
                    return (T) Timestamp.valueOf(str);
                }
            }
            if (c0893f.t1(false)) {
                timeInMillis = c0893f.F0().getTimeInMillis();
            } else {
                try {
                    return (T) new Timestamp(c0888a.x().parse(str).getTime());
                } catch (ParseException unused) {
                    timeInMillis = Long.parseLong(str);
                }
            }
            c0893f.close();
            return (T) new Timestamp(timeInMillis);
        } finally {
            c0893f.close();
        }
    }

    public z(boolean z5) {
    }
}
