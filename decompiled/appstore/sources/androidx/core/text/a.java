package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.google.common.base.Ascii;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2622d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2623e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2624f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f2625g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f2626h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextDirectionHeuristicCompat f2629c;

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    public static final class C0019a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextDirectionHeuristicCompat f2632c;

        public C0019a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean r10) {
            if (r10 == false) goto L5;
            return a.f2626h;
        L5:
            return a.f2625g;
        }

        public a a() {
            if (this.f2631b != 2) goto L9;
            if (this.f2632c != a.f2622d) goto L9;
            return b(this.f2630a);
        L9:
            return new a(this.f2630a, this.f2631b, this.f2632c);
        }

        public final void c(boolean r10) {
            this.f2630a = r10;
            this.f2632c = a.f2622d;
            this.f2631b = 2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f2633f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f2634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f2638e;

        static {
            f2633f = new byte[1792];
            int r10 = 0;
        L3:
            if (r10 >= 1792) goto L5;
            f2633f[r10] = Character.getDirectionality(r10);
            r10 = r10 + 1;
            goto L3
        }

        public b(CharSequence r10, boolean r11) {
            this.f2634a = r10;
            this.f2635b = r11;
            this.f2636c = r10.length();
        }

        public static byte c(char r10) {
            if (r10 >= 1792) goto L6;
            return f2633f[r10];
        L6:
            return Character.getDirectionality(r10);
        }

        public byte a() {
            char r10 = this.f2634a.charAt(this.f2637d - 1);
            this.f2638e = r10;
            if (Character.isLowSurrogate(r10) == false) goto L6;
            int r11 = Character.codePointBefore(this.f2634a, this.f2637d);
            this.f2637d -= Character.charCount(r11);
            return Character.getDirectionality(r11);
        L6:
            this.f2637d--;
            byte r12 = c(this.f2638e);
            if (this.f2635b == false) goto L15;
            char r13 = this.f2638e;
            if (r13 != '>') goto L12;
            return h();
        L12:
            if (r13 == ';') goto L14;
            return r12;
        L14:
            return f();
        L15:
            return r12;
        }

        public byte b() {
            char r10 = this.f2634a.charAt(this.f2637d);
            this.f2638e = r10;
            if (Character.isHighSurrogate(r10) == false) goto L6;
            int r11 = Character.codePointAt(this.f2634a, this.f2637d);
            this.f2637d += Character.charCount(r11);
            return Character.getDirectionality(r11);
        L6:
            this.f2637d++;
            byte r12 = c(this.f2638e);
            if (this.f2635b == false) goto L15;
            char r13 = this.f2638e;
            if (r13 != '<') goto L12;
            return i();
        L12:
            if (r13 == '&') goto L14;
            return r12;
        L14:
            return g();
        L15:
            return r12;
        }

        public int d() {
            this.f2637d = 0;
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L4:
            if (this.f2637d >= this.f2636c) goto L23;
            if (r10 != 0) goto L23;
            byte r13 = b();
            if (r13 == 0) goto L20;
            if (r13 == 1) goto L18;
            if (r13 == 2) goto L18;
            if (r13 == 9) goto L4;
            switch(r13) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r12 = r12 + 1;
            r11 = 1;
            goto L4
        L17:
            r12 = r12 + 1;
            r11 = -1;
        L22:
            r10 = r12;
            goto L4
        L15:
            r12 = r12 - 1;
            r11 = 0;
        L18:
            if (r12 != 0) goto L22;
            return 1;
        L20:
            if (r12 != 0) goto L22;
            return -1;
        L23:
            if (r10 != 0) goto L25;
            return 0;
        L25:
            if (r11 == 0) goto L28;
            return r11;
        L28:
            if (this.f2637d <= 0) goto L38;
            switch(a()) {
                case 14: goto L36;
                case 15: goto L36;
                case 16: goto L33;
                case 17: goto L33;
                case 18: goto L32;
                default: goto L28;
            };
        L32:
            r12 = r12 + 1;
            goto L28
        L33:
            if (r10 == r12) goto L34;
        L35:
            r12 = r12 - 1;
            goto L28
        L34:
            return 1;
        L36:
            if (r10 != r12) goto L35;
            return -1;
        L38:
            return 0;
        }

        public int e() {
            this.f2637d = this.f2636c;
            int r10 = 0;
        L3:
            int r11 = r10;
        L5:
            if (this.f2637d <= 0) goto L31;
            byte r12 = a();
            if (r12 != 0) goto L9;
            if (r10 == 0) goto L28;
            if (r11 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r12 == 1) goto L23;
            if (r12 == 2) goto L23;
            if (r12 == 9) goto L5;
            switch(r12) {
                case 14: goto L21;
                case 15: goto L21;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r10 = r10 + 1;
            goto L5
        L18:
            if (r11 == r10) goto L19;
        L20:
            r10 = r10 - 1;
            goto L5
        L19:
            return 1;
        L21:
            if (r11 != r10) goto L20;
            return -1;
        L15:
            if (r11 != 0) goto L5;
        L23:
            if (r10 == 0) goto L24;
            if (r11 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }

        public final byte f() {
            int r10 = this.f2637d;
        L3:
            int r11 = this.f2637d;
            if (r11 <= 0) goto L10;
            CharSequence r12 = this.f2634a;
            int r13 = r11 - 1;
            this.f2637d = r13;
            char r14 = r12.charAt(r13);
            this.f2638e = r14;
            if (r14 == '&') goto L7;
            if (r14 != ';') goto L3;
        L7:
            return Ascii.FF;
        L10:
            this.f2637d = r10;
            this.f2638e = ';';
            return Ascii.CR;
        }

        public final byte g() {
        L2:
            int r10 = this.f2637d;
            if (r10 >= this.f2636c) goto L7;
            CharSequence r11 = this.f2634a;
            this.f2637d = r10 + 1;
            char r12 = r11.charAt(r10);
            this.f2638e = r12;
            if (r12 != ';') goto L2;
            return Ascii.FF;
        L7:
            return Ascii.FF;
        }

        public final byte h() {
            int r10 = this.f2637d;
        L3:
            int r11 = this.f2637d;
            if (r11 <= 0) goto L20;
            CharSequence r12 = this.f2634a;
            int r13 = r11 - 1;
            this.f2637d = r13;
            char r14 = r12.charAt(r13);
            this.f2638e = r14;
            if (r14 == '<') goto L7;
            if (r14 == '>') goto L20;
            if (r14 == '\"') goto L15;
            if (r14 != '\'') goto L3;
        L15:
            int r15 = this.f2637d;
            if (r15 <= 0) goto L3;
            CharSequence r16 = this.f2634a;
            int r17 = r15 - 1;
            this.f2637d = r17;
            char r18 = r16.charAt(r17);
            this.f2638e = r18;
            if (r18 == r14) goto L3;
        L7:
            return Ascii.FF;
        L20:
            this.f2637d = r10;
            this.f2638e = '>';
            return Ascii.CR;
        }

        public final byte i() {
            int r10 = this.f2637d;
        L3:
            int r11 = this.f2637d;
            if (r11 >= this.f2636c) goto L18;
            CharSequence r12 = this.f2634a;
            this.f2637d = r11 + 1;
            char r13 = r12.charAt(r11);
            this.f2638e = r13;
            if (r13 == '>') goto L7;
            if (r13 == '\"') goto L13;
            if (r13 != '\'') goto L3;
        L13:
            int r14 = this.f2637d;
            if (r14 >= this.f2636c) goto L3;
            CharSequence r15 = this.f2634a;
            this.f2637d = r14 + 1;
            char r16 = r15.charAt(r14);
            this.f2638e = r16;
            if (r16 == r13) goto L3;
        L7:
            return Ascii.FF;
        L18:
            this.f2637d = r10;
            this.f2638e = '<';
            return Ascii.CR;
        }
    }

    static {
        TextDirectionHeuristicCompat r10 = TextDirectionHeuristicsCompat.f2612c;
        f2622d = r10;
        f2623e = Character.toString(8206);
        f2624f = Character.toString(8207);
        f2625g = new a(false, 2, r10);
        f2626h = new a(true, 2, r10);
    }

    public a(boolean r10, int r11, TextDirectionHeuristicCompat r12) {
        this.f2627a = r10;
        this.f2628b = r11;
        this.f2629c = r12;
    }

    public static int a(CharSequence r10) {
        return new b(r10, false).d();
    }

    public static int b(CharSequence r10) {
        return new b(r10, false).e();
    }

    public static a c() {
        return new C0019a().a();
    }

    public static boolean e(Locale r10) {
        if (d.a(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean d() {
        if ((this.f2628b & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String f(CharSequence r10, TextDirectionHeuristicCompat r11) {
        boolean r12 = r11.isRtl(r10, 0, r10.length());
        if (this.f2627a == true) goto L10;
        if (r12 == true) goto L8;
        if (b(r10) != 1) goto L10;
    L8:
        return f2623e;
    L10:
        if (this.f2627a == false) goto L16;
        if (r12 == false) goto L15;
        if (b(r10) == (-1)) goto L15;
        return "";
    L15:
        return f2624f;
    L16:
        return "";
    }

    public final String g(CharSequence r10, TextDirectionHeuristicCompat r11) {
        boolean r12 = r11.isRtl(r10, 0, r10.length());
        if (this.f2627a == true) goto L10;
        if (r12 == true) goto L8;
        if (a(r10) != 1) goto L10;
    L8:
        return f2623e;
    L10:
        if (this.f2627a == false) goto L16;
        if (r12 == false) goto L15;
        if (a(r10) == (-1)) goto L15;
        return "";
    L15:
        return f2624f;
    L16:
        return "";
    }

    public CharSequence h(CharSequence r10) {
        return i(r10, this.f2629c, true);
    }

    public CharSequence i(CharSequence r10, TextDirectionHeuristicCompat r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r13 = r11.isRtl(r10, 0, r10.length());
        SpannableStringBuilder r14 = new SpannableStringBuilder();
        if (d() == false) goto L13;
        if (r12 == false) goto L13;
        if (r13 == false) goto L10;
        TextDirectionHeuristicCompat r15 = TextDirectionHeuristicsCompat.f2611b;
    L11:
        r14.append(g(r10, r15));
        goto L13
    L10:
        r15 = TextDirectionHeuristicsCompat.f2610a;
    L13:
        if (r13 == this.f2627a) goto L18;
        if (r13 == false) goto L16;
        char r16 = 8235;
    L17:
        r14.append(r16);
        r14.append(r10);
        r14.append(8236);
    L19:
        if (r12 == false) goto L24;
        if (r13 == false) goto L22;
        TextDirectionHeuristicCompat r17 = TextDirectionHeuristicsCompat.f2611b;
    L23:
        r14.append(f(r10, r17));
        goto L24
    L22:
        r17 = TextDirectionHeuristicsCompat.f2610a;
    L24:
        return r14;
    L16:
        r16 = 8234;
        goto L17
    L18:
        r14.append(r10);
        goto L19
    }

    public String j(String r10) {
        return k(r10, this.f2629c, true);
    }

    public String k(String r10, TextDirectionHeuristicCompat r11, boolean r12) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return i(r10, r11, r12).toString();
    }
}
