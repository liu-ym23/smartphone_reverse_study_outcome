package androidx.navigation;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3879j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3883d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3884e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3885f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3886g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3887h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3888i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3889j;

        public a() {
            this.f3882c = -1;
            this.f3886g = -1;
            this.f3887h = -1;
            this.f3888i = -1;
            this.f3889j = -1;
        }

        public static /* synthetic */ a i(a r10, int r11, boolean r12, boolean r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r13 = false;
        L6:
            return r10.g(r11, r12, r13);
        }

        public final k a() {
            String r10 = this.f3883d;
            if (r10 == null) goto L6;
            return new k(this.f3880a, this.f3881b, r10, this.f3884e, this.f3885f, this.f3886g, this.f3887h, this.f3888i, this.f3889j);
        L6:
            return new k(this.f3880a, this.f3881b, this.f3882c, this.f3884e, this.f3885f, this.f3886g, this.f3887h, this.f3888i, this.f3889j);
        }

        public final a b(int r10) {
            this.f3886g = r10;
            return this;
        }

        public final a c(int r10) {
            this.f3887h = r10;
            return this;
        }

        public final a d(boolean r10) {
            this.f3880a = r10;
            return this;
        }

        public final a e(int r10) {
            this.f3888i = r10;
            return this;
        }

        public final a f(int r10) {
            this.f3889j = r10;
            return this;
        }

        public final a g(int r10, boolean r11, boolean r12) {
            this.f3882c = r10;
            this.f3883d = null;
            this.f3884e = r11;
            this.f3885f = r12;
            return this;
        }

        public final a h(String r10, boolean r11, boolean r12) {
            this.f3883d = r10;
            this.f3882c = -1;
            this.f3884e = r11;
            this.f3885f = r12;
            return this;
        }

        public final a j(boolean r10) {
            this.f3881b = r10;
            return this;
        }
    }

    public k(boolean r10, boolean r11, int r12, boolean r13, boolean r14, int r15, int r16, int r17, int r18) {
        this.f3870a = r10;
        this.f3871b = r11;
        this.f3872c = r12;
        this.f3873d = r13;
        this.f3874e = r14;
        this.f3875f = r15;
        this.f3876g = r16;
        this.f3877h = r17;
        this.f3878i = r18;
    }

    public final int a() {
        return this.f3875f;
    }

    public final int b() {
        return this.f3876g;
    }

    public final int c() {
        return this.f3877h;
    }

    public final int d() {
        return this.f3878i;
    }

    public final int e() {
        return this.f3872c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L33:
        return false;
    L8:
        if (kotlin.jvm.internal.q.b(k.class, r10.getClass()) == false) goto L33;
        k r11 = (k) r10;
        if (this.f3870a != r11.f3870a) goto L32;
        if (this.f3871b != r11.f3871b) goto L32;
        if (this.f3872c != r11.f3872c) goto L32;
        if (kotlin.jvm.internal.q.b(this.f3879j, r11.f3879j) == false) goto L32;
        if (this.f3873d != r11.f3873d) goto L32;
        if (this.f3874e != r11.f3874e) goto L32;
        if (this.f3875f != r11.f3875f) goto L32;
        if (this.f3876g != r11.f3876g) goto L32;
        if (this.f3877h != r11.f3877h) goto L32;
        if (this.f3878i != r11.f3878i) goto L32;
        return true;
    L32:
        return false;
    }

    public final boolean f() {
        return this.f3873d;
    }

    public final boolean g() {
        return this.f3870a;
    }

    public final boolean h() {
        return this.f3874e;
    }

    public int hashCode() {
        int r10 = (((((g() ? 1 : 0) * 31) + (i() ? 1 : 0)) * 31) + this.f3872c) * 31;
        String r11 = this.f3879j;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return ((((((((((((r10 + r12) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f3875f) * 31) + this.f3876g) * 31) + this.f3877h) * 31) + this.f3878i;
    L5:
        r12 = 0;
        goto L7
    }

    public final boolean i() {
        return this.f3871b;
    }

    public k(boolean r13, boolean r14, String r15, boolean r16, boolean r17, int r18, int r19, int r20, int r21) {
        this(r13, r14, NavDestination.f3796j.a(r15).hashCode(), r16, r17, r18, r19, r20, r21);
        this.f3879j = r15;
    }
}
