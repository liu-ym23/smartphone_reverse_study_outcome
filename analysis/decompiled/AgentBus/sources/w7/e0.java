package w7;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import b0.s2;
import com.google.protobuf.y0;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentbus.R;
import f8.q0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import v9.m0;
import v9.p0;
import v9.v0;
import v9.x0;
import z7.m1;
import z7.q1;

/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: b, reason: collision with root package name */
    public static i5.f f10865b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10866a;

    public /* synthetic */ e0(int i2) {
        this.f10866a = i2;
    }

    public static final Object A(f9.l lVar, f9.n nVar) {
        q7.k.e(lVar, "<this>");
        q7.k.e(nVar, "extension");
        if (lVar.j(nVar)) {
            return lVar.i(nVar);
        }
        return null;
    }

    public static final Object B(f9.l lVar, f9.n nVar, int i2) {
        q7.k.e(lVar, "<this>");
        q7.k.e(nVar, "extension");
        lVar.m(nVar);
        f9.i iVar = lVar.f3568f;
        f9.m mVar = nVar.f3583d;
        iVar.getClass();
        f9.a0 a0Var = iVar.f3563a;
        if (!mVar.f3571h) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = a0Var.get(mVar);
        if (i2 >= (obj == null ? 0 : ((List) obj).size())) {
            return null;
        }
        lVar.m(nVar);
        if (!mVar.f3571h) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj2 = a0Var.get(mVar);
        if (obj2 != null) {
            return nVar.a(((List) obj2).get(i2));
        }
        throw new IndexOutOfBoundsException();
    }

    public static final Type C(u uVar) {
        q7.k.e(uVar, "<this>");
        if (uVar instanceof q7.l) {
            q1 q1Var = ((m1) ((q7.l) uVar)).f11909g;
            Type type = q1Var != null ? (Type) q1Var.c() : null;
            if (type != null) {
                return type;
            }
        }
        return j(uVar, false);
    }

    public static final Type D(x xVar) {
        y yVar = xVar.f10875a;
        if (yVar == null) {
            return f0.f10867h;
        }
        u uVar = xVar.f10876b;
        q7.k.b(uVar);
        int i2 = c0.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i2 == 1) {
            return new f0(null, j(uVar, true));
        }
        if (i2 == 2) {
            return j(uVar, true);
        }
        if (i2 == 3) {
            return new f0(j(uVar, true), null);
        }
        throw new a4.u();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String E(android.content.Context r12) throws java.lang.Throwable {
        /*
            a7.g r0 = a7.g.d()
            android.content.Context r12 = r12.getApplicationContext()
            java.lang.Object r1 = r0.f419h
            a7.a r1 = (a7.a) r1
            r2 = 0
            if (r1 != 0) goto L10
            goto L26
        L10:
            long r3 = r1.f399a
            long r5 = java.lang.System.currentTimeMillis()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L1f
            java.lang.Object r12 = r1.f400b
            java.lang.String r12 = (java.lang.String) r12
            return r12
        L1f:
            r3 = 1
            boolean r4 = r0.h(r12, r3)
            if (r4 != 0) goto L27
        L26:
            return r2
        L27:
            a7.c r4 = r0.a(r12)
            if (r4 == 0) goto Lac
            boolean r5 = r4.f408b
            if (r5 == 0) goto Lac
            if (r5 == 0) goto L3d
            java.lang.Object r5 = r4.f409c     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            a7.b r5 = (a7.b) r5     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r5 = r5.f404b     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            goto L3e
        L3a:
            r8 = r2
            goto L9d
        L3d:
            r5 = r2
        L3e:
            android.net.Uri r7 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.Object r5 = r1.f401c     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String[] r10 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r11 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r5 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r6 = 0
            if (r5 == 0) goto L88
            a7.e r7 = a7.g.c(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            java.lang.Object r8 = r7.f415d     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            r1.f400b = r8     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            long r9 = r7.f414c     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r1.f399a = r9     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            int r1 = r7.f413b     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 == r2) goto L81
            r0.f(r12, r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r1 = r0.h(r12, r6)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r1 != 0) goto L81
            r0.h(r12, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            goto L81
        L79:
            r0 = move-exception
            r12 = r0
            r2 = r5
            goto La6
        L7d:
            r0 = move-exception
            r12 = r0
        L7f:
            r2 = r5
            goto L9d
        L81:
            r2 = r8
            goto L91
        L83:
            r8 = r2
            goto L7f
        L85:
            r0 = move-exception
            r12 = r0
            goto L83
        L88:
            boolean r1 = r0.h(r12, r6)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            if (r1 == 0) goto L91
            r0.h(r12, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
        L91:
            if (r5 == 0) goto L96
            r5.close()
        L96:
            return r2
        L97:
            r0 = move-exception
            r12 = r0
            goto La6
        L9a:
            r0 = move-exception
            r12 = r0
            goto L3a
        L9d:
            r12.getMessage()     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto La5
            r2.close()
        La5:
            return r8
        La6:
            if (r2 == 0) goto Lab
            r2.close()
        Lab:
            throw r12
        Lac:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.E(android.content.Context):java.lang.String");
    }

    public static final boolean F(int i2, String str) {
        char cCharAt = str.charAt(i2);
        return 'A' <= cCharAt && cCharAt < '[';
    }

    public static final boolean I(String str) {
        q7.k.e(str, "method");
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final void J(s2 s2Var, b0.c cVar, int i2) {
        while (true) {
            int i10 = s2Var.f1367v;
            if (i2 > i10 && i2 < s2Var.f1366u) {
                return;
            }
            if (i10 == 0 && i2 == 0) {
                return;
            }
            s2Var.J();
            if (s2Var.w(s2Var.f1367v)) {
                cVar.j();
            }
            s2Var.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final v9.v K(v9.v r9, java.util.ArrayList r10) {
        /*
            java.util.List r0 = r9.C0()
            r0.size()
            r10.size()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = d7.t.A0(r10, r1)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        L19:
            boolean r1 = r10.hasNext()
            r2 = 0
            if (r1 == 0) goto L96
            java.lang.Object r1 = r10.next()
            aa.d r1 = (aa.d) r1
            r1.getClass()
            v9.v r3 = r1.f485c
            v9.v r4 = r1.f484b
            f8.q0 r1 = r1.f483a
            w9.m r5 = w9.e.f10930a
            r5.b(r4, r3)
            boolean r5 = q7.k.a(r4, r3)
            if (r5 != 0) goto L8d
            int r5 = r1.a0()
            r6 = 2
            if (r5 != r6) goto L42
            goto L8d
        L42:
            boolean r5 = c8.h.E(r4)
            r7 = 1
            r8 = 3
            if (r5 == 0) goto L5e
            int r5 = r1.a0()
            if (r5 == r6) goto L5e
            v9.q0 r2 = new v9.q0
            int r1 = r1.a0()
            if (r8 != r1) goto L59
            goto L5a
        L59:
            r7 = r8
        L5a:
            r2.<init>(r7, r3)
            goto L92
        L5e:
            if (r3 == 0) goto L87
            boolean r2 = c8.h.x(r3)
            if (r2 == 0) goto L79
            boolean r2 = r3.F0()
            if (r2 == 0) goto L79
            v9.q0 r2 = new v9.q0
            int r1 = r1.a0()
            if (r6 != r1) goto L75
            r6 = r7
        L75:
            r2.<init>(r6, r4)
            goto L92
        L79:
            v9.q0 r2 = new v9.q0
            int r1 = r1.a0()
            if (r8 != r1) goto L82
            goto L83
        L82:
            r7 = r8
        L83:
            r2.<init>(r7, r3)
            goto L92
        L87:
            r9 = 140(0x8c, float:1.96E-43)
            c8.h.a(r9)
            throw r2
        L8d:
            v9.q0 r2 = new v9.q0
            r2.<init>(r4)
        L92:
            r0.add(r2)
            goto L19
        L96:
            r10 = 6
            v9.v r9 = v9.c.o(r9, r0, r2, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.K(v9.v, java.util.ArrayList):v9.v");
    }

    public static String L(byte[] bArr) {
        Object objN;
        Map metaMap;
        try {
            l4.k kVarS = l4.k.s(bArr);
            l4.g head = kVarS.getHead();
            com.google.protobuf.l body = kVarS.getBody();
            int size = body != null ? body.size() : 0;
            String str = (head == null || (metaMap = head.getMetaMap()) == null) ? null : (String) metaMap.get(OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME);
            String str2 = "";
            if (str == null) {
                str = "";
            }
            StringBuilder sb2 = new StringBuilder("bytes=");
            sb2.append(bArr.length);
            sb2.append(" module=");
            String module = head != null ? head.getModule() : null;
            if (module == null) {
                module = "";
            }
            sb2.append(module);
            sb2.append(" cmd=");
            String command = head != null ? head.getCommand() : null;
            if (command == null) {
                command = "";
            }
            sb2.append(command);
            sb2.append(" msgId=");
            String msgId = head != null ? head.getMsgId() : null;
            if (msgId != null) {
                str2 = msgId;
            }
            sb2.append(str2);
            sb2.append(" pkg=");
            sb2.append(str);
            sb2.append(" bodyLen=");
            sb2.append(size);
            objN = sb2.toString();
        } catch (Throwable th) {
            objN = n(th);
        }
        if (c7.m.a(objN) != null) {
            objN = a1.a.f(bArr.length, "bytes=", " invalidStreamMsg");
        }
        return (String) objN;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final e9.c M(e9.c r3, e9.c r4) {
        /*
            java.lang.String r0 = "<this>"
            q7.k.e(r3, r0)
            java.lang.String r0 = "prefix"
            q7.k.e(r4, r0)
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L11
            goto L33
        L11:
            boolean r0 = r4.d()
            if (r0 == 0) goto L18
            goto L33
        L18:
            java.lang.String r0 = r3.b()
            java.lang.String r1 = r4.b()
            r2 = 0
            boolean r2 = ga.r.g0(r0, r1, r2)
            if (r2 == 0) goto L65
            int r1 = r1.length()
            char r0 = r0.charAt(r1)
            r1 = 46
            if (r0 != r1) goto L65
        L33:
            boolean r0 = r4.d()
            if (r0 == 0) goto L3a
            goto L65
        L3a:
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L48
            e9.c r3 = e9.c.f3187c
            java.lang.String r4 = "ROOT"
            q7.k.d(r3, r4)
            return r3
        L48:
            e9.c r0 = new e9.c
            java.lang.String r3 = r3.b()
            java.lang.String r4 = r4.b()
            int r4 = r4.length()
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)
            java.lang.String r4 = "this as java.lang.String).substring(startIndex)"
            q7.k.d(r3, r4)
            r0.<init>(r3)
            return r0
        L65:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.M(e9.c, e9.c):e9.c");
    }

    public static final void N(Object obj) {
        if (obj instanceof c7.l) {
            throw ((c7.l) obj).f1975f;
        }
    }

    public static final String O(String str) {
        q7.k.e(str, "<this>");
        StringBuilder sb2 = new StringBuilder(str.length());
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb2.append(cCharAt);
        }
        String string = sb2.toString();
        q7.k.d(string, "builder.toString()");
        return string;
    }

    public static final void P(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        if (i2 < 0 || byteBuffer2.remaining() < i2 || byteBuffer3.remaining() < i2 || byteBuffer.remaining() < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i10 = 0; i10 < i2; i10++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] Q(int i2, int i10, int i11, byte[] bArr, byte[] bArr2) {
        if (i11 < 0 || bArr.length - i11 < i2 || bArr2.length - i11 < i10) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr3[i12] = (byte) (bArr[i12 + i2] ^ bArr2[i12 + i10]);
        }
        return bArr3;
    }

    public static final byte[] R(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return Q(0, 0, bArr.length, bArr, bArr2);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final long a(float f10, float f11) {
        return (Float.floatToRawIntBits(f11) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32);
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.stepos.pushservice", 0).getLongVersionCode();
        } catch (Exception e10) {
            j6.a.c("AppUtils", "getAppVersionCode error: " + e10.getMessage());
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float c(g1.r r6, boolean r7, g1.h[] r8, float r9) {
        /*
            int r0 = r8.length
            r1 = 2143289344(0x7fc00000, float:NaN)
            r2 = 0
            r3 = r2
        L5:
            if (r3 >= r0) goto L20
            r4 = r8[r3]
            float r4 = r6.b(r4)
            boolean r5 = java.lang.Float.isNaN(r1)
            if (r5 != 0) goto L1c
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L19
            r5 = 1
            goto L1a
        L19:
            r5 = r2
        L1a:
            if (r7 != r5) goto L1d
        L1c:
            r1 = r4
        L1d:
            int r3 = r3 + 1
            goto L5
        L20:
            boolean r6 = java.lang.Float.isNaN(r1)
            if (r6 == 0) goto L27
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.c(g1.r, boolean, g1.h[], float):float");
    }

    public static final String d(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            return cls.getName();
        }
        fa.j jVarS0 = fa.l.s0(type, d0.f10864n);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = jVarS0.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        sb2.append(((Class) next).getName());
        sb2.append(ga.r.c0(fa.l.p0(jVarS0), "[]"));
        return sb2.toString();
    }

    public static final aa.a e(v9.v vVar) {
        aa.d dVar;
        q7.k.e(vVar, "type");
        if (v9.c.j(vVar)) {
            aa.a aVarE = e(v9.c.k(vVar));
            aa.a aVarE2 = e(v9.c.x(vVar));
            return new aa.a(v9.c.g(v9.d.j(v9.c.k((v9.v) aVarE.f480a), v9.c.x((v9.v) aVarE2.f480a)), vVar), v9.c.g(v9.d.j(v9.c.k((v9.v) aVarE.f481b), v9.c.x((v9.v) aVarE2.f481b)), vVar));
        }
        m0 m0VarE0 = vVar.E0();
        boolean z4 = true;
        if (vVar.E0() instanceof i9.b) {
            q7.k.c(m0VarE0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            p0 p0VarB = ((i9.b) m0VarE0).b();
            v9.v vVarB = p0VarB.b();
            q7.k.d(vVarB, "typeProjection.type");
            v9.v vVarH = x0.h(vVarB, vVar.F0());
            int iD = n.f.d(p0VarB.a());
            if (iD == 1) {
                v9.z zVarO = n7.m.r(vVar).o();
                q7.k.d(zVarO, "type.builtIns.nullableAnyType");
                return new aa.a(vVarH, zVarO);
            }
            if (iD == 2) {
                return new aa.a(x0.h(n7.m.r(vVar).n(), vVar.F0()), vVarH);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + p0VarB);
        }
        if (vVar.C0().isEmpty() || vVar.C0().size() != m0VarE0.getParameters().size()) {
            return new aa.a(vVar, vVar);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listC0 = vVar.C0();
        List parameters = m0VarE0.getParameters();
        q7.k.d(parameters, "typeConstructor.parameters");
        Iterator it = d7.r.s1(listC0, parameters).iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            p0 p0Var = (p0) jVar.f1973f;
            q0 q0Var = (q0) jVar.f1974g;
            q7.k.d(q0Var, "typeParameter");
            int iA0 = q0Var.a0();
            if (iA0 == 0) {
                v0.a(35);
                throw null;
            }
            if (p0Var == null) {
                v0.a(36);
                throw null;
            }
            v0 v0Var = v0.f10595b;
            int iD2 = n.f.d(p0Var.c() ? 3 : v0.b(iA0, p0Var.a()));
            if (iD2 == 0) {
                v9.v vVarB2 = p0Var.b();
                q7.k.d(vVarB2, "type");
                v9.v vVarB3 = p0Var.b();
                q7.k.d(vVarB3, "type");
                dVar = new aa.d(q0Var, vVarB2, vVarB3);
            } else if (iD2 == 1) {
                v9.v vVarB4 = p0Var.b();
                q7.k.d(vVarB4, "type");
                v9.z zVarO2 = l9.d.e(q0Var).o();
                q7.k.d(zVarO2, "typeParameter.builtIns.nullableAnyType");
                dVar = new aa.d(q0Var, vVarB4, zVarO2);
            } else {
                if (iD2 != 2) {
                    throw new a4.u();
                }
                v9.z zVarN = l9.d.e(q0Var).n();
                v9.v vVarB5 = p0Var.b();
                q7.k.d(vVarB5, "type");
                dVar = new aa.d(q0Var, zVarN, vVarB5);
            }
            if (p0Var.c()) {
                arrayList.add(dVar);
                arrayList2.add(dVar);
            } else {
                aa.a aVarE3 = e(dVar.f484b);
                v9.v vVar2 = (v9.v) aVarE3.f480a;
                v9.v vVar3 = (v9.v) aVarE3.f481b;
                aa.a aVarE4 = e(dVar.f485c);
                v9.v vVar4 = (v9.v) aVarE4.f480a;
                v9.v vVar5 = (v9.v) aVarE4.f481b;
                q0 q0Var2 = dVar.f483a;
                aa.d dVar2 = new aa.d(q0Var2, vVar3, vVar4);
                aa.d dVar3 = new aa.d(q0Var2, vVar2, vVar5);
                arrayList.add(dVar2);
                arrayList2.add(dVar3);
            }
        }
        if (arrayList.isEmpty()) {
            z4 = false;
        } else {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                aa.d dVar4 = (aa.d) it2.next();
                dVar4.getClass();
                if (!w9.e.f10930a.b(dVar4.f484b, dVar4.f485c)) {
                    break;
                }
            }
            z4 = false;
        }
        return new aa.a(z4 ? n7.m.r(vVar).n() : K(vVar, arrayList), K(vVar, arrayList2));
    }

    public static final String g(String str) {
        char cCharAt;
        q7.k.e(str, "<this>");
        if (str.length() == 0 || 'a' > (cCharAt = str.charAt(0)) || cCharAt >= '{') {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        return upperCase + strSubstring;
    }

    public static final g8.j i(g8.j jVar, g8.j jVar2) {
        q7.k.e(jVar, "first");
        q7.k.e(jVar2, "second");
        return jVar.isEmpty() ? jVar2 : jVar2.isEmpty() ? jVar : new g8.k(new g8.j[]{jVar, jVar2});
    }

    public static final Type j(u uVar, boolean z4) {
        e eVarQ = uVar.q();
        if (eVarQ instanceof v) {
            return new b0((v) eVarQ);
        }
        if (!(eVarQ instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + uVar);
        }
        d dVar = (d) eVarQ;
        Class clsU = z4 ? nb.i.u(dVar) : nb.i.t(dVar);
        List listK = uVar.k();
        if (listK.isEmpty()) {
            return clsU;
        }
        if (!clsU.isArray()) {
            return o(clsU, listK);
        }
        if (clsU.getComponentType().isPrimitive()) {
            return clsU;
        }
        x xVar = (x) d7.r.h1(listK);
        if (xVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + uVar);
        }
        y yVar = xVar.f10875a;
        u uVar2 = xVar.f10876b;
        int i2 = yVar == null ? -1 : c0.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i2 == -1 || i2 == 1) {
            return clsU;
        }
        if (i2 != 2 && i2 != 3) {
            throw new a4.u();
        }
        q7.k.b(uVar2);
        Type typeJ = j(uVar2, false);
        return typeJ instanceof Class ? clsU : new a(typeJ);
    }

    public static byte[] k(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length > Integer.MAX_VALUE - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final void l(int i2, int i10) {
        if (i2 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i10 + ").");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k8.c m(java.lang.Class r14) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.m(java.lang.Class):k8.c");
    }

    public static final c7.l n(Throwable th) {
        q7.k.e(th, "exception");
        return new c7.l(th);
    }

    public static final a0 o(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(D((x) it.next()));
            }
            return new a0(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(D((x) it2.next()));
            }
            return new a0(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        a0 a0VarO = o(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(d7.t.A0(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(D((x) it3.next()));
        }
        return new a0(cls, a0VarO, arrayList3);
    }

    public static androidx.lifecycle.p0 p(Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "));
            }
            try {
                Object objNewInstance = declaredConstructor.newInstance(null);
                q7.k.b(objNewInstance);
                return (androidx.lifecycle.p0) objNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e11);
            }
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException(a1.a.g(cls, "Cannot create an instance of "), e12);
        }
    }

    public static final j7.b s(Enum[] enumArr) {
        q7.k.e(enumArr, "entries");
        return new j7.b(enumArr);
    }

    public static long t(int i2, int i10, int i11, int i12) {
        int i13 = 262142;
        int iMin = Math.min(i11, 262142);
        int iMin2 = i12 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i12, 262142);
        int i14 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i14 >= 8191) {
            if (i14 < 32767) {
                i13 = 65534;
            } else if (i14 < 65535) {
                i13 = 32766;
            } else {
                if (i14 >= 262143) {
                    d2.b.j(i14);
                    throw new a4.u();
                }
                i13 = 8190;
            }
        }
        return d2.b.a(Math.min(i13, i2), i10 != Integer.MAX_VALUE ? Math.min(i13, i10) : Integer.MAX_VALUE, iMin, iMin2);
    }

    public static long u(int i2, int i10, int i11, int i12) {
        int i13 = 262142;
        int iMin = Math.min(i2, 262142);
        int iMin2 = i10 == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(i10, 262142);
        int i14 = iMin2 == Integer.MAX_VALUE ? iMin : iMin2;
        if (i14 >= 8191) {
            if (i14 < 32767) {
                i13 = 65534;
            } else if (i14 < 65535) {
                i13 = 32766;
            } else {
                if (i14 >= 262143) {
                    d2.b.j(i14);
                    throw new a4.u();
                }
                i13 = 8190;
            }
        }
        return d2.b.a(iMin, iMin2, Math.min(i13, i11), i12 != Integer.MAX_VALUE ? Math.min(i13, i12) : Integer.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        if (((r2 * 100) / r5.length) >= 85) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String v(byte[] r5) {
        /*
            int r0 = r5.length
            if (r0 != 0) goto L6
            java.lang.String r5 = "empty"
            return r5
        L6:
            int r0 = r5.length
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 > r1) goto L5b
            int r0 = r5.length
            if (r0 != 0) goto Lf
            goto L39
        Lf:
            int r0 = r5.length
            r1 = 0
            r2 = r1
        L12:
            if (r1 >= r0) goto L31
            r3 = r5[r1]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 10
            if (r3 == r4) goto L2c
            r4 = 13
            if (r3 == r4) goto L2c
            r4 = 9
            if (r3 == r4) goto L2c
            r4 = 32
            if (r4 > r3) goto L2e
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 >= r4) goto L2e
        L2c:
            int r2 = r2 + 1
        L2e:
            int r1 = r1 + 1
            goto L12
        L31:
            int r2 = r2 * 100
            int r0 = r5.length
            int r2 = r2 / r0
            r0 = 85
            if (r2 < r0) goto L5b
        L39:
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = ga.a.f4005a
            r0.<init>(r5, r1)
            java.lang.String r5 = "\\"
            java.lang.String r1 = "\\\\"
            java.lang.String r5 = ga.r.e0(r0, r5, r1)
            java.lang.String r0 = "\\\""
            java.lang.String r1 = "\""
            java.lang.String r5 = ga.r.e0(r5, r1, r0)
            java.lang.String r5 = a1.a.j(r1, r5, r1)
            java.lang.String r0 = "utf8="
            java.lang.String r5 = a1.a.w(r0, r5)
            return r5
        L5b:
            r0 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r5, r0)
            int r1 = r0.length()
            java.lang.String r2 = ", b64="
            java.lang.String r3 = "bytes="
            r4 = 1500(0x5dc, float:2.102E-42)
            if (r1 > r4) goto L80
            int r5 = r5.length
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r5)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            return r5
        L80:
            int r5 = r5.length
            java.lang.String r0 = ga.k.L0(r4, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r5)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r5 = "…(truncated)"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.e0.v(byte[]):java.lang.String");
    }

    public static String w(l4.g gVar) {
        if (gVar == null) {
            return "head=null";
        }
        StringBuilder sb2 = new StringBuilder("head={frameType=");
        sb2.append(gVar.getFrameType());
        sb2.append(", msgType=");
        sb2.append(gVar.getMsgType());
        sb2.append(", msgId=");
        sb2.append(gVar.getMsgId());
        sb2.append(", module=");
        sb2.append(gVar.getModule());
        sb2.append(", command=");
        sb2.append(gVar.getCommand());
        if (gVar.getMetaCount() > 0) {
            sb2.append(", meta={");
            sb2.append(d7.r.U0(gVar.getMetaMap().entrySet(), ", ", null, null, new c6.d(20), 30));
            sb2.append("}");
        }
        sb2.append("}");
        return sb2.toString();
    }

    public static ab.r x(String str) {
        q7.k.e(str, "<this>");
        Matcher matcher = ab.r.f597c.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(a1.a.e('\"', "No subtype found for: \"", str).toString());
        }
        String strGroup = matcher.group(1);
        q7.k.d(strGroup, "typeSubtype.group(1)");
        Locale locale = Locale.US;
        q7.k.d(locale, "US");
        q7.k.d(strGroup.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        q7.k.d(strGroup2, "typeSubtype.group(2)");
        q7.k.d(strGroup2.toLowerCase(locale), "this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = ab.r.f598d.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb2 = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring);
                sb2.append("\" for: \"");
                throw new IllegalArgumentException(a1.a.l(sb2, str, '\"').toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (ga.r.g0(strGroup4, "'", false) && ga.r.Z(strGroup4, "'", false) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    q7.k.d(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new ab.r(str, (String[]) arrayList.toArray(new String[0]));
    }

    public static final i3.e y(View view) {
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            i3.e eVar = tag instanceof i3.e ? (i3.e) tag : null;
            if (eVar != null) {
                return eVar;
            }
            Object objO = n7.o.o(view);
            view = objO instanceof View ? (View) objO : null;
        }
        return null;
    }

    public static final int z(Cursor cursor, String str) {
        String strO0;
        q7.k.e(cursor, "c");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            q7.k.d(columnNames, "c.columnNames");
            strO0 = d7.n.o0(columnNames, null, null, null, null, 63);
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            strO0 = "unknown";
        }
        throw new IllegalArgumentException(a1.a.k("column '", str, "' does not exist. Available columns: ", strO0));
    }

    public boolean G(byte[] bArr, int i2, int i10) {
        return H(bArr, i2, i10) == 0;
    }

    public abstract int H(byte[] bArr, int i2, int i10);

    public abstract String f();

    public abstract List h(String str, List list);

    public abstract String q(byte[] bArr, int i2, int i10);

    public abstract int r(int i2, int i10, String str, byte[] bArr);

    public String toString() {
        switch (this.f10866a) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return f();
            default:
                return super.toString();
        }
    }
}
