package androidx.compose.ui.semantics;

import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsRegion;", "", "Landroidx/compose/ui/unit/IntRect;", "rect", "LC7/r;", "set", "(Landroidx/compose/ui/unit/IntRect;)V", "region", "", "intersect", "(Landroidx/compose/ui/semantics/SemanticsRegion;)Z", "difference", "(Landroidx/compose/ui/unit/IntRect;)Z", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "bounds", "isEmpty", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SemanticsRegion {
    boolean difference(IntRect rect);

    IntRect getBounds();

    boolean intersect(SemanticsRegion region);

    boolean isEmpty();

    void set(IntRect rect);
}
