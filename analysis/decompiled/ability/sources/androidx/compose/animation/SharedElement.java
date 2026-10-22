package androidx.compose.animation;

import C7.r;
import S7.k;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"R/\u0010+\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u00100\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010/R/\u00104\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R(\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010?R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0013\u0010D\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\bC\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "scope", AppAgent.CONSTRUCT, "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "", "hasVisibleContent", "()Z", "isAnimating", "LC7/r;", "updateMatch", "()V", "Landroidx/compose/animation/SharedElementInternalState;", "state", "Landroidx/compose/ui/geometry/Size;", "lookaheadSize", "Landroidx/compose/ui/geometry/Offset;", "topLeft", "onLookaheadResult-v_w8tDc", "(Landroidx/compose/animation/SharedElementInternalState;JJ)V", "onLookaheadResult", "updateTargetBoundsProvider", "onSharedTransitionFinished", "sharedElementState", "addState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "removeState", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/ui/geometry/Rect;", "<set-?>", "_targetBounds$delegate", "Landroidx/compose/runtime/MutableState;", "get_targetBounds", "()Landroidx/compose/ui/geometry/Rect;", "set_targetBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "_targetBounds", "foundMatch$delegate", "getFoundMatch", "setFoundMatch", "(Z)V", "foundMatch", "currentBounds$delegate", "getCurrentBounds", "setCurrentBounds", "currentBounds", "targetBoundsProvider", "Landroidx/compose/animation/SharedElementInternalState;", "getTargetBoundsProvider$animation_release", "()Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "states", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getStates", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "LS7/k;", "Lkotlin/Function0;", "observingVisibilityChange", "LS7/a;", "getTargetBounds", "targetBounds", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedElement {
    public static final int $stable = 8;
    private final Object key;
    private final SharedTransitionScopeImpl scope;
    private SharedElementInternalState targetBoundsProvider;

    /* renamed from: _targetBounds$delegate, reason: from kotlin metadata */
    private final MutableState _targetBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* renamed from: foundMatch$delegate, reason: from kotlin metadata */
    private final MutableState foundMatch = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    /* renamed from: currentBounds$delegate, reason: from kotlin metadata */
    private final MutableState currentBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private final SnapshotStateList<SharedElementInternalState> states = SnapshotStateKt.mutableStateListOf();
    private final k updateMatch = new k() { // from class: androidx.compose.animation.SharedElement.updateMatch.1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SharedElement) obj);
            return r.f317a;
        }

        public final void invoke(SharedElement sharedElement) {
            SharedElement.this.updateMatch();
        }
    };
    private final S7.a observingVisibilityChange = new S7.a() { // from class: androidx.compose.animation.SharedElement$observingVisibilityChange$1
        {
            super(0);
        }

        @Override // S7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m104invoke();
            return r.f317a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m104invoke() {
            this.this$0.hasVisibleContent();
        }
    };

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Rect get_targetBounds() {
        return (Rect) this._targetBounds.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasVisibleContent() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        for (int i = 0; i < size; i++) {
            if (snapshotStateList.get(i).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }

    private final void setFoundMatch(boolean z10) {
        this.foundMatch.setValue(Boolean.valueOf(z10));
    }

    private final void set_targetBounds(Rect rect) {
        this._targetBounds.setValue(rect);
    }

    public final void addState(SharedElementInternalState sharedElementState) {
        this.states.add(sharedElementState);
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Rect getCurrentBounds() {
        return (Rect) this.currentBounds.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getFoundMatch() {
        return ((Boolean) this.foundMatch.getValue()).booleanValue();
    }

    public final Object getKey() {
        return this.key;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final SnapshotStateList<SharedElementInternalState> getStates() {
        return this.states;
    }

    public final Rect getTargetBounds() {
        SharedElementInternalState sharedElementInternalState = this.targetBoundsProvider;
        set_targetBounds(sharedElementInternalState != null ? RectKt.m3935Recttz77jQw(sharedElementInternalState.m105calculateLookaheadOffsetF1C5BW0(), sharedElementInternalState.m106getNonNullLookaheadSizeNHjbRc()) : null);
        return get_targetBounds();
    }

    /* renamed from: getTargetBoundsProvider$animation_release, reason: from getter */
    public final SharedElementInternalState getTargetBoundsProvider() {
        return this.targetBoundsProvider;
    }

    public final boolean isAnimating() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (!snapshotStateList.get(i).getBoundsAnimation().isRunning()) {
                i++;
            } else if (getFoundMatch()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: onLookaheadResult-v_w8tDc, reason: not valid java name */
    public final void m103onLookaheadResultv_w8tDc(SharedElementInternalState state, long lookaheadSize, long topLeft) {
        if (state.getBoundsAnimation().getTarget()) {
            this.targetBoundsProvider = state;
            Rect rect = get_targetBounds();
            Offset offsetM3884boximpl = rect != null ? Offset.m3884boximpl(rect.m3930getTopLeftF1C5BW0()) : null;
            if (offsetM3884boximpl == null ? false : Offset.m3892equalsimpl0(offsetM3884boximpl.m3905unboximpl(), topLeft)) {
                Rect rect2 = get_targetBounds();
                Size sizeM3952boximpl = rect2 != null ? Size.m3952boximpl(rect2.m3928getSizeNHjbRc()) : null;
                if (sizeM3952boximpl == null ? false : Size.m3960equalsimpl0(sizeM3952boximpl.m3969unboximpl(), lookaheadSize)) {
                    return;
                }
            }
            Rect rectM3935Recttz77jQw = RectKt.m3935Recttz77jQw(topLeft, lookaheadSize);
            set_targetBounds(rectM3935Recttz77jQw);
            SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
            int size = snapshotStateList.size();
            for (int i = 0; i < size; i++) {
                BoundsAnimation boundsAnimation = snapshotStateList.get(i).getBoundsAnimation();
                Rect currentBounds = getCurrentBounds();
                kotlin.jvm.internal.k.c(currentBounds);
                boundsAnimation.animate(currentBounds, rectM3935Recttz77jQw);
            }
        }
    }

    public final void onSharedTransitionFinished() {
        setFoundMatch(this.states.size() > 1 && hasVisibleContent());
        set_targetBounds(null);
    }

    public final void removeState(SharedElementInternalState sharedElementState) {
        this.states.remove(sharedElementState);
        if (!this.states.isEmpty()) {
            SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
        } else {
            updateMatch();
            SharedTransitionScopeKt.getSharedTransitionObserver().clear(this);
        }
    }

    public final void setCurrentBounds(Rect rect) {
        this.currentBounds.setValue(rect);
    }

    public final void updateMatch() {
        boolean zHasVisibleContent = hasVisibleContent();
        if (this.states.size() > 1 && zHasVisibleContent) {
            setFoundMatch(true);
        } else if (!this.scope.isTransitionActive() || !zHasVisibleContent) {
            setFoundMatch(false);
        }
        if (this.states.isEmpty()) {
            return;
        }
        SharedTransitionScopeKt.getSharedTransitionObserver().observeReads(this, this.updateMatch, this.observingVisibilityChange);
    }

    public final void updateTargetBoundsProvider() {
        SnapshotStateList<SharedElementInternalState> snapshotStateList = this.states;
        int size = snapshotStateList.size() - 1;
        SharedElementInternalState sharedElementInternalState = null;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                SharedElementInternalState sharedElementInternalState2 = snapshotStateList.get(size);
                if (sharedElementInternalState2.getBoundsAnimation().getTarget()) {
                    sharedElementInternalState = sharedElementInternalState2;
                }
                if (i < 0) {
                    break;
                } else {
                    size = i;
                }
            }
        }
        if (kotlin.jvm.internal.k.b(sharedElementInternalState, this.targetBoundsProvider)) {
            return;
        }
        this.targetBoundsProvider = sharedElementInternalState;
        set_targetBounds(null);
    }
}
