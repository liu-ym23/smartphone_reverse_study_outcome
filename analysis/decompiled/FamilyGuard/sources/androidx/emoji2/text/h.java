package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.m;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final e.j f10331a;

    /* renamed from: b, reason: collision with root package name */
    private final m f10332b;

    /* renamed from: c, reason: collision with root package name */
    private e.InterfaceC0131e f10333c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f10334d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f10335e;

    private static final class a {
        static int a(CharSequence charSequence, int i5, int i6) {
            int length = charSequence.length();
            if (i5 < 0 || length < i5 || i6 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i6 != 0) {
                    i5--;
                    if (i5 < 0) {
                        return z5 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i5);
                    if (z5) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i6--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i6--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z5 = true;
                    }
                }
                return i5;
            }
        }

        static int b(CharSequence charSequence, int i5, int i6) {
            int length = charSequence.length();
            if (i5 < 0 || length < i5 || i6 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i6 != 0) {
                    if (i5 >= length) {
                        if (z5) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i5);
                    if (z5) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i6--;
                        i5++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i6--;
                        i5++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i5++;
                        z5 = true;
                    }
                }
                return i5;
            }
        }
    }

    private static class b implements c<q> {

        /* renamed from: a, reason: collision with root package name */
        public q f10336a;

        /* renamed from: b, reason: collision with root package name */
        private final e.j f10337b;

        b(q qVar, e.j jVar) {
            this.f10336a = qVar;
            this.f10337b = jVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i5, int i6, o oVar) {
            if (oVar.k()) {
                return true;
            }
            if (this.f10336a == null) {
                this.f10336a = new q(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f10336a.setSpan(this.f10337b.a(oVar), i5, i6, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public q a() {
            return this.f10336a;
        }
    }

    private interface c<T> {
        T a();

        boolean b(CharSequence charSequence, int i5, int i6, o oVar);
    }

    private static class d implements c<d> {

        /* renamed from: a, reason: collision with root package name */
        private final String f10338a;

        d(String str) {
            this.f10338a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i5, int i6, o oVar) {
            if (!TextUtils.equals(charSequence.subSequence(i5, i6), this.f10338a)) {
                return true;
            }
            oVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        private int f10339a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f10340b;

        /* renamed from: c, reason: collision with root package name */
        private m.a f10341c;

        /* renamed from: d, reason: collision with root package name */
        private m.a f10342d;

        /* renamed from: e, reason: collision with root package name */
        private int f10343e;

        /* renamed from: f, reason: collision with root package name */
        private int f10344f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f10345g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f10346h;

        e(m.a aVar, boolean z5, int[] iArr) {
            this.f10340b = aVar;
            this.f10341c = aVar;
            this.f10345g = z5;
            this.f10346h = iArr;
        }

        private static boolean d(int i5) {
            return i5 == 65039;
        }

        private static boolean f(int i5) {
            return i5 == 65038;
        }

        private int g() {
            this.f10339a = 1;
            this.f10341c = this.f10340b;
            this.f10344f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f10341c.b().j() || d(this.f10343e)) {
                return true;
            }
            if (this.f10345g) {
                if (this.f10346h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f10346h, this.f10341c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i5) {
            m.a aVarA = this.f10341c.a(i5);
            int iG = 2;
            if (this.f10339a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f10339a = 2;
                    this.f10341c = aVarA;
                    this.f10344f = 1;
                }
            } else if (aVarA != null) {
                this.f10341c = aVarA;
                this.f10344f++;
            } else if (f(i5)) {
                iG = g();
            } else if (!d(i5)) {
                if (this.f10341c.b() != null) {
                    iG = 3;
                    if (this.f10344f != 1 || h()) {
                        this.f10342d = this.f10341c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f10343e = i5;
            return iG;
        }

        o b() {
            return this.f10341c.b();
        }

        o c() {
            return this.f10342d.b();
        }

        boolean e() {
            if (this.f10339a != 2 || this.f10341c.b() == null) {
                return false;
            }
            return this.f10344f > 1 || h();
        }
    }

    h(m mVar, e.j jVar, e.InterfaceC0131e interfaceC0131e, boolean z5, int[] iArr, Set<int[]> set) {
        this.f10331a = jVar;
        this.f10332b = mVar;
        this.f10333c = interfaceC0131e;
        this.f10334d = z5;
        this.f10335e = iArr;
        g(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z5) {
        i[] iVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z5 && spanStart == selectionStart) || ((!z5 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean b(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i5 >= 0 && i6 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z5) {
                iMax = a.a(editable, selectionStart, Math.max(i5, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i6, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i5, 0);
                iMin = Math.min(selectionEnd + i6, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(iMax, iMin, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean c(Editable editable, int i5, KeyEvent keyEvent) {
        if (!(i5 != 67 ? i5 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean d(CharSequence charSequence, int i5, int i6, o oVar) {
        if (oVar.d() == 0) {
            oVar.m(this.f10333c.a(charSequence, i5, i6, oVar.h()));
        }
        return oVar.d() == 2;
    }

    private static boolean e(int i5, int i6) {
        return i5 == -1 || i6 == -1 || i5 != i6;
    }

    private static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void g(Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    private <T> T i(CharSequence charSequence, int i5, int i6, int i7, boolean z5, c<T> cVar) {
        int iCharCount;
        e eVar = new e(this.f10332b.f(), this.f10334d, this.f10335e);
        int i8 = 0;
        boolean zB = true;
        int iCodePointAt = Character.codePointAt(charSequence, i5);
        loop0: while (true) {
            iCharCount = i5;
            while (i5 < i6 && i8 < i7 && zB) {
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i6) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i5 = iCharCount;
                } else if (iA == 2) {
                    i5 += Character.charCount(iCodePointAt);
                    if (i5 < i6) {
                        iCodePointAt = Character.codePointAt(charSequence, i5);
                    }
                } else if (iA == 3) {
                    if (z5 || !d(charSequence, iCharCount, i5, eVar.c())) {
                        zB = cVar.b(charSequence, iCharCount, i5, eVar.c());
                        i8++;
                    }
                }
            }
            break loop0;
        }
        if (eVar.e() && i8 < i7 && zB && (z5 || !d(charSequence, iCharCount, i5, eVar.b()))) {
            cVar.b(charSequence, iCharCount, i5, eVar.b());
        }
        return cVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[Catch: all -> 0x002a, TRY_ENTER, TryCatch #2 {all -> 0x002a, blocks: (B:7:0x000e, B:10:0x0013, B:12:0x0017, B:14:0x0024, B:22:0x003c, B:24:0x0044, B:26:0x0047, B:28:0x004b, B:30:0x0057, B:31:0x005a, B:41:0x0078), top: B:69:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[Catch: all -> 0x002a, TryCatch #2 {all -> 0x002a, blocks: (B:7:0x000e, B:10:0x0013, B:12:0x0017, B:14:0x0024, B:22:0x003c, B:24:0x0044, B:26:0x0047, B:28:0x004b, B:30:0x0057, B:31:0x005a, B:41:0x0078), top: B:69:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[Catch: all -> 0x00b0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:35:0x0069, B:44:0x0085, B:19:0x0031), top: B:65:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r1 = r11 instanceof androidx.emoji2.text.n
            if (r1 == 0) goto La
            r0 = r11
            androidx.emoji2.text.n r0 = (androidx.emoji2.text.n) r0
            r0.a()
        La:
            java.lang.Class<androidx.emoji2.text.i> r0 = androidx.emoji2.text.i.class
            if (r1 != 0) goto L31
            boolean r2 = r11 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L13
            goto L31
        L13:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2f
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch: java.lang.Throwable -> L2a
            int r3 = r12 + (-1)
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r0)     // Catch: java.lang.Throwable -> L2a
            if (r2 > r13) goto L2f
            androidx.emoji2.text.q r2 = new androidx.emoji2.text.q     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L2a
            goto L39
        L2a:
            r0 = move-exception
            r10 = r0
            r3 = r11
            goto Lb7
        L2f:
            r2 = 0
            goto L39
        L31:
            androidx.emoji2.text.q r2 = new androidx.emoji2.text.q     // Catch: java.lang.Throwable -> Lb0
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> Lb0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb0
        L39:
            r3 = 0
            if (r2 == 0) goto L65
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r0)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r4 = (androidx.emoji2.text.i[]) r4     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L65
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            if (r5 <= 0) goto L65
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            r6 = r3
        L49:
            if (r6 >= r5) goto L65
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L2a
            int r8 = r2.getSpanStart(r7)     // Catch: java.lang.Throwable -> L2a
            int r9 = r2.getSpanEnd(r7)     // Catch: java.lang.Throwable -> L2a
            if (r8 == r13) goto L5a
            r2.removeSpan(r7)     // Catch: java.lang.Throwable -> L2a
        L5a:
            int r12 = java.lang.Math.min(r8, r12)     // Catch: java.lang.Throwable -> L2a
            int r13 = java.lang.Math.max(r9, r13)     // Catch: java.lang.Throwable -> L2a
            int r6 = r6 + 1
            goto L49
        L65:
            r4 = r12
            r5 = r13
            if (r4 == r5) goto L6f
            int r12 = r11.length()     // Catch: java.lang.Throwable -> Lb0
            if (r4 < r12) goto L71
        L6f:
            r3 = r11
            goto Lb3
        L71:
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r12) goto L84
            if (r2 == 0) goto L84
            int r12 = r2.length()     // Catch: java.lang.Throwable -> L2a
            java.lang.Object[] r12 = r2.getSpans(r3, r12, r0)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r12 = (androidx.emoji2.text.i[]) r12     // Catch: java.lang.Throwable -> L2a
            int r12 = r12.length     // Catch: java.lang.Throwable -> L2a
            int r14 = r14 - r12
        L84:
            r6 = r14
            androidx.emoji2.text.h$b r8 = new androidx.emoji2.text.h$b     // Catch: java.lang.Throwable -> Lb0
            androidx.emoji2.text.e$j r12 = r10.f10331a     // Catch: java.lang.Throwable -> Lb0
            r8.<init>(r2, r12)     // Catch: java.lang.Throwable -> Lb0
            r2 = r10
            r3 = r11
            r7 = r15
            java.lang.Object r10 = r2.i(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La4
            androidx.emoji2.text.q r10 = (androidx.emoji2.text.q) r10     // Catch: java.lang.Throwable -> La4
            if (r10 == 0) goto La7
            android.text.Spannable r10 = r10.b()     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto La3
            r11 = r3
            androidx.emoji2.text.n r11 = (androidx.emoji2.text.n) r11
            r11.d()
        La3:
            return r10
        La4:
            r0 = move-exception
        La5:
            r10 = r0
            goto Lb7
        La7:
            if (r1 == 0) goto Laf
        La9:
            r11 = r3
            androidx.emoji2.text.n r11 = (androidx.emoji2.text.n) r11
            r11.d()
        Laf:
            return r3
        Lb0:
            r0 = move-exception
            r3 = r11
            goto La5
        Lb3:
            if (r1 == 0) goto Lb6
            goto La9
        Lb6:
            return r3
        Lb7:
            if (r1 == 0) goto Lbf
            r11 = r3
            androidx.emoji2.text.n r11 = (androidx.emoji2.text.n) r11
            r11.d()
        Lbf:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
