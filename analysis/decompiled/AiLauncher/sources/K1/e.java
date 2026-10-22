package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class e implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final e f4034a = new e();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
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
        if (obj instanceof BigInteger) {
            zVar.write(((BigInteger) obj).toString());
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        zVar.write(bigDecimal.toString());
        if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) == 0 || type == BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        zVar.write(46);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.math.BigDecimal] */
    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 2) {
            if (type == BigInteger.class) {
                String strV = dVar.v();
                dVar.t(16);
                return (T) new BigInteger(strV, 10);
            }
            T t10 = (T) dVar.g();
            dVar.t(16);
            return t10;
        }
        if (iA0 == 3) {
            ?? r42 = (T) dVar.g();
            dVar.t(16);
            return type == BigInteger.class ? (T) r42.toBigInteger() : r42;
        }
        Object objJ = bVar.J();
        if (objJ == null) {
            return null;
        }
        return type == BigInteger.class ? (T) L1.d.e(objJ) : (T) L1.d.d(objJ);
    }
}
