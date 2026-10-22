package okhttp3.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    public NamedRunnable(String r10, Object... r11) {
        this.name = Util.format(r10, r11);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String r10 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        execute();     // Catch: Throwable -> L6
        Thread.currentThread().setName(r10);
        return;
    L6:
        th = move-exception;
        Thread.currentThread().setName(r10);
        throw th;
    }
}
