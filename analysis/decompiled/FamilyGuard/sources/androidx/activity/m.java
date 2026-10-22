package androidx.activity;

import V3.v;
import i4.InterfaceC0761a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f7376a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0761a<v> f7377b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f7378c;

    /* renamed from: d, reason: collision with root package name */
    private int f7379d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7380e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7381f;

    /* renamed from: g, reason: collision with root package name */
    private final List<InterfaceC0761a<v>> f7382g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f7383h;

    public m(Executor executor, InterfaceC0761a<v> interfaceC0761a) {
        j4.k.g(executor, "executor");
        j4.k.g(interfaceC0761a, "reportFullyDrawn");
        this.f7376a = executor;
        this.f7377b = interfaceC0761a;
        this.f7378c = new Object();
        this.f7382g = new ArrayList();
        this.f7383h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f7375a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(m mVar) {
        j4.k.g(mVar, "this$0");
        synchronized (mVar.f7378c) {
            try {
                mVar.f7380e = false;
                if (mVar.f7379d == 0 && !mVar.f7381f) {
                    mVar.f7377b.invoke();
                    mVar.b();
                }
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f7378c) {
            try {
                this.f7381f = true;
                Iterator<T> it = this.f7382g.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0761a) it.next()).invoke();
                }
                this.f7382g.clear();
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z5;
        synchronized (this.f7378c) {
            z5 = this.f7381f;
        }
        return z5;
    }
}
