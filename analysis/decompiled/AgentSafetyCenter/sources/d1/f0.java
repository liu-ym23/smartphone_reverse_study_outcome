package d1;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f2972a = new e0();

    /* JADX WARN: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long a(float r21, float r22, float r23, float r24, e1.c r25) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f0.a(float, float, float, float, e1.c):long");
    }

    public static final long b(int i) {
        long j10 = i << 32;
        int i3 = p.f3025h;
        return j10;
    }

    public static final long c(long j10) {
        long j11 = j10 << 32;
        int i = p.f3025h;
        return j11;
    }

    public static long d(int i, int i3, int i10) {
        return b(((i & 255) << 16) | (-16777216) | ((i3 & 255) << 8) | (i10 & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d1.e e(int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f0.e(int, int, int):d1.e");
    }

    public static final f f() {
        return new f(new Paint(7));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long h(long r19, long r21) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.f0.h(long, long):long");
    }

    public static float[] i() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static final boolean j(float[] fArr) {
        return fArr.length >= 16 && fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[3] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[7] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f && fArr[11] == 0.0f && fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f;
    }

    public static final float k(long j10) {
        e1.c cVarG = p.g(j10);
        if (!e1.b.a(cVarG.f3340b, e1.b.f3334a)) {
            x.a("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) e1.b.b(cVarG.f3340b)));
        }
        e1.m mVar = ((e1.q) cVarG).f3404p;
        double dB = mVar.b(p.i(j10));
        float fB = (float) ((mVar.b(p.f(j10)) * 0.0722d) + (mVar.b(p.h(j10)) * 0.7152d) + (dB * 0.2126d));
        if (fB < 0.0f) {
            fB = 0.0f;
        }
        if (fB > 1.0f) {
            return 1.0f;
        }
        return fB;
    }

    public static final long l(float[] fArr, long j10) {
        if (fArr.length < 16) {
            return j10;
        }
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[3];
        float f12 = fArr[4];
        float f13 = fArr[5];
        float f14 = fArr[7];
        float f15 = fArr[12];
        float f16 = fArr[13];
        float f17 = fArr[15];
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        float f18 = 1 / (((f14 * fIntBitsToFloat2) + (f11 * fIntBitsToFloat)) + f17);
        if ((Float.floatToRawIntBits(f18) & Reader.READ_DONE) >= 2139095040) {
            f18 = 0.0f;
        }
        float f19 = ((f13 * fIntBitsToFloat2) + (f10 * fIntBitsToFloat) + f16) * f18;
        return (Float.floatToRawIntBits((((f12 * fIntBitsToFloat2) + (f5 * fIntBitsToFloat)) + f15) * f18) << 32) | (Float.floatToRawIntBits(f19) & 4294967295L);
    }

    public static final void m(float[] fArr, c1.a aVar) {
        if (fArr.length < 16) {
            return;
        }
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[3];
        float f12 = fArr[4];
        float f13 = fArr[5];
        float f14 = fArr[7];
        float f15 = fArr[12];
        float f16 = fArr[13];
        float f17 = fArr[15];
        float f18 = aVar.f2161a;
        float f19 = aVar.f2162b;
        float f20 = aVar.f2163c;
        float f21 = aVar.f2164d;
        float f22 = f11 * f18;
        float f23 = f14 * f19;
        float f24 = 1.0f / ((f22 + f23) + f17);
        if ((Float.floatToRawIntBits(f24) & Reader.READ_DONE) >= 2139095040) {
            f24 = 0.0f;
        }
        float f25 = f5 * f18;
        float f26 = f12 * f19;
        float f27 = (f25 + f26 + f15) * f24;
        float f28 = f18 * f10;
        float f29 = f19 * f13;
        float f30 = (f28 + f29 + f16) * f24;
        float f31 = f14 * f21;
        float f32 = 1.0f / ((f22 + f31) + f17);
        if ((Float.floatToRawIntBits(f32) & Reader.READ_DONE) >= 2139095040) {
            f32 = 0.0f;
        }
        float f33 = f12 * f21;
        float f34 = (f25 + f33 + f15) * f32;
        float f35 = f13 * f21;
        float f36 = (f28 + f35 + f16) * f32;
        float f37 = f11 * f20;
        float f38 = 1.0f / ((f23 + f37) + f17);
        if ((Float.floatToRawIntBits(f38) & Reader.READ_DONE) >= 2139095040) {
            f38 = 0.0f;
        }
        float f39 = f5 * f20;
        float f40 = (f39 + f26 + f15) * f38;
        float f41 = f20 * f10;
        float f42 = (f29 + f41 + f16) * f38;
        float f43 = 1.0f / ((f37 + f31) + f17);
        float f44 = (Float.floatToRawIntBits(f43) & Reader.READ_DONE) < 2139095040 ? f43 : 0.0f;
        float f45 = (f39 + f33 + f15) * f44;
        float f46 = (f41 + f35 + f16) * f44;
        aVar.f2161a = Math.min(f27, Math.min(f34, Math.min(f40, f45)));
        aVar.f2162b = Math.min(f30, Math.min(f36, Math.min(f42, f46)));
        aVar.f2163c = Math.max(f27, Math.max(f34, Math.max(f40, f45)));
        aVar.f2164d = Math.max(f30, Math.max(f36, Math.max(f42, f46)));
    }

    public static final void n(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public static final long o(c1.c cVar) {
        float f5 = cVar.f2169c - cVar.f2167a;
        float f10 = cVar.f2170d - cVar.f2168b;
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32);
    }

    public static final BlendMode p(int i) {
        return i == 0 ? BlendMode.CLEAR : i == 1 ? BlendMode.SRC : i == 2 ? BlendMode.DST : i == 3 ? BlendMode.SRC_OVER : i == 4 ? BlendMode.DST_OVER : i == 5 ? BlendMode.SRC_IN : i == 6 ? BlendMode.DST_IN : i == 7 ? BlendMode.SRC_OUT : i == 8 ? BlendMode.DST_OUT : i == 9 ? BlendMode.SRC_ATOP : i == 10 ? BlendMode.DST_ATOP : i == 11 ? BlendMode.XOR : i == 12 ? BlendMode.PLUS : i == 13 ? BlendMode.MODULATE : i == 14 ? BlendMode.SCREEN : i == 15 ? BlendMode.OVERLAY : i == 16 ? BlendMode.DARKEN : i == 17 ? BlendMode.LIGHTEN : i == 18 ? BlendMode.COLOR_DODGE : i == 19 ? BlendMode.COLOR_BURN : i == 20 ? BlendMode.HARD_LIGHT : i == 21 ? BlendMode.SOFT_LIGHT : i == 22 ? BlendMode.DIFFERENCE : i == 23 ? BlendMode.EXCLUSION : i == 24 ? BlendMode.MULTIPLY : i == 25 ? BlendMode.HUE : i == 26 ? BlendMode.SATURATION : i == 27 ? BlendMode.COLOR : i == 28 ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }

    public static final Rect q(o2.j jVar) {
        return new Rect(jVar.f9118a, jVar.f9119b, jVar.f9120c, jVar.f9121d);
    }

    public static final int r(long j10) {
        float[] fArr = e1.d.f3342a;
        return (int) (p.b(j10, e1.d.f3346e) >>> 32);
    }

    public static final Bitmap.Config s(int i) {
        return i == 0 ? Bitmap.Config.ARGB_8888 : i == 1 ? Bitmap.Config.ALPHA_8 : i == 2 ? Bitmap.Config.RGB_565 : i == 3 ? Bitmap.Config.RGBA_F16 : i == 4 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public static final c1.c t(Rect rect) {
        return new c1.c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static String u(int i) {
        return i == 0 ? "Clear" : i == 1 ? "Src" : i == 2 ? "Dst" : i == 3 ? "SrcOver" : i == 4 ? "DstOver" : i == 5 ? "SrcIn" : i == 6 ? "DstIn" : i == 7 ? "SrcOut" : i == 8 ? "DstOut" : i == 9 ? "SrcAtop" : i == 10 ? "DstAtop" : i == 11 ? "Xor" : i == 12 ? "Plus" : i == 13 ? "Modulate" : i == 14 ? "Screen" : i == 15 ? "Overlay" : i == 16 ? "Darken" : i == 17 ? "Lighten" : i == 18 ? "ColorDodge" : i == 19 ? "ColorBurn" : i == 20 ? "HardLight" : i == 21 ? "Softlight" : i == 22 ? "Difference" : i == 23 ? "Exclusion" : i == 24 ? "Multiply" : i == 25 ? "Hue" : i == 26 ? ExifInterface.TAG_SATURATION : i == 27 ? "Color" : i == 28 ? "Luminosity" : "Unknown";
    }

    public static void v(float[] fArr, float f5, float f10) {
        if (fArr.length < 16) {
            return;
        }
        float f11 = (fArr[8] * 0.0f) + (fArr[4] * f10) + (fArr[0] * f5) + fArr[12];
        float f12 = (fArr[9] * 0.0f) + (fArr[5] * f10) + (fArr[1] * f5) + fArr[13];
        float f13 = (fArr[10] * 0.0f) + (fArr[6] * f10) + (fArr[2] * f5) + fArr[14];
        float f14 = (fArr[11] * 0.0f) + (fArr[7] * f10) + (fArr[3] * f5) + fArr[15];
        fArr[12] = f11;
        fArr[13] = f12;
        fArr[14] = f13;
        fArr[15] = f14;
    }

    public static final int w(float f5, float[] fArr, int i) {
        float f10 = f5 >= 0.0f ? f5 : 0.0f;
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (Math.abs(f10 - f5) > 1.05E-6f) {
            f10 = Float.NaN;
        }
        fArr[i] = f10;
        return !Float.isNaN(f10) ? 1 : 0;
    }

    public abstract void g(float f5, long j10, f fVar);
}
