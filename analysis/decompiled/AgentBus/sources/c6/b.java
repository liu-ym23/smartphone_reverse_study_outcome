package c6;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1905a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1906b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f1905a = i2;
        this.f1906b = obj;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i2 = this.f1905a;
        Object obj = this.f1906b;
        switch (i2) {
            case 0:
                Thread thread = new Thread(runnable, a1.a.j("LocalSocketChannel-", ((c) obj).f1910c, "-read"));
                thread.setDaemon(true);
                return thread;
            default:
                Thread thread2 = new Thread(runnable, (String) obj);
                thread2.setPriority(10);
                return thread2;
        }
    }
}
