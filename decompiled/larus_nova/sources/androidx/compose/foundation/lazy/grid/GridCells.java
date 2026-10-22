package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", "", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "Fixed", "Adaptive", "FixedSize", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GridCells {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Adaptive implements GridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public int hashCode() {
            return Dp.m7550hashCodeimpl(this.minSize);
        }

        private Adaptive(float r100) {
            this.minSize = r100;
            boolean r101 = false;
            if (Dp.m7543compareTo0680j_4(r100, Dp.m7544constructorimpl(0)) <= 0) goto L5;
            r101 = true;
        L5:
            if (r101 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Provided min size should be larger than zero.");
            return;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Adaptive) == true) goto L5;
        L7:
            return false;
        L5:
            if (Dp.m7549equalsimpl0(this.minSize, ((Adaptive) r100).minSize) == false) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r100, int r101, int r102) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(r101, Math.max((r101 + r102) / (r100.mo365roundToPx0680j_4(this.minSize) + r102), 1), r102);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Fixed;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "count", "", "<init>", "(I)V", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Fixed implements GridCells {
        public static final int $stable = 0;
        private final int count;

        public int hashCode() {
            return -this.count;
        }

        public Fixed(int r100) {
            this.count = r100;
            if (r100 <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("Provided count should be larger than zero");
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Fixed) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.count != ((Fixed) r100).count) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r100, int r101, int r102) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(r101, this.count, r102);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$FixedSize;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FixedSize implements GridCells {
        public static final int $stable = 0;
        private final float size;

        public /* synthetic */ FixedSize(float r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public int hashCode() {
            return Dp.m7550hashCodeimpl(this.size);
        }

        private FixedSize(float r100) {
            this.size = r100;
            boolean r101 = false;
            if (Dp.m7543compareTo0680j_4(r100, Dp.m7544constructorimpl(0)) <= 0) goto L5;
            r101 = true;
        L5:
            if (r101 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Provided size should be larger than zero.");
            return;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof FixedSize) == true) goto L5;
        L7:
            return false;
        L5:
            if (Dp.m7549equalsimpl0(this.size, ((FixedSize) r100).size) == false) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r100, int r101, int r102) {
            int r103 = r100.mo365roundToPx0680j_4(this.size);
            int r104 = r103 + r102;
            int r105 = r102 + r101;
            if (r104 >= r105) goto L7;
            int r106 = r105 / r104;
            ArrayList r107 = new ArrayList(r106);
            int r108 = 0;
        L5:
            if (r108 >= r106) goto L10;
            r107.add(Integer.valueOf(r103));
            r108 = r108 + 1;
            goto L5
        L10:
            return r107;
        L7:
            ArrayList r109 = new ArrayList(1);
            r109.add(Integer.valueOf(r101));
            return r109;
        }
    }

    List<Integer> calculateCrossAxisCellSizes(Density r100, int r101, int r102);
}
