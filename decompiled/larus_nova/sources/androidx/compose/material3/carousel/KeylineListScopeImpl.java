package androidx.compose.material3.carousel;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007J%\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0005H\u0002JT\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J \u0010#\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "<init>", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createWithPivot", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "findLastFocalIndex", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "isCutoffLeft", "offset", "isCutoffRight", "TmpKeyline", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class KeylineListScopeImpl implements KeylineListScope {
    private int firstFocalIndex;
    private float focalItemSize;
    private int pivotIndex;
    private float pivotOffset;
    private final List<TmpKeyline> tmpKeylines;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "<init>", "(FZ)V", "getSize", "()F", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TmpKeyline {
        private final boolean isAnchor;
        private final float size;

        public static /* synthetic */ TmpKeyline copy$default(TmpKeyline r100, float r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.size;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.isAnchor;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final TmpKeyline copy(float r100, boolean r101) {
            return new TmpKeyline(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TmpKeyline) == true) goto L8;
            return false;
        L8:
            TmpKeyline r101 = (TmpKeyline) r100;
            if (Float.compare(this.size, r101.size) == 0) goto L12;
            return false;
        L12:
            if (this.isAnchor == r101.isAnchor) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = Float.floatToIntBits(this.size) * 31;
            if (this.isAnchor == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ')';
        }

        public final float getSize() {
            return this.size;
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }

        public TmpKeyline(float r100, boolean r101) {
            this.size = r100;
            this.isAnchor = r101;
        }
    }

    private final boolean isCutoffLeft(float r100, float r101) {
        float r102 = r100 / 2;
        if ((r101 - r102) < 0.0f) goto L5;
    L7:
        return false;
    L5:
        if ((r101 + r102) <= 0.0f) goto L7;
        return true;
    }

    private final boolean isCutoffRight(float r100, float r101, float r102) {
        float r103 = r100 / 2;
        if ((r101 - r103) < r102) goto L5;
    L7:
        return false;
    L5:
        if ((r101 + r103) <= r102) goto L7;
        return true;
    }

    private final int findLastFocalIndex() {
        int r100 = this.firstFocalIndex;
    L4:
        if (r100 >= CollectionsKt.getLastIndex(this.tmpKeylines)) goto L11;
        int r101 = r100 + 1;
        if (((TmpKeyline) ListProtector.get(this.tmpKeylines, r101)).getSize() != this.focalItemSize) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        r100 = r101;
        goto L4
    L8:
        r102 = false;
    L11:
        return r100;
    }

    public KeylineListScopeImpl() {
        this.firstFocalIndex = -1;
        this.pivotIndex = -1;
        this.tmpKeylines = new ArrayList();
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void add(float r100, boolean r101) {
        this.tmpKeylines.add(new TmpKeyline(r100, r101));
        if (r100 <= this.focalItemSize) goto L6;
        this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
        this.focalItemSize = r100;
        return;
    }

    /* JADX INFO: renamed from: createWithAlignment-waks0t8, reason: not valid java name */
    public final KeylineList m3120createWithAlignmentwaks0t8(float r110, float r111, int r112) {
        int r100 = findLastFocalIndex();
        int r101 = this.firstFocalIndex;
        int r102 = r100 - r101;
        this.pivotIndex = r101;
        CarouselAlignment.Companion r103 = CarouselAlignment.Companion;
        if (CarouselAlignment.m3099equalsimpl0(r112, r103.m3103getCenterNUL3oTo()) == false) goto L15;
        float r113 = 0.0f;
        if (r111 != 0.0f) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L13;
        int r105 = r102 % 2;
        if ((r105 + ((((r105 ^ 2) & ((-r105) | r105)) >> 31) & 2)) == 0) goto L13;
        r113 = r111 / 2.0f;
    L13:
        float r106 = 2;
        float r107 = ((r110 / r106) - ((this.focalItemSize / r106) * r102)) - r113;
    L19:
        this.pivotOffset = r107;
        return new KeylineList(createKeylinesWithPivot(this.pivotIndex, r107, this.firstFocalIndex, r100, this.focalItemSize, r110, r111, this.tmpKeylines));
    L7:
        r104 = false;
        goto L8
    L15:
        if (CarouselAlignment.m3099equalsimpl0(r112, r103.m3104getEndNUL3oTo()) == false) goto L17;
        float r114 = r110 - (this.focalItemSize / 2);
    L18:
        r107 = r114;
        goto L19
    L17:
        r114 = this.focalItemSize / 2;
        goto L18
    }

    public final KeylineList createWithPivot(float r110, float r111, int r112, float r113) {
        return new KeylineList(createKeylinesWithPivot(r112, r113, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, r110, r111, this.tmpKeylines));
    }

    private final List<Keyline> createKeylinesWithPivot(int r210, float r310, int r311, int r312, float r313, float r314, float r315, List<TmpKeyline> r316) {
        TmpKeyline r100 = (TmpKeyline) ListProtector.get(r316, r210);
        ArrayList r110 = new ArrayList();
        if (isCutoffLeft(r100.getSize(), r310) == false) goto L7;
        float r101 = r310 - (r100.getSize() / 2);
    L5:
        float r111 = r101;
    L10:
        float r102 = r100.getSize();
        if (r311 > r210) goto L14;
        if (r210 > r312) goto L14;
        boolean r103 = true;
    L15:
        r110.add(new Keyline(r102, r310, r310, r103, r100.isAnchor(), true, r111));
        float r104 = 2;
        float r105 = r313 / r104;
        float r106 = (r310 - r105) - r315;
        Iterator<Integer> r107 = RangesKt.downTo(r210 - 1, 0).iterator();
        float r108 = r106;
    L17:
        if (r107.hasNext() == false) goto L28;
        int r109 = ((IntIterator) r107).nextInt();
        TmpKeyline r112 = (TmpKeyline) ListProtector.get(r316, r109);
        float r113 = r106 - (r112.getSize() / r104);
        float r211 = r108 - r105;
        if (isCutoffLeft(r112.getSize(), r113) == false) goto L21;
        float r212 = Math.abs(r113 - (r112.getSize() / r104));
    L22:
        float r213 = r112.getSize();
        if (r311 > r109) goto L26;
        if (r109 > r312) goto L26;
        boolean r214 = true;
    L27:
        ListProtector.add(r110, 0, new Keyline(r213, r113, r211, r214, r112.isAnchor(), false, r212));
        r106 = r106 - (r112.getSize() + r315);
        r108 = r108 - (r313 + r315);
    L26:
        r214 = false;
        goto L27
    L21:
        r212 = 0.0f;
        goto L22
    L28:
        float r114 = (r310 + r105) + r315;
        Iterator<Integer> r115 = RangesKt.until(r210 + 1, r316.size()).iterator();
        float r116 = r114;
    L30:
        if (r115.hasNext() == false) goto L41;
        int r117 = ((IntIterator) r115).nextInt();
        TmpKeyline r118 = (TmpKeyline) ListProtector.get(r316, r117);
        float r119 = (r118.getSize() / r104) + r114;
        float r215 = r116 + r105;
        if (isCutoffRight(r118.getSize(), r119, r314) == false) goto L34;
        float r216 = ((r118.getSize() / r104) + r119) - r314;
    L35:
        float r217 = r118.getSize();
        if (r311 > r117) goto L39;
        if (r117 > r312) goto L39;
        boolean r218 = true;
    L40:
        r110.add(new Keyline(r217, r119, r215, r218, r118.isAnchor(), false, r216));
        r114 = r114 + (r118.getSize() + r315);
        r116 = r116 + (r313 + r315);
    L39:
        r218 = false;
        goto L40
    L34:
        r216 = 0.0f;
        goto L35
    L41:
        return r110;
    L14:
        r103 = false;
        goto L15
    L7:
        if (isCutoffRight(r100.getSize(), r310, r314) == false) goto L9;
        r101 = ((r100.getSize() / 2) + r310) - r314;
        goto L5
    L9:
        r111 = 0.0f;
        goto L10
    }
}
