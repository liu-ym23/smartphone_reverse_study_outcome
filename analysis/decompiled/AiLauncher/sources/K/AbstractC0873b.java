package K;

import D.C0777n;
import K.p0;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* renamed from: K.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0873b implements p0<List<C0777n>> {

    /* renamed from: c, reason: collision with root package name */
    public List<C0777n> f3941c;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3939a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f3940b = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    public Throwable f3942d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3943e = false;

    /* renamed from: K.b$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f3944a;

        /* renamed from: b, reason: collision with root package name */
        public final p0.a<? super List<C0777n>> f3945b;

        public a(Executor executor, p0.a<? super List<C0777n>> aVar) {
            this.f3944a = executor;
            this.f3945b = aVar;
        }
    }

    public AbstractC0873b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(C0777n.a.a(it.next()));
        }
        this.f3941c = arrayList;
    }

    public static /* synthetic */ void d(Throwable th, a aVar, List list) {
        if (th != null) {
            aVar.f3945b.onError(th);
        } else {
            aVar.f3945b.a(list);
        }
    }

    @Override // K.p0
    public void a(Executor executor, p0.a<? super List<C0777n>> aVar) {
        List<C0777n> listUnmodifiableList;
        Throwable th;
        B0.h.f(executor);
        B0.h.f(aVar);
        this.f3940b.add(new a(executor, aVar));
        synchronized (this.f3939a) {
            try {
                if (!this.f3943e && !this.f3940b.isEmpty()) {
                    Log.i("CameraPresenceSrc", "First observer added. Starting monitoring.");
                    this.f3943e = true;
                    f();
                }
                listUnmodifiableList = Collections.unmodifiableList(this.f3941c);
                th = this.f3942d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        e(new a(executor, aVar), listUnmodifiableList, th);
    }

    @Override // K.p0
    public void c(p0.a<? super List<C0777n>> aVar) {
        a next;
        B0.h.f(aVar);
        Iterator<a> it = this.f3940b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.f3945b.equals(aVar)) {
                    break;
                }
            }
        }
        if (next != null) {
            this.f3940b.remove(next);
        }
        synchronized (this.f3939a) {
            try {
                if (this.f3943e && this.f3940b.isEmpty()) {
                    Log.i("CameraPresenceSrc", "Last observer removed. Stopping monitoring.");
                    this.f3943e = false;
                    g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(final a aVar, final List<C0777n> list, final Throwable th) {
        aVar.f3944a.execute(new Runnable() { // from class: K.a
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC0873b.d(th, aVar, list);
            }
        });
    }

    public abstract void f();

    public abstract void g();

    public void h(List<C0777n> list) {
        j(list, null);
    }

    public void i(Throwable th) {
        j(null, th);
    }

    public final void j(List<C0777n> list, Throwable th) {
        boolean z10;
        List<C0777n> listUnmodifiableList;
        Throwable th2;
        synchronized (this.f3939a) {
            try {
                if (th != null) {
                    z10 = this.f3942d == null || !this.f3941c.isEmpty();
                    this.f3942d = th;
                    this.f3941c = Collections.EMPTY_LIST;
                } else {
                    B0.h.f(list);
                    boolean z11 = (this.f3942d == null && this.f3941c.equals(list)) ? false : true;
                    this.f3942d = null;
                    this.f3941c = list;
                    z10 = z11;
                }
                listUnmodifiableList = Collections.unmodifiableList(this.f3941c);
                th2 = this.f3942d;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Data changed. Notifying ");
            sb2.append(this.f3940b.size());
            sb2.append(" observers. Error: ");
            sb2.append(th2 != null);
            Log.d("CameraPresenceSrc", sb2.toString());
            Iterator<a> it = this.f3940b.iterator();
            while (it.hasNext()) {
                e(it.next(), listUnmodifiableList, th2);
            }
        }
    }
}
