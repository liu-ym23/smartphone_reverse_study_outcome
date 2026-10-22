package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f4101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View[] f4102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f4103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseIntArray f4104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f4105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f4106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4107i;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4109b;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f4108a = -1;
            this.f4109b = 0;
        }

        public int a() {
            return this.f4108a;
        }

        public int b() {
            return this.f4109b;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f4108a = -1;
            this.f4109b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f4108a = -1;
            this.f4109b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f4108a = -1;
            this.f4109b = 0;
        }
    }

    public static final class a extends b {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanIndex(int r10, int r11) {
            return r10 % r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            return 1;
        }
    }

    public static abstract class b {
        private boolean mCacheSpanGroupIndices;
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanGroupIndexCache;
        final SparseIntArray mSpanIndexCache;

        public b() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        public static int findFirstKeyLessThan(SparseIntArray r10, int r11) {
            int r12 = r10.size() - 1;
            int r13 = 0;
        L3:
            if (r13 > r12) goto L8;
            int r14 = (r13 + r12) >>> 1;
            if (r10.keyAt(r14) < r11) goto L6;
            r12 = r14 - 1;
            goto L3
        L6:
            r13 = r14 + 1;
            goto L3
        L8:
            int r15 = r13 - 1;
            if (r15 >= 0) goto L11;
            return -1;
        L11:
            if (r15 < r10.size()) goto L13;
            return -1;
        L13:
            return r10.keyAt(r15);
        }

        public int getCachedSpanGroupIndex(int r10, int r11) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r12 = this.mSpanGroupIndexCache.get(r10, -1);
            if (r12 == (-1)) goto L9;
            return r12;
        L9:
            int r13 = getSpanGroupIndex(r10, r11);
            this.mSpanGroupIndexCache.put(r10, r13);
            return r13;
        L5:
            return getSpanGroupIndex(r10, r11);
        }

        public int getCachedSpanIndex(int r10, int r11) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r12 = this.mSpanIndexCache.get(r10, -1);
            if (r12 == (-1)) goto L9;
            return r12;
        L9:
            int r13 = getSpanIndex(r10, r11);
            this.mSpanIndexCache.put(r10, r13);
            return r13;
        L5:
            return getSpanIndex(r10, r11);
        }

        public int getSpanGroupIndex(int r10, int r11) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r12 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r10);
            if (r12 == (-1)) goto L9;
            int r13 = this.mSpanGroupIndexCache.get(r12);
            int r14 = r12 + 1;
            int r15 = getCachedSpanIndex(r12, r11) + getSpanSize(r12);
            if (r15 != r11) goto L10;
            r13 = r13 + 1;
            r15 = 0;
        L10:
            int r16 = getSpanSize(r10);
        L11:
            if (r14 >= r10) goto L19;
            int r17 = getSpanSize(r14);
            r15 = r15 + r17;
            if (r15 != r11) goto L15;
            r13 = r13 + 1;
            r15 = 0;
        L17:
            r14 = r14 + 1;
            goto L11
        L15:
            if (r15 <= r11) goto L17;
            r13 = r13 + 1;
            r15 = r17;
            goto L17
        L19:
            if ((r15 + r16) > r11) goto L21;
            return r13;
        L21:
            return r13 + 1;
        L9:
            r13 = 0;
            r14 = 0;
            r15 = 0;
            goto L10
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r10, int r11) {
            int r12 = getSpanSize(r10);
            if (r12 != r11) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r13 = findFirstKeyLessThan(this.mSpanIndexCache, r10);
            if (r13 < 0) goto L10;
            int r14 = this.mSpanIndexCache.get(r13) + getSpanSize(r13);
        L17:
            r13 = r13 + 1;
        L11:
            if (r13 >= r10) goto L19;
            int r15 = getSpanSize(r13);
            r14 = r14 + r15;
            if (r14 != r11) goto L15;
            r14 = 0;
            goto L17
        L15:
            if (r14 <= r11) goto L17;
            r14 = r15;
            goto L17
        L19:
            if ((r12 + r14) > r11) goto L21;
            return r14;
        L21:
            return 0;
        L10:
            r13 = 0;
            r14 = 0;
            goto L11
        }

        public abstract int getSpanSize(int r10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean r10) {
            if (r10 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r10;
        }

        public void setSpanIndexCacheEnabled(boolean r10) {
            if (r10 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r10;
        }
    }

    public GridLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f4099a = false;
        this.f4100b = -1;
        this.f4103e = new SparseIntArray();
        this.f4104f = new SparseIntArray();
        this.f4105g = new a();
        this.f4106h = new Rect();
        Q(RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13).f4198b);
    }

    public static int[] B(int[] r10, int r11, int r12) {
        int r13 = 1;
        if (r10 != null) goto L5;
    L8:
        r10 = new int[r11 + 1];
    L9:
        int r14 = 0;
        r10[0] = 0;
        int r15 = r12 / r11;
        int r16 = r12 % r11;
        int r17 = 0;
    L10:
        if (r13 > r11) goto L18;
        r14 = r14 + r16;
        if (r14 > 0) goto L14;
    L16:
        int r18 = r15;
    L17:
        r17 = r17 + r18;
        r10[r13] = r17;
        r13 = r13 + 1;
        goto L10
    L14:
        if ((r11 - r14) >= r16) goto L16;
        r18 = r15 + 1;
        r14 = r14 - r11;
        goto L17
    L18:
        return r10;
    L5:
        if (r10.length != (r11 + 1)) goto L8;
        if (r10[r10.length - 1] == r12) goto L9;
        goto L8
    }

    public final void A(int r10) {
        this.f4101c = B(this.f4101c, this.f4100b, r10);
    }

    public final void C() {
        this.f4103e.clear();
        this.f4104f.clear();
    }

    public final int D(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L19:
        return 0;
    L5:
        if (r10.c() == 0) goto L19;
        ensureLayoutState();
        boolean r11 = isSmoothScrollbarEnabled();
        View r12 = findFirstVisibleChildClosestToStart(!r11, true);
        View r13 = findFirstVisibleChildClosestToEnd(!r11, true);
        if (r12 == null) goto L19;
        if (r13 == null) goto L19;
        int r14 = this.f4105g.getCachedSpanGroupIndex(getPosition(r12), this.f4100b);
        int r15 = this.f4105g.getCachedSpanGroupIndex(getPosition(r13), this.f4100b);
        int r16 = Math.min(r14, r15);
        int r17 = Math.max(r14, r15);
        int r18 = this.f4105g.getCachedSpanGroupIndex(r10.c() - 1, this.f4100b) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r19 = Math.max(0, (r18 - r17) - 1);
    L15:
        if (r11 == true) goto L18;
        return r19;
    L18:
        return Math.round((r19 * (Math.abs(this.mOrientationHelper.d(r13) - this.mOrientationHelper.g(r12)) / ((this.f4105g.getCachedSpanGroupIndex(getPosition(r13), this.f4100b) - this.f4105g.getCachedSpanGroupIndex(getPosition(r12), this.f4100b)) + 1))) + (this.mOrientationHelper.n() - this.mOrientationHelper.g(r12)));
    L14:
        r19 = Math.max(0, r16);
        goto L15
    }

    public final int E(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r10.c() == 0) goto L17;
        ensureLayoutState();
        View r11 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r12 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r11 == null) goto L17;
        if (r12 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r13 = this.mOrientationHelper.d(r12) - this.mOrientationHelper.g(r11);
        int r14 = this.f4105g.getCachedSpanGroupIndex(getPosition(r11), this.f4100b);
        int r15 = this.f4105g.getCachedSpanGroupIndex(getPosition(r12), this.f4100b);
        return (int) ((r13 / ((r15 - r14) + 1)) * (this.f4105g.getCachedSpanGroupIndex(r10.c() - 1, this.f4100b) + 1));
    L14:
        return this.f4105g.getCachedSpanGroupIndex(r10.c() - 1, this.f4100b) + 1;
    }

    public final void F(RecyclerView.Recycler r10, RecyclerView.State r11, LinearLayoutManager.AnchorInfo r12, int r13) {
        if (r13 != 1) goto L5;
        boolean r14 = true;
    L6:
        int r15 = K(r10, r11, r12.f4162b);
        if (r14 == false) goto L12;
    L8:
        if (r15 <= 0) goto L23;
        int r16 = r12.f4162b;
        if (r16 <= 0) goto L24;
        int r17 = r16 - 1;
        r12.f4162b = r17;
        r15 = K(r10, r11, r17);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r18 = r11.c() - 1;
        int r19 = r12.f4162b;
    L13:
        if (r19 >= r18) goto L17;
        int r20 = r19 + 1;
        int r21 = K(r10, r11, r20);
        if (r21 <= r15) goto L17;
        r19 = r20;
        r15 = r21;
    L17:
        r12.f4162b = r19;
        return;
    L5:
        r14 = false;
        goto L6
    }

    public final void G() {
        View[] r10 = this.f4102d;
        if (r10 != null) goto L5;
    L6:
        this.f4102d = new View[this.f4100b];
        return;
    L5:
        if (r10.length != this.f4100b) goto L6;
    }

    public int H(int r10, int r11) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r12 = this.f4101c;
        return r12[r11 + r10] - r12[r10];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r13 = this.f4101c;
        int r14 = this.f4100b;
        return r13[r14 - r10] - r13[(r14 - r10) - r11];
    }

    public int I() {
        return this.f4100b;
    }

    public final int J(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.f() == false) goto L5;
        int r13 = r10.f(r12);
        if (r13 != (-1)) goto L11;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + r12);
        return 0;
    L11:
        return this.f4105g.getCachedSpanGroupIndex(r13, this.f4100b);
    L5:
        return this.f4105g.getCachedSpanGroupIndex(r12, this.f4100b);
    }

    public final int K(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.f() == false) goto L5;
        int r13 = this.f4104f.get(r12, -1);
        if (r13 == (-1)) goto L9;
        return r13;
    L9:
        int r14 = r10.f(r12);
        if (r14 != (-1)) goto L14;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r12);
        return 0;
    L14:
        return this.f4105g.getCachedSpanIndex(r14, this.f4100b);
    L5:
        return this.f4105g.getCachedSpanIndex(r12, this.f4100b);
    }

    public final int L(RecyclerView.Recycler r10, RecyclerView.State r11, int r12) {
        if (r11.f() == false) goto L5;
        int r13 = this.f4103e.get(r12, -1);
        if (r13 == (-1)) goto L9;
        return r13;
    L9:
        int r14 = r10.f(r12);
        if (r14 != (-1)) goto L14;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r12);
        return 1;
    L14:
        return this.f4105g.getSpanSize(r14);
    L5:
        return this.f4105g.getSpanSize(r12);
    }

    public b M() {
        return this.f4105g;
    }

    public final void N(float r10, int r11) {
        A(Math.max(Math.round(r10 * this.f4100b), r11));
    }

    public final void O(View r10, int r11, boolean r12) {
        LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
        Rect r14 = r13.mDecorInsets;
        int r15 = ((r14.top + r14.bottom) + ((ViewGroup.MarginLayoutParams) r13).topMargin) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin;
        int r16 = ((r14.left + r14.right) + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + ((ViewGroup.MarginLayoutParams) r13).rightMargin;
        int r17 = H(r13.f4108a, r13.f4109b);
        if (this.mOrientation != 1) goto L5;
        int r18 = RecyclerView.LayoutManager.getChildMeasureSpec(r17, r11, r16, ((ViewGroup.MarginLayoutParams) r13).width, false);
        int r19 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.o(), getHeightMode(), r15, ((ViewGroup.MarginLayoutParams) r13).height, true);
    L6:
        P(r10, r18, r19, r12);
        return;
    L5:
        int r110 = RecyclerView.LayoutManager.getChildMeasureSpec(r17, r11, r15, ((ViewGroup.MarginLayoutParams) r13).height, false);
        int r20 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.o(), getWidthMode(), r16, ((ViewGroup.MarginLayoutParams) r13).width, true);
        r19 = r110;
        r18 = r20;
        goto L6
    }

    public final void P(View r10, int r11, int r12, boolean r13) {
        RecyclerView.LayoutParams r14 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        if (r13 == false) goto L5;
        boolean r15 = shouldReMeasureChild(r10, r11, r12, r14);
    L6:
        if (r15 == false) goto L9;
        r10.measure(r11, r12);
        return;
    L9:
        return;
    L5:
        r15 = shouldMeasureChild(r10, r11, r12, r14);
        goto L6
    }

    public void Q(int r10) {
        if (r10 != this.f4100b) goto L5;
        return;
    L5:
        this.f4099a = true;
        if (r10 < 1) goto L10;
        this.f4100b = r10;
        this.f4105g.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r10);
    }

    public void R(b r10) {
        this.f4105g = r10;
    }

    public final void S() {
        if (getOrientation() != 1) goto L6;
        int r10 = getWidth() - getPaddingRight();
        int r11 = getPaddingLeft();
    L7:
        A(r10 - r11);
        return;
    L6:
        r10 = getHeight() - getPaddingBottom();
        r11 = getPaddingTop();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r10, LinearLayoutManager.LayoutState r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r13 = this.f4100b;
        int r14 = 0;
    L4:
        if (r14 >= this.f4100b) goto L9;
        if (r11.c(r10) == false) goto L13;
        if (r13 <= 0) goto L14;
        int r15 = r11.f4173d;
        r12.addPosition(r15, Math.max(0, r11.f4176g));
        r13 = r13 - this.f4105g.getSpanSize(r15);
        r11.f4173d += r11.f4174e;
        r14 = r14 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r10) {
        if (this.f4107i == false) goto L7;
        return D(r10);
    L7:
        return super.computeHorizontalScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r10) {
        if (this.f4107i == false) goto L7;
        return E(r10);
    L7:
        return super.computeHorizontalScrollRange(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r10) {
        if (this.f4107i == false) goto L7;
        return D(r10);
    L7:
        return super.computeVerticalScrollOffset(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r10) {
        if (this.f4107i == false) goto L7;
        return E(r10);
    L7:
        return super.computeVerticalScrollRange(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler r10, RecyclerView.State r11, boolean r12, boolean r13) {
        int r14 = getChildCount();
        int r15 = 1;
        if (r13 == false) goto L5;
        int r16 = getChildCount() - 1;
        int r17 = -1;
        r15 = -1;
    L6:
        int r18 = r11.c();
        ensureLayoutState();
        int r19 = this.mOrientationHelper.n();
        int r20 = this.mOrientationHelper.i();
        View r21 = null;
        View r22 = null;
    L7:
        if (r16 == r17) goto L27;
        View r23 = getChildAt(r16);
        int r24 = getPosition(r23);
        if (r24 < 0) goto L26;
        if (r24 >= r18) goto L26;
        if (K(r10, r11, r24) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r23.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r22 != null) goto L26;
        r22 = r23;
        goto L26
    L19:
        if (this.mOrientationHelper.g(r23) < r20) goto L21;
    L24:
        if (r21 != null) goto L26;
        r21 = r23;
        goto L26
    L21:
        if (this.mOrientationHelper.d(r23) < r19) goto L24;
        return r23;
    L26:
        r16 = r16 + r15;
        goto L7
    L27:
        if (r21 == null) goto L30;
        return r21;
    L30:
        return r22;
    L5:
        r17 = r14;
        r16 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
        return new LayoutParams(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 1) goto L7;
        return this.f4100b;
    L7:
        if (r11.c() >= 1) goto L11;
        return 0;
    L11:
        return J(r10, r11, r11.c() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mOrientation != 0) goto L7;
        return this.f4100b;
    L7:
        if (r11.c() >= 1) goto L11;
        return 0;
    L11:
        return J(r10, r11, r11.c() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.Recycler r18, RecyclerView.State r19, LinearLayoutManager.LayoutState r20, LinearLayoutManager.LayoutChunkResult r21) {
        int r10 = this.mOrientationHelper.m();
        if (r10 == 1073741824) goto L5;
        boolean r11 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r12 = this.f4101c[this.f4100b];
    L10:
        if (r11 == false) goto L13;
        S();
    L13:
        if (r20.f4174e != 1) goto L15;
        boolean r13 = true;
    L16:
        int r14 = this.f4100b;
        if (r13 == true) goto L19;
        r14 = K(r18, r19, r20.f4173d) + L(r18, r19, r20.f4173d);
    L19:
        int r15 = 0;
    L21:
        if (r15 >= this.f4100b) goto L36;
        if (r20.c(r19) == false) goto L36;
        if (r14 <= 0) goto L36;
        int r16 = r20.f4173d;
        int r17 = L(r18, r19, r16);
        if (r17 > this.f4100b) goto L35;
        r14 = r14 - r17;
        if (r14 < 0) goto L36;
        View r22 = r20.d(r18);
        if (r22 == null) goto L36;
        this.f4102d[r15] = r22;
        r15 = r15 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r16 + " requires " + r17 + " spans but GridLayoutManager has only " + this.f4100b + " spans.");
    L36:
        if (r15 != 0) goto L39;
        r21.f4167b = true;
        return;
    L39:
        y(r18, r19, r15, r13);
        float r23 = 0.0f;
        int r24 = 0;
        int r25 = 0;
    L40:
        if (r24 >= r15) goto L56;
        View r110 = this.f4102d[r24];
        if (r20.f4181l != null) goto L46;
        if (r13 == false) goto L45;
        addView(r110);
    L49:
        calculateItemDecorationsForChild(r110, this.f4106h);
        O(r110, r10, false);
        int r111 = this.mOrientationHelper.e(r110);
        if (r111 <= r25) goto L52;
        r25 = r111;
    L52:
        float r112 = (this.mOrientationHelper.f(r110) * 1.0f) / ((LayoutParams) r110.getLayoutParams()).f4109b;
        if (r112 <= r23) goto L55;
        r23 = r112;
    L55:
        r24 = r24 + 1;
        goto L40
    L45:
        addView(r110, 0);
        goto L49
    L46:
        if (r13 == false) goto L48;
        addDisappearingView(r110);
        goto L49
    L48:
        addDisappearingView(r110, 0);
        goto L49
    L56:
        if (r11 == false) goto L63;
        N(r23, r12);
        int r26 = 0;
        r25 = 0;
    L58:
        if (r26 >= r15) goto L63;
        View r27 = this.f4102d[r26];
        O(r27, Ints.MAX_POWER_OF_TWO, true);
        int r28 = this.mOrientationHelper.e(r27);
        if (r28 <= r25) goto L62;
        r25 = r28;
    L62:
        r26 = r26 + 1;
    L63:
        int r29 = 0;
    L64:
        if (r29 >= r15) goto L74;
        View r30 = this.f4102d[r29];
        if (this.mOrientationHelper.e(r30) == r25) goto L73;
        LayoutParams r31 = (LayoutParams) r30.getLayoutParams();
        Rect r32 = r31.mDecorInsets;
        int r113 = ((r32.top + r32.bottom) + ((ViewGroup.MarginLayoutParams) r31).topMargin) + ((ViewGroup.MarginLayoutParams) r31).bottomMargin;
        int r114 = ((r32.left + r32.right) + ((ViewGroup.MarginLayoutParams) r31).leftMargin) + ((ViewGroup.MarginLayoutParams) r31).rightMargin;
        int r33 = H(r31.f4108a, r31.f4109b);
        if (this.mOrientation != 1) goto L70;
        int r34 = RecyclerView.LayoutManager.getChildMeasureSpec(r33, Ints.MAX_POWER_OF_TWO, r114, ((ViewGroup.MarginLayoutParams) r31).width, false);
        int r35 = View.MeasureSpec.makeMeasureSpec(r25 - r113, Ints.MAX_POWER_OF_TWO);
    L71:
        P(r30, r34, r35, true);
        goto L73
    L70:
        int r115 = View.MeasureSpec.makeMeasureSpec(r25 - r114, Ints.MAX_POWER_OF_TWO);
        r35 = RecyclerView.LayoutManager.getChildMeasureSpec(r33, Ints.MAX_POWER_OF_TWO, r113, ((ViewGroup.MarginLayoutParams) r31).height, false);
        r34 = r115;
    L73:
        r29 = r29 + 1;
        goto L64
    L74:
        r21.f4166a = r25;
        if (this.mOrientation != 1) goto L82;
        if (r20.f4175f != (-1)) goto L80;
        int r36 = r20.f4171b;
        int r37 = r36 - r25;
    L79:
        int r38 = r37;
        int r39 = 0;
        int r40 = 0;
    L86:
        int r41 = 0;
    L87:
        if (r41 >= r15) goto L102;
        View r116 = this.f4102d[r41];
        LayoutParams r117 = (LayoutParams) r116.getLayoutParams();
        if (this.mOrientation == 1) goto L91;
        int r42 = getPaddingTop() + this.f4101c[r117.f4108a];
        int r118 = r42;
        int r119 = r39;
        int r120 = r40;
        r36 = this.mOrientationHelper.f(r116) + r42;
    L96:
        layoutDecoratedWithMargins(r116, r120, r118, r119, r36);
        if (r117.isItemRemoved() == false) goto L99;
    L100:
        r21.f4168c = true;
    L101:
        r21.f4169d |= r116.hasFocusable();
        r41 = r41 + 1;
        r36 = r36;
        r39 = r119;
        r40 = r120;
        r38 = r118;
        goto L87
    L99:
        if (r117.isItemChanged() == false) goto L101;
    L91:
        if (isLayoutRTL() == false) goto L94;
        int r43 = getPaddingLeft() + this.f4101c[this.f4100b - r117.f4108a];
        r119 = r43;
        r120 = r43 - this.mOrientationHelper.f(r116);
    L93:
        r118 = r38;
        goto L96
    L94:
        int r44 = getPaddingLeft() + this.f4101c[r117.f4108a];
        r120 = r44;
        r119 = this.mOrientationHelper.f(r116) + r44;
        goto L93
    L102:
        Arrays.fill(this.f4102d, null);
        return;
    L80:
        r37 = r20.f4171b;
        r36 = r37 + r25;
        goto L79
    L82:
        if (r20.f4175f != (-1)) goto L85;
        int r45 = r20.f4171b;
        int r46 = r45 - r25;
    L84:
        r40 = r46;
        r38 = 0;
        r39 = r45;
        r36 = 0;
        goto L86
    L85:
        r46 = r20.f4171b;
        r45 = r46 + r25;
        goto L84
    L15:
        r13 = false;
        goto L16
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler r10, RecyclerView.State r11, LinearLayoutManager.AnchorInfo r12, int r13) {
        super.onAnchorReady(r10, r11, r12, r13);
        S();
        if (r11.c() > 0) goto L5;
    L7:
        G();
        return;
    L5:
        if (r11.f() == true) goto L7;
        F(r10, r11, r12, r13);
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r24, int r25, RecyclerView.Recycler r26, RecyclerView.State r27) {
        RecyclerView.Recycler r10 = r26;
        RecyclerView.State r11 = r27;
        View r12 = findContainingItemView(r24);
        View r13 = null;
        if (r12 != null) goto L5;
        return null;
    L5:
        LayoutParams r14 = (LayoutParams) r12.getLayoutParams();
        int r15 = r14.f4108a;
        int r16 = r14.f4109b + r15;
        if (super.onFocusSearchFailed(r24, r25, r26, r27) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r25) != 1) goto L11;
        boolean r17 = true;
    L13:
        if (r17 == this.mShouldReverseLayout) goto L15;
        int r18 = getChildCount() - 1;
        int r19 = -1;
        int r110 = -1;
    L17:
        if (this.mOrientation == 1) goto L19;
    L21:
        boolean r111 = false;
    L22:
        int r112 = J(r10, r11, r18);
        int r113 = -1;
        int r114 = -1;
        int r20 = 0;
        int r115 = 0;
        int r116 = r18;
        View r21 = null;
    L23:
        if (r116 == r19) goto L26;
        int r22 = J(r10, r11, r116);
        View r23 = getChildAt(r116);
        if (r23 == r12) goto L26;
        if (r23.hasFocusable() == false) goto L35;
        if (r22 == r112) goto L35;
        if (r13 != null) goto L26;
        View r117 = r12;
        View r28 = r21;
    L33:
        int r118 = r20;
        int r29 = r19;
    L34:
        int r30 = r114;
        int r31 = r115;
    L75:
        r114 = r30;
        r115 = r31;
        r20 = r118;
        r21 = r28;
    L76:
        r116 = r116 + r110;
        r10 = r26;
        r11 = r27;
        r12 = r117;
        r19 = r29;
    L35:
        LayoutParams r32 = (LayoutParams) r23.getLayoutParams();
        int r33 = r32.f4108a;
        r117 = r12;
        int r34 = r32.f4109b + r33;
        if (r23.hasFocusable() == false) goto L41;
        if (r33 != r15) goto L41;
        if (r34 != r16) goto L41;
        return r23;
    L41:
        if (r23.hasFocusable() == false) goto L44;
        if (r13 != null) goto L44;
    L46:
        r28 = r21;
    L47:
        r118 = r20;
        r29 = r19;
        r30 = r114;
        r31 = r115;
    L71:
        if (r23.hasFocusable() == false) goto L73;
        r113 = r32.f4108a;
        r114 = r30;
        r115 = r31;
        r21 = r28;
        r13 = r23;
        r20 = Math.min(r34, r16) - Math.max(r33, r15);
        goto L76
    L73:
        int r35 = r32.f4108a;
        r115 = Math.min(r34, r16) - Math.max(r33, r15);
        r114 = r35;
        r20 = r118;
        r21 = r23;
    L44:
        if (r23.hasFocusable() == true) goto L48;
        if (r21 == null) goto L46;
    L48:
        r28 = r21;
        int r36 = Math.min(r34, r16) - Math.max(r33, r15);
        if (r23.hasFocusable() == false) goto L58;
        if (r36 > r20) goto L47;
        if (r36 != r20) goto L33;
        if (r33 <= r113) goto L55;
        boolean r37 = true;
    L56:
        if (r111 != r37) goto L33;
    L55:
        r37 = false;
        goto L56
    L58:
        if (r13 != null) goto L33;
        r118 = r20;
        r29 = r19;
        boolean r119 = true;
        if (isViewPartiallyVisible(r23, false, true) == false) goto L34;
        r31 = r115;
        if (r36 <= r31) goto L64;
        r30 = r114;
        goto L71
    L64:
        if (r36 != r31) goto L74;
        r30 = r114;
        if (r33 > r30) goto L69;
        r119 = false;
    L69:
        if (r111 != r119) goto L75;
    L74:
        r30 = r114;
    L26:
        View r210 = r21;
        if (r13 == null) goto L80;
        return r13;
    L80:
        return r210;
    L19:
        if (isLayoutRTL() == false) goto L21;
        r111 = true;
        goto L22
    L15:
        r19 = getChildCount();
        r110 = 1;
        r18 = 0;
        goto L17
    L11:
        r17 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r10, RecyclerView.State r11, AccessibilityNodeInfoCompat r12) {
        super.onInitializeAccessibilityNodeInfo(r10, r11, r12);
        r12.V(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r10, RecyclerView.State r11, View r12, AccessibilityNodeInfoCompat r13) {
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r12, r13);
        return;
    L6:
        LayoutParams r15 = (LayoutParams) r14;
        int r16 = J(r10, r11, r15.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        r13.Y(AccessibilityNodeInfoCompat.c.a(r15.a(), r15.b(), r16, 1, false, false));
        return;
    L9:
        r13.Y(AccessibilityNodeInfoCompat.c.a(r16, 1, r15.a(), r15.b(), false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r10, int r11, int r12) {
        this.f4105g.invalidateSpanIndexCache();
        this.f4105g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r10) {
        this.f4105g.invalidateSpanIndexCache();
        this.f4105g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r10, int r11, int r12, int r13) {
        this.f4105g.invalidateSpanIndexCache();
        this.f4105g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r10, int r11, int r12) {
        this.f4105g.invalidateSpanIndexCache();
        this.f4105g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r10, int r11, int r12, Object r13) {
        this.f4105g.invalidateSpanIndexCache();
        this.f4105g.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (r11.f() == false) goto L5;
        z();
    L5:
        super.onLayoutChildren(r10, r11);
        C();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.f4099a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        S();
        G();
        return super.scrollHorizontallyBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        S();
        G();
        return super.scrollVerticallyBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r10, int r11, int r12) {
        if (this.f4101c != null) goto L5;
        super.setMeasuredDimension(r10, r11, r12);
    L5:
        int r13 = getPaddingLeft() + getPaddingRight();
        int r14 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L8;
        int r15 = RecyclerView.LayoutManager.chooseSize(r12, r10.height() + r14, getMinimumHeight());
        int[] r16 = this.f4101c;
        int r17 = RecyclerView.LayoutManager.chooseSize(r11, r16[r16.length - 1] + r13, getMinimumWidth());
    L9:
        setMeasuredDimension(r17, r15);
        return;
    L8:
        r17 = RecyclerView.LayoutManager.chooseSize(r11, r10.width() + r13, getMinimumWidth());
        int[] r18 = this.f4101c;
        r15 = RecyclerView.LayoutManager.chooseSize(r12, r18[r18.length - 1] + r14, getMinimumHeight());
        goto L9
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r10) {
        if (r10 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f4099a == true) goto L7;
        return true;
    }

    public final void y(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, boolean r13) {
        int r14 = 0;
        if (r13 == false) goto L5;
        int r15 = 1;
        int r16 = r12;
        int r17 = 0;
    L6:
        if (r17 == r16) goto L8;
        View r18 = this.f4102d[r17];
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        int r20 = L(r10, r11, getPosition(r18));
        r19.f4109b = r20;
        r19.f4108a = r14;
        r14 = r14 + r20;
        r17 = r17 + r15;
        goto L6
    L8:
        return;
    L5:
        r17 = r12 - 1;
        r16 = -1;
        r15 = -1;
        goto L6
    }

    public final void z() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        LayoutParams r12 = (LayoutParams) getChildAt(r11).getLayoutParams();
        int r13 = r12.getViewLayoutPosition();
        this.f4103e.put(r13, r12.b());
        this.f4104f.put(r13, r12.a());
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L7:
        return new LayoutParams(r10);
    }

    public GridLayoutManager(Context r10, int r11) {
        super(r10);
        this.f4099a = false;
        this.f4100b = -1;
        this.f4103e = new SparseIntArray();
        this.f4104f = new SparseIntArray();
        this.f4105g = new a();
        this.f4106h = new Rect();
        Q(r11);
    }

    public GridLayoutManager(Context r10, int r11, int r12, boolean r13) {
        super(r10, r12, r13);
        this.f4099a = false;
        this.f4100b = -1;
        this.f4103e = new SparseIntArray();
        this.f4104f = new SparseIntArray();
        this.f4105g = new a();
        this.f4106h = new Rect();
        Q(r11);
    }
}
