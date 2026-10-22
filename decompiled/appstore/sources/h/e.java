package h;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public e() {
    }

    public abstract void a(Runnable r10);

    public void b(Runnable r10) {
        if (c() == false) goto L5;
        r10.run();
        return;
    L5:
        d(r10);
    }

    public abstract boolean c();

    public abstract void d(Runnable r10);
}
