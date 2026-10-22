package f3;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3390f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f3391g;

    public /* synthetic */ h(Context context, int i2) {
        this.f3390f = i2;
        this.f3391g = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException, IOException {
        switch (this.f3390f) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new h(this.f3391g, 1));
                break;
            default:
                f.t(this.f3391g, new d(0), f.f3379a, false);
                break;
        }
    }
}
