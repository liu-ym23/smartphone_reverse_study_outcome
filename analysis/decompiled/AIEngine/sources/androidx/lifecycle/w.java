package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import h2.m;
import java.util.Map;
import n.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class w<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f2322k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2323a;

    /* renamed from: b, reason: collision with root package name */
    public final n.b<y<? super T>, w<T>.d> f2324b;

    /* renamed from: c, reason: collision with root package name */
    public int f2325c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2326d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f2327e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f2328f;

    /* renamed from: g, reason: collision with root package name */
    public int f2329g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2330i;

    /* renamed from: j, reason: collision with root package name */
    public final a f2331j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Object obj;
            synchronized (w.this.f2323a) {
                obj = w.this.f2328f;
                w.this.f2328f = w.f2322k;
            }
            w.this.f(obj);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends w<T>.d {
        @Override // androidx.lifecycle.w.d
        public final boolean d() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends w<T>.d implements o {
    }

    public w(int i10) {
        m.a.b bVar = h2.m.f9277b;
        this.f2323a = new Object();
        this.f2324b = new n.b<>();
        this.f2325c = 0;
        this.f2328f = f2322k;
        this.f2331j = new a();
        this.f2327e = bVar;
        this.f2329g = 0;
    }

    public static void a(String str) {
        m.b.k().f10433b.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(a0.a.k("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(w<T>.d dVar) {
        if (dVar.f2334b) {
            if (!dVar.d()) {
                dVar.b(false);
                return;
            }
            int i10 = dVar.f2335c;
            int i11 = this.f2329g;
            if (i10 >= i11) {
                return;
            }
            dVar.f2335c = i11;
            y<? super T> yVar = dVar.f2333a;
            Object obj = this.f2327e;
            DialogFragment.d dVar2 = (DialogFragment.d) yVar;
            dVar2.getClass();
            q qVar = (q) obj;
            DialogFragment dialogFragment = DialogFragment.this;
            if (qVar == null || !dialogFragment.mShowsDialog) {
                return;
            }
            View viewRequireView = dialogFragment.requireView();
            if (viewRequireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (dialogFragment.mDialog != null) {
                if (FragmentManager.G(3)) {
                    Log.d("FragmentManager", "DialogFragment " + dVar2 + " setting the content view on " + dialogFragment.mDialog);
                }
                dialogFragment.mDialog.setContentView(viewRequireView);
            }
        }
    }

    public final void c(w<T>.d dVar) {
        if (this.h) {
            this.f2330i = true;
            return;
        }
        this.h = true;
        do {
            this.f2330i = false;
            if (dVar != null) {
                b(dVar);
                dVar = null;
            } else {
                n.b<y<? super T>, w<T>.d> bVar = this.f2324b;
                bVar.getClass();
                b.d dVar2 = new b.d();
                bVar.f10575c.put(dVar2, Boolean.FALSE);
                while (dVar2.hasNext()) {
                    b((d) ((Map.Entry) dVar2.next()).getValue());
                    if (this.f2330i) {
                        break;
                    }
                }
            }
        } while (this.f2330i);
        this.h = false;
    }

    public void f(T t8) {
        a("setValue");
        this.f2329g++;
        this.f2327e = t8;
        c(null);
    }

    public w() {
        this.f2323a = new Object();
        this.f2324b = new n.b<>();
        this.f2325c = 0;
        Object obj = f2322k;
        this.f2328f = obj;
        this.f2331j = new a();
        this.f2327e = obj;
        this.f2329g = -1;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public final y<? super T> f2333a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2334b;

        /* renamed from: c, reason: collision with root package name */
        public int f2335c = -1;

        public d(y<? super T> yVar) {
            this.f2333a = yVar;
        }

        public final void b(boolean z) {
            if (z == this.f2334b) {
                return;
            }
            this.f2334b = z;
            int i10 = z ? 1 : -1;
            w wVar = w.this;
            int i11 = wVar.f2325c;
            wVar.f2325c = i10 + i11;
            if (!wVar.f2326d) {
                wVar.f2326d = true;
                while (true) {
                    try {
                        int i12 = wVar.f2325c;
                        if (i11 == i12) {
                            break;
                        }
                        boolean z3 = i11 == 0 && i12 > 0;
                        boolean z10 = i11 > 0 && i12 == 0;
                        if (z3) {
                            wVar.d();
                        } else if (z10) {
                            wVar.e();
                        }
                        i11 = i12;
                    } catch (Throwable th) {
                        wVar.f2326d = false;
                        throw th;
                    }
                }
                wVar.f2326d = false;
            }
            if (this.f2334b) {
                wVar.c(this);
            }
        }

        public abstract boolean d();

        public void c() {
        }
    }

    public void d() {
    }

    public void e() {
    }
}
