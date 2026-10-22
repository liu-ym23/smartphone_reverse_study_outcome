package y2;

import com.stepos.alphame.utils.Consts;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final g f16332b = new g();

    /* renamed from: c, reason: collision with root package name */
    public static final g f16333c = new g();

    /* renamed from: d, reason: collision with root package name */
    public static final g f16334d = new g();

    /* renamed from: e, reason: collision with root package name */
    public static final g f16335e = new g();

    /* renamed from: f, reason: collision with root package name */
    public static final c f16336f = new c();

    /* renamed from: a, reason: collision with root package name */
    public final float[] f16337a;

    public c() {
        float[] fArr = new float[16];
        this.f16337a = fArr;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f4 = fArr[0];
        float f5 = fArr2[0];
        float f6 = fArr[4];
        float f7 = fArr2[1];
        float f8 = fArr[8];
        float f9 = fArr2[2];
        float f10 = f8 * f9;
        float f11 = fArr[12];
        float f12 = fArr2[3];
        float f13 = f11 * f12;
        float f14 = f13 + f10 + (f6 * f7) + (f4 * f5);
        float f15 = fArr2[4];
        float f16 = fArr2[5];
        float f17 = fArr2[6];
        float f18 = f8 * f17;
        float f19 = fArr2[7];
        float f20 = f11 * f19;
        float f21 = f20 + f18 + (f6 * f16) + (f4 * f15);
        float f22 = fArr2[8];
        float f23 = fArr2[9];
        float f24 = fArr2[10];
        float f25 = f8 * f24;
        float f26 = fArr2[11];
        float f27 = f11 * f26;
        float f28 = f27 + f25 + (f6 * f23) + (f4 * f22);
        float f29 = fArr2[12];
        float f30 = fArr2[13];
        float f31 = fArr2[14];
        float f32 = f8 * f31;
        float f33 = fArr2[15];
        float f34 = f11 * f33;
        float f35 = f34 + f32 + (f6 * f30) + (f4 * f29);
        float f36 = fArr[1];
        float f37 = fArr[5];
        float f38 = fArr[9];
        float f39 = (f38 * f9) + (f37 * f7) + (f36 * f5);
        float f40 = fArr[13];
        float f41 = (f40 * f12) + f39;
        float f42 = (f40 * f19) + (f38 * f17) + (f37 * f16) + (f36 * f15);
        float f43 = (f40 * f26) + (f38 * f24) + (f37 * f23) + (f36 * f22);
        float f44 = f38 * f31;
        float f45 = f40 * f33;
        float f46 = f45 + f44 + (f37 * f30) + (f36 * f29);
        float f47 = fArr[2];
        float f48 = fArr[6];
        float f49 = fArr[10];
        float f50 = (f49 * f9) + (f48 * f7) + (f47 * f5);
        float f51 = fArr[14];
        float f52 = (f51 * f12) + f50;
        float f53 = (f51 * f19) + (f49 * f17) + (f48 * f16) + (f47 * f15);
        float f54 = (f51 * f26) + (f49 * f24) + (f48 * f23) + (f47 * f22);
        float f55 = f49 * f31;
        float f56 = f51 * f33;
        float f57 = f56 + f55 + (f48 * f30) + (f47 * f29);
        float f58 = fArr[3];
        float f59 = fArr[7];
        float f60 = (f7 * f59) + (f5 * f58);
        float f61 = fArr[11];
        float f62 = (f9 * f61) + f60;
        float f63 = fArr[15];
        float f64 = (f12 * f63) + f62;
        float f65 = f17 * f61;
        float f66 = f19 * f63;
        float f67 = f66 + f65 + (f16 * f59) + (f15 * f58);
        float f68 = f24 * f61;
        float f69 = f26 * f63;
        float f70 = f69 + f68 + (f23 * f59) + (f22 * f58);
        float f71 = f61 * f31;
        float f72 = f63 * f33;
        fArr[0] = f14;
        fArr[1] = f41;
        fArr[2] = f52;
        fArr[3] = f64;
        fArr[4] = f21;
        fArr[5] = f42;
        fArr[6] = f53;
        fArr[7] = f67;
        fArr[8] = f28;
        fArr[9] = f43;
        fArr[10] = f54;
        fArr[11] = f70;
        fArr[12] = f35;
        fArr[13] = f46;
        fArr[14] = f57;
        fArr[15] = f72 + f71 + (f59 * f30) + (f58 * f29);
    }

    public final void a() {
        float[] fArr = this.f16337a;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        float[] fArr = this.f16337a;
        sb.append(fArr[0]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[4]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[8]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[12]);
        sb.append("]\n[");
        sb.append(fArr[1]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[5]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[9]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[13]);
        sb.append("]\n[");
        sb.append(fArr[2]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[6]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[10]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[14]);
        sb.append("]\n[");
        sb.append(fArr[3]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[7]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[11]);
        sb.append(Consts.SPLITTER_DETAIL);
        sb.append(fArr[15]);
        sb.append("]\n");
        return sb.toString();
    }
}
