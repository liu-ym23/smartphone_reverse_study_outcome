package androidx.compose.runtime;

import D7.q;
import Z7.t;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000d\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a6\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\n¢\u0006\u0004\b\f\u0010\r\u001a>\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0001\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0014\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0016\u001a#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\"\u0004\b\u0000\u0010\u001a\"\u0004\b\u0001\u0010\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aS\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\"\u0004\b\u0000\u0010\u001a\"\u0004\b\u0001\u0010\u001b2*\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u0014\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0007¢\u0006\u0004\b\u001d\u0010!\u001a;\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\"\u0004\b\u0000\u0010\u001a\"\u0004\b\u0001\u0010\u001b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\"¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%\"\u0004\b\u0000\u0010\u0000H\u0007¢\u0006\u0004\b&\u0010'\u001a/\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0014\"\u00028\u0000H\u0007¢\u0006\u0004\b&\u0010(\u001a#\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0007¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Landroidx/compose/runtime/SnapshotMutationPolicy;", PolicySdkConstants.policyFileDir, "Landroidx/compose/runtime/MutableState;", "mutableStateOf", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/State;", "", "thisObj", "LZ7/t;", "property", "getValue", "(Landroidx/compose/runtime/State;Ljava/lang/Object;LZ7/t;)Ljava/lang/Object;", "LC7/r;", "setValue", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;LZ7/t;Ljava/lang/Object;)V", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "mutableStateListOf", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "toMutableStateList", "(Ljava/util/Collection;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableStateMapOf", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "toMutableStateMap", "(Ljava/lang/Iterable;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "mutableStateSetOf", "()Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "newValue", "rememberUpdatedState", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotStateKt {
    public static final <T> T getValue(State<? extends T> state, Object obj, t tVar) {
        return state.getValue();
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return new SnapshotStateList<>();
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return new SnapshotStateMap<>();
    }

    @StateFactoryMarker
    public static final <T> MutableState<T> mutableStateOf(T t9, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotState_androidKt.createSnapshotMutableState(t9, snapshotMutationPolicy);
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i, Object obj2) {
        if ((i & 2) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return SnapshotStateKt.mutableStateOf(obj, snapshotMutationPolicy);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateSet<T> mutableStateSetOf() {
        return new SnapshotStateSet<>();
    }

    @Composable
    public static final <T> State<T> rememberUpdatedState(T t9, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1058319986, i, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:335)");
        }
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = mutableStateOf$default(t9, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        mutableState.setValue(t9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }

    public static final <T> void setValue(MutableState<T> mutableState, Object obj, t tVar, T t9) {
        mutableState.setValue(t9);
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(collection);
        return snapshotStateList;
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        SnapshotStateMap<K, V> snapshotStateMap = new SnapshotStateMap<>();
        snapshotStateMap.putAll(kotlin.collections.a.X(iterable));
        return snapshotStateMap;
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(q.I0(tArr));
        return snapshotStateList;
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairArr) {
        SnapshotStateMap<K, V> snapshotStateMap = new SnapshotStateMap<>();
        snapshotStateMap.putAll(kotlin.collections.a.Z(pairArr));
        return snapshotStateMap;
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateSet<T> mutableStateSetOf(T... tArr) {
        SnapshotStateSet<T> snapshotStateSet = new SnapshotStateSet<>();
        snapshotStateSet.addAll(q.K0(tArr));
        return snapshotStateSet;
    }
}
