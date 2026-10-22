package bb;

import java.util.concurrent.ThreadFactory;
import q7.k;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1657a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1658b;

    public /* synthetic */ a(String str, boolean z4) {
        this.f1657a = str;
        this.f1658b = z4;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f1657a;
        k.e(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(this.f1658b);
        return thread;
    }
}
