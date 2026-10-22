package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J%\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SkipToLookaheadNode;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "()Lkotlin/jvm/functions/Function0;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SkipToLookaheadElement extends ModifierNodeElement<SkipToLookaheadNode> {
    public static final int $stable = 0;
    private final Function0<Boolean> isEnabled;
    private final ScaleToBoundsImpl scaleToBounds;

    /* JADX WARN: Multi-variable type inference failed */
    public SkipToLookaheadElement() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkipToLookaheadElement copy$default(SkipToLookaheadElement r100, ScaleToBoundsImpl r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.scaleToBounds;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isEnabled;
    L9:
        return r100.copy(r101, r102);
    }

    public final ScaleToBoundsImpl component1() {
        return this.scaleToBounds;
    }

    public final Function0<Boolean> component2() {
        return this.isEnabled;
    }

    public final SkipToLookaheadElement copy(ScaleToBoundsImpl r100, Function0<Boolean> r101) {
        return new SkipToLookaheadElement(r100, r101);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SkipToLookaheadElement) == true) goto L8;
        return false;
    L8:
        SkipToLookaheadElement r101 = (SkipToLookaheadElement) r100;
        if (Intrinsics.areEqual(this.scaleToBounds, r101.scaleToBounds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isEnabled, r101.isEnabled) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        ScaleToBoundsImpl r100 = this.scaleToBounds;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.isEnabled.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "SkipToLookaheadElement(scaleToBounds=" + this.scaleToBounds + ", isEnabled=" + this.isEnabled + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SkipToLookaheadNode create() {
        return new SkipToLookaheadNode(this.scaleToBounds, this.isEnabled);
    }

    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("skipToLookahead");
        r100.getProperties().set("scaleToBounds", this.scaleToBounds);
        r100.getProperties().set("isEnabled", this.isEnabled);
    }

    public void update(SkipToLookaheadNode r100) {
        r100.setScaleToBounds(this.scaleToBounds);
        r100.setEnabled(this.isEnabled);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((SkipToLookaheadNode) r100);
    }

    public SkipToLookaheadElement(ScaleToBoundsImpl r100, Function0<Boolean> r101) {
        this.scaleToBounds = r100;
        this.isEnabled = r101;
    }

    public /* synthetic */ SkipToLookaheadElement(ScaleToBoundsImpl r100, Function0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = SkipToLookaheadNodeKt.access$getDefaultEnabled$p();
    L8:
        this(r100, r101);
    }
}
