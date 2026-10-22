package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u0082\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000e\u001a\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a0\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u001b\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0019\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\" \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001f¨\u0006 "}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Landroidx/compose/runtime/internal/IntRef;", "block", "withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt", "(LS7/k;)Ljava/lang/Object;", "withCalculationNestedLevel", "Lkotlin/Function0;", "calculation", "Landroidx/compose/runtime/State;", "derivedStateOf", "(LS7/a;)Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", PolicySdkConstants.policyFileDir, "(Landroidx/compose/runtime/SnapshotMutationPolicy;LS7/a;)Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateObservers", "()Landroidx/compose/runtime/collection/MutableVector;", "R", "Landroidx/compose/runtime/DerivedState;", "derivedState", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;LS7/a;)Ljava/lang/Object;", "notifyObservers", "observer", "LC7/r;", "observeDerivedStateRecalculations", "(Landroidx/compose/runtime/DerivedStateObserver;LS7/a;)V", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "calculationBlockNestedLevel", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<IntRef> calculationBlockNestedLevel = new SnapshotThreadLocal<>();
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = new SnapshotThreadLocal<>();

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> snapshotThreadLocal = derivedStateObservers;
        MutableVector<DerivedStateObserver> mutableVector = snapshotThreadLocal.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<DerivedStateObserver> mutableVector2 = new MutableVector<>(new DerivedStateObserver[0], 0);
        snapshotThreadLocal.set(mutableVector2);
        return mutableVector2;
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(S7.a aVar) {
        return new DerivedSnapshotState(aVar, null);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, S7.a aVar) {
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        DerivedStateObserver[] derivedStateObserverArr = mutableVectorDerivedStateObservers.content;
        int size = mutableVectorDerivedStateObservers.getSize();
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            derivedStateObserverArr[i6].start(derivedState);
        }
        try {
            return (R) aVar.invoke();
        } finally {
            DerivedStateObserver[] derivedStateObserverArr2 = mutableVectorDerivedStateObservers.content;
            int size2 = mutableVectorDerivedStateObservers.getSize();
            while (i < size2) {
                derivedStateObserverArr2[i].done(derivedState);
                i++;
            }
        }
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver derivedStateObserver, S7.a aVar) {
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        try {
            mutableVectorDerivedStateObservers.add(derivedStateObserver);
            aVar.invoke();
        } finally {
            mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
        }
    }

    private static final <T> T withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt(S7.k kVar) {
        IntRef intRef = (IntRef) calculationBlockNestedLevel.get();
        if (intRef == null) {
            intRef = new IntRef(0);
            calculationBlockNestedLevel.set(intRef);
        }
        return (T) kVar.invoke(intRef);
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, S7.a aVar) {
        return new DerivedSnapshotState(aVar, snapshotMutationPolicy);
    }
}
