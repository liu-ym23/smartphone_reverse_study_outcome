package bd;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f2072c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f2073f;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f2072c;
        boolean z10 = this.f2073f;
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }
}
