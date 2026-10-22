package androidx.compose.ui.semantics;

import android.graphics.Region;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.unit.IntRect;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/semantics/SemanticRegionImpl;", "Landroidx/compose/ui/semantics/SemanticsRegion;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/unit/IntRect;", "rect", "LC7/r;", "set", "(Landroidx/compose/ui/unit/IntRect;)V", "region", "", "intersect", "(Landroidx/compose/ui/semantics/SemanticsRegion;)Z", "difference", "(Landroidx/compose/ui/unit/IntRect;)Z", "Landroid/graphics/Region;", "Landroid/graphics/Region;", "getRegion", "()Landroid/graphics/Region;", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "bounds", "isEmpty", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class SemanticRegionImpl implements SemanticsRegion {
    private final Region region = new Region();

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean difference(IntRect rect) {
        return this.region.op(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), Region.Op.DIFFERENCE);
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public IntRect getBounds() {
        return RectHelper_androidKt.toComposeIntRect(this.region.getBounds());
    }

    public final Region getRegion() {
        return this.region;
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean intersect(SemanticsRegion region) {
        Region region2 = this.region;
        k.d(region, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticRegionImpl");
        return region2.op(((SemanticRegionImpl) region).region, Region.Op.INTERSECT);
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean isEmpty() {
        return this.region.isEmpty();
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public void set(IntRect rect) {
        this.region.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }
}
