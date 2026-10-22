package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001KBe\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012:\b\u0002\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u001f\u001a\u00020\u0015H\u0017J\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\b\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\r\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7JK\u00108\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u00112\u001d\u0010;\u001a\u0019\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\b=H\u0082\b¢\u0006\u0004\b>\u0010?J,\u0010@\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\b¢\u0006\u0004\bA\u0010BJ,\u0010C\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\b¢\u0006\u0004\bD\u0010BJ\r\u0010E\u001a\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0000¢\u0006\u0002\bJR@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR&\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006L"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "onDispatchEventsCompleted", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "isProcessingCustomExit", "", "isProcessingCustomEnter", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "requestFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "value", "getFocusability-LCbbffg", "()I", "setFocusability-josRg5g", "(I)V", "I", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "setPreviouslyFocusedChildHash", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "onObservedReadsChanged", "onReset", "onDetach", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "fetchCustomEnterOrExit", "block", "Landroidx/compose/ui/focus/FocusRequester;", "enterOrExit", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "Lkotlin/ExtensionFunctionType;", "fetchCustomEnterOrExit-ULY8qGw", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "fetchCustomEnter", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "dispatchFocusCallbacks", "previousState", "newState", "dispatchFocusCallbacks$ui_release", "FocusTargetElement", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private FocusStateImpl committedFocusState;
    private int focusability;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private final Function1<FocusTargetNode, Unit> onDispatchEventsCompleted;
    private final Function2<FocusState, FocusState, Unit> onFocusChange;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "<init>", "()V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;
        public static final FocusTargetElement INSTANCE = null;

        static {
            INSTANCE = new FocusTargetElement();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object r100) {
            if (r100 != this) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return 1739042953;
        }

        public void update(FocusTargetNode r100) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return new FocusTargetNode(0, null, null, 7, null);
        }

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public /* bridge */ /* synthetic */ Modifier.Node create() {
            return create();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo r100) {
            r100.setName("focusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
            update((FocusTargetNode) r100);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[CustomDestinationResult.values().length];
            r100[CustomDestinationResult.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[CustomDestinationResult.Redirected.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[CustomDestinationResult.Cancelled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[FocusStateImpl.values().length];
            r101[FocusStateImpl.Active.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[FocusStateImpl.Captured.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[FocusStateImpl.ActiveParent.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[FocusStateImpl.Inactive.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            $EnumSwitchMapping$1 = r101;
        }
    }

    public /* synthetic */ FocusTargetNode(int r100, Function2 r101, Function1 r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public final /* synthetic */ Object getCurrent(ModifierLocal r100) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, r100);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.CC.$default$getProvidedValues(this);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final /* synthetic */ void provide(ModifierLocal r100, Object r101) {
        ModifierLocalModifierNode.CC.$default$provide(this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    public final FocusProperties fetchFocusProperties$ui_release() {
        FocusPropertiesImpl r100 = new FocusPropertiesImpl();
        r100.setCanFocus(Focusability.m4509canFocusimpl$ui_release(mo4491getFocusabilityLCbbffg(), this));
        int r101 = NodeKind.m6556constructorimpl(2048);
        int r102 = NodeKind.m6556constructorimpl(1024);
        Modifier.Node r103 = getNode();
        int r104 = r101 | r102;
        if (getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r105 = getNode();
        LayoutNode r106 = DelegatableNodeKt.requireLayoutNode(this);
    L6:
        if (r106 == null) goto L62;
        if ((r106.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r104) == 0) goto L56;
    L9:
        if (r105 == null) goto L56;
        if ((r105.getKindSet$ui_release() & r104) == 0) goto L55;
        if (r105 == r103) goto L20;
        if ((r105.getKindSet$ui_release() & r102) == 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == true) goto L62;
    L17:
        r110 = false;
    L20:
        if ((r105.getKindSet$ui_release() & r101) == 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L55;
        Modifier.Node r112 = r105;
        MutableVector r113 = null;
    L25:
        if (r112 == 0) goto L55;
        if ((r112 instanceof FocusPropertiesModifierNode) == true) goto L28;
        if ((r112.getKindSet$ui_release() & r101) == 0) goto L32;
        boolean r114 = true;
    L33:
        if (r114 == false) goto L54;
        if ((r112 instanceof DelegatingNode) == false) goto L54;
        Modifier.Node r115 = ((DelegatingNode) r112).getDelegate$ui_release();
        int r116 = 0;
        r112 = r112;
    L37:
        if (r115 == null) goto L52;
        if ((r115.getKindSet$ui_release() & r101) == 0) goto L41;
        boolean r117 = true;
    L42:
        if (r117 == false) goto L51;
        r116 = r116 + 1;
        if (r116 != 1) goto L46;
        r112 = r115;
        goto L51
    L46:
        if (r113 != null) goto L48;
        r113 = new MutableVector(new Modifier.Node[16], 0);
    L48:
        if (r112 == 0) goto L50;
        r113.add(r112);
        r112 = 0;
    L50:
        r113.add(r115);
    L51:
        r115 = r115.getChild$ui_release();
        r112 = r112;
        goto L37
    L41:
        r117 = false;
        goto L42
    L52:
        if (r116 == 1) goto L25;
    L54:
        r112 = DelegatableNodeKt.access$pop(r113);
        goto L25
    L32:
        r114 = false;
        goto L33
    L28:
        ((FocusPropertiesModifierNode) r112).applyFocusProperties(r100);
        goto L54
    L22:
        r111 = false;
    L55:
        r105 = r105.getParent$ui_release();
    L56:
        r106 = r106.getParent$ui_release();
        if (r106 == null) goto L61;
        NodeChain r107 = r106.getNodes$ui_release();
        if (r107 == null) goto L61;
        r105 = r107.getTail$ui_release();
    L61:
        r105 = null;
    L62:
        return r100;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        if (ComposeUiFlags.isClearFocusOnResetEnabled == true) goto L5;
        return;
    L5:
        if (getFocusState().isFocused() == false) goto L9;
        DelegatableNodeKt.requireOwner(this).getFocusOwner().mo4476clearFocusI7lrPNg(true, true, true, FocusDirection.Companion.m4467getExitdhqQ8s());
        return;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the version accepting FocusDirection", replaceWith = @ReplaceWith(expression = "this.requestFocus()", imports = {}))
    public /* synthetic */ boolean requestFocus() {
        return mo4492requestFocus3ESFkO8(FocusDirection.Companion.m4466getEnterdhqQ8s());
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) ModifierLocalModifierNode.CC.$default$getCurrent(this, androidx.compose.ui.layout.BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public FocusStateImpl getFocusState() {
        if (isAttached() == false) goto L5;
        FocusOwner r100 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode r101 = r100.getActiveFocusTargetNode();
        if (r101 == null) goto L9;
        if (this != r101) goto L16;
        if (r100.isFocusCaptured() == false) goto L93;
        return FocusStateImpl.Captured;
    L93:
        return FocusStateImpl.Active;
    L16:
        if (r101.isAttached() == false) goto L69;
        int r102 = NodeKind.m6556constructorimpl(1024);
        if (r101.getNode().isAttached() == true) goto L20;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L20:
        Modifier.Node r103 = r101.getNode().getParent$ui_release();
        LayoutNode r104 = DelegatableNodeKt.requireLayoutNode(r101);
    L21:
        if (r104 == null) goto L69;
        if ((r104.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r102) == 0) goto L62;
    L24:
        if (r103 == null) goto L62;
        if ((r103.getKindSet$ui_release() & r102) == 0) goto L61;
        Modifier.Node r105 = r103;
        MutableVector r106 = null;
    L28:
        if (r105 == null) goto L61;
        if ((r105 instanceof FocusTargetNode) == true) goto L32;
        if ((r105.getKindSet$ui_release() & r102) == 0) goto L38;
        boolean r107 = true;
    L39:
        if (r107 == false) goto L60;
        if ((r105 instanceof DelegatingNode) == false) goto L60;
        Modifier.Node r108 = ((DelegatingNode) r105).getDelegate$ui_release();
        int r109 = 0;
    L43:
        if (r108 == null) goto L58;
        if ((r108.getKindSet$ui_release() & r102) == 0) goto L47;
        boolean r110 = true;
    L48:
        if (r110 == false) goto L57;
        r109 = r109 + 1;
        if (r109 != 1) goto L52;
        r105 = r108;
        goto L57
    L52:
        if (r106 != null) goto L54;
        r106 = new MutableVector(new Modifier.Node[16], 0);
    L54:
        if (r105 == null) goto L56;
        r106.add(r105);
        r105 = null;
    L56:
        r106.add(r108);
    L57:
        r108 = r108.getChild$ui_release();
        goto L43
    L47:
        r110 = false;
        goto L48
    L58:
        if (r109 == 1) goto L28;
    L60:
        r105 = DelegatableNodeKt.access$pop(r106);
        goto L28
    L38:
        r107 = false;
        goto L39
    L32:
        if (this != ((FocusTargetNode) r105)) goto L60;
        return FocusStateImpl.ActiveParent;
    L61:
        r103 = r103.getParent$ui_release();
    L62:
        r104 = r104.getParent$ui_release();
        if (r104 == null) goto L67;
        NodeChain r111 = r104.getNodes$ui_release();
        if (r111 == null) goto L67;
        r103 = r111.getTail$ui_release();
    L67:
        r103 = null;
    L69:
        return FocusStateImpl.Inactive;
    L9:
        return FocusStateImpl.Inactive;
    L5:
        return FocusStateImpl.Inactive;
    }

    public final void invalidateFocus$ui_release() {
        FocusStateImpl r100 = getFocusState();
        int r101 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r101 != 1) goto L5;
    L13:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new FocusTargetNode$invalidateFocus$1(r102, this));
        T r103 = r102.element;
        if (r103 != 0) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
        FocusProperties r104 = null;
    L18:
        if (r104.getCanFocus() == true) goto L22;
        DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
        return;
    L22:
        return;
    L16:
        r104 = (FocusProperties) r103;
        goto L18
    L5:
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L9;
        return;
    L9:
        if (r101 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FocusStateImpl r100 = getFocusState();
        int r101 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
        if (r101 != 1) goto L5;
    L13:
        FocusOwner r102 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        r102.mo4476clearFocusI7lrPNg(true, true, false, FocusDirection.Companion.m4467getExitdhqQ8s());
        r102.scheduleInvalidationForOwner();
    L14:
        this.committedFocusState = null;
        return;
    L5:
        if (r101 == 2) goto L13;
        if (r101 == 3) goto L14;
        if (r101 == 4) goto L14;
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* JADX INFO: renamed from: getFocusability-LCbbffg */
    public int mo4491getFocusabilityLCbbffg() {
        return this.focusability;
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        invalidateFocus$ui_release();
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public /* bridge */ /* synthetic */ FocusState getFocusState() {
        return getFocusState();
    }

    public static final /* synthetic */ boolean access$isProcessingCustomEnter$p(FocusTargetNode r100) {
        return r100.isProcessingCustomEnter;
    }

    public static final /* synthetic */ boolean access$isProcessingCustomExit$p(FocusTargetNode r100) {
        return r100.isProcessingCustomExit;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* JADX INFO: renamed from: requestFocus-3ESFkO8 */
    public boolean mo4492requestFocus3ESFkO8(int r100) {
        Trace.beginSection("FocusTransactions:requestFocus");
    L23:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        boolean r101 = false;
        if (fetchFocusProperties$ui_release().getCanFocus() == true) goto L8;
        Trace.endSection();
        return false;
    L8:
        CustomDestinationResult r102 = FocusTransactionsKt.m4503performCustomRequestFocusMxy_nc0(this, r100);     // Catch: Throwable -> L23
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];     // Catch: Throwable -> L23
        if (r103 != 1) goto L11;
        r101 = FocusTransactionsKt.performRequestFocus(this);     // Catch: Throwable -> L23
    L21:
        Trace.endSection();
        return r101;
    L11:
        if (r103 != 2) goto L13;
        r101 = true;
        goto L21
    L13:
        if (r103 == 3) goto L21;
        if (r103 == 4) goto L21;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L23
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* JADX INFO: renamed from: setFocusability-josRg5g */
    public void mo4493setFocusabilityjosRg5g(int r100) {
        if (Focusability.m4512equalsimpl0(this.focusability, r100) == true) goto L12;
        this.focusability = r100;
        if (isAttached() == true) goto L7;
        return;
    L7:
        if (this == DelegatableNodeKt.requireOwner(this).getFocusOwner().getActiveFocusTargetNode()) goto L9;
        return;
    L9:
        if (Focusability.m4509canFocusimpl$ui_release(this.focusability, this) == true) goto L15;
        FocusTransactionsKt.clearFocus(this, true, true);
        return;
    L15:
        return;
    }

    public final void setPreviouslyFocusedChildHash(int r100) {
        this.previouslyFocusedChildHash = r100;
    }

    public static final /* synthetic */ void access$setProcessingCustomEnter$p(FocusTargetNode r100, boolean r101) {
        r100.isProcessingCustomEnter = r101;
    }

    public static final /* synthetic */ void access$setProcessingCustomExit$p(FocusTargetNode r100, boolean r101) {
        r100.isProcessingCustomExit = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    public final void dispatchFocusCallbacks$ui_release(FocusState r110, FocusState r111) {
        FocusOwner r100 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode r101 = r100.getActiveFocusTargetNode();
        if (Intrinsics.areEqual(r110, r111) == true) goto L7;
        Function2<FocusState, FocusState, Unit> r102 = this.onFocusChange;
        if (r102 == null) goto L7;
        r102.invoke(r110, r111);
    L7:
        int r103 = NodeKind.m6556constructorimpl(4096);
        int r104 = NodeKind.m6556constructorimpl(1024);
        Modifier.Node r105 = getNode();
        int r106 = r103 | r104;
        if (getNode().isAttached() == true) goto L10;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L10:
        Modifier.Node r107 = getNode();
        LayoutNode r108 = DelegatableNodeKt.requireLayoutNode(this);
    L11:
        if (r108 == null) goto L70;
        if ((r108.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r106) == 0) goto L64;
    L14:
        if (r107 == null) goto L64;
        if ((r107.getKindSet$ui_release() & r106) == 0) goto L63;
        int r112 = 1;
        if (r107 == r105) goto L25;
        if ((r107.getKindSet$ui_release() & r104) == 0) goto L22;
        boolean r113 = true;
    L23:
        if (r113 == true) goto L70;
    L22:
        r113 = false;
    L25:
        if ((r107.getKindSet$ui_release() & r103) == 0) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L63;
        Modifier.Node r115 = r107;
        MutableVector r116 = null;
    L30:
        if (r115 == 0) goto L63;
        if ((r115 instanceof FocusEventModifierNode) == true) goto L33;
        if ((r115.getKindSet$ui_release() & r103) == 0) goto L40;
        boolean r117 = true;
    L41:
        if (r117 == false) goto L62;
        if ((r115 instanceof DelegatingNode) == false) goto L62;
        Modifier.Node r118 = ((DelegatingNode) r115).getDelegate$ui_release();
        int r119 = 0;
        r115 = r115;
    L45:
        if (r118 == null) goto L60;
        if ((r118.getKindSet$ui_release() & r103) == 0) goto L49;
        boolean r120 = true;
    L50:
        if (r120 == false) goto L59;
        r119 = r119 + 1;
        if (r119 != r112) goto L54;
        r115 = r118;
        goto L59
    L54:
        if (r116 != null) goto L56;
        r116 = new MutableVector(new Modifier.Node[16], 0);
    L56:
        if (r115 == 0) goto L58;
        r116.add(r115);
        r115 = 0;
    L58:
        r116.add(r118);
    L59:
        r118 = r118.getChild$ui_release();
        r112 = 1;
        r115 = r115;
        goto L45
    L49:
        r120 = false;
        goto L50
    L60:
        if (r119 == r112) goto L30;
    L62:
        r115 = DelegatableNodeKt.access$pop(r116);
        goto L30
    L40:
        r117 = false;
        goto L41
    L33:
        FocusEventModifierNode r121 = (FocusEventModifierNode) r115;
        if (r101 != r100.getActiveFocusTargetNode()) goto L62;
        r121.onFocusEvent(r111);
        goto L62
    L27:
        r114 = false;
    L63:
        r107 = r107.getParent$ui_release();
    L64:
        r108 = r108.getParent$ui_release();
        if (r108 == null) goto L69;
        NodeChain r109 = r108.getNodes$ui_release();
        if (r109 == null) goto L69;
        r107 = r109.getTail$ui_release();
    L69:
        r107 = null;
    L70:
        Function1<FocusTargetNode, Unit> r122 = this.onDispatchEventsCompleted;
        if (r122 == null) goto L97;
        r122.invoke(this);
        return;
    }

    /* JADX INFO: renamed from: fetchCustomEnter-aToIllA$ui_release, reason: not valid java name */
    public final void m4498fetchCustomEnteraToIllA$ui_release(int r100, Function1<? super FocusRequester, Unit> r101) {
        if (access$isProcessingCustomEnter$p(this) == true) goto L15;
        access$setProcessingCustomEnter$p(this, true);
        FocusProperties r102 = fetchFocusProperties$ui_release();     // Catch: Throwable -> L12
        CancelIndicatingFocusBoundaryScope r103 = new CancelIndicatingFocusBoundaryScope(r100, null);     // Catch: Throwable -> L12
        FocusOwner r104 = DelegatableNodeKt.requireOwner(this).getFocusOwner();     // Catch: Throwable -> L12
        FocusTargetNode r105 = r104.getActiveFocusTargetNode();     // Catch: Throwable -> L12
        r102.getOnEnter().invoke(r103);     // Catch: Throwable -> L12
        FocusTargetNode r106 = r104.getActiveFocusTargetNode();     // Catch: Throwable -> L12
        if (r103.isCanceled() == false) goto L8;
        r101.invoke(FocusRequester.Companion.getCancel());     // Catch: Throwable -> L12
    L11:
        InlineMarker.finallyStart(1);
        access$setProcessingCustomEnter$p(this, false);
        InlineMarker.finallyEnd(1);
        return;
    L8:
        if (r105 == r106) goto L11;
        if (r106 == null) goto L11;
        r101.invoke(FocusRequester.Companion.getRedirect$ui_release());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        access$setProcessingCustomEnter$p(this, false);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX INFO: renamed from: fetchCustomExit-aToIllA$ui_release, reason: not valid java name */
    public final void m4499fetchCustomExitaToIllA$ui_release(int r100, Function1<? super FocusRequester, Unit> r101) {
        if (access$isProcessingCustomExit$p(this) == true) goto L15;
        access$setProcessingCustomExit$p(this, true);
        FocusProperties r102 = fetchFocusProperties$ui_release();     // Catch: Throwable -> L12
        CancelIndicatingFocusBoundaryScope r103 = new CancelIndicatingFocusBoundaryScope(r100, null);     // Catch: Throwable -> L12
        FocusOwner r104 = DelegatableNodeKt.requireOwner(this).getFocusOwner();     // Catch: Throwable -> L12
        FocusTargetNode r105 = r104.getActiveFocusTargetNode();     // Catch: Throwable -> L12
        r102.getOnExit().invoke(r103);     // Catch: Throwable -> L12
        FocusTargetNode r106 = r104.getActiveFocusTargetNode();     // Catch: Throwable -> L12
        if (r103.isCanceled() == false) goto L8;
        r101.invoke(FocusRequester.Companion.getCancel());     // Catch: Throwable -> L12
    L11:
        InlineMarker.finallyStart(1);
        access$setProcessingCustomExit$p(this, false);
        InlineMarker.finallyEnd(1);
        return;
    L8:
        if (r105 == r106) goto L11;
        if (r106 == null) goto L11;
        r101.invoke(FocusRequester.Companion.getRedirect$ui_release());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        access$setProcessingCustomExit$p(this, false);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FocusTargetNode(int r100, Function2<? super FocusState, ? super FocusState, Unit> r101, Function1<? super FocusTargetNode, Unit> r102) {
        this.onFocusChange = r101;
        this.onDispatchEventsCompleted = r102;
        this.focusability = r100;
    }

    /* JADX INFO: renamed from: fetchCustomEnterOrExit-ULY8qGw, reason: not valid java name */
    private final void m4497fetchCustomEnterOrExitULY8qGw(int r100, Function1<? super FocusRequester, Unit> r101, Function2<? super FocusProperties, ? super FocusEnterExitScope, Unit> r102) {
        FocusProperties r103 = fetchFocusProperties$ui_release();
        CancelIndicatingFocusBoundaryScope r104 = new CancelIndicatingFocusBoundaryScope(r100, null);
        FocusOwner r105 = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode r106 = r105.getActiveFocusTargetNode();
        r102.invoke(r103, r104);
        FocusTargetNode r107 = r105.getActiveFocusTargetNode();
        if (r104.isCanceled() == false) goto L5;
        r101.invoke(FocusRequester.Companion.getCancel());
        return;
    L5:
        if (r106 == r107) goto L10;
        if (r107 == null) goto L11;
        r101.invoke(FocusRequester.Companion.getRedirect$ui_release());
        return;
    L11:
        return;
    }

    public /* synthetic */ FocusTargetNode(int r100, Function2 r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = Focusability.Companion.m4516getAlwaysLCbbffg();
    L5:
        DefaultConstructorMarker r105 = null;
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, r105);
    }
}
