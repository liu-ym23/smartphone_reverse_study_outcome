package h3;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import k3.AbstractC0684F;
import k3.AbstractC0685G;
import k3.C0694i;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import l3.AbstractC0766b;
import n3.InterfaceC0780a;
import n3.InterfaceC0781b;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* renamed from: h3.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0611u implements m3.h, InterfaceC0780a, q3.a, x3.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12973a;

    public /* synthetic */ C0611u(int i4) {
        this.f12973a = i4;
    }

    public static void b(long j4, C0694i c0694i, int i4, List list, int i5, int i6, List list2) {
        int i7;
        int i8;
        int i9;
        int i10;
        C0694i c0694i2;
        int i11 = i4;
        if (i5 >= i6) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (int i12 = i5; i12 < i6; i12++) {
            if (((k3.l) list.get(i12)).c() < i11) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        k3.l lVar = (k3.l) list.get(i5);
        k3.l lVar2 = (k3.l) list.get(i6 - 1);
        int i13 = -1;
        if (i11 == lVar.c()) {
            int iIntValue = ((Number) list2.get(i5)).intValue();
            int i14 = i5 + 1;
            k3.l lVar3 = (k3.l) list.get(i14);
            i7 = i14;
            i8 = iIntValue;
            lVar = lVar3;
        } else {
            i7 = i5;
            i8 = -1;
        }
        if (lVar.f(i11) == lVar2.f(i11)) {
            int iMin = Math.min(lVar.c(), lVar2.c());
            int i15 = 0;
            for (int i16 = i11; i16 < iMin && lVar.f(i16) == lVar2.f(i16); i16++) {
                i15++;
            }
            long j5 = 4;
            long j6 = (c0694i.f13357b / j5) + j4 + 2 + i15 + 1;
            c0694i.Y(-i15);
            c0694i.Y(i8);
            int i17 = i15 + i11;
            while (i11 < i17) {
                c0694i.Y(lVar.f(i11) & 255);
                i11++;
            }
            if (i7 + 1 == i6) {
                if (i17 != ((k3.l) list.get(i7)).c()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                c0694i.Y(((Number) list2.get(i7)).intValue());
                return;
            } else {
                C0694i c0694i3 = new C0694i();
                c0694i.Y(((int) ((c0694i3.f13357b / j5) + j6)) * (-1));
                b(j6, c0694i3, i17, list, i7, i6, list2);
                c0694i.A(c0694i3);
                return;
            }
        }
        int i18 = 1;
        for (int i19 = i7 + 1; i19 < i6; i19++) {
            if (((k3.l) list.get(i19 - 1)).f(i11) != ((k3.l) list.get(i19)).f(i11)) {
                i18++;
            }
        }
        long j7 = 4;
        long j8 = (c0694i.f13357b / j7) + j4 + 2 + (i18 * 2);
        c0694i.Y(i18);
        c0694i.Y(i8);
        for (int i20 = i7; i20 < i6; i20++) {
            int iF = ((k3.l) list.get(i20)).f(i11);
            if (i20 == i7 || iF != ((k3.l) list.get(i20 - 1)).f(i11)) {
                c0694i.Y(iF & 255);
            }
        }
        C0694i c0694i4 = new C0694i();
        int i21 = i7;
        while (i21 < i6) {
            byte bF = ((k3.l) list.get(i21)).f(i11);
            int i22 = i21 + 1;
            int i23 = i22;
            while (true) {
                if (i23 >= i6) {
                    i9 = i6;
                    break;
                } else {
                    if (bF != ((k3.l) list.get(i23)).f(i11)) {
                        i9 = i23;
                        break;
                    }
                    i23++;
                }
            }
            if (i22 == i9 && i11 + 1 == ((k3.l) list.get(i21)).c()) {
                c0694i.Y(((Number) list2.get(i21)).intValue());
                i10 = i9;
                c0694i2 = c0694i4;
            } else {
                c0694i.Y(((int) ((c0694i4.f13357b / j7) + j8)) * i13);
                i10 = i9;
                c0694i2 = c0694i4;
                b(j8, c0694i4, i11 + 1, list, i21, i9, list2);
            }
            c0694i4 = c0694i2;
            i21 = i10;
            i13 = -1;
        }
        c0694i.A(c0694i4);
    }

    public static String c(String str, int i4, int i5, String encodeSet, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset, int i6) {
        char[] cArr = J.f12721k;
        int i7 = (i6 & 1) != 0 ? 0 : i4;
        int length = (i6 & 2) != 0 ? str.length() : i5;
        boolean z8 = (i6 & 8) != 0 ? false : z4;
        boolean z9 = (i6 & 16) != 0 ? false : z5;
        boolean z10 = (i6 & 32) != 0 ? false : z6;
        boolean z11 = (i6 & 64) == 0 ? z7 : false;
        int i8 = 128;
        Charset charset2 = (i6 & 128) != 0 ? null : charset;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
        int iCharCount = i7;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i9 = 32;
            int i10 = 43;
            int i11 = 127;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= i8 && !z11) || StringsKt__StringsKt.contains$default(encodeSet, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z8 || (z9 && !q(iCharCount, length, str)))) || (iCodePointAt == 43 && z10)))) {
                C0694i c0694i = new C0694i();
                c0694i.c0(i7, iCharCount, str);
                C0694i c0694i2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z8 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == i10 && z10) {
                            c0694i.d0(z8 ? "+" : "%2B");
                        } else {
                            if (iCodePointAt2 >= i9 && iCodePointAt2 != i11) {
                                if ((iCodePointAt2 < 128 || z11) && !StringsKt__StringsKt.contains$default(encodeSet, (char) iCodePointAt2, false, 2, (Object) null) && (iCodePointAt2 != 37 || (z8 && (!z9 || q(iCharCount, length, str))))) {
                                    c0694i.e0(iCodePointAt2);
                                }
                            }
                            if (c0694i2 == null) {
                                c0694i2 = new C0694i();
                            }
                            if (charset2 == null || Intrinsics.areEqual(charset2, StandardCharsets.UTF_8)) {
                                c0694i2.e0(iCodePointAt2);
                            } else {
                                c0694i2.b0(str, iCharCount, Character.charCount(iCodePointAt2) + iCharCount, charset2);
                            }
                            while (!c0694i2.s()) {
                                byte b4 = c0694i2.readByte();
                                int i12 = b4 & UByte.MAX_VALUE;
                                c0694i.V(37);
                                char[] cArr2 = J.f12721k;
                                c0694i.V(cArr2[(i12 >> 4) & 15]);
                                c0694i.V(cArr2[b4 & 15]);
                            }
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i11 = 127;
                    i9 = 32;
                    i10 = 43;
                }
                return c0694i.O();
            }
            iCharCount += Character.charCount(iCodePointAt);
            i8 = 128;
        }
        String strSubstring = str.substring(i7, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static void e(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i4), str).toString());
            }
            i4 = i5;
        }
    }

    public static void f(String str, String str2) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i4), str2), Util.isSensitiveHeader(str2) ? "" : Intrinsics.stringPlus(": ", str)).toString());
            }
            i4 = i5;
        }
    }

    public static int g(int i4, int i5, String str, boolean z4) {
        while (i4 < i5) {
            int i6 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt <= '9' && '0' <= cCharAt) || ((cCharAt <= 'z' && 'a' <= cCharAt) || ((cCharAt <= 'Z' && 'A' <= cCharAt) || cCharAt == ':'))) == (!z4)) {
                return i4;
            }
            i4 = i6;
        }
        return i5;
    }

    public static k3.l h(String str) {
        int i4;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = AbstractC0684F.f13338a;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i5 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i6 < length) {
                char cCharAt2 = str.charAt(i6);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i4 = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i4 = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i4 = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i6++;
                    } else {
                        i4 = 63;
                    }
                } else {
                    i4 = 62;
                }
                i8 = (i8 << 6) | i4;
                i7++;
                if (i7 % 4 == 0) {
                    bArrCopyOf[i9] = (byte) (i8 >> 16);
                    int i10 = i9 + 2;
                    bArrCopyOf[i9 + 1] = (byte) (i8 >> 8);
                    i9 += 3;
                    bArrCopyOf[i10] = (byte) i8;
                }
                i6++;
            } else {
                int i11 = i7 % 4;
                if (i11 != 1) {
                    if (i11 == 2) {
                        bArrCopyOf[i9] = (byte) ((i8 << 12) >> 16);
                        i9++;
                    } else if (i11 == 3) {
                        int i12 = i8 << 6;
                        int i13 = i9 + 1;
                        bArrCopyOf[i9] = (byte) (i12 >> 16);
                        i9 += 2;
                        bArrCopyOf[i13] = (byte) (i12 >> 8);
                    }
                    if (i9 != i5) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i9);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new k3.l(bArrCopyOf);
        }
        return null;
    }

    public static k3.l i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = (byte) (AbstractC0766b.a(str.charAt(i5 + 1)) + (AbstractC0766b.a(str.charAt(i5)) << 4));
        }
        return new k3.l(bArr);
    }

    public static int j(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (Intrinsics.areEqual(scheme, "http")) {
            return 80;
        }
        return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
    }

    public static k3.l k(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        k3.l lVar = new k3.l(bytes);
        lVar.f13361c = str;
        return lVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static h0 l(String javaName) {
        Intrinsics.checkNotNullParameter(javaName, "javaName");
        int iHashCode = javaName.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (javaName.equals("TLSv1.1")) {
                            return h0.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (javaName.equals("TLSv1.2")) {
                            return h0.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (javaName.equals("TLSv1.3")) {
                            return h0.TLS_1_3;
                        }
                        break;
                }
            } else if (javaName.equals("TLSv1")) {
                return h0.TLS_1_0;
            }
        } else if (javaName.equals("SSLv3")) {
            return h0.SSL_3_0;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected TLS version: ", javaName));
    }

    public static F m(SSLSession sSLSession) throws IOException {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(sSLSession, "<this>");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
        if (Intrinsics.areEqual(cipherSuite, "TLS_NULL_WITH_NULL_NULL") || Intrinsics.areEqual(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException(Intrinsics.stringPlus("cipherSuite == ", cipherSuite));
        }
        C0607p c0607pB = C0607p.f12942b.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null".toString());
        }
        if (Intrinsics.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        h0 h0VarL = l(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listEmptyList = peerCertificates != null ? Util.immutableListOf(Arrays.copyOf(peerCertificates, peerCertificates.length)) : CollectionsKt.emptyList();
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new F(h0VarL, c0607pB, localCertificates != null ? Util.immutableListOf(Arrays.copyOf(localCertificates, localCertificates.length)) : CollectionsKt.emptyList(), new E(1, listEmptyList));
    }

    public static J n(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        I i4 = new I();
        i4.e(null, str);
        return i4.c();
    }

    public static M o(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Matcher matcher = M.f12732d.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }
        String strGroup = matcher.group(1);
        Intrinsics.checkNotNullExpressionValue(strGroup, "typeSubtype.group(1)");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strGroup.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        Intrinsics.checkNotNullExpressionValue(strGroup2, "typeSubtype.group(2)");
        Intrinsics.checkNotNullExpressionValue(US, "US");
        Intrinsics.checkNotNullExpressionValue(strGroup2.toLowerCase(US), "this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = M.f12733e.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                throw new IllegalArgumentException(B0.g.q(sb, str, '\"').toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (StringsKt.y(strGroup4, "'") && StringsKt__StringsJVMKt.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new M(str, lowerCase, (String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static T p(String protocol) throws IOException {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        T t4 = T.HTTP_1_0;
        if (!Intrinsics.areEqual(protocol, "http/1.0")) {
            t4 = T.HTTP_1_1;
            if (!Intrinsics.areEqual(protocol, "http/1.1")) {
                t4 = T.H2_PRIOR_KNOWLEDGE;
                if (!Intrinsics.areEqual(protocol, "h2_prior_knowledge")) {
                    t4 = T.HTTP_2;
                    if (!Intrinsics.areEqual(protocol, "h2")) {
                        t4 = T.SPDY_3;
                        if (!Intrinsics.areEqual(protocol, "spdy/3.1")) {
                            t4 = T.QUIC;
                            if (!Intrinsics.areEqual(protocol, "quic")) {
                                throw new IOException(Intrinsics.stringPlus("Unexpected protocol: ", protocol));
                            }
                        }
                    }
                }
            }
        }
        return t4;
    }

    public static boolean q(int i4, int i5, String str) {
        int i6 = i4 + 2;
        return i6 < i5 && str.charAt(i4) == '%' && Util.parseHexDigit(str.charAt(i4 + 1)) != -1 && Util.parseHexDigit(str.charAt(i6)) != -1;
    }

    public static H r(String... namesAndValues) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        if (namesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        String[] strArr = (String[]) namesAndValues.clone();
        int length = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            String str = strArr[i5];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            strArr[i5] = StringsKt.trim((CharSequence) str).toString();
            i5 = i6;
        }
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                int i7 = i4 + 2;
                String str2 = strArr[i4];
                String str3 = strArr[i4 + 1];
                e(str2);
                f(str3, str2);
                if (i4 == progressionLastElement) {
                    break;
                }
                i4 = i7;
            }
        }
        return new H(strArr);
    }

    public static k3.l s(byte[] bArr) {
        k3.l lVar = k3.l.f13358d;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        AbstractC0685G.b(bArr.length, 0, length);
        return new k3.l(ArraysKt.copyOfRange(bArr, 0, length));
    }

    public static M t(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return o(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static C0612v u(long j4, J url, String setCookie) throws NumberFormatException {
        long j5;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setCookie, "setCookie");
        int iDelimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
        int iDelimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, iDelimiterOffset$default, 2, (Object) null);
        if (iDelimiterOffset$default2 == iDelimiterOffset$default) {
            return null;
        }
        String strTrimSubstring$default = Util.trimSubstring$default(setCookie, 0, iDelimiterOffset$default2, 1, null);
        if (strTrimSubstring$default.length() == 0 || Util.indexOfControlOrNonAscii(strTrimSubstring$default) != -1) {
            return null;
        }
        String strTrimSubstring = Util.trimSubstring(setCookie, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
        if (Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
            return null;
        }
        int i4 = iDelimiterOffset$default + 1;
        int length = setCookie.length();
        String str3 = null;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        long j6 = -1;
        long jV = DatesKt.MAX_DATE;
        String str4 = null;
        while (true) {
            long j7 = LongCompanionObject.MAX_VALUE;
            if (i4 >= length) {
                if (j6 == Long.MIN_VALUE) {
                    j5 = Long.MIN_VALUE;
                } else if (j6 != -1) {
                    if (j6 <= 9223372036854775L) {
                        j7 = j6 * 1000;
                    }
                    long j8 = j4 + j7;
                    j5 = (j8 < j4 || j8 > DatesKt.MAX_DATE) ? 253402300799999L : j8;
                } else {
                    j5 = jV;
                }
                String str5 = url.f12725d;
                if (str4 == null) {
                    str = str5;
                } else {
                    if (!Intrinsics.areEqual(str5, str4) && (!StringsKt__StringsJVMKt.endsWith$default(str5, str4, false, 2, null) || str5.charAt((str5.length() - str4.length()) - 1) != '.' || Util.canParseAsIpAddress(str5))) {
                        return null;
                    }
                    str = str4;
                }
                if (str5.length() != str.length() && PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(str) == null) {
                    return null;
                }
                String strSubstring = "/";
                String str6 = str3;
                if (str6 == null || !StringsKt.y(str6, "/")) {
                    String strB = url.b();
                    int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) strB, '/', 0, false, 6, (Object) null);
                    if (iLastIndexOf$default != 0) {
                        strSubstring = strB.substring(0, iLastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    str2 = strSubstring;
                } else {
                    str2 = str6;
                }
                return new C0612v(strTrimSubstring$default, strTrimSubstring, j5, str, str2, z4, z5, z6, z7);
            }
            int iDelimiterOffset = Util.delimiterOffset(setCookie, ';', i4, length);
            int iDelimiterOffset2 = Util.delimiterOffset(setCookie, '=', i4, iDelimiterOffset);
            String strTrimSubstring2 = Util.trimSubstring(setCookie, i4, iDelimiterOffset2);
            String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? Util.trimSubstring(setCookie, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
            if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "expires", true)) {
                try {
                    jV = v(strTrimSubstring3.length(), strTrimSubstring3);
                    z6 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "max-age", true)) {
                try {
                    long j9 = Long.parseLong(strTrimSubstring3);
                    j6 = j9 > 0 ? j9 : Long.MIN_VALUE;
                } catch (NumberFormatException e4) {
                    if (!new Regex("-?\\d+").matches(strTrimSubstring3)) {
                        throw e4;
                    }
                    if (StringsKt.y(strTrimSubstring3, "-")) {
                        j7 = Long.MIN_VALUE;
                    }
                    j6 = j7;
                }
                z6 = true;
            } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "domain", true)) {
                if (!(!StringsKt__StringsJVMKt.endsWith$default(strTrimSubstring3, ".", false, 2, null))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.removePrefix(strTrimSubstring3, (CharSequence) "."));
                if (canonicalHost == null) {
                    throw new IllegalArgumentException();
                }
                str4 = canonicalHost;
                z7 = false;
            } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "path", true)) {
                str3 = strTrimSubstring3;
            } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "secure", true)) {
                z4 = true;
            } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "httponly", true)) {
                z5 = true;
            }
            i4 = iDelimiterOffset + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long v(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.C0611u.v(int, java.lang.String):long");
    }

    public static String w(String str, int i4, int i5, boolean z4, int i6) {
        int i7;
        char[] cArr = J.f12721k;
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = str.length();
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        int iCharCount = i4;
        while (iCharCount < i5) {
            int i8 = iCharCount + 1;
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z4)) {
                C0694i c0694i = new C0694i();
                c0694i.c0(i4, iCharCount, str);
                while (iCharCount < i5) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i7 = iCharCount + 2) < i5) {
                        int hexDigit = Util.parseHexDigit(str.charAt(iCharCount + 1));
                        int hexDigit2 = Util.parseHexDigit(str.charAt(i7));
                        if (hexDigit == -1 || hexDigit2 == -1) {
                            c0694i.e0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            c0694i.V((hexDigit << 4) + hexDigit2);
                            iCharCount = Character.charCount(iCodePointAt) + i7;
                        }
                    } else if (iCodePointAt == 43 && z4) {
                        c0694i.V(32);
                        iCharCount++;
                    } else {
                        c0694i.e0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return c0694i.O();
            }
            iCharCount = i8;
        }
        String strSubstring = str.substring(i4, i5);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static ArrayList x(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 <= str.length()) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str, Typography.amp, i4, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = str.length();
            }
            int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', i4, false, 4, (Object) null);
            if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                String strSubstring = str.substring(i4, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i4, iIndexOf$default2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iIndexOf$default2 + 1, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i4 = iIndexOf$default + 1;
        }
        return arrayList;
    }

    public static void y(List list, StringBuilder out) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, list.size()), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            int i4 = first + step;
            String str = (String) list.get(first);
            String str2 = (String) list.get(first + 1);
            if (first > 0) {
                out.append(Typography.amp);
            }
            out.append(str);
            if (str2 != null) {
                out.append('=');
                out.append(str2);
            }
            if (first == last) {
                return;
            } else {
                first = i4;
            }
        }
    }

    @Override // m3.h
    public final void a(Level level, String str) {
        System.out.println("[" + level + "] " + str);
    }

    @Override // x3.e
    public final Object call(Object obj) {
        int i4 = this.f12973a;
        switch (i4) {
            case 20:
                Throwable th = (Throwable) obj;
                switch (i4) {
                    case 20:
                        E3.h.f420f.f().getClass();
                        return th;
                    default:
                        E3.h.f420f.a().getClass();
                        return th;
                }
            case 21:
                t3.b bVar = (t3.b) obj;
                E3.h.f420f.f().getClass();
                return bVar;
            case 22:
                Throwable th2 = (Throwable) obj;
                switch (i4) {
                    case 20:
                        E3.h.f420f.f().getClass();
                        return th2;
                    default:
                        E3.h.f420f.a().getClass();
                        return th2;
                }
            case 23:
                B0.g.y(obj);
                E3.h.f420f.a().getClass();
                return null;
            case 24:
                t3.a aVar = (t3.a) obj;
                E3.h.f420f.c().getClass();
                return aVar;
            case 25:
                B0.g.y(obj);
                E3.h.f420f.f().getClass();
                return null;
            case 26:
                B0.g.y(obj);
                E3.h.f420f.a().getClass();
                return null;
            default:
                t3.h hVar = (t3.h) obj;
                E3.h.f420f.c().getClass();
                return hVar;
        }
    }

    @Override // m3.h
    public final void d(Level level, String str, Throwable th) {
        PrintStream printStream = System.out;
        printStream.println("[" + level + "] " + str);
        th.printStackTrace(printStream);
    }

    @Override // q3.a
    public final String get(String str) {
        return null;
    }

    @Override // q3.a
    public final Map getCopyOfContextMap() {
        return null;
    }

    @Override // n3.InterfaceC0780a
    public final InterfaceC0781b getLogger(String str) {
        return o3.e.f13808a;
    }

    @Override // q3.a
    public final void put(String str, String str2) {
    }

    @Override // q3.a
    public final void remove(String str) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0611u(int i4, int i5) {
        this(0);
        this.f12973a = i4;
        switch (i4) {
            case 1:
                this(1);
                break;
            case 2:
                this(2);
                break;
            case 3:
                this(3);
                break;
            case 4:
                this(4);
                break;
            case 5:
                this(5);
                break;
            case 6:
                this(6);
                break;
            case 7:
                this(7);
                break;
            case 8:
                this(8);
                break;
            case 9:
                this(9);
                break;
            case 10:
                this(10);
                break;
            case 11:
                this(11);
                break;
            case 12:
                this(12);
                break;
            case 13:
                this(13);
                break;
            case 14:
                this(14);
                break;
            case 15:
                this(15);
                break;
            default:
                break;
        }
    }
}
