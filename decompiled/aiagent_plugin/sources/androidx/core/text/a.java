package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f1344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f1345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final a f1346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f1347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f1348e = null;
    private final boolean f;
    private final int g;
    private final d h;

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static final class C0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f1351c;

        public C0033a() {
            a(a.a(Locale.getDefault()));
        }

        private void a(boolean r1) {
            this.f1349a = r1;
            this.f1351c = a.f1344a;
            this.f1350b = 2;
        }

        private static a b(boolean r0) {
            if (r0 == false) goto L5;
            return a.f1346c;
        L5:
            return a.f1345b;
        }

        public a a() {
            if (this.f1350b != 2) goto L9;
            if (this.f1351c != a.f1344a) goto L9;
            return b(this.f1349a);
        L9:
            return new a(this.f1349a, this.f1350b, this.f1351c);
        }
    }

    /* JADX INFO: compiled from: BidiFormatter.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f1352a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f1353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f1354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1356e;
        private char f;

        static {
            f1352a = new byte[1792];
            int r1 = 0;
        L3:
            if (r1 >= 1792) goto L5;
            f1352a[r1] = Character.getDirectionality(r1);
            r1 = r1 + 1;
            goto L3
        }

        b(CharSequence r3, boolean r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            this.f1353b = r5;
            this.f1354c = r4;
            this.f1355d = r5.length();
        }

        int a() {
            this.f1356e = 0;
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
        L4:
            if (this.f1356e >= this.f1355d) goto L23;
            if (r3 != 0) goto L23;
            byte r6 = c();
            if (r6 == 0) goto L20;
            if (r6 == 1) goto L18;
            if (r6 == 2) goto L18;
            if (r6 == 9) goto L4;
            switch(r6) {
                case 14: goto L17;
                case 15: goto L17;
                case 16: goto L16;
                case 17: goto L16;
                case 18: goto L15;
                default: goto L22;
            };
        L16:
            r5 = r5 + 1;
            r4 = 1;
            goto L4
        L17:
            r5 = r5 + 1;
            r4 = -1;
        L22:
            r3 = r5;
            goto L4
        L15:
            r5 = r5 - 1;
            r4 = 0;
        L18:
            if (r5 != 0) goto L22;
            return 1;
        L20:
            if (r5 != 0) goto L22;
            return -1;
        L23:
            if (r3 != 0) goto L25;
            return 0;
        L25:
            if (r4 == 0) goto L28;
            return r4;
        L28:
            if (this.f1356e <= 0) goto L38;
            switch(d()) {
                case 14: goto L35;
                case 15: goto L35;
                case 16: goto L33;
                case 17: goto L33;
                case 18: goto L32;
                default: goto L28;
            };
        L32:
            r5 = r5 + 1;
            goto L28
        L33:
            if (r3 == r5) goto L34;
        L37:
            r5 = r5 - 1;
            goto L28
        L34:
            return 1;
        L35:
            if (r3 != r5) goto L37;
            return -1;
        L38:
            return 0;
        }

        int b() {
            this.f1356e = this.f1355d;
            int r1 = 0;
        L3:
            int r2 = r1;
        L5:
            if (this.f1356e <= 0) goto L31;
            byte r3 = d();
            if (r3 != 0) goto L9;
            if (r1 == 0) goto L28;
            if (r2 != 0) goto L5;
        L28:
            return -1;
        L9:
            if (r3 == 1) goto L23;
            if (r3 == 2) goto L23;
            if (r3 == 9) goto L5;
            switch(r3) {
                case 14: goto L20;
                case 15: goto L20;
                case 16: goto L18;
                case 17: goto L18;
                case 18: goto L17;
                default: goto L15;
            };
        L17:
            r1 = r1 + 1;
            goto L5
        L18:
            if (r2 == r1) goto L19;
        L22:
            r1 = r1 - 1;
            goto L5
        L19:
            return 1;
        L20:
            if (r2 != r1) goto L22;
            return -1;
        L15:
            if (r2 != 0) goto L5;
        L23:
            if (r1 == 0) goto L24;
            if (r2 != 0) goto L5;
        L24:
            return 1;
        L31:
            return 0;
        }

        private static byte a(char r1) {
            if (r1 >= 1792) goto L6;
            return f1352a[r1];
        L6:
            return Character.getDirectionality(r1);
        }

        byte c() {
            char r0 = this.f1353b.charAt(this.f1356e);
            this.f = r0;
            if (Character.isHighSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointAt(this.f1353b, this.f1356e);
            this.f1356e += Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.f1356e++;
            byte r2 = a(this.f);
            if (this.f1354c == false) goto L15;
            char r3 = this.f;
            if (r3 != '<') goto L12;
            return e();
        L12:
            if (r3 == '&') goto L14;
            return r2;
        L14:
            return g();
        L15:
            return r2;
        }

        byte d() {
            char r0 = this.f1353b.charAt(this.f1356e - 1);
            this.f = r0;
            if (Character.isLowSurrogate(r0) == false) goto L6;
            int r1 = Character.codePointBefore(this.f1353b, this.f1356e);
            this.f1356e -= Character.charCount(r1);
            return Character.getDirectionality(r1);
        L6:
            this.f1356e--;
            byte r2 = a(this.f);
            if (this.f1354c == false) goto L15;
            char r3 = this.f;
            if (r3 != '>') goto L12;
            return f();
        L12:
            if (r3 == ';') goto L14;
            return r2;
        L14:
            return h();
        L15:
            return r2;
        }

        private byte e() {
            int r0 = this.f1356e;
        L3:
            int r1 = this.f1356e;
            if (r1 >= this.f1355d) goto L18;
            CharSequence r2 = this.f1353b;
            this.f1356e = r1 + 1;
            char r3 = r2.charAt(r1);
            this.f = r3;
            if (r3 == '>') goto L7;
            if (r3 == '\"') goto L13;
            if (r3 != '\'') goto L3;
        L13:
            int r4 = this.f1356e;
            if (r4 >= this.f1355d) goto L3;
            CharSequence r5 = this.f1353b;
            this.f1356e = r4 + 1;
            char r6 = r5.charAt(r4);
            this.f = r6;
            if (r6 == r3) goto L3;
        L7:
            return 12;
        L18:
            this.f1356e = r0;
            this.f = '<';
            return 13;
        }

        private byte f() {
            int r0 = this.f1356e;
        L3:
            int r1 = this.f1356e;
            if (r1 <= 0) goto L20;
            CharSequence r3 = this.f1353b;
            int r2 = r1 - 1;
            this.f1356e = r2;
            char r4 = r3.charAt(r2);
            this.f = r4;
            if (r4 == '<') goto L7;
            if (r4 == '>') goto L20;
            if (r4 == '\"') goto L15;
            if (r4 != '\'') goto L3;
        L15:
            int r5 = this.f1356e;
            if (r5 <= 0) goto L3;
            CharSequence r6 = this.f1353b;
            int r7 = r5 - 1;
            this.f1356e = r7;
            char r8 = r6.charAt(r7);
            this.f = r8;
            if (r8 == r4) goto L3;
        L7:
            return 12;
        L20:
            this.f1356e = r0;
            this.f = '>';
            return 13;
        }

        private byte g() {
        L2:
            int r0 = this.f1356e;
            if (r0 >= this.f1355d) goto L7;
            CharSequence r1 = this.f1353b;
            this.f1356e = r0 + 1;
            char r2 = r1.charAt(r0);
            this.f = r2;
            if (r2 != ';') goto L2;
            return 12;
        L7:
            return 12;
        }

        private byte h() {
            int r0 = this.f1356e;
        L3:
            int r1 = this.f1356e;
            if (r1 <= 0) goto L10;
            CharSequence r3 = this.f1353b;
            int r2 = r1 - 1;
            this.f1356e = r2;
            char r4 = r3.charAt(r2);
            this.f = r4;
            if (r4 == '&') goto L7;
            if (r4 != ';') goto L3;
        L7:
            return 12;
        L10:
            this.f1356e = r0;
            this.f = ';';
            return 13;
        }
    }

    static {
        d r0 = e.f1361c;
        f1344a = r0;
        f1347d = Character.toString(8206);
        f1348e = Character.toString(8207);
        f1345b = new a(false, 2, r0);
        f1346c = new a(true, 2, r0);
    }

    public static a a() {
        return new C0033a().a();
    }

    a(boolean r3, int r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.f = r3;
        this.g = r4;
        this.h = r6;
    }

    public boolean b() {
        if ((this.g & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private String a(CharSequence r3, d r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r6 = ((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")).a(r5, 0, r5.length());
        if (this.f == true) goto L10;
        if (r6 == true) goto L8;
        if (b(r5) != 1) goto L10;
    L8:
        return f1347d;
    L10:
        if (this.f == false) goto L16;
        if (r6 == false) goto L15;
        if (b(r5) == (-1)) goto L15;
        return "";
    L15:
        return f1348e;
    L16:
        return "";
    }

    private String b(CharSequence r3, d r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r6 = ((d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")).a(r5, 0, r5.length());
        if (this.f == true) goto L10;
        if (r6 == true) goto L8;
        if (c(r5) != 1) goto L10;
    L8:
        return f1347d;
    L10:
        if (this.f == false) goto L16;
        if (r6 == false) goto L15;
        if (c(r5) == (-1)) goto L15;
        return "";
    L15:
        return f1348e;
    L16:
        return "";
    }

    public String a(String r3, d r4, boolean r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return a(r3, r6, r5).toString();
    }

    public CharSequence a(CharSequence r3, d r4, boolean r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        boolean r8 = r7.a(r6, 0, r6.length());
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (b() == false) goto L14;
        if (r5 == false) goto L14;
        if (r8 == false) goto L11;
        d r1 = e.f1360b;
    L12:
        r0.append(b(r6, r1));
        goto L14
    L11:
        r1 = e.f1359a;
    L14:
        if (r8 == this.f) goto L19;
        if (r8 == false) goto L17;
        char r2 = 8235;
    L18:
        r0.append(r2);
        r0.append(r6);
        r0.append(8236);
    L20:
        if (r5 == false) goto L25;
        if (r8 == false) goto L23;
        d r9 = e.f1360b;
    L24:
        r0.append(a(r6, r9));
        goto L25
    L23:
        r9 = e.f1359a;
    L25:
        return r0;
    L17:
        r2 = 8234;
        goto L18
    L19:
        r0.append(r6);
        goto L20
    }

    public String a(String r3) {
        return a(r3, this.h, true);
    }

    public CharSequence a(CharSequence r3) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), this.h, true);
    }

    static boolean a(Locale r1) {
        if (f.a(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static int b(CharSequence r2) {
        return new b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), false).b();
    }

    private static int c(CharSequence r2) {
        return new b((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), false).a();
    }
}
