package androidx.emoji2.text;

import O0.i;
import O0.k;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.c;
import androidx.emoji2.text.f;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final c.j f13778a;

    /* renamed from: b, reason: collision with root package name */
    public final f f13779b;

    /* renamed from: c, reason: collision with root package name */
    public c.e f13780c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13781d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f13782e;

    public static final class a {
        public static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        public static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    public static class b implements c<k> {

        /* renamed from: a, reason: collision with root package name */
        public k f13783a;

        /* renamed from: b, reason: collision with root package name */
        public final c.j f13784b;

        public b(k kVar, c.j jVar) {
            this.f13783a = kVar;
            this.f13784b = jVar;
        }

        @Override // androidx.emoji2.text.d.c
        public boolean a(CharSequence charSequence, int i10, int i11, i iVar) {
            if (iVar.k()) {
                return true;
            }
            if (this.f13783a == null) {
                this.f13783a = new k(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f13783a.setSpan(this.f13784b.a(iVar), i10, i11, 33);
            return true;
        }

        @Override // androidx.emoji2.text.d.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k getResult() {
            return this.f13783a;
        }
    }

    public interface c<T> {
        boolean a(CharSequence charSequence, int i10, int i11, i iVar);

        T getResult();
    }

    /* renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    public static class C0170d implements c<C0170d> {

        /* renamed from: a, reason: collision with root package name */
        public final String f13785a;

        public C0170d(String str) {
            this.f13785a = str;
        }

        @Override // androidx.emoji2.text.d.c
        public boolean a(CharSequence charSequence, int i10, int i11, i iVar) {
            if (!TextUtils.equals(charSequence.subSequence(i10, i11), this.f13785a)) {
                return true;
            }
            iVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.d.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0170d getResult() {
            return this;
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f13786a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final f.a f13787b;

        /* renamed from: c, reason: collision with root package name */
        public f.a f13788c;

        /* renamed from: d, reason: collision with root package name */
        public f.a f13789d;

        /* renamed from: e, reason: collision with root package name */
        public int f13790e;

        /* renamed from: f, reason: collision with root package name */
        public int f13791f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f13792g;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f13793h;

        public e(f.a aVar, boolean z10, int[] iArr) {
            this.f13787b = aVar;
            this.f13788c = aVar;
            this.f13792g = z10;
            this.f13793h = iArr;
        }

        public static boolean d(int i10) {
            return i10 == 65039;
        }

        public static boolean f(int i10) {
            return i10 == 65038;
        }

        public int a(int i10) {
            f.a aVarA = this.f13788c.a(i10);
            int iG = 2;
            if (this.f13786a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f13786a = 2;
                    this.f13788c = aVarA;
                    this.f13791f = 1;
                }
            } else if (aVarA != null) {
                this.f13788c = aVarA;
                this.f13791f++;
            } else if (f(i10)) {
                iG = g();
            } else if (!d(i10)) {
                if (this.f13788c.b() != null) {
                    iG = 3;
                    if (this.f13791f != 1 || h()) {
                        this.f13789d = this.f13788c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f13790e = i10;
            return iG;
        }

        public i b() {
            return this.f13788c.b();
        }

        public i c() {
            return this.f13789d.b();
        }

        public boolean e() {
            if (this.f13786a != 2 || this.f13788c.b() == null) {
                return false;
            }
            return this.f13791f > 1 || h();
        }

        public final int g() {
            this.f13786a = 1;
            this.f13788c = this.f13787b;
            this.f13791f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f13788c.b().j() || d(this.f13790e)) {
                return true;
            }
            if (this.f13792g) {
                if (this.f13793h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f13793h, this.f13788c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(f fVar, c.j jVar, c.e eVar, boolean z10, int[] iArr, Set<int[]> set) {
        this.f13778a = jVar;
        this.f13779b = fVar;
        this.f13780c = eVar;
        this.f13781d = z10;
        this.f13782e = iArr;
        g(set);
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        O0.e[] eVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (eVarArr = (O0.e[]) editable.getSpans(selectionStart, selectionEnd, O0.e.class)) != null && eVarArr.length > 0) {
            for (O0.e eVar : eVarArr) {
                int spanStart = editable.getSpanStart(eVar);
                int spanEnd = editable.getSpanEnd(eVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                iMax = a.a(editable, selectionStart, Math.max(i10, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i10, 0);
                iMin = Math.min(selectionEnd + i11, editable.length());
            }
            O0.e[] eVarArr = (O0.e[]) editable.getSpans(iMax, iMin, O0.e.class);
            if (eVarArr != null && eVarArr.length > 0) {
                for (O0.e eVar : eVarArr) {
                    int spanStart = editable.getSpanStart(eVar);
                    int spanEnd = editable.getSpanEnd(eVar);
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

    public static boolean c(Editable editable, int i10, KeyEvent keyEvent) {
        if (!(i10 != 67 ? i10 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public static boolean e(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    public static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final boolean d(CharSequence charSequence, int i10, int i11, i iVar) {
        if (iVar.d() == 0) {
            iVar.m(this.f13780c.a(charSequence, i10, i11, iVar.h()));
        }
        return iVar.d() == 2;
    }

    public final void g(Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new C0170d(str));
        }
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
    public java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r1 = r11 instanceof O0.h
            if (r1 == 0) goto La
            r0 = r11
            O0.h r0 = (O0.h) r0
            r0.a()
        La:
            java.lang.Class<O0.e> r0 = O0.e.class
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
            O0.k r2 = new O0.k     // Catch: java.lang.Throwable -> L2a
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
            O0.k r2 = new O0.k     // Catch: java.lang.Throwable -> Lb0
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> Lb0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb0
        L39:
            r3 = 0
            if (r2 == 0) goto L65
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r0)     // Catch: java.lang.Throwable -> L2a
            O0.e[] r4 = (O0.e[]) r4     // Catch: java.lang.Throwable -> L2a
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
            O0.e[] r12 = (O0.e[]) r12     // Catch: java.lang.Throwable -> L2a
            int r12 = r12.length     // Catch: java.lang.Throwable -> L2a
            int r14 = r14 - r12
        L84:
            r6 = r14
            androidx.emoji2.text.d$b r8 = new androidx.emoji2.text.d$b     // Catch: java.lang.Throwable -> Lb0
            androidx.emoji2.text.c$j r12 = r10.f13778a     // Catch: java.lang.Throwable -> Lb0
            r8.<init>(r2, r12)     // Catch: java.lang.Throwable -> Lb0
            r2 = r10
            r3 = r11
            r7 = r15
            java.lang.Object r10 = r2.i(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La4
            O0.k r10 = (O0.k) r10     // Catch: java.lang.Throwable -> La4
            if (r10 == 0) goto La7
            android.text.Spannable r10 = r10.b()     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto La3
            r11 = r3
            O0.h r11 = (O0.h) r11
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
            O0.h r11 = (O0.h) r11
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
            O0.h r11 = (O0.h) r11
            r11.d()
        Lbf:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.d.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    public final <T> T i(CharSequence charSequence, int i10, int i11, int i12, boolean z10, c<T> cVar) {
        int iCharCount;
        e eVar = new e(this.f13779b.f(), this.f13781d, this.f13782e);
        int i13 = 0;
        boolean zA = true;
        int iCodePointAt = Character.codePointAt(charSequence, i10);
        loop0: while (true) {
            iCharCount = i10;
            while (i10 < i11 && i13 < i12 && zA) {
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i11) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i10 = iCharCount;
                } else if (iA == 2) {
                    i10 += Character.charCount(iCodePointAt);
                    if (i10 < i11) {
                        iCodePointAt = Character.codePointAt(charSequence, i10);
                    }
                } else if (iA == 3) {
                    if (z10 || !d(charSequence, iCharCount, i10, eVar.c())) {
                        zA = cVar.a(charSequence, iCharCount, i10, eVar.c());
                        i13++;
                    }
                }
            }
            break loop0;
        }
        if (eVar.e() && i13 < i12 && zA && (z10 || !d(charSequence, iCharCount, i10, eVar.b()))) {
            cVar.a(charSequence, iCharCount, i10, eVar.b());
        }
        return cVar.getResult();
    }
}
