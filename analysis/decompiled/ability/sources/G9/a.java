package G9;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f703a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ a(String str, boolean z10) {
        this.f703a = str;
        this.b = z10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String name = this.f703a;
        k.f(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(this.b);
        return thread;
    }
}
