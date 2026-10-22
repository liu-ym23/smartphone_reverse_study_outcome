package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<c> {

    public static class a {
        public static /* synthetic */ void a(Runnable r10, long r11) {
            b(r10, r11);
        }

        public static /* synthetic */ void b(Runnable r10, long r11) {
            r10.run();
        }

        @DoNotInline
        public static void c(final Runnable r10) {
            Choreographer.getInstance().postFrameCallback(new k(r10));
        }
    }

    public static class b {
        @DoNotInline
        public static Handler a(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public static class c {
        public c() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    public static /* synthetic */ void a(ProfileInstallerInitializer r10, Context r11) {
        r10.g(r11);
    }

    public static /* synthetic */ void b(Context r10) {
        i(r10);
    }

    public static /* synthetic */ void c(Context r10) {
        h(r10);
    }

    public static /* synthetic */ void h(Context r10) {
        j(r10);
    }

    public static /* synthetic */ void i(Context r10) {
        ProfileInstaller.i(r10);
    }

    public static void j(final Context r10) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new j(r10));
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ c create(Context r10) {
        return d(r10);
    }

    public c d(Context r10) {
        e(r10.getApplicationContext());
        return new c();
    }

    @Override // androidx.startup.Initializer
    public List dependencies() {
        return Collections.emptyList();
    }

    public void e(final Context r10) {
        a.c(new h(this, r10));
    }

    public void f(final Context r10) {
        b.a(Looper.getMainLooper()).postDelayed(new i(r10), new Random().nextInt(Math.max(1000, 1)) + 5000);
    }

    public final /* synthetic */ void g(Context r10) {
        f(r10);
    }
}
