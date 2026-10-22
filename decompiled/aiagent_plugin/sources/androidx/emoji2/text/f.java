package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: EmojiProcessor.java */
/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.i f1638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f1639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.InterfaceC0051d f1640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f1642e;

    /* JADX INFO: compiled from: EmojiProcessor.java */
    private static final class a {
        static int a(CharSequence r5, int r6, int r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            int r0 = r8.length();
            if (r6 < 0) goto L30;
            if (r0 < r6) goto L30;
            if (r7 >= 0) goto L9;
            return -1;
        L9:
            boolean r2 = false;
        L10:
            if (r7 == 0) goto L11;
            r6 = r6 - 1;
            if (r6 < 0) goto L14;
            char r3 = r8.charAt(r6);
            if (r2 == true) goto L20;
            if (Character.isSurrogate(r3) == false) goto L25;
            if (Character.isHighSurrogate(r3) == true) goto L28;
            r2 = true;
            goto L10
        L28:
            return -1;
        L25:
            r7 = r7 - 1;
            goto L10
        L20:
            if (Character.isHighSurrogate(r3) == false) goto L21;
            r7 = r7 - 1;
            goto L9
        L21:
            return -1;
        L14:
            if (r2 == false) goto L16;
            return -1;
        L16:
            return 0;
        L11:
            return r6;
        L30:
            return -1;
        }

        static int b(CharSequence r6, int r7, int r8) {
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
            int r0 = r9.length();
            if (r7 < 0) goto L29;
            if (r0 < r7) goto L29;
            if (r8 >= 0) goto L9;
            return -1;
        L9:
            boolean r3 = false;
        L10:
            if (r8 == 0) goto L11;
            if (r7 >= r0) goto L13;
            char r4 = r9.charAt(r7);
            if (r3 == true) goto L19;
            if (Character.isSurrogate(r4) == false) goto L24;
            if (Character.isLowSurrogate(r4) == true) goto L27;
            r7 = r7 + 1;
            r3 = true;
            goto L10
        L27:
            return -1;
        L24:
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L10
        L19:
            if (Character.isLowSurrogate(r4) == false) goto L20;
            r8 = r8 - 1;
            r7 = r7 + 1;
            goto L9
        L20:
            return -1;
        L13:
            if (r3 == false) goto L15;
            return -1;
        L15:
            return r0;
        L11:
            return r7;
        L29:
            return -1;
        }
    }

    /* JADX INFO: compiled from: EmojiProcessor.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i.a f1644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private i.a f1645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private i.a f1646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1647e;
        private int f;
        private final boolean g;
        private final int[] h;

        private static boolean b(int r1) {
            if (r1 != 65039) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean c(int r1) {
            if (r1 != 65038) goto L5;
            return true;
        L5:
            return false;
        }

        b(i.a r2, boolean r3, int[] r4) {
            this.f1643a = 1;
            this.f1644b = r2;
            this.f1645c = r2;
            this.g = r3;
            this.h = r4;
        }

        int a(int r6) {
            i.a r0 = this.f1645c.a(r6);
            int r2 = 3;
            if (this.f1643a == 2) goto L8;
            if (r0 != null) goto L6;
            r2 = d();
        L26:
            this.f1647e = r6;
            return r2;
        L6:
            this.f1643a = 2;
            this.f1645c = r0;
            this.f = 1;
        L7:
            r2 = 2;
            goto L26
        L8:
            if (r0 == null) goto L11;
            this.f1645c = r0;
            this.f++;
            goto L7
        L11:
            if (c(r6) == false) goto L14;
            r2 = d();
            goto L26
        L14:
            if (b(r6) == true) goto L7;
            if (this.f1645c.a() != null) goto L19;
            r2 = d();
            goto L26
        L19:
            if (this.f == 1) goto L21;
            this.f1646d = this.f1645c;
            d();
            goto L26
        L21:
            if (e() == false) goto L23;
            this.f1646d = this.f1645c;
            d();
            goto L26
        L23:
            r2 = d();
            goto L26
        }

        private int d() {
            this.f1643a = 1;
            this.f1645c = this.f1644b;
            this.f = 0;
            return 1;
        }

        e a() {
            return this.f1646d.a();
        }

        e b() {
            return this.f1645c.a();
        }

        boolean c() {
            if (this.f1643a == 2) goto L5;
        L11:
            return false;
        L5:
            if (this.f1645c.a() == null) goto L11;
            if (this.f <= 1) goto L9;
            return true;
        L9:
            if (e() == false) goto L11;
            return true;
        }

        private boolean e() {
            if (this.f1645c.a().f() == false) goto L6;
            return true;
        L6:
            if (b(this.f1647e) == false) goto L9;
            return true;
        L9:
            if (this.g == true) goto L11;
        L16:
            return false;
        L11:
            if (this.h != null) goto L13;
            return true;
        L13:
            int r0 = this.f1645c.a().a(0);
            if (Arrays.binarySearch(this.h, r0) >= 0) goto L16;
            return true;
        }
    }

    private static boolean a(int r1, int r2) {
        if (r1 == (-1)) goto L8;
        if (r2 == (-1)) goto L8;
        if (r1 != r2) goto L8;
        return false;
    L8:
        return true;
    }

    f(i r3, d.i r4, d.InterfaceC0051d r5, boolean r6, int[] r7) {
        d.InterfaceC0051d r8 = (d.InterfaceC0051d) ZeusTransformUtils.wrapperContextForParams(r5, d.InterfaceC0051d.class, "com.obric.aiagent.plugin");
        this.f1638a = r4;
        this.f1639b = r3;
        this.f1640c = r8;
        this.f1641d = r6;
        this.f1642e = r7;
    }

    CharSequence a(CharSequence r11, int r12, int r13, int r14, boolean r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = ZeusTransformUtils.instanceOf(r16, SpannableBuilder.class);
        if (r0 == false) goto L5;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.aiagent.plugin")).beginBatchEdit();
    L5:
        UnprecomputeTextOnModificationSpannable r2 = null;
        if (r0 == false) goto L84;
    L15:
        r2 = new UnprecomputeTextOnModificationSpannable((Spannable) ZeusTransformUtils.preCheckCast(r16, Spannable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L80
    L17:
        if (r2 == null) goto L28;
        EmojiSpan[] r4 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r2.getSpans(r12, r13, EmojiSpan.class), EmojiSpan[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L80
        if (r4 == null) goto L28;
        if (r4.length <= 0) goto L28;
        int r5 = r4.length;     // Catch: Throwable -> L80
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L28;
        EmojiSpan r7 = r4[r6];     // Catch: Throwable -> L80
        int r8 = r2.getSpanStart(r7);     // Catch: Throwable -> L80
        int r9 = r2.getSpanEnd(r7);     // Catch: Throwable -> L80
        if (r8 == r13) goto L27;
        r2.removeSpan(r7);     // Catch: Throwable -> L80
    L27:
        r12 = Math.min(r8, r12);     // Catch: Throwable -> L80
        r13 = Math.max(r9, r13);     // Catch: Throwable -> L80
        r6 = r6 + 1;     // Catch: Throwable -> L80
    L28:
        if (r12 != r13) goto L30;
    L77:
        if (r0 == false) goto L79;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.aiagent.plugin")).endBatchEdit();
    L79:
        return r16;
    L30:
        if (r12 >= r16.length()) goto L77;
        if (r14 == Integer.MAX_VALUE) goto L36;
        if (r2 == null) goto L36;
        r14 = r14 - ((EmojiSpan[]) ZeusTransformUtils.preCheckCast(r2.getSpans(0, r2.length(), EmojiSpan.class), EmojiSpan[].class, "com.obric.aiagent.plugin")).length;     // Catch: Throwable -> L80
    L36:
        b r10 = new b(this.f1639b.c(), this.f1641d, this.f1642e);     // Catch: Throwable -> L80
        int r17 = Character.codePointAt(r16, r12);     // Catch: Throwable -> L80
        int r18 = 0;
        UnprecomputeTextOnModificationSpannable r3 = r2;
    L37:
        int r19 = r12;
    L38:
        if (r12 >= r13) goto L61;
        if (r18 >= r14) goto L61;
        int r20 = r10.a(r17);     // Catch: Throwable -> L80
        if (r20 != 1) goto L43;
        r19 = r19 + Character.charCount(Character.codePointAt(r16, r19));     // Catch: Throwable -> L80
        if (r19 >= r13) goto L59;
        r17 = Character.codePointAt(r16, r19);     // Catch: Throwable -> L80
    L59:
        r12 = r19;
        goto L38
    L43:
        if (r20 != 2) goto L45;
        r12 = r12 + Character.charCount(r17);     // Catch: Throwable -> L80
        if (r12 >= r13) goto L38;
        r17 = Character.codePointAt(r16, r12);     // Catch: Throwable -> L80
        goto L38
    L45:
        if (r20 != 3) goto L38;
        if (r15 == true) goto L50;
        if (a(r16, r19, r12, r10.a()) == true) goto L37;
    L50:
        if (r3 != null) goto L52;
        r3 = new UnprecomputeTextOnModificationSpannable(new SpannableString(r16));     // Catch: Throwable -> L80
    L52:
        a(r3, r10.a(), r19, r12);     // Catch: Throwable -> L80
        r18 = r18 + 1;     // Catch: Throwable -> L80
    L61:
        if (r10.c() == false) goto L69;
        if (r18 >= r14) goto L69;
        if (r15 == false) goto L65;
    L66:
        if (r3 != null) goto L68;
        r3 = new UnprecomputeTextOnModificationSpannable(r16);     // Catch: Throwable -> L80
    L68:
        a(r3, r10.b(), r19, r12);     // Catch: Throwable -> L80
        goto L69
    L65:
        if (a(r16, r19, r12, r10.b()) == false) goto L66;
    L69:
        if (r3 == null) goto L74;
        Spannable r110 = r3.getUnwrappedSpannable();     // Catch: Throwable -> L80
        if (r0 == false) goto L73;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.aiagent.plugin")).endBatchEdit();
    L73:
        return r110;
    L80:
        th = move-exception;
        if (r0 == false) goto L83;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.aiagent.plugin")).endBatchEdit();
    L83:
        throw th;
    L74:
        if (r0 == false) goto L76;
        ((SpannableBuilder) ZeusTransformUtils.preCheckCast(r16, SpannableBuilder.class, "com.obric.aiagent.plugin")).endBatchEdit();
    L76:
        return r16;
    L84:
        if (ZeusTransformUtils.instanceOf(r16, Spannable.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r16, Spanned.class) == false) goto L17;
        if (((Spanned) ZeusTransformUtils.preCheckCast(r16, Spanned.class, "com.obric.aiagent.plugin")).nextSpanTransition(r12 - 1, r13 + 1, EmojiSpan.class) > r13) goto L17;
        r2 = new UnprecomputeTextOnModificationSpannable(r16);     // Catch: Throwable -> L80
        goto L17
    }

    static boolean a(Editable r3, int r4, KeyEvent r5) {
        Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
        if (r4 != 67) goto L5;
        boolean r7 = delete(r6, r5, false);
    L9:
        if (r7 == false) goto L12;
        MetaKeyKeyListener.adjustMetaAfterKeypress(r6);
        return true;
    L12:
        return false;
    L5:
        if (r4 == 112) goto L7;
        r7 = false;
        goto L9
    L7:
        r7 = delete(r6, r5, true);
        goto L9
    }

    private static boolean delete(Editable r6, KeyEvent r7, boolean r8) {
        Editable r9 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.aiagent.plugin");
        if (a(r7) == false) goto L5;
        return false;
    L5:
        int r10 = Selection.getSelectionStart(r9);
        int r2 = Selection.getSelectionEnd(r9);
        if (a(r10, r2) == false) goto L8;
        return false;
    L8:
        EmojiSpan[] r1 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r9.getSpans(r10, r2, EmojiSpan.class), EmojiSpan[].class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
    L24:
        return false;
    L11:
        if (r1.length <= 0) goto L24;
        int r3 = r1.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L24;
        EmojiSpan r5 = r1[r4];
        int r11 = r9.getSpanStart(r5);
        int r12 = r9.getSpanEnd(r5);
        if (r8 == false) goto L17;
        if (r11 != r10) goto L17;
    L21:
        r9.delete(r11, r12);
        return true;
    L17:
        if (r8 == true) goto L19;
        if (r12 == r10) goto L21;
    L19:
        if (r10 <= r11) goto L23;
        if (r10 < r12) goto L21;
    L23:
        r4 = r4 + 1;
        goto L13
    }

    static boolean a(InputConnection r5, Editable r6, int r7, int r8, boolean r9) {
        InputConnection r10 = (InputConnection) ZeusTransformUtils.wrapperContextForParams(r5, InputConnection.class, "com.obric.aiagent.plugin");
        Editable r11 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        if (r10 == null) goto L27;
        if (r7 < 0) goto L27;
        if (r8 < 0) goto L27;
        int r2 = Selection.getSelectionStart(r11);
        int r3 = Selection.getSelectionEnd(r11);
        if (a(r2, r3) == false) goto L12;
        return false;
    L12:
        if (r9 == false) goto L17;
        int r12 = a.a(r11, r2, Math.max(r7, 0));
        int r13 = a.b(r11, r3, Math.max(r8, 0));
        if (r12 == (-1)) goto L16;
        if (r13 == (-1)) goto L16;
    L18:
        EmojiSpan[] r14 = (EmojiSpan[]) ZeusTransformUtils.preCheckCast(r11.getSpans(r12, r13, EmojiSpan.class), EmojiSpan[].class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L27;
        if (r14.length <= 0) goto L27;
        int r1 = r14.length;
        int r4 = 0;
    L23:
        if (r4 >= r1) goto L25;
        EmojiSpan r15 = r14[r4];
        int r16 = r11.getSpanStart(r15);
        int r17 = r11.getSpanEnd(r15);
        r12 = Math.min(r16, r12);
        r13 = Math.max(r17, r13);
        r4 = r4 + 1;
        goto L23
    L25:
        int r18 = Math.max(r12, 0);
        int r19 = Math.min(r13, r11.length());
        r10.beginBatchEdit();
        r11.delete(r18, r19);
        r10.endBatchEdit();
        return true;
    L16:
        return false;
    L17:
        r12 = Math.max(r2 - r7, 0);
        r13 = Math.min(r3 + r8, r11.length());
    L27:
        return false;
    }

    private static boolean a(KeyEvent r0) {
        return !KeyEvent.metaStateHasNoModifiers(r0.getMetaState());
    }

    private void a(Spannable r3, e r4, int r5, int r6) {
        ((Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin")).setSpan(this.f1638a.a(r4), r5, r6, 33);
    }

    private boolean a(CharSequence r3, int r4, int r5, e r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6.e() != 0) goto L6;
        r6.a(this.f1640c.a(r7, r4, r5, r6.d()));
    L6:
        if (r6.e() != 2) goto L8;
        return true;
    L8:
        return false;
    }
}
