package androidx.compose.runtime.snapshots.tooling;

import C7.r;
import S7.k;
import S7.n;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ExperimentalComposeRuntimeApi;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.a;
import androidx.compose.runtime.snapshots.b;
import com.mdisdk.capability.model.RequestInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptySet;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0094\u0001\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\b\b\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\b\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000e26\b\u0004\u0010\u0011\u001a0\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0004\u0012\u00028\u00000\u0010H\u0081\b¢\u0006\u0004\b\u0012\u0010\u0013\u001aq\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00170\u0015*\b\u0012\u0004\u0012\u00020\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aI\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0018\u0010\u001c\u001aA\u0010\u001f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\"\u0010#\u001a'\u0010'\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0000¢\u0006\u0004\b'\u0010(\"$\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b)\u0010*\u0012\u0004\b+\u0010,¨\u0006-"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "Landroidx/compose/runtime/snapshots/tooling/SnapshotObserver;", "snapshotObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observeSnapshots", "(Landroidx/compose/runtime/snapshots/Snapshot$Companion;Landroidx/compose/runtime/snapshots/tooling/SnapshotObserver;)Landroidx/compose/runtime/snapshots/ObserverHandle;", "Landroidx/compose/runtime/snapshots/Snapshot;", "R", "parent", "Lkotlin/Function1;", "", "LC7/r;", "readObserver", "writeObserver", "", "readonly", "Lkotlin/Function2;", "block", "creatingSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;LS7/k;LS7/k;ZLS7/n;)Landroidx/compose/runtime/snapshots/Snapshot;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/Pair;", "Landroidx/compose/runtime/snapshots/tooling/SnapshotInstanceObservers;", "", "mergeObservers", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Landroidx/compose/runtime/snapshots/Snapshot;ZLS7/k;LS7/k;)Lkotlin/Pair;", "a", "b", "(LS7/k;LS7/k;)LS7/k;", "result", "observerMap", "dispatchCreatedObservers", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/Snapshot;Ljava/util/Map;)V", RequestInfo.FUNCTION_SNAPSHOT, "dispatchObserverOnPreDispose", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "changes", "dispatchObserverOnApplied", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/collection/ScatterSet;)V", "observers", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "getObservers$annotations", "()V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotObserverKt {
    private static PersistentList<? extends SnapshotObserver> observers;

    @ExperimentalComposeRuntimeApi
    public static final <R extends Snapshot> R creatingSnapshot(Snapshot snapshot, k kVar, k kVar2, boolean z10, n nVar) {
        Map map;
        PersistentList persistentList = observers;
        if (persistentList != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> pairMergeObservers = mergeObservers(persistentList, snapshot, z10, kVar, kVar2);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairMergeObservers.f4886a;
            k readObserver = snapshotInstanceObservers.getReadObserver();
            kVar2 = snapshotInstanceObservers.getWriteObserver();
            map = (Map) pairMergeObservers.b;
            kVar = readObserver;
        } else {
            map = null;
        }
        R r5 = (R) nVar.invoke(kVar, kVar2);
        if (persistentList != null) {
            dispatchCreatedObservers(persistentList, snapshot, r5, map);
        }
        return r5;
    }

    @ExperimentalComposeRuntimeApi
    public static final void dispatchCreatedObservers(PersistentList<? extends SnapshotObserver> persistentList, Snapshot snapshot, Snapshot snapshot2, Map<SnapshotObserver, SnapshotInstanceObservers> map) {
        int size = persistentList.size();
        for (int i = 0; i < size; i++) {
            SnapshotObserver snapshotObserver = persistentList.get(i);
            snapshotObserver.onCreated(snapshot2, snapshot, map != null ? map.get(snapshotObserver) : null);
        }
    }

    public static final void dispatchObserverOnApplied(Snapshot snapshot, ScatterSet<StateObject> scatterSet) {
        Set<? extends Object> setWrapIntoSet;
        PersistentList<? extends SnapshotObserver> persistentList = observers;
        if (persistentList == null || persistentList.isEmpty()) {
            return;
        }
        if (scatterSet == null || (setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(scatterSet)) == null) {
            setWrapIntoSet = EmptySet.f4895a;
        }
        int size = persistentList.size();
        for (int i = 0; i < size; i++) {
            persistentList.get(i).onApplied(snapshot, setWrapIntoSet);
        }
    }

    public static final void dispatchObserverOnPreDispose(Snapshot snapshot) {
        PersistentList<? extends SnapshotObserver> persistentList = observers;
        if (persistentList != null) {
            int size = persistentList.size();
            for (int i = 0; i < size; i++) {
                persistentList.get(i).onPreDispose(snapshot);
            }
        }
    }

    @ExperimentalComposeRuntimeApi
    private static /* synthetic */ void getObservers$annotations() {
    }

    private static final k mergeObservers(k kVar, k kVar2) {
        return (kVar == null || kVar2 == null) ? kVar == null ? kVar2 : kVar : new b(2, kVar, kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r mergeObservers$lambda$6(k kVar, k kVar2, Object obj) {
        kVar.invoke(obj);
        kVar2.invoke(obj);
        return r.f317a;
    }

    @ExperimentalComposeRuntimeApi
    public static final ObserverHandle observeSnapshots(Snapshot.Companion companion, SnapshotObserver snapshotObserver) {
        synchronized (SnapshotKt.getLock()) {
            try {
                PersistentList<? extends SnapshotObserver> persistentListPersistentListOf = observers;
                if (persistentListPersistentListOf == null) {
                    persistentListPersistentListOf = ExtensionsKt.persistentListOf();
                }
                observers = persistentListPersistentListOf.add((PersistentList<? extends SnapshotObserver>) snapshotObserver);
            } catch (Throwable th) {
                throw th;
            }
        }
        return new a(snapshotObserver, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeSnapshots$lambda$3(SnapshotObserver snapshotObserver) {
        synchronized (SnapshotKt.getLock()) {
            try {
                PersistentList<? extends SnapshotObserver> persistentList = observers;
                PersistentList<? extends SnapshotObserver> persistentList2 = null;
                PersistentList<? extends SnapshotObserver> persistentListRemove = persistentList != null ? persistentList.remove((PersistentList<? extends SnapshotObserver>) snapshotObserver) : null;
                if (persistentListRemove != null && !persistentListRemove.isEmpty()) {
                    persistentList2 = persistentListRemove;
                }
                observers = persistentList2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ExperimentalComposeRuntimeApi
    public static final Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> mergeObservers(PersistentList<? extends SnapshotObserver> persistentList, Snapshot snapshot, boolean z10, k kVar, k kVar2) {
        int size = persistentList.size();
        LinkedHashMap linkedHashMap = null;
        for (int i = 0; i < size; i++) {
            SnapshotObserver snapshotObserver = persistentList.get(i);
            SnapshotInstanceObservers snapshotInstanceObserversOnPreCreate = snapshotObserver.onPreCreate(snapshot, z10);
            if (snapshotInstanceObserversOnPreCreate != null) {
                kVar = mergeObservers(snapshotInstanceObserversOnPreCreate.getReadObserver(), kVar);
                kVar2 = mergeObservers(snapshotInstanceObserversOnPreCreate.getWriteObserver(), kVar2);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(snapshotObserver, snapshotInstanceObserversOnPreCreate);
            }
        }
        return new Pair<>(new SnapshotInstanceObservers(kVar, kVar2), linkedHashMap);
    }
}
