package y8;

/* renamed from: y8.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5962j {

    /* renamed from: y8.j$a */
    public interface a {
    }

    /* renamed from: y8.j$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f43983a;

        /* renamed from: b, reason: collision with root package name */
        public final float f43984b;

        /* renamed from: c, reason: collision with root package name */
        public final float f43985c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f43986d = true;

        /* renamed from: e, reason: collision with root package name */
        public int f43987e = 1;

        /* renamed from: f, reason: collision with root package name */
        public int f43988f;

        /* renamed from: g, reason: collision with root package name */
        public int f43989g;

        /* renamed from: h, reason: collision with root package name */
        public int f43990h;

        public b(float f10, float f11, float f12) {
            this.f43983a = f10;
            this.f43984b = f11;
            this.f43985c = f12;
        }

        public static /* synthetic */ d c(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ a h(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ a i(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ a j(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ d m(b bVar) {
            bVar.getClass();
            return null;
        }

        public static /* synthetic */ d n(b bVar) {
            bVar.getClass();
            return null;
        }

        public AbstractC5962j o() {
            return new c(this);
        }

        public b p(int i10) {
            this.f43989g = i10;
            return this;
        }

        public b q(int i10) {
            this.f43988f = i10;
            return this;
        }
    }

    /* renamed from: y8.j$c */
    public static class c extends AbstractC5962j {

        /* renamed from: a, reason: collision with root package name */
        public final float f43991a;

        /* renamed from: b, reason: collision with root package name */
        public final float f43992b;

        /* renamed from: c, reason: collision with root package name */
        public final float f43993c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f43994d;

        /* renamed from: e, reason: collision with root package name */
        public int f43995e;

        /* renamed from: f, reason: collision with root package name */
        public final int f43996f;

        /* renamed from: g, reason: collision with root package name */
        public final int f43997g;

        /* renamed from: h, reason: collision with root package name */
        public final int f43998h;

        public c(b bVar) {
            this.f43991a = bVar.f43983a;
            this.f43992b = bVar.f43984b;
            this.f43993c = bVar.f43985c;
            b.h(bVar);
            b.i(bVar);
            b.j(bVar);
            this.f43994d = bVar.f43986d;
            this.f43995e = bVar.f43987e;
            b.m(bVar);
            b.n(bVar);
            b.c(bVar);
            this.f43996f = bVar.f43988f;
            this.f43997g = bVar.f43989g;
            this.f43998h = bVar.f43990h;
        }

        @Override // y8.AbstractC5962j
        public a a() {
            return null;
        }

        @Override // y8.AbstractC5962j
        public boolean b() {
            return this.f43994d;
        }

        @Override // y8.AbstractC5962j
        public int c() {
            return this.f43995e;
        }

        @Override // y8.AbstractC5962j
        public d d() {
            return null;
        }

        @Override // y8.AbstractC5962j
        public int e() {
            int i10 = this.f43998h;
            return i10 != 0 ? i10 : this.f43996f;
        }

        @Override // y8.AbstractC5962j
        public float f() {
            float f10 = this.f43993c;
            return f10 > 0.0f ? f10 : this.f43991a;
        }

        @Override // y8.AbstractC5962j
        public a h() {
            return null;
        }

        @Override // y8.AbstractC5962j
        public d i() {
            return null;
        }

        @Override // y8.AbstractC5962j
        public int j() {
            int i10 = this.f43997g;
            return i10 != 0 ? i10 : this.f43996f;
        }

        @Override // y8.AbstractC5962j
        public float k() {
            float f10 = this.f43992b;
            return f10 > 0.0f ? f10 : this.f43991a;
        }
    }

    /* renamed from: y8.j$d */
    public static class d {
    }

    public static b g(float f10) {
        return new b(f10, 0.0f, 0.0f);
    }

    public abstract a a();

    public abstract boolean b();

    public abstract int c();

    public abstract d d();

    public abstract int e();

    public abstract float f();

    public abstract a h();

    public abstract d i();

    public abstract int j();

    public abstract float k();
}
