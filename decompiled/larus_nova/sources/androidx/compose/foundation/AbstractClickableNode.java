package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b!\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001nBM\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00101\u001a\u00020\rH\u0002J\n\u00102\u001a\u0004\u0018\u00010#H&J\f\u00103\u001a\u00020\u0015*\u000204H\u0016JS\u00105\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0004¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020\u0015J\b\u00108\u001a\u00020\u0015H\u0016J\u0006\u00109\u001a\u00020\u0015J\b\u0010:\u001a\u00020\u0015H\u0004J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\rH\u0002J\b\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J'\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020\u0015H\u0016J\u0015\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH$¢\u0006\u0004\bO\u0010MJ\u0017\u0010P\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH$¢\u0006\u0004\bQ\u0010MJ\b\u0010R\u001a\u00020\u0015H\u0014J\u0015\u0010S\u001a\u00020\r2\u0006\u0010J\u001a\u00020K¢\u0006\u0004\bT\u0010MJ\n\u0010W\u001a\u00020\u0015*\u000204J\u000f\u0010X\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0002\u0010YJ\u0017\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020-H\u0004¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u00152\u0006\u0010]\u001a\u00020-H\u0004¢\u0006\u0004\ba\u0010_J\b\u0010b\u001a\u00020\u0015H\u0004J\u001c\u0010c\u001a\u00020\u0015*\u00020d2\u0006\u0010]\u001a\u00020-H\u0084@¢\u0006\u0004\be\u0010fJ\b\u0010g\u001a\u00020\rH\u0002J\b\u0010h\u001a\u00020\u0015H\u0002J\b\u0010i\u001a\u00020\u0015H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\rX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020'0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010U\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bV\u0010\u001aR\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\u00020kX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010m¨\u0006o"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getEnabled", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "localIndicationNodeFactory", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "currentKeyPressInteractions", "Landroidx/collection/MutableLongObjectMap;", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "userProvidedInteractionSource", "lazilyCreateIndication", "shouldLazilyCreateIndication", "createPointerInputNodeIfNeeded", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCommon", "updateCommon-O2vRcR0", "onAttach", "onObservedReadsChanged", "onDetach", "disposeInteractions", "onFocusChange", "isFocused", "recreateIndicationIfNeeded", "initializeIndicationAndInteractionSourceIfNeeded", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyDownEvent", "onClickKeyDownEvent-ZmokQxo", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "resetPointerInputHandler", "()Lkotlin/Unit;", "delayJob", "Lkotlinx/coroutines/Job;", "handlePressInteractionStart", "offset", "handlePressInteractionStart-k-4lQ0M", "(J)V", "handlePressInteractionRelease", "handlePressInteractionRelease-k-4lQ0M", "handlePressInteractionCancel", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public static final int $stable = 0;
    public static final TraverseKey TraverseKey = null;
    private long centerOffset;
    private final MutableLongObjectMap<PressInteraction.Press> currentKeyPressInteractions;
    private Job delayJob;
    private boolean enabled;
    private final FocusableNode focusableNode;
    private HoverInteraction.Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private IndicationNodeFactory localIndicationNodeFactory;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private boolean useLocalIndication;
    private MutableInteractionSource userProvidedInteractionSource;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraverseKey {
        private TraverseKey() {
        }

        public /* synthetic */ TraverseKey(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        TraverseKey = new TraverseKey(null);
        $stable = 8;
    }

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource r100, IndicationNodeFactory r101, boolean r102, boolean r103, String r104, Role r105, Function0 r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ boolean a(AbstractClickableNode r100) {
        return applySemantics$lambda$12(r100);
    }

    public static /* synthetic */ Unit b(AbstractClickableNode r100) {
        return onObservedReadsChanged$lambda$1(r100);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver r100) {
    }

    public abstract SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded();

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long mo195getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.CC.m6621$default$getTouchBoundsExpansionRZrCHBk(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.CC.$default$isImportantForBounds(this);
    }

    public void onCancelKeyInput() {
    }

    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo, reason: not valid java name */
    public abstract boolean mo199onClickKeyDownEventZmokQxo(KeyEvent r100);

    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo, reason: not valid java name */
    public abstract boolean mo200onClickKeyUpEventZmokQxo(KeyEvent r100);

    @Override // androidx.compose.ui.Modifier.Node, androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo203onPreKeyEventZmokQxo(KeyEvent r100) {
        return false;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    private final void emitHoverEnter() {
        if (this.hoverInteraction != null) goto L9;
        HoverInteraction.Enter r100 = new HoverInteraction.Enter();
        MutableInteractionSource r101 = this.interactionSource;
        if (r101 == null) goto L7;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(r101, r100, null), 3, null);
    L7:
        this.hoverInteraction = r100;
        return;
    }

    private final void emitHoverExit() {
        HoverInteraction.Enter r100 = this.hoverInteraction;
        if (r100 == null) goto L9;
        HoverInteraction.Exit r101 = new HoverInteraction.Exit(r100);
        MutableInteractionSource r102 = this.interactionSource;
        if (r102 == null) goto L7;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(r102, r101, null), 3, null);
    L7:
        this.hoverInteraction = null;
        return;
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode == null) goto L6;
        return;
    L6:
        if (this.useLocalIndication == false) goto L8;
        IndicationNodeFactory r100 = this.localIndicationNodeFactory;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (this.interactionSource != null) goto L13;
        this.interactionSource = InteractionSourceKt.MutableInteractionSource();
    L13:
        this.focusableNode.update(this.interactionSource);
        MutableInteractionSource r101 = this.interactionSource;
        Intrinsics.checkNotNull(r101);
        DelegatableNode r102 = r100.create(r101);
        delegate(r102);
        this.indicationNode = r102;
        return;
    L8:
        r100 = this.indicationNodeFactory;
        goto L9
    }

    private final void recreateIndicationIfNeeded() {
        DelegatableNode r100 = this.indicationNode;
        if (r100 == null) goto L5;
    L6:
        if (r100 == null) goto L8;
        undelegate(r100);
    L8:
        this.indicationNode = null;
        initializeIndicationAndInteractionSourceIfNeeded();
        return;
    L5:
        if (this.lazilyCreateIndication == false) goto L6;
    }

    private final boolean shouldLazilyCreateIndication() {
        if (this.userProvidedInteractionSource != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void disposeInteractions() {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L27;
        PressInteraction.Press r101 = this.pressInteraction;
        if (r101 == null) goto L7;
        r100.tryEmit(new PressInteraction.Cancel(r101));
    L7:
        HoverInteraction.Enter r102 = this.hoverInteraction;
        if (r102 == null) goto L10;
        r100.tryEmit(new HoverInteraction.Exit(r102));
    L10:
        MutableLongObjectMap<PressInteraction.Press> r103 = this.currentKeyPressInteractions;
        Object[] r104 = r103.values;
        long[] r105 = r103.metadata;
        int r106 = r105.length - 2;
        if (r106 < 0) goto L27;
        int r107 = 0;
    L13:
        long r108 = r105[r107];
        if (((((~r108) << 7) & r108) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r109 = 8 - ((~(r107 - r106)) >>> 31);
        int r110 = 0;
    L16:
        if (r110 >= r109) goto L24;
        if ((255 & r108) >= 128) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L23;
        r100.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) r104[(r107 << 3) + r110]));
    L23:
        r108 = r108 >> 8;
        r110 = r110 + 1;
        goto L16
    L20:
        r111 = false;
        goto L21
    L24:
        if (r109 != 8) goto L27;
    L25:
        if (r107 == r106) goto L27;
        r107 = r107 + 1;
    L27:
        this.pressInteraction = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    public final void handlePressInteractionCancel() {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L19;
        Job r101 = this.delayJob;
        boolean r102 = false;
        if (r101 == null) goto L10;
        if (r101.isActive() != true) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L14;
        Job r103 = this.delayJob;
        if (r103 == null) goto L17;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L17:
        this.pressInteraction = null;
        return;
    L14:
        PressInteraction.Press r104 = this.pressInteraction;
        if (r104 == null) goto L17;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionCancel$1$1$1(r104, r100, null), 3, null);
        goto L17
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L7;
        HoverInteraction.Enter r101 = this.hoverInteraction;
        if (r101 == null) goto L7;
        r100.tryEmit(new HoverInteraction.Exit(r101));
    L7:
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode r102 = this.pointerInputNode;
        if (r102 == null) goto L11;
        r102.onCancelPointerInput();
        return;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        if (this.useLocalIndication == false) goto L6;
        ObserverModifierNodeKt.observeReads(this, new b(this));
        return;
    }

    public final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode r100 = this.pointerInputNode;
        if (r100 == null) goto L5;
        r100.resetPointerInputHandler();
        return Unit.INSTANCE;
    L5:
        return null;
    }

    private final boolean delayPressInteraction() {
        if (ClickableKt.hasScrollableContainer(this) == false) goto L5;
    L8:
        return true;
    L5:
        if (Clickable_androidKt.isComposeRootInScrollableContainer(this) == true) goto L8;
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        if (this.lazilyCreateIndication == true) goto L6;
        initializeIndicationAndInteractionSourceIfNeeded();
    L6:
        if (this.enabled == false) goto L9;
        delegate(this.focusableNode);
        return;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource != null) goto L5;
        this.interactionSource = null;
    L5:
        DelegatableNode r100 = this.indicationNode;
        if (r100 == null) goto L8;
        undelegate(r100);
    L8:
        this.indicationNode = null;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public static final /* synthetic */ boolean access$delayPressInteraction(AbstractClickableNode r100) {
        return r100.delayPressInteraction();
    }

    public static final /* synthetic */ void access$emitHoverEnter(AbstractClickableNode r100) {
        r100.emitHoverEnter();
    }

    public static final /* synthetic */ void access$emitHoverExit(AbstractClickableNode r100) {
        r100.emitHoverExit();
    }

    public static final /* synthetic */ Job access$getDelayJob$p(AbstractClickableNode r100) {
        return r100.delayJob;
    }

    public static final /* synthetic */ MutableInteractionSource access$getInteractionSource$p(AbstractClickableNode r100) {
        return r100.interactionSource;
    }

    public static final /* synthetic */ PressInteraction.Press access$getPressInteraction$p(AbstractClickableNode r100) {
        return r100.pressInteraction;
    }

    private static final boolean applySemantics$lambda$12(AbstractClickableNode r100) {
        r100.onClick.invoke();
        return true;
    }

    private final void onFocusChange(boolean r110) {
        if (r110 == false) goto L6;
        initializeIndicationAndInteractionSourceIfNeeded();
        return;
    L6:
        if (this.interactionSource == null) goto L24;
        MutableLongObjectMap<PressInteraction.Press> r100 = this.currentKeyPressInteractions;
        Object[] r101 = r100.values;
        long[] r102 = r100.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
    L10:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L13:
        if (r111 >= r106) goto L21;
        if ((255 & r105) >= 128) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L20;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$1$1(this, (PressInteraction.Press) r101[(r104 << 3) + r111], null), 3, null);
    L20:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L13
    L17:
        r112 = false;
        goto L18
    L21:
        if (r106 != 8) goto L24;
    L22:
        if (r104 == r103) goto L24;
        r104 = r104 + 1;
    L24:
        this.currentKeyPressInteractions.clear();
        onCancelKeyInput();
    }

    private static final Unit onObservedReadsChanged$lambda$1(AbstractClickableNode r100) {
        Indication r101 = (Indication) CompositionLocalConsumerModifierNodeKt.currentValueOf(r100, IndicationKt.getLocalIndication());
        if ((r101 instanceof IndicationNodeFactory) == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException(ClickableKt.access$unsupportedIndicationExceptionMessage(r101));
    L5:
        IndicationNodeFactory r102 = r100.localIndicationNodeFactory;
        IndicationNodeFactory r103 = (IndicationNodeFactory) r101;
        r100.localIndicationNodeFactory = r103;
        if (r102 == null) goto L11;
        if (Intrinsics.areEqual(r103, r102) == true) goto L11;
        r100.recreateIndicationIfNeeded();
    L11:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver r100) {
        Role r101 = this.role;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        SemanticsPropertiesKt.m6788setRolekuIjeqM(r100, r101.m6768unboximpl());
    L5:
        SemanticsPropertiesKt.onClick(r100, this.onClickLabel, new a(this));
        if (this.enabled == false) goto L8;
        this.focusableNode.applySemantics(r100);
    L9:
        applyAdditionalSemantics(r100);
        return;
    L8:
        SemanticsPropertiesKt.disabled(r100);
        goto L9
    }

    /* JADX INFO: renamed from: handlePressInteractionRelease-k-4lQ0M, reason: not valid java name */
    public final void m197handlePressInteractionReleasek4lQ0M(long r110) {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L17;
        Job r101 = this.delayJob;
        boolean r102 = false;
        if (r101 == null) goto L10;
        if (r101.isActive() != true) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L12;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(this, r110, r100, null), 3, null);
    L15:
        this.pressInteraction = null;
        return;
    L12:
        PressInteraction.Press r111 = this.pressInteraction;
        if (r111 == null) goto L15;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$2$1(r111, r100, null), 3, null);
        goto L15
    }

    /* JADX INFO: renamed from: handlePressInteractionStart-k-4lQ0M, reason: not valid java name */
    public final void m198handlePressInteractionStartk4lQ0M(long r110) {
        MutableInteractionSource r100 = this.interactionSource;
        if (r100 == null) goto L9;
        PressInteraction.Press r101 = new PressInteraction.Press(r110, null);
        if (delayPressInteraction() == false) goto L7;
        this.delayJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(r100, r101, this, null), 3, null);
        return;
    L7:
        this.pressInteraction = r101;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(r100, r101, null), 3, null);
        return;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo201onKeyEventZmokQxo(KeyEvent r110) {
        initializeIndicationAndInteractionSourceIfNeeded();
        long r100 = KeyEvent_androidKt.m5977getKeyZmokQxo(r110);
        if (this.enabled == false) goto L18;
        if (ClickableKt.m261access$isPressZmokQxo(r110) == false) goto L18;
        if (this.currentKeyPressInteractions.containsKey(r100) == true) goto L12;
        PressInteraction.Press r101 = new PressInteraction.Press(this.centerOffset, null);
        this.currentKeyPressInteractions.set(r100, r101);
        if (this.interactionSource == null) goto L11;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, r101, null), 3, null);
    L11:
        boolean r102 = true;
    L14:
        if (mo199onClickKeyDownEventZmokQxo(r110) == true) goto L31;
        if (r102 == true) goto L32;
    L29:
        return false;
    L32:
        return true;
    L31:
        return true;
    L12:
        r102 = false;
    L18:
        if (this.enabled == false) goto L29;
        if (ClickableKt.m260access$isClickZmokQxo(r110) == false) goto L29;
        PressInteraction.Press r103 = this.currentKeyPressInteractions.remove(r100);
        if (r103 != null) goto L24;
    L27:
        if (r103 == null) goto L29;
        return true;
    L24:
        if (this.interactionSource == null) goto L26;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, r103, null), 3, null);
    L26:
        mo200onClickKeyUpEventZmokQxo(r110);
        goto L27
    }

    public static final /* synthetic */ void access$onFocusChange(AbstractClickableNode r100, boolean r101) {
        r100.onFocusChange(r101);
    }

    public static final /* synthetic */ void access$setPressInteraction$p(AbstractClickableNode r100, PressInteraction.Press r101) {
        r100.pressInteraction = r101;
    }

    /* JADX INFO: renamed from: handlePressInteraction-d-4ec7I, reason: not valid java name */
    public final Object m196handlePressInteractiond4ec7I(PressGestureScope r100, long r110, Continuation<? super Unit> r111) {
        MutableInteractionSource r101 = this.interactionSource;
        if (r101 == null) goto L8;
        Object r102 = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(r100, r110, r101, this, null), r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo202onPointerEventH0pRuoY(PointerEvent r110, PointerEventPass r111, long r112) {
        long r100 = IntSizeKt.m7725getCenterozmzZPI(r112);
        float r101 = IntOffset.m7676getXimpl(r100);
        float r102 = IntOffset.m7677getYimpl(r100);
        this.centerOffset = Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (Float.floatToRawIntBits(r102) & BodyPartID.bodyIdMax));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled == false) goto L13;
        if (r111 != PointerEventPass.Main) goto L13;
        int r103 = r110.m6068getType7fucELk();
        PointerEventType.Companion r104 = PointerEventType.Companion;
        if (PointerEventType.m6075equalsimpl0(r103, r104.m6079getEnter7fucELk()) == false) goto L10;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
        goto L13
    L10:
        if (PointerEventType.m6075equalsimpl0(r103, r104.m6080getExit7fucELk()) == false) goto L13;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
    L13:
        if (this.pointerInputNode != null) goto L17;
        SuspendingPointerInputModifierNode r105 = createPointerInputNodeIfNeeded();
        if (r105 == null) goto L17;
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(r105);
    L17:
        SuspendingPointerInputModifierNode r106 = this.pointerInputNode;
        if (r106 == null) goto L21;
        r106.mo202onPointerEventH0pRuoY(r110, r111, r112);
        return;
    }

    private AbstractClickableNode(MutableInteractionSource r100, IndicationNodeFactory r101, boolean r102, boolean r103, String r104, Role r105, Function0<Unit> r106) {
        this.interactionSource = r100;
        this.indicationNodeFactory = r101;
        this.useLocalIndication = r102;
        this.onClickLabel = r104;
        this.role = r105;
        this.enabled = r103;
        this.onClick = r106;
        this.focusableNode = new FocusableNode(this.interactionSource, Focusability.Companion.m4518getSystemDefinedLCbbffg(), new AbstractClickableNode$focusableNode$1(this), null);
        this.currentKeyPressInteractions = LongObjectMapKt.mutableLongObjectMapOf();
        this.centerOffset = Offset.Companion.m4598getZeroF1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = TraverseKey;
    }

    /* JADX INFO: renamed from: updateCommon-O2vRcR0, reason: not valid java name */
    public final void m204updateCommonO2vRcR0(MutableInteractionSource r100, IndicationNodeFactory r101, boolean r102, boolean r103, String r104, Role r105, Function0<Unit> r106) {
        boolean r107 = true;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, r100) == true) goto L5;
        disposeInteractions();
        this.userProvidedInteractionSource = r100;
        this.interactionSource = r100;
        boolean r108 = true;
    L7:
        if (Intrinsics.areEqual(this.indicationNodeFactory, r101) == true) goto L10;
        this.indicationNodeFactory = r101;
        r108 = true;
    L10:
        if (this.useLocalIndication == r102) goto L16;
        this.useLocalIndication = r102;
        if (r102 == false) goto L14;
        onObservedReadsChanged();
    L14:
        r108 = true;
    L16:
        if (this.enabled == r103) goto L22;
        if (r103 == false) goto L19;
        delegate(this.focusableNode);
    L20:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        this.enabled = r103;
        goto L22
    L19:
        undelegate(this.focusableNode);
        disposeInteractions();
    L22:
        if (Intrinsics.areEqual(this.onClickLabel, r104) == true) goto L25;
        this.onClickLabel = r104;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L25:
        if (Intrinsics.areEqual(this.role, r105) == true) goto L27;
        this.role = r105;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L27:
        this.onClick = r106;
        if (this.lazilyCreateIndication == shouldLazilyCreateIndication()) goto L34;
        boolean r109 = shouldLazilyCreateIndication();
        this.lazilyCreateIndication = r109;
        if (r109 == true) goto L34;
        if (this.indicationNode != null) goto L34;
    L35:
        if (r107 == false) goto L37;
        recreateIndicationIfNeeded();
    L37:
        this.focusableNode.update(this.interactionSource);
        return;
    L34:
        r107 = r108;
        goto L35
    L5:
        r108 = false;
        goto L7
    }
}
