package h4;

import android.content.ContentResolver;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.protobuf.a1;
import f8.q0;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Mac;
import k.a0;
import k.g0;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import v9.p0;
import v9.x0;

/* loaded from: classes.dex */
public class n implements o, g7.k, qa.a, v1.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4152f;

    public /* synthetic */ n(int i2, boolean z4) {
        this.f4152f = i2;
    }

    public static final String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i10;
        boolean z4;
        int i11;
        int i12;
        byte[] bArr3 = PublicSuffixDatabase.f8044e;
        int length = bArr.length;
        int i13 = 0;
        while (i13 < length) {
            int i14 = (i13 + length) / 2;
            while (i14 > -1 && bArr[i14] != 10) {
                i14--;
            }
            int i15 = i14 + 1;
            int i16 = 1;
            while (true) {
                i10 = i15 + i16;
                if (bArr[i10] == 10) {
                    break;
                }
                i16++;
            }
            int i17 = i10 - i15;
            int i18 = i2;
            boolean z10 = false;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (z10) {
                    i11 = 46;
                    z4 = false;
                } else {
                    byte b10 = bArr2[i18][i19];
                    byte[] bArr4 = bb.b.f1659a;
                    int i21 = b10 & 255;
                    z4 = z10;
                    i11 = i21;
                }
                byte b11 = bArr[i15 + i20];
                byte[] bArr5 = bb.b.f1659a;
                i12 = i11 - (b11 & 255);
                if (i12 != 0) {
                    break;
                }
                i20++;
                i19++;
                if (i20 == i17) {
                    break;
                }
                if (bArr2[i18].length != i19) {
                    z10 = z4;
                } else {
                    if (i18 == bArr2.length - 1) {
                        break;
                    }
                    i18++;
                    i19 = -1;
                    z10 = true;
                }
            }
            if (i12 >= 0) {
                if (i12 <= 0) {
                    int i22 = i17 - i20;
                    int length2 = bArr2[i18].length - i19;
                    int length3 = bArr2.length;
                    for (int i23 = i18 + 1; i23 < length3; i23++) {
                        length2 += bArr2[i23].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            Charset charset = StandardCharsets.UTF_8;
                            q7.k.d(charset, "UTF_8");
                            return new String(bArr, i15, i17, charset);
                        }
                    }
                }
                i13 = i10 + 1;
            }
            length = i14;
        }
        return null;
    }

    public static final float[] b() {
        float[] fArr = n.p.f6683s;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[91];
        n.p.f6683s = fArr2;
        return fArr2;
    }

    public static final void d(ob.f fVar, long j2, boolean z4) {
        ob.f fVar2;
        ReentrantLock reentrantLock = ob.f.f7967h;
        if (ob.f.f7971l == null) {
            ob.f.f7971l = new ob.f();
            ob.c cVar = new ob.c("Okio Watchdog");
            cVar.setDaemon(true);
            cVar.start();
        }
        long jNanoTime = System.nanoTime();
        if (j2 != 0 && z4) {
            fVar.f7974g = Math.min(j2, fVar.c() - jNanoTime) + jNanoTime;
        } else if (j2 != 0) {
            fVar.f7974g = j2 + jNanoTime;
        } else {
            if (!z4) {
                throw new AssertionError();
            }
            fVar.f7974g = fVar.c();
        }
        long j4 = fVar.f7974g - jNanoTime;
        ob.f fVar3 = ob.f.f7971l;
        q7.k.b(fVar3);
        while (true) {
            fVar2 = fVar3.f7973f;
            if (fVar2 == null || j4 < fVar2.f7974g - jNanoTime) {
                break;
            }
            q7.k.b(fVar2);
            fVar3 = fVar2;
        }
        fVar.f7973f = fVar2;
        fVar3.f7973f = fVar;
        if (fVar3 == ob.f.f7971l) {
            ob.f.f7968i.signal();
        }
    }

    public static final boolean e(ob.z zVar) {
        ob.z zVar2 = pb.f.f8588e;
        return !ga.r.Z(zVar.b(), ".class", true);
    }

    public static ob.f f() throws InterruptedException {
        ob.f fVar = ob.f.f7971l;
        q7.k.b(fVar);
        ob.f fVar2 = fVar.f7973f;
        if (fVar2 == null) {
            long jNanoTime = System.nanoTime();
            ob.f.f7968i.await(ob.f.f7969j, TimeUnit.MILLISECONDS);
            ob.f fVar3 = ob.f.f7971l;
            q7.k.b(fVar3);
            if (fVar3.f7973f != null || System.nanoTime() - jNanoTime < ob.f.f7970k) {
                return null;
            }
            return ob.f.f7971l;
        }
        long jNanoTime2 = fVar2.f7974g - System.nanoTime();
        if (jNanoTime2 > 0) {
            ob.f.f7968i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        ob.f fVar4 = ob.f.f7971l;
        q7.k.b(fVar4);
        fVar4.f7973f = fVar2.f7973f;
        fVar2.f7973f = null;
        fVar2.f7972e = 2;
        return fVar2;
    }

    public static p0 g(q0 q0Var, t8.a aVar, nb.f fVar, v9.v vVar) {
        q7.k.e(aVar, "typeAttr");
        q7.k.e(fVar, "typeParameterUpperBoundEraser");
        if (!aVar.f9774c) {
            aVar = aVar.b(1);
        }
        int iD = n.f.d(aVar.f9773b);
        if (iD != 0 && iD != 1) {
            if (iD == 2) {
                return new v9.q0(1, vVar);
            }
            throw new a4.u();
        }
        int iA0 = q0Var.a0();
        boolean z4 = true;
        if (iA0 != 1) {
            if (iA0 == 2) {
                z4 = false;
            } else if (iA0 != 3) {
                throw null;
            }
        }
        if (!z4) {
            return new v9.q0(1, l9.d.e(q0Var).n());
        }
        List parameters = vVar.E0().getParameters();
        q7.k.d(parameters, "erasedUpperBound.constructor.parameters");
        return !parameters.isEmpty() ? new v9.q0(3, vVar) : x0.k(q0Var, aVar);
    }

    public static Typeface h(String str, v1.k kVar, int i2) {
        if (i2 == 0 && q7.k.a(kVar, v1.k.f10358h) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), kVar.f10363f, i2 == 1);
    }

    public static ob.k i(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i10 = i2 * 2;
            bArr[i2] = (byte) (pb.b.a(str.charAt(i10 + 1)) + (pb.b.a(str.charAt(i10)) << 4));
        }
        return new ob.k(bArr);
    }

    public static ob.k j(String str) {
        q7.k.e(str, "<this>");
        byte[] bytes = str.getBytes(ga.a.f4005a);
        q7.k.d(bytes, "getBytes(...)");
        ob.k kVar = new ob.k(bytes);
        kVar.f8000h = str;
        return kVar;
    }

    public static Font k(FontFamily fontFamily) {
        FontStyle fontStyle = new FontStyle(400, 0);
        Font font = fontFamily.getFont(0);
        int iP = p(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iP2 = p(fontStyle, font2.getStyle());
            if (iP2 < iP) {
                font = font2;
                iP = iP2;
            }
        }
        return font;
    }

    public static ob.z l(String str, boolean z4) {
        q7.k.e(str, "<this>");
        ob.k kVar = pb.c.f8578a;
        ob.h hVar = new ob.h();
        hVar.U(str);
        return pb.c.d(hVar, z4);
    }

    public static ob.z m(File file) {
        String str = ob.z.f8042g;
        String string = file.toString();
        q7.k.d(string, "toString(...)");
        return l(string, false);
    }

    public static int p(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public static ob.k q(byte[] bArr) {
        ob.k kVar = ob.k.f7997i;
        int length = bArr.length;
        ob.b.e(bArr.length, 0, length);
        return new ob.k(d7.n.b0(bArr, 0, length));
    }

    @Override // h4.o
    public Object c(String str, Provider provider) {
        switch (this.f4152f) {
            case 0:
                return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
            case 1:
                return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
            case 2:
                return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
            default:
                return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    public FontFamily n(m2.d[] dVarArr, ContentResolver contentResolver) throws IOException {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (m2.d dVar : dVarArr) {
            if (Objects.equals(dVar.f6141a.getScheme(), "systemfont")) {
                fontBuild = o(dVar);
            } else {
                try {
                    Uri uri = dVar.f6141a;
                    str = dVar.f6145e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e10) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(dVar.f6143c).setSlant(dVar.f6144d ? 1 : 0).setTtcIndex(dVar.f6142b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font o(m2.d dVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    public String toString() {
        switch (this.f4152f) {
            case 9:
                return "CompositionErrorContext";
            default:
                return super.toString();
        }
    }

    public n(String str) {
        this.f4152f = 19;
    }

    public n(u9.k kVar) {
        this.f4152f = 12;
        String str = u9.k.f10206d;
        new ConcurrentHashMap(3, 1.0f, 2);
    }

    public n(int i2) {
        this.f4152f = i2;
        switch (i2) {
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                new k.p(16);
                long[] jArr = g0.f5491a;
                new a0();
                break;
            default:
                new ConcurrentHashMap();
                break;
        }
    }
}
