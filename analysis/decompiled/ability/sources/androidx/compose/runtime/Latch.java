package androidx.compose.runtime;

import C7.r;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;
import m9.InterfaceC1717j;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\u0003J\u0010\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u00060\u0001j\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/Latch;", "", AppAgent.CONSTRUCT, "()V", "R", "Lkotlin/Function0;", "block", "withClosed", "(LS7/a;)Ljava/lang/Object;", "LC7/r;", "closeLatch", "openLatch", "await", "(LH7/c;)Ljava/lang/Object;", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "", "LH7/c;", "awaiters", "Ljava/util/List;", "spareList", "", "_isOpen", "Z", "isOpen", "()Z", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Latch {
    public static final int $stable = 8;
    private final Object lock = new Object();
    private List<H7.c<r>> awaiters = new ArrayList();
    private List<H7.c<r>> spareList = new ArrayList();
    private boolean _isOpen = true;

    public final Object await(H7.c<? super r> cVar) {
        if (isOpen()) {
            return r.f317a;
        }
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        synchronized (this.lock) {
            this.awaiters.add(c1718k);
        }
        c1718k.j(new S7.k() { // from class: androidx.compose.runtime.Latch$await$2$2
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                Object obj = this.this$0.lock;
                Latch latch = this.this$0;
                InterfaceC1717j interfaceC1717j = c1718k;
                synchronized (obj) {
                    latch.awaiters.remove(interfaceC1717j);
                }
            }
        });
        Object objX = c1718k.x();
        return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
    }

    public final void closeLatch() {
        synchronized (this.lock) {
            this._isOpen = false;
        }
    }

    public final boolean isOpen() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this._isOpen;
        }
        return z10;
    }

    public final void openLatch() {
        synchronized (this.lock) {
            try {
                if (isOpen()) {
                    return;
                }
                List<H7.c<r>> list = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = list;
                this._isOpen = true;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).resumeWith(r.f317a);
                }
                list.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <R> R withClosed(S7.a block) {
        closeLatch();
        try {
            return (R) block.invoke();
        } finally {
            openLatch();
        }
    }
}
