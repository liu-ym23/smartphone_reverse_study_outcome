package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR+\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/TargetData;", "", "size", "Landroidx/compose/ui/geometry/Size;", "initialMfrOffset", "Landroidx/compose/ui/geometry/Offset;", "targetStructuralOffset", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "getInitialMfrOffset-F1C5BW0", "setInitialMfrOffset-k-4lQ0M", "initialMfrOffset$delegate", "getTargetStructuralOffset-F1C5BW0", "setTargetStructuralOffset-k-4lQ0M", "targetStructuralOffset$delegate", "currentMfrOffset", "getCurrentMfrOffset-F1C5BW0", "setCurrentMfrOffset-k-4lQ0M", "currentMfrOffset$delegate", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TargetData {
    public static final int $stable = 0;
    private final MutableState currentMfrOffset$delegate;
    private final MutableState initialMfrOffset$delegate;
    private final MutableState size$delegate;
    private final MutableState targetStructuralOffset$delegate;

    public /* synthetic */ TargetData(long r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCurrentMfrOffset-F1C5BW0, reason: not valid java name */
    public final long m120getCurrentMfrOffsetF1C5BW0() {
        return ((Offset) this.currentMfrOffset$delegate.getValue()).m4592unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getInitialMfrOffset-F1C5BW0, reason: not valid java name */
    public final long m121getInitialMfrOffsetF1C5BW0() {
        return ((Offset) this.initialMfrOffset$delegate.getValue()).m4592unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m122getSizeNHjbRc() {
        return ((Size) this.size$delegate.getValue()).m4656unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getTargetStructuralOffset-F1C5BW0, reason: not valid java name */
    public final long m123getTargetStructuralOffsetF1C5BW0() {
        return ((Offset) this.targetStructuralOffset$delegate.getValue()).m4592unboximpl();
    }

    /* JADX INFO: renamed from: setCurrentMfrOffset-k-4lQ0M, reason: not valid java name */
    public final void m124setCurrentMfrOffsetk4lQ0M(long r100) {
        this.currentMfrOffset$delegate.setValue(Offset.m4571boximpl(r100));
    }

    /* JADX INFO: renamed from: setInitialMfrOffset-k-4lQ0M, reason: not valid java name */
    public final void m125setInitialMfrOffsetk4lQ0M(long r100) {
        this.initialMfrOffset$delegate.setValue(Offset.m4571boximpl(r100));
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m126setSizeuvyYCjk(long r100) {
        this.size$delegate.setValue(Size.m4639boximpl(r100));
    }

    /* JADX INFO: renamed from: setTargetStructuralOffset-k-4lQ0M, reason: not valid java name */
    public final void m127setTargetStructuralOffsetk4lQ0M(long r100) {
        this.targetStructuralOffset$delegate.setValue(Offset.m4571boximpl(r100));
    }

    private TargetData(long r100, long r101, long r102) {
        this.size$delegate = SnapshotStateKt.mutableStateOf$default(Size.m4639boximpl(r100), null, 2, null);
        this.initialMfrOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.m4571boximpl(r101), null, 2, null);
        this.targetStructuralOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.m4571boximpl(r102), null, 2, null);
        this.currentMfrOffset$delegate = SnapshotStateKt.mutableStateOf$default(Offset.m4571boximpl(r101), null, 2, null);
    }
}
