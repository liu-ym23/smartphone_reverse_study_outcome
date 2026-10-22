package K1;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class c implements t {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f4029a;

    /* renamed from: b, reason: collision with root package name */
    public final t f4030b;

    public c(Class<?> cls, t tVar) {
        this.f4029a = cls;
        this.f4030b = tVar;
    }

    @Override // K1.t
    public final void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        if (obj == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                zVar.write("[]");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        int i10 = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            zVar.write(91);
            while (i10 < zArr.length) {
                if (i10 != 0) {
                    zVar.write(44);
                }
                zVar.A(zArr[i10]);
                i10++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            zVar.G((byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            zVar.e0(new String((char[]) obj));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                zVar.append("[]");
                return;
            }
            zVar.write(91);
            while (i10 < length) {
                double d10 = dArr[i10];
                if (Double.isNaN(d10)) {
                    zVar.Y();
                } else {
                    zVar.append(Double.toString(d10));
                }
                zVar.write(44);
                i10++;
            }
            double d11 = dArr[length];
            if (Double.isNaN(d11)) {
                zVar.Y();
            } else {
                zVar.append(Double.toString(d11));
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length - 1;
            if (length2 == -1) {
                zVar.append("[]");
                return;
            }
            zVar.write(91);
            while (i10 < length2) {
                float f10 = fArr[i10];
                if (Float.isNaN(f10)) {
                    zVar.Y();
                } else {
                    zVar.append(Float.toString(f10));
                }
                zVar.write(44);
                i10++;
            }
            float f11 = fArr[length2];
            if (Float.isNaN(f11)) {
                zVar.Y();
            } else {
                zVar.append(Float.toString(f11));
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            zVar.write(91);
            while (i10 < iArr.length) {
                if (i10 != 0) {
                    zVar.write(44);
                }
                zVar.writeInt(iArr[i10]);
                i10++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            zVar.write(91);
            while (i10 < jArr.length) {
                if (i10 != 0) {
                    zVar.write(44);
                }
                zVar.writeLong(jArr[i10]);
                i10++;
            }
            zVar.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            zVar.write(91);
            while (i10 < sArr.length) {
                if (i10 != 0) {
                    zVar.write(44);
                }
                zVar.writeInt(sArr[i10]);
                i10++;
            }
            zVar.write(93);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length3 = objArr.length;
        w wVar = mVar.f4059m;
        mVar.p(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            while (i10 < length3) {
                if (i10 != 0) {
                    zVar.write(44);
                }
                Object obj3 = objArr[i10];
                if (obj3 == null) {
                    if (zVar.n(SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        zVar.e0("");
                    } else {
                        zVar.append("null");
                    }
                } else if (obj3.getClass() == this.f4029a) {
                    this.f4030b.a(mVar, obj3, Integer.valueOf(i10), null);
                } else {
                    mVar.f4047a.a(obj3.getClass()).a(mVar, obj3, Integer.valueOf(i10), null);
                }
                i10++;
            }
            zVar.write(93);
            mVar.f4059m = wVar;
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }
}
