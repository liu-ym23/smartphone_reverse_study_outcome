package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 implements w0 {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f1160n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Unsafe f1161o = j1.i();

    /* renamed from: a, reason: collision with root package name */
    public int[] f1162a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1163b;

    /* renamed from: c, reason: collision with root package name */
    public int f1164c;

    /* renamed from: d, reason: collision with root package name */
    public int f1165d;

    /* renamed from: e, reason: collision with root package name */
    public a f1166e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1167f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f1168g;

    /* renamed from: h, reason: collision with root package name */
    public int f1169h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public p0 f1170j;

    /* renamed from: k, reason: collision with root package name */
    public c0 f1171k;

    /* renamed from: l, reason: collision with root package name */
    public e1 f1172l;

    /* renamed from: m, reason: collision with root package name */
    public j0 f1173m;

    public static Field B(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbO = androidx.activity.b.o("Field ", str, " for ");
            sbO.append(cls.getName());
            sbO.append(" not found. Known fields are ");
            sbO.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbO.toString());
        }
    }

    public static int G(int i) {
        return (i & 267386880) >>> 20;
    }

    public static boolean l(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof v) {
            return ((v) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.n0 s(androidx.datastore.preferences.protobuf.v0 r34, androidx.datastore.preferences.protobuf.p0 r35, androidx.datastore.preferences.protobuf.c0 r36, androidx.datastore.preferences.protobuf.e1 r37, androidx.datastore.preferences.protobuf.o r38, androidx.datastore.preferences.protobuf.j0 r39) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.s(androidx.datastore.preferences.protobuf.v0, androidx.datastore.preferences.protobuf.p0, androidx.datastore.preferences.protobuf.c0, androidx.datastore.preferences.protobuf.e1, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.j0):androidx.datastore.preferences.protobuf.n0");
    }

    public static long t(int i) {
        return i & 1048575;
    }

    public static int u(Object obj, long j10) {
        return ((Integer) j1.f1140c.h(obj, j10)).intValue();
    }

    public static long v(Object obj, long j10) {
        return ((Long) j1.f1140c.h(obj, j10)).longValue();
    }

    public final void A(int i, j jVar, Object obj) throws y {
        boolean z10 = (536870912 & i) != 0;
        c0 c0Var = this.f1171k;
        if (z10) {
            c0Var.getClass();
            jVar.w(c0.a(obj, i & 1048575), true);
        } else {
            c0Var.getClass();
            jVar.w(c0.a(obj, i & 1048575), false);
        }
    }

    public final void C(Object obj, int i) {
        int i3 = this.f1162a[i + 2];
        long j10 = 1048575 & i3;
        if (j10 == 1048575) {
            return;
        }
        j1.m(obj, j10, (1 << (i3 >>> 20)) | j1.f1140c.f(obj, j10));
    }

    public final void D(Object obj, int i, int i3) {
        j1.m(obj, this.f1162a[i3 + 2] & 1048575, i);
    }

    public final void E(Object obj, int i, a aVar) {
        f1161o.putObject(obj, H(i) & 1048575, aVar);
        C(obj, i);
    }

    public final void F(Object obj, int i, int i3, a aVar) {
        f1161o.putObject(obj, H(i3) & 1048575, aVar);
        D(obj, i, i3);
    }

    public final int H(int i) {
        return this.f1162a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x035c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(java.lang.Object r33, androidx.datastore.preferences.protobuf.f0 r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.I(java.lang.Object, androidx.datastore.preferences.protobuf.f0):void");
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void a(Object obj, f0 f0Var) throws IOException {
        f0Var.getClass();
        I(obj, f0Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x061c A[PHI: r22 r24 r26
      0x061c: PHI (r22v35 int) = 
      (r22v21 int)
      (r22v22 int)
      (r22v23 int)
      (r22v27 int)
      (r22v29 int)
      (r22v30 int)
      (r22v31 int)
      (r22v34 int)
      (r22v36 int)
     binds: [B:275:0x07f5, B:271:0x07d5, B:267:0x07b5, B:250:0x0730, B:236:0x06c0, B:232:0x06a0, B:228:0x0682, B:221:0x063e, B:215:0x061a] A[DONT_GENERATE, DONT_INLINE]
      0x061c: PHI (r24v19 int) = 
      (r24v2 int)
      (r24v3 int)
      (r24v4 int)
      (r24v8 int)
      (r24v10 int)
      (r24v11 int)
      (r24v12 int)
      (r24v16 int)
      (r24v20 int)
     binds: [B:275:0x07f5, B:271:0x07d5, B:267:0x07b5, B:250:0x0730, B:236:0x06c0, B:232:0x06a0, B:228:0x0682, B:221:0x063e, B:215:0x061a] A[DONT_GENERATE, DONT_INLINE]
      0x061c: PHI (r26v18 int) = 
      (r26v2 int)
      (r26v3 int)
      (r26v4 int)
      (r26v8 int)
      (r26v10 int)
      (r26v11 int)
      (r26v12 int)
      (r26v15 int)
      (r26v19 int)
     binds: [B:275:0x07f5, B:271:0x07d5, B:267:0x07b5, B:250:0x0730, B:236:0x06c0, B:232:0x06a0, B:228:0x0682, B:221:0x063e, B:215:0x061a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0338 A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(androidx.datastore.preferences.protobuf.v r32) {
        /*
            Method dump skipped, instructions count: 2758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.b(androidx.datastore.preferences.protobuf.v):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(androidx.datastore.preferences.protobuf.v r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.c(androidx.datastore.preferences.protobuf.v):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(androidx.datastore.preferences.protobuf.v r13, androidx.datastore.preferences.protobuf.v r14) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.d(androidx.datastore.preferences.protobuf.v, androidx.datastore.preferences.protobuf.v):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // androidx.datastore.preferences.protobuf.w0
    public final void e(java.lang.Object r20, androidx.datastore.preferences.protobuf.j r21, androidx.datastore.preferences.protobuf.n r22) {
        /*
            Method dump skipped, instructions count: 2012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.e(java.lang.Object, androidx.datastore.preferences.protobuf.j, androidx.datastore.preferences.protobuf.n):void");
    }

    public final boolean f(v vVar, v vVar2, int i) {
        return j(vVar, i) == j(vVar2, i);
    }

    public final void g(int i, Object obj, Object obj2) {
        int i3 = this.f1162a[i];
        if (j1.f1140c.h(obj, H(i) & 1048575) == null) {
            return;
        }
        h(i);
    }

    public final void h(int i) {
        if (this.f1163b[((i / 3) * 2) + 1] == null) {
            return;
        }
        od.f.j();
    }

    public final w0 i(int i) {
        int i3 = (i / 3) * 2;
        Object[] objArr = this.f1163b;
        w0 w0Var = (w0) objArr[i3];
        if (w0Var != null) {
            return w0Var;
        }
        w0 w0VarA = t0.f1207c.a((Class) objArr[i3 + 1]);
        objArr[i3] = w0VarA;
        return w0VarA;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final boolean isInitialized(Object obj) {
        int i;
        int i3;
        int i10;
        int[] iArr = this.f1162a;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        while (i13 < this.f1169h) {
            int i14 = this.f1168g[i13];
            int i15 = iArr[i14];
            int iH = H(i14);
            int i16 = iArr[i14 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i11) {
                if (i17 != 1048575) {
                    i12 = f1161o.getInt(obj, i17);
                }
                i3 = i14;
                i10 = i12;
                i = i17;
            } else {
                int i19 = i12;
                i = i11;
                i3 = i14;
                i10 = i19;
            }
            if ((268435456 & iH) == 0 || k(obj, i3, i, i10, i18)) {
                int iG = G(iH);
                if (iG == 9 || iG == 17) {
                    if (k(obj, i3, i, i10, i18)) {
                        if (!i(i3).isInitialized(j1.f1140c.h(obj, iH & 1048575))) {
                        }
                    } else {
                        continue;
                    }
                    i13++;
                    i11 = i;
                    i12 = i10;
                } else {
                    if (iG != 27) {
                        if (iG == 60 || iG == 68) {
                            if (m(obj, i15, i3)) {
                                if (!i(i3).isInitialized(j1.f1140c.h(obj, iH & 1048575))) {
                                }
                            } else {
                                continue;
                            }
                            i13++;
                            i11 = i;
                            i12 = i10;
                        } else if (iG != 49) {
                            if (iG != 50) {
                                continue;
                            } else {
                                j0 j0Var = this.f1173m;
                                Object objH = j1.f1140c.h(obj, iH & 1048575);
                                j0Var.getClass();
                                i0 i0Var = (i0) objH;
                                if (!i0Var.isEmpty() && ((h0) this.f1163b[(i3 / 3) * 2]).f1128a.f1118b.f1191c == s1.MESSAGE) {
                                    w0 w0VarA = null;
                                    for (Object obj2 : i0Var.values()) {
                                        if (w0VarA == null) {
                                            w0VarA = t0.f1207c.a(obj2.getClass());
                                        }
                                        if (!w0VarA.isInitialized(obj2)) {
                                        }
                                    }
                                }
                            }
                            i13++;
                            i11 = i;
                            i12 = i10;
                        }
                    }
                    List list = (List) j1.f1140c.h(obj, iH & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        w0 w0VarI = i(i3);
                        for (int i20 = 0; i20 < list.size(); i20++) {
                            if (w0VarI.isInitialized(list.get(i20))) {
                            }
                        }
                    }
                    i13++;
                    i11 = i;
                    i12 = i10;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean j(Object obj, int i) {
        int i3 = this.f1162a[i + 2];
        long j10 = i3 & 1048575;
        if (j10 == 1048575) {
            int iH = H(i);
            long j11 = iH & 1048575;
            switch (G(iH)) {
                case 0:
                    if (Double.doubleToRawLongBits(j1.f1140c.d(obj, j11)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(j1.f1140c.e(obj, j11)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (j1.f1140c.g(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (j1.f1140c.g(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (j1.f1140c.g(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return j1.f1140c.c(obj, j11);
                case 8:
                    Object objH = j1.f1140c.h(obj, j11);
                    if (objH instanceof String) {
                        return !((String) objH).isEmpty();
                    }
                    if (objH instanceof f) {
                        return !f.f1105g.equals(objH);
                    }
                    od.f.b();
                    return false;
                case 9:
                    if (j1.f1140c.h(obj, j11) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !f.f1105g.equals(j1.f1140c.h(obj, j11));
                case 11:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (j1.f1140c.g(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (j1.f1140c.f(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (j1.f1140c.g(obj, j11) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (j1.f1140c.h(obj, j11) == null) {
                        return false;
                    }
                    break;
                default:
                    od.f.b();
                    return false;
            }
        } else if (((1 << (i3 >>> 20)) & j1.f1140c.f(obj, j10)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean k(Object obj, int i, int i3, int i10, int i11) {
        return i3 == 1048575 ? j(obj, i) : (i10 & i11) != 0;
    }

    public final boolean m(Object obj, int i, int i3) {
        return j1.f1140c.f(obj, (long) (this.f1162a[i3 + 2] & 1048575)) == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void makeImmutable(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.f1162a
            boolean r1 = l(r10)
            if (r1 != 0) goto La
            goto La5
        La:
            boolean r1 = r10 instanceof androidx.datastore.preferences.protobuf.v
            r2 = 0
            if (r1 == 0) goto L1d
            r1 = r10
            androidx.datastore.preferences.protobuf.v r1 = (androidx.datastore.preferences.protobuf.v) r1
            r3 = 2147483647(0x7fffffff, float:NaN)
            r1.l(r3)
            r1.memoizedHashCode = r2
            r1.h()
        L1d:
            int r1 = r0.length
            r3 = r2
        L1f:
            if (r3 >= r1) goto L96
            int r4 = r9.H(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = G(r4)
            r7 = 9
            if (r4 == r7) goto L80
            r7 = 60
            if (r4 == r7) goto L6a
            r7 = 68
            if (r4 == r7) goto L6a
            switch(r4) {
                case 17: goto L80;
                case 18: goto L54;
                case 19: goto L54;
                case 20: goto L54;
                case 21: goto L54;
                case 22: goto L54;
                case 23: goto L54;
                case 24: goto L54;
                case 25: goto L54;
                case 26: goto L54;
                case 27: goto L54;
                case 28: goto L54;
                case 29: goto L54;
                case 30: goto L54;
                case 31: goto L54;
                case 32: goto L54;
                case 33: goto L54;
                case 34: goto L54;
                case 35: goto L54;
                case 36: goto L54;
                case 37: goto L54;
                case 38: goto L54;
                case 39: goto L54;
                case 40: goto L54;
                case 41: goto L54;
                case 42: goto L54;
                case 43: goto L54;
                case 44: goto L54;
                case 45: goto L54;
                case 46: goto L54;
                case 47: goto L54;
                case 48: goto L54;
                case 49: goto L54;
                case 50: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L93
        L3e:
            sun.misc.Unsafe r4 = androidx.datastore.preferences.protobuf.n0.f1161o
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L93
            androidx.datastore.preferences.protobuf.j0 r8 = r9.f1173m
            r8.getClass()
            r8 = r7
            androidx.datastore.preferences.protobuf.i0 r8 = (androidx.datastore.preferences.protobuf.i0) r8
            r8.f1132c = r2
            r4.putObject(r10, r5, r7)
            goto L93
        L54:
            androidx.datastore.preferences.protobuf.c0 r4 = r9.f1171k
            r4.getClass()
            androidx.datastore.preferences.protobuf.i1 r4 = androidx.datastore.preferences.protobuf.j1.f1140c
            java.lang.Object r4 = r4.h(r10, r5)
            androidx.datastore.preferences.protobuf.w r4 = (androidx.datastore.preferences.protobuf.w) r4
            androidx.datastore.preferences.protobuf.u0 r4 = (androidx.datastore.preferences.protobuf.u0) r4
            boolean r5 = r4.f1211c
            if (r5 == 0) goto L93
            r4.f1211c = r2
            goto L93
        L6a:
            r4 = r0[r3]
            boolean r4 = r9.m(r10, r4, r3)
            if (r4 == 0) goto L93
            androidx.datastore.preferences.protobuf.w0 r4 = r9.i(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.n0.f1161o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.makeImmutable(r5)
            goto L93
        L80:
            boolean r4 = r9.j(r10, r3)
            if (r4 == 0) goto L93
            androidx.datastore.preferences.protobuf.w0 r4 = r9.i(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.n0.f1161o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.makeImmutable(r5)
        L93:
            int r3 = r3 + 3
            goto L1f
        L96:
            androidx.datastore.preferences.protobuf.e1 r9 = r9.f1172l
            r9.getClass()
            androidx.datastore.preferences.protobuf.v r10 = (androidx.datastore.preferences.protobuf.v) r10
            androidx.datastore.preferences.protobuf.d1 r9 = r10.unknownFields
            boolean r10 = r9.f1102e
            if (r10 == 0) goto La5
            r9.f1102e = r2
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.makeImmutable(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mergeFrom(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.mergeFrom(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
    
        r9.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        r10.d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.Object r8, int r9, java.lang.Object r10, androidx.datastore.preferences.protobuf.n r11, androidx.datastore.preferences.protobuf.j r12) throws androidx.datastore.preferences.protobuf.y {
        /*
            r7 = this;
            int r9 = r7.H(r9)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r0
            long r0 = (long) r9
            androidx.datastore.preferences.protobuf.i1 r9 = androidx.datastore.preferences.protobuf.j1.f1140c
            java.lang.Object r9 = r9.h(r8, r0)
            androidx.datastore.preferences.protobuf.j0 r7 = r7.f1173m
            if (r9 != 0) goto L20
            r7.getClass()
            androidx.datastore.preferences.protobuf.i0 r9 = androidx.datastore.preferences.protobuf.i0.f1131f
            androidx.datastore.preferences.protobuf.i0 r9 = r9.b()
            androidx.datastore.preferences.protobuf.j1.o(r8, r0, r9)
            goto L37
        L20:
            r7.getClass()
            r2 = r9
            androidx.datastore.preferences.protobuf.i0 r2 = (androidx.datastore.preferences.protobuf.i0) r2
            boolean r2 = r2.f1132c
            if (r2 != 0) goto L37
            androidx.datastore.preferences.protobuf.i0 r2 = androidx.datastore.preferences.protobuf.i0.f1131f
            androidx.datastore.preferences.protobuf.i0 r2 = r2.b()
            androidx.datastore.preferences.protobuf.j0.a(r2, r9)
            androidx.datastore.preferences.protobuf.j1.o(r8, r0, r2)
            r9 = r2
        L37:
            r7.getClass()
            androidx.datastore.preferences.protobuf.i0 r9 = (androidx.datastore.preferences.protobuf.i0) r9
            androidx.datastore.preferences.protobuf.h0 r10 = (androidx.datastore.preferences.protobuf.h0) r10
            androidx.datastore.preferences.protobuf.g0 r7 = r10.f1128a
            r8 = 2
            r12.A(r8)
            java.lang.Object r10 = r12.f1137d
            androidx.datastore.preferences.protobuf.i r10 = (androidx.datastore.preferences.protobuf.i) r10
            int r0 = r10.v()
            int r0 = r10.e(r0)
            r7.getClass()
            x3.i r1 = r7.f1119c
            java.lang.String r2 = ""
            r3 = r1
        L58:
            int r4 = r12.c()     // Catch: java.lang.Throwable -> L7c
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L9e
            boolean r5 = r10.c()     // Catch: java.lang.Throwable -> L7c
            if (r5 == 0) goto L68
            goto L9e
        L68:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L89
            if (r4 == r8) goto L7e
            boolean r4 = r12.B()     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            if (r4 == 0) goto L76
            goto L58
        L76:
            androidx.datastore.preferences.protobuf.z r4 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            throw r4     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
        L7c:
            r7 = move-exception
            goto La5
        L7e:
            androidx.datastore.preferences.protobuf.r1 r4 = r7.f1118b     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            java.lang.Object r3 = r12.m(r4, r5, r11)     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            goto L58
        L89:
            androidx.datastore.preferences.protobuf.r1 r4 = r7.f1117a     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            r5 = 0
            java.lang.Object r2 = r12.m(r4, r5, r5)     // Catch: java.lang.Throwable -> L7c androidx.datastore.preferences.protobuf.y -> L91
            goto L58
        L91:
            boolean r4 = r12.B()     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L98
            goto L58
        L98:
            androidx.datastore.preferences.protobuf.z r7 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L7c
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L7c
            throw r7     // Catch: java.lang.Throwable -> L7c
        L9e:
            r9.put(r2, r3)     // Catch: java.lang.Throwable -> L7c
            r10.d(r0)
            return
        La5:
            r10.d(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.n(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.j):void");
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final v newInstance() {
        p0 p0Var = this.f1170j;
        a aVar = this.f1166e;
        p0Var.getClass();
        return ((v) aVar).j();
    }

    public final void o(Object obj, Object obj2, int i) {
        if (j(obj2, i)) {
            long jH = H(i) & 1048575;
            Unsafe unsafe = f1161o;
            Object object = unsafe.getObject(obj2, jH);
            if (object == null) {
                b8.z.g(this.f1162a[i], obj2);
                return;
            }
            w0 w0VarI = i(i);
            if (!j(obj, i)) {
                if (l(object)) {
                    v vVarNewInstance = w0VarI.newInstance();
                    w0VarI.mergeFrom(vVarNewInstance, object);
                    unsafe.putObject(obj, jH, vVarNewInstance);
                } else {
                    unsafe.putObject(obj, jH, object);
                }
                C(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jH);
            if (!l(object2)) {
                v vVarNewInstance2 = w0VarI.newInstance();
                w0VarI.mergeFrom(vVarNewInstance2, object2);
                unsafe.putObject(obj, jH, vVarNewInstance2);
                object2 = vVarNewInstance2;
            }
            w0VarI.mergeFrom(object2, object);
        }
    }

    public final void p(Object obj, Object obj2, int i) {
        int[] iArr = this.f1162a;
        int i3 = iArr[i];
        if (m(obj2, i3, i)) {
            long jH = H(i) & 1048575;
            Unsafe unsafe = f1161o;
            Object object = unsafe.getObject(obj2, jH);
            if (object == null) {
                b8.z.g(iArr[i], obj2);
                return;
            }
            w0 w0VarI = i(i);
            if (!m(obj, i3, i)) {
                if (l(object)) {
                    v vVarNewInstance = w0VarI.newInstance();
                    w0VarI.mergeFrom(vVarNewInstance, object);
                    unsafe.putObject(obj, jH, vVarNewInstance);
                } else {
                    unsafe.putObject(obj, jH, object);
                }
                D(obj, i3, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jH);
            if (!l(object2)) {
                v vVarNewInstance2 = w0VarI.newInstance();
                w0VarI.mergeFrom(vVarNewInstance2, object2);
                unsafe.putObject(obj, jH, vVarNewInstance2);
                object2 = vVarNewInstance2;
            }
            w0VarI.mergeFrom(object2, object);
        }
    }

    public final Object q(Object obj, int i) {
        w0 w0VarI = i(i);
        long jH = H(i) & 1048575;
        if (!j(obj, i)) {
            return w0VarI.newInstance();
        }
        Object object = f1161o.getObject(obj, jH);
        if (l(object)) {
            return object;
        }
        v vVarNewInstance = w0VarI.newInstance();
        if (object != null) {
            w0VarI.mergeFrom(vVarNewInstance, object);
        }
        return vVarNewInstance;
    }

    public final Object r(Object obj, int i, int i3) {
        w0 w0VarI = i(i3);
        if (!m(obj, i, i3)) {
            return w0VarI.newInstance();
        }
        Object object = f1161o.getObject(obj, H(i3) & 1048575);
        if (l(object)) {
            return object;
        }
        v vVarNewInstance = w0VarI.newInstance();
        if (object != null) {
            w0VarI.mergeFrom(vVarNewInstance, object);
        }
        return vVarNewInstance;
    }

    public final int w(int i) {
        if (i < this.f1164c || i > this.f1165d) {
            return -1;
        }
        int[] iArr = this.f1162a;
        int length = (iArr.length / 3) - 1;
        int i3 = 0;
        while (i3 <= length) {
            int i10 = (length + i3) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i == i12) {
                return i11;
            }
            if (i < i12) {
                length = i10 - 1;
            } else {
                i3 = i10 + 1;
            }
        }
        return -1;
    }

    public final void x(Object obj, long j10, j jVar, w0 w0Var, n nVar) throws y {
        int iU;
        this.f1171k.getClass();
        w wVarA = c0.a(obj, j10);
        i iVar = (i) jVar.f1137d;
        int i = jVar.f1134a;
        if ((i & 7) != 3) {
            throw z.b();
        }
        do {
            v vVarNewInstance = w0Var.newInstance();
            jVar.f(vVarNewInstance, w0Var, nVar);
            w0Var.makeImmutable(vVarNewInstance);
            ((u0) wVarA).add(vVarNewInstance);
            if (iVar.c() || jVar.f1136c != 0) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == i);
        jVar.f1136c = iU;
    }

    public final void y(Object obj, int i, j jVar, w0 w0Var, n nVar) throws z {
        int iU;
        this.f1171k.getClass();
        w wVarA = c0.a(obj, i & 1048575);
        i iVar = (i) jVar.f1137d;
        int i3 = jVar.f1134a;
        if ((i3 & 7) != 2) {
            throw z.b();
        }
        do {
            v vVarNewInstance = w0Var.newInstance();
            jVar.g(vVarNewInstance, w0Var, nVar);
            w0Var.makeImmutable(vVarNewInstance);
            ((u0) wVarA).add(vVarNewInstance);
            if (iVar.c() || jVar.f1136c != 0) {
                return;
            } else {
                iU = iVar.u();
            }
        } while (iU == i3);
        jVar.f1136c = iU;
    }

    public final void z(int i, j jVar, Object obj) throws y {
        if ((536870912 & i) != 0) {
            jVar.A(2);
            j1.o(obj, i & 1048575, ((i) jVar.f1137d).t());
        } else if (!this.f1167f) {
            j1.o(obj, i & 1048575, jVar.i());
        } else {
            jVar.A(2);
            j1.o(obj, i & 1048575, ((i) jVar.f1137d).s());
        }
    }
}
