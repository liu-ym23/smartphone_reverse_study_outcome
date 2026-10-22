package androidx.lifecycle;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0526f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f10865a;

    /* renamed from: b, reason: collision with root package name */
    private final AbstractC0545z<T> f10866b;

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC0545z<T> f10867c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f10868d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f10869e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f10870f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f10871g;

    /* renamed from: androidx.lifecycle.f$a */
    public static final class a extends AbstractC0545z<T> {

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ AbstractC0526f<T> f10872l;

        a(AbstractC0526f<T> abstractC0526f) {
            this.f10872l = abstractC0526f;
        }

        @Override // androidx.lifecycle.AbstractC0545z
        protected void i() {
            this.f10872l.d().execute(this.f10872l.f10870f);
        }
    }

    public AbstractC0526f(Executor executor) {
        j4.k.g(executor, "executor");
        this.f10865a = executor;
        a aVar = new a(this);
        this.f10866b = aVar;
        this.f10867c = aVar;
        this.f10868d = new AtomicBoolean(true);
        this.f10869e = new AtomicBoolean(false);
        this.f10870f = new Runnable() { // from class: androidx.lifecycle.d
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC0526f.h(this.f10863a);
            }
        };
        this.f10871g = new Runnable() { // from class: androidx.lifecycle.e
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC0526f.g(this.f10864a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AbstractC0526f abstractC0526f) {
        j4.k.g(abstractC0526f, "this$0");
        boolean zF = abstractC0526f.e().f();
        if (abstractC0526f.f10868d.compareAndSet(false, true) && zF) {
            abstractC0526f.f10865a.execute(abstractC0526f.f10870f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(AbstractC0526f abstractC0526f) {
        j4.k.g(abstractC0526f, "this$0");
        do {
            boolean z5 = false;
            if (abstractC0526f.f10869e.compareAndSet(false, true)) {
                Object objC = null;
                boolean z6 = false;
                while (abstractC0526f.f10868d.compareAndSet(true, false)) {
                    try {
                        objC = abstractC0526f.c();
                        z6 = true;
                    } catch (Throwable th) {
                        abstractC0526f.f10869e.set(false);
                        throw th;
                    }
                }
                if (z6) {
                    abstractC0526f.e().k(objC);
                }
                abstractC0526f.f10869e.set(false);
                z5 = z6;
            }
            if (!z5) {
                return;
            }
        } while (abstractC0526f.f10868d.get());
    }

    protected abstract T c();

    public final Executor d() {
        return this.f10865a;
    }

    public AbstractC0545z<T> e() {
        return this.f10867c;
    }

    public void f() {
        m.c.h().b(this.f10871g);
    }
}
