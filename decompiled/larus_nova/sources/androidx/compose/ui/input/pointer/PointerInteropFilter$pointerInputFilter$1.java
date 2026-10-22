package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "lastEventDispatchedToInitialPass", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancel", BasicTestActionHandler.TEST_ACTION_RESET, "dispatchToView", "shouldConsume", "stopDispatching", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerEvent lastEventDispatchedToInitialPass;
    private PointerInteropFilter.DispatchToViewState state;
    final /* synthetic */ PointerInteropFilter this$0;

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
        this.lastEventDispatchedToInitialPass = null;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state != PointerInteropFilter.DispatchToViewState.Dispatching) goto L6;
        long r100 = SystemClock.uptimeMillis();
        final PointerInteropFilter r101 = this.this$0;
        PointerInteropUtils_androidKt.emptyCancelMotionEventScope(r100, new PointerInteropFilter$pointerInputFilter$1$onCancel$1(r101));
        reset();
        return;
    }

    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter r100) {
        this.this$0 = r100;
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
    }

    private final void stopDispatching(PointerEvent r100) {
        if (this.state != PointerInteropFilter.DispatchToViewState.Dispatching) goto L9;
        LayoutCoordinates r101 = getLayoutCoordinates$ui_release();
        if (r101 == null) goto L8;
        long r102 = r101.mo6261localToRootMKHz9U(Offset.Companion.m4598getZeroF1C5BW0());
        final PointerInteropFilter r103 = this.this$0;
        PointerInteropUtils_androidKt.m6185toCancelMotionEventScoped4ec7I(r100, r102, new PointerInteropFilter$pointerInputFilter$1$stopDispatching$1(r103));
        goto L9
    L8:
        throw new IllegalStateException("layoutCoordinates not set".toString());
    L9:
        this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
    }

    public static final /* synthetic */ void access$setState$p(PointerInteropFilter$pointerInputFilter$1 r100, PointerInteropFilter.DispatchToViewState r101) {
        r100.state = r101;
    }

    private final void dispatchToView(PointerEvent r100, boolean r110) {
        List<PointerInputChange> r101 = r100.getChanges();
        List<PointerInputChange> r102 = r101;
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L9;
        if (((PointerInputChange) ListProtector.get(r101, r105)).isConsumed() == true) goto L7;
        r105 = r105 + 1;
        goto L4
    L7:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
        stopDispatching(r100);
        return;
    L12:
        LayoutCoordinates r107 = getLayoutCoordinates$ui_release();
        if (r107 == null) goto L30;
        long r108 = r107.mo6261localToRootMKHz9U(Offset.Companion.m4598getZeroF1C5BW0());
        final PointerInteropFilter r109 = this.this$0;
        PointerInteropUtils_androidKt.m6186toMotionEventScoped4ec7I(r100, r108, new PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(this, r109));
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) goto L17;
        return;
    L17:
        if (ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled == false) goto L22;
        if (r110 == false) goto L25;
        int r111 = r102.size();
    L20:
        if (r104 >= r111) goto L25;
        ((PointerInputChange) ListProtector.get(r101, r104)).consume();
        r104 = r104 + 1;
    L25:
        InternalPointerEvent r112 = r100.getInternalPointerEvent$ui_release();
        if (r112 == null) goto L37;
        r112.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept$ui_release());
        return;
    L37:
        return;
    L22:
        int r113 = r102.size();
    L23:
        if (r104 >= r113) goto L25;
        ((PointerInputChange) ListProtector.get(r101, r104)).consume();
        r104 = r104 + 1;
        goto L23
    L30:
        throw new IllegalStateException("layoutCoordinates not set".toString());
    L9:
        r106 = false;
        goto L10
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo6149onPointerEventH0pRuoY(PointerEvent r100, PointerEventPass r110, long r111) {
        List<PointerInputChange> r112 = r100.getChanges();
        List<PointerInputChange> r113 = r112;
        int r101 = r113.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r101) goto L14;
        PointerInputChange r105 = (PointerInputChange) ListProtector.get(r112, r103);
        if (PointerEventKt.changedToDownIgnoreConsumed(r105) == false) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L25;
        int r108 = r113.size();
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L22;
        if ((!((PointerInputChange) ListProtector.get(r112, r109)).isConsumed()) == false) goto L20;
        r109 = r109 + 1;
        goto L17
    L20:
        boolean r114 = false;
    L23:
        if (r114 == false) goto L25;
        boolean r115 = true;
    L27:
        if (this.this$0.getDisallowIntercept$ui_release() == true) goto L47;
        int r116 = r113.size();
        int r117 = 0;
    L29:
        if (r117 >= r116) goto L40;
        PointerInputChange r118 = (PointerInputChange) ListProtector.get(r112, r117);
        if (PointerEventKt.changedToDownIgnoreConsumed(r118) == false) goto L33;
    L36:
        boolean r119 = true;
    L37:
        if (r119 == true) goto L38;
        r117 = r117 + 1;
        goto L29
    L38:
        boolean r120 = true;
    L41:
        if (r120 == true) goto L47;
        if (r115 == true) goto L44;
    L46:
        boolean r121 = false;
    L49:
        if (this.state == PointerInteropFilter.DispatchToViewState.NotDispatching) goto L89;
        if (r110 != PointerEventPass.Initial) goto L62;
        if (r121 == false) goto L62;
        this.lastEventDispatchedToInitialPass = r100;
        if (r107 == true) goto L56;
    L59:
        boolean r122 = true;
    L60:
        dispatchToView(r100, r122);
        goto L62
    L56:
        if (this.this$0.getDisallowIntercept$ui_release() == true) goto L59;
        r122 = false;
    L62:
        if (r110 != PointerEventPass.Main) goto L74;
        if (r107 == false) goto L74;
        if (Intrinsics.areEqual(r100, this.lastEventDispatchedToInitialPass) == false) goto L74;
        if (this.this$0.getDisallowIntercept$ui_release() == false) goto L74;
        if (ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled == false) goto L74;
        int r123 = r113.size();
        int r124 = 0;
    L71:
        if (r124 >= r123) goto L74;
        ((PointerInputChange) ListProtector.get(r112, r124)).consume();
        r124 = r124 + 1;
    L74:
        if (ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled == false) goto L82;
        if (r110 != PointerEventPass.Final) goto L85;
        if (r121 == true) goto L85;
        if (Intrinsics.areEqual(r100, this.lastEventDispatchedToInitialPass) == true) goto L85;
    L84:
        boolean r125 = true;
    L86:
        if (r125 == false) goto L89;
        dispatchToView(r100, true);
    L85:
        r125 = false;
        goto L86
    L82:
        if (r110 != PointerEventPass.Final) goto L85;
        if (r121 == true) goto L85;
    L89:
        if (r110 != PointerEventPass.Final) goto L118;
        int r126 = r113.size();
        int r127 = 0;
    L91:
        if (r127 >= r126) goto L96;
        if (PointerEventKt.changedToUpIgnoreConsumed((PointerInputChange) ListProtector.get(r112, r127)) == false) goto L94;
        r127 = r127 + 1;
        goto L91
    L94:
        boolean r128 = false;
    L97:
        if (r128 == false) goto L100;
        reset();
    L100:
        if (Intrinsics.areEqual(r100, this.lastEventDispatchedToInitialPass) == false) goto L131;
        if (r107 == true) goto L103;
        return;
    L103:
        if (ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled == false) goto L133;
        int r129 = r113.size();
        int r130 = 0;
    L105:
        if (r130 >= r129) goto L110;
        if (((PointerInputChange) ListProtector.get(r112, r130)).isConsumed() == true) goto L111;
        r130 = r130 + 1;
    L111:
        if (r104 == true) goto L113;
    L115:
        int r131 = r113.size();
    L116:
        if (r102 >= r131) goto L135;
        ((PointerInputChange) ListProtector.get(r112, r102)).consume();
        r102 = r102 + 1;
        goto L116
    L135:
        return;
    L113:
        if (this.this$0.getDisallowIntercept$ui_release() == true) goto L115;
        stopDispatching(r100);
        return;
    L110:
        r104 = false;
        goto L111
    L133:
        return;
    L131:
        return;
    L96:
        r128 = true;
        goto L97
    L118:
        return;
    L44:
        if (ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled == false) goto L46;
    L33:
        if (PointerEventKt.changedToUpIgnoreConsumed(r118) == true) goto L36;
        r119 = false;
        goto L37
    L40:
        r120 = false;
    L47:
        r121 = true;
        goto L49
    L22:
        r114 = true;
    L25:
        r115 = false;
        goto L27
    L8:
        if (PointerEventKt.changedToUpIgnoreConsumed(r105) == true) goto L10;
        r106 = true;
        goto L11
    L14:
        r107 = true;
        goto L15
    }
}
