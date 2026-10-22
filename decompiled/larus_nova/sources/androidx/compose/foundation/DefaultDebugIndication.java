package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/IndicationNodeFactory;", "<init>", "()V", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "hashCode", "", "equals", "", "other", "", "DefaultDebugIndicationInstance", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultDebugIndication implements IndicationNodeFactory {
    public static final DefaultDebugIndication INSTANCE = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\u00020\f*\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "", "isHovered", "isFocused", "onAttach", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {
        private final InteractionSource interactionSource;
        private boolean isFocused;
        private boolean isHovered;
        private boolean isPressed;

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final /* synthetic */ void onMeasureResultChanged() {
            DrawModifierNode.CC.$default$onMeasureResultChanged(this);
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            BuildersKt.launch$default(getCoroutineScope(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }

        public DefaultDebugIndicationInstance(InteractionSource r100) {
            this.interactionSource = r100;
        }

        public static final /* synthetic */ InteractionSource access$getInteractionSource$p(DefaultDebugIndicationInstance r100) {
            return r100.interactionSource;
        }

        public static final /* synthetic */ boolean access$isFocused$p(DefaultDebugIndicationInstance r100) {
            return r100.isFocused;
        }

        public static final /* synthetic */ boolean access$isHovered$p(DefaultDebugIndicationInstance r100) {
            return r100.isHovered;
        }

        public static final /* synthetic */ boolean access$isPressed$p(DefaultDebugIndicationInstance r100) {
            return r100.isPressed;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope r210) {
            r210.drawContent();
            if (this.isPressed == false) goto L6;
            DrawScope.CC.m5407drawRectnJ9OG0$default(r210, Color.m4826copywmQWz5c$default(Color.Companion.m4853getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0, r210.mo5322getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            return;
        L6:
            if (this.isHovered == false) goto L8;
        L9:
            DrawScope.CC.m5407drawRectnJ9OG0$default(r210, Color.m4826copywmQWz5c$default(Color.Companion.m4853getBlack0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0, r210.mo5322getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            return;
        L8:
            if (this.isFocused == true) goto L9;
        }

        public static final /* synthetic */ void access$setFocused$p(DefaultDebugIndicationInstance r100, boolean r101) {
            r100.isFocused = r101;
        }

        public static final /* synthetic */ void access$setHovered$p(DefaultDebugIndicationInstance r100, boolean r101) {
            r100.isHovered = r101;
        }

        public static final /* synthetic */ void access$setPressed$p(DefaultDebugIndicationInstance r100, boolean r101) {
            r100.isPressed = r101;
        }
    }

    static {
        INSTANCE = new DefaultDebugIndication();
    }

    private DefaultDebugIndication() {
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object r100) {
        if (r100 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        return -1;
    }

    @Override // androidx.compose.foundation.Indication
    public final /* synthetic */ IndicationInstance rememberUpdatedInstance(InteractionSource r100, Composer r101, int r102) {
        return Indication.CC.$default$rememberUpdatedInstance(this, r100, r101, r102);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource r100) {
        return new DefaultDebugIndicationInstance(r100);
    }
}
