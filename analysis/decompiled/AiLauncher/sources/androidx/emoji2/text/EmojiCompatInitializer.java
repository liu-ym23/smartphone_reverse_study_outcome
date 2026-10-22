package androidx.emoji2.text;

import android.content.Context;
import android.view.InterfaceC1387e;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.ProcessLifecycleInitializer;
import androidx.emoji2.text.c;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import n1.C4935a;
import x0.l;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements n1.b<Boolean> {

    public class a implements InterfaceC1387e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f13735a;

        public a(Lifecycle lifecycle) {
            this.f13735a = lifecycle;
        }

        @Override // android.view.InterfaceC1387e
        public void onResume(LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.e();
            this.f13735a.d(this);
        }
    }

    public static class b extends c.AbstractC0169c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    public static class c implements c.h {

        /* renamed from: a, reason: collision with root package name */
        public final Context f13737a;

        public class a extends c.i {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c.i f13738a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f13739b;

            public a(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f13738a = iVar;
                this.f13739b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                try {
                    this.f13738a.a(th);
                } finally {
                    this.f13739b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.c.i
            public void b(f fVar) {
                try {
                    this.f13738a.b(fVar);
                } finally {
                    this.f13739b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f13737a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.h
        public void a(final c.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = O0.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: O0.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5133a.c(iVar, threadPoolExecutorB);
                }
            });
        }

        public void c(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                e eVarA = androidx.emoji2.text.a.a(this.f13737a);
                if (eVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                eVarA.c(threadPoolExecutor);
                eVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                l.a("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.i()) {
                    androidx.emoji2.text.c.c().l();
                }
            } finally {
                l.b();
            }
        }
    }

    @Override // n1.b
    public List<Class<? extends n1.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // n1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        androidx.emoji2.text.c.h(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    public void d(Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) C4935a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    public void e() {
        O0.b.c().postDelayed(new d(), 500L);
    }
}
