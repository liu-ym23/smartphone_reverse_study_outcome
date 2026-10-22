package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010JU\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u0016J\f\u0010\u0017\u001a\u00020\u000e*\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/selection/ToggleableNode;", "Landroidx/compose/foundation/ClickableNode;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "<init>", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_onClick", "Lkotlin/Function0;", "get_onClick", "()Lkotlin/jvm/functions/Function0;", "update", "update-O2vRcR0", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ToggleableNode extends ClickableNode {
    private final Function0<Unit> _onClick;
    private Function1<? super Boolean, Unit> onValueChange;
    private boolean value;

    public /* synthetic */ ToggleableNode(boolean r100, MutableInteractionSource r101, IndicationNodeFactory r102, boolean r103, boolean r104, Role r105, Function1 r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ Unit c(ToggleableNode r100) {
        return _onClick$lambda$1(r100);
    }

    public static /* synthetic */ Unit d(Function1 r100, boolean r101) {
        return _init_$lambda$0(r100, r101);
    }

    public final Function0<Unit> get_onClick() {
        return this._onClick;
    }

    private static final Unit _onClick$lambda$1(ToggleableNode r100) {
        r100.onValueChange.invoke(Boolean.valueOf(!r100.value));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver r100) {
        SemanticsPropertiesKt.setToggleableState(r100, ToggleableStateKt.ToggleableState(this.value));
    }

    private static final Unit _init_$lambda$0(Function1 r100, boolean r101) {
        r100.invoke(Boolean.valueOf(!r101));
        return Unit.INSTANCE;
    }

    private ToggleableNode(final boolean r110, MutableInteractionSource r111, IndicationNodeFactory r112, boolean r113, boolean r114, Role r115, final Function1<? super Boolean, Unit> r116) {
        super(r111, r112, r113, r114, null, r115, new b(r116, r110), null);
        this.value = r110;
        this.onValueChange = r116;
        this._onClick = new c(this);
    }

    /* JADX INFO: renamed from: update-O2vRcR0, reason: not valid java name */
    public final void m1007updateO2vRcR0(boolean r110, MutableInteractionSource r111, IndicationNodeFactory r112, boolean r113, boolean r114, Role r115, Function1<? super Boolean, Unit> r116) {
        if (this.value == r110) goto L5;
        this.value = r110;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L5:
        this.onValueChange = r116;
        super.m282updateO2vRcR0(r111, r112, r113, r114, null, r115, this._onClick);
    }
}
