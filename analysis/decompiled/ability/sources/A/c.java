package A;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f65a;
    public b b;

    public c(String str) {
        this.f65a = "APM_".concat(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(new a(0, this, runnable), this.f65a);
    }
}
