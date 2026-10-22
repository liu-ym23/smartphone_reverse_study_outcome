package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextDirectionHeuristicsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2611b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2612c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2613d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2614e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2615f = null;

    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence r10, int r11, int r12);
    }

    public static class a implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f2616b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2617a;

        static {
            f2616b = new a(true);
        }

        public a(boolean r10) {
            this.f2617a = r10;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r10, int r11, int r12) {
            int r13 = r12 + r11;
            boolean r14 = false;
        L3:
            if (r11 >= r13) goto L16;
            int r15 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(r10.charAt(r11)));
            if (r15 == 0) goto L13;
            if (r15 != 1) goto L15;
            if (this.f2617a == false) goto L10;
        L11:
            r14 = true;
            goto L15
        L10:
            return 1;
        L15:
            r11 = r11 + 1;
            r14 = r14;
            goto L3
        L13:
            if (this.f2617a == false) goto L11;
            return 0;
        L16:
            if (r14 == true) goto L18;
            return 2;
        L18:
            return this.f2617a ? 1 : 0;
        }
    }

    public static class b implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f2618a = null;

        static {
            f2618a = new b();
        }

        public b() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence r10, int r11, int r12) {
            int r13 = r12 + r11;
            int r14 = 2;
        L3:
            if (r11 >= r13) goto L6;
            if (r14 != 2) goto L6;
            r14 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(r10.charAt(r11)));
            r11 = r11 + 1;
        L6:
            return r14;
        }
    }

    public static abstract class c implements TextDirectionHeuristicCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextDirectionAlgorithm f2619a;

        public c(TextDirectionAlgorithm r10) {
            this.f2619a = r10;
        }

        public abstract boolean a();

        public final boolean b(CharSequence r10, int r11, int r12) {
            int r13 = this.f2619a.checkRtl(r10, r11, r12);
            if (r13 == 0) goto L9;
            if (r13 != 1) goto L6;
            return false;
        L6:
            return a();
        L9:
            return true;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] r10, int r11, int r12) {
            return isRtl(CharBuffer.wrap(r10), r11, r12);
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence r10, int r11, int r12) {
            if (r10 == null) goto L14;
            if (r11 < 0) goto L14;
            if (r12 < 0) goto L14;
            if ((r10.length() - r12) < r11) goto L14;
            if (this.f2619a != null) goto L12;
            return a();
        L12:
            return b(r10, r11, r12);
        L14:
            throw new IllegalArgumentException();
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2620b;

        public d(TextDirectionAlgorithm r10, boolean r11) {
            super(r10);
            this.f2620b = r11;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.c
        public boolean a() {
            return this.f2620b;
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f2621b = null;

        static {
            f2621b = new e();
        }

        public e() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.c
        public boolean a() {
            if (androidx.core.text.d.a(Locale.getDefault()) == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        f2610a = new d(null, false);
        f2611b = new d(null, true);
        b r10 = b.f2618a;
        f2612c = new d(r10, false);
        f2613d = new d(r10, true);
        f2614e = new d(a.f2616b, false);
        f2615f = e.f2621b;
    }

    public static int a(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L6;
        return 0;
    L6:
        if (r10 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    public static int b(int r10) {
        if (r10 == 0) goto L11;
        if (r10 != 1) goto L6;
        return 0;
    L6:
        if (r10 == 2) goto L12;
        switch(r10) {
            case 14: goto L11;
            case 15: goto L11;
            case 16: goto L13;
            case 17: goto L13;
            default: goto L8;
        };
    L8:
        return 2;
    L13:
        return 0;
    L12:
        return 0;
    L11:
        return 1;
    }
}
