package p0;

import android.util.Log;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.stepos.stepclaw.SecurePrefs;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements t0.e, f5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4645a;

    public /* synthetic */ b(int i8) {
        this.f4645a = i8;
    }

    public static final String a(c7.i iVar, c7.i[] iVarArr, int i8) {
        int i9;
        boolean z;
        int i10;
        int i11;
        c7.i iVar2 = y6.a.f6360b;
        int iC = iVar.c();
        int i12 = 0;
        while (i12 < iC) {
            int i13 = (i12 + iC) / 2;
            while (i13 > -1 && iVar.f(i13) != 10) {
                i13--;
            }
            int i14 = i13 + 1;
            int i15 = 1;
            while (true) {
                i9 = i14 + i15;
                if (iVar.f(i9) == 10) {
                    break;
                }
                i15++;
            }
            int i16 = i9 - i14;
            int i17 = i8;
            boolean z2 = false;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (z2) {
                    i10 = 46;
                    z = false;
                } else {
                    byte bF = iVarArr[i17].f(i18);
                    byte[] bArr = o6.d.f4327a;
                    int i20 = bF & 255;
                    z = z2;
                    i10 = i20;
                }
                byte bF2 = iVar.f(i14 + i19);
                byte[] bArr2 = o6.d.f4327a;
                i11 = i10 - (bF2 & 255);
                if (i11 != 0) {
                    break;
                }
                i19++;
                i18++;
                if (i19 == i16) {
                    break;
                }
                if (iVarArr[i17].c() != i18) {
                    z2 = z;
                } else {
                    if (i17 == iVarArr.length - 1) {
                        break;
                    }
                    i17++;
                    i18 = -1;
                    z2 = true;
                }
            }
            if (i11 >= 0) {
                if (i11 <= 0) {
                    int i21 = i16 - i19;
                    int iC2 = iVarArr[i17].c() - i18;
                    int length = iVarArr.length;
                    for (int i22 = i17 + 1; i22 < length; i22++) {
                        iC2 += iVarArr[i22].c();
                    }
                    if (iC2 >= i21) {
                        if (iC2 <= i21) {
                            return iVar.j(i14, i16 + i14).i(x5.a.f6276a);
                        }
                    }
                }
                i12 = i9 + 1;
            }
            iC = i13;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(p0.c r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.b.b(p0.c, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // t0.e
    public void d() {
        switch (this.f4645a) {
            case 2:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // t0.e
    public void e(int i8, Object obj) {
        String str;
        switch (this.f4645a) {
            case 2:
                break;
            default:
                switch (i8) {
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
                        str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i8 != 6 && i8 != 7 && i8 != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ b(int i8, Object obj) {
        this.f4645a = i8;
    }

    public b(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f4645a = 13;
    }

    private final void c() {
    }

    private final void f(int i8, Object obj) {
    }
}
