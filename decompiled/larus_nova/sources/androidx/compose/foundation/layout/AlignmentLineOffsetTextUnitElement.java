package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\f\u0010\u001e\u001a\u00020\u000b*\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\"\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-XSAIIZE", "()J", "J", "getAfter-XSAIIZE", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "update", "node", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AlignmentLineOffsetTextUnitElement extends ModifierNodeElement<AlignmentLineOffsetTextUnitNode> {
    private final long after;
    private final AlignmentLine alignmentLine;
    private final long before;
    private final Function1<InspectorInfo, Unit> inspectorInfo;

    public /* synthetic */ AlignmentLineOffsetTextUnitElement(AlignmentLine r100, long r101, long r102, Function1 r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public AlignmentLineOffsetTextUnitNode create() {
        return new AlignmentLineOffsetTextUnitNode(this.alignmentLine, this.before, this.after, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + TextUnit.m7743hashCodeimpl(this.before)) * 31) + TextUnit.m7743hashCodeimpl(this.after);
    }

    /* JADX INFO: renamed from: getAfter-XSAIIZE, reason: not valid java name */
    public final long m595getAfterXSAIIZE() {
        return this.after;
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* JADX INFO: renamed from: getBefore-XSAIIZE, reason: not valid java name */
    public final long m596getBeforeXSAIIZE() {
        return this.before;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
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
        if ((r100 instanceof AlignmentLineOffsetTextUnitElement) == false) goto L8;
        AlignmentLineOffsetTextUnitElement r101 = (AlignmentLineOffsetTextUnitElement) r100;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.alignmentLine, r101.alignmentLine) == true) goto L15;
    L19:
        return false;
    L15:
        if (TextUnit.m7739equalsimpl0(this.before, r101.before) == false) goto L19;
        if (TextUnit.m7739equalsimpl0(this.after, r101.after) == false) goto L19;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        this.inspectorInfo.invoke(r100);
    }

    public void update(AlignmentLineOffsetTextUnitNode r100) {
        r100.setAlignmentLine(this.alignmentLine);
        r100.m600setBeforeR2X_6o(this.before);
        r100.m599setAfterR2X_6o(this.after);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((AlignmentLineOffsetTextUnitNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlignmentLineOffsetTextUnitElement(AlignmentLine r100, long r101, long r102, Function1<? super InspectorInfo, Unit> r103) {
        this.alignmentLine = r100;
        this.before = r101;
        this.after = r102;
        this.inspectorInfo = r103;
    }
}
