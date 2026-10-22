package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import f0.InterfaceC0693a;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC0693a<c> {

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        public static void b(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.m
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j5) {
                    runnable.run();
                }
            });
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.l
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                i.h(context);
            }
        });
    }

    @Override // f0.InterfaceC0693a
    public List<Class<? extends InterfaceC0693a<?>>> a() {
        return Collections.EMPTY_LIST;
    }

    @Override // f0.InterfaceC0693a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c b(Context context) {
        g(context.getApplicationContext());
        return new c();
    }

    void g(final Context context) {
        a.b(new Runnable() { // from class: androidx.profileinstaller.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f11309a.h(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(final Context context) {
        b.a(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: androidx.profileinstaller.k
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.i(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
