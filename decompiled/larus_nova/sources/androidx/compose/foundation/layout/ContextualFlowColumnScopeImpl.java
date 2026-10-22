package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0097\u0001J\u0015\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0097\u0001J!\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001dH\u0097\u0001J\u001f\u0010\u001f\u001a\u00020\u0013*\u00020\u00132\b\b\u0001\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0097\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowColumnScopeImpl;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "lineIndex", "", "indexInLine", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "maxHeightInLine", "<init>", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex", "()I", "getIndexInLine", "getMaxWidth-D9Ej5fM", "()F", FaceService.girlLabel, "getMaxHeightInLine-D9Ej5fM", "fillMaxColumnWidth", "Landroidx/compose/ui/Modifier;", "fraction", "", "align", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "weight", LynxVideoManagerLite.FILL, "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextualFlowColumnScopeImpl implements ColumnScope, ContextualFlowColumnScope {
    public static final int $stable = 0;
    private final /* synthetic */ ColumnScopeInstance $$delegate_0;
    private final int indexInLine;
    private final int lineIndex;
    private final float maxHeightInLine;
    private final float maxWidth;

    public /* synthetic */ ContextualFlowColumnScopeImpl(int r100, int r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier align(Modifier r100, Alignment.Horizontal r101) {
        return this.$$delegate_0.align(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier alignBy(Modifier r100, VerticalAlignmentLine r101) {
        return this.$$delegate_0.alignBy(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier alignBy(Modifier r100, Function1<? super Measured, Integer> r101) {
        return this.$$delegate_0.alignBy(r100, r101);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier weight(Modifier r100, float r101, boolean r102) {
        return this.$$delegate_0.weight(r100, r101, r102);
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowColumnScope
    public int getIndexInLine() {
        return this.indexInLine;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowColumnScope
    public int getLineIndex() {
        return this.lineIndex;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowColumnScope
    /* JADX INFO: renamed from: getMaxHeightInLine-D9Ej5fM */
    public float mo647getMaxHeightInLineD9Ej5fM() {
        return this.maxHeightInLine;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowColumnScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo648getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    @Override // androidx.compose.foundation.layout.ContextualFlowColumnScope
    public Modifier fillMaxColumnWidth(Modifier r100, float r101) {
        boolean r102 = false;
        if (0.0f <= r101) goto L5;
    L7:
        if (r102 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("invalid fraction " + r101 + "; must be >= 0 and <= 1.0");
    L10:
        return r100.then(new FillCrossAxisSizeElement(r101));
    L5:
        if (r101 > 1.0f) goto L7;
        r102 = true;
        goto L7
    }

    private ContextualFlowColumnScopeImpl(int r100, int r101, float r102, float r103) {
        this.$$delegate_0 = ColumnScopeInstance.INSTANCE;
        this.lineIndex = r100;
        this.indexInLine = r101;
        this.maxWidth = r102;
        this.maxHeightInLine = r103;
    }
}
