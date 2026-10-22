package k4;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f3588a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set f3589b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f3590c;
    public static final ArrayList d;

    static {
        Character chValueOf = Character.valueOf(AbstractJsonLexerKt.COMMA);
        Character chValueOf2 = Character.valueOf(AbstractJsonLexerKt.COLON);
        ArrayList arrayListE0 = c5.m.E0(c5.m.F0(new u5.c('a', 'z'), new u5.c('A', 'Z')), new u5.c('0', '9'));
        ArrayList arrayList = new ArrayList(c5.o.n0(arrayListE0, 10));
        int size = arrayListE0.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayListE0.get(i8);
            i8++;
            arrayList.add(Byte.valueOf((byte) ((Character) obj).charValue()));
        }
        f3588a = c5.m.R0(arrayList);
        f3589b = c5.m.R0(c5.m.E0(c5.m.F0(new u5.c('a', 'z'), new u5.c('A', 'Z')), new u5.c('0', '9')));
        c5.m.R0(c5.m.E0(c5.m.F0(new u5.c('a', 'f'), new u5.c('A', 'F')), new u5.c('0', '9')));
        Set setK0 = c5.l.k0(new Character[]{chValueOf2, '/', '?', '#', Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '@', '!', '$', '&', '\'', '(', ')', '*', chValueOf, ';', '=', '-', '.', '_', '~', '+'});
        ArrayList arrayList2 = new ArrayList(c5.o.n0(setK0, 10));
        Iterator it = setK0.iterator();
        while (it.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f3590c = arrayList2;
        c5.l.k0(new Character[]{chValueOf2, '@', '!', '$', '&', '\'', '(', ')', '*', '+', chValueOf, ';', '=', '-', '.', '_', '~'});
        a.a.Z(f3589b, c5.l.k0(new Character[]{'!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', '~'}));
        List listS = c5.l.S(new Character[]{'-', '.', '_', '~'});
        ArrayList arrayList3 = new ArrayList(c5.o.n0(listS, 10));
        Iterator it2 = listS.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        d = arrayList3;
    }

    public static final int a(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('A' <= c3 && c3 < 'G') {
            return c3 - '7';
        }
        if ('a' > c3 || c3 >= 'g') {
            return -1;
        }
        return c3 - 'W';
    }

    public static final String b(boolean z, int i8, int i9, String str) throws b4.a {
        int i10 = i8;
        while (i10 < i9) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '%' || (z && cCharAt == '+')) {
                int i11 = i9 - i8;
                if (i11 > 255) {
                    i11 /= 3;
                }
                StringBuilder sb = new StringBuilder(i11);
                if (i10 > i8) {
                    sb.append((CharSequence) str, i8, i10);
                }
                byte[] bArr = null;
                while (i10 < i9) {
                    char cCharAt2 = str.charAt(i10);
                    if (z && cCharAt2 == '+') {
                        sb.append(' ');
                    } else if (cCharAt2 == '%') {
                        if (bArr == null) {
                            bArr = new byte[(i9 - i10) / 3];
                        }
                        int i12 = 0;
                        while (i10 < i9 && str.charAt(i10) == '%') {
                            int i13 = i10 + 2;
                            if (i13 >= i9) {
                                throw new b4.a("Incomplete trailing HEX escape: " + str.subSequence(i10, str.length()).toString() + ", in " + ((Object) str) + " at " + i10, 2);
                            }
                            int i14 = i10 + 1;
                            int iA = a(str.charAt(i14));
                            int iA2 = a(str.charAt(i13));
                            if (iA == -1 || iA2 == -1) {
                                throw new b4.a("Wrong HEX escape: %" + str.charAt(i14) + str.charAt(i13) + ", in " + ((Object) str) + ", at " + i10, 2);
                            }
                            bArr[i12] = (byte) ((iA * 16) + iA2);
                            i10 += 3;
                            i12++;
                        }
                        a.a.i(0, i12, bArr.length);
                        sb.append(new String(bArr, 0, i12, x5.a.f6276a));
                    } else {
                        sb.append(cCharAt2);
                    }
                    i10++;
                }
                String string = sb.toString();
                kotlin.jvm.internal.p.d(string, "toString(...)");
                return string;
            }
            i10++;
        }
        if (i8 == 0 && i9 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i8, i9);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String c(String str) {
        int length = str.length();
        Charset charset = x5.a.f6276a;
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(charset, "charset");
        return b(false, 0, length, str);
    }

    public static String d(String str, int i8, int i9, int i10) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        boolean z = (i10 & 4) == 0;
        Charset charset = x5.a.f6276a;
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(charset, "charset");
        return b(z, i8, i9, str);
    }

    public static final String e(String str, final boolean z) {
        kotlin.jvm.internal.p.e(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = x5.a.f6276a.newEncoder();
        kotlin.jvm.internal.p.d(charsetEncoderNewEncoder, "newEncoder(...)");
        int length = str.length();
        j6.a aVar = new j6.a();
        x.e.x(charsetEncoderNewEncoder, aVar, str, 0, length);
        f(aVar, new p5.l() { // from class: k4.a
            @Override // p5.l
            public final Object invoke(Object obj) {
                Byte b9 = (Byte) obj;
                byte bByteValue = b9.byteValue();
                boolean zContains = b.f3588a.contains(b9);
                StringBuilder sb2 = sb;
                if (zContains || b.d.contains(b9)) {
                    sb2.append((char) bByteValue);
                } else if (z && bByteValue == 32) {
                    sb2.append('+');
                } else {
                    sb2.append(b.g(bByteValue));
                }
                return b5.a0.f883a;
            }
        });
        return sb.toString();
    }

    public static final void f(j6.a aVar, p5.l lVar) {
        while (!aVar.q()) {
            while (!aVar.q()) {
                lVar.invoke(Byte.valueOf(aVar.readByte()));
            }
        }
    }

    public static final String g(byte b9) {
        int i8 = (b9 & 255) >> 4;
        int i9 = b9 & 15;
        return new String(new char[]{'%', (char) ((i8 < 0 || i8 >= 10) ? ((char) (i8 + 65)) - '\n' : i8 + 48), (char) ((i9 < 0 || i9 >= 10) ? ((char) (i9 + 65)) - '\n' : i9 + 48)});
    }
}
