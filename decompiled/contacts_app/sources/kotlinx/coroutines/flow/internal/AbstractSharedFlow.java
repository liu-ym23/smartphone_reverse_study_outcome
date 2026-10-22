package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u0017\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001b\u001a\u00020\tH$¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0 H\u0084\bJ\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010#R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int r1);

    public AbstractSharedFlow() {
    }

    public static final /* synthetic */ int access$getNCollectors(AbstractSharedFlow r0) {
        return r0.nCollectors;
    }

    public static final /* synthetic */ AbstractSharedFlowSlot[] access$getSlots(AbstractSharedFlow r0) {
        return r0.slots;
    }

    protected final S[] getSlots() {
        return this.slots;
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final void forEachSlotLocked(Function1<? super S, Unit> r4) {
        if (access$getNCollectors(this) != 0) goto L5;
        return;
    L5:
        AbstractSharedFlowSlot[] r3 = access$getSlots(this);
        if (r3 == null) goto L13;
        int r0 = r3.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        AbstractSharedFlowSlot r2 = r3[r1];
        if (r2 == null) goto L12;
        r4.invoke(r2);
    L12:
        r1 = r1 + 1;
        goto L8
    L17:
        return;
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        monitor-enter(this);
        SubscriptionCountStateFlow r0 = this._subscriptionCount;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = new SubscriptionCountStateFlow(this.nCollectors);     // Catch: Throwable -> L9
        this._subscriptionCount = r0;     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    protected final S allocateSlot() {
        monitor-enter(this);
        S[] r0 = this.slots;     // Catch: Throwable -> L23
        if (r0 != null) goto L7;
        r0 = (S[]) createSlotArray(2);
        this.slots = r0;     // Catch: Throwable -> L23
    L9:
        int r1 = this.nextIndex;     // Catch: Throwable -> L23
    L10:
        S r2 = r0[r1];     // Catch: Throwable -> L23
        if (r2 != null) goto L13;
        r2 = (S) createSlot();
        r0[r1] = r2;     // Catch: Throwable -> L23
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        if (r1 < r0.length) goto L16;
        r1 = 0;
    L16:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r2.allocateLocked(this) == false) goto L10;
        this.nextIndex = r1;     // Catch: Throwable -> L23
        this.nCollectors++;     // Catch: Throwable -> L23
        SubscriptionCountStateFlow r3 = this._subscriptionCount;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r3 == null) goto L22;
        r3.increment(1);
    L22:
        return r2;
    L7:
        if (this.nCollectors < r0.length) goto L9;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");     // Catch: Throwable -> L23
        this.slots = (S[]) ((AbstractSharedFlowSlot[]) r4);     // Catch: Throwable -> L23
        r0 = (S[]) ((AbstractSharedFlowSlot[]) r4);
    L23:
        th = move-exception;
        throw th;
    }

    protected final void freeSlot(S r6) {
        monitor-enter(this);
        int r0 = this.nCollectors - 1;     // Catch: Throwable -> L17
        this.nCollectors = r0;     // Catch: Throwable -> L17
        SubscriptionCountStateFlow r2 = this._subscriptionCount;     // Catch: Throwable -> L17
        int r3 = 0;
        if (r0 != 0) goto L6;
        this.nextIndex = 0;     // Catch: Throwable -> L17
    L6:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        Continuation<Unit>[] r7 = r6.freeLocked(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r5 = r7.length;
    L9:
        if (r3 >= r5) goto L14;
        Continuation<Unit> r1 = r7[r3];
        if (r1 == null) goto L13;
        Result.Companion r4 = Result.Companion;
        r1.resumeWith(Result.m803constructorimpl(Unit.INSTANCE));
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r2 == null) goto L25;
        r2.increment(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
