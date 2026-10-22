package a;

import a7.e;
import ab.u;
import ab.x;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import b0.b2;
import b0.c2;
import b0.d0;
import b0.p;
import b0.z1;
import c0.i0;
import com.google.crypto.tink.shaded.protobuf.a1;
import com.google.crypto.tink.shaded.protobuf.b0;
import com.google.crypto.tink.shaded.protobuf.d1;
import com.google.crypto.tink.shaded.protobuf.h;
import com.google.crypto.tink.shaded.protobuf.p1;
import com.google.crypto.tink.shaded.protobuf.w;
import com.google.crypto.tink.shaded.protobuf.y;
import com.google.crypto.tink.shaded.protobuf.z;
import com.google.protobuf.c4;
import com.google.protobuf.g;
import com.google.protobuf.g3;
import com.google.protobuf.j2;
import com.google.protobuf.l;
import com.google.protobuf.o2;
import com.google.protobuf.r2;
import com.google.protobuf.t3;
import com.stepos.agentbus.R;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase;
import d7.t;
import e.b;
import e9.c;
import ea.f;
import fi.iki.elonen.NanoHTTPD;
import ga.r;
import j1.q0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import ka.q;
import l8.d;
import n0.j;
import n7.o;
import nb.i;
import o9.m;
import o9.n;
import q7.k;
import v9.s;
import v9.s0;
import z8.f0;
import z8.p0;
import z8.x0;

/* loaded from: classes.dex */
public abstract class a {
    public static int A(int i2, byte[] bArr, int i10, int i11, c4 c4Var, g gVar) throws r2 {
        if ((i2 >>> 3) == 0) {
            throw r2.a();
        }
        int i12 = i2 & 7;
        if (i12 == 0) {
            int I = I(bArr, i10, gVar);
            c4Var.d(i2, Long.valueOf(gVar.f2355b));
            return I;
        }
        if (i12 == 1) {
            c4Var.d(i2, Long.valueOf(u(i10, bArr)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int iE = E(bArr, i10, gVar);
            int i13 = gVar.f2354a;
            if (i13 < 0) {
                throw r2.e();
            }
            if (i13 > bArr.length - iE) {
                throw r2.g();
            }
            if (i13 == 0) {
                c4Var.d(i2, l.f2424g);
            } else {
                c4Var.d(i2, l.h(bArr, iE, i13));
            }
            return iE + i13;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw r2.a();
            }
            c4Var.d(i2, Integer.valueOf(s(i10, bArr)));
            return i10 + 4;
        }
        c4 c4VarC = c4.c();
        int i14 = (i2 & (-8)) | 4;
        int i15 = gVar.f2358e + 1;
        gVar.f2358e = i15;
        if (i15 >= 100) {
            throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i16 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int iE2 = E(bArr, i10, gVar);
            i16 = gVar.f2354a;
            if (i16 == i14) {
                i10 = iE2;
                break;
            }
            i10 = A(i16, bArr, iE2, i11, c4VarC, gVar);
        }
        gVar.f2358e--;
        if (i10 > i11 || i16 != i14) {
            throw r2.f();
        }
        c4Var.d(i2, c4VarC);
        return i10;
    }

    public static int B(int i2, byte[] bArr, int i10, e eVar) {
        int i11 = i2 & 127;
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            eVar.f413b = i11 | (b10 << 7);
            return i12;
        }
        int i13 = i11 | ((b10 & 127) << 7);
        int i14 = i10 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            eVar.f413b = i13 | (b11 << 14);
            return i14;
        }
        int i15 = i13 | ((b11 & 127) << 14);
        int i16 = i10 + 3;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            eVar.f413b = i15 | (b12 << 21);
            return i16;
        }
        int i17 = i15 | ((b12 & 127) << 21);
        int i18 = i10 + 4;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            eVar.f413b = i17 | (b13 << 28);
            return i18;
        }
        int i19 = i17 | ((b13 & 127) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                eVar.f413b = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int C(int i2, byte[] bArr, int i10, g gVar) {
        int i11 = i2 & 127;
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            gVar.f2354a = i11 | (b10 << 7);
            return i12;
        }
        int i13 = i11 | ((b10 & 127) << 7);
        int i14 = i10 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            gVar.f2354a = i13 | (b11 << 14);
            return i14;
        }
        int i15 = i13 | ((b11 & 127) << 14);
        int i16 = i10 + 3;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            gVar.f2354a = i15 | (b12 << 21);
            return i16;
        }
        int i17 = i15 | ((b12 & 127) << 21);
        int i18 = i10 + 4;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            gVar.f2354a = i17 | (b13 << 28);
            return i18;
        }
        int i19 = i17 | ((b13 & 127) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                gVar.f2354a = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int D(byte[] bArr, int i2, e eVar) {
        int i10 = i2 + 1;
        byte b10 = bArr[i2];
        if (b10 < 0) {
            return B(b10, bArr, i10, eVar);
        }
        eVar.f413b = b10;
        return i10;
    }

    public static int E(byte[] bArr, int i2, g gVar) {
        int i10 = i2 + 1;
        byte b10 = bArr[i2];
        if (b10 < 0) {
            return C(b10, bArr, i10, gVar);
        }
        gVar.f2354a = b10;
        return i10;
    }

    public static int F(int i2, byte[] bArr, int i10, int i11, y yVar, e eVar) {
        w wVar = (w) yVar;
        int iD = D(bArr, i10, eVar);
        wVar.addInt(eVar.f413b);
        while (iD < i11) {
            int iD2 = D(bArr, iD, eVar);
            if (i2 != eVar.f413b) {
                break;
            }
            iD = D(bArr, iD2, eVar);
            wVar.addInt(eVar.f413b);
        }
        return iD;
    }

    public static int G(int i2, byte[] bArr, int i10, int i11, o2 o2Var, g gVar) {
        j2 j2Var = (j2) o2Var;
        int iE = E(bArr, i10, gVar);
        j2Var.addInt(gVar.f2354a);
        while (iE < i11) {
            int iE2 = E(bArr, iE, gVar);
            if (i2 != gVar.f2354a) {
                break;
            }
            iE = E(bArr, iE2, gVar);
            j2Var.addInt(gVar.f2354a);
        }
        return iE;
    }

    public static int H(byte[] bArr, int i2, e eVar) {
        int i10 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            eVar.f414c = j2;
            return i10;
        }
        int i11 = i2 + 2;
        byte b10 = bArr[i10];
        long j4 = (j2 & 127) | ((b10 & 127) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            i12 += 7;
            j4 |= (r10 & 127) << i12;
            b10 = bArr[i11];
            i11 = i13;
        }
        eVar.f414c = j4;
        return i11;
    }

    public static int I(byte[] bArr, int i2, g gVar) {
        int i10 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            gVar.f2355b = j2;
            return i10;
        }
        int i11 = i2 + 2;
        byte b10 = bArr[i10];
        long j4 = (j2 & 127) | ((b10 & 127) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            i12 += 7;
            j4 |= (r10 & 127) << i12;
            b10 = bArr[i11];
            i11 = i13;
        }
        gVar.f2355b = j4;
        return i11;
    }

    public static String J(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i2 = b10 & 255;
            sb2.append("0123456789abcdef".charAt(i2 / 16));
            sb2.append("0123456789abcdef".charAt(i2 % 16));
        }
        return sb2.toString();
    }

    public static final boolean K(long j2, long j4) {
        return j2 == j4;
    }

    public static void L(File file, File file2) throws IOException {
        if (file2.exists()) {
            n7.l.K(file2);
        }
        file2.mkdirs();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file), NanoHTTPD.HTTPSession.BUFSIZE));
        try {
            String canonicalPath = file2.getCanonicalPath();
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                String name = nextEntry.getName();
                k.d(name, "getName(...)");
                File fileO = n7.l.O(file2, name);
                String canonicalPath2 = fileO.getCanonicalPath();
                k.b(canonicalPath2);
                k.b(canonicalPath);
                if (!r.g0(canonicalPath2, canonicalPath, false)) {
                    throw new IllegalStateException(("zip-slip detected: " + nextEntry.getName()).toString());
                }
                if (nextEntry.isDirectory()) {
                    fileO.mkdirs();
                } else {
                    File parentFile = fileO.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(fileO);
                    try {
                        n7.a.f(zipInputStream, fileOutputStream);
                        fileOutputStream.close();
                    } finally {
                    }
                }
                zipInputStream.closeEntry();
            }
            zipInputStream.close();
        } finally {
        }
    }

    public static final l8.e M(Annotation[] annotationArr, c cVar) {
        Annotation annotation;
        k.e(annotationArr, "<this>");
        k.e(cVar, "fqName");
        int length = annotationArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i2];
            if (d.a(i.t(i.p(annotation))).b().equals(cVar)) {
                break;
            }
            i2++;
        }
        if (annotation != null) {
            return new l8.e(annotation);
        }
        return null;
    }

    public static final String N(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    public static u O(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return u.HTTP_1_0;
        }
        if (str.equals("http/1.1")) {
            return u.HTTP_1_1;
        }
        if (str.equals("h2_prior_knowledge")) {
            return u.H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals("h2")) {
            return u.HTTP_2;
        }
        if (str.equals("spdy/3.1")) {
            return u.SPDY_3;
        }
        if (str.equals("quic")) {
            return u.QUIC;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public static final ArrayList P(Annotation[] annotationArr) {
        k.e(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new l8.e(annotation));
        }
        return arrayList;
    }

    public static final int Q(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? 0 : 1;
        }
        return 2;
    }

    public static final int R(int i2, int i10) {
        return (i2 >> i10) & 31;
    }

    public static List S(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        k.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final f T(ArrayList arrayList) {
        f fVar = new f();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            n nVar = (n) next;
            if (nVar != null && nVar != m.f7933b) {
                fVar.add(next);
            }
        }
        return fVar;
    }

    public static final n0.m U(p pVar, n0.m mVar) {
        if (mVar.b(n0.i.f6795g)) {
            return mVar;
        }
        pVar.P(1219399079, null, 0, null);
        n0.m mVar2 = (n0.m) mVar.a(j.f6796a, new j1.a(3, pVar));
        pVar.q(false);
        return mVar2;
    }

    public static final n0.m V(p pVar, n0.m mVar) {
        pVar.S(439770924);
        n0.m mVarU = U(pVar, mVar);
        pVar.q(false);
        return mVarU;
    }

    public static int W(Object obj, t3 t3Var, byte[] bArr, int i2, int i10, int i11, g gVar) throws r2 {
        g3 g3Var = (g3) t3Var;
        int i12 = gVar.f2358e + 1;
        gVar.f2358e = i12;
        if (i12 >= 100) {
            throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iG = g3Var.G(obj, bArr, i2, i10, i11, gVar);
        gVar.f2358e--;
        gVar.f2356c = obj;
        return iG;
    }

    public static int X(Object obj, a1 a1Var, byte[] bArr, int i2, int i10, e eVar) throws b0 {
        int iB = i2 + 1;
        int i11 = bArr[i2];
        if (i11 < 0) {
            iB = B(i11, bArr, iB, eVar);
            i11 = eVar.f413b;
        }
        int i12 = iB;
        if (i11 < 0 || i11 > i10 - i12) {
            throw b0.g();
        }
        int i13 = i12 + i11;
        a1Var.f(obj, bArr, i12, i13, eVar);
        eVar.f415d = obj;
        return i13;
    }

    public static int Y(Object obj, t3 t3Var, byte[] bArr, int i2, int i10, g gVar) throws r2 {
        int iC = i2 + 1;
        int i11 = bArr[i2];
        if (i11 < 0) {
            iC = C(i11, bArr, iC, gVar);
            i11 = gVar.f2354a;
        }
        int i12 = iC;
        if (i11 < 0 || i11 > i10 - i12) {
            throw r2.g();
        }
        int i13 = gVar.f2358e + 1;
        gVar.f2358e = i13;
        if (i13 >= 100) {
            throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i14 = i12 + i11;
        t3Var.h(obj, bArr, i12, i14, gVar);
        gVar.f2358e--;
        gVar.f2356c = obj;
        return i14;
    }

    public static final p0 Z(p0 p0Var, b9.g gVar) {
        k.e(p0Var, "<this>");
        int i2 = p0Var.f12301h;
        if ((i2 & 256) == 256) {
            return p0Var.f12311r;
        }
        if ((i2 & 512) == 512) {
            return gVar.a(p0Var.f12312s);
        }
        return null;
    }

    public static final void a(boolean z4, p7.a aVar, p pVar, int i2) {
        pVar.T(-361453782);
        int i10 = i2 | 6 | (pVar.h(aVar) ? 32 : 16);
        if (pVar.L(i10 & 1, (i10 & 19) != 18)) {
            Object obj = (d3.c) pVar.j(e3.a.f3051a);
            if (obj == null) {
                pVar.S(950836184);
                View view = (View) pVar.j(q0.f5303e);
                k.e(view, "<this>");
                while (true) {
                    if (view == null) {
                        obj = null;
                        break;
                    }
                    Object tag = view.getTag(R.id.view_tree_navigation_event_dispatcher_owner);
                    Object obj2 = tag instanceof d3.c ? (d3.c) tag : null;
                    if (obj2 != null) {
                        obj = obj2;
                        break;
                    } else {
                        Object objO = o.o(view);
                        view = objO instanceof View ? (View) objO : null;
                    }
                }
                pVar.q(false);
            } else {
                pVar.S(950834231);
                pVar.q(false);
            }
            if (obj == null) {
                pVar.S(535274673);
                obj = (c.p) pVar.j(d.g.f2741a);
                if (obj == null) {
                    pVar.S(1208426157);
                    View view2 = (View) pVar.j(q0.f5303e);
                    k.e(view2, "<this>");
                    while (true) {
                        if (view2 == null) {
                            obj = null;
                            break;
                        }
                        Object tag2 = view2.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                        Object obj3 = tag2 instanceof c.p ? (c.p) tag2 : null;
                        if (obj3 != null) {
                            obj = obj3;
                            break;
                        } else {
                            Object objO2 = o.o(view2);
                            view2 = objO2 instanceof View ? (View) objO2 : null;
                        }
                    }
                } else {
                    pVar.S(1208423708);
                }
                pVar.q(false);
                if (obj == null) {
                    pVar.S(1208428160);
                    Object baseContext = (Context) pVar.j(q0.f5300b);
                    while (true) {
                        if (!(baseContext instanceof ContextWrapper)) {
                            baseContext = null;
                            break;
                        } else if (baseContext instanceof c.p) {
                            break;
                        } else {
                            baseContext = ((ContextWrapper) baseContext).getBaseContext();
                        }
                    }
                    obj = (c.p) baseContext;
                } else {
                    pVar.S(1208423789);
                }
                pVar.q(false);
            } else {
                pVar.S(535271790);
            }
            pVar.q(false);
            if (obj == null) {
                throw new IllegalStateException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
            }
            boolean zF = pVar.f(obj);
            Object objJ = pVar.J();
            Object obj4 = b0.k.f1229a;
            if (zF || objJ == obj4) {
                d3.c cVar = obj instanceof d3.c ? (d3.c) obj : null;
                i5.f fVar = cVar != null ? ((c.n) ((c.o) ((c.i) cVar).f1702x.getValue()).f1712b.getValue()).f1710c : null;
                c.p pVar2 = obj instanceof c.p ? (c.p) obj : null;
                objJ = new b(fVar, pVar2 != null ? (c.o) ((c.i) pVar2).f1702x.getValue() : null);
                pVar.b0(objJ);
            }
            Object obj5 = (b) objJ;
            long j2 = pVar.Q;
            boolean zF2 = pVar.f(obj5) | pVar.e(j2);
            Object objJ2 = pVar.J();
            Object obj6 = objJ2;
            if (zF2 || objJ2 == obj4) {
                d.f fVar2 = new d.f(new d.a(j2, obj));
                fVar2.f2740c = new d0(1);
                pVar.b0(fVar2);
                obj6 = fVar2;
            }
            Object obj7 = (d.f) obj6;
            pVar.S(-585307852);
            boolean zH = pVar.h(obj7) | ((i10 & 112) == 32);
            Object objJ3 = pVar.J();
            if (zH || objJ3 == obj4) {
                objJ3 = new c2(1, obj7, aVar);
                pVar.b0(objJ3);
            }
            b0.b.f((p7.a) objJ3, pVar);
            boolean zH2 = pVar.h(obj7);
            Object objJ4 = pVar.J();
            if (zH2 || objJ4 == obj4) {
                objJ4 = new a5.a(7, obj7);
                pVar.b0(objJ4);
            }
            i.c(true, obj7, null, (p7.k) objJ4, pVar, 6);
            boolean zH3 = pVar.h(obj5) | pVar.h(obj7);
            Object objJ5 = pVar.J();
            if (zH3 || objJ5 == obj4) {
                objJ5 = new b2(2, obj5, obj7);
                pVar.b0(objJ5);
            }
            b0.b.c(obj5, obj7, (p7.k) objJ5, pVar);
            pVar.q(false);
            z4 = true;
        } else {
            pVar.O();
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new d.b(z4, aVar, i2);
        }
    }

    public static x a0(String str) throws ProtocolException, NumberFormatException {
        int i2;
        String strSubstring;
        k.e(str, "statusLine");
        boolean zG0 = r.g0(str, "HTTP/1.", false);
        u uVar = u.HTTP_1_0;
        if (zG0) {
            i2 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                uVar = u.HTTP_1_1;
            }
        } else {
            if (!r.g0(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i2 = 4;
        }
        int i10 = i2 + 3;
        if (str.length() < i10) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            String strSubstring2 = str.substring(i2, i10);
            k.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int i11 = Integer.parseInt(strSubstring2);
            if (str.length() <= i10) {
                strSubstring = "";
            } else {
                if (str.charAt(i10) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i2 + 4);
                k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
            return new x(uVar, i11, strSubstring, 1);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public static ka.g b(int i2, int i10, ka.a aVar) {
        if ((i10 & 2) != 0) {
            aVar = ka.a.f5661f;
        }
        if (i2 == -2) {
            if (aVar != ka.a.f5661f) {
                return new q(1, aVar);
            }
            ka.k.f5709d.getClass();
            return new ka.g(ka.j.f5708b);
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? aVar == ka.a.f5661f ? new ka.g(i2) : new q(i2, aVar) : new ka.g(Integer.MAX_VALUE) : aVar == ka.a.f5661f ? new ka.g(0) : new q(1, aVar);
        }
        if (aVar == ka.a.f5661f) {
            return new q(1, ka.a.f5662g);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static final Cursor b0(OfflineQueueDatabase offlineQueueDatabase, m3.c cVar) {
        k.e(offlineQueueDatabase, "db");
        k.e(cVar, "sqLiteQuery");
        return offlineQueueDatabase.m(cVar);
    }

    public static final long c(int i2, int i10) {
        return (i10 & 4294967295L) | (i2 << 32);
    }

    public static final p0 c0(z8.x xVar, b9.g gVar) {
        k.e(xVar, "<this>");
        k.e(gVar, "typeTable");
        int i2 = xVar.f12445h;
        if ((i2 & 32) == 32) {
            return xVar.f12452o;
        }
        if ((i2 & 64) == 64) {
            return gVar.a(xVar.f12453p);
        }
        return null;
    }

    public static void d(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putInt(a1.a.i(str, ".push_id_expire_time"), i2).apply();
    }

    public static final String d0(e9.f fVar) {
        k.e(fVar, "<this>");
        String strB = fVar.b();
        k.d(strB, "asString()");
        if (!g9.n.f3991a.contains(strB)) {
            for (int i2 = 0; i2 < strB.length(); i2++) {
                char cCharAt = strB.charAt(i2);
                if (Character.isLetterOrDigit(cCharAt) || cCharAt == '_') {
                }
            }
            String strB2 = fVar.b();
            k.d(strB2, "asString()");
            return strB2;
        }
        StringBuilder sb2 = new StringBuilder();
        String strB3 = fVar.b();
        k.d(strB3, "asString()");
        sb2.append("`".concat(strB3));
        sb2.append('`');
        return sb2.toString();
    }

    public static e7.c e(e7.c cVar) {
        cVar.k();
        cVar.f3089h = true;
        return cVar.f3088g > 0 ? cVar : e7.c.f3086i;
    }

    public static final String e0(List list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e9.f fVar = (e9.f) it.next();
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(d0(fVar));
        }
        String string = sb2.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static void f(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = context.getSharedPreferences("com.stepos.push", 0).getString("app_id", "");
        }
        context.getSharedPreferences("com.stepos.push", 0).edit().putString(a1.a.i(str, ".push_id"), str2).apply();
    }

    public static final String f0(String str, String str2, String str3, String str4, String str5) {
        k.e(str, "lowerRendered");
        k.e(str2, "lowerPrefix");
        k.e(str3, "upperRendered");
        k.e(str4, "upperPrefix");
        k.e(str5, "foldedPrefix");
        if (!r.g0(str, str2, false) || !r.g0(str3, str4, false)) {
            return null;
        }
        String strSubstring = str.substring(str2.length());
        k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        String strSubstring2 = str3.substring(str4.length());
        k.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
        String strConcat = str5.concat(strSubstring);
        if (strSubstring.equals(strSubstring2)) {
            return strConcat;
        }
        if (!o0(strSubstring, strSubstring2)) {
            return null;
        }
        return strConcat + '!';
    }

    public static final void g(int i2, int i10) {
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
    }

    public static final p0 g0(z8.x xVar, b9.g gVar) {
        k.e(xVar, "<this>");
        k.e(gVar, "typeTable");
        int i2 = xVar.f12445h;
        if ((i2 & 8) == 8) {
            p0 p0Var = xVar.f12449l;
            k.d(p0Var, "returnType");
            return p0Var;
        }
        if ((i2 & 16) == 16) {
            return gVar.a(xVar.f12450m);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    public static final void h(int i2, int i10) {
        if (i2 < 0 || i2 > i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
    }

    public static final p0 h0(f0 f0Var, b9.g gVar) {
        k.e(f0Var, "<this>");
        k.e(gVar, "typeTable");
        int i2 = f0Var.f12134h;
        if ((i2 & 8) == 8) {
            p0 p0Var = f0Var.f12138l;
            k.d(p0Var, "returnType");
            return p0Var;
        }
        if ((i2 & 16) == 16) {
            return gVar.a(f0Var.f12139m);
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    public static final void i(int i2, int i10, int i11) {
        if (i2 >= 0 && i10 <= i11) {
            if (i2 > i10) {
                throw new IllegalArgumentException(m.x.k("fromIndex: ", i2, i10, " > toIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i10 + ", size: " + i11);
    }

    public static final long i0(long j2) {
        return (Math.round(Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j2 >> 32))) << 32);
    }

    public static final Collection j(Collection collection, Collection collection2) {
        k.e(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final void j0(i0 i0Var, int i2, Object obj) {
        i0Var.f1745e[(i0Var.f1746f - i0Var.f1741a[i0Var.f1742b - 1].f1557c) + i2] = obj;
    }

    public static final Object k(Class cls, Map map, List list) throws IllegalArgumentException {
        k.e(cls, "annotationClass");
        k.e(list, "methods");
        int i2 = 0;
        c7.o oVarH = s7.a.H(new a8.c(i2, map));
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a8.b(cls, map, s7.a.H(new a8.e(i2, cls, map)), oVarH, list));
        k.c(objNewProxyInstance, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return objNewProxyInstance;
    }

    public static final void k0(i0 i0Var, int i2, Object obj, int i10, Object obj2) {
        int i11 = i0Var.f1746f - i0Var.f1741a[i0Var.f1742b - 1].f1557c;
        Object[] objArr = i0Var.f1745e;
        objArr[i2 + i11] = obj;
        objArr[i11 + i10] = obj2;
    }

    public static final v9.p0 l(v9.p0 p0Var, f8.q0 q0Var) {
        if (q0Var == null || p0Var.a() == 1) {
            return p0Var;
        }
        if (q0Var.a0() != p0Var.a()) {
            i9.c cVar = new i9.c(p0Var);
            v9.i0.f10557g.getClass();
            return new v9.q0(1, new i9.a(p0Var, cVar, false, v9.i0.f10558h));
        }
        if (!p0Var.c()) {
            return new v9.q0(p0Var.b());
        }
        u9.b bVar = u9.k.f10207e;
        k.d(bVar, "NO_LOCKS");
        return new v9.q0(1, new v9.x(bVar, new a8.c(13, p0Var)));
    }

    public static int l0(int i2, byte[] bArr, int i10, int i11, g gVar) throws r2 {
        if ((i2 >>> 3) == 0) {
            throw r2.a();
        }
        int i12 = i2 & 7;
        if (i12 == 0) {
            return I(bArr, i10, gVar);
        }
        if (i12 == 1) {
            return i10 + 8;
        }
        if (i12 == 2) {
            return E(bArr, i10, gVar) + gVar.f2354a;
        }
        if (i12 != 3) {
            if (i12 == 5) {
                return i10 + 4;
            }
            throw r2.a();
        }
        int i13 = (i2 & (-8)) | 4;
        int i14 = 0;
        while (i10 < i11) {
            i10 = E(bArr, i10, gVar);
            i14 = gVar.f2354a;
            if (i14 == i13) {
                break;
            }
            i10 = l0(i14, bArr, i10, i11, gVar);
        }
        if (i10 > i11 || i14 != i13) {
            throw r2.f();
        }
        return i10;
    }

    public static e7.c m() {
        return new e7.c(10);
    }

    public static final c7.j m0(Object obj, String str) {
        return new c7.j(str, obj);
    }

    public static byte[] n(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            byte b10 = (byte) ((bArr[i2] << 1) & 254);
            bArr2[i2] = b10;
            if (i2 < 15) {
                bArr2[i2] = (byte) (((byte) ((bArr[i2 + 1] >> 7) & 1)) | b10);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }

    public static final p0 n0(x0 x0Var, b9.g gVar) {
        k.e(gVar, "typeTable");
        int i2 = x0Var.f12466h;
        if ((i2 & 4) == 4) {
            p0 p0Var = x0Var.f12469k;
            k.d(p0Var, "type");
            return p0Var;
        }
        if ((i2 & 8) == 8) {
            return gVar.a(x0Var.f12470l);
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static byte[] o(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i10 = i2 * 2;
            int iDigit = Character.digit(str.charAt(i10), 16);
            int iDigit2 = Character.digit(str.charAt(i10 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i2] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }

    public static final boolean o0(String str, String str2) {
        k.e(str, "lower");
        k.e(str2, "upper");
        if (str.equals(r.e0(str2, "?", ""))) {
            return true;
        }
        if (r.Z(str2, "?", false) && k.a(str.concat("?"), str2)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(str);
        sb2.append(")?");
        return k.a(sb2.toString(), str2);
    }

    public static int p(byte[] bArr, int i2, e eVar) throws b0 {
        int iD = D(bArr, i2, eVar);
        int i10 = eVar.f413b;
        if (i10 < 0) {
            throw b0.e();
        }
        if (i10 > bArr.length - iD) {
            throw b0.g();
        }
        if (i10 == 0) {
            eVar.f415d = h.f2209g;
            return iD;
        }
        eVar.f415d = h.h(bArr, iD, i10);
        return iD + i10;
    }

    public static s0 p0(s0 s0Var) {
        if (!(s0Var instanceof s)) {
            return new i9.d(s0Var, 0);
        }
        s sVar = (s) s0Var;
        f8.q0[] q0VarArr = sVar.f10586b;
        v9.p0[] p0VarArr = sVar.f10587c;
        k.e(p0VarArr, "<this>");
        k.e(q0VarArr, "other");
        int iMin = Math.min(p0VarArr.length, q0VarArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(new c7.j(p0VarArr[i2], q0VarArr[i2]));
        }
        ArrayList arrayList2 = new ArrayList(t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            arrayList2.add(l((v9.p0) jVar.f1973f, (f8.q0) jVar.f1974g));
        }
        return new s(q0VarArr, (v9.p0[]) arrayList2.toArray(new v9.p0[0]), true);
    }

    public static int q(byte[] bArr, int i2, g gVar) throws r2 {
        int iE = E(bArr, i2, gVar);
        int i10 = gVar.f2354a;
        if (i10 < 0) {
            throw r2.e();
        }
        if (i10 > bArr.length - iE) {
            throw r2.g();
        }
        if (i10 == 0) {
            gVar.f2356c = l.f2424g;
            return iE;
        }
        gVar.f2356c = l.h(bArr, iE, i10);
        return iE + i10;
    }

    public static int r(int i2, byte[] bArr) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static int s(int i2, byte[] bArr) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static long t(int i2, byte[] bArr) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static long u(int i2, byte[] bArr) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int v(a1 a1Var, int i2, byte[] bArr, int i10, int i11, y yVar, e eVar) throws b0 {
        Object objD = a1Var.d();
        a1 a1Var2 = a1Var;
        byte[] bArr2 = bArr;
        int i12 = i11;
        e eVar2 = eVar;
        int iX = X(objD, a1Var2, bArr2, i10, i12, eVar2);
        a1Var2.b(objD);
        eVar2.f415d = objD;
        yVar.add(objD);
        while (iX < i12) {
            e eVar3 = eVar2;
            int i13 = i12;
            int iD = D(bArr2, iX, eVar3);
            if (i2 != eVar3.f413b) {
                break;
            }
            byte[] bArr3 = bArr2;
            a1 a1Var3 = a1Var2;
            Object objD2 = a1Var3.d();
            iX = X(objD2, a1Var3, bArr3, iD, i13, eVar3);
            a1Var2 = a1Var3;
            bArr2 = bArr3;
            i12 = i13;
            eVar2 = eVar3;
            a1Var2.b(objD2);
            eVar2.f415d = objD2;
            yVar.add(objD2);
        }
        return iX;
    }

    public static int w(t3 t3Var, int i2, byte[] bArr, int i10, int i11, o2 o2Var, g gVar) throws r2 {
        Object objD = t3Var.d();
        t3 t3Var2 = t3Var;
        byte[] bArr2 = bArr;
        int i12 = i11;
        g gVar2 = gVar;
        int iY = Y(objD, t3Var2, bArr2, i10, i12, gVar2);
        t3Var2.b(objD);
        gVar2.f2356c = objD;
        o2Var.add(objD);
        while (iY < i12) {
            g gVar3 = gVar2;
            int i13 = i12;
            int iE = E(bArr2, iY, gVar3);
            if (i2 != gVar3.f2354a) {
                break;
            }
            byte[] bArr3 = bArr2;
            t3 t3Var3 = t3Var2;
            Object objD2 = t3Var3.d();
            iY = Y(objD2, t3Var3, bArr3, iE, i13, gVar3);
            t3Var2 = t3Var3;
            bArr2 = bArr3;
            i12 = i13;
            gVar2 = gVar3;
            t3Var2.b(objD2);
            gVar2.f2356c = objD2;
            o2Var.add(objD2);
        }
        return iY;
    }

    public static int x(byte[] bArr, int i2, e eVar) throws b0 {
        int iD = D(bArr, i2, eVar);
        int i10 = eVar.f413b;
        if (i10 < 0) {
            throw b0.e();
        }
        if (i10 == 0) {
            eVar.f415d = "";
            return iD;
        }
        eVar.f415d = new String(bArr, iD, i10, z.f2296a);
        return iD + i10;
    }

    public static int y(byte[] bArr, int i2, e eVar) throws b0 {
        int iD = D(bArr, i2, eVar);
        int i10 = eVar.f413b;
        if (i10 < 0) {
            throw b0.e();
        }
        if (i10 == 0) {
            eVar.f415d = "";
            return iD;
        }
        eVar.f415d = p1.f2258a.q(bArr, iD, i10);
        return iD + i10;
    }

    public static int z(int i2, byte[] bArr, int i10, int i11, d1 d1Var, e eVar) throws b0 {
        if ((i2 >>> 3) == 0) {
            throw b0.a();
        }
        int i12 = i2 & 7;
        if (i12 == 0) {
            int iH = H(bArr, i10, eVar);
            d1Var.d(i2, Long.valueOf(eVar.f414c));
            return iH;
        }
        if (i12 == 1) {
            d1Var.d(i2, Long.valueOf(t(i10, bArr)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int iD = D(bArr, i10, eVar);
            int i13 = eVar.f413b;
            if (i13 < 0) {
                throw b0.e();
            }
            if (i13 > bArr.length - iD) {
                throw b0.g();
            }
            if (i13 == 0) {
                d1Var.d(i2, h.f2209g);
            } else {
                d1Var.d(i2, h.h(bArr, iD, i13));
            }
            return iD + i13;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw b0.a();
            }
            d1Var.d(i2, Integer.valueOf(r(i10, bArr)));
            return i10 + 4;
        }
        d1 d1VarC = d1.c();
        int i14 = (i2 & (-8)) | 4;
        int i15 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int iD2 = D(bArr, i10, eVar);
            i15 = eVar.f413b;
            if (i15 == i14) {
                i10 = iD2;
                break;
            }
            i10 = z(i15, bArr, iD2, i11, d1VarC, eVar);
        }
        if (i10 > i11 || i15 != i14) {
            throw b0.f();
        }
        d1Var.d(i2, d1VarC);
        return i10;
    }
}
