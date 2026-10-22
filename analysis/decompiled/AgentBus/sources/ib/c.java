package ib;

import ab.u;
import ab.x;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import d7.r;
import d7.t;
import d7.z;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k.a0;
import k.b0;
import k.g0;
import p1.n;
import p1.s;
import w7.e0;
import z8.c1;

/* loaded from: classes.dex */
public abstract class c {
    public static final int A(a8.h hVar) {
        q7.k.e(hVar, "<this>");
        return hVar.i().size();
    }

    public static final int B(int i2, int i10, int i11) {
        if (i11 > 0) {
            if (i2 < i10) {
                int i12 = i10 % i11;
                if (i12 < 0) {
                    i12 += i11;
                }
                int i13 = i2 % i11;
                if (i13 < 0) {
                    i13 += i11;
                }
                int i14 = (i12 - i13) % i11;
                if (i14 < 0) {
                    i14 += i11;
                }
                return i10 - i14;
            }
        } else {
            if (i11 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i2 > i10) {
                int i15 = -i11;
                int i16 = i2 % i15;
                if (i16 < 0) {
                    i16 += i15;
                }
                int i17 = i10 % i15;
                if (i17 < 0) {
                    i17 += i15;
                }
                int i18 = (i16 - i17) % i15;
                if (i18 < 0) {
                    i18 += i15;
                }
                return i18 + i10;
            }
        }
        return i10;
    }

    public static final int C(int i2, int i10) {
        return (i2 >> i10) & 31;
    }

    public static boolean D() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean E(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long F(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.c.F(int, java.lang.String):long");
    }

    public static c6.a G(String str) {
        q7.k.e(str, "msg");
        return new c6.a(1002, str, null);
    }

    public static void J(Context context, u5.c cVar, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(cVar, intentFilter, null, null, 4);
            return;
        }
        String str = context.getApplicationContext().getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (k.n(context, str) != 0) {
            str = context.getOpPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
            if (k.n(context, str) != 0) {
                throw new RuntimeException(a1.a.j("Permission ", str, " is required by your application to receive broadcasts, please add it to your manifest"));
            }
        }
        context.registerReceiver(cVar, intentFilter, str, null);
    }

    public static final boolean K(a0 a0Var, Object obj, Object obj2) {
        Object objG = a0Var.g(obj);
        if (objG == null) {
            return false;
        }
        if (!(objG instanceof b0)) {
            if (!objG.equals(obj2)) {
                return false;
            }
            a0Var.j(obj);
            return true;
        }
        b0 b0Var = (b0) objG;
        boolean zK = b0Var.k(obj2);
        if (zK && b0Var.g()) {
            a0Var.j(obj);
        }
        return zK;
    }

    public static final void L(a0 a0Var, Object obj) {
        boolean zG;
        long[] jArr = a0Var.f5446a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        int i12 = (i2 << 3) + i11;
                        Object obj2 = a0Var.f5447b[i12];
                        Object obj3 = a0Var.f5448c[i12];
                        if (obj3 instanceof b0) {
                            b0 b0Var = (b0) obj3;
                            b0Var.k(obj);
                            zG = b0Var.g();
                        } else {
                            zG = obj3 == obj;
                        }
                        if (zG) {
                            a0Var.k(i12);
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final d2.j M(t0.c cVar) {
        return new d2.j(Math.round(cVar.f9656a), Math.round(cVar.f9657b), Math.round(cVar.f9658c), Math.round(cVar.f9659d));
    }

    public static final void N(n nVar, p2.h hVar) {
        Object objG = nVar.k().f8304f.g(s.f8350g);
        if (objG == null) {
            objG = null;
        }
        if (objG != null) {
            throw new ClassCastException();
        }
        n nVarL = nVar.l();
        if (nVarL == null) {
            return;
        }
        Object objG2 = nVarL.k().f8304f.g(s.f8348e);
        if (objG2 == null) {
            objG2 = null;
        }
        if (objG2 != null) {
            Object objG3 = nVarL.k().f8304f.g(s.f8349f);
            if ((objG3 != null ? objG3 : null) != null) {
                throw new ClassCastException();
            }
            if (nVar.k().f8304f.c(s.E)) {
                ArrayList arrayList = new ArrayList();
                List listI = nVarL.i((4 & 1) != 0 ? !nVarL.f8313b : false, (4 & 2) == 0);
                int size = listI.size();
                int i2 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    n nVar2 = (n) listI.get(i10);
                    if (nVar2.k().f8304f.c(s.E)) {
                        arrayList.add(nVar2);
                        if (nVar2.f8314c.o() < nVar.f8314c.o()) {
                            i2++;
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                boolean zJ = j(arrayList);
                int i11 = zJ ? 0 : i2;
                int i12 = zJ ? i2 : 0;
                Object objG4 = nVar.k().f8304f.g(s.E);
                if (objG4 == null) {
                    objG4 = Boolean.FALSE;
                }
                hVar.f8393a.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, 1, i12, 1, false, ((Boolean) objG4).booleanValue()));
            }
        }
    }

    public static final double O(long j2) {
        return ((j2 >>> 11) * 2048) + (j2 & 2047);
    }

    public static final long a(int i2) {
        long j2 = (i2 << 32) | (0 & 4294967295L);
        int i10 = a1.b.f153p;
        return j2;
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            return str.charAt(0) + "*";
        }
        return str.charAt(0) + "*" + str.substring(str.length() - 1);
    }

    public static final Object[] c(Object[] objArr, int i2, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        d7.n.a0(objArr, objArr2, 0, i2, 6);
        d7.n.Y(objArr, objArr2, i2 + 2, i2, objArr.length);
        objArr2[i2] = obj;
        objArr2[i2 + 1] = obj2;
        return objArr2;
    }

    public static final void d(db.a aVar, db.c cVar, String str) {
        db.e.f3031i.fine(cVar.f3023b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f3016a);
    }

    public static final Object[] e(int i2, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 2];
        d7.n.a0(objArr, objArr2, 0, i2, 6);
        d7.n.Y(objArr, objArr2, i2, i2 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] f(int i2, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 1];
        d7.n.a0(objArr, objArr2, 0, i2, 6);
        d7.n.Y(objArr, objArr2, i2, i2 + 1, objArr.length);
        return objArr2;
    }

    public static final void g(a0 a0Var, Object obj, Object obj2) {
        int iF = a0Var.f(obj);
        boolean z4 = iF < 0;
        Object obj3 = z4 ? null : a0Var.f5448c[iF];
        if (obj3 != null) {
            if (obj3 instanceof b0) {
                ((b0) obj3).a(obj2);
            } else if (obj3 != obj2) {
                b0 b0Var = new b0();
                b0Var.a(obj3);
                b0Var.a(obj2);
                obj2 = b0Var;
            }
            obj2 = obj3;
        }
        if (!z4) {
            a0Var.f5448c[iF] = obj2;
            return;
        }
        int i2 = ~iF;
        a0Var.f5447b[i2] = obj;
        a0Var.f5448c[i2] = obj2;
    }

    public static ArrayList h(List list) {
        q7.k.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((u) obj) != u.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((u) it.next()).f655f);
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(ka.t r4, b0.l r5, i7.c r6) {
        /*
            boolean r0 = r6 instanceof ka.r
            if (r0 == 0) goto L13
            r0 = r6
            ka.r r0 = (ka.r) r0
            int r1 = r0.f5718h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5718h = r1
            goto L18
        L13:
            ka.r r0 = new ka.r
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f5717g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f5718h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            b0.l r5 = r0.f5716f
            w7.e0.N(r6)     // Catch: java.lang.Throwable -> L29
            goto L64
        L29:
            r4 = move-exception
            goto L6a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            w7.e0.N(r6)
            g7.l r6 = r0.getContext()
            ia.z r2 = ia.z.f5027g
            g7.j r6 = r6.o(r2)
            if (r6 != r4) goto L6e
            r0.f5716f = r5     // Catch: java.lang.Throwable -> L29
            r0.f5718h = r3     // Catch: java.lang.Throwable -> L29
            ia.m r6 = new ia.m     // Catch: java.lang.Throwable -> L29
            g7.d r0 = ib.k.C(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.s()     // Catch: java.lang.Throwable -> L29
            c6.i r0 = new c6.i     // Catch: java.lang.Throwable -> L29
            r2 = 3
            r0.<init>(r2, r6)     // Catch: java.lang.Throwable -> L29
            ka.s r4 = (ka.s) r4     // Catch: java.lang.Throwable -> L29
            r4.o0(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.r()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L64
            return r1
        L64:
            r5.c()
            c7.r r4 = c7.r.f1986a
            return r4
        L6a:
            r5.c()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.c.i(ka.t, b0.l, i7.c):java.lang.Object");
    }

    public static final boolean j(ArrayList arrayList) {
        List list;
        long j2;
        if (arrayList.size() >= 2) {
            if (arrayList.size() <= 1) {
                list = z.f2978f;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Object obj = arrayList.get(0);
                int iT0 = d7.s.t0(arrayList);
                int i2 = 0;
                while (i2 < iT0) {
                    i2++;
                    Object obj2 = arrayList.get(i2);
                    n nVar = (n) obj2;
                    n nVar2 = (n) obj;
                    float fAbs = Math.abs(Float.intBitsToFloat((int) (nVar2.g().a() >> 32)) - Float.intBitsToFloat((int) (nVar.g().a() >> 32)));
                    float fAbs2 = Math.abs(Float.intBitsToFloat((int) (nVar2.g().a() & 4294967295L)) - Float.intBitsToFloat((int) (nVar.g().a() & 4294967295L)));
                    arrayList2.add(new t0.b((Float.floatToRawIntBits(fAbs) << 32) | (Float.floatToRawIntBits(fAbs2) & 4294967295L)));
                    obj = obj2;
                }
                list = arrayList2;
            }
            if (list.size() == 1) {
                j2 = ((t0.b) r.N0(list)).f9654a;
            } else {
                if (list.isEmpty()) {
                    f2.a.b("Empty collection can't be reduced.");
                }
                Object objN0 = r.N0(list);
                int iT02 = d7.s.t0(list);
                if (1 <= iT02) {
                    int i10 = 1;
                    while (true) {
                        objN0 = new t0.b(t0.b.g(((t0.b) objN0).f9654a, ((t0.b) list.get(i10)).f9654a));
                        if (i10 == iT02) {
                            break;
                        }
                        i10++;
                    }
                }
                j2 = ((t0.b) objN0).f9654a;
            }
            if (Float.intBitsToFloat((int) (4294967295L & j2)) >= Float.intBitsToFloat((int) (j2 >> 32))) {
                return false;
            }
        }
        return true;
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void o(int i2) {
        if (2 > i2 || i2 >= 37) {
            StringBuilder sbN = a1.a.n(i2, "radix ", " was not in valid range ");
            sbN.append(new v7.d(2, 36, 1));
            throw new IllegalArgumentException(sbN.toString());
        }
    }

    public static byte[] p(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) throws IllegalStateException, GeneralSecurityException {
        Mac mac = (Mac) h4.m.f4150c.f4151a.a(str);
        if (i2 > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        byte[] bArr4 = new byte[i2];
        mac.init(new SecretKeySpec(mac.doFinal(bArr), str));
        byte[] bArrDoFinal = new byte[0];
        int i10 = 1;
        int length = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr3);
            mac.update((byte) i10);
            bArrDoFinal = mac.doFinal();
            if (bArrDoFinal.length + length >= i2) {
                System.arraycopy(bArrDoFinal, 0, bArr4, length, i2 - length);
                return bArr4;
            }
            System.arraycopy(bArrDoFinal, 0, bArr4, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i10++;
        }
    }

    public static byte[] q(List list) {
        q7.k.e(list, "protocols");
        ob.h hVar = new ob.h();
        Iterator it = h(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            hVar.Q(str.length());
            hVar.U(str);
        }
        return hVar.r(hVar.f7993g);
    }

    public static a0 r() {
        long[] jArr = g0.f5491a;
        return new a0();
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [byte[], java.io.Serializable, java.lang.Object] */
    public static x s(String str, ab.r rVar) {
        q7.k.e(str, "<this>");
        Charset charset = ga.a.f4005a;
        if (rVar != null) {
            Pattern pattern = ab.r.f597c;
            Charset charsetA = rVar.a(null);
            if (charsetA == null) {
                String str2 = rVar + "; charset=utf-8";
                q7.k.e(str2, "<this>");
                try {
                    rVar = e0.x(str2);
                } catch (IllegalArgumentException unused) {
                    rVar = null;
                }
            } else {
                charset = charsetA;
            }
        }
        ?? bytes = str.getBytes(charset);
        q7.k.d(bytes, "this as java.lang.String).getBytes(charset)");
        int length = bytes.length;
        bb.b.c(bytes.length, 0, length);
        return new x(rVar, length, bytes, 0);
    }

    public static b9.h t(c1 c1Var) {
        q7.k.e(c1Var, "table");
        if (c1Var.f12082g.size() == 0) {
            return b9.h.f1585b;
        }
        List list = c1Var.f12082g;
        q7.k.d(list, "table.requirementList");
        return new b9.h(list);
    }

    public static int u(String str, int i2, int i10, boolean z4) {
        while (i2 < i10) {
            char cCharAt = str.charAt(i2);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z4)) {
                return i2;
            }
            i2++;
        }
        return i10;
    }

    public static boolean v(String str, String str2) {
        q7.k.e(str, "current");
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i2 = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    int i12 = i11 + 1;
                    if (i11 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt != '(') {
                        if (cCharAt == ')' && i10 - 1 == 0 && i11 != str.length() - 1) {
                            break;
                        }
                    } else {
                        i10++;
                    }
                    i2++;
                    i11 = i12;
                } else if (i10 == 0) {
                    String strSubstring = str.substring(1, str.length() - 1);
                    q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return q7.k.a(ga.k.N0(strSubstring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static final boolean w(char c10, char c11, boolean z4) {
        if (c10 == c11) {
            return true;
        }
        if (!z4) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static c6.a x(String str, Throwable th) {
        q7.k.e(str, "msg");
        return new c6.a(1011, str, th);
    }

    public static final float y(float f10) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f10) & 8589934591L) / 3)) + 709952852);
        float f11 = fIntBitsToFloat - ((fIntBitsToFloat - (f10 / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f11 - ((f11 - (f10 / (f11 * f11))) * 0.33333334f);
    }

    public static final String z(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - 500000000) / 1000000000) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - 500000) / 1000000) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - 500) / 1000) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + 500) / 1000) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + 500000) / 1000000) + " ms";
        } else {
            str = ((j2 + 500000000) / 1000000000) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    public abstract void H(g2.f fVar, g2.f fVar2);

    public abstract void I(g2.f fVar, Thread thread);

    public abstract void P(byte[] bArr, int i2, int i10);

    public abstract boolean k(g2.g gVar, g2.c cVar);

    public abstract boolean l(g2.g gVar, Object obj, Object obj2);

    public abstract boolean m(g2.g gVar, g2.f fVar, g2.f fVar2);
}
