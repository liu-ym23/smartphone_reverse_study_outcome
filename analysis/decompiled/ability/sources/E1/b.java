package E1;

import H4.o;
import g1.AbstractC1451a;
import java.io.Serializable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f454a;
    public final Serializable b;

    public b() {
        this.f454a = 2;
        this.b = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f454a) {
            case 0:
                return new Thread(runnable, (String) this.b);
            case 1:
                String str = (String) this.b;
                if (AbstractC1451a.f4467a) {
                    o.f("APM-AsyncTask", "creating newThread " + str);
                }
                return new Thread(new A.a(17, this, runnable), str);
            default:
                AtomicInteger atomicInteger = (AtomicInteger) this.b;
                if (atomicInteger.get() == Integer.MAX_VALUE) {
                    atomicInteger.set(0);
                }
                return new Thread(runnable, "ScheduleTask#" + atomicInteger.getAndIncrement());
        }
    }

    public b(String str, int i) {
        this.f454a = i;
        switch (i) {
            case 1:
                this.b = B7.a.k("APM6-", str);
                break;
            default:
                this.b = "MemoryWidget_".concat(str);
                break;
        }
    }
}
