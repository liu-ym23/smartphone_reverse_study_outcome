package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {

    public class a implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f3042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EmojiCompatInitializer f3043b;

        public a(EmojiCompatInitializer r10, Lifecycle r11) {
            this.f3043b = r10;
            this.f3042a = r11;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner r10) {
            this.f3043b.c();
            this.f3042a.d(this);
        }
    }

    public static class b extends EmojiCompat.c {
        public b(Context r10) {
            super(new c(r10));
            b(1);
        }
    }

    public static class c implements EmojiCompat.MetadataRepoLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3044a;

        public class a extends EmojiCompat.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EmojiCompat.f f3045a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f3046b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f3047c;

            public a(c r10, EmojiCompat.f r11, ThreadPoolExecutor r12) {
                this.f3047c = r10;
                this.f3045a = r11;
                this.f3046b = r12;
            }

            @Override // androidx.emoji2.text.EmojiCompat.f
            public void a(Throwable r10) {
                this.f3045a.a(r10);     // Catch: Throwable -> L5
                this.f3046b.shutdown();
                return;
            L5:
                th = move-exception;
                this.f3046b.shutdown();
                throw th;
            }

            @Override // androidx.emoji2.text.EmojiCompat.f
            public void b(j r10) {
                this.f3045a.b(r10);     // Catch: Throwable -> L5
                this.f3046b.shutdown();
                return;
            L5:
                th = move-exception;
                this.f3046b.shutdown();
                throw th;
            }
        }

        public c(Context r10) {
            this.f3044a = r10.getApplicationContext();
        }

        public static /* synthetic */ void a(c r10, EmojiCompat.f r11, ThreadPoolExecutor r12) {
            r10.c(r11, r12);
        }

        public void b(EmojiCompat.f r10, ThreadPoolExecutor r11) {
            h r12 = androidx.emoji2.text.c.a(this.f3044a);     // Catch: Throwable -> L5
            if (r12 == null) goto L8;
            r12.c(r11);     // Catch: Throwable -> L5
            r12.a().load(new a(this, r10, r11));     // Catch: Throwable -> L5
            return;
        L8:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            r10.a(th);
            r11.shutdown();
        }

        public final /* synthetic */ void c(EmojiCompat.f r10, ThreadPoolExecutor r11) {
            b(r10, r11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(final EmojiCompat.f r10) {
            final ThreadPoolExecutor r11 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            r11.execute(new e(this, r10, r11));
        }
    }

    public static class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.core.os.g.a("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L6
            if (EmojiCompat.h() == false) goto L8;
            EmojiCompat.b().k();     // Catch: Throwable -> L6
        L8:
            androidx.core.os.g.b();
            return;
        L6:
            th = move-exception;
            androidx.core.os.g.b();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    public Boolean a(Context r10) {
        EmojiCompat.g(new b(r10));
        b(r10);
        return Boolean.TRUE;
    }

    public void b(Context r10) {
        Lifecycle r11 = ((LifecycleOwner) e0.a.e(r10).f(ProcessLifecycleInitializer.class)).getLifecycle();
        r11.a(new a(this, r11));
    }

    public void c() {
        androidx.emoji2.text.b.d().postDelayed(new d(), 500);
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Boolean create(Context r10) {
        return a(r10);
    }

    @Override // androidx.startup.Initializer
    public List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
