package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class s implements t, J1.f {

    /* renamed from: b, reason: collision with root package name */
    public static final s f4070b = new s();

    /* renamed from: a, reason: collision with root package name */
    public DecimalFormat f4071a = null;

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        String string;
        z zVar = mVar.f4048b;
        if (obj == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                zVar.write(48);
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (Float.isNaN(fFloatValue)) {
                zVar.Y();
                return;
            }
            if (Float.isInfinite(fFloatValue)) {
                zVar.Y();
                return;
            }
            String string2 = Float.toString(fFloatValue);
            if (string2.endsWith(".0")) {
                string2 = string2.substring(0, string2.length() - 2);
            }
            zVar.write(string2);
            if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0) {
                zVar.write(70);
                return;
            }
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue)) {
            zVar.Y();
            return;
        }
        if (Double.isInfinite(dDoubleValue)) {
            zVar.Y();
            return;
        }
        DecimalFormat decimalFormat = this.f4071a;
        if (decimalFormat == null) {
            string = Double.toString(dDoubleValue);
            if (string.endsWith(".0")) {
                string = string.substring(0, string.length() - 2);
            }
        } else {
            string = decimalFormat.format(dDoubleValue);
        }
        zVar.append(string);
        if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0) {
            zVar.write(68);
        }
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Number, java.math.BigDecimal] */
    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) throws NumberFormatException {
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        Class cls = Byte.TYPE;
        Class cls2 = Short.TYPE;
        Class cls3 = Float.TYPE;
        Class cls4 = Double.TYPE;
        if (iA0 == 2) {
            if (type == cls4 || type == Double.class) {
                String strV = dVar.v();
                dVar.t(16);
                return (T) Double.valueOf(Double.parseDouble(strV));
            }
            if (type == cls3 || type == Float.class) {
                String strV2 = dVar.v();
                dVar.t(16);
                return (T) Float.valueOf(Float.parseFloat(strV2));
            }
            long jN = dVar.n();
            dVar.t(16);
            return (type == cls2 || type == Short.class) ? (T) Short.valueOf((short) jN) : (type == cls || type == Byte.class) ? (T) Byte.valueOf((byte) jN) : (jN < -2147483648L || jN > 2147483647L) ? (T) Long.valueOf(jN) : (T) Integer.valueOf((int) jN);
        }
        if (iA0 != 3) {
            Object objJ = bVar.J();
            if (objJ == null) {
                return null;
            }
            return (type == cls4 || type == Double.class) ? (T) L1.d.k(objJ) : (type == cls3 || type == Float.class) ? (T) L1.d.m(objJ) : (type == cls2 || type == Short.class) ? (T) L1.d.q(objJ) : (type == cls || type == Byte.class) ? (T) L1.d.g(objJ) : (T) L1.d.d(objJ);
        }
        if (type == cls4 || type == Double.class) {
            String strV3 = dVar.v();
            dVar.t(16);
            return (T) Double.valueOf(Double.parseDouble(strV3));
        }
        if (type == cls3 || type == Float.class) {
            String strV4 = dVar.v();
            dVar.t(16);
            return (T) Float.valueOf(Float.parseFloat(strV4));
        }
        ?? r11 = (T) dVar.g();
        dVar.t(16);
        return (type == cls2 || type == Short.class) ? (T) Short.valueOf(r11.shortValue()) : (type == cls || type == Byte.class) ? (T) Byte.valueOf(r11.byteValue()) : r11;
    }
}
