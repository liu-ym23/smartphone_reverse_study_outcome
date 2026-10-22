package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u000f*\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/selection/SelectableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/SelectableNode;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "", "<init>", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SelectableElement extends ModifierNodeElement<SelectableNode> {
    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final Role role;
    private final boolean selected;
    private final boolean useLocalIndication;

    public /* synthetic */ SelectableElement(boolean r100, MutableInteractionSource r101, IndicationNodeFactory r102, boolean r103, boolean r104, Role r105, Function0 r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SelectableNode create() {
        return new SelectableNode(this.selected, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = 1231;
        if (this.selected == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        MutableInteractionSource r103 = this.interactionSource;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = (r102 + r105) * 31;
        IndicationNodeFactory r107 = this.indicationNodeFactory;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.useLocalIndication == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.enabled == true) goto L22;
        r100 = 1237;
    L22:
        int r112 = (r111 + r100) * 31;
        Role r113 = this.role;
        if (r113 == null) goto L26;
        r104 = Role.m6766hashCodeimpl(r113.m6768unboximpl());
    L26:
        return ((r112 + r104) * 31) + this.onClick.hashCode();
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = 1237;
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
        if (SelectableElement.class == r100.getClass()) goto L11;
        return false;
    L11:
        SelectableElement r101 = (SelectableElement) r100;
        if (this.selected == r101.selected) goto L15;
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
        r100.setName("selectable");
        r100.getProperties().set("selected", Boolean.valueOf(this.selected));
        r100.getProperties().set("interactionSource", this.interactionSource);
        r100.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        r100.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r100.getProperties().set("role", this.role);
        r100.getProperties().set(SendEventContainerMethodParamModel.EventKinds.onClick, this.onClick);
    }

    public void update(SelectableNode r100) {
        r100.m994updateO2vRcR0(this.selected, this.interactionSource, this.indicationNodeFactory, this.useLocalIndication, this.enabled, this.role, this.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((SelectableNode) r100);
    }

    private SelectableElement(boolean r100, MutableInteractionSource r101, IndicationNodeFactory r102, boolean r103, boolean r104, Role r105, Function0<Unit> r106) {
        this.selected = r100;
        this.interactionSource = r101;
        this.indicationNodeFactory = r102;
        this.useLocalIndication = r103;
        this.enabled = r104;
        this.role = r105;
        this.onClick = r106;
    }
}
