package androidx.core.text;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.core.text.e f9701a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.core.text.e f9702b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.core.text.e f9703c;

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.core.text.e f9704d;

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.core.text.e f9705e;

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.core.text.e f9706f;

    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f9707b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f9708a;

        private a(boolean z5) {
            this.f9708a = z5;
        }

        @Override // androidx.core.text.f.c
        public int a(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            boolean z5 = false;
            while (i5 < i7) {
                int iA = f.a(Character.getDirectionality(charSequence.charAt(i5)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i5++;
                        z5 = z5;
                    } else if (!this.f9708a) {
                        return 1;
                    }
                } else if (this.f9708a) {
                    return 0;
                }
                z5 = true;
                i5++;
                z5 = z5;
            }
            if (z5) {
                return this.f9708a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f9709a = new b();

        private b() {
        }

        @Override // androidx.core.text.f.c
        public int a(CharSequence charSequence, int i5, int i6) {
            int i7 = i6 + i5;
            int iB = 2;
            while (i5 < i7 && iB == 2) {
                iB = f.b(Character.getDirectionality(charSequence.charAt(i5)));
                i5++;
            }
            return iB;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i5, int i6);
    }

    private static abstract class d implements androidx.core.text.e {

        /* renamed from: a, reason: collision with root package name */
        private final c f9710a;

        d(c cVar) {
            this.f9710a = cVar;
        }

        private boolean b(CharSequence charSequence, int i5, int i6) {
            int iA = this.f9710a.a(charSequence, i5, i6);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        protected abstract boolean a();

        @Override // androidx.core.text.e
        public boolean isRtl(CharSequence charSequence, int i5, int i6) {
            if (charSequence == null || i5 < 0 || i6 < 0 || charSequence.length() - i6 < i5) {
                throw new IllegalArgumentException();
            }
            return this.f9710a == null ? a() : b(charSequence, i5, i6);
        }
    }

    private static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9711b;

        e(c cVar, boolean z5) {
            super(cVar);
            this.f9711b = z5;
        }

        @Override // androidx.core.text.f.d
        protected boolean a() {
            return this.f9711b;
        }
    }

    /* renamed from: androidx.core.text.f$f, reason: collision with other inner class name */
    private static class C0120f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final C0120f f9712b = new C0120f();

        C0120f() {
            super(null);
        }

        @Override // androidx.core.text.f.d
        protected boolean a() {
            return g.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f9709a;
        f9703c = new e(bVar, false);
        f9704d = new e(bVar, true);
        f9705e = new e(a.f9707b, false);
        f9706f = C0120f.f9712b;
    }

    static int a(int i5) {
        if (i5 != 0) {
            return (i5 == 1 || i5 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i5) {
        if (i5 != 0) {
            if (i5 == 1 || i5 == 2) {
                return 0;
            }
            switch (i5) {
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
