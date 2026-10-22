package androidx.compose.material3.carousel;

import H4.o;
import androidx.appfunctions.metadata.a;
import androidx.compose.material3.carousel.CarouselAlignment;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J[\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010!\u001a\u00020 2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J(\u0010'\u001a\u00020 2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010$\u001a\u00020#ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010*R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", AppAgent.CONSTRUCT, "()V", "", "findLastFocalIndex", "()I", "pivotIndex", "", "pivotOffset", "firstFocalIndex", "lastFocalIndex", "itemMainAxisSize", "carouselMainAxisSize", "itemSpacing", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "tmpKeylines", "Landroidx/compose/material3/carousel/Keyline;", "createKeylinesWithPivot", "(IFIIFFFLjava/util/List;)Ljava/util/List;", "size", TypedValues.CycleType.S_WAVE_OFFSET, "", "isCutoffLeft", "(FF)Z", "isCutoffRight", "(FFF)Z", "isAnchor", "LC7/r;", "add", "(FZ)V", "Landroidx/compose/material3/carousel/KeylineList;", "createWithPivot", "(FFIF)Landroidx/compose/material3/carousel/KeylineList;", "Landroidx/compose/material3/carousel/CarouselAlignment;", "carouselAlignment", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "createWithAlignment", "I", "focalItemSize", "F", "", "Ljava/util/List;", "TmpKeyline", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class KeylineListScopeImpl implements KeylineListScope {
    private float focalItemSize;
    private float pivotOffset;
    private int firstFocalIndex = -1;
    private int pivotIndex = -1;
    private final List<TmpKeyline> tmpKeylines = new ArrayList();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "(FZ)V", "()Z", "getSize", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public TmpKeyline(float f, boolean z10) {
            this.size = f;
            this.isAnchor = z10;
        }

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline tmpKeyline, float f, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                f = tmpKeyline.size;
            }
            if ((i & 2) != 0) {
                z10 = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(f, z10);
        }

        /* renamed from: component1, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAnchor() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float size, boolean isAnchor) {
            return new TmpKeyline(size, isAnchor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmpKeyline)) {
                return false;
            }
            TmpKeyline tmpKeyline = (TmpKeyline) other;
            return Float.compare(this.size, tmpKeyline.size) == 0 && this.isAnchor == tmpKeyline.isAnchor;
        }

        public final float getSize() {
            return this.size;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isAnchor) + (Float.hashCode(this.size) * 31);
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TmpKeyline(size=");
            sb.append(this.size);
            sb.append(", isAnchor=");
            return a.r(sb, this.isAnchor, ')');
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<androidx.compose.material3.carousel.Keyline> createKeylinesWithPivot(int r28, float r29, int r30, int r31, float r32, float r33, float r34, java.util.List<androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline> r35) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.KeylineListScopeImpl.createKeylinesWithPivot(int, float, int, int, float, float, float, java.util.List):java.util.List");
    }

    private final int findLastFocalIndex() {
        int i = this.firstFocalIndex;
        while (i < o.H(this.tmpKeylines)) {
            int i6 = i + 1;
            if (this.tmpKeylines.get(i6).getSize() != this.focalItemSize) {
                break;
            }
            i = i6;
        }
        return i;
    }

    private final boolean isCutoffLeft(float size, float offset) {
        float f = size / 2;
        return offset - f < 0.0f && offset + f > 0.0f;
    }

    private final boolean isCutoffRight(float size, float offset, float carouselMainAxisSize) {
        float f = size / 2;
        return offset - f < carouselMainAxisSize && offset + f > carouselMainAxisSize;
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void add(float size, boolean isAnchor) {
        this.tmpKeylines.add(new TmpKeyline(size, isAnchor));
        if (size > this.focalItemSize) {
            this.firstFocalIndex = o.H(this.tmpKeylines);
            this.focalItemSize = size;
        }
    }

    /* renamed from: createWithAlignment-waks0t8, reason: not valid java name */
    public final KeylineList m2662createWithAlignmentwaks0t8(float carouselMainAxisSize, float itemSpacing, int carouselAlignment) {
        float f;
        int iFindLastFocalIndex = findLastFocalIndex();
        int i = this.firstFocalIndex;
        int i6 = iFindLastFocalIndex - i;
        this.pivotIndex = i;
        CarouselAlignment.Companion companion = CarouselAlignment.INSTANCE;
        if (CarouselAlignment.m2646equalsimpl0(carouselAlignment, companion.m2650getCenterNUL3oTo())) {
            float f7 = 0.0f;
            if (itemSpacing != 0.0f) {
                int i10 = i6 % 2;
                if (i10 + ((((i10 ^ 2) & ((-i10) | i10)) >> 31) & 2) != 0) {
                    f7 = itemSpacing / 2.0f;
                }
            }
            float f9 = 2;
            f = ((carouselMainAxisSize / f9) - ((this.focalItemSize / f9) * i6)) - f7;
        } else {
            f = CarouselAlignment.m2646equalsimpl0(carouselAlignment, companion.m2651getEndNUL3oTo()) ? carouselMainAxisSize - (this.focalItemSize / 2) : this.focalItemSize / 2;
        }
        this.pivotOffset = f;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, f, this.firstFocalIndex, iFindLastFocalIndex, this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
    }

    public final KeylineList createWithPivot(float carouselMainAxisSize, float itemSpacing, int pivotIndex, float pivotOffset) {
        return new KeylineList(createKeylinesWithPivot(pivotIndex, pivotOffset, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
    }
}
