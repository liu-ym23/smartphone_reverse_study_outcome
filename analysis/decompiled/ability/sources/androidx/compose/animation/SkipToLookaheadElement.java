package androidx.compose.animation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\r*\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0014R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b\u0007\u0010\u0016¨\u0006&"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "scaleToBounds", "Lkotlin/Function0;", "", "isEnabled", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/ScaleToBoundsImpl;LS7/a;)V", "create", "()Landroidx/compose/animation/SkipToLookaheadNode;", "node", "LC7/r;", "update", "(Landroidx/compose/animation/SkipToLookaheadNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "component2", "()LS7/a;", "copy", "(Landroidx/compose/animation/ScaleToBoundsImpl;LS7/a;)Landroidx/compose/animation/SkipToLookaheadElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/animation/ScaleToBoundsImpl;", "getScaleToBounds", "LS7/a;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class SkipToLookaheadElement extends ModifierNodeElement<SkipToLookaheadNode> {
    private final S7.a isEnabled;
    private final ScaleToBoundsImpl scaleToBounds;

    /* JADX WARN: Multi-variable type inference failed */
    public SkipToLookaheadElement() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SkipToLookaheadElement copy$default(SkipToLookaheadElement skipToLookaheadElement, ScaleToBoundsImpl scaleToBoundsImpl, S7.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            scaleToBoundsImpl = skipToLookaheadElement.scaleToBounds;
        }
        if ((i & 2) != 0) {
            aVar = skipToLookaheadElement.isEnabled;
        }
        return skipToLookaheadElement.copy(scaleToBoundsImpl, aVar);
    }

    /* renamed from: component1, reason: from getter */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    /* renamed from: component2, reason: from getter */
    public final S7.a getIsEnabled() {
        return this.isEnabled;
    }

    public final SkipToLookaheadElement copy(ScaleToBoundsImpl scaleToBounds, S7.a isEnabled) {
        return new SkipToLookaheadElement(scaleToBounds, isEnabled);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkipToLookaheadElement)) {
            return false;
        }
        SkipToLookaheadElement skipToLookaheadElement = (SkipToLookaheadElement) other;
        return k.b(this.scaleToBounds, skipToLookaheadElement.scaleToBounds) && k.b(this.isEnabled, skipToLookaheadElement.isEnabled);
    }

    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        ScaleToBoundsImpl scaleToBoundsImpl = this.scaleToBounds;
        return this.isEnabled.hashCode() + ((scaleToBoundsImpl == null ? 0 : scaleToBoundsImpl.hashCode()) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("skipToLookahead");
        inspectorInfo.getProperties().set("scaleToBounds", this.scaleToBounds);
        inspectorInfo.getProperties().set("isEnabled", this.isEnabled);
    }

    public final S7.a isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        return "SkipToLookaheadElement(scaleToBounds=" + this.scaleToBounds + ", isEnabled=" + this.isEnabled + ')';
    }

    public /* synthetic */ SkipToLookaheadElement(ScaleToBoundsImpl scaleToBoundsImpl, S7.a aVar, int i, e eVar) {
        this((i & 1) != 0 ? null : scaleToBoundsImpl, (i & 2) != 0 ? SharedTransitionScopeKt.DefaultEnabled : aVar);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public SkipToLookaheadNode getNode() {
        return new SkipToLookaheadNode(this.scaleToBounds, this.isEnabled);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(SkipToLookaheadNode node) {
        node.setScaleToBounds(this.scaleToBounds);
        node.setEnabled(this.isEnabled);
    }

    public SkipToLookaheadElement(ScaleToBoundsImpl scaleToBoundsImpl, S7.a aVar) {
        this.scaleToBounds = scaleToBoundsImpl;
        this.isEnabled = aVar;
    }
}
