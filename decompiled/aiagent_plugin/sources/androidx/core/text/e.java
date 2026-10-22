package androidx.core.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.core.text.d f1359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.core.text.d f1360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.core.text.d f1361c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final androidx.core.text.d f1362d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.core.text.d f1363e = null;
    public static final androidx.core.text.d f = null;

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f1364a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1365b;

        @Override // androidx.core.text.e.c
        public int a(CharSequence r5, int r6, int r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            int r9 = r7 + r6;
            boolean r1 = false;
        L3:
            if (r6 >= r9) goto L16;
            int r2 = e.a(Character.getDirectionality(r8.charAt(r6)));
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L15;
            if (this.f1365b == false) goto L10;
        L14:
            r1 = true;
            goto L15
        L10:
            return 1;
        L15:
            r6 = r6 + 1;
            r1 = r1;
            goto L3
        L12:
            if (this.f1365b == false) goto L14;
            return 0;
        L16:
            if (r1 == true) goto L18;
            return 2;
        L18:
            return this.f1365b ? 1 : 0;
        }

        private a(boolean r1) {
            this.f1365b = r1;
        }

        static {
            f1364a = new a(true);
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f1366a = null;

        @Override // androidx.core.text.e.c
        public int a(CharSequence r2, int r3, int r4) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            int r5 = r4 + r3;
            int r0 = 2;
        L3:
            if (r3 >= r5) goto L6;
            if (r0 != 2) goto L6;
            r0 = e.b(Character.getDirectionality(r1.charAt(r3)));
            r3 = r3 + 1;
        L6:
            return r0;
        }

        private b() {
        }

        static {
            f1366a = new b();
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private interface c {
        int a(CharSequence r1, int r2, int r3);
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static abstract class d implements androidx.core.text.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f1367a;

        public abstract boolean a();

        d(c r3) {
            this.f1367a = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.core.text.d
        public boolean a(CharSequence r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L15;
            if (r4 < 0) goto L15;
            if (r5 < 0) goto L15;
            if ((r6.length() - r5) < r4) goto L15;
            if (this.f1367a != null) goto L13;
            return a();
        L13:
            return b(r6, r4, r5);
        L15:
            throw new IllegalArgumentException();
        }

        private boolean b(CharSequence r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            int r7 = this.f1367a.a(r6, r4, r5);
            if (r7 == 0) goto L9;
            if (r7 != 1) goto L6;
            return false;
        L6:
            return a();
        L9:
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.core.text.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class C0034e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f1368a;

        C0034e(c r3, boolean r4) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
            this.f1368a = r4;
        }

        @Override // androidx.core.text.e.d
        public boolean a() {
            return this.f1368a;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f1369a = null;

        f() {
            super(null);
        }

        @Override // androidx.core.text.e.d
        public boolean a() {
            if (androidx.core.text.f.a(Locale.getDefault()) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        static {
            f1369a = new f();
        }
    }

    static int a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L6;
        return 0;
    L6:
        if (r1 == 2) goto L11;
        return 2;
    L11:
        return 0;
    L10:
        return 1;
    }

    static int b(int r2) {
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L6;
        return 0;
    L6:
        if (r2 == 2) goto L12;
        switch(r2) {
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

    static {
        f1359a = new C0034e(null, false);
        f1360b = new C0034e(null, true);
        f1361c = new C0034e(b.f1366a, false);
        f1362d = new C0034e(b.f1366a, true);
        f1363e = new C0034e(a.f1364a, false);
        f = f.f1369a;
    }
}
