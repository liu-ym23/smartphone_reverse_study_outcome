package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements androidx.startup.b<c> {

    private static class a {
        /* JADX INFO: renamed from: lambda$N_YRuFpprR-wwUsg3o3zOF8_KW4, reason: not valid java name */
        public static /* synthetic */ void m6lambda$N_YRuFpprRwwUsg3o3zOF8_KW4(Runnable r0, long r1) {
            a(r0, r1);
        }

        public static void a(Runnable r2) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
            Choreographer.getInstance().postFrameCallback(new $$Lambda$ProfileInstallerInitializer$a$N_YRuFpprRwwUsg3o3zOF8_KW4(r3));
        }

        private static /* synthetic */ void a(Runnable r0, long r1) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.aiagent.plugin")).run();
        }
    }

    private static class b {
        public static Handler a(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public static class c {
        public c() {
        }
    }

    public static /* synthetic */ void lambda$_2sf8uA0DmswWYkpE8SdeEOOqNc(Context r0) {
        f(r0);
    }

    public static /* synthetic */ void lambda$ePedVAVkxeC4MgKMOq4kul1RqPg(Context r0) {
        g(r0);
    }

    /* JADX INFO: renamed from: lambda$wbbKF0-ZVFe4XZKr9des7uoTjJM, reason: not valid java name */
    public static /* synthetic */ void m5lambda$wbbKF0ZVFe4XZKr9des7uoTjJM(ProfileInstallerInitializer r0, Context r1) {
        r0.h(r1);
    }

    public ProfileInstallerInitializer() {
    }

    @Override // androidx.startup.b
    public /* synthetic */ c c(Context r3) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public c a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return new c();
    L5:
        return new c();
    }

    private /* synthetic */ void h(Context r3) {
        d((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    void b(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a.a(new $$Lambda$ProfileInstallerInitializer$wbbKF0ZVFe4XZKr9des7uoTjJM(this, r4));
    }

    void d(Context r5) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Handler r6 = b.a(Looper.getMainLooper());
    L6:
        r6.postDelayed(new $$Lambda$ProfileInstallerInitializer$ePedVAVkxeC4MgKMOq4kul1RqPg(r4), new Random().nextInt(Math.max(1000, 1)) + DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        return;
    L5:
        r6 = new Handler(Looper.getMainLooper());
        goto L6
    }

    private static /* synthetic */ void g(Context r2) {
        e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.startup.b
    public List<Class<? extends androidx.startup.b<?>>> b() {
        return Collections.emptyList();
    }

    private static void e(Context r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new $$Lambda$ProfileInstallerInitializer$_2sf8uA0DmswWYkpE8SdeEOOqNc(r9));
    }

    private static /* synthetic */ void f(Context r2) {
        e.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }
}
