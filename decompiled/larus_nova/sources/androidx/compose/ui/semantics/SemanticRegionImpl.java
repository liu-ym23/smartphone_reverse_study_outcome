package androidx.compose.ui.semantics;

import android.graphics.Region;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.unit.IntRect;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/semantics/SemanticRegionImpl;", "Landroidx/compose/ui/semantics/SemanticsRegion;", "<init>", "()V", EffectConfiguration.KEY_REGION, "Landroid/graphics/Region;", "getRegion", "()Landroid/graphics/Region;", "set", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/unit/IntRect;", "bounds", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "isEmpty", "", "()Z", "intersect", "difference", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SemanticRegionImpl implements SemanticsRegion {
    private final Region region;

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public IntRect getBounds() {
        return RectHelper_androidKt.toComposeIntRect(this.region.getBounds());
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean isEmpty() {
        return this.region.isEmpty();
    }

    public SemanticRegionImpl() {
        this.region = new Region();
    }

    public final Region getRegion() {
        return this.region;
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean difference(IntRect r100) {
        return this.region.op(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom(), Region.Op.DIFFERENCE);
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public boolean intersect(SemanticsRegion r100) {
        Region r101 = this.region;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticRegionImpl");
        return r101.op(((SemanticRegionImpl) r100).region, Region.Op.INTERSECT);
    }

    @Override // androidx.compose.ui.semantics.SemanticsRegion
    public void set(IntRect r100) {
        this.region.set(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }
}
