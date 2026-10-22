package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0893f;
import p0.AbstractC0915b;

/* renamed from: q0.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0975w extends AbstractC0915b implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0975w f19876a = new C0975w();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        char[] charArray;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.Y();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == Date.class && !e0Var.v(f0.WriteDateUseDateFormat)) {
            if ((((Date) obj).getTime() + c0946i.f19684s.getOffset(r7)) % 86400000 == 0 && !f0.d(e0Var.f19798c, i5, f0.WriteClassName)) {
                e0Var.h0(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time = ((Time) obj).getTime();
            if ("unixtime".equals(c0946i.v())) {
                e0Var.X(time / 1000);
                return;
            } else if ("millis".equals(c0946i.v())) {
                e0Var.X(time);
                return;
            } else if (time < 86400000) {
                e0Var.h0(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        java.util.Date dateO = obj instanceof java.util.Date ? (java.util.Date) obj : u0.o.o(obj);
        if ("unixtime".equals(c0946i.v())) {
            e0Var.X(dateO.getTime() / 1000);
            return;
        }
        if ("millis".equals(c0946i.v())) {
            e0Var.X(dateO.getTime());
            return;
        }
        if (e0Var.v(f0.WriteDateUseDateFormat)) {
            DateFormat dateFormatU = c0946i.u();
            if (dateFormatU == null) {
                String strW = c0946i.w();
                if (strW == null) {
                    strW = AbstractC0822a.f18020e;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strW, c0946i.f19685t);
                simpleDateFormat.setTimeZone(c0946i.f19684s);
                dateFormatU = simpleDateFormat;
            }
            e0Var.h0(dateFormatU.format(dateO));
            return;
        }
        if (e0Var.v(f0.WriteClassName) && cls != type) {
            if (cls == java.util.Date.class) {
                e0Var.write("new Date(");
                e0Var.X(((java.util.Date) obj).getTime());
                e0Var.write(41);
                return;
            } else {
                e0Var.write(123);
                e0Var.D(AbstractC0822a.f18018c);
                c0946i.H(cls.getName());
                e0Var.L(',', "val", ((java.util.Date) obj).getTime());
                e0Var.write(125);
                return;
            }
        }
        long time2 = dateO.getTime();
        if (!e0Var.v(f0.UseISO8601DateFormat)) {
            e0Var.X(time2);
            return;
        }
        int i6 = e0Var.v(f0.UseSingleQuotes) ? 39 : 34;
        e0Var.write(i6);
        Calendar calendar = Calendar.getInstance(c0946i.f19684s, c0946i.f19685t);
        calendar.setTimeInMillis(time2);
        int i7 = calendar.get(1);
        int i8 = calendar.get(2) + 1;
        int i9 = calendar.get(5);
        int i10 = calendar.get(11);
        int i11 = calendar.get(12);
        int i12 = calendar.get(13);
        int i13 = calendar.get(14);
        if (nanos > 0) {
            charArray = "0000-00-00 00:00:00.000000000".toCharArray();
            u0.g.f(nanos, 29, charArray);
            u0.g.f(i12, 19, charArray);
            u0.g.f(i11, 16, charArray);
            u0.g.f(i10, 13, charArray);
            u0.g.f(i9, 10, charArray);
            u0.g.f(i8, 7, charArray);
            u0.g.f(i7, 4, charArray);
        } else if (i13 != 0) {
            char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
            u0.g.f(i13, 23, charArray2);
            u0.g.f(i12, 19, charArray2);
            u0.g.f(i11, 16, charArray2);
            u0.g.f(i10, 13, charArray2);
            u0.g.f(i9, 10, charArray2);
            u0.g.f(i8, 7, charArray2);
            u0.g.f(i7, 4, charArray2);
            charArray = charArray2;
        } else if (i12 == 0 && i11 == 0 && i10 == 0) {
            char[] charArray3 = "0000-00-00".toCharArray();
            u0.g.f(i9, 10, charArray3);
            u0.g.f(i8, 7, charArray3);
            u0.g.f(i7, 4, charArray3);
            charArray = charArray3;
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            u0.g.f(i12, 19, charArray);
            u0.g.f(i11, 16, charArray);
            u0.g.f(i10, 13, charArray);
            u0.g.f(i9, 10, charArray);
            u0.g.f(i8, 7, charArray);
            u0.g.f(i7, 4, charArray);
        }
        if (nanos > 0) {
            int i14 = 0;
            while (i14 < 9 && charArray[(charArray.length - i14) - 1] == '0') {
                i14++;
            }
            e0Var.write(charArray, 0, charArray.length - i14);
            e0Var.write(i6);
            return;
        }
        e0Var.write(charArray);
        float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
        int i15 = (int) offset;
        if (i15 == 0.0d) {
            e0Var.write(90);
        } else {
            if (i15 > 9) {
                e0Var.write(43);
                e0Var.V(i15);
            } else if (i15 > 0) {
                e0Var.write(43);
                e0Var.write(48);
                e0Var.V(i15);
            } else if (i15 < -9) {
                e0Var.write(45);
                e0Var.V(-i15);
            } else if (i15 < 0) {
                e0Var.write(45);
                e0Var.write(48);
                e0Var.V(-i15);
            }
            e0Var.write(58);
            e0Var.append(String.format("%02d", Integer.valueOf((int) (Math.abs(offset - i15) * 60.0f))));
        }
        e0Var.write(i6);
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r4v15, types: [T, java.util.Calendar] */
    @Override // p0.AbstractC0915b
    public <T> T g(C0888a c0888a, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new java.util.Date(u0.o.D0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return (T) new java.util.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new l0.d("parse error");
        }
        String strSubstring = (String) obj2;
        if (strSubstring.length() == 0) {
            return null;
        }
        if (strSubstring.length() == 23 && strSubstring.endsWith(" 000")) {
            strSubstring = strSubstring.substring(0, 19);
        }
        C0893f c0893f = new C0893f(strSubstring);
        try {
            if (c0893f.t1(false)) {
                ?? r42 = (T) c0893f.F0();
                return type == Calendar.class ? r42 : (T) r42.getTime();
            }
            c0893f.close();
            String strW = c0888a.w();
            if (strSubstring.length() == strW.length() || ((strSubstring.length() == 22 && strW.equals("yyyyMMddHHmmssSSSZ")) || (strSubstring.indexOf(84) != -1 && strW.contains("'T'") && strSubstring.length() + 2 == strW.length()))) {
                try {
                    return (T) c0888a.x().parse(strSubstring);
                } catch (ParseException unused) {
                }
            }
            if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
            }
            if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                return null;
            }
            int iLastIndexOf = strSubstring.lastIndexOf(124);
            if (iLastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    C0893f c0893f2 = new C0893f(strSubstring.substring(0, iLastIndexOf));
                    try {
                        if (c0893f2.t1(false)) {
                            ?? r43 = (T) c0893f2.F0();
                            r43.setTimeZone(timeZone);
                            return type == Calendar.class ? r43 : (T) r43.getTime();
                        }
                    } finally {
                    }
                }
            }
            return (T) new java.util.Date(Long.parseLong(strSubstring));
        } finally {
        }
    }
}
