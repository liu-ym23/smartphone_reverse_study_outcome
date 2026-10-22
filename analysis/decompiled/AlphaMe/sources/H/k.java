package H;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class k implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public String f685a;

    /* renamed from: b, reason: collision with root package name */
    public int f686b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new j(runnable, this.f685a, this.f686b);
    }
}
