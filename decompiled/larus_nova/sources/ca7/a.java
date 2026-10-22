package ca7;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0420a f22952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0420a f22953d;

    /* JADX INFO: renamed from: ca7.a$a, reason: collision with other inner class name */
    public static class C0420a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f22954c;

        public C0420a(a r100) {
            this.f22954c = r100;
            this.f22956a = r100.f22956a;
            this.f22957b = r100.f22957b;
        }

        @Override // ca7.c
        public final boolean b(da7.b r100) {
            return this.f22954c.b(r100);
        }
    }

    public a() {
        this.f22952c = new C0420a(this);
        this.f22953d = new C0420a(this);
    }

    @Override // ca7.c
    public final boolean b(da7.b r100) {
        C0420a r101 = this.f22952c;
        r101.getClass();
        if (r100.a(r101).f467705a == false) goto L9;
        C0420a r102 = this.f22953d;
        r102.getClass();
        if (r100.a(r102).f467705a == false) goto L9;
        if (super.b(r100) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // ca7.c
    public final void f(int r100) {
        super.f(r100);
        this.f22952c.f(r100);
        this.f22953d.f(r100);
    }
}
