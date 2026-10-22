package z0;

import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final z0.d f44551a = new C0563e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final z0.d f44552b = new C0563e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final z0.d f44553c;

    /* renamed from: d, reason: collision with root package name */
    public static final z0.d f44554d;

    /* renamed from: e, reason: collision with root package name */
    public static final z0.d f44555e;

    /* renamed from: f, reason: collision with root package name */
    public static final z0.d f44556f;

    public static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f44557b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f44558a;

        public a(boolean z10) {
            this.f44558a = z10;
        }

        @Override // z0.e.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int iA = e.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i10++;
                        z10 = z10;
                    } else if (!this.f44558a) {
                        return 1;
                    }
                } else if (this.f44558a) {
                    return 0;
                }
                z10 = true;
                i10++;
                z10 = z10;
            }
            if (z10) {
                return this.f44558a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f44559a = new b();

        @Override // z0.e.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int iB = 2;
            while (i10 < i12 && iB == 2) {
                iB = e.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return iB;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    public static abstract class d implements z0.d {

        /* renamed from: a, reason: collision with root package name */
        public final c f44560a;

        public d(c cVar) {
            this.f44560a = cVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i10, int i11) {
            int iA = this.f44560a.a(charSequence, i10, i11);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        @Override // z0.d
        public boolean isRtl(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f44560a == null ? a() : b(charSequence, i10, i11);
        }
    }

    /* renamed from: z0.e$e, reason: collision with other inner class name */
    public static class C0563e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f44561b;

        public C0563e(c cVar, boolean z10) {
            super(cVar);
            this.f44561b = z10;
        }

        @Override // z0.e.d
        public boolean a() {
            return this.f44561b;
        }
    }

    public static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f44562b = new f();

        public f() {
            super(null);
        }

        @Override // z0.e.d
        public boolean a() {
            return z0.f.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f44559a;
        f44553c = new C0563e(bVar, false);
        f44554d = new C0563e(bVar, true);
        f44555e = new C0563e(a.f44557b, false);
        f44556f = f.f44562b;
    }

    public static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
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
