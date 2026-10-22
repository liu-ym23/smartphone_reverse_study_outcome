package d8;

import java.io.EOFException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i2 extends b2 {

    /* renamed from: n, reason: collision with root package name */
    public static final z7.b f2022n = z7.d.b(i2.class);

    /* renamed from: l, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2023l = new ConcurrentLinkedQueue();

    /* renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f2024m = new ConcurrentHashMap();

    public i2() {
        b2.d = new a0(1, this);
        final int i8 = 0;
        b2.f1954c[0] = new Runnable(this) { // from class: d8.c2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i2 f1965b;

            {
                this.f1965b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i8) {
                    case 0:
                        Iterator it = this.f1965b.f2024m.values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((g2) it.next()).f2003b.iterator();
                            while (it2.hasNext()) {
                                h2 h2Var = (h2) it2.next();
                                if (h2Var.f2011c - System.nanoTime() < 0) {
                                    h2Var.f2012e.completeExceptionally(new SocketTimeoutException("Query timed out"));
                                    it2.remove();
                                }
                            }
                        }
                        break;
                    default:
                        i2 i2Var = this.f1965b;
                        i2Var.f2023l.clear();
                        final EOFException eOFException = new EOFException("Client is closing");
                        ConcurrentHashMap concurrentHashMap = i2Var.f2024m;
                        concurrentHashMap.forEach(new BiConsumer() { // from class: d8.d2
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                g2 g2Var = (g2) obj2;
                                Iterator it3 = g2Var.f2003b.iterator();
                                while (true) {
                                    boolean zHasNext = it3.hasNext();
                                    EOFException eOFException2 = eOFException;
                                    if (!zHasNext) {
                                        g2Var.b(eOFException2);
                                        return;
                                    } else {
                                        ((h2) it3.next()).f2012e.completeExceptionally(eOFException2);
                                        it3.remove();
                                    }
                                }
                            }
                        });
                        concurrentHashMap.clear();
                        break;
                }
            }
        };
        final int i9 = 1;
        b2.f1956f[0] = new Runnable(this) { // from class: d8.c2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i2 f1965b;

            {
                this.f1965b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i9) {
                    case 0:
                        Iterator it = this.f1965b.f2024m.values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((g2) it.next()).f2003b.iterator();
                            while (it2.hasNext()) {
                                h2 h2Var = (h2) it2.next();
                                if (h2Var.f2011c - System.nanoTime() < 0) {
                                    h2Var.f2012e.completeExceptionally(new SocketTimeoutException("Query timed out"));
                                    it2.remove();
                                }
                            }
                        }
                        break;
                    default:
                        i2 i2Var = this.f1965b;
                        i2Var.f2023l.clear();
                        final EOFException eOFException = new EOFException("Client is closing");
                        ConcurrentHashMap concurrentHashMap = i2Var.f2024m;
                        concurrentHashMap.forEach(new BiConsumer() { // from class: d8.d2
                            @Override // java.util.function.BiConsumer
                            public final void accept(Object obj, Object obj2) {
                                g2 g2Var = (g2) obj2;
                                Iterator it3 = g2Var.f2003b.iterator();
                                while (true) {
                                    boolean zHasNext = it3.hasNext();
                                    EOFException eOFException2 = eOFException;
                                    if (!zHasNext) {
                                        g2Var.b(eOFException2);
                                        return;
                                    } else {
                                        ((h2) it3.next()).f2012e.completeExceptionally(eOFException2);
                                        it3.remove();
                                    }
                                }
                            }
                        });
                        concurrentHashMap.clear();
                        break;
                }
            }
        };
    }
}
