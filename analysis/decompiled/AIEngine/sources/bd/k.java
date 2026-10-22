package bd;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3235a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3236b;

    public /* synthetic */ k(String str, boolean z) {
        this.f3235a = str;
        this.f3236b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String name = this.f3235a;
        kotlin.jvm.internal.g.f(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(this.f3236b);
        return thread;
    }
}
