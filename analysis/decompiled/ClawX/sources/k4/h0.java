package k4;

import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Serializable(with = i0.class)
/* loaded from: classes.dex */
public final class h0 implements java.io.Serializable {
    public static final g0 Companion = new g0();

    /* renamed from: a, reason: collision with root package name */
    public final String f3613a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3614b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3615c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3616e;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f3617f;

    /* renamed from: g, reason: collision with root package name */
    public final e0 f3618g;

    /* renamed from: h, reason: collision with root package name */
    public final b5.k f3619h;

    /* renamed from: j, reason: collision with root package name */
    public final b5.k f3620j;

    public h0(e0 e0Var, String host, int i8, ArrayList arrayList, a0 parameters, String fragment, String str, String str2, String str3) {
        kotlin.jvm.internal.p.e(host, "host");
        kotlin.jvm.internal.p.e(parameters, "parameters");
        kotlin.jvm.internal.p.e(fragment, "fragment");
        this.f3613a = host;
        this.f3614b = i8;
        this.f3615c = str;
        this.d = str2;
        this.f3616e = str3;
        if (i8 < 0 || i8 >= 65536) {
            throw new IllegalArgumentException(a8.b.j(i8, "Port must be between 0 and 65535, or 0 if not set. Provided: ").toString());
        }
        b8.h.x(new b7.c(15, arrayList));
        this.f3617f = e0Var;
        this.f3618g = e0Var == null ? e0.f3605c : e0Var;
        b8.h.x(new com.stepos.stepclaw.memory.lightmem.f(arrayList, 3, this));
        final int i9 = 0;
        b8.h.x(new p5.a(this) { // from class: k4.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f3610b;

            {
                this.f3610b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i10 = i9;
                h0 h0Var = this.f3610b;
                switch (i10) {
                    case 0:
                        String str4 = h0Var.f3616e;
                        int iQ1 = x5.n.q1(str4, '?', 0, 6) + 1;
                        if (iQ1 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ12 = x5.n.q1(str4, '#', iQ1, 4);
                        if (iQ12 == -1) {
                            String strSubstring = str4.substring(iQ1);
                            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str4.substring(iQ1, iQ12);
                        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        String str5 = h0Var.f3616e;
                        int iQ13 = x5.n.q1(str5, '/', h0Var.f3618g.f3606a.length() + 3, 4);
                        if (iQ13 == -1) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ14 = x5.n.q1(str5, '#', iQ13, 4);
                        if (iQ14 == -1) {
                            String strSubstring3 = str5.substring(iQ13);
                            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str5.substring(iQ13, iQ14);
                        kotlin.jvm.internal.p.d(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str6 = h0Var.f3616e;
                        String str7 = h0Var.f3615c;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int length = h0Var.f3618g.f3606a.length() + 3;
                        String strSubstring5 = str6.substring(length, x5.n.s1(str6, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false));
                        kotlin.jvm.internal.p.d(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str8 = h0Var.f3616e;
                        String str9 = h0Var.d;
                        if (str9 == null) {
                            return null;
                        }
                        if (str9.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring6 = str8.substring(x5.n.q1(str8, AbstractJsonLexerKt.COLON, h0Var.f3618g.f3606a.length() + 3, 4) + 1, x5.n.q1(str8, '@', 0, 6));
                        kotlin.jvm.internal.p.d(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        String str10 = h0Var.f3616e;
                        int iQ15 = x5.n.q1(str10, '#', 0, 6) + 1;
                        if (iQ15 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring7 = str10.substring(iQ15);
                        kotlin.jvm.internal.p.d(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i10 = 1;
        b8.h.x(new p5.a(this) { // from class: k4.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f3610b;

            {
                this.f3610b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i102 = i10;
                h0 h0Var = this.f3610b;
                switch (i102) {
                    case 0:
                        String str4 = h0Var.f3616e;
                        int iQ1 = x5.n.q1(str4, '?', 0, 6) + 1;
                        if (iQ1 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ12 = x5.n.q1(str4, '#', iQ1, 4);
                        if (iQ12 == -1) {
                            String strSubstring = str4.substring(iQ1);
                            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str4.substring(iQ1, iQ12);
                        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        String str5 = h0Var.f3616e;
                        int iQ13 = x5.n.q1(str5, '/', h0Var.f3618g.f3606a.length() + 3, 4);
                        if (iQ13 == -1) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ14 = x5.n.q1(str5, '#', iQ13, 4);
                        if (iQ14 == -1) {
                            String strSubstring3 = str5.substring(iQ13);
                            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str5.substring(iQ13, iQ14);
                        kotlin.jvm.internal.p.d(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str6 = h0Var.f3616e;
                        String str7 = h0Var.f3615c;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int length = h0Var.f3618g.f3606a.length() + 3;
                        String strSubstring5 = str6.substring(length, x5.n.s1(str6, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false));
                        kotlin.jvm.internal.p.d(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str8 = h0Var.f3616e;
                        String str9 = h0Var.d;
                        if (str9 == null) {
                            return null;
                        }
                        if (str9.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring6 = str8.substring(x5.n.q1(str8, AbstractJsonLexerKt.COLON, h0Var.f3618g.f3606a.length() + 3, 4) + 1, x5.n.q1(str8, '@', 0, 6));
                        kotlin.jvm.internal.p.d(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        String str10 = h0Var.f3616e;
                        int iQ15 = x5.n.q1(str10, '#', 0, 6) + 1;
                        if (iQ15 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring7 = str10.substring(iQ15);
                        kotlin.jvm.internal.p.d(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i11 = 2;
        this.f3619h = b8.h.x(new p5.a(this) { // from class: k4.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f3610b;

            {
                this.f3610b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i102 = i11;
                h0 h0Var = this.f3610b;
                switch (i102) {
                    case 0:
                        String str4 = h0Var.f3616e;
                        int iQ1 = x5.n.q1(str4, '?', 0, 6) + 1;
                        if (iQ1 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ12 = x5.n.q1(str4, '#', iQ1, 4);
                        if (iQ12 == -1) {
                            String strSubstring = str4.substring(iQ1);
                            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str4.substring(iQ1, iQ12);
                        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        String str5 = h0Var.f3616e;
                        int iQ13 = x5.n.q1(str5, '/', h0Var.f3618g.f3606a.length() + 3, 4);
                        if (iQ13 == -1) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ14 = x5.n.q1(str5, '#', iQ13, 4);
                        if (iQ14 == -1) {
                            String strSubstring3 = str5.substring(iQ13);
                            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str5.substring(iQ13, iQ14);
                        kotlin.jvm.internal.p.d(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str6 = h0Var.f3616e;
                        String str7 = h0Var.f3615c;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int length = h0Var.f3618g.f3606a.length() + 3;
                        String strSubstring5 = str6.substring(length, x5.n.s1(str6, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false));
                        kotlin.jvm.internal.p.d(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str8 = h0Var.f3616e;
                        String str9 = h0Var.d;
                        if (str9 == null) {
                            return null;
                        }
                        if (str9.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring6 = str8.substring(x5.n.q1(str8, AbstractJsonLexerKt.COLON, h0Var.f3618g.f3606a.length() + 3, 4) + 1, x5.n.q1(str8, '@', 0, 6));
                        kotlin.jvm.internal.p.d(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        String str10 = h0Var.f3616e;
                        int iQ15 = x5.n.q1(str10, '#', 0, 6) + 1;
                        if (iQ15 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring7 = str10.substring(iQ15);
                        kotlin.jvm.internal.p.d(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i12 = 3;
        this.f3620j = b8.h.x(new p5.a(this) { // from class: k4.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f3610b;

            {
                this.f3610b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i102 = i12;
                h0 h0Var = this.f3610b;
                switch (i102) {
                    case 0:
                        String str4 = h0Var.f3616e;
                        int iQ1 = x5.n.q1(str4, '?', 0, 6) + 1;
                        if (iQ1 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ12 = x5.n.q1(str4, '#', iQ1, 4);
                        if (iQ12 == -1) {
                            String strSubstring = str4.substring(iQ1);
                            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str4.substring(iQ1, iQ12);
                        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        String str5 = h0Var.f3616e;
                        int iQ13 = x5.n.q1(str5, '/', h0Var.f3618g.f3606a.length() + 3, 4);
                        if (iQ13 == -1) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ14 = x5.n.q1(str5, '#', iQ13, 4);
                        if (iQ14 == -1) {
                            String strSubstring3 = str5.substring(iQ13);
                            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str5.substring(iQ13, iQ14);
                        kotlin.jvm.internal.p.d(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str6 = h0Var.f3616e;
                        String str7 = h0Var.f3615c;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int length = h0Var.f3618g.f3606a.length() + 3;
                        String strSubstring5 = str6.substring(length, x5.n.s1(str6, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false));
                        kotlin.jvm.internal.p.d(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str8 = h0Var.f3616e;
                        String str9 = h0Var.d;
                        if (str9 == null) {
                            return null;
                        }
                        if (str9.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring6 = str8.substring(x5.n.q1(str8, AbstractJsonLexerKt.COLON, h0Var.f3618g.f3606a.length() + 3, 4) + 1, x5.n.q1(str8, '@', 0, 6));
                        kotlin.jvm.internal.p.d(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        String str10 = h0Var.f3616e;
                        int iQ15 = x5.n.q1(str10, '#', 0, 6) + 1;
                        if (iQ15 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring7 = str10.substring(iQ15);
                        kotlin.jvm.internal.p.d(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i13 = 4;
        b8.h.x(new p5.a(this) { // from class: k4.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f3610b;

            {
                this.f3610b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i102 = i13;
                h0 h0Var = this.f3610b;
                switch (i102) {
                    case 0:
                        String str4 = h0Var.f3616e;
                        int iQ1 = x5.n.q1(str4, '?', 0, 6) + 1;
                        if (iQ1 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ12 = x5.n.q1(str4, '#', iQ1, 4);
                        if (iQ12 == -1) {
                            String strSubstring = str4.substring(iQ1);
                            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str4.substring(iQ1, iQ12);
                        kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        String str5 = h0Var.f3616e;
                        int iQ13 = x5.n.q1(str5, '/', h0Var.f3618g.f3606a.length() + 3, 4);
                        if (iQ13 == -1) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int iQ14 = x5.n.q1(str5, '#', iQ13, 4);
                        if (iQ14 == -1) {
                            String strSubstring3 = str5.substring(iQ13);
                            kotlin.jvm.internal.p.d(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str5.substring(iQ13, iQ14);
                        kotlin.jvm.internal.p.d(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str6 = h0Var.f3616e;
                        String str7 = h0Var.f3615c;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        int length = h0Var.f3618g.f3606a.length() + 3;
                        String strSubstring5 = str6.substring(length, x5.n.s1(str6, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false));
                        kotlin.jvm.internal.p.d(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str8 = h0Var.f3616e;
                        String str9 = h0Var.d;
                        if (str9 == null) {
                            return null;
                        }
                        if (str9.length() == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring6 = str8.substring(x5.n.q1(str8, AbstractJsonLexerKt.COLON, h0Var.f3618g.f3606a.length() + 3, 4) + 1, x5.n.q1(str8, '@', 0, 6));
                        kotlin.jvm.internal.p.d(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        String str10 = h0Var.f3616e;
                        int iQ15 = x5.n.q1(str10, '#', 0, 6) + 1;
                        if (iQ15 == 0) {
                            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String strSubstring7 = str10.substring(iQ15);
                        kotlin.jvm.internal.p.d(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        return kotlin.jvm.internal.p.a(this.f3616e, ((h0) obj).f3616e);
    }

    public final int hashCode() {
        return this.f3616e.hashCode();
    }

    public final String toString() {
        return this.f3616e;
    }
}
