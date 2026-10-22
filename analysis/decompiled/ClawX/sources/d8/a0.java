package d8;

import java.io.EOFException;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1939a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1940b;

    public /* synthetic */ a0(int i8, Object obj) {
        this.f1939a = i8;
        this.f1940b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws ClosedChannelException {
        int i8 = this.f1939a;
        Object obj2 = this.f1940b;
        switch (i8) {
            case 0:
                ((b0.j) obj2).m(((Integer) obj).intValue());
                break;
            case 1:
                Selector selector = (Selector) obj;
                ConcurrentLinkedQueue concurrentLinkedQueue = ((i2) obj2).f2023l;
                while (!concurrentLinkedQueue.isEmpty()) {
                    g2 g2Var = (g2) concurrentLinkedQueue.poll();
                    if (g2Var != null) {
                        try {
                            if (g2Var.f2002a.isConnected()) {
                                g2Var.f2002a.keyFor(selector).interestOps(4);
                            } else {
                                g2Var.f2002a.register(selector, 8, g2Var);
                            }
                        } catch (IOException e9) {
                            g2Var.b(e9);
                        }
                    }
                }
                break;
            case 2:
                Selector selector2 = (Selector) obj;
                ConcurrentLinkedQueue concurrentLinkedQueue2 = ((l2) obj2).f2071o;
                while (!concurrentLinkedQueue2.isEmpty()) {
                    k2 k2Var = (k2) concurrentLinkedQueue2.poll();
                    if (k2Var != null) {
                        try {
                            l2.f2067q.e(Integer.valueOf(k2Var.f2047a));
                            k2Var.f2050e.register(selector2, 1, k2Var);
                            k2Var.c();
                        } catch (IOException e10) {
                            k2Var.b(e10);
                        }
                    }
                }
                break;
            default:
                ((k2) obj).b((EOFException) obj2);
                break;
        }
    }
}
