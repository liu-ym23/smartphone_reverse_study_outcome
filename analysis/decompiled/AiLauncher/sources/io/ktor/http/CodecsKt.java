package io.ktor.http;

import La.C0952b;
import La.C0953c;
import Z8.C1173v;
import Z8.C1174w;
import Z8.Y;
import Z8.Z;
import com.fasterxml.jackson.core.JsonPointer;
import fb.C4074a;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.util.date.GMTDateParser;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BufferKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5674c;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u001a3\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a\u001b\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\n\u001a=\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001c\u0010\u001d\u001a3\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010 \u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b \u0010\u001d\u001a?\u0010#\u001a\u00020\u0000*\u00020!2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010\u0015\u001a\u00020\u0000*\u00020%H\u0002¢\u0006\u0004\b\u0015\u0010&\u001a\u0017\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010+\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0018H\u0002¢\u0006\u0004\b+\u0010,\u001a'\u00101\u001a\u00020/*\u00020-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020/0.H\u0002¢\u0006\u0004\b1\u00102\"\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\"\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104\"\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104\"\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020%078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109\"\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104\" \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u0010=\"\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020%078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00109¨\u0006?"}, d2 = {"", "", "encodeFull", "spaceToPlus", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "encodeURLQueryComponent", "(Ljava/lang/String;ZZLjava/nio/charset/Charset;)Ljava/lang/String;", "encodeURLPathPart", "(Ljava/lang/String;)Ljava/lang/String;", "encodeSlash", "encodeEncoded", "encodeURLPath", "(Ljava/lang/String;ZZ)Ljava/lang/String;", "encodeOAuth", "encodeURLParameter", "(Ljava/lang/String;Z)Ljava/lang/String;", "", "", "allowedSet", "percentEncode", "(Ljava/lang/String;Ljava/util/Set;)Ljava/lang/String;", "encodeURLParameterValue", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "plusIsSpace", "decodeURLQueryComponent", "(Ljava/lang/String;IIZLjava/nio/charset/Charset;)Ljava/lang/String;", "decodeURLPart", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Ljava/lang/String;", "decodeScan", "", "prefixEnd", "decodeImpl", "(Ljava/lang/CharSequence;IIIZLjava/nio/charset/Charset;)Ljava/lang/String;", "", "(B)Ljava/lang/String;", "c2", "charToHexDigit", "(C)I", "digit", "hexDigitToChar", "(I)C", "Lfb/v;", "Lkotlin/Function1;", "LY8/t;", "block", "forEach", "(Lfb/v;Lp9/l;)V", "URL_ALPHABET", "Ljava/util/Set;", "URL_ALPHABET_CHARS", "HEX_ALPHABET", "", "URL_PROTOCOL_PART", "Ljava/util/List;", "VALID_PATH_PART", "ATTRIBUTE_CHARACTERS", "getATTRIBUTE_CHARACTERS", "()Ljava/util/Set;", "SPECIAL_SYMBOLS", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CodecsKt {
    private static final Set<Character> ATTRIBUTE_CHARACTERS;
    private static final Set<Character> HEX_ALPHABET;
    private static final List<Byte> SPECIAL_SYMBOLS;
    private static final Set<Byte> URL_ALPHABET;
    private static final Set<Character> URL_ALPHABET_CHARS;
    private static final List<Byte> URL_PROTOCOL_PART;
    private static final Set<Character> VALID_PATH_PART;

    static {
        Character chValueOf = Character.valueOf(GMTDateParser.ANY);
        Character chValueOf2 = Character.valueOf(JsonPointer.ESC);
        List listS0 = Z8.F.S0(Z8.F.P0(new C5674c('a', GMTDateParser.ZONE), new C5674c('A', 'Z')), new C5674c('0', '9'));
        ArrayList arrayList = new ArrayList(C1174w.x(listS0, 10));
        Iterator it = listS0.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        URL_ALPHABET = Z8.F.r1(arrayList);
        URL_ALPHABET_CHARS = Z8.F.r1(Z8.F.S0(Z8.F.P0(new C5674c('a', GMTDateParser.ZONE), new C5674c('A', 'Z')), new C5674c('0', '9')));
        HEX_ALPHABET = Z8.F.r1(Z8.F.S0(Z8.F.P0(new C5674c('a', 'f'), new C5674c('A', 'F')), new C5674c('0', '9')));
        Set setJ = Y.j(':', Character.valueOf(JsonPointer.SEPARATOR), '?', '#', '[', ']', '@', '!', '$', '&', '\'', '(', ')', chValueOf, ',', ';', '=', '-', '.', '_', chValueOf2, '+');
        ArrayList arrayList2 = new ArrayList(C1174w.x(setJ, 10));
        Iterator it2 = setJ.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        URL_PROTOCOL_PART = arrayList2;
        VALID_PATH_PART = Y.j(':', '@', '!', '$', '&', '\'', '(', ')', chValueOf, '+', ',', ';', '=', '-', '.', '_', chValueOf2);
        ATTRIBUTE_CHARACTERS = Z.o(URL_ALPHABET_CHARS, Y.j('!', '#', '$', '&', '+', '-', '.', '^', '_', '`', '|', chValueOf2));
        List listP = C1173v.p('-', '.', '_', chValueOf2);
        ArrayList arrayList3 = new ArrayList(C1174w.x(listP, 10));
        Iterator it3 = listP.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        SPECIAL_SYMBOLS = arrayList3;
    }

    private static final int charToHexDigit(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        if ('a' > c10 || c10 >= 'g') {
            return -1;
        }
        return c10 - 'W';
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c7, code lost:
    
        r0.append(La.D.F(r2, 0, r4, false, 4, null));
        r9 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String decodeImpl(java.lang.CharSequence r8, int r9, int r10, int r11, boolean r12, java.nio.charset.Charset r13) throws io.ktor.http.URLDecodeException {
        /*
            int r13 = r10 - r9
            r0 = 255(0xff, float:3.57E-43)
            if (r13 <= r0) goto L8
            int r13 = r13 / 3
        L8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r13)
            if (r11 <= r9) goto L12
            r0.append(r8, r9, r11)
        L12:
            r9 = 0
        L13:
            if (r11 >= r10) goto Lda
            char r13 = r8.charAt(r11)
            if (r12 == 0) goto L27
            r1 = 43
            if (r13 != r1) goto L27
            r13 = 32
            r0.append(r13)
        L24:
            int r11 = r11 + 1
            goto L13
        L27:
            r1 = 37
            if (r13 != r1) goto Ld5
            if (r9 != 0) goto L33
            int r9 = r10 - r11
            int r9 = r9 / 3
            byte[] r9 = new byte[r9]
        L33:
            r2 = r9
            r9 = 0
        L35:
            r4 = r9
            if (r11 >= r10) goto Lc7
            char r9 = r8.charAt(r11)
            if (r9 != r1) goto Lc7
            int r9 = r11 + 2
            java.lang.String r13 = ", in "
            if (r9 >= r10) goto L96
            int r3 = r11 + 1
            char r5 = r8.charAt(r3)
            int r5 = charToHexDigit(r5)
            char r6 = r8.charAt(r9)
            int r6 = charToHexDigit(r6)
            r7 = -1
            if (r5 == r7) goto L66
            if (r6 == r7) goto L66
            int r9 = r4 + 1
            int r5 = r5 * 16
            int r5 = r5 + r6
            byte r13 = (byte) r5
            r2[r4] = r13
            int r11 = r11 + 3
            goto L35
        L66:
            io.ktor.http.URLDecodeException r10 = new io.ktor.http.URLDecodeException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Wrong HEX escape: %"
            r12.append(r0)
            char r0 = r8.charAt(r3)
            r12.append(r0)
            char r9 = r8.charAt(r9)
            r12.append(r9)
            r12.append(r13)
            r12.append(r8)
            java.lang.String r8 = ", at "
            r12.append(r8)
            r12.append(r11)
            java.lang.String r8 = r12.toString()
            r10.<init>(r8)
            throw r10
        L96:
            io.ktor.http.URLDecodeException r9 = new io.ktor.http.URLDecodeException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "Incomplete trailing HEX escape: "
            r10.append(r12)
            int r12 = r8.length()
            java.lang.CharSequence r12 = r8.subSequence(r11, r12)
            java.lang.String r12 = r12.toString()
            r10.append(r12)
            r10.append(r13)
            r10.append(r8)
            java.lang.String r8 = " at "
            r10.append(r8)
            r10.append(r11)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        Lc7:
            r6 = 4
            r7 = 0
            r3 = 0
            r5 = 0
            java.lang.String r9 = La.D.F(r2, r3, r4, r5, r6, r7)
            r0.append(r9)
            r9 = r2
            goto L13
        Ld5:
            r0.append(r13)
            goto L24
        Lda:
            java.lang.String r8 = r0.toString()
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.p.h(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt.decodeImpl(java.lang.CharSequence, int, int, int, boolean, java.nio.charset.Charset):java.lang.String");
    }

    private static final String decodeScan(String str, int i10, int i11, boolean z10, Charset charset) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (z10 && cCharAt == '+')) {
                return decodeImpl(str, i10, i11, i12, z10, charset);
            }
        }
        if (i10 == 0 && i11 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String decodeURLPart(String str, int i10, int i11, Charset charset) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(charset, "charset");
        return decodeScan(str, i10, i11, false, charset);
    }

    public static /* synthetic */ String decodeURLPart$default(String str, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            charset = C0953c.UTF_8;
        }
        return decodeURLPart(str, i10, i11, charset);
    }

    public static final String decodeURLQueryComponent(String str, int i10, int i11, boolean z10, Charset charset) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(charset, "charset");
        return decodeScan(str, i10, i11, z10, charset);
    }

    public static /* synthetic */ String decodeURLQueryComponent$default(String str, int i10, int i11, boolean z10, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            charset = C0953c.UTF_8;
        }
        return decodeURLQueryComponent(str, i10, i11, z10, charset);
    }

    public static final String encodeOAuth(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return encodeURLParameter$default(str, false, 1, null);
    }

    public static final String encodeURLParameter(String str, final boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        final StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = C0953c.UTF_8.newEncoder();
        kotlin.jvm.internal.p.h(charsetEncoderNewEncoder, "newEncoder(...)");
        forEach(EncodingKt.encode$default(charsetEncoderNewEncoder, str, 0, 0, 6, null), new InterfaceC5074l() { // from class: io.ktor.http.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CodecsKt.encodeURLParameter$lambda$8$lambda$7(sb2, z10, ((Byte) obj).byteValue());
            }
        });
        return sb2.toString();
    }

    public static /* synthetic */ String encodeURLParameter$default(String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return encodeURLParameter(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t encodeURLParameter$lambda$8$lambda$7(StringBuilder sb2, boolean z10, byte b10) {
        if (URL_ALPHABET.contains(Byte.valueOf(b10)) || SPECIAL_SYMBOLS.contains(Byte.valueOf(b10))) {
            sb2.append((char) b10);
        } else if (z10 && b10 == 32) {
            sb2.append('+');
        } else {
            sb2.append(percentEncode(b10));
        }
        return Y8.t.f7040a;
    }

    public static final String encodeURLParameterValue(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return encodeURLParameter(str, true);
    }

    public static final String encodeURLPath(String str, boolean z10, boolean z11) {
        int i10;
        kotlin.jvm.internal.p.i(str, "<this>");
        final StringBuilder sb2 = new StringBuilder();
        Charset charset = C0953c.UTF_8;
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if ((!z10 && cCharAt == '/') || URL_ALPHABET_CHARS.contains(Character.valueOf(cCharAt)) || VALID_PATH_PART.contains(Character.valueOf(cCharAt))) {
                sb2.append(cCharAt);
                i11++;
            } else {
                if (!z11 && cCharAt == '%' && (i10 = i11 + 2) < str.length()) {
                    Set<Character> set = HEX_ALPHABET;
                    int i12 = i11 + 1;
                    if (set.contains(Character.valueOf(str.charAt(i12))) && set.contains(Character.valueOf(str.charAt(i10)))) {
                        sb2.append(cCharAt);
                        sb2.append(str.charAt(i12));
                        sb2.append(str.charAt(i10));
                        i11 += 3;
                    }
                }
                int i13 = C0952b.e(cCharAt) ? 2 : 1;
                CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
                kotlin.jvm.internal.p.h(charsetEncoderNewEncoder, "newEncoder(...)");
                int i14 = i13 + i11;
                forEach(EncodingKt.encode(charsetEncoderNewEncoder, str, i11, i14), new InterfaceC5074l() { // from class: io.ktor.http.d
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return CodecsKt.encodeURLPath$lambda$6$lambda$5(sb2, ((Byte) obj).byteValue());
                    }
                });
                i11 = i14;
            }
        }
        return sb2.toString();
    }

    public static /* synthetic */ String encodeURLPath$default(String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return encodeURLPath(str, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t encodeURLPath$lambda$6$lambda$5(StringBuilder sb2, byte b10) {
        sb2.append(percentEncode(b10));
        return Y8.t.f7040a;
    }

    public static final String encodeURLPathPart(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return encodeURLPath$default(str, true, false, 2, null);
    }

    public static final String encodeURLQueryComponent(String str, final boolean z10, final boolean z11, Charset charset) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(charset, "charset");
        final StringBuilder sb2 = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kotlin.jvm.internal.p.h(charsetEncoderNewEncoder, "newEncoder(...)");
        forEach(EncodingKt.encode$default(charsetEncoderNewEncoder, str, 0, 0, 6, null), new InterfaceC5074l() { // from class: io.ktor.http.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CodecsKt.encodeURLQueryComponent$lambda$4$lambda$3(z11, sb2, z10, ((Byte) obj).byteValue());
            }
        });
        return sb2.toString();
    }

    public static /* synthetic */ String encodeURLQueryComponent$default(String str, boolean z10, boolean z11, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            charset = C0953c.UTF_8;
        }
        return encodeURLQueryComponent(str, z10, z11, charset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t encodeURLQueryComponent$lambda$4$lambda$3(boolean z10, StringBuilder sb2, boolean z11, byte b10) {
        if (b10 == 32) {
            if (z10) {
                sb2.append('+');
            } else {
                sb2.append("%20");
            }
        } else if (URL_ALPHABET.contains(Byte.valueOf(b10)) || (!z11 && URL_PROTOCOL_PART.contains(Byte.valueOf(b10)))) {
            sb2.append((char) b10);
        } else {
            sb2.append(percentEncode(b10));
        }
        return Y8.t.f7040a;
    }

    private static final void forEach(fb.v vVar, final InterfaceC5074l<? super Byte, Y8.t> interfaceC5074l) {
        ByteReadPacketKt.takeWhile(vVar, new InterfaceC5074l() { // from class: io.ktor.http.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CodecsKt.forEach$lambda$11(interfaceC5074l, (C4074a) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean forEach$lambda$11(InterfaceC5074l interfaceC5074l, C4074a buffer) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        while (BufferKt.canRead(buffer)) {
            interfaceC5074l.invoke(Byte.valueOf(buffer.readByte()));
        }
        return true;
    }

    public static final Set<Character> getATTRIBUTE_CHARACTERS() {
        return ATTRIBUTE_CHARACTERS;
    }

    private static final char hexDigitToChar(int i10) {
        return (char) ((i10 < 0 || i10 >= 10) ? ((char) (i10 + 65)) - '\n' : i10 + 48);
    }

    private static final String percentEncode(byte b10) {
        return La.D.B(new char[]{'%', hexDigitToChar((b10 & 255) >> 4), hexDigitToChar(b10 & 15)});
    }

    public static final String percentEncode(String str, Set<Character> allowedSet) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(allowedSet, "allowedSet");
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (!allowedSet.contains(Character.valueOf(str.charAt(i11)))) {
                i10++;
            }
        }
        if (i10 == 0) {
            return str;
        }
        byte[] byteArray = StringsKt.toByteArray(str, C0953c.UTF_8);
        int length = str.length() - i10;
        char[] cArr = new char[length + ((byteArray.length - length) * 3)];
        int i12 = 0;
        for (byte b10 : byteArray) {
            char c10 = (char) b10;
            if (allowedSet.contains(Character.valueOf(c10))) {
                cArr[i12] = c10;
                i12++;
            } else {
                cArr[i12] = '%';
                int i13 = i12 + 2;
                cArr[i12 + 1] = hexDigitToChar((b10 & 255) >> 4);
                i12 += 3;
                cArr[i13] = hexDigitToChar(b10 & 15);
            }
        }
        return La.D.B(cArr);
    }
}
