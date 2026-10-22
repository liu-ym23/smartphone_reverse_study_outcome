package f8;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.stepos.agentsafetycenter.R;
import g2.k;
import hc.o;
import i9.b0;
import j6.h;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import l.w;
import m4.e;
import nb.f;
import od.i;
import od.l;
import od.z;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements w, e, f {

    /* renamed from: f, reason: collision with root package name */
    public static b f4038f;

    /* renamed from: g, reason: collision with root package name */
    public static b f4039g;

    /* renamed from: h, reason: collision with root package name */
    public static b f4040h;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4041c;

    public /* synthetic */ b(int i) {
        this.f4041c = i;
    }

    public static final String a(byte[] bArr, byte[][] bArr2, int i) {
        int i3;
        boolean z10;
        int i10;
        int i11;
        byte[] bArr3 = PublicSuffixDatabase.f9505e;
        int length = bArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = (i12 + length) / 2;
            while (i13 > -1 && bArr[i13] != 10) {
                i13--;
            }
            int i14 = i13 + 1;
            int i15 = 1;
            while (true) {
                i3 = i14 + i15;
                if (bArr[i3] == 10) {
                    break;
                }
                i15++;
            }
            int i16 = i3 - i14;
            int i17 = i;
            boolean z11 = false;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (z11) {
                    i10 = 46;
                    z10 = false;
                } else {
                    byte b10 = bArr2[i17][i18];
                    byte[] bArr4 = bd.b.f2074a;
                    int i20 = b10 & 255;
                    z10 = z11;
                    i10 = i20;
                }
                byte b11 = bArr[i14 + i19];
                byte[] bArr5 = bd.b.f2074a;
                i11 = i10 - (b11 & 255);
                if (i11 != 0) {
                    break;
                }
                i19++;
                i18++;
                if (i19 == i16) {
                    break;
                }
                if (bArr2[i17].length != i18) {
                    z11 = z10;
                } else {
                    if (i17 == bArr2.length - 1) {
                        break;
                    }
                    i17++;
                    i18 = -1;
                    z11 = true;
                }
            }
            if (i11 >= 0) {
                if (i11 <= 0) {
                    int i21 = i16 - i19;
                    int length2 = bArr2[i17].length - i18;
                    int length3 = bArr2.length;
                    for (int i22 = i17 + 1; i22 < length3; i22++) {
                        length2 += bArr2[i22].length;
                    }
                    if (length2 >= i21) {
                        if (length2 <= i21) {
                            Charset charset = StandardCharsets.UTF_8;
                            charset.getClass();
                            return new String(bArr, i14, i16, charset);
                        }
                    }
                }
                i12 = i3 + 1;
            }
            length = i13;
        }
        return null;
    }

    public static final void e(od.d dVar, long j10, boolean z10) {
        od.d dVar2;
        ReentrantLock reentrantLock = od.d.f9430h;
        if (od.d.f9433l == null) {
            od.d.f9433l = new od.d();
            h hVar = new h("Okio Watchdog");
            hVar.setDaemon(true);
            hVar.start();
        }
        long jNanoTime = System.nanoTime();
        if (j10 != 0 && z10) {
            dVar.f9436g = Math.min(j10, dVar.c() - jNanoTime) + jNanoTime;
        } else if (j10 != 0) {
            dVar.f9436g = j10 + jNanoTime;
        } else {
            if (!z10) {
                throw new AssertionError();
            }
            dVar.f9436g = dVar.c();
        }
        long j11 = dVar.f9436g - jNanoTime;
        od.d dVar3 = od.d.f9433l;
        dVar3.getClass();
        while (true) {
            dVar2 = dVar3.f9435f;
            if (dVar2 == null || j11 < dVar2.f9436g - jNanoTime) {
                break;
            } else {
                dVar3 = dVar2;
            }
        }
        dVar.f9435f = dVar2;
        dVar3.f9435f = dVar;
        if (dVar3 == od.d.f9433l) {
            od.d.i.signal();
        }
    }

    public static final boolean g(z zVar) {
        z zVar2 = pd.f.f10009e;
        l lVarN = zVar.f9498c;
        int iJ = l.j(lVarN, pd.c.f9999a);
        if (iJ == -1) {
            iJ = l.j(zVar.f9498c, pd.c.f10000b);
        }
        if (iJ != -1) {
            lVarN = l.n(lVarN, iJ + 1, 0, 2);
        } else if (zVar.e() != null && lVarN.c() == 2) {
            lVarN = l.f9459h;
        }
        return !o.P(lVarN.p(), ".class", true);
    }

    public static final float h(float f5, float[] fArr, float[] fArr2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float fAbs = Math.abs(f5);
        float fSignum = Math.signum(f5);
        int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
        if (iBinarySearch >= 0) {
            return fSignum * fArr2[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        int i3 = i - 1;
        if (i3 >= fArr.length - 1) {
            float f14 = fArr[fArr.length - 1];
            float f15 = fArr2[fArr.length - 1];
            if (f14 == 0.0f) {
                return 0.0f;
            }
            return (f15 / f14) * f5;
        }
        if (i3 == -1) {
            float f16 = fArr[0];
            f12 = fArr2[0];
            f13 = f16;
            f11 = 0.0f;
            f10 = 0.0f;
        } else {
            float f17 = fArr[i3];
            float f18 = fArr[i];
            f10 = fArr2[i3];
            f11 = f17;
            f12 = fArr2[i];
            f13 = f18;
        }
        return (((f12 - f10) * Math.max(0.0f, Math.min(1.0f, f11 == f13 ? 0.0f : (fAbs - f11) / (f13 - f11)))) + f10) * fSignum;
    }

    public static od.d i() throws InterruptedException {
        od.d dVar = od.d.f9433l;
        dVar.getClass();
        od.d dVar2 = dVar.f9435f;
        if (dVar2 == null) {
            long jNanoTime = System.nanoTime();
            od.d.i.await(od.d.f9431j, TimeUnit.MILLISECONDS);
            od.d dVar3 = od.d.f9433l;
            dVar3.getClass();
            if (dVar3.f9435f != null || System.nanoTime() - jNanoTime < od.d.f9432k) {
                return null;
            }
            return od.d.f9433l;
        }
        long jNanoTime2 = dVar2.f9436g - System.nanoTime();
        if (jNanoTime2 > 0) {
            od.d.i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        od.d dVar4 = od.d.f9433l;
        dVar4.getClass();
        dVar4.f9435f = dVar2.f9435f;
        dVar2.f9435f = null;
        dVar2.f9434e = 2;
        return dVar2;
    }

    public static Typeface j(String str, k kVar, int i) {
        if (i == 0 && yb.k.a(kVar, k.f4252g) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), kVar.f4256c, i == 1);
    }

    public static l k(String str) {
        if (str.length() % 2 != 0) {
            od.f.c("Unexpected hex string: ".concat(str));
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i3 = i * 2;
            bArr[i] = (byte) (pd.b.a(str.charAt(i3 + 1)) + (pd.b.a(str.charAt(i3)) << 4));
        }
        l lVar = new l();
        lVar.f9460c = bArr;
        return lVar;
    }

    public static l l(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(hc.a.f5448a);
        bytes.getClass();
        l lVar = new l();
        lVar.f9460c = bytes;
        lVar.f9462g = str;
        return lVar;
    }

    public static z n(String str) {
        str.getClass();
        l lVar = pd.c.f9999a;
        i iVar = new i();
        iVar.g0(str);
        return pd.c.d(iVar, false);
    }

    public static z o(File file) {
        String str = z.f9497f;
        file.getClass();
        String string = file.toString();
        string.getClass();
        return n(string);
    }

    @Override // m4.e
    public void b() {
        switch (this.f4041c) {
            case 17:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // m4.e
    public void c(int i, Object obj) {
        String str;
        switch (this.f4041c) {
            case 17:
                break;
            default:
                switch (i) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i != 6 && i != 7 && i != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    break;
                }
                break;
        }
    }

    @Override // l.w
    public boolean f(l.l lVar) {
        return false;
    }

    public b0 m(Context context) {
        b0 b0Var;
        context.getClass();
        b0 b0Var2 = b0.f5840e;
        if (b0Var2 != null) {
            return b0Var2;
        }
        synchronized (this) {
            b0Var = b0.f5840e;
            if (b0Var == null) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                b0Var = new b0(applicationContext);
                b0.f5840e = b0Var;
            }
        }
        return b0Var;
    }

    public CharSequence r(Preference preference) {
        switch (this.f4041c) {
            case 12:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                if (TextUtils.isEmpty(null)) {
                    return editTextPreference.f1468c.getString(R.string.not_set);
                }
                return null;
            default:
                ListPreference listPreference = (ListPreference) preference;
                if (TextUtils.isEmpty(null)) {
                    return listPreference.f1468c.getString(R.string.not_set);
                }
                return null;
        }
    }

    private final void p() {
    }

    private final void q(int i, Object obj) {
    }

    @Override // l.w
    public void d(l.l lVar, boolean z10) {
    }
}
