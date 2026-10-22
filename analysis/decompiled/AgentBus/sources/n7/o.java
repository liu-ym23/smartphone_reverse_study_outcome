package n7;

import a4.u;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import b0.p;
import b0.t1;
import b0.z1;
import com.google.protobuf.y0;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentbus.R;
import d7.s;
import d7.t;
import f8.q0;
import fi.iki.elonen.NanoHTTPD;
import ga.r;
import i1.y;
import j1.g1;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import m.x;
import q7.w;
import r.z;
import s1.h0;
import v9.e0;
import v9.i0;
import v9.m0;
import v9.p0;
import v9.v;
import z7.b0;
import z7.m1;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6875a;

    public /* synthetic */ o(int i2) {
        this.f6875a = i2;
    }

    public static final String A(f8.e eVar, String str) {
        String strE;
        q7.k.e(eVar, "classDescriptor");
        String str2 = e8.d.f3123a;
        e9.e eVarI = l9.d.g(eVar).i();
        q7.k.d(eVarI, "fqNameSafe.toUnsafe()");
        e9.b bVarF = e8.d.f(eVarI);
        if (bVarF != null) {
            strE = m9.b.b(bVarF).e();
            q7.k.d(strE, "byClassId(it).internalName");
        } else {
            strE = a.e(eVar, x8.e.f11257d);
        }
        q7.k.e(strE, "internalName");
        return strE + '.' + str;
    }

    public static void B(int i2, long j2, byte[] bArr) {
        int i10 = 0;
        while (i10 < 4) {
            bArr[i2 + i10] = (byte) (255 & j2);
            i10++;
            j2 >>= 8;
        }
    }

    public static final z C(k2.a aVar) {
        return new z(aVar.f5575a, aVar.f5576b, aVar.f5577c, aVar.f5578d);
    }

    public static String E(long j2) {
        int i2 = (int) (j2 >> 32);
        int i10 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i2) == Float.intBitsToFloat(i10)) {
            return "CornerRadius.circular(" + a.D(Float.intBitsToFloat(i2)) + ')';
        }
        return "CornerRadius.elliptical(" + a.D(Float.intBitsToFloat(i2)) + ", " + a.D(Float.intBitsToFloat(i10)) + ')';
    }

    public static void F(int i2, int[] iArr, int[] iArr2, int[] iArr3, int i10, int[] iArr4) {
        int i11 = i2;
        int i12 = iArr3[0];
        int i13 = iArr3[1];
        int i14 = iArr3[2];
        int i15 = iArr3[3];
        int i16 = i11 - 1;
        int i17 = iArr[i16] >> 31;
        int i18 = iArr2[i16] >> 31;
        int i19 = (i12 & i17) + (i13 & i18);
        int i20 = (i17 & i14) + (i18 & i15);
        int i21 = iArr4[0];
        long j2 = i12;
        long j4 = iArr[0];
        long j10 = i13;
        long j11 = iArr2[0];
        long j12 = (j10 * j11) + (j2 * j4);
        long j13 = i14;
        long j14 = i15;
        long j15 = (j14 * j11) + (j4 * j13);
        int i22 = i19 - (((((int) j12) * i10) + i19) & 1073741823);
        long j16 = i21;
        long j17 = i22;
        long j18 = (j16 * j17) + j12;
        long j19 = i20 - (((((int) j15) * i10) + i20) & 1073741823);
        long j20 = (j16 * j19) + j15;
        long j21 = j18 >> 30;
        int i23 = 1;
        long j22 = j20 >> 30;
        while (i23 < i11) {
            int i24 = iArr4[i23];
            long j23 = j19;
            long j24 = j13;
            long j25 = iArr[i23];
            long j26 = iArr2[i23];
            long j27 = j10 * j26;
            long j28 = i24;
            long j29 = (j28 * j17) + j27 + (j2 * j25) + j21;
            long j30 = (j28 * j23) + (j26 * j14) + (j24 * j25) + j22;
            int i25 = i23 - 1;
            iArr[i25] = ((int) j29) & 1073741823;
            j21 = j29 >> 30;
            iArr2[i25] = ((int) j30) & 1073741823;
            j22 = j30 >> 30;
            i23++;
            i11 = i2;
            j19 = j23;
            j13 = j24;
        }
        iArr[i16] = (int) j21;
        iArr2[i16] = (int) j22;
    }

    public static void G(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = iArr3[0];
        boolean z4 = true;
        int i11 = iArr3[1];
        int i12 = iArr3[2];
        int i13 = iArr3[3];
        long j2 = i10;
        long j4 = iArr[0];
        long j10 = i11;
        long j11 = iArr2[0];
        long j12 = (j10 * j11) + (j2 * j4);
        long j13 = i12;
        long j14 = i13;
        long j15 = (j11 * j14) + (j4 * j13);
        char c10 = 30;
        long j16 = j12 >> 30;
        long j17 = j15 >> 30;
        int i14 = 1;
        while (true) {
            boolean z10 = z4;
            if (i14 >= i2) {
                int i15 = i2 - 1;
                iArr[i15] = (int) j16;
                iArr2[i15] = (int) j17;
                return;
            }
            char c11 = c10;
            long j18 = j13;
            long j19 = iArr[i14];
            long j20 = j2 * j19;
            long j21 = iArr2[i14];
            long j22 = (j10 * j21) + j20 + j16;
            long j23 = (j21 * j14) + (j18 * j19) + j17;
            int i16 = i14 - 1;
            iArr[i16] = ((int) j22) & 1073741823;
            j16 = j22 >> c11;
            iArr2[i16] = ((int) j23) & 1073741823;
            j17 = j23 >> c11;
            i14++;
            c10 = c11;
            z4 = z10;
            j13 = j18;
        }
    }

    public static final void a(String str, n0.m mVar, h0 h0Var, int i2, boolean z4, int i10, int i11, p pVar, int i12) {
        int i13;
        pVar.T(-1186827822);
        if ((i12 & 6) == 0) {
            i13 = (pVar.f(str) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= pVar.f(mVar) ? 32 : 16;
        }
        if ((i12 & 384) == 0) {
            i13 |= pVar.f(h0Var) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i13 |= pVar.h(null) ? 2048 : NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        }
        if ((i12 & 24576) == 0) {
            i13 |= pVar.d(i2) ? 16384 : NanoHTTPD.HTTPSession.BUFSIZE;
        }
        if ((196608 & i12) == 0) {
            i13 |= pVar.g(z4) ? 131072 : 65536;
        }
        if ((1572864 & i12) == 0) {
            i13 |= pVar.d(i10) ? 1048576 : 524288;
        }
        if ((12582912 & i12) == 0) {
            i13 |= pVar.d(i11) ? 8388608 : 4194304;
        }
        if (((i13 | 100663296) & 38347923) == 38347922 && pVar.z()) {
            pVar.O();
        } else {
            if (i11 <= 0 || i10 <= 0) {
                throw new IllegalArgumentException(("both minLines " + i11 + " and maxLines " + i10 + " must be greater than zero").toString());
            }
            if (i11 > i10) {
                throw new IllegalArgumentException(x.k("minLines ", i11, i10, " must be less than or equal to maxLines ").toString());
            }
            if (pVar.j(w.b.f10624a) != null) {
                throw new ClassCastException();
            }
            pVar.S(-1588686502);
            pVar.q(false);
            pVar.S(-1587866335);
            n0.m mVarC = androidx.compose.ui.graphics.a.b(mVar, 0.0f, null, 131071).c(new TextStringSimpleElement(str, h0Var, (v1.d) pVar.j(g1.f5177k), i2, z4, i10, i11));
            pVar.q(false);
            int iHashCode = Long.hashCode(pVar.Q);
            n0.m mVarV = a.a.V(pVar, mVarC);
            t1 t1VarL = pVar.l();
            i1.h.f4488c.getClass();
            y yVar = i1.g.f4474b;
            pVar.U();
            if (pVar.P) {
                pVar.k(yVar);
            } else {
                pVar.e0();
            }
            b0.b.q(pVar, u.c.f9868a, i1.g.f4477e);
            b0.b.q(pVar, t1VarL, i1.g.f4476d);
            b0.b.q(pVar, mVarV, i1.g.f4475c);
            i1.f fVar = i1.g.f4478f;
            if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iHashCode))) {
                a1.a.r(iHashCode, pVar, iHashCode, fVar);
            }
            pVar.q(true);
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new u.a(str, mVar, h0Var, i2, z4, i10, i11, i12);
        }
    }

    public static final o0.d b(String str) {
        return new o0.d(ib.k.S(str));
    }

    public static final t0.d c(float f10, float f11, float f12, float f13, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2));
        return new t0.d(f10, f11, f12, f13, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits);
    }

    public static int d(int i2, int[] iArr, int[] iArr2) {
        int i10 = i2 - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12] + iArr2[i12] + i11;
            iArr[i12] = 1073741823 & i13;
            i11 = i13 >> 30;
        }
        int i14 = iArr[i10] + iArr2[i10] + i11;
        iArr[i10] = i14;
        return i14 >> 30;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        long jS = s(0, bArr) & 67108863;
        int i2 = 3;
        long jS2 = (s(3, bArr) >> 2) & 67108611;
        long jS3 = (s(6, bArr) >> 4) & 67092735;
        long jS4 = (s(9, bArr) >> 6) & 66076671;
        long jS5 = (s(12, bArr) >> 8) & 1048575;
        long j2 = jS2 * 5;
        long j4 = jS3 * 5;
        long j10 = jS4 * 5;
        long j11 = jS5 * 5;
        byte[] bArr3 = new byte[17];
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        int i10 = 0;
        while (i10 < bArr2.length) {
            int iMin = Math.min(16, bArr2.length - i10);
            System.arraycopy(bArr2, i10, bArr3, 0, iMin);
            bArr3[iMin] = 1;
            if (iMin != 16) {
                Arrays.fill(bArr3, iMin + 1, 17, (byte) 0);
            }
            long jS6 = j16 + (s(0, bArr3) & 67108863);
            long jS7 = j12 + ((s(i2, bArr3) >> 2) & 67108863);
            long jS8 = j13 + ((s(6, bArr3) >> 4) & 67108863);
            long jS9 = j14 + ((s(9, bArr3) >> 6) & 67108863);
            long j17 = jS2;
            long jS10 = j15 + (((s(12, bArr3) >> 8) & 67108863) | (bArr3[16] << 24));
            long j18 = (jS10 * j2) + (jS9 * j4) + (jS8 * j10) + (jS7 * j11) + (jS6 * jS);
            long j19 = (jS10 * j4) + (jS9 * j10) + (jS8 * j11) + (jS7 * jS) + (jS6 * j17);
            long j20 = (jS10 * j10) + (jS9 * j11) + (jS8 * jS) + (jS7 * j17) + (jS6 * jS3);
            long j21 = (jS10 * j11) + (jS9 * jS) + (jS8 * j17) + (jS7 * jS3) + (jS6 * jS4);
            long j22 = jS9 * j17;
            long j23 = jS10 * jS;
            long j24 = j19 + (j18 >> 26);
            long j25 = j20 + (j24 >> 26);
            long j26 = j21 + (j25 >> 26);
            long j27 = j23 + j22 + (jS8 * jS3) + (jS7 * jS4) + (jS6 * jS5) + (j26 >> 26);
            long j28 = j27 >> 26;
            j15 = j27 & 67108863;
            long j29 = (j28 * 5) + (j18 & 67108863);
            i10 += 16;
            j13 = j25 & 67108863;
            j14 = j26 & 67108863;
            j16 = j29 & 67108863;
            j12 = (j24 & 67108863) + (j29 >> 26);
            jS2 = j17;
            i2 = 3;
        }
        long j30 = j13 + (j12 >> 26);
        long j31 = j30 & 67108863;
        long j32 = j14 + (j30 >> 26);
        long j33 = j32 & 67108863;
        long j34 = j15 + (j32 >> 26);
        long j35 = j34 & 67108863;
        long j36 = ((j34 >> 26) * 5) + j16;
        long j37 = j36 >> 26;
        long j38 = j36 & 67108863;
        long j39 = (j12 & 67108863) + j37;
        long j40 = j38 + 5;
        long j41 = j40 & 67108863;
        long j42 = j39 + (j40 >> 26);
        long j43 = j31 + (j42 >> 26);
        long j44 = j33 + (j43 >> 26);
        long j45 = j44 & 67108863;
        long j46 = (j35 + (j44 >> 26)) - 67108864;
        long j47 = j46 >> 63;
        long j48 = j38 & j47;
        long j49 = j39 & j47;
        long j50 = j31 & j47;
        long j51 = j33 & j47;
        long j52 = j35 & j47;
        long j53 = ~j47;
        long j54 = j49 | (j42 & 67108863 & j53);
        long j55 = j50 | (j43 & 67108863 & j53);
        long j56 = j51 | (j45 & j53);
        long j57 = (j48 | (j41 & j53) | (j54 << 26)) & 4294967295L;
        long j58 = ((j54 >> 6) | (j55 << 20)) & 4294967295L;
        long j59 = ((j55 >> 12) | (j56 << 14)) & 4294967295L;
        long j60 = ((j56 >> 18) | ((j52 | (j46 & j53)) << 8)) & 4294967295L;
        long jS11 = s(16, bArr) + j57;
        long j61 = jS11 & 4294967295L;
        long jS12 = s(20, bArr) + j58 + (jS11 >> 32);
        long jS13 = s(24, bArr) + j59 + (jS12 >> 32);
        long jS14 = (s(28, bArr) + j60 + (jS13 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        B(0, j61, bArr4);
        B(4, jS12 & 4294967295L, bArr4);
        B(8, jS13 & 4294967295L, bArr4);
        B(12, jS14, bArr4);
        return bArr4;
    }

    public static final y9.p f(int i2) {
        x.t(i2, "<this>");
        int iD = n.f.d(i2);
        if (iD == 0) {
            return y9.p.INV;
        }
        if (iD == 1) {
            return y9.p.IN;
        }
        if (iD == 2) {
            return y9.p.OUT;
        }
        throw new u();
    }

    public static o9.n g(String str, Collection collection) {
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        q7.k.e(collection, "types");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(t.A0(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(((v) it.next()).v0());
        }
        ea.f fVarT = a.a.T(arrayList);
        int i2 = fVarT.f3233f;
        o9.n aVar = i2 != 0 ? i2 != 1 ? new o9.a(str, (o9.n[]) fVarT.toArray(new o9.n[0])) : (o9.n) fVarT.get(0) : o9.m.f7933b;
        return fVarT.f3233f <= 1 ? aVar : new o9.j(aVar);
    }

    public static final m1 h(w7.e eVar, List list, boolean z4, List list2) {
        f8.g gVarA;
        i0 i0Var;
        p0 e0Var;
        q7.k.e(eVar, "<this>");
        q7.k.e(list, "arguments");
        q7.k.e(list2, "annotations");
        b0 b0Var = eVar instanceof b0 ? (b0) eVar : null;
        if (b0Var == null || (gVarA = b0Var.a()) == null) {
            throw new c7.i("Cannot create type for an unsupported classifier: " + eVar + " (" + eVar.getClass() + ')', 3);
        }
        m0 m0VarH = gVarA.h();
        q7.k.d(m0VarH, "descriptor.typeConstructor");
        List parameters = m0VarH.getParameters();
        q7.k.d(parameters, "typeConstructor.parameters");
        if (parameters.size() != list.size()) {
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
        }
        if (list2.isEmpty()) {
            i0.f10557g.getClass();
            i0Var = i0.f10558h;
        } else {
            i0.f10557g.getClass();
            i0Var = i0.f10558h;
        }
        List parameters2 = m0VarH.getParameters();
        q7.k.d(parameters2, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(t.A0(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i10 = i2 + 1;
            if (i2 < 0) {
                s.z0();
                throw null;
            }
            w7.x xVar = (w7.x) obj;
            m1 m1Var = (m1) xVar.f10876b;
            v vVar = m1Var != null ? m1Var.f11908f : null;
            w7.y yVar = xVar.f10875a;
            int i11 = yVar == null ? -1 : x7.b.$EnumSwitchMapping$0[yVar.ordinal()];
            if (i11 == -1) {
                Object obj2 = parameters2.get(i2);
                q7.k.d(obj2, "parameters[index]");
                e0Var = new e0((q0) obj2);
            } else if (i11 == 1) {
                q7.k.b(vVar);
                e0Var = new v9.q0(1, vVar);
            } else if (i11 == 2) {
                q7.k.b(vVar);
                e0Var = new v9.q0(2, vVar);
            } else {
                if (i11 != 3) {
                    throw new u();
                }
                q7.k.b(vVar);
                e0Var = new v9.q0(3, vVar);
            }
            arrayList.add(e0Var);
            i2 = i10;
        }
        return new m1(v9.d.r(arrayList, i0Var, m0VarH, z4), null);
    }

    public static void i(int i2, int[] iArr, int[] iArr2) {
        int i10 = 0;
        long j2 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i2 > 0) {
            while (i10 < Math.min(32, i2)) {
                j2 |= iArr[i11] << i10;
                i10 += 30;
                i11++;
            }
            iArr2[i12] = (int) j2;
            j2 >>>= 32;
            i10 -= 32;
            i2 -= 32;
            i12++;
        }
    }

    public static void j(int i2, int[] iArr, int[] iArr2) {
        int i10 = 0;
        long j2 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i2 > 0) {
            if (i10 < Math.min(30, i2)) {
                j2 |= (iArr[i11] & 4294967295L) << i10;
                i10 += 32;
                i11++;
            }
            iArr2[i12] = ((int) j2) & 1073741823;
            j2 >>>= 30;
            i10 -= 30;
            i2 -= 30;
            i12++;
        }
    }

    public static int k(int i2, int i10, int[] iArr) {
        int i11 = i10 ^ iArr[0];
        for (int i12 = 1; i12 < i2; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static final boolean l(long j2, long j4) {
        return j2 == j4;
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        q7.k.b(str);
        if (!r.g0(str, "16-", false)) {
            return null;
        }
        String strSubstring = str.substring(3);
        q7.k.d(strSubstring, "substring(...)");
        int length = strSubstring.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length) {
            boolean z10 = q7.k.f(strSubstring.charAt(!z4 ? i2 : length), 32) <= 0;
            if (z4) {
                if (!z10) {
                    break;
                }
                length--;
            } else if (z10) {
                i2++;
            } else {
                z4 = true;
            }
        }
        String string = strSubstring.subSequence(i2, length + 1).toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return "16-" + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(Long.parseLong(string) * 1000));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String[] n(o0.k kVar) {
        q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidContentType");
        return (String[]) ((o0.d) kVar).f7180b.toArray(new String[0]);
    }

    public static final ViewParent o(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            return parent;
        }
        Object tag = view.getTag(R.id.view_tree_disjoint_parent);
        if (tag instanceof ViewParent) {
            return (ViewParent) tag;
        }
        return null;
    }

    public static String p() {
        String str;
        try {
            try {
                str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "ro.build.aios_version", "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strM = m(str);
            if (strM != null) {
                return strM;
            }
            if (!TextUtils.isEmpty(str)) {
                q7.k.b(str);
                int length = str.length() - 1;
                int i2 = 0;
                boolean z4 = false;
                while (i2 <= length) {
                    boolean z10 = q7.k.f(str.charAt(!z4 ? i2 : length), 32) <= 0;
                    if (z4) {
                        if (!z10) {
                            break;
                        }
                        length--;
                    } else if (z10) {
                        i2++;
                    } else {
                        z4 = true;
                    }
                }
                if (!"16-".equals(str.subSequence(i2, length + 1).toString())) {
                    return str;
                }
            }
            String str2 = Build.DISPLAY;
            q7.k.d(str2, "DISPLAY");
            return str2;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static int q(int i2) {
        int i10 = (2 - (i2 * i2)) * i2;
        int i11 = (2 - (i2 * i10)) * i10;
        int i12 = (2 - (i2 * i11)) * i11;
        return (2 - (i2 * i12)) * i12;
    }

    public static final boolean r(t0.d dVar) {
        long j2 = dVar.f9664e;
        return (j2 >>> 32) == (4294967295L & j2) && j2 == dVar.f9665f && j2 == dVar.f9666g && j2 == dVar.f9667h;
    }

    public static long s(int i2, byte[] bArr) {
        return (((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16)) & 4294967295L;
    }

    public static int t(int i2, int[] iArr) {
        int i10 = i2 - 1;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i11 - iArr[i12];
            iArr[i12] = 1073741823 & i13;
            i11 = i13 >> 30;
        }
        int i14 = i11 - iArr[i10];
        iArr[i10] = i14;
        return i14 >> 30;
    }

    public static e9.f u(e9.f fVar, String str, String str2, int i2) {
        char cCharAt;
        char cCharAt2;
        Object next;
        boolean z4 = (i2 & 4) != 0;
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        if (!fVar.f3198g) {
            String strC = fVar.c();
            if (r.g0(strC, str, false) && strC.length() != str.length() && ('a' > (cCharAt = strC.charAt(str.length())) || cCharAt >= '{')) {
                if (str2 != null) {
                    return e9.f.e(str2.concat(ga.k.z0(strC, str)));
                }
                if (!z4) {
                    return fVar;
                }
                String strZ0 = ga.k.z0(strC, str);
                if (strZ0.length() != 0 && w7.e0.F(0, strZ0)) {
                    if (strZ0.length() != 1 && w7.e0.F(1, strZ0)) {
                        Iterator it = new v7.d(0, strZ0.length() - 1, 1).iterator();
                        while (true) {
                            v7.c cVar = (v7.c) it;
                            if (!cVar.f10528h) {
                                next = null;
                                break;
                            }
                            next = cVar.next();
                            if (!w7.e0.F(((Number) next).intValue(), strZ0)) {
                                break;
                            }
                        }
                        Integer num = (Integer) next;
                        if (num != null) {
                            int iIntValue = num.intValue() - 1;
                            String strSubstring = strZ0.substring(0, iIntValue);
                            q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            String strO = w7.e0.O(strSubstring);
                            String strSubstring2 = strZ0.substring(iIntValue);
                            q7.k.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                            strZ0 = strO.concat(strSubstring2);
                        } else {
                            strZ0 = w7.e0.O(strZ0);
                        }
                    } else if (strZ0.length() != 0 && 'A' <= (cCharAt2 = strZ0.charAt(0)) && cCharAt2 < '[') {
                        char lowerCase = Character.toLowerCase(cCharAt2);
                        String strSubstring3 = strZ0.substring(1);
                        q7.k.d(strSubstring3, "this as java.lang.String).substring(startIndex)");
                        strZ0 = lowerCase + strSubstring3;
                    }
                }
                if (e9.f.f(strZ0)) {
                    return e9.f.e(strZ0);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String v(java.lang.String r2) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "root/.openclaw/openclaw.json"
            r0.<init>(r2, r1)
            boolean r2 = r0.exists()
            r1 = 0
            if (r2 != 0) goto Lf
            return r1
        Lf:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = n7.l.N(r0)     // Catch: java.lang.Throwable -> L39
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "gateway"
            org.json.JSONObject r2 = r2.optJSONObject(r0)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L37
            java.lang.String r0 = "auth"
            org.json.JSONObject r2 = r2.optJSONObject(r0)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L37
            java.lang.String r0 = "token"
            java.lang.String r2 = r2.optString(r0)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L37
            int r0 = r2.length()     // Catch: java.lang.Throwable -> L39
            if (r0 <= 0) goto L37
            goto L3e
        L37:
            r2 = r1
            goto L3e
        L39:
            r2 = move-exception
            c7.l r2 = w7.e0.n(r2)
        L3e:
            boolean r0 = r2 instanceof c7.l
            if (r0 == 0) goto L43
            goto L44
        L43:
            r1 = r2
        L44:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.o.v(java.lang.String):java.lang.String");
    }

    public static final String w(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[NanoHTTPD.HTTPSession.BUFSIZE];
        int i2 = reader.read(cArr);
        while (i2 >= 0) {
            stringWriter.write(cArr, 0, i2);
            i2 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public static final r8.d x(a3.b bVar, v8.b bVar2) {
        q7.k.e(bVar, "<this>");
        q7.k.e(bVar2, "annotationsOwner");
        return new r8.d(bVar, bVar2, false);
    }

    public static boolean z(Context context, String str, String str2, String str3, String str4) {
        long jB = w7.e0.b(context);
        if (jB < 1000001) {
            return true;
        }
        q6.b bVar = q6.a.f8785a;
        String packageName = context.getPackageName();
        bVar.getClass();
        return !TextUtils.isEmpty(str4) && str4.equals(q6.b.B0(str, str2, packageName, jB, str3));
    }

    public Map D() {
        if (!(this instanceof o5.g)) {
            if (this instanceof o5.i) {
                o5.i iVar = (o5.i) this;
                return d7.e0.U(new c7.j("status", "unavailable"), new c7.j("reason", iVar.f7763b), new c7.j("sinceMs", Long.valueOf(iVar.f7764c)), new c7.j("retryHint", iVar.f7765d.getWire()));
            }
            if (this instanceof o5.h) {
                return d7.e0.U(new c7.j("status", "degraded"), new c7.j("reason", "bff ws connected, awaiting auth"), new c7.j("sinceMs", Long.valueOf(((o5.h) this).f7762b)));
            }
            throw new u();
        }
        e7.g gVar = new e7.g();
        gVar.put("status", "available");
        String str = ((o5.g) this).f7761b;
        if (str != null && !ga.k.t0(str)) {
            gVar.put("reason", str);
        }
        return gVar.c();
    }

    public int hashCode() {
        switch (this.f6875a) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f6875a) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                String strT = w.f8821a.b(getClass()).t();
                q7.k.b(strT);
                return strT;
            default:
                return super.toString();
        }
    }

    public boolean y(o oVar) {
        if (this instanceof o5.g) {
            if (!(oVar instanceof o5.g)) {
                return false;
            }
            if (!q7.k.a(((o5.g) this).f7761b, ((o5.g) oVar).f7761b)) {
                return false;
            }
        } else {
            if (!(this instanceof o5.i)) {
                if (this instanceof o5.h) {
                    return oVar instanceof o5.h;
                }
                throw new u();
            }
            if (!(oVar instanceof o5.i)) {
                return false;
            }
            o5.i iVar = (o5.i) this;
            o5.i iVar2 = (o5.i) oVar;
            if (!iVar.f7763b.equals(iVar2.f7763b) || iVar.f7765d != iVar2.f7765d) {
                return false;
            }
        }
        return true;
    }
}
