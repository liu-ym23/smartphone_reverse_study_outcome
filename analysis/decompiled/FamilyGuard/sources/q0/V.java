package q0;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class V implements U {

    /* renamed from: a, reason: collision with root package name */
    public static V f19721a = new V();

    @Override // q0.U
    public final void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            e0Var.write(91);
            while (i6 < iArr.length) {
                if (i6 != 0) {
                    e0Var.write(44);
                }
                e0Var.V(iArr[i6]);
                i6++;
            }
            e0Var.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            e0Var.write(91);
            while (i6 < sArr.length) {
                if (i6 != 0) {
                    e0Var.write(44);
                }
                e0Var.V(sArr[i6]);
                i6++;
            }
            e0Var.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            e0Var.write(91);
            while (i6 < jArr.length) {
                if (i6 != 0) {
                    e0Var.write(44);
                }
                e0Var.X(jArr[i6]);
                i6++;
            }
            e0Var.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            e0Var.write(91);
            while (i6 < zArr.length) {
                if (i6 != 0) {
                    e0Var.write(44);
                }
                e0Var.w(zArr[i6]);
                i6++;
            }
            e0Var.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            e0Var.write(91);
            while (i6 < fArr.length) {
                if (i6 != 0) {
                    e0Var.write(44);
                }
                float f5 = fArr[i6];
                if (Float.isNaN(f5)) {
                    e0Var.Y();
                } else {
                    e0Var.append(Float.toString(f5));
                }
                i6++;
            }
            e0Var.write(93);
            return;
        }
        if (!(obj instanceof double[])) {
            if (obj instanceof byte[]) {
                e0Var.x((byte[]) obj);
                return;
            } else {
                e0Var.j0((char[]) obj);
                return;
            }
        }
        double[] dArr = (double[]) obj;
        e0Var.write(91);
        while (i6 < dArr.length) {
            if (i6 != 0) {
                e0Var.write(44);
            }
            double d6 = dArr[i6];
            if (Double.isNaN(d6)) {
                e0Var.Y();
            } else {
                e0Var.append(Double.toString(d6));
            }
            i6++;
        }
        e0Var.write(93);
    }
}
