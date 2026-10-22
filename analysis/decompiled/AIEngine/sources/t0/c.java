package t0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final d f12912a = new d(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final d f12913b = new d(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final d f12914c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f12915d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12916a = new a();

        /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
        @Override // t0.c.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int a(java.lang.CharSequence r5, int r6) {
            /*
                r4 = this;
                r4 = 0
                r0 = 2
                r1 = r4
                r2 = r0
            L4:
                if (r1 >= r6) goto L24
                if (r2 != r0) goto L24
                char r2 = r5.charAt(r1)
                byte r2 = java.lang.Character.getDirectionality(r2)
                t0.c$d r3 = t0.c.f12912a
                r3 = 1
                if (r2 == 0) goto L20
                if (r2 == r3) goto L1e
                if (r2 == r0) goto L1e
                switch(r2) {
                    case 14: goto L20;
                    case 15: goto L20;
                    case 16: goto L1e;
                    case 17: goto L1e;
                    default: goto L1c;
                }
            L1c:
                r2 = r0
                goto L21
            L1e:
                r2 = r4
                goto L21
            L20:
                r2 = r3
            L21:
                int r1 = r1 + 1
                goto L4
            L24:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: t0.c.a.a(java.lang.CharSequence, int):int");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        int a(CharSequence charSequence, int i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: t0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0146c {

        /* renamed from: a, reason: collision with root package name */
        public final b f12917a;

        public AbstractC0146c(b bVar) {
            this.f12917a = bVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i10) {
            if (charSequence == null || i10 < 0 || charSequence.length() - i10 < 0) {
                throw new IllegalArgumentException();
            }
            b bVar = this.f12917a;
            if (bVar == null) {
                return a();
            }
            int iA = bVar.a(charSequence, i10);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends AbstractC0146c {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12918b;

        public d(a aVar, boolean z) {
            super(aVar);
            this.f12918b = z;
        }

        @Override // t0.c.AbstractC0146c
        public final boolean a() {
            return this.f12918b;
        }
    }

    static {
        a aVar = a.f12916a;
        f12914c = new d(aVar, false);
        f12915d = new d(aVar, true);
    }
}
