package k4;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import com.stepos.stepclaw.SecurePrefs;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import v0.k0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3653a = 0;

    public static d8.m B(String statusLine) throws ProtocolException {
        n6.r rVar;
        int i8;
        String strSubstring;
        kotlin.jvm.internal.p.e(statusLine, "statusLine");
        if (x5.u.c1(statusLine, "HTTP/1.", false)) {
            i8 = 9;
            if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iCharAt = statusLine.charAt(7) - '0';
            if (iCharAt == 0) {
                rVar = n6.r.f4120c;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                rVar = n6.r.d;
            }
        } else if (x5.u.c1(statusLine, "ICY ", false)) {
            rVar = n6.r.f4120c;
            i8 = 4;
        } else {
            if (!x5.u.c1(statusLine, "SOURCETABLE ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            rVar = n6.r.d;
            i8 = 12;
        }
        int i9 = i8 + 3;
        if (statusLine.length() < i9) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
        String strSubstring2 = statusLine.substring(i8, i9);
        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
        Integer numD1 = x5.u.d1(strSubstring2);
        if (numD1 == null) {
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
        int iIntValue = numD1.intValue();
        if (statusLine.length() <= i9) {
            strSubstring = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            if (statusLine.charAt(i9) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            strSubstring = statusLine.substring(i8 + 4);
            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        }
        return new d8.m(rVar, iIntValue, strSubstring);
    }

    public static final String C(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i8 = reader.read(cArr);
        while (i8 >= 0) {
            stringWriter.write(cArr, 0, i8);
            i8 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    public static TypedValue D(Context context, int i8) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i8, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static TypedValue E(Context context, int i8, String str) {
        TypedValue typedValueD = D(context, i8);
        if (typedValueD != null) {
            return typedValueD;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i8)));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object F(u3.c r4, h5.c r5) {
        /*
            boolean r0 = r5 instanceof u3.e
            if (r0 == 0) goto L13
            r0 = r5
            u3.e r0 = (u3.e) r0
            int r1 = r0.f5637c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5637c = r1
            goto L18
        L13:
            u3.e r0 = new u3.e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f5636b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f5637c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            u3.c r4 = r0.f5635a
            a.a.c0(r5)
            goto L47
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            a.a.c0(r5)
            h4.c r5 = r4.e()
            io.ktor.utils.io.p r5 = r5.d()
            r0.f5635a = r4
            r0.f5637c = r3
            java.lang.Object r5 = io.ktor.utils.io.h0.m(r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            j6.j r5 = (j6.j) r5
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.e(r5, r0)
            r0 = -1
            byte[] r5 = j6.k.f(r5, r0)
            u3.f r0 = new u3.f
            t3.c r1 = r4.f5631a
            f4.b r2 = r4.d()
            h4.c r4 = r4.e()
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.z.F(u3.c, h5.c):java.lang.Object");
    }

    public static final void I(c0 c0Var, String value) {
        kotlin.jvm.internal.p.e(c0Var, "<this>");
        kotlin.jvm.internal.p.e(value, "value");
        List listO0 = x5.n.t1(value) ? c5.s.f1092a : value.equals("/") ? d0.f3603a : c5.m.O0(x5.n.H1(value, new char[]{'/'}));
        kotlin.jvm.internal.p.e(listO0, "<set-?>");
        c0Var.f3598h = listO0;
    }

    public static void J(View view, t1.j jVar) {
        o1.a aVar = jVar.f5475b.f5459c;
        if (aVar == null || !aVar.f4297a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        t1.h hVar = jVar.f5475b;
        if (hVar.f5468m != elevation) {
            hVar.f5468m = elevation;
            jVar.r();
        }
    }

    public static final n6.u K(n6.u uVar) {
        kotlin.jvm.internal.p.e(uVar, "<this>");
        n6.t tVarA = uVar.a();
        n6.w wVar = uVar.f4151g;
        tVarA.f4137g = new o6.b(wVar.b(), wVar.a());
        return tVarA.a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void a(c0 c0Var, StringBuilder sb) {
        List listS;
        sb.append(c0Var.c().f3606a);
        String str = c0Var.c().f3606a;
        switch (str.hashCode()) {
            case -1081572750:
                if (str.equals("mailto")) {
                    StringBuilder sb2 = new StringBuilder();
                    String str2 = c0Var.f3595e;
                    String str3 = c0Var.f3596f;
                    if (str2 != null) {
                        sb2.append(str2);
                        if (str3 != null) {
                            sb2.append(AbstractJsonLexerKt.COLON);
                            sb2.append(str3);
                        }
                        sb2.append("@");
                    }
                    CharSequence string = sb2.toString();
                    CharSequence charSequence = c0Var.f3592a;
                    sb.append(":");
                    sb.append(string);
                    sb.append(charSequence);
                    return;
                }
                break;
            case 114715:
                if (str.equals("tel")) {
                    CharSequence charSequence2 = c0Var.f3592a;
                    sb.append(":");
                    sb.append(charSequence2);
                    return;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    CharSequence charSequence3 = c0Var.f3592a;
                    String strU = u(c0Var);
                    sb.append("://");
                    sb.append(charSequence3);
                    if (!x5.n.J1(strU, '/')) {
                        sb.append('/');
                    }
                    sb.append((CharSequence) strU);
                    return;
                }
                break;
            case 92611469:
                if (str.equals("about")) {
                    CharSequence charSequence4 = c0Var.f3592a;
                    sb.append(":");
                    sb.append(charSequence4);
                    return;
                }
                break;
        }
        sb.append("://");
        sb.append(s(c0Var));
        String encodedPath = u(c0Var);
        p encodedQueryParameters = c0Var.f3599i;
        boolean z = c0Var.f3593b;
        kotlin.jvm.internal.p.e(encodedPath, "encodedPath");
        kotlin.jvm.internal.p.e(encodedQueryParameters, "encodedQueryParameters");
        if (!x5.n.t1(encodedPath) && !x5.u.c1(encodedPath, "/", false)) {
            sb.append('/');
        }
        sb.append((CharSequence) encodedPath);
        if (!((Map) encodedQueryParameters.f2554a).isEmpty() || z) {
            sb.append("?");
        }
        Set<Map.Entry> setA = encodedQueryParameters.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setA) {
            String str4 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listS = a.a.S(new b5.g(str4, null));
            } else {
                ArrayList arrayList2 = new ArrayList(c5.o.n0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new b5.g(str4, (String) it.next()));
                }
                listS = arrayList2;
            }
            c5.m.p0(arrayList, listS);
        }
        c5.m.z0(arrayList, sb, "&", new com.stepos.stepclaw.gateway.d(17), 60);
        if (c0Var.f3597g.length() > 0) {
            sb.append('#');
            sb.append(c0Var.f3597g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(x3.d r7, f4.d r8, h5.c r9) {
        /*
            boolean r0 = r9 instanceof w3.a
            if (r0 == 0) goto L13
            r0 = r9
            w3.a r0 = (w3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            w3.a r0 = new w3.a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f6186c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            a.a.c0(r9)
            return r9
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            f4.d r8 = r0.f6185b
            x3.d r7 = r0.f6184a
            a.a.c0(r9)
            goto L7e
        L3a:
            a.a.c0(r9)
            a6.h1 r9 = r8.f2599e
            r0.f6184a = r7
            r0.f6185b = r8
            r0.d = r4
            a6.e0 r2 = w3.g.f6193a
            a6.j1 r2 = new a6.j1
            r2.<init>(r9)
            f5.h r9 = r7.b()
            f5.h r9 = r9.t(r2)
            a6.e0 r5 = w3.g.f6193a
            f5.h r9 = r9.t(r5)
            f5.h r5 = r0.getContext()
            a6.c0 r6 = a6.c0.f143b
            f5.f r5 = r5.o(r6)
            a6.h1 r5 = (a6.h1) r5
            if (r5 != 0) goto L69
            goto L7b
        L69:
            w3.i r6 = new w3.i
            r6.<init>(r4, r2)
            a6.s0 r4 = r5.n(r4, r4, r6)
            w3.i r5 = new w3.i
            r6 = 0
            r5.<init>(r6, r4)
            r2.A(r5)
        L7b:
            if (r9 != r1) goto L7e
            goto L9f
        L7e:
            f5.h r9 = (f5.h) r9
            w3.h r2 = new w3.h
            r2.<init>(r9)
            f5.h r9 = r9.t(r2)
            c4.c r2 = new c4.c
            r4 = 0
            r2.<init>(r7, r8, r4)
            a6.m0 r7 = a6.i0.d(r7, r9, r2, r3)
            r0.f6184a = r4
            r0.f6185b = r4
            r0.d = r3
            java.lang.Object r7 = r7.w(r0)
            if (r7 != r1) goto La0
        L9f:
            return r1
        La0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.z.b(x3.d, f4.d, h5.c):java.lang.Object");
    }

    public static final void c(r4.k kVar, r4.k builder) {
        kotlin.jvm.internal.p.e(kVar, "<this>");
        kotlin.jvm.internal.p.e(builder, "builder");
        for (Map.Entry entry : builder.a()) {
            kVar.j((String) entry.getKey(), (List) entry.getValue());
        }
    }

    public static final w4.a d(w4.a aVar) {
        kotlin.jvm.internal.p.e(aVar, "<this>");
        v5.i iVar = aVar.f6201b;
        kotlin.jvm.internal.p.b(iVar);
        v5.i iVar2 = ((v5.k) iVar.getArguments().get(0)).f5988b;
        kotlin.jvm.internal.p.b(iVar2);
        v5.d classifier = iVar2.getClassifier();
        kotlin.jvm.internal.p.c(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        return new w4.a((v5.c) classifier, iVar2);
    }

    public static t1.f e(List from, p5.l lVar, p5.p pVar) {
        Object obj;
        kotlin.jvm.internal.p.e(from, "from");
        Iterator it = from.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Comparable comparable = (Comparable) lVar.invoke(next);
                do {
                    Object next2 = it.next();
                    Comparable comparable2 = (Comparable) lVar.invoke(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new NoSuchElementException("Unable to build char tree from an empty list");
        }
        ((Number) lVar.invoke(obj)).intValue();
        if (!from.isEmpty()) {
            Iterator it2 = from.iterator();
            while (it2.hasNext()) {
                if (((Number) lVar.invoke(it2.next())).intValue() == 0) {
                    throw new IllegalArgumentException("There should be no empty entries");
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        f(arrayList, from, 0, lVar, pVar);
        arrayList.trimToSize();
        new m4.a((char) 0, c5.s.f1092a, arrayList);
        return new t1.f(27);
    }

    public static void f(ArrayList arrayList, List list, int i8, p5.l lVar, p5.p pVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Character ch = (Character) pVar.invoke(obj, Integer.valueOf(i8));
            ch.getClass();
            Object arrayList2 = linkedHashMap.get(ch);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(ch, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            char cCharValue = ((Character) entry.getKey()).charValue();
            List list2 = (List) entry.getValue();
            int i9 = i8 + 1;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list2) {
                if (((Number) lVar.invoke(obj2)).intValue() > i9) {
                    arrayList4.add(obj2);
                }
            }
            f(arrayList3, arrayList4, i9, lVar, pVar);
            arrayList3.trimToSize();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : list2) {
                if (((Number) lVar.invoke(obj3)).intValue() == i9) {
                    arrayList5.add(obj3);
                }
            }
            arrayList.add(new m4.a(cCharValue, arrayList5, arrayList3));
        }
    }

    public static BigInteger g(BigInteger bigInteger, BigInteger bigInteger2, int i8) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2.abs());
        boolean zTestBit = bigIntegerMultiply.testBit(i8 - 1);
        BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(i8);
        if (zTestBit) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(p7.a.f4758b);
        }
        return z ? bigIntegerShiftRight.negate() : bigIntegerShiftRight;
    }

    public static final void h(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                a.a.a(th, th2);
            }
        }
    }

    public static final String i(int i8, int i9, byte[] bArr) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i8;
        if (i15 < 0 || i9 > bArr.length || i15 > i9) {
            StringBuilder sb = new StringBuilder("size=");
            a8.b.z(sb, bArr.length, " beginIndex=", i15, " endIndex=");
            sb.append(i9);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        char[] cArr = new char[i9 - i15];
        int i16 = 0;
        while (i15 < i9) {
            byte b9 = bArr[i15];
            if (b9 >= 0) {
                i10 = i16 + 1;
                cArr[i16] = (char) b9;
                i15++;
                while (i15 < i9) {
                    byte b10 = bArr[i15];
                    if (b10 < 0) {
                        break;
                    }
                    i15++;
                    cArr[i10] = (char) b10;
                    i10++;
                }
            } else {
                if ((b9 >> 5) == -2) {
                    int i17 = i15 + 1;
                    if (i9 <= i17) {
                        i10 = i16 + 1;
                        cArr[i16] = (char) 65533;
                    } else {
                        byte b11 = bArr[i17];
                        if ((b11 & 192) == 128) {
                            int i18 = (b9 << 6) ^ (b11 ^ 3968);
                            if (i18 < 128) {
                                i10 = i16 + 1;
                                cArr[i16] = (char) 65533;
                            } else {
                                i10 = i16 + 1;
                                cArr[i16] = (char) i18;
                            }
                        } else {
                            i10 = i16 + 1;
                            cArr[i16] = (char) 65533;
                        }
                    }
                } else if ((b9 >> 4) == -2) {
                    int i19 = i15 + 2;
                    if (i9 <= i19) {
                        i10 = i16 + 1;
                        cArr[i16] = (char) 65533;
                        int i20 = i15 + 1;
                        i11 = (i9 <= i20 || (bArr[i20] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b12 = bArr[i15 + 1];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i19];
                            if ((b13 & 192) == 128) {
                                int i21 = (b9 << 12) ^ ((b13 ^ (-123008)) ^ (b12 << 6));
                                if (i21 < 2048) {
                                    i10 = i16 + 1;
                                    cArr[i16] = (char) 65533;
                                } else if (55296 > i21 || i21 >= 57344) {
                                    i10 = i16 + 1;
                                    cArr[i16] = (char) i21;
                                } else {
                                    i10 = i16 + 1;
                                    cArr[i16] = (char) 65533;
                                }
                                i11 = 3;
                            } else {
                                i10 = i16 + 1;
                                cArr[i16] = (char) 65533;
                            }
                        } else {
                            i10 = i16 + 1;
                            cArr[i16] = (char) 65533;
                        }
                    }
                } else {
                    if ((b9 >> 3) == -2) {
                        int i22 = i15 + 3;
                        if (i9 <= i22) {
                            i12 = i16 + 1;
                            cArr[i16] = 65533;
                            int i23 = i15 + 1;
                            if (i9 > i23 && (bArr[i23] & 192) == 128) {
                                int i24 = i15 + 2;
                                i14 = (i9 <= i24 || (bArr[i24] & 192) != 128) ? 2 : 3;
                            }
                            i14 = 1;
                        } else {
                            byte b14 = bArr[i15 + 1];
                            if ((b14 & 192) == 128) {
                                byte b15 = bArr[i15 + 2];
                                if ((b15 & 192) == 128) {
                                    byte b16 = bArr[i22];
                                    if ((b16 & 192) == 128) {
                                        int i25 = (b9 << 18) ^ (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12));
                                        if (i25 > 1114111) {
                                            i12 = i16 + 1;
                                            cArr[i16] = 65533;
                                        } else if ((55296 > i25 || i25 >= 57344) && i25 >= 65536) {
                                            if (i25 != 65533) {
                                                cArr[i16] = (char) ((i25 >>> 10) + 55232);
                                                i13 = i16 + 2;
                                                cArr[i16 + 1] = (char) ((i25 & 1023) + 56320);
                                            } else {
                                                cArr[i16] = 65533;
                                                i13 = i16 + 1;
                                            }
                                            i12 = i13;
                                        } else {
                                            i12 = i16 + 1;
                                            cArr[i16] = 65533;
                                        }
                                        i14 = 4;
                                    } else {
                                        i12 = i16 + 1;
                                        cArr[i16] = 65533;
                                    }
                                } else {
                                    i12 = i16 + 1;
                                    cArr[i16] = 65533;
                                }
                            } else {
                                i12 = i16 + 1;
                                cArr[i16] = 65533;
                                i14 = 1;
                            }
                        }
                        i15 += i14;
                    } else {
                        i12 = i16 + 1;
                        cArr[i16] = 65533;
                        i15++;
                    }
                    i16 = i12;
                }
                i15 += i11;
            }
            i16 = i10;
        }
        return x5.u.U0(cArr, 0, i16);
    }

    public static int j(k0 k0Var, a2.g gVar, View view, View view2, v0.b0 b0Var, boolean z) {
        if (b0Var.q() == 0 || k0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(v0.b0.A(view) - v0.b0.A(view2)) + 1;
        }
        return Math.min(gVar.n(), gVar.d(view2) - gVar.g(view));
    }

    public static int k(k0 k0Var, a2.g gVar, View view, View view2, v0.b0 b0Var, boolean z, boolean z2) {
        if (b0Var.q() == 0 || k0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (k0Var.a() - Math.max(v0.b0.A(view), v0.b0.A(view2))) - 1) : Math.max(0, Math.min(v0.b0.A(view), v0.b0.A(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(gVar.d(view2) - gVar.g(view)) / (Math.abs(v0.b0.A(view) - v0.b0.A(view2)) + 1))) + (gVar.m() - gVar.g(view)));
        }
        return iMax;
    }

    public static int l(k0 k0Var, a2.g gVar, View view, View view2, v0.b0 b0Var, boolean z) {
        if (b0Var.q() == 0 || k0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return k0Var.a();
        }
        return (int) (((gVar.d(view2) - gVar.g(view)) / (Math.abs(v0.b0.A(view) - v0.b0.A(view2)) + 1)) * k0Var.a());
    }

    public static v m(int i8) {
        return i8 != 0 ? i8 != 1 ? new t1.l() : new t1.e() : new t1.l();
    }

    public static byte[] n(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 * 2;
            int iDigit = Character.digit(str.charAt(i9), 16);
            int iDigit2 = Character.digit(str.charAt(i9 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i8] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }

    public static final a0 o(p pVar) {
        p pVar2 = new p(1);
        for (String str : ((Map) pVar.f2554a).keySet()) {
            List listG = pVar.g(str);
            if (listG == null) {
                listG = c5.s.f1092a;
            }
            String strD = b.d(str, 0, 0, 15);
            ArrayList arrayList = new ArrayList(c5.o.n0(listG, 10));
            Iterator it = listG.iterator();
            while (it.hasNext()) {
                arrayList.add(b.d((String) it.next(), 0, 0, 11));
            }
            pVar2.j(strD, arrayList);
        }
        Map values = (Map) pVar2.f2554a;
        kotlin.jvm.internal.p.e(values, "values");
        return new b0(values);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(java.util.ArrayList r11, io.ktor.utils.io.p r12, w4.a r13, java.nio.charset.Charset r14, h5.c r15) throws b4.a {
        /*
            boolean r0 = r15 instanceof o4.d
            if (r0 == 0) goto L13
            r0 = r15
            o4.d r0 = (o4.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            o4.d r0 = new o4.d
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f4319c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            w4.a r13 = r0.f4318b
            io.ktor.utils.io.p r12 = r0.f4317a
            a.a.c0(r15)
            goto L5b
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            a.a.c0(r15)
            d6.e r6 = new d6.e
            r15 = 0
            r6.<init>(r15, r11)
            o4.c r5 = new o4.c
            r10 = 0
            r9 = r12
            r8 = r13
            r7 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            o4.e r11 = new o4.e
            r12 = 0
            r11.<init>(r9, r12, r4)
            r0.f4317a = r9
            r0.f4318b = r8
            r0.d = r3
            java.lang.Object r15 = d6.z.e(r5, r11, r0)
            if (r15 != r1) goto L59
            return r1
        L59:
            r13 = r8
            r12 = r9
        L5b:
            if (r15 != 0) goto L8a
            boolean r11 = r12.e()
            if (r11 != 0) goto L64
            return r12
        L64:
            v5.i r11 = r13.f6201b
            if (r11 == 0) goto L71
            boolean r11 = r11.isMarkedNullable()
            if (r11 != r3) goto L71
            n4.b r11 = n4.b.f3977a
            return r11
        L71:
            b4.a r11 = new b4.a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "No suitable converter found for "
            r12.<init>(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = "message"
            kotlin.jvm.internal.p.e(r12, r13)
            r11.<init>(r12, r4)
            throw r11
        L8a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.z.p(java.util.ArrayList, io.ktor.utils.io.p, w4.a, java.nio.charset.Charset, h5.c):java.lang.Object");
    }

    public static String q(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            int i8 = b9 & 255;
            sb.append("0123456789abcdef".charAt(i8 / 16));
            sb.append("0123456789abcdef".charAt(i8 % 16));
        }
        return sb.toString();
    }

    public static n6.j r(SSLSession sSLSession) throws IOException {
        Object objK;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") || cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        n6.g gVarB = n6.g.f4013b.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        n6.y.f4166b.getClass();
        n6.y yVarC = n6.b.c(protocol);
        try {
            objK = o6.f.k(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            objK = c5.s.f1092a;
        }
        return new n6.j(yVarC, gVarB, o6.f.k(sSLSession.getLocalCertificates()), new b7.c(19, objK));
    }

    public static final String s(c0 c0Var) {
        kotlin.jvm.internal.p.e(c0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String str = c0Var.f3595e;
        String str2 = c0Var.f3596f;
        if (str != null) {
            sb2.append(str);
            if (str2 != null) {
                sb2.append(AbstractJsonLexerKt.COLON);
                sb2.append(str2);
            }
            sb2.append("@");
        }
        sb.append(sb2.toString());
        sb.append(c0Var.f3592a);
        int i8 = c0Var.f3594c;
        if (i8 != 0 && i8 != c0Var.c().f3607b) {
            sb.append(":");
            sb.append(String.valueOf(c0Var.f3594c));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r5.f6058c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList t(android.content.Context r8, int r9) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            w.i r1 = new w.i
            r1.<init>(r0, r8)
            java.lang.Object r2 = w.j.f6063c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = w.j.f6062b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            w.h r5 = (w.h) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.f6057b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.f6058c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb8
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.f6058c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.f6056a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = w.j.f6061a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = w.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb3
            java.lang.Object r2 = w.j.f6063c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = w.j.f6062b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb1
        La1:
            w.h r0 = new w.h     // Catch: java.lang.Throwable -> L9f
            android.content.res.Resources r1 = r1.f6059a     // Catch: java.lang.Throwable -> L9f
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L9f
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            goto Lb7
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb3:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lb7:
            return r4
        Lb8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.z.t(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static final String u(c0 c0Var) {
        List list = c0Var.f3598h;
        return list.isEmpty() ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : list.size() == 1 ? ((CharSequence) c5.m.u0(list)).length() == 0 ? "/" : (String) c5.m.u0(list) : c5.m.A0(list, "/", null, null, null, 62);
    }

    public static v5.k w(kotlin.jvm.internal.f0 f0Var) {
        return new v5.k(v5.l.f5989a, f0Var);
    }

    public static boolean x(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static final boolean y(y yVar) {
        kotlin.jvm.internal.p.e(yVar, "<this>");
        int i8 = yVar.f3651a;
        return 200 <= i8 && i8 < 300;
    }

    public abstract void A(Typeface typeface, boolean z);

    public abstract void G(boolean z);

    public abstract void H(boolean z);

    public abstract InputFilter[] v(InputFilter[] inputFilterArr);

    public abstract void z(int i8);
}
