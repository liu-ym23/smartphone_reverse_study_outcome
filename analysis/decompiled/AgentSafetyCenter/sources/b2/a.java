package b2;

import ad.o;
import ad.x;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.security.keystore.KeyGenParameterSpec;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import id.k;
import java.lang.invoke.VarHandle;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import java.util.WeakHashMap;
import javax.crypto.KeyGenerator;
import m.e1;
import m.s;
import m0.e;
import n3.i0;
import n3.k0;
import od.f;
import p.z;
import p5.m;
import pc.t;
import xb.r;
import y.h;
import y.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1859a;

    /* renamed from: b, reason: collision with root package name */
    public int f1860b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1861c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1862d;

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.f1859a = 1;
        this.f1861c = shader;
        this.f1862d = colorStateList;
        this.f1860b = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x021e, code lost:
    
        if (r21 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0220, code lost:
    
        r0 = new p5.c(4);
        r0.f9717f = new int[]{r6, r5, r12};
        r0.f9718g = new float[]{0.0f, 0.5f, 1.0f};
        java.lang.invoke.VarHandle.storeStoreFence();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0238, code lost:
    
        r0 = new p5.c(4);
        r0.f9717f = new int[]{r6, r12};
        r15 = 2;
        r0.f9718g = new float[]{0.0f, 1.0f};
        java.lang.invoke.VarHandle.storeStoreFence();
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0250, code lost:
    
        if (r11 == r14) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0252, code lost:
    
        if (r11 == r15) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0254, code lost:
    
        r16 = (int[]) r0.f9717f;
        r17 = (float[]) r0.f9718g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0262, code lost:
    
        if (r10 == r14) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0264, code lost:
    
        if (r10 == r15) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0266, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0273, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0276, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0279, code lost:
    
        r11 = new android.graphics.LinearGradient(r22, r24, r27, r28, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x027d, code lost:
    
        r11 = new android.graphics.SweepGradient(r8, r9, (int[]) r0.f9717f, (float[]) r0.f9718g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x028f, code lost:
    
        if (r26 <= 0.0f) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0291, code lost:
    
        r1 = (int[]) r0.f9717f;
        r21 = (float[]) r0.f9718g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x029e, code lost:
    
        if (r10 == 1) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02a1, code lost:
    
        if (r10 == 2) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02a3, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02b0, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02b3, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02b6, code lost:
    
        r11 = new android.graphics.RadialGradient(r8, r9, r26, r1, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02c2, code lost:
    
        return new b2.a(r11, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ca, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01da, code lost:
    
        if (r13.size() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dc, code lost:
    
        r0 = new p5.c(4);
        r1 = r13.size();
        r0.f9717f = new int[r1];
        r0.f9718g = new float[r1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ef, code lost:
    
        if (r2 >= r1) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f1, code lost:
    
        ((int[]) r0.f9717f)[r2] = ((java.lang.Integer) r13.get(r2)).intValue();
        ((float[]) r0.f9718g)[r2] = ((java.lang.Float) r7.get(r2)).floatValue();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0214, code lost:
    
        java.lang.invoke.VarHandle.storeStoreFence();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0218, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0219, code lost:
    
        if (r0 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x021b, code lost:
    
        r14 = 1;
        r15 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b2.a f(android.content.res.Resources r31, int r32, android.content.res.Resources.Theme r33) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.a.f(android.content.res.Resources, int, android.content.res.Resources$Theme):b2.a");
    }

    public void a(int i, m mVar) {
        if (i < 0) {
            f.c(k0.a.j(i, "size should be >=0, but was "));
            return;
        }
        if (i == 0) {
            return;
        }
        int i3 = this.f1860b;
        h hVar = new h();
        hVar.f15745a = i3;
        hVar.f15746b = i;
        hVar.f15747c = mVar;
        if (i3 < 0) {
            f.c(k0.a.j(i3, "startIndex should be >= 0, but was "));
        } else {
            if (i <= 0) {
                f.c(k0.a.j(i, "size should be >0, but was "));
                return;
            }
            VarHandle.storeStoreFence();
            this.f1860b = i3 + i;
            ((e) this.f1861c).b(hVar);
        }
    }

    @Override // y.w
    public int b(Object obj) {
        z zVar = (z) this.f1861c;
        int iD = zVar.d(obj);
        if (iD >= 0) {
            return zVar.f9652c[iD];
        }
        return -1;
    }

    public void c() {
        ad.h hVar;
        ImageView imageView = (ImageView) this.f1861c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            Rect rect = e1.f7901a;
        }
        if (drawable == null || (hVar = (ad.h) this.f1862d) == null) {
            return;
        }
        s.d(drawable, hVar, imageView.getDrawableState());
    }

    public t d() {
        int i = this.f1860b;
        if (i == 0 && ((KeyGenParameterSpec) this.f1862d) == null) {
            g5.f.s("build() called before setKeyGenParameterSpec or setKeyScheme.");
            return null;
        }
        if (i == 1) {
            this.f1862d = new KeyGenParameterSpec.Builder((String) this.f1861c, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH).build();
        }
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) this.f1862d;
        if (keyGenParameterSpec == null) {
            g5.f.g("KeyGenParameterSpec was null after build() check");
            return null;
        }
        Object obj = w4.f.f15227a;
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            g5.f.f(Arrays.toString(keyGenParameterSpec.getBlockModes()), "invalid block mode, want GCM got ");
            return null;
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            o.j(keyGenParameterSpec.getPurposes(), "invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got ");
            return null;
        }
        if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            g5.f.f(Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()), "invalid padding mode, want NoPadding got ");
            return null;
        }
        if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            g5.f.s("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
            return null;
        }
        synchronized (w4.f.f15227a) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(keyGenParameterSpec);
                    keyGenerator.generateKey();
                } catch (ProviderException e10) {
                    throw new GeneralSecurityException(e10.getMessage(), e10);
                }
            }
        }
        String keystoreAlias2 = keyGenParameterSpec.getKeystoreAlias();
        t tVar = new t();
        tVar.f9985b = keystoreAlias2;
        VarHandle.storeStoreFence();
        return tVar;
    }

    public void e(int i) {
        if (i < 0 || i >= this.f1860b) {
            b8.z.i(this.f1860b, k0.a.t(i, "Index ", ", size "));
        }
    }

    public h g(int i) {
        e(i);
        h hVar = (h) this.f1862d;
        if (hVar != null) {
            int i3 = hVar.f15745a;
            if (i < hVar.f15746b + i3 && i3 <= i) {
                return hVar;
            }
        }
        e eVar = (e) this.f1861c;
        h hVar2 = (h) eVar.f8158c[t2.a.b(i, eVar)];
        this.f1862d = hVar2;
        return hVar2;
    }

    public void h(int i, int i3, int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        long[] jArr = (long[]) this.f1861c;
        int i14 = this.f1860b;
        int i15 = i14 + 3;
        this.f1860b = i15;
        int length = jArr.length;
        if (length <= i15) {
            int iMax = Math.max(length * 2, i15);
            this.f1861c = Arrays.copyOf(jArr, iMax);
            this.f1862d = Arrays.copyOf((long[]) this.f1862d, iMax);
        }
        long[] jArr2 = (long[]) this.f1861c;
        jArr2[i14] = (i3 << 32) | (i10 & 4294967295L);
        jArr2[i14 + 1] = (i11 << 32) | (i12 & 4294967295L);
        int i16 = i13 & 67108863;
        jArr2[i14 + 2] = ((z11 ? 1L : 0L) << 63) | ((z10 ? 1L : 0L) << 62) | (1 << 61) | (0 << 52) | (i16 << 26) | (i & 67108863);
        if (i13 < 0) {
            return;
        }
        for (int i17 = i14 - 3; i17 >= 0; i17 -= 3) {
            int i18 = i17 + 2;
            long j10 = jArr2[i18];
            if ((((int) j10) & 67108863) == i16) {
                jArr2[i18] = (j10 & (-2301339409586323457L)) | (((i14 - i17) & 511) << 52);
                return;
            }
        }
    }

    public boolean i() {
        ColorStateList colorStateList;
        return ((Shader) this.f1861c) == null && (colorStateList = (ColorStateList) this.f1862d) != null && colorStateList.isStateful();
    }

    public void j(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.f1861c;
        Context context = imageView.getContext();
        int[] iArr = g.a.f4103f;
        m mVarJ = m.J(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        Context context2 = imageView.getContext();
        TypedArray typedArray2 = (TypedArray) mVarJ.f9742g;
        WeakHashMap weakHashMap = k0.f8724a;
        i0.b(imageView, context2, iArr, attributeSet, typedArray2, i, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = k.v(resourceId, imageView.getContext())) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                Rect rect = e1.f7901a;
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(mVarJ.z(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(e1.b(typedArray.getInt(3, -1), null));
            }
            mVarJ.M();
        } catch (Throwable th) {
            mVarJ.M();
            throw th;
        }
    }

    public void k(int i, r rVar) {
        int i3 = i & 67108863;
        long[] jArr = (long[]) this.f1861c;
        int i10 = this.f1860b;
        for (int i11 = 0; i11 < jArr.length - 2 && i11 < i10; i11 += 3) {
            if ((((int) jArr[i11 + 2]) & 67108863) == i3) {
                long j10 = jArr[i11];
                long j11 = jArr[i11 + 1];
                rVar.c(Integer.valueOf((int) (j10 >> 32)), Integer.valueOf((int) j10), Integer.valueOf((int) (j11 >> 32)), Integer.valueOf((int) j11));
                return;
            }
        }
    }

    public String toString() {
        switch (this.f1859a) {
            case 2:
                StringBuilder sb2 = new StringBuilder();
                if (((x) this.f1861c) == x.HTTP_1_0) {
                    sb2.append("HTTP/1.0");
                } else {
                    sb2.append("HTTP/1.1");
                }
                sb2.append(' ');
                sb2.append(this.f1860b);
                sb2.append(' ');
                sb2.append((String) this.f1862d);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a(ImageView imageView) {
        this.f1859a = 3;
        this.f1860b = 0;
        this.f1861c = imageView;
    }

    public /* synthetic */ a(int i) {
        this.f1859a = i;
    }
}
