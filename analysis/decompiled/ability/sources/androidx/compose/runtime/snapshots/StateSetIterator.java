package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0082\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R*\u0010\u0014\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u001e\u0012\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010!R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/compose/runtime/snapshots/StateSetIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "set", "", "iterator", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Ljava/util/Iterator;)V", "LC7/r;", "advance", "()V", "Lkotlin/Function0;", "block", "modify", "(LS7/a;)Ljava/lang/Object;", "validateModification", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "remove", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getSet", "()Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "current", "Ljava/lang/Object;", "getCurrent", "setCurrent", "(Ljava/lang/Object;)V", "getNext", "setNext", "getNext$annotations", "", "modification", "I", "getModification", "()I", "setModification", "(I)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StateSetIterator<T> implements Iterator<T>, T7.a {
    public static final int $stable = 8;
    private T current;
    private final Iterator<T> iterator;
    private int modification;
    private T next;
    private final SnapshotStateSet<T> set;

    /* JADX WARN: Multi-variable type inference failed */
    public StateSetIterator(SnapshotStateSet<T> snapshotStateSet, Iterator<? extends T> it) {
        this.set = snapshotStateSet;
        this.iterator = it;
        this.modification = SnapshotStateSetKt.getModification(snapshotStateSet);
        advance();
    }

    private final void advance() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? this.iterator.next() : null;
    }

    public static /* synthetic */ void getNext$annotations() {
    }

    private final <T> T modify(S7.a block) {
        validateModification();
        T t9 = (T) block.invoke();
        this.modification = SnapshotStateSetKt.getModification(this.set);
        return t9;
    }

    private final void validateModification() {
        if (SnapshotStateSetKt.getModification(this.set) != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    public final T getCurrent() {
        return this.current;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getModification() {
        return this.modification;
    }

    public final T getNext() {
        return this.next;
    }

    public final SnapshotStateSet<T> getSet() {
        return this.set;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public T next() {
        validateModification();
        advance();
        T t9 = this.current;
        if (t9 != null) {
            return t9;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public void remove() {
        validateModification();
        T t9 = this.current;
        if (t9 == null) {
            throw new IllegalStateException();
        }
        this.set.remove(t9);
        this.current = null;
        this.modification = SnapshotStateSetKt.getModification(this.set);
    }

    public final void setCurrent(T t9) {
        this.current = t9;
    }

    public final void setModification(int i) {
        this.modification = i;
    }

    public final void setNext(T t9) {
        this.next = t9;
    }
}
