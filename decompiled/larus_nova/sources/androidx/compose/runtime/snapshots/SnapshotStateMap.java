package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001RB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fJ\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\rH\u0016J\u001f\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020\r2\u0014\u0010-\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0016J\u0017\u0010.\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0017\u00101\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00028\u0001H\u0000¢\u0006\u0004\b2\u0010\u0017J.\u00108\u001a\u00020\u00152\u001e\u00109\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b;J.\u0010<\u001a\u00020\u00152\u001e\u00109\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b>J.\u0010?\u001a\u00020\u00152\u001e\u00109\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=\u0012\u0004\u0012\u00020\u00150:H\u0080\b¢\u0006\u0002\b@J9\u0010E\u001a\u0002HF\"\u0004\b\u0002\u0010F2#\u0010G\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104\u0012\u0004\u0012\u0002HF0:¢\u0006\u0002\bHH\u0082\b¢\u0006\u0002\u0010IJ9\u0010J\u001a\u0002HF\"\u0004\b\u0002\u0010F2#\u0010G\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104\u0012\u0004\u0012\u0002HF0:¢\u0006\u0002\bHH\u0082\b¢\u0006\u0002\u0010IJ4\u0010K\u001a\u0002HF\"\u0004\b\u0002\u0010F2\u001e\u0010G\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u0002HF0:H\u0082\b¢\u0006\u0002\u0010IJ4\u0010L\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001042\u0006\u0010M\u001a\u00020\u00112\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010OH\u0002J5\u0010P\u001a\u00020\r2*\u0010G\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O0:H\u0082\bJ,\u0010Q\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001042\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010OH\u0002R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010/\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0013R&\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001048@X\u0080\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001a\u0004\b6\u00107R&\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f8AX\u0080\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0006\u001a\u0004\bC\u0010D¨\u0006S"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "Landroidx/compose/runtime/snapshots/StateObject;", "", "<init>", "()V", "value", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "toMap", "", "size", "", "getSize", "()I", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "toString", "", "clear", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "modification", "getModification$runtime", "removeValue", "removeValue$runtime", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime$annotations", "getReadable$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "removeIf", "predicate", "Lkotlin/Function1;", "removeIf$runtime", "any", "", "any$runtime", "all", "all$runtime", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "withCurrent", "R", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "mutate", "attemptUpdate", "currentModification", "newMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "update", "commitUpdate", "StateMapStateRecord", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateMap<K, V> implements StateObject, Map<K, V>, KMutableMap {
    public static final int $stable = 0;
    private final Set<Map.Entry<K, V>> entries;
    private StateRecord firstStateRecord;
    private final Set<K> keys;
    private final Collection<V> values;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B)\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0019\u0010\u0018\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0002\u0010\u0019R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "<init>", "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "modification", "", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        public static final int $stable = 8;
        private PersistentMap<K, ? extends V> map;
        private int modification;

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateMapStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.map);
        }

        public final PersistentMap<K, V> getMap$runtime() {
            return this.map;
        }

        public final int getModification$runtime() {
            return this.modification;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord r100) {
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            StateMapStateRecord r101 = (StateMapStateRecord) r100;
            Object r102 = SnapshotStateMapKt.access$getSync$p();
            monitor-enter(r102);
            this.map = r101.map;     // Catch: Throwable -> L7
            this.modification = r101.modification;     // Catch: Throwable -> L7
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r102);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create(long r100) {
            return new StateMapStateRecord(r100, this.map);
        }

        public final void setMap$runtime(PersistentMap<K, ? extends V> r100) {
            this.map = r100;
        }

        public final void setModification$runtime(int r100) {
            this.modification = r100;
        }

        public StateMapStateRecord(long r100, PersistentMap<K, ? extends V> r101) {
            super(r100);
            this.map = r101;
        }
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime$annotations() {
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final /* synthetic */ StateRecord mergeRecords(StateRecord r100, StateRecord r101, StateRecord r102) {
        return StateObject.CC.$default$mergeRecords(this, r100, r101, r102);
    }

    public SnapshotStateMap() {
        PersistentMap r100 = ExtensionsKt.persistentHashMapOf();
        Snapshot r101 = SnapshotKt.currentSnapshot();
        StateMapStateRecord r102 = new StateMapStateRecord(r101.getSnapshotId(), r100);
        if ((r101 instanceof GlobalSnapshot) == true) goto L5;
        r102.setNext$runtime(new StateMapStateRecord(SnapshotId_jvmKt.toSnapshotId(1), r100));
    L5:
        this.firstStateRecord = r102;
        this.entries = new SnapshotMapEntrySet(this);
        this.keys = new SnapshotMapKeySet(this);
        this.values = new SnapshotMapValueSet(this);
    }

    @Override // java.util.Map
    public void clear() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r101 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r100);
        r101.getMap$runtime();
        PersistentMap<K, ? extends V> r102 = ExtensionsKt.persistentHashMapOf();
        if (r102 == r101.getMap$runtime()) goto L12;
        StateRecord r103 = getFirstStateRecord();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r104 = (StateMapStateRecord) r103;
        Object r105 = SnapshotKt.getLock();
        monitor-enter(r105);
        Snapshot r106 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L9
        commitUpdate((StateMapStateRecord) SnapshotKt.writableRecord(r104, this, r106), r102);     // Catch: Throwable -> L9
        monitor-exit(r105);
        SnapshotKt.notifyWrite(r106, this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r100)).getMap$runtime();
    }

    public final int getModification$runtime() {
        return getReadable$runtime().getModification$runtime();
    }

    public final StateMapStateRecord<K, V> getReadable$runtime() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) r100, this);
    }

    public int getSize() {
        return getReadable$runtime().getMap$runtime().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getReadable$runtime().getMap$runtime().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final Map<K, V> toMap() {
        return getReadable$runtime().getMap$runtime();
    }

    public String toString() {
        StateRecord r100 = getFirstStateRecord();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r100)).getMap$runtime() + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public Collection<V> getValues() {
        return this.values;
    }

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> r100) {
    L2:
        Object r101 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L24
        StateMapStateRecord r103 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r102);     // Catch: Throwable -> L24
        PersistentMap<K, V> r104 = r103.getMap$runtime();     // Catch: Throwable -> L24
        int r105 = r103.getModification$runtime();     // Catch: Throwable -> L24
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L24
        InlineMarker.finallyStart(1);
        monitor-exit(r101);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r104);
        PersistentMap.Builder<K, V> r107 = r104.builder();
        R r108 = r100.invoke(r107);
        PersistentMap<K, V> r109 = r107.build();
        if (Intrinsics.areEqual(r109, r104) == true) goto L23;
        StateRecord r110 = getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r111 = (StateMapStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L18
        boolean r114 = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(r111, this, r113), r105, r109);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        monitor-exit(r112);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r113, this);
        if (r114 == false) goto L2;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        return r108;
    L24:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> r100) {
        StateRecord r101 = getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r102 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r101);
        PersistentMap<K, ? extends V> r103 = r100.invoke(r102.getMap$runtime());
        if (r103 == r102.getMap$runtime()) goto L16;
        StateRecord r104 = getFirstStateRecord();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r105 = (StateMapStateRecord) r104;
        Object r106 = SnapshotKt.getLock();
        monitor-enter(r106);
        Snapshot r107 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L11
        commitUpdate((StateMapStateRecord) SnapshotKt.writableRecord(r105, this, r107), r103);     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        monitor-exit(r106);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r107, this);
        return;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> r100) {
        StateRecord r101 = getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return r100.invoke(SnapshotKt.current((StateMapStateRecord) r101));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> r100) {
        StateRecord r101 = getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r102 = (StateMapStateRecord) r101;
        Object r103 = SnapshotKt.getLock();
        monitor-enter(r103);
        Snapshot r104 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r105 = r100.invoke(SnapshotKt.writableRecord(r102, this, r104));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r103);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r104, this);
        return r105;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final boolean all$runtime(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r100) {
        Iterator<E> r101 = ((ImmutableSet) getReadable$runtime().getMap$runtime().entrySet()).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.invoke((Map.Entry) r101.next()).booleanValue() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final boolean any$runtime(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r100) {
        Iterator<E> r101 = ((ImmutableSet) getReadable$runtime().getMap$runtime().entrySet()).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.invoke((Map.Entry) r101.next()).booleanValue() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r100) {
        return getReadable$runtime().getMap$runtime().containsKey(r100);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r100) {
        return getReadable$runtime().getMap$runtime().containsValue(r100);
    }

    @Override // java.util.Map
    public V get(Object r100) {
        return getReadable$runtime().getMap$runtime().get(r100);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.firstStateRecord = (StateMapStateRecord) r100;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r100) {
    L2:
        Object r101 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L19
        StateMapStateRecord r103 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r102);     // Catch: Throwable -> L19
        PersistentMap<K, V> r104 = r103.getMap$runtime();     // Catch: Throwable -> L19
        int r105 = r103.getModification$runtime();     // Catch: Throwable -> L19
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        Intrinsics.checkNotNull(r104);
        PersistentMap.Builder<K, V> r107 = r104.builder();
        r107.putAll(r100);
        PersistentMap<K, V> r108 = r107.build();
        if (Intrinsics.areEqual(r108, r104) == true) goto L18;
        StateRecord r109 = getFirstStateRecord();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r110 = (StateMapStateRecord) r109;
        Object r111 = SnapshotKt.getLock();
        monitor-enter(r111);
        Snapshot r112 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        boolean r113 = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(r110, this, r112), r105, r108);     // Catch: Throwable -> L15
        monitor-exit(r111);
        SnapshotKt.notifyWrite(r112, this);
        if (r113 == false) goto L2;
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

    @Override // java.util.Map
    public V remove(Object r100) {
    L2:
        Object r101 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r101);
        StateRecord r102 = getFirstStateRecord();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L19
        StateMapStateRecord r103 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r102);     // Catch: Throwable -> L19
        PersistentMap<K, V> r104 = r103.getMap$runtime();     // Catch: Throwable -> L19
        int r105 = r103.getModification$runtime();     // Catch: Throwable -> L19
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        Intrinsics.checkNotNull(r104);
        PersistentMap.Builder<K, V> r107 = r104.builder();
        V r108 = r107.remove(r100);
        PersistentMap<K, V> r109 = r107.build();
        if (Intrinsics.areEqual(r109, r104) == true) goto L18;
        StateRecord r110 = getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r111 = (StateMapStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        boolean r114 = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(r111, this, r113), r105, r109);     // Catch: Throwable -> L15
        monitor-exit(r112);
        SnapshotKt.notifyWrite(r113, this);
        if (r114 == false) goto L2;
    L15:
        th = move-exception;
        throw th;
    L18:
        return r108;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean removeIf$runtime(Function1<? super Map.Entry<K, V>, Boolean> r100) {
        boolean r101 = false;
    L3:
        Object r102 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L31
        StateMapStateRecord r104 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r103);     // Catch: Throwable -> L31
        PersistentMap<K, V> r105 = r104.getMap$runtime();     // Catch: Throwable -> L31
        int r106 = r104.getModification$runtime();     // Catch: Throwable -> L31
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L31
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r105);
        PersistentMap.Builder<K, V> r108 = r105.builder();
        Iterator<Map.Entry<K, V>> r109 = entrySet().iterator();
    L11:
        if (r109.hasNext() == false) goto L15;
        Map.Entry<K, V> r110 = r109.next();
        if (r100.invoke(r110).booleanValue() == false) goto L11;
        r108.remove(r110.getKey());
        r101 = true;
        goto L11
    L15:
        Unit r111 = Unit.INSTANCE;
        PersistentMap<K, V> r112 = r108.build();
        if (Intrinsics.areEqual(r112, r105) == true) goto L30;
        StateRecord r113 = getFirstStateRecord();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r114 = (StateMapStateRecord) r113;
        Object r115 = SnapshotKt.getLock();
        monitor-enter(r115);
        Snapshot r116 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        boolean r117 = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(r114, this, r116), r106, r112);     // Catch: Throwable -> L25
        InlineMarker.finallyStart(1);
        monitor-exit(r115);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r116, this);
        if (r117 == false) goto L3;
    L25:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        return r101;
    L31:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final boolean removeValue$runtime(V r100) {
        Iterator<T> r101 = entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((Map.Entry) r102).getValue(), r100) == false) goto L4;
    L9:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 == null) goto L12;
        remove(r103.getKey());
        return true;
    L12:
        return false;
    L8:
        r102 = null;
        goto L9
    }

    private final int commitUpdate(StateMapStateRecord<K, V> r100, PersistentMap<K, ? extends V> r101) {
        Object r102 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r102);
        r100.setMap$runtime(r101);     // Catch: Throwable -> L7
        int r103 = r100.getModification$runtime();     // Catch: Throwable -> L7
        r100.setModification$runtime(r103 + 1);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public V put(K r100, V r101) {
    L2:
        Object r102 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = getFirstStateRecord();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");     // Catch: Throwable -> L19
        StateMapStateRecord r104 = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) r103);     // Catch: Throwable -> L19
        PersistentMap<K, V> r105 = r104.getMap$runtime();     // Catch: Throwable -> L19
        int r106 = r104.getModification$runtime();     // Catch: Throwable -> L19
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        Intrinsics.checkNotNull(r105);
        PersistentMap.Builder<K, V> r108 = r105.builder();
        V r109 = r108.put(r100, r101);
        PersistentMap<K, V> r110 = r108.build();
        if (Intrinsics.areEqual(r110, r105) == true) goto L18;
        StateRecord r111 = getFirstStateRecord();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord r112 = (StateMapStateRecord) r111;
        Object r113 = SnapshotKt.getLock();
        monitor-enter(r113);
        Snapshot r114 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        boolean r115 = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(r112, this, r114), r106, r110);     // Catch: Throwable -> L15
        monitor-exit(r113);
        SnapshotKt.notifyWrite(r114, this);
        if (r115 == false) goto L2;
    L15:
        th = move-exception;
        throw th;
    L18:
        return r109;
    L19:
        th = move-exception;
        throw th;
    }

    private final boolean attemptUpdate(StateMapStateRecord<K, V> r100, int r101, PersistentMap<K, ? extends V> r102) {
        Object r103 = SnapshotStateMapKt.access$getSync$p();
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r100.getModification$runtime() != r101) goto L8;
        r100.setMap$runtime(r102);     // Catch: Throwable -> L11
        boolean r104 = true;
        r100.setModification$runtime(r100.getModification$runtime() + 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);
        return r104;
    L8:
        r104 = false;
        goto L9
    }

    public static final /* synthetic */ boolean access$attemptUpdate(SnapshotStateMap r100, StateMapStateRecord r101, int r102, PersistentMap r103) {
        return r100.attemptUpdate(r101, r102, r103);
    }
}
