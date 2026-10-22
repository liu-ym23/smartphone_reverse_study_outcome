package d8;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m0 implements x2 {
    public static final z7.b d = z7.d.b(m0.class);

    /* renamed from: e, reason: collision with root package name */
    public static final Duration f2078e = Duration.ofSeconds(10);

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f2079a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2080b;

    /* renamed from: c, reason: collision with root package name */
    public Duration f2081c;

    static {
        Duration.ofSeconds(5L);
    }

    public m0(x2[] x2VarArr) {
        List listAsList = Arrays.asList(x2VarArr);
        this.f2079a = new CopyOnWriteArrayList();
        new AtomicInteger();
        this.f2080b = 3;
        this.f2081c = f2078e;
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            this.f2079a.add(new l0((x2) it.next()));
        }
    }

    @Override // d8.x2
    public final CompletionStage b(j1 j1Var, Executor executor) {
        k0 k0Var = new k0(this, j1Var);
        return k0Var.b(executor).handle(new i0(k0Var, executor, 0)).thenCompose(Function.identity());
    }

    @Override // d8.x2
    public final Duration c() {
        return this.f2081c;
    }

    @Override // d8.x2
    public final CompletionStage d(j1 j1Var) {
        return b(j1Var, ForkJoinPool.commonPool());
    }

    public final String toString() {
        return "ExtendedResolver of " + this.f2079a;
    }
}
