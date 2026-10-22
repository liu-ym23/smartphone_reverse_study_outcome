package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.core.os.n;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements androidx.startup.b<Boolean> {

    static class a extends d.c {
        public a(Context r3) {
            super(new b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")));
            a(1);
        }
    }

    static class b implements d.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f1604a;

        public static /* synthetic */ void lambda$_PFzr53CDcYgJDSEVeiVIltXqtA(b r0, d.h r1, ThreadPoolExecutor r2) {
            r0.b(r1, r2);
        }

        b(Context r3) {
            this.f1604a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        @Override // androidx.emoji2.text.d.g
        public void a(final d.h r3) {
            final ThreadPoolExecutor r0 = androidx.emoji2.text.a.a("EmojiCompatInitializer");
            r0.execute(new $$Lambda$EmojiCompatInitializer$b$_PFzr53CDcYgJDSEVeiVIltXqtA(this, r3, r0));
        }

        private /* synthetic */ void b(d.h r1, ThreadPoolExecutor r2) {
            a(r1, r2);
        }

        void a(final d.h r3, final ThreadPoolExecutor r4) {
            g r0 = androidx.emoji2.text.b.a(this.f1604a);     // Catch: Throwable -> L7
            if (r0 == null) goto L6;
            r0.a(r4);     // Catch: Throwable -> L7
            r0.a().a(new AnonymousClass1(this, r3, r4));     // Catch: Throwable -> L7
            return;
        L6:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r3.a(th);
            r4.shutdown();
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L7
            if (d.a() == false) goto L5;
            d.b().c();     // Catch: Throwable -> L7
        L5:
            n.a();
            return;
        L7:
            th = move-exception;
            n.a();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    @Override // androidx.startup.b
    public /* synthetic */ Boolean c(Context r3) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public Boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        d.a(new a(r4));
        b(r4);
        return true;
    L7:
        return false;
    }

    void b(Context r3) {
        final androidx.lifecycle.i r4 = ((p) ZeusTransformUtils.preCheckCast(androidx.startup.a.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).a(ProcessLifecycleInitializer.class), p.class, "com.obric.aiagent.plugin")).getLifecycle();
        r4.a(new AnonymousClass1(this, r4));
    }

    void a() {
        androidx.emoji2.text.a.a().postDelayed(new c(), 500);
    }

    @Override // androidx.startup.b
    public List<Class<? extends androidx.startup.b<?>>> b() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
