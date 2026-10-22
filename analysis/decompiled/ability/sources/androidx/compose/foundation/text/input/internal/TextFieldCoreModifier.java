package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0006HÂ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\bHÂ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\nHÂ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\fHÂ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÂ\u0003¢\u0006\u0004\b \u0010\u0016J\u0010\u0010!\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0011HÂ\u0003¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010*J\u0013\u0010,\u001a\u00020(*\u00020+H\u0016¢\u0006\u0004\b,\u0010-Jj\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00108\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010:R\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010:R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010;R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010<R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010>R\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010:R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010?R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010@¨\u0006A"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "", "isFocused", "isDragHovered", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textFieldSelectionState", "Landroidx/compose/ui/graphics/Brush;", "cursorBrush", "writeable", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", AppAgent.CONSTRUCT, "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "component1", "()Z", "component2", "component3", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "component4", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "component5", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "component6", "()Landroidx/compose/ui/graphics/Brush;", "component7", "component8", "()Landroidx/compose/foundation/ScrollState;", "component9", "()Landroidx/compose/foundation/gestures/Orientation;", "create", "()Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "node", "LC7/r;", "update", "(Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "copy", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifier;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TextFieldCoreModifier extends ModifierNodeElement<TextFieldCoreModifierNode> {
    public static final int $stable = 0;
    private final Brush cursorBrush;
    private final boolean isDragHovered;
    private final boolean isFocused;
    private final Orientation orientation;
    private final ScrollState scrollState;
    private final TextFieldSelectionState textFieldSelectionState;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private final boolean writeable;

    public TextFieldCoreModifier(boolean z10, boolean z11, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z12, ScrollState scrollState, Orientation orientation) {
        this.isFocused = z10;
        this.isDragHovered = z11;
        this.textLayoutState = textLayoutState;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.cursorBrush = brush;
        this.writeable = z12;
        this.scrollState = scrollState;
        this.orientation = orientation;
    }

    /* renamed from: component1, reason: from getter */
    private final boolean getIsFocused() {
        return this.isFocused;
    }

    /* renamed from: component2, reason: from getter */
    private final boolean getIsDragHovered() {
        return this.isDragHovered;
    }

    /* renamed from: component3, reason: from getter */
    private final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    /* renamed from: component4, reason: from getter */
    private final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    /* renamed from: component5, reason: from getter */
    private final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    /* renamed from: component6, reason: from getter */
    private final Brush getCursorBrush() {
        return this.cursorBrush;
    }

    /* renamed from: component7, reason: from getter */
    private final boolean getWriteable() {
        return this.writeable;
    }

    /* renamed from: component8, reason: from getter */
    private final ScrollState getScrollState() {
        return this.scrollState;
    }

    /* renamed from: component9, reason: from getter */
    private final Orientation getOrientation() {
        return this.orientation;
    }

    public static /* synthetic */ TextFieldCoreModifier copy$default(TextFieldCoreModifier textFieldCoreModifier, boolean z10, boolean z11, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z12, ScrollState scrollState, Orientation orientation, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = textFieldCoreModifier.isFocused;
        }
        if ((i & 2) != 0) {
            z11 = textFieldCoreModifier.isDragHovered;
        }
        if ((i & 4) != 0) {
            textLayoutState = textFieldCoreModifier.textLayoutState;
        }
        if ((i & 8) != 0) {
            transformedTextFieldState = textFieldCoreModifier.textFieldState;
        }
        if ((i & 16) != 0) {
            textFieldSelectionState = textFieldCoreModifier.textFieldSelectionState;
        }
        if ((i & 32) != 0) {
            brush = textFieldCoreModifier.cursorBrush;
        }
        if ((i & 64) != 0) {
            z12 = textFieldCoreModifier.writeable;
        }
        if ((i & 128) != 0) {
            scrollState = textFieldCoreModifier.scrollState;
        }
        if ((i & 256) != 0) {
            orientation = textFieldCoreModifier.orientation;
        }
        ScrollState scrollState2 = scrollState;
        Orientation orientation2 = orientation;
        Brush brush2 = brush;
        boolean z13 = z12;
        TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
        TextLayoutState textLayoutState2 = textLayoutState;
        return textFieldCoreModifier.copy(z10, z11, textLayoutState2, transformedTextFieldState, textFieldSelectionState2, brush2, z13, scrollState2, orientation2);
    }

    public final TextFieldCoreModifier copy(boolean isFocused, boolean isDragHovered, TextLayoutState textLayoutState, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, Brush cursorBrush, boolean writeable, ScrollState scrollState, Orientation orientation) {
        return new TextFieldCoreModifier(isFocused, isDragHovered, textLayoutState, textFieldState, textFieldSelectionState, cursorBrush, writeable, scrollState, orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldCoreModifier)) {
            return false;
        }
        TextFieldCoreModifier textFieldCoreModifier = (TextFieldCoreModifier) other;
        return this.isFocused == textFieldCoreModifier.isFocused && this.isDragHovered == textFieldCoreModifier.isDragHovered && k.b(this.textLayoutState, textFieldCoreModifier.textLayoutState) && k.b(this.textFieldState, textFieldCoreModifier.textFieldState) && k.b(this.textFieldSelectionState, textFieldCoreModifier.textFieldSelectionState) && k.b(this.cursorBrush, textFieldCoreModifier.cursorBrush) && this.writeable == textFieldCoreModifier.writeable && k.b(this.scrollState, textFieldCoreModifier.scrollState) && this.orientation == textFieldCoreModifier.orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.orientation.hashCode() + ((this.scrollState.hashCode() + androidx.appfunctions.metadata.a.d((this.cursorBrush.hashCode() + ((this.textFieldSelectionState.hashCode() + ((this.textFieldState.hashCode() + ((this.textLayoutState.hashCode() + androidx.appfunctions.metadata.a.d(Boolean.hashCode(this.isFocused) * 31, 31, this.isDragHovered)) * 31)) * 31)) * 31)) * 31, 31, this.writeable)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.isFocused + ", isDragHovered=" + this.isDragHovered + ", textLayoutState=" + this.textLayoutState + ", textFieldState=" + this.textFieldState + ", textFieldSelectionState=" + this.textFieldSelectionState + ", cursorBrush=" + this.cursorBrush + ", writeable=" + this.writeable + ", scrollState=" + this.scrollState + ", orientation=" + this.orientation + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public TextFieldCoreModifierNode getNode() {
        return new TextFieldCoreModifierNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(TextFieldCoreModifierNode node) {
        node.updateNode(this.isFocused, this.isDragHovered, this.textLayoutState, this.textFieldState, this.textFieldSelectionState, this.cursorBrush, this.writeable, this.scrollState, this.orientation);
    }
}
