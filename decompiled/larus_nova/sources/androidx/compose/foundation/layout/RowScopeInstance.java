package androidx.compose.foundation.layout;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0014\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0017J\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0005H\u0017J \u0010\f\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/RowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "<init>", "()V", "weight", "Landroidx/compose/ui/Modifier;", "", LynxVideoManagerLite.FILL, "", "align", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RowScopeInstance implements RowScope {
    public static final int $stable = 0;
    public static final RowScopeInstance INSTANCE = null;

    static {
        INSTANCE = new RowScopeInstance();
    }

    private RowScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier r100) {
        return alignBy(r100, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier r100, Alignment.Vertical r101) {
        return r100.then(new VerticalAlignElement(r101));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier r100, HorizontalAlignmentLine r101) {
        return r100.then(new WithAlignmentLineElement(r101));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier r100, Function1<? super Measured, Integer> r101) {
        return r100.then(new WithAlignmentLineBlockElement(r101));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier r100, float r101, boolean r102) {
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
    L9:
        return r100.then(new LayoutWeightElement(RangesKt.coerceAtMost(r101, Float.MAX_VALUE), r102));
    L5:
        r103 = false;
        goto L6
    }
}
