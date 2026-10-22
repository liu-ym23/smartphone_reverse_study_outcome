package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EmojiCompat.g f3062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiCompat.GlyphChecker f3064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f3066e;

    public static final class a {
        public static int a(CharSequence r10, int r11, int r12) {
            int r13 = r10.length();
            if (r11 < 0) goto L30;
            if (r13 < r11) goto L30;
            if (r12 >= 0) goto L9;
            return -1;
        L9:
            boolean r14 = false;
        L10:
            if (r12 == 0) goto L11;
            r11 = r11 - 1;
            if (r11 < 0) goto L14;
            char r15 = r10.charAt(r11);
            if (r14 == true) goto L20;
            if (Character.isSurrogate(r15) == false) goto L25;
            if (Character.isHighSurrogate(r15) == true) goto L28;
            r14 = true;
            goto L10
        L28:
            return -1;
        L25:
            r12 = r12 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r15) == false) goto L21;
            r12 = r12 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r14 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r11;
        L30:
            return -1;
        }

        public static int b(CharSequence r10, int r11, int r12) {
            int r13 = r10.length();
            if (r11 < 0) goto L29;
            if (r13 < r11) goto L29;
            if (r12 >= 0) goto L9;
            return -1;
        L9:
            boolean r14 = false;
        L10:
            if (r12 == 0) goto L11;
            if (r11 >= r13) goto L13;
            char r15 = r10.charAt(r11);
            if (r14 == true) goto L19;
            if (Character.isSurrogate(r15) == false) goto L24;
            if (Character.isLowSurrogate(r15) == true) goto L27;
            r11 = r11 + 1;
            r14 = true;
            goto L10
        L27:
            return -1;
        L24:
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r15) == false) goto L20;
            r12 = r12 - 1;
            r11 = r11 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r14 == false) goto L15;
            return -1;
        L15:
            return r13;
        L11:
            return r11;
        L29:
            return -1;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j.a f3068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j.a f3069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j.a f3070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3071e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3072f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f3073g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f3074h;

        public b(j.a r10, boolean r11, int[] r12) {
            this.f3067a = 1;
            this.f3068b = r10;
            this.f3069c = r10;
            this.f3073g = r11;
            this.f3074h = r12;
        }

        public static boolean d(int r10) {
            if (r10 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean f(int r10) {
            if (r10 != 65038) goto L5;
            return true;
        L5:
            return false;
        }

        public int a(int r10) {
            j.a r11 = this.f3069c.a(r10);
            int r12 = 2;
            if (this.f3067a == 2) goto L7;
            if (r11 != null) goto L6;
            r12 = g();
        L25:
            this.f3071e = r10;
            return r12;
        L6:
            this.f3067a = 2;
            this.f3069c = r11;
            this.f3072f = 1;
            goto L25
        L7:
            if (r11 == null) goto L10;
            this.f3069c = r11;
            this.f3072f++;
            goto L25
        L10:
            if (f(r10) == false) goto L13;
            r12 = g();
            goto L25
        L13:
            if (d(r10) == true) goto L25;
            if (this.f3069c.b() == null) goto L24;
            r12 = 3;
            if (this.f3072f == 1) goto L20;
            this.f3070d = this.f3069c;
            g();
            goto L25
        L20:
            if (h() == false) goto L22;
            this.f3070d = this.f3069c;
            g();
            goto L25
        L22:
            r12 = g();
            goto L25
        L24:
            r12 = g();
            goto L25
        }

        public EmojiMetadata b() {
            return this.f3069c.b();
        }

        public EmojiMetadata c() {
            return this.f3070d.b();
        }

        public boolean e() {
            if (this.f3067a == 2) goto L5;
        L11:
            return false;
        L5:
            if (this.f3069c.b() == null) goto L11;
            if (this.f3072f <= 1) goto L9;
            return true;
        L9:
            if (h() == false) goto L11;
            return true;
        }

        public final int g() {
            this.f3067a = 1;
            this.f3069c = this.f3068b;
            this.f3072f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f3069c.b().j() == false) goto L6;
            return true;
        L6:
            if (d(this.f3071e) == false) goto L9;
            return true;
        L9:
            if (this.f3073g == true) goto L11;
        L16:
            return false;
        L11:
            if (this.f3074h != null) goto L13;
            return true;
        L13:
            int r10 = this.f3069c.b().b(0);
            if (Arrays.binarySearch(this.f3074h, r10) >= 0) goto L16;
            return true;
        }
    }

    public f(j r10, EmojiCompat.g r11, EmojiCompat.GlyphChecker r12, boolean r13, int[] r14) {
        this.f3062a = r11;
        this.f3063b = r10;
        this.f3064c = r12;
        this.f3065d = r13;
        this.f3066e = r14;
    }

    public static boolean b(Editable r10, KeyEvent r11, boolean r12) {
        if (g(r11) == false) goto L5;
        return false;
    L5:
        int r13 = Selection.getSelectionStart(r10);
        int r14 = Selection.getSelectionEnd(r10);
        if (f(r13, r14) == false) goto L8;
        return false;
    L8:
        g[] r15 = (g[]) r10.getSpans(r13, r14, g.class);
        if (r15 != null) goto L11;
    L24:
        return false;
    L11:
        if (r15.length <= 0) goto L24;
        int r16 = r15.length;
        int r17 = 0;
    L13:
        if (r17 >= r16) goto L24;
        g r18 = r15[r17];
        int r19 = r10.getSpanStart(r18);
        int r20 = r10.getSpanEnd(r18);
        if (r12 == false) goto L17;
        if (r19 != r13) goto L17;
    L21:
        r10.delete(r19, r20);
        return true;
    L17:
        if (r12 == true) goto L19;
        if (r20 == r13) goto L21;
    L19:
        if (r13 <= r19) goto L23;
        if (r13 < r20) goto L21;
    L23:
        r17 = r17 + 1;
        goto L13
    }

    public static boolean c(InputConnection r10, Editable r11, int r12, int r13, boolean r14) {
        if (r11 == null) goto L27;
        if (r10 == null) goto L27;
        if (r12 < 0) goto L27;
        if (r13 < 0) goto L27;
        int r15 = Selection.getSelectionStart(r11);
        int r16 = Selection.getSelectionEnd(r11);
        if (f(r15, r16) == false) goto L12;
        return false;
    L12:
        if (r14 == false) goto L17;
        int r17 = a.a(r11, r15, Math.max(r12, 0));
        int r18 = a.b(r11, r16, Math.max(r13, 0));
        if (r17 == (-1)) goto L16;
        if (r18 == (-1)) goto L16;
    L18:
        g[] r19 = (g[]) r11.getSpans(r17, r18, g.class);
        if (r19 == null) goto L27;
        if (r19.length <= 0) goto L27;
        int r20 = r19.length;
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L25;
        g r22 = r19[r21];
        int r23 = r11.getSpanStart(r22);
        int r24 = r11.getSpanEnd(r22);
        r17 = Math.min(r23, r17);
        r18 = Math.max(r24, r18);
        r21 = r21 + 1;
        goto L23
    L25:
        int r25 = Math.max(r17, 0);
        int r26 = Math.min(r18, r11.length());
        r10.beginBatchEdit();
        r11.delete(r25, r26);
        r10.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r17 = Math.max(r15 - r12, 0);
        r18 = Math.min(r16 + r13, r11.length());
    L27:
        return false;
    }

    public static boolean d(Editable r10, int r11, KeyEvent r12) {
        if (r11 != 67) goto L5;
        boolean r13 = b(r10, r12, false);
    L9:
        if (r13 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r10);
        return true;
    L12:
        return false;
    L5:
        if (r11 == 112) goto L7;
        r13 = false;
        goto L9
    L7:
        r13 = b(r10, r12, true);
        goto L9
    }

    public static boolean f(int r10, int r11) {
        if (r10 == (-1)) goto L8;
        if (r11 == (-1)) goto L8;
        if (r10 != r11) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean g(KeyEvent r10) {
        return !KeyEvent.metaStateHasNoModifiers(r10.getMetaState());
    }

    public final void a(Spannable r10, EmojiMetadata r11, int r12, int r13) {
        r10.setSpan(this.f3062a.a(r11), r12, r13, 33);
    }

    public final boolean e(CharSequence r10, int r11, int r12, EmojiMetadata r13) {
        if (r13.d() != 0) goto L6;
        r13.k(this.f3064c.hasGlyph(r10, r11, r12, r13.h()));
    L6:
        if (r13.d() != 2) goto L8;
        return true;
    L8:
        return false;
    }

    public CharSequence h(CharSequence r11, int r12, int r13, int r14, boolean r15) {
        boolean r10 = r11 instanceof k;
        if (r10 == false) goto L6;
        ((k) r11).a();
    L6:
        if (r10 == false) goto L86;
    L18:
        m r16 = new m((Spannable) r11);     // Catch: Throwable -> L15
    L20:
        if (r16 == null) goto L31;
        g[] r17 = (g[]) r16.getSpans(r12, r13, g.class);     // Catch: Throwable -> L15
        if (r17 == null) goto L31;
        if (r17.length <= 0) goto L31;
        int r18 = r17.length;     // Catch: Throwable -> L15
        int r19 = 0;
    L26:
        if (r19 >= r18) goto L31;
        g r20 = r17[r19];     // Catch: Throwable -> L15
        int r21 = r16.getSpanStart(r20);     // Catch: Throwable -> L15
        int r22 = r16.getSpanEnd(r20);     // Catch: Throwable -> L15
        if (r21 == r13) goto L30;
        r16.removeSpan(r20);     // Catch: Throwable -> L15
    L30:
        r12 = Math.min(r21, r12);     // Catch: Throwable -> L15
        r13 = Math.max(r22, r13);     // Catch: Throwable -> L15
        r19 = r19 + 1;     // Catch: Throwable -> L15
    L31:
        if (r12 != r13) goto L33;
    L80:
        if (r10 == false) goto L82;
        ((k) r11).d();
    L82:
        return r11;
    L33:
        if (r12 >= r11.length()) goto L80;
        if (r14 == Integer.MAX_VALUE) goto L39;
        if (r16 == null) goto L39;
        r14 = r14 - ((g[]) r16.getSpans(0, r16.length(), g.class)).length;     // Catch: Throwable -> L15
    L39:
        b r23 = new b(this.f3063b.f(), this.f3065d, this.f3066e);     // Catch: Throwable -> L15
        int r24 = Character.codePointAt(r11, r12);     // Catch: Throwable -> L15
        int r25 = 0;
        m r26 = r16;
    L40:
        int r27 = r12;
    L41:
        if (r12 >= r13) goto L64;
        if (r25 >= r14) goto L64;
        int r28 = r23.a(r24);     // Catch: Throwable -> L15
        if (r28 != 1) goto L46;
        r27 = r27 + Character.charCount(Character.codePointAt(r11, r27));     // Catch: Throwable -> L15
        if (r27 >= r13) goto L62;
        r24 = Character.codePointAt(r11, r27);     // Catch: Throwable -> L15
    L62:
        r12 = r27;
        goto L41
    L46:
        if (r28 != 2) goto L48;
        r12 = r12 + Character.charCount(r24);     // Catch: Throwable -> L15
        if (r12 >= r13) goto L41;
        r24 = Character.codePointAt(r11, r12);     // Catch: Throwable -> L15
        goto L41
    L48:
        if (r28 != 3) goto L41;
        if (r15 == true) goto L53;
        if (e(r11, r27, r12, r23.c()) == true) goto L40;
    L53:
        if (r26 != null) goto L55;
        r26 = new m(new SpannableString(r11));     // Catch: Throwable -> L15
    L55:
        a(r26, r23.c(), r27, r12);     // Catch: Throwable -> L15
        r25 = r25 + 1;     // Catch: Throwable -> L15
    L64:
        if (r23.e() == false) goto L72;
        if (r25 >= r14) goto L72;
        if (r15 == false) goto L68;
    L69:
        if (r26 != null) goto L71;
        r26 = new m(r11);     // Catch: Throwable -> L15
    L71:
        a(r26, r23.b(), r27, r12);     // Catch: Throwable -> L15
        goto L72
    L68:
        if (e(r11, r27, r12, r23.b()) == false) goto L69;
    L72:
        if (r26 == null) goto L77;
        Spannable r110 = r26.b();     // Catch: Throwable -> L15
        if (r10 == false) goto L76;
        ((k) r11).d();
    L76:
        return r110;
    L15:
        th = move-exception;
        if (r10 == false) goto L85;
        ((k) r11).d();
    L85:
        throw th;
    L77:
        if (r10 == false) goto L79;
        ((k) r11).d();
    L79:
        return r11;
    L86:
        if ((r11 instanceof Spannable) == true) goto L18;
        if ((r11 instanceof Spanned) == true) goto L13;
    L17:
        r16 = null;
        goto L20
    L13:
        if (((Spanned) r11).nextSpanTransition(r12 - 1, r13 + 1, g.class) > r13) goto L17;
        r16 = new m(r11);     // Catch: Throwable -> L15
        goto L20
    }
}
