package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001eH\u0004J\"\u0010\"\u001a\u0002H#\"\u0004\b\u0002\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0084\b¢\u0006\u0002\u0010&R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006'"}, d2 = {"Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "getIterator", "()Ljava/util/Iterator;", "modification", "", "getModification", "()I", "setModification", "(I)V", "current", "getCurrent", "()Ljava/util/Map$Entry;", "setCurrent", "(Ljava/util/Map$Entry;)V", TeaEventTrack.ACTION_DRAMA_NEXT, "getNext", "setNext", "remove", "", "hasNext", "", "advance", PriorityModule.OPERATOR_MODIFY, ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class StateMapMutableIterator<K, V> {
    private Map.Entry<? extends K, ? extends V> current;
    private final Iterator<Map.Entry<K, V>> iterator;
    private final SnapshotStateMap<K, V> map;
    private int modification;
    private Map.Entry<? extends K, ? extends V> next;

    public final void advance() {
        this.current = this.next;
        if (this.iterator.hasNext() == false) goto L5;
        Map.Entry<K, V> r100 = this.iterator.next();
    L6:
        this.next = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    public final boolean hasNext() {
        if (this.next == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void remove() {
        if (getMap().getModification$runtime() != access$getModification(this)) goto L11;
        Map.Entry<? extends K, ? extends V> r100 = this.current;
        if (r100 == null) goto L9;
        this.map.remove(r100.getKey());
        this.current = null;
        Unit r101 = Unit.INSTANCE;
        access$setModification(this, getMap().getModification$runtime());
        return;
    L9:
        throw new IllegalStateException();
    L11:
        throw new ConcurrentModificationException();
    }

    public final Map.Entry<K, V> getCurrent() {
        return this.current;
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public final SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    public final int getModification() {
        return this.modification;
    }

    public final Map.Entry<K, V> getNext() {
        return this.next;
    }

    public static final /* synthetic */ int access$getModification(StateMapMutableIterator r100) {
        return r100.modification;
    }

    public final <T> T modify(Function0<? extends T> r100) {
        if (getMap().getModification$runtime() != access$getModification(this)) goto L7;
        T r101 = r100.invoke();
        access$setModification(this, getMap().getModification$runtime());
        return r101;
    L7:
        throw new ConcurrentModificationException();
    }

    public final void setCurrent(Map.Entry<? extends K, ? extends V> r100) {
        this.current = r100;
    }

    public final void setModification(int r100) {
        this.modification = r100;
    }

    public final void setNext(Map.Entry<? extends K, ? extends V> r100) {
        this.next = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StateMapMutableIterator(SnapshotStateMap<K, V> r100, Iterator<? extends Map.Entry<? extends K, ? extends V>> r101) {
        this.map = r100;
        this.iterator = r101;
        this.modification = r100.getModification$runtime();
        advance();
    }

    public static final /* synthetic */ void access$setModification(StateMapMutableIterator r100, int r101) {
        r100.modification = r101;
    }
}
