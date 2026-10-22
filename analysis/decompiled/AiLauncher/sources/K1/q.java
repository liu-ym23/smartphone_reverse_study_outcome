package K1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class q implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final q f4069a = new q();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                mVar.s("");
                return;
            } else if ((zVar.f4092c & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Enumeration.class.isAssignableFrom(L1.d.x(type))) {
                zVar.Y();
                return;
            } else {
                zVar.write("[]");
                return;
            }
        }
        if (obj instanceof Pattern) {
            mVar.s(((Pattern) obj).pattern());
            return;
        }
        if (obj instanceof TimeZone) {
            mVar.s(((TimeZone) obj).getID());
            return;
        }
        if (obj instanceof Currency) {
            mVar.s(((Currency) obj).getCurrencyCode());
            return;
        }
        if (obj instanceof Class) {
            mVar.s(((Class) obj).getName());
            return;
        }
        if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == 0) {
                mVar.s("\u0000");
                return;
            } else {
                mVar.s(ch.toString());
                return;
            }
        }
        int i10 = 0;
        if (obj instanceof SimpleDateFormat) {
            String pattern = ((SimpleDateFormat) obj).toPattern();
            if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                zVar.e0(pattern);
                return;
            }
            zVar.write(123);
            zVar.J("@type", false);
            mVar.s(obj.getClass().getName());
            zVar.write(44);
            zVar.J("val", false);
            zVar.e0(pattern);
            zVar.write(125);
            return;
        }
        if (obj instanceof G1.c) {
            ((G1.c) obj).i(zVar);
            return;
        }
        if (obj instanceof G1.b) {
            zVar.write(((G1.b) obj).j());
            return;
        }
        if (obj instanceof l) {
            ((l) obj).a(mVar, obj2, type);
            return;
        }
        if (!(obj instanceof Enumeration)) {
            mVar.s(obj.toString());
            return;
        }
        Type type2 = ((zVar.f4092c & SerializerFeature.WriteClassName.mask) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
        Enumeration enumeration = (Enumeration) obj;
        w wVar = mVar.f4059m;
        mVar.p(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i11 = i10 + 1;
                if (i10 != 0) {
                    zVar.write(44);
                }
                if (objNextElement == null) {
                    zVar.Y();
                } else {
                    mVar.f4047a.a(objNextElement.getClass()).a(mVar, objNextElement, Integer.valueOf(i10), type2);
                }
                i10 = i11;
            }
            zVar.write(93);
            mVar.f4059m = wVar;
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        Object objJ;
        if (type == StackTraceElement.class) {
            return (T) c(bVar);
        }
        I1.d dVar = bVar.f3258e;
        if (bVar.f3263j == 2) {
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
            objJ = bVar.J();
            bVar.b(13);
        } else {
            objJ = bVar.J();
        }
        if (objJ == null) {
            return null;
        }
        if (!(objJ instanceof String)) {
            if (objJ instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) objJ;
                if (type == Currency.class) {
                    String strT = jSONObject.T("currency");
                    if (strT != null) {
                        return (T) Currency.getInstance(strT);
                    }
                    String strT2 = jSONObject.T("currencyCode");
                    if (strT2 != null) {
                        return (T) Currency.getInstance(strT2);
                    }
                }
                if (type == Map.Entry.class) {
                    return (T) jSONObject.entrySet().iterator().next();
                }
            }
            throw new JSONException("except string value");
        }
        String str = (String) objJ;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) L1.d.F(str, bVar.f3255b.f3334c);
        }
        if (type == Locale.class) {
            String[] strArrSplit = str.split("_");
            return strArrSplit.length == 1 ? (T) new Locale(strArrSplit[0]) : strArrSplit.length == 2 ? (T) new Locale(strArrSplit[0], strArrSplit[1]) : (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        if (type == URI.class) {
            return (T) URI.create(str);
        }
        if (type == URL.class) {
            try {
                return (T) new URL(str);
            } catch (MalformedURLException e10) {
                throw new JSONException("create url error", e10);
            }
        }
        if (type == Pattern.class) {
            return (T) Pattern.compile(str);
        }
        if (type == Charset.class) {
            return (T) Charset.forName(str);
        }
        if (type == Currency.class) {
            return (T) Currency.getInstance(str);
        }
        if (type == SimpleDateFormat.class) {
            ?? r62 = (T) new SimpleDateFormat(str, bVar.f3258e.f3293n);
            r62.setTimeZone(bVar.f3258e.f3292m);
            return r62;
        }
        if (type == Character.TYPE || type == Character.class) {
            return (T) L1.d.i(str);
        }
        if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
            return (T) TimeZone.getTimeZone(str);
        }
        try {
            return (T) Class.forName("android.net.Uri").getMethod(M5.e.FAIL_PARSE, String.class).invoke(null, str);
        } catch (Exception e11) {
            throw new JSONException("parse android.net.Uri error.", e11);
        }
    }

    public <T> T c(I1.b bVar) {
        I1.d dVar = bVar.f3258e;
        if (dVar.a0() == 8) {
            dVar.s();
            return null;
        }
        if (dVar.a0() != 12 && dVar.a0() != 16) {
            throw new JSONException("syntax error: " + I1.e.a(dVar.a0()));
        }
        int iJ = 0;
        String strX = null;
        String strX2 = null;
        String strX3 = null;
        while (true) {
            String strR = dVar.R(bVar.f3254a);
            if (strR == null) {
                if (dVar.a0() == 13) {
                    dVar.t(16);
                    break;
                }
                if (dVar.a0() == 16) {
                    continue;
                }
            }
            dVar.u(':');
            if ("className".equals(strR)) {
                if (dVar.a0() == 8) {
                    strX = null;
                } else {
                    if (dVar.a0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strX = dVar.X();
                }
            } else if ("methodName".equals(strR)) {
                if (dVar.a0() == 8) {
                    strX2 = null;
                } else {
                    if (dVar.a0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strX2 = dVar.X();
                }
            } else if ("fileName".equals(strR)) {
                if (dVar.a0() == 8) {
                    strX3 = null;
                } else {
                    if (dVar.a0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strX3 = dVar.X();
                }
            } else if ("lineNumber".equals(strR)) {
                if (dVar.a0() == 8) {
                    iJ = 0;
                } else {
                    if (dVar.a0() != 2) {
                        throw new JSONException("syntax error");
                    }
                    iJ = dVar.j();
                }
            } else if ("nativeMethod".equals(strR)) {
                if (dVar.a0() != 8 && dVar.a0() != 6 && dVar.a0() != 7) {
                    throw new JSONException("syntax error");
                }
                dVar.t(16);
            } else {
                if (strR != "@type") {
                    throw new JSONException("syntax error : " + strR);
                }
                if (dVar.a0() == 4) {
                    String strX4 = dVar.X();
                    if (!strX4.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + strX4);
                    }
                } else if (dVar.a0() != 8) {
                    throw new JSONException("syntax error");
                }
            }
            if (dVar.a0() == 13) {
                dVar.t(16);
                break;
            }
        }
        return (T) new StackTraceElement(strX, strX2, strX3, iJ);
    }
}
