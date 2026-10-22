package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 1*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006:\u00011B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\u0015\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010#\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u0015\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010&\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010'\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118AX\u0080\u0004¢\u0006\f\u0012\u0004\b)\u0010\b\u001a\u0004\b*\u0010+¨\u00062"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateSet;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toSet", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", "isEmpty", "iterator", "", "toString", "", "add", "addAll", "clear", "remove", "removeAll", "retainAll", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Set;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateSet<T> implements Parcelable, StateObject, Set<T>, RandomAccess, KMutableSet {
    public static final int $stable = 0;
    public static final Parcelable.Creator<SnapshotStateSet<Object>> CREATOR = null;
    public static final Companion Companion = null;
    private StateRecord firstStateRecord;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateSet$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getCREATOR$annotations", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }

    public static /* synthetic */ boolean a(Collection r100, Set r101) {
        return retainAll$lambda$5(r100, r101);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final /* synthetic */ StateRecord mergeRecords(StateRecord r100, StateRecord r101, StateRecord r102) {
        return StateObject.CC.$default$mergeRecords(this, r100, r101, r102);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new SnapshotStateSet$Companion$CREATOR$1();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new StateSetIterator(this, SnapshotStateSetKt.getReadable(this).getSet$runtime().iterator());
    }

    public SnapshotStateSet() {
        this.firstStateRecord = SnapshotStateSetKt.stateRecordWith(this, ExtensionsKt.persistentSetOf());
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r101 = (StateSetStateRecord) r100;
        Object r102 = SnapshotKt.getLock();
        monitor-enter(r102);
        Snapshot r103 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L14
        StateSetStateRecord r104 = (StateSetStateRecord) SnapshotKt.writableRecord(r101, this, r103);     // Catch: Throwable -> L14
        Object r105 = SnapshotStateSetKt.access$getSync$p();     // Catch: Throwable -> L14
        monitor-enter(r105);     // Catch: Throwable -> L14
        r104.setSet$runtime(ExtensionsKt.persistentSetOf());     // Catch: Throwable -> L11
        r104.setModification$runtime(r104.getModification$runtime() + 1);     // Catch: Throwable -> L11
        monitor-exit(r105);     // Catch: Throwable -> L14
        monitor-exit(r102);
        SnapshotKt.notifyWrite(r103, this);
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final Set<T> getDebuggerDisplayValue() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r100)).getSet$runtime();
    }

    public int getSize() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final Set<T> toSet() {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime();
    }

    public String toString() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return "SnapshotStateSet(value=" + ((StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r100)).getSet$runtime() + ")@" + hashCode();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T r100) {
    L2:
        Object r101 = SnapshotStateSetKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L20
        StateSetStateRecord r103 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentSet<T> r105 = r103.getSet$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentSet<T> r107 = r105.add(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r109 = (StateSetStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateSetKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107);     // Catch: Throwable -> L17
        monitor-exit(r110);
        SnapshotKt.notifyWrite(r111, this);
        if (r112 == false) goto L2;
        return true;
    L17:
        th = move-exception;
        throw th;
    L8:
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
    L2:
        Object r101 = SnapshotStateSetKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L20
        StateSetStateRecord r103 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentSet<T> r105 = r103.getSet$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentSet<T> r107 = r105.addAll(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r109 = (StateSetStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateSetKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107);     // Catch: Throwable -> L17
        monitor-exit(r110);
        SnapshotKt.notifyWrite(r111, this);
        if (r112 == false) goto L2;
        return true;
    L17:
        th = move-exception;
        throw th;
    L8:
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r100) {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().contains(r100);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return SnapshotStateSetKt.getReadable(this).getSet$runtime().containsAll(r100);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r100) {
        r100.setNext$runtime(getFirstStateRecord());
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        this.firstStateRecord = (StateSetStateRecord) r100;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r100) {
    L2:
        Object r101 = SnapshotStateSetKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L20
        StateSetStateRecord r103 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentSet<T> r105 = r103.getSet$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentSet<T> r107 = r105.remove(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r109 = (StateSetStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateSetKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107);     // Catch: Throwable -> L17
        monitor-exit(r110);
        SnapshotKt.notifyWrite(r111, this);
        if (r112 == false) goto L2;
        return true;
    L17:
        th = move-exception;
        throw th;
    L8:
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
    L2:
        Object r101 = SnapshotStateSetKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L20
        StateSetStateRecord r103 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentSet<T> r105 = r103.getSet$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentSet<T> r107 = r105.removeAll(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r109 = (StateSetStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateSetKt.attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107);     // Catch: Throwable -> L17
        monitor-exit(r110);
        SnapshotKt.notifyWrite(r111, this);
        if (r112 == false) goto L2;
        return true;
    L17:
        th = move-exception;
        throw th;
    L8:
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(final Collection<?> r100) {
        return SnapshotStateSetKt.mutateBoolean(this, new n(r100));
    }

    private static final boolean retainAll$lambda$5(Collection r100, Set r101) {
        return r101.retainAll(CollectionsKt.toSet(r100));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Set<T> r102 = toSet();
        r100.writeInt(size());
        Iterator<T> r103 = r102.iterator();
        if (r103.hasNext() == false) goto L6;
        r100.writeValue(r103.next());
        return;
    }
}
