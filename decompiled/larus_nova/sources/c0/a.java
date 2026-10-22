package c0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21896a;

    public final boolean a() {
        if (this.f21896a.b() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a(boolean r100) {
        this.f21896a = new b(r100 ? 1 : 0);
    }

    public final void b(boolean r100) {
        this.f21896a.c(r100 ? 1 : 0);
    }
}
