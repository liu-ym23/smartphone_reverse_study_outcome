package t0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5434a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f5435b;

    public /* synthetic */ g(Context context, int i8) {
        this.f5434a = i8;
        this.f5435b = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException, IOException {
        switch (this.f5434a) {
            case 0:
                Handler handlerA = i.a(Looper.getMainLooper());
                int iNextInt = new Random().nextInt(Math.max(1000, 1));
                handlerA.postDelayed(new g(this.f5435b, 1), iNextInt + 5000);
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new g(this.f5435b, 2));
                break;
            default:
                f.s(this.f5435b, new d(), f.f5425a, false);
                break;
        }
    }

    public /* synthetic */ g(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f5434a = 0;
        this.f5435b = context;
    }
}
