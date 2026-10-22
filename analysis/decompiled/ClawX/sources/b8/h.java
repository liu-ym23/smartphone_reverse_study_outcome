package b8;

import a6.a2;
import a6.i0;
import a6.o0;
import a6.v;
import a6.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import b5.b0;
import b5.j;
import b5.w;
import c5.m;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import d8.x0;
import f5.i;
import g.l1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;
import k4.k;
import k4.l;
import k4.r;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.hpke.HPKE;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static g f1012a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1013b = false;

    public static k4.g F(String value) throws b4.a {
        p.e(value, "value");
        if (n.t1(value)) {
            return k4.g.f3611f;
        }
        k kVar = (k) m.B0(G(value));
        String str = kVar.f3625a;
        List list = kVar.f3626b;
        int iQ1 = n.q1(str, '/', 0, 6);
        if (iQ1 == -1) {
            if (p.a(n.T1(str).toString(), "*")) {
                return k4.g.f3611f;
            }
            throw new b4.a(value, 1);
        }
        String strSubstring = str.substring(0, iQ1);
        p.d(strSubstring, "substring(...)");
        String string = n.T1(strSubstring).toString();
        if (string.length() == 0) {
            throw new b4.a(value, 1);
        }
        String strSubstring2 = str.substring(iQ1 + 1);
        p.d(strSubstring2, "substring(...)");
        String string2 = n.T1(strSubstring2).toString();
        if (n.h1(string, ' ') || n.h1(string2, ' ')) {
            throw new b4.a(value, 1);
        }
        if (string2.length() == 0 || n.h1(string2, '/')) {
            throw new b4.a(value, 1);
        }
        return new k4.g(string, string2, list);
    }

    public static final List G(String str) {
        int i8;
        b5.g gVar;
        b5.g gVar2;
        s sVar = s.f1092a;
        if (str == null) {
            return sVar;
        }
        b5.e eVarW = w(b5.f.f890b, new r(0));
        for (int i9 = 0; i9 <= n.n1(str); i9 = i8) {
            b5.e eVarW2 = w(b5.f.f890b, new r(1));
            Integer numValueOf = null;
            i8 = i9;
            while (true) {
                if (i8 <= n.n1(str)) {
                    char cCharAt = str.charAt(i8);
                    if (cCharAt == ',') {
                        ((ArrayList) eVarW.getValue()).add(new k(N(i9, numValueOf != null ? numValueOf.intValue() : i8, str), eVarW2.a() ? (List) eVarW2.getValue() : sVar));
                        i8++;
                    } else if (cCharAt != ';') {
                        i8++;
                    } else {
                        if (numValueOf == null) {
                            numValueOf = Integer.valueOf(i8);
                        }
                        int i10 = i8 + 1;
                        int i11 = i10;
                        while (i11 <= n.n1(str)) {
                            char cCharAt2 = str.charAt(i11);
                            if (cCharAt2 == ',' || cCharAt2 == ';') {
                                H(eVarW2, str, i10, i11, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                                break;
                            }
                            if (cCharAt2 != '=') {
                                i11++;
                            } else {
                                int i12 = i11 + 1;
                                if (str.length() == i12) {
                                    gVar2 = new b5.g(Integer.valueOf(i12), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                                } else {
                                    char cCharAt3 = str.charAt(i12);
                                    char c3 = AbstractJsonLexerKt.STRING;
                                    if (cCharAt3 == '\"') {
                                        int i13 = i11 + 2;
                                        StringBuilder sb = new StringBuilder();
                                        while (i13 <= n.n1(str)) {
                                            char cCharAt4 = str.charAt(i13);
                                            if (cCharAt4 == c3) {
                                                int i14 = i13 + 1;
                                                int i15 = i14;
                                                while (i15 < str.length() && str.charAt(i15) == ' ') {
                                                    i15++;
                                                }
                                                if (i15 == str.length() || str.charAt(i15) == ';') {
                                                    gVar = new b5.g(Integer.valueOf(i14), sb.toString());
                                                    break;
                                                }
                                            }
                                            if (cCharAt4 != '\\' || i13 >= n.n1(str) - 2) {
                                                sb.append(cCharAt4);
                                                i13++;
                                            } else {
                                                sb.append(str.charAt(i13 + 1));
                                                i13 += 2;
                                            }
                                            c3 = AbstractJsonLexerKt.STRING;
                                        }
                                        Integer numValueOf2 = Integer.valueOf(i13);
                                        String string = sb.toString();
                                        p.d(string, "toString(...)");
                                        gVar = new b5.g(numValueOf2, "\"".concat(string));
                                    } else {
                                        int i16 = i12;
                                        while (i16 <= n.n1(str)) {
                                            char cCharAt5 = str.charAt(i16);
                                            if (cCharAt5 == ',' || cCharAt5 == ';') {
                                                gVar = new b5.g(Integer.valueOf(i16), N(i12, i16, str));
                                                break;
                                            }
                                            i16++;
                                        }
                                        gVar = new b5.g(Integer.valueOf(i16), N(i12, i16, str));
                                    }
                                    gVar2 = gVar;
                                }
                                int iIntValue = ((Number) gVar2.f892a).intValue();
                                H(eVarW2, str, i10, i11, (String) gVar2.f893b);
                                i8 = iIntValue;
                            }
                        }
                        H(eVarW2, str, i10, i11, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                        i8 = i11;
                    }
                } else {
                    ((ArrayList) eVarW.getValue()).add(new k(N(i9, numValueOf != null ? numValueOf.intValue() : i8, str), eVarW2.a() ? (List) eVarW2.getValue() : sVar));
                }
            }
        }
        return eVarW.a() ? (List) eVarW.getValue() : sVar;
    }

    public static final void H(b5.e eVar, String str, int i8, int i9, String str2) {
        String strN = N(i8, i9, str);
        if (strN.length() == 0) {
            return;
        }
        ((ArrayList) eVar.getValue()).add(new l(strN, str2));
    }

    public static f5.h I(f5.f fVar, f5.h context) {
        p.e(context, "context");
        return context == i.f2626a ? fVar : (f5.h) context.z(fVar, new y(7));
    }

    public static o0.b J(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j4;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i8 = byteBufferDuplicate.getShort() & HPKE.aead_EXPORT_ONLY;
        if (i8 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                j4 = -1;
                break;
            }
            int i10 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j4 = byteBufferDuplicate.getInt() & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i10) {
                break;
            }
            i9++;
        }
        if (j4 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j4 - byteBufferDuplicate.position())));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j8 = byteBufferDuplicate.getInt() & 4294967295L;
            for (int i11 = 0; i11 < j8; i11++) {
                int i12 = byteBufferDuplicate.getInt();
                long j9 = byteBufferDuplicate.getInt() & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i12 || 1701669481 == i12) {
                    byteBufferDuplicate.position((int) (j9 + j4));
                    o0.b bVar = new o0.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.d = byteBufferDuplicate;
                    bVar.f1830a = iPosition;
                    int i13 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f1831b = i13;
                    bVar.f1832c = ((ByteBuffer) bVar.d).getShort(i13);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static final void K(Object[] objArr, int i8, int i9) {
        p.e(objArr, "<this>");
        while (i8 < i9) {
            objArr[i8] = null;
            i8++;
        }
    }

    public static void L(TextView textView, int i8) {
        a.a.h(i8);
        if (i8 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i8 - r0, 1.0f);
        }
    }

    public static final Object M(f6.p pVar, boolean z, f6.p pVar2, p5.p pVar3) throws Throwable {
        Object vVar;
        Object objT;
        try {
            if (pVar3 instanceof h5.a) {
                d0.a(2, pVar3);
                vVar = pVar3.invoke(pVar2, pVar);
            } else {
                vVar = R(pVar3, pVar2, pVar);
            }
        } catch (o0 e9) {
            Throwable th = e9.f201a;
            pVar.S(new v(th, false));
            throw th;
        } catch (Throwable th2) {
            vVar = new v(th2, false);
        }
        g5.a aVar = g5.a.f2984a;
        if (vVar == aVar || (objT = pVar.T(vVar)) == i0.f175e) {
            return aVar;
        }
        pVar.i0();
        if (!(objT instanceof v)) {
            return i0.y(objT);
        }
        if (!z) {
            Throwable th3 = ((v) objT).f222a;
            if ((th3 instanceof a2) && ((a2) th3).f134a == pVar) {
                if (vVar instanceof v) {
                    throw ((v) vVar).f222a;
                }
                return vVar;
            }
        }
        throw ((v) objT).f222a;
    }

    public static final String N(int i8, int i9, String str) {
        String strSubstring = str.substring(i8, i9);
        p.d(strSubstring, "substring(...)");
        return n.T1(strSubstring).toString();
    }

    public static String O(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b9 : bArr) {
            short s8 = (short) (b9 & 255);
            sb.append("0123456789ABCDEF".charAt((byte) (s8 >> 4)));
            sb.append("0123456789ABCDEF".charAt((byte) (s8 & 15)));
        }
        return sb.toString();
    }

    public static void P(c7.e cursor, byte[] key) {
        long j4;
        p.e(cursor, "cursor");
        p.e(key, "key");
        int length = key.length;
        int i8 = 0;
        do {
            byte[] bArr = cursor.f1160e;
            int i9 = cursor.f1161f;
            int i10 = cursor.f1162g;
            if (bArr != null) {
                while (i9 < i10) {
                    int i11 = i8 % length;
                    bArr[i9] = (byte) (bArr[i9] ^ key[i11]);
                    i9++;
                    i8 = i11 + 1;
                }
            }
            long j8 = cursor.d;
            c7.f fVar = cursor.f1157a;
            p.b(fVar);
            if (j8 == fVar.f1164b) {
                throw new IllegalStateException("no more bytes");
            }
            j4 = cursor.d;
        } while (cursor.b(j4 == -1 ? 0L : j4 + (cursor.f1162g - cursor.f1161f)) != -1);
    }

    public static Object R(p5.p pVar, Object obj, f5.c cVar) {
        p.e(pVar, "<this>");
        f5.h context = cVar.getContext();
        Object eVar = context == i.f2626a ? new g5.e(cVar) : new g5.f(cVar, context);
        d0.a(2, pVar);
        return pVar.invoke(obj, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0083 -> B:25:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:25:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.util.List r7, j0.i r8, h5.c r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof j0.d
            if (r0 == 0) goto L13
            r0 = r9
            j0.d r0 = (j0.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            j0.d r0 = new j0.d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f3334c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.util.Iterator r7 = r0.f3333b
            java.io.Serializable r8 = r0.f3332a
            kotlin.jvm.internal.y r8 = (kotlin.jvm.internal.y) r8
            a.a.c0(r9)     // Catch: java.lang.Throwable -> L30
            goto L66
        L30:
            r9 = move-exception
            goto L7f
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            java.io.Serializable r7 = r0.f3332a
            java.util.List r7 = (java.util.List) r7
            a.a.c0(r9)
            goto L5d
        L42:
            a.a.c0(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            c4.a r2 = new c4.a
            r5 = 0
            r6 = 1
            r2.<init>(r7, r9, r5, r6)
            r0.f3332a = r9
            r0.d = r4
            java.lang.Object r7 = r8.a(r2, r0)
            if (r7 != r1) goto L5c
            goto L94
        L5c:
            r7 = r9
        L5d:
            kotlin.jvm.internal.y r8 = new kotlin.jvm.internal.y
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L66:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L8c
            java.lang.Object r9 = r7.next()
            p5.l r9 = (p5.l) r9
            r0.f3332a = r8     // Catch: java.lang.Throwable -> L30
            r0.f3333b = r7     // Catch: java.lang.Throwable -> L30
            r0.d = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L30
            if (r9 != r1) goto L66
            goto L94
        L7f:
            java.lang.Object r2 = r8.f3686a
            if (r2 != 0) goto L86
            r8.f3686a = r9
            goto L66
        L86:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            a.a.a(r2, r9)
            goto L66
        L8c:
            java.lang.Object r7 = r8.f3686a
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 != 0) goto L95
            b5.a0 r1 = b5.a0.f883a
        L94:
            return r1
        L95:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.a(java.util.List, j0.i, h5.c):java.lang.Object");
    }

    public static final String b(Object[] objArr, int i8, int i9, c5.g gVar) {
        StringBuilder sb = new StringBuilder((i9 * 3) + 2);
        sb.append("[");
        for (int i10 = 0; i10 < i9; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i8 + i10];
            if (obj == gVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        p.d(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(h4.c r5, h5.c r6) {
        /*
            boolean r0 = r6 instanceof h4.e
            if (r0 == 0) goto L13
            r0 = r6
            h4.e r0 = (h4.e) r0
            int r1 = r0.f3023b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3023b = r1
            goto L18
        L13:
            h4.e r0 = new h4.e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3022a
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3023b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.a.c0(r6)
            goto L50
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            a.a.c0(r6)
            u3.c r5 = r5.c()
            java.lang.Class<io.ktor.utils.io.p> r6 = io.ktor.utils.io.p.class
            kotlin.jvm.internal.h r2 = kotlin.jvm.internal.z.a(r6)
            kotlin.jvm.internal.f0 r6 = kotlin.jvm.internal.z.c(r6)     // Catch: java.lang.Throwable -> L41
            goto L42
        L41:
            r6 = 0
        L42:
            w4.a r4 = new w4.a
            r4.<init>(r2, r6)
            r0.f3023b = r3
            java.lang.Object r6 = r5.a(r4, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            if (r6 == 0) goto L55
            io.ktor.utils.io.p r6 = (io.ktor.utils.io.p) r6
            return r6
        L55:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.c(h4.c, h5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(h4.c r5, java.nio.charset.Charset r6, h5.c r7) throws b4.a {
        /*
            boolean r0 = r7 instanceof h4.f
            if (r0 == 0) goto L13
            r0 = r7
            h4.f r0 = (h4.f) r0
            int r1 = r0.f3026c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3026c = r1
            goto L18
        L13:
            h4.f r0 = new h4.f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3025b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3026c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.nio.charset.CharsetDecoder r5 = r0.f3024a
            a.a.c0(r7)
            goto L7f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            a.a.c0(r7)
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.p.e(r5, r7)
            k4.o r7 = r5.a()
            java.util.List r2 = k4.t.f3636a
            java.lang.String r2 = "Content-Type"
            java.lang.String r7 = r7.d(r2)
            r2 = 0
            if (r7 == 0) goto L4f
            k4.g r4 = k4.g.f3611f
            k4.g r7 = F(r7)
            goto L50
        L4f:
            r7 = r2
        L50:
            if (r7 == 0) goto L57
            java.nio.charset.Charset r7 = a.a.f(r7)
            goto L58
        L57:
            r7 = r2
        L58:
            if (r7 != 0) goto L5b
            goto L5c
        L5b:
            r6 = r7
        L5c:
            java.nio.charset.CharsetDecoder r6 = r6.newDecoder()
            u3.c r5 = r5.c()
            java.lang.Class<j6.j> r7 = j6.j.class
            kotlin.jvm.internal.h r4 = kotlin.jvm.internal.z.a(r7)
            kotlin.jvm.internal.f0 r2 = kotlin.jvm.internal.z.c(r7)     // Catch: java.lang.Throwable -> L6e
        L6e:
            w4.a r7 = new w4.a
            r7.<init>(r4, r2)
            r0.f3024a = r6
            r0.f3026c = r3
            java.lang.Object r7 = r5.a(r7, r0)
            if (r7 != r1) goto L7e
            return r1
        L7e:
            r5 = r6
        L7f:
            if (r7 == 0) goto L8b
            j6.j r7 = (j6.j) r7
            kotlin.jvm.internal.p.b(r5)
            java.lang.String r5 = x.e.u(r5, r7)
            return r5
        L8b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type kotlinx.io.Source"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.d(h4.c, java.nio.charset.Charset, h5.c):java.lang.Object");
    }

    public static void e(long j4) {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new x0(a8.b.l(j4, "Invalid DNS TTL: "));
        }
    }

    public static final void f(int i8, int i9) {
        String strK;
        if (i8 <= 0 || i9 <= 0) {
            if (i8 != i9) {
                strK = "Both size " + i8 + " and step " + i9 + " must be greater than zero.";
            } else {
                strK = a8.b.k(i8, "size ", " must be greater than zero.");
            }
            throw new IllegalArgumentException(strK.toString());
        }
    }

    public static final void i(int i8, int i9) {
        if (i8 <= i9) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is greater than size (" + i9 + ").");
    }

    public static final a4.d j(String str, p5.a createConfiguration, p5.l lVar) {
        p.e(createConfiguration, "createConfiguration");
        return new a4.d(str, createConfiguration, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f5.c k(f5.c cVar, f5.c cVar2, p5.p pVar) {
        p.e(pVar, "<this>");
        if (pVar instanceof h5.a) {
            return ((h5.a) pVar).create(cVar, cVar2);
        }
        f5.h context = cVar2.getContext();
        return context == i.f2626a ? new g5.c(cVar2, cVar, pVar) : new g5.d(cVar2, context, pVar, cVar);
    }

    public static String n(androidx.datastore.preferences.protobuf.g gVar) {
        StringBuilder sb = new StringBuilder(gVar.size());
        for (int i8 = 0; i8 < gVar.size(); i8++) {
            byte bF = gVar.f(i8);
            if (bF == 34) {
                sb.append("\\\"");
            } else if (bF == 39) {
                sb.append("\\'");
            } else if (bF != 92) {
                switch (bF) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case BERTags.RELATIVE_OID /* 13 */:
                        sb.append("\\r");
                        break;
                    default:
                        if (bF < 32 || bF > 126) {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((bF >>> 6) & 3) + 48));
                            sb.append((char) (((bF >>> 3) & 7) + 48));
                            sb.append((char) ((bF & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bF);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static f5.f o(f5.f fVar, f5.g key) {
        p.e(key, "key");
        if (p.a(fVar.getKey(), key)) {
            return fVar;
        }
        return null;
    }

    public static Drawable p(Context context, int i8) {
        return l1.b().c(context, i8);
    }

    public static final f4.b q(h4.c cVar) {
        p.e(cVar, "<this>");
        return cVar.c().d();
    }

    public static int t(int i8) {
        if (i8 == 1) {
            return 0;
        }
        if (i8 == 2) {
            return 1;
        }
        if (i8 == 4) {
            return 2;
        }
        if (i8 == 8) {
            return 3;
        }
        if (i8 == 16) {
            return 4;
        }
        if (i8 == 32) {
            return 5;
        }
        if (i8 == 64) {
            return 6;
        }
        if (i8 == 128) {
            return 7;
        }
        if (i8 == 256) {
            return 8;
        }
        if (i8 == 512) {
            return 9;
        }
        throw new IllegalArgumentException(a8.b.j(i8, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static f5.c u(f5.c cVar) {
        f5.c cVarIntercepted;
        p.e(cVar, "<this>");
        h5.c cVar2 = cVar instanceof h5.c ? (h5.c) cVar : null;
        return (cVar2 == null || (cVarIntercepted = cVar2.intercepted()) == null) ? cVar : cVarIntercepted;
    }

    public static boolean v(byte b9) {
        return b9 > -65;
    }

    public static b5.e w(b5.f fVar, p5.a aVar) {
        w wVar = w.f917a;
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0) {
            return new b5.k(aVar);
        }
        if (iOrdinal == 1) {
            j jVar = new j();
            jVar.f897a = aVar;
            jVar.f898b = wVar;
            return jVar;
        }
        if (iOrdinal != 2) {
            throw new a6.w();
        }
        b0 b0Var = new b0();
        b0Var.f884a = aVar;
        b0Var.f885b = wVar;
        return b0Var;
    }

    public static b5.k x(p5.a initializer) {
        p.e(initializer, "initializer");
        return new b5.k(initializer);
    }

    public static f5.h y(f5.f fVar, f5.g key) {
        p.e(key, "key");
        return p.a(fVar.getKey(), key) ? i.f2626a : fVar;
    }

    public abstract void A(a1.w wVar);

    public abstract void C(int i8);

    public abstract void D(View view, int i8, int i9);

    public abstract void E(View view, float f3, float f7);

    public abstract boolean Q(View view, int i8);

    public abstract int g(View view, int i8);

    public abstract int h(View view, int i8);

    public abstract String l(int i8, int i9, byte[] bArr);

    public abstract int m(String str, byte[] bArr, int i8, int i9);

    public int r(View view) {
        return 0;
    }

    public int s() {
        return 0;
    }

    public abstract void z(Throwable th);

    public void B(View view, int i8) {
    }
}
