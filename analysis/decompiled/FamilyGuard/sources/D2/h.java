package D2;

import android.os.Looper;

/* loaded from: classes.dex */
abstract class h<K, V> implements A<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private z<V> f1183a;

    /* renamed from: b, reason: collision with root package name */
    private v<K> f1184b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1185c = false;

    /* renamed from: d, reason: collision with root package name */
    private final Object f1186d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f1187e = false;

    /* renamed from: f, reason: collision with root package name */
    private u<K, V> f1188f;

    h() {
    }

    @Override // D2.A
    public void a(r<K, V> rVar, v<K> vVar, z<V> zVar, u<K, V> uVar) {
        this.f1184b = vVar;
        this.f1183a = zVar;
        this.f1188f = uVar;
    }

    @Override // D2.A
    public void b() {
        this.f1185c = false;
        synchronized (this.f1186d) {
            this.f1186d.notifyAll();
        }
    }

    @Override // D2.A
    public void c() {
        this.f1185c = true;
        synchronized (this.f1186d) {
            this.f1186d.notifyAll();
        }
    }

    @Override // D2.A
    public void cancel() {
        this.f1187e = true;
        this.f1184b = null;
        this.f1183a = null;
        synchronized (this.f1186d) {
            this.f1186d.notifyAll();
        }
    }

    @Override // D2.A
    public v<K> d() {
        return this.f1184b;
    }

    protected V e(v<K> vVar) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new AssertionError();
        }
        if (vVar == null) {
            return null;
        }
        synchronized (this.f1186d) {
            while (this.f1185c && !this.f1187e) {
                try {
                    this.f1186d.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        return g(vVar);
    }

    public boolean f() {
        return this.f1187e;
    }

    protected abstract V g(v<K> vVar);

    protected void h(V v5) {
        u<K, V> uVar = this.f1188f;
        if (uVar != null) {
            uVar.g(this, v5 != null, this.f1184b, this.f1183a, v5);
        }
    }
}
