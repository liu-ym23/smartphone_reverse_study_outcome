package c50;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f22447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f22448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22450d;

    public final void a() {
        Runnable r100 = this.f22447a;
        if (r100 == null) goto L5;
        r100.run();
    L5:
        f r101 = this.f22448b;
        if (r101 == null) goto L12;
        e.a r102 = (e.a) r101;
        d r103 = r102.f22460a.f22456b.get(Integer.valueOf(this.f22450d));
        if (r103 == null) goto L10;
        r103.f22454d.remove(this);
    L10:
        r102.f22460a.f22458d.b();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(String r100, int r101, Runnable r102, f r103, long r104) {
        this.f22447a = null;
        this.f22448b = null;
        this.f22449c = 0;
        this.f22450d = -1;
        this.f22450d = r101;
        this.f22447a = r102;
        this.f22448b = r103;
        this.f22449c = r104;
    }
}
