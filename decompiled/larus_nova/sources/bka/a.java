package bka;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19387a = null;

    static {
        f19387a = new a();
    }

    public a() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L5
    }
}
