package bytekn.foundation.io.file;

/* JADX INFO: loaded from: classes6.dex */
public final class j extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f21802c;

    @Override // bytekn.foundation.io.file.e
    public final void a() {
        this.f21802c.a();
    }

    @Override // bytekn.foundation.io.file.e, bytekn.foundation.io.file.g
    public final void close() {
        this.f21802c.close();
    }

    public j(e r100) {
        this.f21802c = r100;
    }

    @Override // bytekn.foundation.io.file.e
    public final void b(byte[] r100, int r101) {
        this.f21802c.b(r100, r101);
        this.f21801b += (long) r101;
    }
}
