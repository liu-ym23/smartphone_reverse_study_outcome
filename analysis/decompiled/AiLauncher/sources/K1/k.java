package K1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class k implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static k f4046a = new k();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        Number number = (Number) obj;
        if (number == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                zVar.write(48);
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        if (obj instanceof Long) {
            zVar.writeLong(number.longValue());
        } else {
            zVar.writeInt(number.intValue());
        }
        if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                zVar.write(66);
                return;
            }
            if (cls == Short.class) {
                zVar.write(83);
                return;
            }
            if (cls == Long.class) {
                long jLongValue = number.longValue();
                if (jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
                    return;
                }
                zVar.write(76);
            }
        }
    }

    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        T t10;
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 8) {
            dVar.t(16);
            return null;
        }
        Class cls = Long.TYPE;
        if (iA0 == 2) {
            if (type == cls || type == Long.class) {
                t10 = (T) Long.valueOf(dVar.n());
            } else {
                try {
                    t10 = (T) Integer.valueOf(dVar.j());
                } catch (NumberFormatException e10) {
                    throw new JSONException("int value overflow, field : " + obj, e10);
                }
            }
            dVar.t(16);
            return t10;
        }
        if (iA0 == 3) {
            BigDecimal bigDecimalG = dVar.g();
            dVar.t(16);
            return (type == cls || type == Long.class) ? (T) Long.valueOf(bigDecimalG.longValue()) : (T) Integer.valueOf(bigDecimalG.intValue());
        }
        Object objJ = bVar.J();
        try {
            return (type == cls || type == Long.class) ? (T) L1.d.p(objJ) : (T) L1.d.n(objJ);
        } catch (Exception e11) {
            throw new JSONException("cast error, field : " + obj + ", value " + objJ, e11);
        }
    }
}
