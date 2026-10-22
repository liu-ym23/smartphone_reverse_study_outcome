package p0;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0893f;
import o0.EnumC0889b;
import o0.InterfaceC0890c;

/* renamed from: p0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0915b extends AbstractC0918e implements t {
    @Override // p0.AbstractC0918e, p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) f(c0888a, type, obj, null, 0);
    }

    @Override // p0.AbstractC0918e
    public <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5) throws Throwable {
        Object objS;
        SimpleDateFormat simpleDateFormat;
        Date date;
        SimpleDateFormat simpleDateFormat2;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 2) {
            long jF = interfaceC0890c.f();
            interfaceC0890c.A(16);
            if ("unixtime".equals(str)) {
                jF *= 1000;
            }
            objS = Long.valueOf(jF);
        } else {
            Date date2 = null;
            if (interfaceC0890c.U() == 4) {
                String strN = interfaceC0890c.N();
                if (str != null) {
                    if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(str) && (type instanceof Class) && ((Class) type).getName().equals("java.sql.Timestamp")) {
                        return (T) u0.o.A(strN);
                    }
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, c0888a.f18948f.s0());
                    } catch (IllegalArgumentException e6) {
                        if (str.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
                            try {
                                simpleDateFormat = new SimpleDateFormat(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), c0888a.f18948f.s0());
                            } catch (IllegalArgumentException unused) {
                                throw e6;
                            }
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    if (AbstractC0822a.f18016a != null) {
                        simpleDateFormat.setTimeZone(c0888a.f18948f.O());
                    }
                    try {
                        date = simpleDateFormat.parse(strN);
                    } catch (ParseException unused2) {
                        date = null;
                    }
                    if (date == null && AbstractC0822a.f18017b == Locale.CHINA) {
                        try {
                            simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                        } catch (IllegalArgumentException e7) {
                            simpleDateFormat2 = simpleDateFormat;
                            if (str.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
                                try {
                                    simpleDateFormat2 = new SimpleDateFormat(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), c0888a.f18948f.s0());
                                } catch (IllegalArgumentException unused3) {
                                    throw e7;
                                }
                            }
                        }
                        simpleDateFormat2.setTimeZone(c0888a.f18948f.O());
                        try {
                            date = simpleDateFormat2.parse(strN);
                        } catch (ParseException unused4) {
                            date = null;
                        }
                    }
                    if (date != null) {
                        date2 = date;
                    } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strN.length() == 19) {
                        try {
                            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", AbstractC0822a.f18017b);
                            simpleDateFormat3.setTimeZone(AbstractC0822a.f18016a);
                            date2 = simpleDateFormat3.parse(strN);
                        } catch (ParseException unused5) {
                        }
                    }
                }
                if (date2 == null) {
                    interfaceC0890c.A(16);
                    Object obj2 = strN;
                    if (interfaceC0890c.I(EnumC0889b.AllowISO8601DateFormat)) {
                        C0893f c0893f = new C0893f(strN);
                        Object time = strN;
                        if (c0893f.s1()) {
                            time = c0893f.F0().getTime();
                        }
                        c0893f.close();
                        obj2 = time;
                    }
                    objS = obj2;
                } else {
                    objS = date2;
                }
            } else if (interfaceC0890c.U() == 8) {
                interfaceC0890c.nextToken();
                objS = date2;
            } else if (interfaceC0890c.U() == 12) {
                interfaceC0890c.nextToken();
                if (interfaceC0890c.U() != 4) {
                    throw new l0.d("syntax error");
                }
                if (AbstractC0822a.f18018c.equals(interfaceC0890c.N())) {
                    interfaceC0890c.nextToken();
                    c0888a.a(17);
                    Class<?> clsI = c0888a.u().i(interfaceC0890c.N(), null, interfaceC0890c.Y());
                    if (clsI != null) {
                        type = clsI;
                    }
                    c0888a.a(4);
                    c0888a.a(16);
                }
                interfaceC0890c.L(2);
                if (interfaceC0890c.U() != 2) {
                    throw new l0.d("syntax error : " + interfaceC0890c.o0());
                }
                long jF2 = interfaceC0890c.f();
                interfaceC0890c.nextToken();
                objS = Long.valueOf(jF2);
                c0888a.a(13);
            } else if (c0888a.I() == 2) {
                c0888a.C0(0);
                c0888a.a(16);
                if (interfaceC0890c.U() != 4) {
                    throw new l0.d("syntax error");
                }
                if (!"val".equals(interfaceC0890c.N())) {
                    throw new l0.d("syntax error");
                }
                interfaceC0890c.nextToken();
                c0888a.a(17);
                objS = c0888a.S();
                c0888a.a(13);
            } else {
                objS = c0888a.S();
            }
        }
        return (T) g(c0888a, type, obj, objS);
    }

    protected abstract <T> T g(C0888a c0888a, Type type, Object obj, Object obj2);
}
