package X0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class g<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f5791a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f5792b;

    /* renamed from: c, reason: collision with root package name */
    private long f5793c;

    /* renamed from: d, reason: collision with root package name */
    private long f5794d;

    public g(long j5) {
        this.f5792b = j5;
        this.f5793c = j5;
    }

    private void f() {
        m(this.f5793c);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t5) {
        return this.f5791a.get(t5);
    }

    public synchronized long h() {
        return this.f5793c;
    }

    protected int i(Y y5) {
        return 1;
    }

    protected void j(T t5, Y y5) {
    }

    public synchronized Y k(T t5, Y y5) {
        long jI = i(y5);
        if (jI >= this.f5793c) {
            j(t5, y5);
            return null;
        }
        if (y5 != null) {
            this.f5794d += jI;
        }
        Y yPut = this.f5791a.put(t5, y5);
        if (yPut != null) {
            this.f5794d -= i(yPut);
            if (!yPut.equals(y5)) {
                j(t5, yPut);
            }
        }
        f();
        return yPut;
    }

    public synchronized Y l(T t5) {
        Y yRemove;
        yRemove = this.f5791a.remove(t5);
        if (yRemove != null) {
            this.f5794d -= i(yRemove);
        }
        return yRemove;
    }

    protected synchronized void m(long j5) {
        while (this.f5794d > j5) {
            Iterator<Map.Entry<T, Y>> it = this.f5791a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f5794d -= i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
