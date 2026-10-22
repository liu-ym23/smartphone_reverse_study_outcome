package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0010*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/selection/TriStateToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/TriStateToggleableNode;", "state", "Landroidx/compose/ui/state/ToggleableState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TriStateToggleableElement extends ModifierNodeElement<TriStateToggleableNode> {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final Role role;
    private final ToggleableState state;
    private final boolean useLocalIndication;

    public /* synthetic */ TriStateToggleableElement(ToggleableState r100, MutableInteractionSource r101, IndicationNodeFactory r102, boolean r103, boolean r104, Role r105, Function0 r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public TriStateToggleableNode create() {
        return new TriStateToggleableNode(this.state, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = this.state.hashCode() * 31;
        MutableInteractionSource r101 = this.interactionSource;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        IndicationNodeFactory r105 = this.indicationNodeFactory;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        int r108 = 1231;
        if (this.useLocalIndication == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.enabled == true) goto L18;
        r108 = 1237;
    L18:
        int r111 = (r110 + r108) * 31;
        Role r112 = this.role;
        if (r112 == null) goto L22;
        r102 = Role.m6766hashCodeimpl(r112.m6768unboximpl());
    L22:
        return ((r111 + r102) * 31) + this.onClick.hashCode();
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (TriStateToggleableElement.class == r100.getClass()) goto L11;
        return false;
    L11:
        TriStateToggleableElement r101 = (TriStateToggleableElement) r100;
        if (this.state == r101.state) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactionSource, r101.interactionSource) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.indicationNodeFactory, r101.indicationNodeFactory) == true) goto L21;
        return false;
    L21:
        if (this.useLocalIndication == r101.useLocalIndication) goto L24;
        return false;
    L24:
        if (this.enabled == r101.enabled) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.role, r101.role) == true) goto L30;
        return false;
    L30:
        if (this.onClick == r101.onClick) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("triStateToggleable");
        r100.getProperties().set("state", this.state);
        r100.getProperties().set("interactionSource", this.interactionSource);
        r100.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        r100.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r100.getProperties().set("role", this.role);
        r100.getProperties().set(SendEventContainerMethodParamModel.EventKinds.onClick, this.onClick);
    }

    public void update(TriStateToggleableNode r100) {
        r100.m1008updateO2vRcR0(this.state, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((TriStateToggleableNode) r100);
    }

    private TriStateToggleableElement(ToggleableState r100, MutableInteractionSource r101, IndicationNodeFactory r102, boolean r103, boolean r104, Role r105, Function0<Unit> r106) {
        this.state = r100;
        this.interactionSource = r101;
        this.indicationNodeFactory = r102;
        this.useLocalIndication = r103;
        this.enabled = r104;
        this.role = r105;
        this.onClick = r106;
    }
}
