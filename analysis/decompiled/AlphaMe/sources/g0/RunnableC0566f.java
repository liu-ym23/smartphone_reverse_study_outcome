package g0;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l.ExecutorC0743a;

/* renamed from: g0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0566f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12645a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12646b;

    public /* synthetic */ RunnableC0566f(Context context, int i4) {
        this.f12645a = i4;
        this.f12646b = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i4 = this.f12645a;
        Context context = this.f12646b;
        switch (i4) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new RunnableC0566f(context, 1));
                break;
            default:
                AbstractC0565e.o(context, new ExecutorC0743a(5), AbstractC0565e.f12635a, false);
                break;
        }
    }
}
