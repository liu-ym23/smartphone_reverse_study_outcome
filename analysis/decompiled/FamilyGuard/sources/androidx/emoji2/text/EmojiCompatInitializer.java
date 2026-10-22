package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.e;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0527g;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.ProcessLifecycleInitializer;
import f0.InterfaceC0693a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC0693a<Boolean> {

    class a implements InterfaceC0527g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractC0533m f10284a;

        a(AbstractC0533m abstractC0533m) {
            this.f10284a = abstractC0533m;
        }

        @Override // androidx.lifecycle.InterfaceC0527g
        public void a(InterfaceC0539t interfaceC0539t) {
            EmojiCompatInitializer.this.e();
            this.f10284a.d(this);
        }
    }

    static class b extends e.c {
        protected b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    static class c implements e.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f10286a;

        class a extends e.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e.i f10287a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f10288b;

            a(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f10287a = iVar;
                this.f10288b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.e.i
            public void a(Throwable th) {
                try {
                    this.f10287a.a(th);
                } finally {
                    this.f10288b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.e.i
            public void b(m mVar) {
                try {
                    this.f10287a.b(mVar);
                } finally {
                    this.f10288b.shutdown();
                }
            }
        }

        c(Context context) {
            this.f10286a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.e.h
        public void a(final e.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10328a.c(iVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(e.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                j jVarA = androidx.emoji2.text.c.a(this.f10286a);
                if (jVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                jVarA.c(threadPoolExecutor);
                jVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.i.a("EmojiCompat.EmojiCompatInitializer.run");
                if (e.i()) {
                    e.c().l();
                }
            } finally {
                androidx.core.os.i.b();
            }
        }
    }

    @Override // f0.InterfaceC0693a
    public List<Class<? extends InterfaceC0693a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // f0.InterfaceC0693a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        e.h(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        AbstractC0533m lifecycle = ((InterfaceC0539t) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    void e() {
        androidx.emoji2.text.b.c().postDelayed(new d(), 500L);
    }
}
