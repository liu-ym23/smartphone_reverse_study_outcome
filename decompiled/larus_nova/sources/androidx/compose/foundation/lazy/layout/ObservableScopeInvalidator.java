package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "", "state", "Landroidx/compose/runtime/MutableState;", "", "constructor-impl", "(Landroidx/compose/runtime/MutableState;)Landroidx/compose/runtime/MutableState;", "attachToScope", "attachToScope-impl", "(Landroidx/compose/runtime/MutableState;)V", "invalidateScope", "invalidateScope-impl", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class ObservableScopeInvalidator {
    private final MutableState<Unit> state;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ObservableScopeInvalidator m911boximpl(MutableState r100) {
        return new ObservableScopeInvalidator(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static MutableState<Unit> m912constructorimpl(MutableState<Unit> r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m914equalsimpl(MutableState<Unit> r100, Object r101) {
        if ((r101 instanceof ObservableScopeInvalidator) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((ObservableScopeInvalidator) r101).m919unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m915equalsimpl0(MutableState<Unit> r100, MutableState<Unit> r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m916hashCodeimpl(MutableState<Unit> r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m918toStringimpl(MutableState<Unit> r100) {
        return "ObservableScopeInvalidator(state=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m914equalsimpl(this.state, r100);
    }

    public int hashCode() {
        return m916hashCodeimpl(this.state);
    }

    public String toString() {
        return m918toStringimpl(this.state);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ MutableState m919unboximpl() {
        return this.state;
    }

    private /* synthetic */ ObservableScopeInvalidator(MutableState r100) {
        this.state = r100;
    }

    /* JADX INFO: renamed from: attachToScope-impl, reason: not valid java name */
    public static final void m910attachToScopeimpl(MutableState<Unit> r100) {
        r100.getValue();
    }

    /* JADX INFO: renamed from: invalidateScope-impl, reason: not valid java name */
    public static final void m917invalidateScopeimpl(MutableState<Unit> r100) {
        r100.setValue(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableState m913constructorimpl$default(MutableState r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    L6:
        return m912constructorimpl(r100);
    }
}
