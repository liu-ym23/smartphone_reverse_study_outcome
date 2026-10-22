package androidx.compose.ui.draw;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0015¨\u0006'"}, d2 = {"Landroidx/compose/ui/draw/SimpleInnerShadowElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/SimpleInnerShadowNode;", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)V", "create", "()Landroidx/compose/ui/draw/SimpleInnerShadowNode;", "node", "LC7/r;", "update", "(Landroidx/compose/ui/draw/SimpleInnerShadowNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()Landroidx/compose/ui/graphics/Shape;", "component2", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "copy", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/shadow/Shadow;)Landroidx/compose/ui/draw/SimpleInnerShadowElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/Shape;", "getShape", "Landroidx/compose/ui/graphics/shadow/Shadow;", "getShadow", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SimpleInnerShadowElement extends ModifierNodeElement<SimpleInnerShadowNode> {
    public static final int $stable = 0;
    private final Shadow shadow;
    private final Shape shape;

    public SimpleInnerShadowElement(Shape shape, Shadow shadow) {
        this.shape = shape;
        this.shadow = shadow;
    }

    public static /* synthetic */ SimpleInnerShadowElement copy$default(SimpleInnerShadowElement simpleInnerShadowElement, Shape shape, Shadow shadow, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = simpleInnerShadowElement.shape;
        }
        if ((i & 2) != 0) {
            shadow = simpleInnerShadowElement.shadow;
        }
        return simpleInnerShadowElement.copy(shape, shadow);
    }

    /* renamed from: component1, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: component2, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    public final SimpleInnerShadowElement copy(Shape shape, Shadow shadow) {
        return new SimpleInnerShadowElement(shape, shadow);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleInnerShadowElement)) {
            return false;
        }
        SimpleInnerShadowElement simpleInnerShadowElement = (SimpleInnerShadowElement) other;
        return k.b(this.shape, simpleInnerShadowElement.shape) && k.b(this.shadow, simpleInnerShadowElement.shadow);
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.shadow.hashCode() + (this.shape.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("innerShadow");
        inspectorInfo.getProperties().set("shape", this.shape);
        inspectorInfo.getProperties().set("innerShadow", this.shadow);
    }

    public String toString() {
        return "SimpleInnerShadowElement(shape=" + this.shape + ", shadow=" + this.shadow + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SimpleInnerShadowNode getNode() {
        return new SimpleInnerShadowNode(this.shape, this.shadow);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SimpleInnerShadowNode node) {
        node.update(this.shape, this.shadow);
    }
}
