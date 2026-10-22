package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a*\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0082\b¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\fH\u0007\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\fH\u0007\u001a\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a0\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00130\fH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u001a\u001a\u00020\u00112\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00130\fH\u0080\b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"calculationBlockNestedLevel", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/internal/IntRef;", "withCalculationNestedLevel", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "derivedStateOf", "Landroidx/compose/runtime/State;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "derivedStateObservers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "notifyObservers", "R", "derivedState", "Landroidx/compose/runtime/DerivedState;", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "", "observer", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<IntRef> calculationBlockNestedLevel = null;
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = null;

    static {
        calculationBlockNestedLevel = new SnapshotThreadLocal();
        derivedStateObservers = new SnapshotThreadLocal();
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> r100 = derivedStateObservers;
        MutableVector<DerivedStateObserver> r101 = r100.get();
        if (r101 != null) goto L6;
        MutableVector<DerivedStateObserver> r102 = new MutableVector(new DerivedStateObserver[0], 0);
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    public static final /* synthetic */ SnapshotThreadLocal access$getCalculationBlockNestedLevel$p() {
        return calculationBlockNestedLevel;
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> r100) {
        return new DerivedSnapshotState(r100, null);
    }

    private static final <T> T withCalculationNestedLevel$SnapshotStateKt__DerivedStateKt(Function1<? super IntRef, ? extends T> r100) {
        IntRef r101 = (IntRef) access$getCalculationBlockNestedLevel$p().get();
        if (r101 != null) goto L6;
        r101 = new IntRef(0);
        access$getCalculationBlockNestedLevel$p().set(r101);
    L6:
        return r100.invoke(r101);
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> r100, Function0<? extends T> r101) {
        return new DerivedSnapshotState(r101, r100);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> r100, Function0<? extends R> r101) {
        MutableVector<DerivedStateObserver> r102 = SnapshotStateKt.derivedStateObservers();
        DerivedStateObserver[] r103 = r102.content;
        int r104 = r102.getSize();
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L18;
        r103[r106].start(r100);
        r106 = r106 + 1;
        goto L3
    L18:
        R r107 = r101.invoke();     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        DerivedStateObserver[] r108 = r102.content;
        int r109 = r102.getSize();
    L8:
        if (r105 >= r109) goto L10;
        r108[r105].done(r100);
        r105 = r105 + 1;
        goto L8
    L10:
        InlineMarker.finallyEnd(1);
        return r107;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        DerivedStateObserver[] r110 = r102.content;
        int r111 = r102.getSize();
    L14:
        if (r105 >= r111) goto L16;
        r110[r105].done(r100);
        r105 = r105 + 1;
        goto L14
    L16:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver r100, Function0<? extends R> r101) {
        MutableVector<DerivedStateObserver> r102 = SnapshotStateKt.derivedStateObservers();
        r102.add(r100);     // Catch: Throwable -> L6
        r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r102.removeAt(r102.getSize() - 1);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r102.removeAt(r102.getSize() - 1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
