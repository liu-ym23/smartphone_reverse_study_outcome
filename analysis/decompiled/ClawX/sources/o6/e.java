package o6;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4329b;

    public /* synthetic */ e(String str, boolean z) {
        this.f4328a = str;
        this.f4329b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f4328a);
        thread.setDaemon(this.f4329b);
        return thread;
    }
}
