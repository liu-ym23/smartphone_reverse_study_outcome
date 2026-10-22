package androidx.compose.foundation;

import C7.r;
import H7.c;
import S7.k;
import S7.n;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aR+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0005R+\u0010$\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010\u0005R\u001a\u0010&\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u001dR\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u00108\u001a\u0002008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R$\u0010<\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00028F@@X\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010\u0005R\u0011\u0010@\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010A\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u00104R\u0014\u0010C\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00104R\u0014\u0010E\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u00104¨\u0006G"}, d2 = {"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "initial", AppAgent.CONSTRUCT, "(I)V", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "LH7/c;", "LC7/r;", "", "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "", "delta", "dispatchRawDelta", "(F)F", "value", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateScrollTo", "(ILandroidx/compose/animation/core/AnimationSpec;LH7/c;)Ljava/lang/Object;", "scrollTo", "(ILH7/c;)Ljava/lang/Object;", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableIntState;", "getValue", "()I", "setValue", "viewportSize$delegate", "getViewportSize", "setViewportSize$foundation_release", "viewportSize", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/runtime/MutableIntState;", "_maxValueState", "accumulator", "F", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "canScrollForward$delegate", "Landroidx/compose/runtime/State;", "getCanScrollForward", "()Z", "canScrollForward", "canScrollBackward$delegate", "getCanScrollBackward", "canScrollBackward", "newMax", "getMaxValue", "setMaxValue$foundation_release", "maxValue", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "isScrollInProgress", "getLastScrolledForward", "lastScrolledForward", "getLastScrolledBackward", "lastScrolledBackward", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollState implements ScrollableState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<ScrollState, ?> Saver = SaverKt.Saver(new n() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$1
        @Override // S7.n
        public final Integer invoke(SaverScope saverScope, ScrollState scrollState) {
            return Integer.valueOf(scrollState.getValue());
        }
    }, new k() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final ScrollState invoke(int i) {
            return new ScrollState(i);
        }
    });
    private float accumulator;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableIntState value;

    /* renamed from: viewportSize$delegate, reason: from kotlin metadata */
    private final MutableIntState viewportSize = SnapshotIntStateKt.mutableIntStateOf(0);
    private final MutableInteractionSource internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
    private MutableIntState _maxValueState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
    private final ScrollableState scrollableState = ScrollableStateKt.ScrollableState(new k() { // from class: androidx.compose.foundation.ScrollState$scrollableState$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).floatValue());
        }

        public final Float invoke(float f) {
            float value = this.this$0.accumulator + this.this$0.getValue() + f;
            float fT = AbstractC1451a.t(value, 0.0f, this.this$0.getMaxValue());
            boolean z10 = value == fT;
            float value2 = fT - this.this$0.getValue();
            int iRound = Math.round(value2);
            ScrollState scrollState = this.this$0;
            scrollState.setValue(scrollState.getValue() + iRound);
            this.this$0.accumulator = value2 - iRound;
            if (!z10) {
                f = value2;
            }
            return Float.valueOf(f);
        }
    });

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final State canScrollForward = SnapshotStateKt.derivedStateOf(new S7.a() { // from class: androidx.compose.foundation.ScrollState$canScrollForward$2
        {
            super(0);
        }

        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getValue() < this.this$0.getMaxValue());
        }
    });

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final State canScrollBackward = SnapshotStateKt.derivedStateOf(new S7.a() { // from class: androidx.compose.foundation.ScrollState$canScrollBackward$2
        {
            super(0);
        }

        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.getValue() > 0);
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/ScrollState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/ScrollState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<ScrollState, ?> getSaver() {
            return ScrollState.Saver;
        }

        private Companion() {
        }
    }

    public ScrollState(int i) {
        this.value = SnapshotIntStateKt.mutableIntStateOf(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollTo$default(ScrollState scrollState, int i, AnimationSpec animationSpec, c cVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 0.0f, null, 7, null);
        }
        return scrollState.animateScrollTo(i, animationSpec, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setValue(int i) {
        this.value.setIntValue(i);
    }

    public final Object animateScrollTo(int i, AnimationSpec<Float> animationSpec, c<? super r> cVar) {
        Object objAnimateScrollBy = ScrollExtensionsKt.animateScrollBy(this, i - getValue(), animationSpec, cVar);
        return objAnimateScrollBy == CoroutineSingletons.f4909a ? objAnimateScrollBy : r.f317a;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final int getMaxValue() {
        return this._maxValueState.getIntValue();
    }

    public final int getValue() {
        return this.value.getIntValue();
    }

    public final int getViewportSize() {
        return this.viewportSize.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, n nVar, c<? super r> cVar) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, nVar, cVar);
        return objScroll == CoroutineSingletons.f4909a ? objScroll : r.f317a;
    }

    public final Object scrollTo(int i, c<? super Float> cVar) {
        return ScrollExtensionsKt.scrollBy(this, i - getValue(), cVar);
    }

    public final void setMaxValue$foundation_release(int i) {
        this._maxValueState.setIntValue(i);
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getValue() > i) {
                setValue(i);
            }
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public final void setViewportSize$foundation_release(int i) {
        this.viewportSize.setIntValue(i);
    }
}
