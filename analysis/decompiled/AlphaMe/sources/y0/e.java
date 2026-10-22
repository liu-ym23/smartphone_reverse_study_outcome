package y0;

import G1.o;
import G1.p;
import android.widget.TextView;
import h3.C0607p;
import h3.C0611u;
import h3.H;
import h3.J;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import k3.l;
import k3.v;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import m2.n;

/* loaded from: classes.dex */
public final class e implements p, n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16171a;

    public e() {
        this.f16171a = 4;
    }

    public static final C0607p a(e eVar, String str) {
        C0607p c0607p = new C0607p(str);
        C0607p.f12944d.put(str, c0607p);
        return c0607p;
    }

    public static String c(J url) {
        Intrinsics.checkNotNullParameter(url, "url");
        l lVar = l.f13358d;
        return C0611u.k(url.f12730i).b("MD5").d();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h3.C0600i d(h3.H r25) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.e.d(h3.H):h3.i");
    }

    public static String e(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        l lVar = l.f13358d;
        byte[] encoded = certificate.getPublicKey().getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
        return Intrinsics.stringPlus("sha256/", C0611u.s(encoded).b("SHA-256").a());
    }

    public static int g(v source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            long jB = source.b();
            String strY = source.y(LongCompanionObject.MAX_VALUE);
            if (jB >= 0 && jB <= 2147483647L && strY.length() <= 0) {
                return (int) jB;
            }
            throw new IOException("expected an int but was \"" + jB + strY + '\"');
        } catch (NumberFormatException e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public static Set j(H h4) {
        int size = h4.size();
        TreeSet treeSet = null;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            if (StringsKt__StringsJVMKt.equals("Vary", h4.c(i4), true)) {
                String strF = h4.f(i4);
                if (treeSet == null) {
                    treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
                }
                Iterator it = StringsKt__StringsKt.split$default(strF, new char[]{','}, false, 0, 6, (Object) null).iterator();
                while (it.hasNext()) {
                    treeSet.add(StringsKt.trim((CharSequence) it.next()).toString());
                }
            }
            i4 = i5;
        }
        return treeSet == null ? SetsKt.emptySet() : treeSet;
    }

    public final synchronized C0607p b(String javaName) {
        C0607p c0607p;
        String strStringPlus;
        try {
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            LinkedHashMap linkedHashMap = C0607p.f12944d;
            c0607p = (C0607p) linkedHashMap.get(javaName);
            if (c0607p == null) {
                if (StringsKt.y(javaName, "TLS_")) {
                    String strSubstring = javaName.substring(4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    strStringPlus = Intrinsics.stringPlus("SSL_", strSubstring);
                } else if (StringsKt.y(javaName, "SSL_")) {
                    String strSubstring2 = javaName.substring(4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    strStringPlus = Intrinsics.stringPlus("TLS_", strSubstring2);
                } else {
                    strStringPlus = javaName;
                }
                c0607p = (C0607p) linkedHashMap.get(strStringPlus);
                if (c0607p == null) {
                    c0607p = new C0607p(javaName);
                }
                linkedHashMap.put(javaName, c0607p);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0607p;
    }

    @Override // m2.n
    public final void f(TextView textView, float f4) {
        textView.setTextSize(0, f4);
    }

    @Override // m2.n
    public final void h(TextView textView, int i4, int i5) {
        textView.measure(i4, i5);
    }

    @Override // G1.p
    public final Object i() {
        switch (this.f16171a) {
            case 6:
                return new TreeSet();
            case 7:
                return new LinkedHashSet();
            case 8:
                return new ArrayDeque();
            case 9:
                return new ArrayList();
            case 10:
                return new ConcurrentSkipListMap();
            case 11:
                return new ConcurrentHashMap();
            case 12:
                return new TreeMap();
            case 13:
                return new LinkedHashMap();
            default:
                return new o(true);
        }
    }

    public /* synthetic */ e(int i4) {
        this.f16171a = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i4, int i5) {
        this(0);
        this.f16171a = i4;
        int i6 = 1;
        if (i4 == 1) {
            this(i6);
            return;
        }
        int i7 = 2;
        if (i4 == 2) {
            this(i7);
            return;
        }
        int i8 = 3;
        if (i4 == 3) {
            this(i8);
            return;
        }
        int i9 = 15;
        if (i4 != 15) {
            switch (i4) {
                case 20:
                    this(20);
                    break;
                case 21:
                    this(21);
                    break;
                case 22:
                    this(22);
                    break;
                case 23:
                    this(23);
                    break;
                case 24:
                    this(24);
                    break;
                case 25:
                    this(25);
                    break;
                case 26:
                    this(26);
                    break;
                case 27:
                    this(27);
                    break;
                case 28:
                    this(28);
                    break;
                case 29:
                    this(29);
                    break;
                default:
                    break;
            }
            return;
        }
        this(i9);
    }
}
