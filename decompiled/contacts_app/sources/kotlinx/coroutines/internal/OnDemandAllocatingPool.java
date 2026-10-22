package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OnDemandAllocatingPool.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\t\u0010\u0014\u001a\u00020\u0004H\u0082\bJ\r\u0010\u0015\u001a\u00020\r*\u00020\u0004H\u0082\bR\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", ExifInterface.GPS_DIRECTION_TRUE, "", "maxCapacity", "", ContractKt.OBRIC_ACTION_CREATE, "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)V", "controlState", "Lkotlinx/atomicfu/AtomicInt;", "elements", "Lkotlinx/atomicfu/AtomicArray;", "allocate", "", "close", "", "stateRepresentation", "", "stateRepresentation$kotlinx_coroutines_core", "toString", "tryForbidNewElements", "isClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnDemandAllocatingPool<T> {
    private static final AtomicIntegerFieldUpdater controlState$FU = null;

    @Volatile
    private volatile int controlState;
    private final Function1<Integer, T> create;
    private final AtomicReferenceArray elements;
    private final int maxCapacity;

    static {
        controlState$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");
    }

    private final boolean isClosed(int r1) {
        if ((Integer.MIN_VALUE & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater r1, Function1<? super Integer, Unit> r2, Object r3) {
    L2:
        r2.invoke(Integer.valueOf(r1.get(r3)));
        goto L2
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDemandAllocatingPool(int r1, Function1<? super Integer, ? extends T> r2) {
        this.maxCapacity = r1;
        this.create = r2;
        this.elements = new AtomicReferenceArray(r1);
    }

    private final int tryForbidNewElements() {
        AtomicIntegerFieldUpdater r0 = controlState$FU;
    L3:
        int r1 = r0.get(this);
        if ((r1 & Integer.MIN_VALUE) == 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L8;
        if (controlState$FU.compareAndSet(this, r1, Integer.MIN_VALUE | r1) == false) goto L3;
        return r1;
    L8:
        return 0;
    L6:
        r3 = false;
        goto L7
    }

    public final boolean allocate() {
        AtomicIntegerFieldUpdater r0 = controlState$FU;
    L3:
        int r1 = r0.get(this);
        if ((Integer.MIN_VALUE & r1) == 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L8;
        if (r1 >= this.maxCapacity) goto L11;
        if (controlState$FU.compareAndSet(this, r1, r1 + 1) == false) goto L3;
        this.elements.set(r1, this.create.invoke(Integer.valueOf(r1)));
        return true;
    L11:
        return true;
    L8:
        return false;
    L6:
        r2 = false;
        goto L7
    }

    public final List<T> close() {
        AtomicIntegerFieldUpdater r0 = controlState$FU;
    L3:
        int r1 = r0.get(this);
        if ((r1 & Integer.MIN_VALUE) == 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L8;
        if (controlState$FU.compareAndSet(this, r1, Integer.MIN_VALUE | r1) == false) goto L3;
    L11:
        IntRange r2 = RangesKt.until(0, r1);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<Integer> r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        int r6 = ((IntIterator) r5).nextInt();
    L15:
        Object r7 = this.elements.getAndSet(r6, null);
        if (r7 == null) goto L15;
        r4.add(r7);
        goto L13
    L19:
        return r4;
    L8:
        r1 = 0;
        goto L11
    L6:
        r3 = false;
        goto L7
    }

    public final String stateRepresentation$kotlinx_coroutines_core() {
        int r0 = controlState$FU.get(this);
        boolean r2 = false;
        IntRange r1 = RangesKt.until(0, Integer.MAX_VALUE & r0);
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<Integer> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(this.elements.get(((IntIterator) r4).nextInt()));
        goto L4
    L6:
        String r6 = r3.toString();
        if ((r0 & Integer.MIN_VALUE) == 0) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r5 = "[closed]";
    L13:
        return r6 + r5;
    L11:
        r5 = "";
        goto L13
    }

    public String toString() {
        return "OnDemandAllocatingPool(" + stateRepresentation$kotlinx_coroutines_core() + ')';
    }
}
