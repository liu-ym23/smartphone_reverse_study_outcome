package z0;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* renamed from: z0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6050a {

    /* renamed from: d, reason: collision with root package name */
    public static final d f44526d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f44527e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f44528f;

    /* renamed from: g, reason: collision with root package name */
    public static final C6050a f44529g;

    /* renamed from: h, reason: collision with root package name */
    public static final C6050a f44530h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f44531a;

    /* renamed from: b, reason: collision with root package name */
    public final int f44532b;

    /* renamed from: c, reason: collision with root package name */
    public final d f44533c;

    /* renamed from: z0.a$a, reason: collision with other inner class name */
    public static final class C0562a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f44534a;

        /* renamed from: b, reason: collision with root package name */
        public int f44535b;

        /* renamed from: c, reason: collision with root package name */
        public d f44536c;

        public C0562a() {
            c(C6050a.e(Locale.getDefault()));
        }

        public static C6050a b(boolean z10) {
            return z10 ? C6050a.f44530h : C6050a.f44529g;
        }

        public C6050a a() {
            return (this.f44535b == 2 && this.f44536c == C6050a.f44526d) ? b(this.f44534a) : new C6050a(this.f44534a, this.f44535b, this.f44536c);
        }

        public final void c(boolean z10) {
            this.f44534a = z10;
            this.f44536c = C6050a.f44526d;
            this.f44535b = 2;
        }
    }

    /* renamed from: z0.a$b */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f44537f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f44538a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f44539b;

        /* renamed from: c, reason: collision with root package name */
        public final int f44540c;

        /* renamed from: d, reason: collision with root package name */
        public int f44541d;

        /* renamed from: e, reason: collision with root package name */
        public char f44542e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f44537f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f44538a = charSequence;
            this.f44539b = z10;
            this.f44540c = charSequence.length();
        }

        public static byte c(char c10) {
            return c10 < 1792 ? f44537f[c10] : Character.getDirectionality(c10);
        }

        public byte a() {
            char cCharAt = this.f44538a.charAt(this.f44541d - 1);
            this.f44542e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f44538a, this.f44541d);
                this.f44541d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f44541d--;
            byte bC = c(this.f44542e);
            if (this.f44539b) {
                char c10 = this.f44542e;
                if (c10 == '>') {
                    return h();
                }
                if (c10 == ';') {
                    return f();
                }
            }
            return bC;
        }

        public byte b() {
            char cCharAt = this.f44538a.charAt(this.f44541d);
            this.f44542e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f44538a, this.f44541d);
                this.f44541d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f44541d++;
            byte bC = c(this.f44542e);
            if (this.f44539b) {
                char c10 = this.f44542e;
                if (c10 == '<') {
                    return i();
                }
                if (c10 == '&') {
                    return g();
                }
            }
            return bC;
        }

        public int d() {
            this.f44541d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f44541d < this.f44540c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f44541d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        public int e() {
            this.f44541d = this.f44540c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f44541d > 0) {
                    byte bA = a();
                    if (bA != 0) {
                        if (bA == 1 || bA == 2) {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                                break;
                            }
                        } else if (bA != 9) {
                            switch (bA) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    i10--;
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    i10--;
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i10 == 0) {
                            return -1;
                        }
                        if (i11 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char cCharAt;
            int i10 = this.f44541d;
            do {
                int i11 = this.f44541d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f44538a;
                int i12 = i11 - 1;
                this.f44541d = i12;
                cCharAt = charSequence.charAt(i12);
                this.f44542e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f44541d = i10;
            this.f44542e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i10 = this.f44541d;
                if (i10 >= this.f44540c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f44538a;
                this.f44541d = i10 + 1;
                cCharAt = charSequence.charAt(i10);
                this.f44542e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i10 = this.f44541d;
            while (true) {
                int i11 = this.f44541d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f44538a;
                int i12 = i11 - 1;
                this.f44541d = i12;
                char cCharAt2 = charSequence.charAt(i12);
                this.f44542e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i13 = this.f44541d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f44538a;
                            int i14 = i13 - 1;
                            this.f44541d = i14;
                            cCharAt = charSequence2.charAt(i14);
                            this.f44542e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f44541d = i10;
            this.f44542e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i10 = this.f44541d;
            while (true) {
                int i11 = this.f44541d;
                if (i11 >= this.f44540c) {
                    this.f44541d = i10;
                    this.f44542e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f44538a;
                this.f44541d = i11 + 1;
                char cCharAt2 = charSequence.charAt(i11);
                this.f44542e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i12 = this.f44541d;
                        if (i12 < this.f44540c) {
                            CharSequence charSequence2 = this.f44538a;
                            this.f44541d = i12 + 1;
                            cCharAt = charSequence2.charAt(i12);
                            this.f44542e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        d dVar = e.f44553c;
        f44526d = dVar;
        f44527e = Character.toString((char) 8206);
        f44528f = Character.toString((char) 8207);
        f44529g = new C6050a(false, 2, dVar);
        f44530h = new C6050a(true, 2, dVar);
    }

    public C6050a(boolean z10, int i10, d dVar) {
        this.f44531a = z10;
        this.f44532b = i10;
        this.f44533c = dVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static C6050a c() {
        return new C0562a().a();
    }

    public static boolean e(Locale locale) {
        return f.a(locale) == 1;
    }

    public boolean d() {
        return (this.f44532b & 2) != 0;
    }

    public final String f(CharSequence charSequence, d dVar) {
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f44531a || !(zIsRtl || b(charSequence) == 1)) ? this.f44531a ? (!zIsRtl || b(charSequence) == -1) ? f44528f : "" : "" : f44527e;
    }

    public final String g(CharSequence charSequence, d dVar) {
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f44531a || !(zIsRtl || a(charSequence) == 1)) ? this.f44531a ? (!zIsRtl || a(charSequence) == -1) ? f44528f : "" : "" : f44527e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f44533c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = dVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? e.f44552b : e.f44551a));
        }
        if (zIsRtl != this.f44531a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? e.f44552b : e.f44551a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f44533c, true);
    }

    public String k(String str, d dVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z10).toString();
    }
}
