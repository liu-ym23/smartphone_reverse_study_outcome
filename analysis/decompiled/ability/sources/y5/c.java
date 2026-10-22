package y5;

import S7.k;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f6899a;
    public static final ConcurrentLinkedDeque b = new ConcurrentLinkedDeque();
    public static final AtomicInteger c = new AtomicInteger(1);
    public static final ConcurrentLinkedDeque d = new ConcurrentLinkedDeque();

    public static void a(C2132b c2132b) {
        if (f6899a) {
            b.addLast(c2132b);
            while (true) {
                ConcurrentLinkedDeque concurrentLinkedDeque = b;
                if (concurrentLinkedDeque.size() <= 200) {
                    break;
                } else {
                    concurrentLinkedDeque.pollFirst();
                }
            }
            Iterator it = d.iterator();
            while (it.hasNext()) {
                try {
                    ((k) it.next()).invoke(c2132b);
                } catch (Throwable th) {
                    kotlin.b.a(th);
                }
            }
        }
    }
}
