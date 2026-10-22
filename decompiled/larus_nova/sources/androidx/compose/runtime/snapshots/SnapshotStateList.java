package androidx.compose.runtime.snapshots;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 H*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006:\u0001HB\u0017\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0016H\u0096\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001aH\u0016J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0096\u0002J\u0015\u0010(\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001d\u00100\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001e\u00102\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u00102\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\u0015\u00104\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u00105\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0015\u00106\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\"J\u0016\u00107\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u001e\u00108\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016J+\u0010;\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0016H\u0000¢\u0006\u0002\b>J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0016H\u0016J\b\u0010G\u001a\u00020\u0016H\u0016R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148AX\u0080\u0004¢\u0006\f\u0012\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010B¨\u0006I"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "persistentList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toList", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "add", "(ILjava/lang/Object;)V", "addAll", "clear", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeRange", "retainAllInRange", "start", "end", "retainAllInRange$runtime", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "describeContents", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateList<T> implements Parcelable, StateObject, List<T>, RandomAccess, KMutableList {
    public static final int $stable = 0;
    public static final Parcelable.Creator<SnapshotStateList<Object>> CREATOR = null;
    public static final Companion Companion = null;
    private StateRecord firstStateRecord;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getCREATOR$annotations", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }

    public static /* synthetic */ boolean a(Collection r100, List r101) {
        return retainAll$lambda$10(r100, r101);
    }

    public static /* synthetic */ boolean c(int r100, Collection r101, List r102) {
        return addAll$lambda$4(r100, r101, r102);
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

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new SnapshotStateList$Companion$CREATOR$1();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    public SnapshotStateList() {
        this(ExtensionsKt.persistentListOf());
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r101 = (StateListStateRecord) r100;
        Object r102 = SnapshotKt.getLock();
        monitor-enter(r102);
        Snapshot r103 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L14
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.writableRecord(r101, this, r103);     // Catch: Throwable -> L14
        Object r105 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L14
        monitor-enter(r105);     // Catch: Throwable -> L14
        r104.setList$runtime(ExtensionsKt.persistentListOf());     // Catch: Throwable -> L11
        r104.setModification$runtime(r104.getModification$runtime() + 1);     // Catch: Throwable -> L11
        r104.setStructuralChange$runtime(r104.getStructuralChange$runtime() + 1);     // Catch: Throwable -> L11
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

    public final List<T> getDebuggerDisplayValue() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) r100)).getList$runtime();
    }

    public int getSize() {
        return SnapshotStateListKt.getReadable(this).getList$runtime().size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return SnapshotStateListKt.getReadable(this).getList$runtime().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final List<T> toList() {
        return SnapshotStateListKt.getReadable(this).getList$runtime();
    }

    public String toString() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) r100)).getList$runtime() + ")@" + hashCode();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public SnapshotStateList(PersistentList<? extends T> r100) {
        this.firstStateRecord = SnapshotStateListKt.stateRecordWith(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r100) {
    L2:
        Object r101 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r103 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r105 = r103.getList$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentList<T> r107 = r105.add(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r109 = (StateListStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107, true);     // Catch: Throwable -> L17
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

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r100) {
    L2:
        Object r101 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r103 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r105 = r103.getList$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentList<T> r107 = r105.addAll(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r109 = (StateListStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107, true);     // Catch: Throwable -> L17
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

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r100) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().contains(r100);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r100) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().containsAll(r100);
    }

    @Override // java.util.List
    public T get(int r100) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().get(r100);
    }

    @Override // java.util.List
    public int indexOf(Object r100) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().indexOf(r100);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r100) {
        return SnapshotStateListKt.getReadable(this).getList$runtime().lastIndexOf(r100);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r100) {
        return new StateListIterator(this, r100);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r100) {
        r100.setNext$runtime(getFirstStateRecord());
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateListStateRecord) r100;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r100) {
    L2:
        Object r101 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r103 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r105 = r103.getList$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentList<T> r107 = r105.remove(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r109 = (StateListStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107, true);     // Catch: Throwable -> L17
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

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r100) {
    L2:
        Object r101 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r103 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r102);     // Catch: Throwable -> L20
        int r104 = r103.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r105 = r103.getList$runtime();     // Catch: Throwable -> L20
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
        Intrinsics.checkNotNull(r105);
        PersistentList<T> r107 = r105.removeAll(r100);
        if (Intrinsics.areEqual(r107, r105) == true) goto L8;
        StateRecord r108 = getFirstStateRecord();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r109 = (StateListStateRecord) r108;
        Object r110 = SnapshotKt.getLock();
        monitor-enter(r110);
        Snapshot r111 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r112 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r109, this, r111), r104, r107, true);     // Catch: Throwable -> L17
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

    public T removeAt(int r100) {
        T r101 = get(r100);
    L3:
        Object r102 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r103);     // Catch: Throwable -> L20
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r106 = r104.getList$runtime();     // Catch: Throwable -> L20
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        Intrinsics.checkNotNull(r106);
        PersistentList<T> r108 = r106.removeAt(r100);
        if (Intrinsics.areEqual(r108, r106) == true) goto L16;
        StateRecord r109 = getFirstStateRecord();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r110 = (StateListStateRecord) r109;
        Object r111 = SnapshotKt.getLock();
        monitor-enter(r111);
        Snapshot r112 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r113 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r110, this, r112), r105, r108, true);     // Catch: Throwable -> L17
        monitor-exit(r111);
        SnapshotKt.notifyWrite(r112, this);
        if (r113 == false) goto L3;
    L17:
        th = move-exception;
        throw th;
    L16:
        return r101;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<?> r100) {
        return SnapshotStateListKt.mutateBoolean(this, new i(r100));
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int r100) {
        return removeAt(r100);
    }

    private static final boolean retainAll$lambda$10(Collection r100, List r101) {
        return r101.retainAll(r100);
    }

    @Override // java.util.List
    public void add(int r100, T r101) {
    L2:
        Object r102 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = getFirstStateRecord();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L19
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r103);     // Catch: Throwable -> L19
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L19
        PersistentList<T> r106 = r104.getList$runtime();     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        Intrinsics.checkNotNull(r106);
        PersistentList<T> r108 = r106.add(r100, r101);
        if (Intrinsics.areEqual(r108, r106) == true) goto L15;
        StateRecord r109 = getFirstStateRecord();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r110 = (StateListStateRecord) r109;
        Object r111 = SnapshotKt.getLock();
        monitor-enter(r111);
        Snapshot r112 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L16
        boolean r113 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r110, this, r112), r105, r108, true);     // Catch: Throwable -> L16
        monitor-exit(r111);
        SnapshotKt.notifyWrite(r112, this);
        if (r113 == false) goto L2;
        return;
    L16:
        th = move-exception;
        throw th;
    L15:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public boolean addAll(final int r100, final Collection<? extends T> r101) {
        return SnapshotStateListKt.mutateBoolean(this, new h(r100, r101));
    }

    public final void removeRange(int r100, int r101) {
    L2:
        Object r102 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = getFirstStateRecord();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L19
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r103);     // Catch: Throwable -> L19
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L19
        PersistentList<T> r106 = r104.getList$runtime();     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        Intrinsics.checkNotNull(r106);
        PersistentList.Builder<T> r108 = r106.builder();
        r108.subList(r100, r101).clear();
        PersistentList<T> r109 = r108.build();
        if (Intrinsics.areEqual(r109, r106) == true) goto L18;
        StateRecord r110 = getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r111 = (StateListStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        boolean r114 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r111, this, r113), r105, r109, true);     // Catch: Throwable -> L15
        monitor-exit(r112);
        SnapshotKt.notifyWrite(r113, this);
        if (r114 == false) goto L2;
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public T set(int r100, T r101) {
        T r102 = get(r100);
    L3:
        Object r103 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r103);
        StateRecord r104 = getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r105 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r104);     // Catch: Throwable -> L20
        int r106 = r105.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r107 = r105.getList$runtime();     // Catch: Throwable -> L20
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r103);
        Intrinsics.checkNotNull(r107);
        PersistentList<T> r109 = r107.set(r100, r101);
        if (Intrinsics.areEqual(r109, r107) == true) goto L16;
        StateRecord r110 = getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r111 = (StateListStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L17
        boolean r114 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r111, this, r113), r106, r109, false);     // Catch: Throwable -> L17
        monitor-exit(r112);
        SnapshotKt.notifyWrite(r113, this);
        if (r114 == false) goto L3;
    L17:
        th = move-exception;
        throw th;
    L16:
        return r102;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public List<T> subList(int r100, int r101) {
        boolean r102 = true;
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == true) goto L15;
        PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
    L15:
        return new SubList(this, r100, r101);
    L9:
        if (r101 > size()) goto L11;
    L6:
        r103 = false;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        List<T> r102 = toList();
        int r103 = r102.size();
        r100.writeInt(r103);
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.writeValue(ListProtector.get(r102, r104));
        r104 = r104 + 1;
        goto L3
    }

    private static final boolean addAll$lambda$4(int r100, Collection r101, List r102) {
        return r102.addAll(r100, r101);
    }

    public final int retainAllInRange$runtime(Collection<? extends T> r100, int r101, int r110) {
        int r102 = size();
    L3:
        Object r103 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r103);
        StateRecord r104 = getFirstStateRecord();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L21
        StateListStateRecord r105 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r104);     // Catch: Throwable -> L21
        int r106 = r105.getModification$runtime();     // Catch: Throwable -> L21
        PersistentList<T> r107 = r105.getList$runtime();     // Catch: Throwable -> L21
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        Intrinsics.checkNotNull(r107);
        PersistentList.Builder<T> r109 = r107.builder();
        r109.subList(r101, r110).retainAll(r100);
        PersistentList<T> r111 = r109.build();
        if (Intrinsics.areEqual(r111, r107) == true) goto L20;
        StateRecord r112 = getFirstStateRecord();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r113 = (StateListStateRecord) r112;
        Object r114 = SnapshotKt.getLock();
        monitor-enter(r114);
        Snapshot r115 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L16
        boolean r116 = SnapshotStateListKt.attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r113, this, r115), r106, r111, true);     // Catch: Throwable -> L16
        monitor-exit(r114);
        SnapshotKt.notifyWrite(r115, this);
        if (r116 == false) goto L3;
    L16:
        th = move-exception;
        throw th;
    L20:
        return r102 - size();
    L21:
        th = move-exception;
        throw th;
    }
}
