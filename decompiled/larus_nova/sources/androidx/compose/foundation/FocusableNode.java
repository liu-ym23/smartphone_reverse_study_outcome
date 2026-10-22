package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.relocation.BringIntoViewModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001<B3\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010%\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'H\u0002J\f\u0010-\u001a\u00020\u000e*\u00020.H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u001dH\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020\u000eH\u0002J\u0014\u00109\u001a\u00020\u000e*\u00020\b2\u0006\u0010:\u001a\u00020;H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006="}, d2 = {"Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "globalLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusTargetNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "requestFocus", "focusedBoundsObserver", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getFocusedBoundsObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "update", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "onFocusStateChange", "previousState", "currentState", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onReset", "onObservedReadsChanged", "onGloballyPositioned", "coordinates", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "notifyObserverWhenAttached", "emitInteraction", "isFocused", "disposeInteractionSource", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "TraverseKey", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusableNode extends DelegatingNode implements SemanticsModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, TraversableNode {
    public static final int $stable = 0;
    private static final TraverseKey TraverseKey = null;
    private final FocusTargetModifierNode focusTargetNode;
    private FocusInteraction.Focus focusedInteraction;
    private LayoutCoordinates globalLayoutCoordinates;
    private MutableInteractionSource interactionSource;
    private final Function1<Boolean, Unit> onFocusChange;
    private PinnableContainer.PinnedHandle pinnedHandle;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/FocusableNode$TraverseKey;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraverseKey {
        private TraverseKey() {
        }

        public /* synthetic */ TraverseKey(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$applySemantics$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(Object r100) {
            super(0, r100, FocusableNode.class, "requestFocus", "requestFocus()Z", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(((FocusableNode) this.receiver).requestFocus());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$emitWithFallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.FocusableNode$emitWithFallback$1", f = "Focusable.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.m0 $handler;
        final /* synthetic */ Interaction $interaction;
        final /* synthetic */ MutableInteractionSource $this_emitWithFallback;
        int label;

        public C85581(MutableInteractionSource r100, Interaction r101, kotlinx.coroutines.m0 r102, Continuation<? super C85581> r103) {
            this.$this_emitWithFallback = r100;
            this.$interaction = r101;
            this.$handler = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C85581(this.$this_emitWithFallback, this.$interaction, this.$handler, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85581) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            kotlinx.coroutines.m0 r103 = this.$handler;
            if (r103 == null) goto L15;
            r103.dispose();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableInteractionSource r104 = this.$this_emitWithFallback;
            Interaction r105 = this.$interaction;
            this.label = 1;
            if (r104.emit(r105, this) != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$onFocusStateChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.FocusableNode$onFocusStateChange$1", f = "Focusable.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FocusableNode this$0;

        public C85591(FocusableNode r100, Continuation<? super C85591> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C85591(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85591) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FocusableNode r103 = this.this$0;
            this.label = 1;
            if (BringIntoViewModifierNodeKt.bringIntoView$default(r103, null, this, 1, null) != r101) goto L12;
            return r101;
        }
    }

    static {
        TraverseKey = new TraverseKey(null);
        $stable = 8;
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource r100, int r101, Function1 r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public static /* synthetic */ Unit a(Ref.ObjectRef r100, FocusableNode r101) {
        return retrievePinnableContainer$lambda$0(r100, r101);
    }

    public static /* synthetic */ Unit b(MutableInteractionSource r100, Interaction r101, Throwable r102) {
        return emitWithFallback$lambda$6(r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.CC.$default$isImportantForBounds(this);
    }

    private final void disposeInteractionSource() {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L7;
        FocusInteraction.Focus r101 = this.focusedInteraction;
        if (r101 == null) goto L7;
        r100.tryEmit(new FocusInteraction.Unfocus(r101));
    L7:
        this.focusedInteraction = null;
    }

    private final void notifyObserverWhenAttached() {
        LayoutCoordinates r100 = this.globalLayoutCoordinates;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNull(r100);
        if (r100.isAttached() == false) goto L11;
        FocusedBoundsObserverNode r101 = getFocusedBoundsObserver();
        if (r101 == null) goto L12;
        r101.onFocusBoundsChanged(this.globalLayoutCoordinates);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final PinnableContainer retrievePinnableContainer() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new n0(r100, this));
        return (PinnableContainer) r100.element;
    }

    public final FocusState getFocusState() {
        return this.focusTargetNode.getFocusState();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        PinnableContainer.PinnedHandle r100 = this.pinnedHandle;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.pinnedHandle = null;
    }

    public final boolean requestFocus() {
        return FocusTargetModifierNode.CC.m4494requestFocus3ESFkO8$default(this.focusTargetNode, 0, 1, null);
    }

    private final FocusedBoundsObserverNode getFocusedBoundsObserver() {
        if (isAttached() == false) goto L8;
        TraversableNode r100 = TraversableNodeKt.findNearestAncestor(this, FocusedBoundsObserverNode.TraverseKey);
        if ((r100 instanceof FocusedBoundsObserverNode) == true) goto L7;
        return null;
    L7:
        return (FocusedBoundsObserverNode) r100;
    L8:
        return null;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        PinnableContainer r100 = retrievePinnableContainer();
        if (this.focusTargetNode.getFocusState().isFocused() == false) goto L12;
        PinnableContainer.PinnedHandle r101 = this.pinnedHandle;
        if (r101 == null) goto L7;
        r101.release();
    L7:
        if (r100 == null) goto L9;
        PinnableContainer.PinnedHandle r102 = r100.pin();
    L10:
        this.pinnedHandle = r102;
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return TraverseKey;
    }

    private final void emitInteraction(boolean r100) {
        MutableInteractionSource r101 = this.interactionSource;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L10;
        FocusInteraction.Focus r102 = this.focusedInteraction;
        if (r102 == null) goto L9;
        emitWithFallback(r101, new FocusInteraction.Unfocus(r102));
        this.focusedInteraction = null;
    L9:
        FocusInteraction.Focus r103 = new FocusInteraction.Focus();
        emitWithFallback(r101, r103);
        this.focusedInteraction = r103;
        return;
    L10:
        FocusInteraction.Focus r104 = this.focusedInteraction;
        if (r104 == null) goto L16;
        emitWithFallback(r101, new FocusInteraction.Unfocus(r104));
        this.focusedInteraction = null;
        return;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver r100) {
        SemanticsPropertiesKt.setFocused(r100, this.focusTargetNode.getFocusState().isFocused());
        SemanticsPropertiesKt.requestFocus$default(r100, null, new AnonymousClass1(this), 1, null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates r100) {
        this.globalLayoutCoordinates = r100;
        if (this.focusTargetNode.getFocusState().isFocused() == true) goto L6;
        return;
    L6:
        if (r100.isAttached() == false) goto L8;
        notifyObserverWhenAttached();
        return;
    L8:
        FocusedBoundsObserverNode r101 = getFocusedBoundsObserver();
        if (r101 == null) goto L13;
        r101.onFocusBoundsChanged(null);
        return;
    }

    public final void update(MutableInteractionSource r100) {
        if (Intrinsics.areEqual(this.interactionSource, r100) == true) goto L6;
        disposeInteractionSource();
        this.interactionSource = r100;
        return;
    }

    private final void emitWithFallback(final MutableInteractionSource r100, final Interaction r110) {
        if (isAttached() == false) goto L9;
        Job r101 = (Job) getCoroutineScope().getCoroutineContext().get(Job.Key);
        if (r101 == null) goto L7;
        kotlinx.coroutines.m0 r102 = r101.invokeOnCompletion(new m0(r100, r110));
    L8:
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C85581(r100, r110, r102, null), 3, null);
        return;
    L7:
        r102 = null;
        goto L8
    L9:
        r100.tryEmit(r110);
    }

    private final void onFocusStateChange(FocusState r100, FocusState r101) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        boolean r102 = r101.isFocused();
        if (r102 != r100.isFocused()) goto L8;
        return;
    L8:
        Function1<Boolean, Unit> r103 = this.onFocusChange;
        if (r103 == null) goto L11;
        r103.invoke(Boolean.valueOf(r102));
    L11:
        PinnableContainer.PinnedHandle r104 = null;
        if (r102 == false) goto L17;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C85591(this, null), 3, null);
        PinnableContainer r105 = retrievePinnableContainer();
        if (r105 == null) goto L16;
        r104 = r105.pin();
    L16:
        this.pinnedHandle = r104;
        notifyObserverWhenAttached();
    L23:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        emitInteraction(r102);
        return;
    L17:
        PinnableContainer.PinnedHandle r106 = this.pinnedHandle;
        if (r106 == null) goto L20;
        r106.release();
    L20:
        this.pinnedHandle = null;
        FocusedBoundsObserverNode r107 = getFocusedBoundsObserver();
        if (r107 == null) goto L23;
        r107.onFocusBoundsChanged(null);
        goto L23
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    private static final Unit retrievePinnableContainer$lambda$0(Ref.ObjectRef r100, FocusableNode r101) {
        r100.element = CompositionLocalConsumerModifierNodeKt.currentValueOf(r101, PinnableContainerKt.getLocalPinnableContainer());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FocusableNode(MutableInteractionSource r100, int r101, Function1<? super Boolean, Unit> r102) {
        this.interactionSource = r100;
        this.onFocusChange = r102;
        this.focusTargetNode = (FocusTargetModifierNode) delegate(FocusTargetModifierNodeKt.m4495FocusTargetModifierNodePYyLHbc(r101, new FocusableNode$focusTargetNode$1(this)));
    }

    public static final /* synthetic */ void access$onFocusStateChange(FocusableNode r100, FocusState r101, FocusState r102) {
        r100.onFocusStateChange(r101, r102);
    }

    private static final Unit emitWithFallback$lambda$6(MutableInteractionSource r100, Interaction r101, Throwable r102) {
        r100.tryEmit(r101);
        return Unit.INSTANCE;
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource r100, int r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = Focusability.Companion.m4516getAlwaysLCbbffg();
    L5:
        DefaultConstructorMarker r105 = null;
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102, r105);
    }
}
