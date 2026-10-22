package K1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public final class h implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final h f4037a = new h();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        char[] charArray;
        z zVar = mVar.f4048b;
        if (obj == null) {
            zVar.Y();
            return;
        }
        if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0 && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                zVar.write("new Date(");
                zVar.writeLong(((Date) obj).getTime());
                zVar.write(41);
                return;
            }
            zVar.write(123);
            zVar.J("@type", false);
            mVar.s(obj.getClass().getName());
            zVar.write(44);
            zVar.J("val", false);
            zVar.writeLong(((Date) obj).getTime());
            zVar.write(125);
            return;
        }
        Date time = obj instanceof Calendar ? ((Calendar) obj).getTime() : (Date) obj;
        if ((zVar.f4092c & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
            DateFormat dateFormatG = mVar.g();
            if (dateFormatG == null) {
                dateFormatG = new SimpleDateFormat(G1.a.f2775d, mVar.f4061o);
                dateFormatG.setTimeZone(mVar.f4060n);
            }
            zVar.e0(dateFormatG.format(time));
            return;
        }
        long time2 = time.getTime();
        int i10 = zVar.f4092c;
        if ((SerializerFeature.UseISO8601DateFormat.mask & i10) == 0) {
            zVar.writeLong(time2);
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseSingleQuotes;
        if ((i10 & serializerFeature.mask) != 0) {
            zVar.write(39);
        } else {
            zVar.write(34);
        }
        Calendar calendar = Calendar.getInstance(mVar.f4060n, mVar.f4061o);
        calendar.setTimeInMillis(time2);
        int i11 = calendar.get(1);
        int i12 = calendar.get(2) + 1;
        int i13 = calendar.get(5);
        int i14 = calendar.get(11);
        int i15 = calendar.get(12);
        int i16 = calendar.get(13);
        int i17 = calendar.get(14);
        if (i17 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            z.m(i17, 23, charArray);
            z.m(i16, 19, charArray);
            z.m(i15, 16, charArray);
            z.m(i14, 13, charArray);
            z.m(i13, 10, charArray);
            z.m(i12, 7, charArray);
            z.m(i11, 4, charArray);
        } else if (i16 == 0 && i15 == 0 && i14 == 0) {
            charArray = "0000-00-00".toCharArray();
            z.m(i13, 10, charArray);
            z.m(i12, 7, charArray);
            z.m(i11, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            z.m(i16, 19, charArray);
            z.m(i15, 16, charArray);
            z.m(i14, 13, charArray);
            z.m(i13, 10, charArray);
            z.m(i12, 7, charArray);
            z.m(i11, 4, charArray);
        }
        zVar.write(charArray);
        if ((zVar.f4092c & serializerFeature.mask) != 0) {
            zVar.write(39);
        } else {
            zVar.write(34);
        }
    }

    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        return (T) d(bVar, type, obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.util.Calendar] */
    public <T> T c(I1.b bVar, Type type, Object obj, Object obj2, String str) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str2 = (String) obj2;
        if (str2.length() == 0) {
            return null;
        }
        I1.d dVar = new I1.d(str2);
        try {
            if (dVar.K(false)) {
                ?? r12 = (T) dVar.f3294o;
                return type == Calendar.class ? r12 : (T) r12.getTime();
            }
            dVar.e();
            if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                return null;
            }
            try {
                return (T) (str != null ? new SimpleDateFormat(str) : bVar.l()).parse(str2);
            } catch (ParseException unused) {
                return (T) new Date(Long.parseLong(str2));
            }
        } finally {
            dVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.util.Calendar] */
    public <T> T d(I1.b bVar, Type type, Object obj, String str) throws ClassNotFoundException, NumberFormatException {
        h hVar;
        I1.b bVar2;
        Type type2;
        Object obj2;
        String str2;
        Object obj3;
        T t10;
        Object objJ;
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 2) {
            Long lValueOf = Long.valueOf(dVar.n());
            dVar.t(16);
            objJ = lValueOf;
        } else if (iA0 == 4) {
            String strX = dVar.X();
            dVar.t(16);
            objJ = strX;
            if ((dVar.f3282c & Feature.AllowISO8601DateFormat.mask) != 0) {
                I1.d dVar2 = new I1.d(strX);
                Object time = strX;
                if (dVar2.K(true)) {
                    ?? r12 = (T) dVar2.f3294o;
                    if (type == Calendar.class) {
                        dVar2.e();
                        return r12;
                    }
                    time = r12.getTime();
                }
                dVar2.e();
                objJ = time;
            }
        } else {
            if (iA0 == 8) {
                dVar.s();
                hVar = this;
                bVar2 = bVar;
                type2 = type;
                obj2 = obj;
                str2 = str;
                obj3 = null;
                t10 = (T) hVar.c(bVar2, type2, obj2, obj3, str2);
                if (type2 != Calendar.class && !(t10 instanceof Calendar)) {
                    Date date = (Date) t10;
                    if (date == null) {
                        return null;
                    }
                    ?? r122 = (T) Calendar.getInstance(dVar.f3292m, dVar.f3293n);
                    r122.setTime(date);
                    return r122;
                }
            }
            if (iA0 == 12) {
                dVar.s();
                if (dVar.a0() != 4) {
                    throw new JSONException("syntax error");
                }
                if ("@type".equals(dVar.X())) {
                    dVar.s();
                    bVar.b(17);
                    Class<?> clsF = L1.d.F(dVar.X(), bVar.f3255b.f3334c);
                    if (clsF != null) {
                        type = clsF;
                    }
                    bVar.b(4);
                    bVar.b(16);
                }
                dVar.u(':');
                int iA02 = dVar.a0();
                if (iA02 != 2) {
                    throw new JSONException("syntax error : " + I1.e.a(iA02));
                }
                long jN = dVar.n();
                dVar.s();
                Long lValueOf2 = Long.valueOf(jN);
                bVar.b(13);
                objJ = lValueOf2;
            } else if (bVar.f3263j == 2) {
                bVar.f3263j = 0;
                bVar.b(16);
                if (dVar.a0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(dVar.X())) {
                    throw new JSONException("syntax error");
                }
                dVar.s();
                bVar.b(17);
                Object objJ2 = bVar.J();
                bVar.b(13);
                objJ = objJ2;
            } else {
                objJ = bVar.J();
            }
        }
        hVar = this;
        bVar2 = bVar;
        type2 = type;
        obj2 = obj;
        str2 = str;
        obj3 = objJ;
        t10 = (T) hVar.c(bVar2, type2, obj2, obj3, str2);
        return type2 != Calendar.class ? t10 : t10;
    }
}
