package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.Locale;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final e f9676d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f9677e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f9678f;

    /* renamed from: g, reason: collision with root package name */
    static final a f9679g;

    /* renamed from: h, reason: collision with root package name */
    static final a f9680h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f9681a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9682b;

    /* renamed from: c, reason: collision with root package name */
    private final e f9683c;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0119a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9684a;

        /* renamed from: b, reason: collision with root package name */
        private int f9685b;

        /* renamed from: c, reason: collision with root package name */
        private e f9686c;

        public C0119a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z5) {
            return z5 ? a.f9680h : a.f9679g;
        }

        private void c(boolean z5) {
            this.f9684a = z5;
            this.f9686c = a.f9676d;
            this.f9685b = 2;
        }

        public a a() {
            return (this.f9685b == 2 && this.f9686c == a.f9676d) ? b(this.f9684a) : new a(this.f9684a, this.f9685b, this.f9686c);
        }
    }

    private static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f9687f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f9688a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9689b;

        /* renamed from: c, reason: collision with root package name */
        private final int f9690c;

        /* renamed from: d, reason: collision with root package name */
        private int f9691d;

        /* renamed from: e, reason: collision with root package name */
        private char f9692e;

        static {
            for (int i5 = 0; i5 < 1792; i5++) {
                f9687f[i5] = Character.getDirectionality(i5);
            }
        }

        b(CharSequence charSequence, boolean z5) {
            this.f9688a = charSequence;
            this.f9689b = z5;
            this.f9690c = charSequence.length();
        }

        private static byte c(char c6) {
            return c6 < 1792 ? f9687f[c6] : Character.getDirectionality(c6);
        }

        private byte f() {
            char cCharAt;
            int i5 = this.f9691d;
            do {
                int i6 = this.f9691d;
                if (i6 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9688a;
                int i7 = i6 - 1;
                this.f9691d = i7;
                cCharAt = charSequence.charAt(i7);
                this.f9692e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f9691d = i5;
            this.f9692e = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i5 = this.f9691d;
                if (i5 >= this.f9690c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f9688a;
                this.f9691d = i5 + 1;
                cCharAt = charSequence.charAt(i5);
                this.f9692e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i5 = this.f9691d;
            while (true) {
                int i6 = this.f9691d;
                if (i6 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9688a;
                int i7 = i6 - 1;
                this.f9691d = i7;
                char cCharAt2 = charSequence.charAt(i7);
                this.f9692e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i8 = this.f9691d;
                        if (i8 > 0) {
                            CharSequence charSequence2 = this.f9688a;
                            int i9 = i8 - 1;
                            this.f9691d = i9;
                            cCharAt = charSequence2.charAt(i9);
                            this.f9692e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f9691d = i5;
            this.f9692e = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i5 = this.f9691d;
            while (true) {
                int i6 = this.f9691d;
                if (i6 >= this.f9690c) {
                    this.f9691d = i5;
                    this.f9692e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f9688a;
                this.f9691d = i6 + 1;
                char cCharAt2 = charSequence.charAt(i6);
                this.f9692e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i7 = this.f9691d;
                        if (i7 < this.f9690c) {
                            CharSequence charSequence2 = this.f9688a;
                            this.f9691d = i7 + 1;
                            cCharAt = charSequence2.charAt(i7);
                            this.f9692e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f9688a.charAt(this.f9691d - 1);
            this.f9692e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f9688a, this.f9691d);
                this.f9691d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f9691d--;
            byte bC = c(this.f9692e);
            if (this.f9689b) {
                char c6 = this.f9692e;
                if (c6 == '>') {
                    return h();
                }
                if (c6 == ';') {
                    return f();
                }
            }
            return bC;
        }

        byte b() {
            char cCharAt = this.f9688a.charAt(this.f9691d);
            this.f9692e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f9688a, this.f9691d);
                this.f9691d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f9691d++;
            byte bC = c(this.f9692e);
            if (this.f9689b) {
                char c6 = this.f9692e;
                if (c6 == '<') {
                    return i();
                }
                if (c6 == '&') {
                    return g();
                }
            }
            return bC;
        }

        int d() {
            this.f9691d = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (this.f9691d < this.f9690c && i5 == 0) {
                byte b6 = b();
                if (b6 != 0) {
                    if (b6 == 1 || b6 == 2) {
                        if (i7 == 0) {
                            return 1;
                        }
                    } else if (b6 != 9) {
                        switch (b6) {
                            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                            case 15:
                                i7++;
                                i6 = -1;
                                continue;
                            case 16:
                            case 17:
                                i7++;
                                i6 = 1;
                                continue;
                            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                                i7--;
                                i6 = 0;
                                continue;
                        }
                    }
                } else if (i7 == 0) {
                    return -1;
                }
                i5 = i7;
            }
            if (i5 == 0) {
                return 0;
            }
            if (i6 != 0) {
                return i6;
            }
            while (this.f9691d > 0) {
                switch (a()) {
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    case 15:
                        if (i5 == i7) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i5 == i7) {
                            return 1;
                        }
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                        i7++;
                        continue;
                }
                i7--;
            }
            return 0;
        }

        int e() {
            this.f9691d = this.f9690c;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                while (this.f9691d > 0) {
                    byte bA = a();
                    if (bA != 0) {
                        if (bA == 1 || bA == 2) {
                            if (i5 == 0) {
                                return 1;
                            }
                            if (i6 == 0) {
                                break;
                            }
                        } else if (bA != 9) {
                            switch (bA) {
                                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                                case 15:
                                    if (i6 == i5) {
                                        return -1;
                                    }
                                    i5--;
                                    break;
                                case 16:
                                case 17:
                                    if (i6 == i5) {
                                        return 1;
                                    }
                                    i5--;
                                    break;
                                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                                    i5++;
                                    break;
                                default:
                                    if (i6 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i5 == 0) {
                            return -1;
                        }
                        if (i6 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        e eVar = f.f9703c;
        f9676d = eVar;
        f9677e = Character.toString((char) 8206);
        f9678f = Character.toString((char) 8207);
        f9679g = new a(false, 2, eVar);
        f9680h = new a(true, 2, eVar);
    }

    a(boolean z5, int i5, e eVar) {
        this.f9681a = z5;
        this.f9682b = i5;
        this.f9683c = eVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0119a().a();
    }

    static boolean e(Locale locale) {
        return g.a(locale) == 1;
    }

    private String f(CharSequence charSequence, e eVar) {
        boolean zIsRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f9681a || !(zIsRtl || b(charSequence) == 1)) ? this.f9681a ? (!zIsRtl || b(charSequence) == -1) ? f9678f : BuildConfig.FLAVOR : BuildConfig.FLAVOR : f9677e;
    }

    private String g(CharSequence charSequence, e eVar) {
        boolean zIsRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f9681a || !(zIsRtl || a(charSequence) == 1)) ? this.f9681a ? (!zIsRtl || a(charSequence) == -1) ? f9678f : BuildConfig.FLAVOR : BuildConfig.FLAVOR : f9677e;
    }

    public boolean d() {
        return (this.f9682b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f9683c, true);
    }

    public CharSequence i(CharSequence charSequence, e eVar, boolean z5) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = eVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z5) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? f.f9702b : f.f9701a));
        }
        if (zIsRtl != this.f9681a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z5) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? f.f9702b : f.f9701a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f9683c, true);
    }

    public String k(String str, e eVar, boolean z5) {
        if (str == null) {
            return null;
        }
        return i(str, eVar, z5).toString();
    }
}
