package X;

import V3.v;
import W3.C0403n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import s4.I;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final e f5769a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, AutoCloseable> f5770b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<AutoCloseable> f5771c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f5772d;

    public i() {
        this.f5769a = new e();
        this.f5770b = new LinkedHashMap();
        this.f5771c = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                f.a(autoCloseable);
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    public final void d(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        j4.k.g(str, "key");
        j4.k.g(autoCloseable, "closeable");
        if (this.f5772d) {
            f(autoCloseable);
            return;
        }
        synchronized (this.f5769a) {
            autoCloseable2 = (AutoCloseable) this.f5770b.put(str, autoCloseable);
        }
        f(autoCloseable2);
    }

    public final void e() {
        if (this.f5772d) {
            return;
        }
        this.f5772d = true;
        synchronized (this.f5769a) {
            try {
                Iterator it = this.f5770b.values().iterator();
                while (it.hasNext()) {
                    f((AutoCloseable) it.next());
                }
                Iterator it2 = this.f5771c.iterator();
                while (it2.hasNext()) {
                    f((AutoCloseable) it2.next());
                }
                this.f5771c.clear();
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <T extends AutoCloseable> T g(String str) {
        T t5;
        j4.k.g(str, "key");
        synchronized (this.f5769a) {
            t5 = (T) this.f5770b.get(str);
        }
        return t5;
    }

    public i(I i5) {
        j4.k.g(i5, "viewModelScope");
        this.f5769a = new e();
        this.f5770b = new LinkedHashMap();
        this.f5771c = new LinkedHashSet();
        d("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", b.a(i5));
    }

    public i(AutoCloseable... autoCloseableArr) {
        j4.k.g(autoCloseableArr, "closeables");
        this.f5769a = new e();
        this.f5770b = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f5771c = linkedHashSet;
        C0403n.u(linkedHashSet, autoCloseableArr);
    }

    public i(I i5, AutoCloseable... autoCloseableArr) {
        j4.k.g(i5, "viewModelScope");
        j4.k.g(autoCloseableArr, "closeables");
        this.f5769a = new e();
        this.f5770b = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f5771c = linkedHashSet;
        d("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", b.a(i5));
        C0403n.u(linkedHashSet, autoCloseableArr);
    }
}
