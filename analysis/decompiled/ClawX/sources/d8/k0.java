package d8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final j1 f2042a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2043b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2044c;
    public final long d;

    /* renamed from: e, reason: collision with root package name */
    public final List f2045e;

    /* renamed from: f, reason: collision with root package name */
    public int f2046f;

    public k0(m0 m0Var, j1 j1Var) {
        ArrayList arrayList = new ArrayList(m0Var.f2079a);
        this.f2045e = arrayList;
        this.d = m0Var.f2081c.toNanos() + System.nanoTime();
        z7.b bVar = m0.d;
        List list = (List) arrayList.stream().sorted(Comparator.comparingInt(new h0())).collect(Collectors.toList());
        this.f2045e = list;
        this.f2043b = new int[list.size()];
        this.f2044c = m0Var.f2080b;
        this.f2042a = j1Var;
    }

    public final CompletionStage a(j1 j1Var, Throwable th, Executor executor) {
        int i8 = this.f2046f;
        List list = this.f2045e;
        AtomicInteger atomicInteger = ((l0) list.get(i8)).f2061b;
        if (th == null) {
            atomicInteger.updateAndGet(new j0());
            return CompletableFuture.completedFuture(j1Var);
        }
        z7.b bVar = m0.d;
        j1 j1Var2 = this.f2042a;
        x1 x1Var = j1Var2.d().f2195a;
        int i9 = j1Var2.d().f2196b;
        l3 l3Var = f4.f1995a;
        String strD = l3Var.d(i9);
        Integer numValueOf = Integer.valueOf(j1Var2.f2031a.f2175a);
        Integer numValueOf2 = Integer.valueOf(this.f2046f);
        x2 x2Var = ((l0) list.get(this.f2046f)).f2060a;
        int i10 = this.f2046f;
        int[] iArr = this.f2043b;
        Integer numValueOf3 = Integer.valueOf(iArr[i10]);
        int i11 = this.f2044c;
        bVar.a("Failed to resolve {}/{}, id={} with resolver {} ({}) on attempt {} of {}, reason={}", x1Var, strD, numValueOf, numValueOf2, x2Var, numValueOf3, Integer.valueOf(i11), th.getMessage());
        atomicInteger.incrementAndGet();
        if (this.d - System.nanoTime() >= 0) {
            int size = (this.f2046f + 1) % list.size();
            this.f2046f = size;
            if (iArr[size] < i11) {
                return b(executor).handle(new i0(this, executor, 1)).thenCompose(Function.identity());
            }
            CompletableFuture completableFuture = new CompletableFuture();
            completableFuture.completeExceptionally(th);
            return completableFuture;
        }
        CompletableFuture completableFuture2 = new CompletableFuture();
        completableFuture2.completeExceptionally(new IOException("Timed out while trying to resolve " + j1Var2.d().f2195a + "/" + l3Var.d(j1Var2.d().f2196b) + ", id=" + j1Var2.f2031a.f2175a));
        return completableFuture2;
    }

    public final CompletionStage b(Executor executor) {
        l0 l0Var = (l0) this.f2045e.get(this.f2046f);
        z7.b bVar = m0.d;
        j1 j1Var = this.f2042a;
        x1 x1Var = j1Var.d().f2195a;
        String strD = f4.f1995a.d(j1Var.d().f2196b);
        Integer numValueOf = Integer.valueOf(j1Var.f2031a.f2175a);
        Integer numValueOf2 = Integer.valueOf(this.f2046f);
        x2 x2Var = l0Var.f2060a;
        int i8 = this.f2046f;
        int[] iArr = this.f2043b;
        bVar.a("Sending {}/{}, id={} to resolver {} ({}), attempt {} of {}", x1Var, strD, numValueOf, numValueOf2, x2Var, Integer.valueOf(iArr[i8] + 1), Integer.valueOf(this.f2044c));
        int i9 = this.f2046f;
        iArr[i9] = iArr[i9] + 1;
        return l0Var.f2060a.b(j1Var, executor);
    }
}
