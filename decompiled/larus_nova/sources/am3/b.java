package am3;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f4359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4360d;

    @Override // am3.f
    public final void a() {
        this.f4360d = this.f4358b;
    }

    @Override // am3.f
    public final f b() {
        return new b(this);
    }

    @Override // am3.f
    public final boolean d() {
        if ((this.f4359c.length - this.f4360d) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // am3.f
    public final byte readByte() {
        byte[] r100 = this.f4359c;
        int r101 = this.f4360d;
        this.f4360d = r101 + 1;
        return r100[r101];
    }

    public b(b r100) {
        this.f4360d = 0;
        int r101 = r100.f4360d;
        this.f4358b = r101;
        this.f4359c = r100.f4359c;
        this.f4360d = r101;
    }

    @Override // am3.f
    public final void c(long r100) {
        this.f4360d = (int) (((long) this.f4360d) + r100);
    }

    @Override // am3.f
    public final byte[] readByteArray(long r100) {
        int r101 = (int) r100;
        byte[] r102 = new byte[r101];
        System.arraycopy(this.f4359c, this.f4360d, r102, 0, r101);
        this.f4360d += r101;
        return r102;
    }

    @Override // am3.f
    public final String readUtf8(long r100) {
        String r101 = new String(this.f4359c, this.f4360d, (int) r100, e.f4365a);
        this.f4360d = (int) (((long) this.f4360d) + r100);
        return r101;
    }

    @Override // am3.f
    public final void skip(long r100) {
        this.f4360d = (int) (((long) this.f4360d) + r100);
    }

    public b(byte[] r100) {
        this.f4360d = 0;
        this.f4358b = -1;
        this.f4359c = r100;
    }
}
