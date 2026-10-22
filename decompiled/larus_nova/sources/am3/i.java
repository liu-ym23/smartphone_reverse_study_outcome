package am3;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends d<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4384g;

    @Override // am3.d, am3.f
    public final void a() {
        this.f4364e = this.f4383f;
        a r100 = (a) this.f4362c;
        r100.f4357c = this.f4384g;
    }

    @Override // am3.d, am3.f
    public final f b() {
        return new i(this);
    }

    public i(i r100) {
        T r101 = r100.f4362c;
        a r102 = new a((a) r101, ((a) r101).f4357c);
        int r103 = r100.f4364e;
        super(r102, r103, r100.f4363d);
        this.f4383f = r103;
        this.f4384g = ((a) r100.f4362c).f4357c;
    }

    public i(d<?> r100) {
        a r101 = new a(r100.f4362c);
        int r102 = r100.f4364e;
        super(r101, r102, r100.f4363d);
        this.f4383f = r102;
        this.f4384g = 0;
    }
}
