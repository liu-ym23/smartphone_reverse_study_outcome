package androidx.compose.ui.input.pointer;

import C7.r;
import S7.k;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "LC7/r;", "reset", "()V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "", "shouldConsume", "dispatchToView", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)V", "stopDispatching", "(Landroidx/compose/ui/input/pointer/PointerEvent;)V", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancel", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "lastEventDispatchedToInitialPass", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getShareWithSiblings", "()Z", "shareWithSiblings", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerEvent lastEventDispatchedToInitialPass;
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    private final void dispatchToView(PointerEvent pointerEvent, boolean shouldConsume) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            if (changes.get(i6).isConsumed()) {
                stopDispatching(pointerEvent);
                return;
            }
        }
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            throw new IllegalStateException("layoutCoordinates not set");
        }
        long jMo5560localToRootMKHz9U = layoutCoordinates.mo5560localToRootMKHz9U(Offset.INSTANCE.m3911getZeroF1C5BW0());
        final PointerInteropFilter pointerInteropFilter = this.this$0;
        PointerInteropUtils_androidKt.m5480toMotionEventScoped4ec7I(pointerEvent, jMo5560localToRootMKHz9U, new k() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MotionEvent) obj);
                return r.f317a;
            }

            public final void invoke(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    pointerInteropFilter.getOnTouchEvent().invoke(motionEvent);
                } else {
                    this.this$0.state = ((Boolean) pointerInteropFilter.getOnTouchEvent().invoke(motionEvent)).booleanValue() ? PointerInteropFilter.DispatchToViewState.Dispatching : PointerInteropFilter.DispatchToViewState.NotDispatching;
                }
            }
        });
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            if (!ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                int size2 = list.size();
                while (i < size2) {
                    changes.get(i).consume();
                    i++;
                }
            } else if (shouldConsume) {
                int size3 = list.size();
                while (i < size3) {
                    changes.get(i).consume();
                    i++;
                }
            }
            InternalPointerEvent internalPointerEvent = pointerEvent.getInternalPointerEvent();
            if (internalPointerEvent != null) {
                internalPointerEvent.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept());
            }
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
        this.lastEventDispatchedToInitialPass = null;
    }

    private final void stopDispatching(PointerEvent pointerEvent) {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
            if (layoutCoordinates == null) {
                throw new IllegalStateException("layoutCoordinates not set");
            }
            long jMo5560localToRootMKHz9U = layoutCoordinates.mo5560localToRootMKHz9U(Offset.INSTANCE.m3911getZeroF1C5BW0());
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.m5479toCancelMotionEventScoped4ec7I(pointerEvent, jMo5560localToRootMKHz9U, new k() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$stopDispatching$1
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MotionEvent) obj);
                    return r.f317a;
                }

                public final void invoke(MotionEvent motionEvent) {
                    pointerInteropFilter.getOnTouchEvent().invoke(motionEvent);
                }
            });
        }
        this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(jUptimeMillis, new k() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MotionEvent) obj);
                    return r.f317a;
                }

                public final void invoke(MotionEvent motionEvent) {
                    pointerInteropFilter.getOnTouchEvent().invoke(motionEvent);
                }
            });
            reset();
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo5444onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z10;
        boolean z11;
        boolean z12;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        if (!z10) {
            z11 = false;
            break;
        }
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            if (changes.get(i6).isConsumed()) {
                z11 = false;
                break;
            }
        }
        z11 = true;
        if (this.this$0.getDisallowIntercept()) {
            z12 = true;
        } else {
            int size3 = list.size();
            int i10 = 0;
            while (true) {
                if (i10 < size3) {
                    PointerInputChange pointerInputChange2 = changes.get(i10);
                    if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                        break;
                    } else {
                        i10++;
                    }
                } else if (!z11 || !ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                    z12 = false;
                }
            }
            z12 = true;
        }
        if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
            if (pass == PointerEventPass.Initial && z12) {
                this.lastEventDispatchedToInitialPass = pointerEvent;
                dispatchToView(pointerEvent, !z10 || this.this$0.getDisallowIntercept());
            }
            if (pass == PointerEventPass.Main && z10 && pointerEvent.equals(this.lastEventDispatchedToInitialPass) && this.this$0.getDisallowIntercept() && ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                int size4 = list.size();
                for (int i11 = 0; i11 < size4; i11++) {
                    changes.get(i11).consume();
                }
            }
            if (!ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled ? !(pass != PointerEventPass.Final || z12) : !(pass != PointerEventPass.Final || z12 || pointerEvent.equals(this.lastEventDispatchedToInitialPass))) {
                dispatchToView(pointerEvent, true);
            }
        }
        if (pass == PointerEventPass.Final) {
            int size5 = list.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size5) {
                    reset();
                    break;
                } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i12))) {
                    break;
                } else {
                    i12++;
                }
            }
            if (pointerEvent.equals(this.lastEventDispatchedToInitialPass) && z10 && ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                int size6 = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size6) {
                        break;
                    }
                    if (!changes.get(i13).isConsumed()) {
                        i13++;
                    } else if (!this.this$0.getDisallowIntercept()) {
                        stopDispatching(pointerEvent);
                        return;
                    }
                }
                int size7 = list.size();
                for (int i14 = 0; i14 < size7; i14++) {
                    changes.get(i14).consume();
                }
            }
        }
    }
}
