package androidx.compose.runtime;

import S7.n;
import Z7.t;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateKt {
    @Composable
    public static final <T extends R, R> State<R> collectAsState(p9.c cVar, R r5, H7.h hVar, Composer composer, int i, int i6) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(cVar, r5, hVar, composer, i, i6);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(S7.a aVar) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(aVar);
    }

    public static final <T> T getValue(State<? extends T> state, Object obj, t tVar) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(state, obj, tVar);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    @StateFactoryMarker
    public static final <T> MutableState<T> mutableStateOf(T t9, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t9, snapshotMutationPolicy);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateSet<T> mutableStateSetOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf();
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver derivedStateObserver, S7.a aVar) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(derivedStateObserver, aVar);
    }

    @Composable
    public static final <T> State<T> produceState(T t9, n nVar, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t9, nVar, composer, i);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    @Composable
    public static final <T> State<T> rememberUpdatedState(T t9, Composer composer, int i) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t9, composer, i);
    }

    public static final <T> void setValue(MutableState<T> mutableState, Object obj, t tVar, T t9) {
        SnapshotStateKt__SnapshotStateKt.setValue(mutableState, obj, tVar, t9);
    }

    public static final <T> p9.c snapshotFlow(S7.a aVar) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(aVar);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }

    @Composable
    public static final <T> State<T> collectAsState(p9.t tVar, H7.h hVar, Composer composer, int i, int i6) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(tVar, hVar, composer, i, i6);
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, S7.a aVar) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(snapshotMutationPolicy, aVar);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(pairArr);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateSet<T> mutableStateSetOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf(tArr);
    }

    @Composable
    public static final <T> State<T> produceState(T t9, Object obj, n nVar, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t9, obj, nVar, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t9, Object obj, Object obj2, n nVar, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t9, obj, obj2, nVar, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t9, Object obj, Object obj2, Object obj3, n nVar, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t9, obj, obj2, obj3, nVar, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t9, Object[] objArr, n nVar, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState((Object) t9, objArr, nVar, composer, i);
    }
}
