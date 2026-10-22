package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateKt {
    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final <T> SnapshotStateSet<T> mutableStateSetOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf();
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> r100) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(r100);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... r100) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(r100);
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... r100) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(r100);
    }

    public static final <T> SnapshotStateSet<T> mutableStateSetOf(T... r100) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateSetOf(r100);
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> r100) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(r100);
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> r100) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(r100);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> r100) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(r100);
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> r100, Function0<? extends T> r101) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(r100, r101);
    }

    public static final <T> MutableState<T> mutableStateOf(T r100, SnapshotMutationPolicy<T> r101) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(r100, r101);
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver r100, Function0<? extends R> r101) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(r100, r101);
    }

    public static final <T> T getValue(State<? extends T> r100, Object r101, KProperty<?> r102) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(r100, r101, r102);
    }

    public static final <T> State<T> rememberUpdatedState(T r100, Composer r101, int r102) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(r100, r101, r102);
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object r100, SnapshotMutationPolicy r101, int r102, Object r103) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r100, r101, r102, r103);
    }

    public static final <T> State<T> produceState(T r100, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r101, Composer r102, int r103) {
        return SnapshotStateKt__ProduceStateKt.produceState(r100, r101, r102, r103);
    }

    public static final <T> void setValue(MutableState<T> r100, Object r101, KProperty<?> r102, T r103) {
        SnapshotStateKt__SnapshotStateKt.setValue(r100, r101, r102, r103);
    }

    public static final <T> State<T> collectAsState(i1<? extends T> r100, CoroutineContext r101, Composer r102, int r103, int r104) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(r100, r101, r102, r103, r104);
    }

    public static final <T> State<T> produceState(T r100, Object r101, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r102, Composer r103, int r104) {
        return SnapshotStateKt__ProduceStateKt.produceState(r100, r101, r102, r103, r104);
    }

    public static final <T> State<T> produceState(T r100, Object[] r101, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r102, Composer r103, int r104) {
        return SnapshotStateKt__ProduceStateKt.produceState(r100, r101, r102, r103, r104);
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> r100, R r101, CoroutineContext r102, Composer r103, int r104, int r105) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(r100, r101, r102, r103, r104, r105);
    }

    public static final <T> State<T> produceState(T r100, Object r101, Object r102, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r103, Composer r104, int r105) {
        return SnapshotStateKt__ProduceStateKt.produceState(r100, r101, r102, r103, r104, r105);
    }

    public static final <T> State<T> produceState(T r100, Object r101, Object r102, Object r103, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> r104, Composer r105, int r106) {
        return SnapshotStateKt__ProduceStateKt.produceState(r100, r101, r102, r103, r104, r105, r106);
    }
}
