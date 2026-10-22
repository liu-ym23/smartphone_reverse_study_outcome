package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class AnchorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrientationHelper f4161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4165e;

        public AnchorInfo() {
            e();
        }

        public void a() {
            if (this.f4164d == false) goto L5;
            int r10 = this.f4161a.i();
        L6:
            this.f4163c = r10;
            return;
        L5:
            r10 = this.f4161a.n();
            goto L6
        }

        public void b(View r10, int r11) {
            if (this.f4164d == false) goto L5;
            this.f4163c = this.f4161a.d(r10) + this.f4161a.p();
        L6:
            this.f4162b = r11;
            return;
        L5:
            this.f4163c = this.f4161a.g(r10);
            goto L6
        }

        public void c(View r10, int r11) {
            int r12 = this.f4161a.p();
            if (r12 < 0) goto L6;
            b(r10, r11);
            return;
        L6:
            this.f4162b = r11;
            if (this.f4164d == false) goto L13;
            int r13 = (this.f4161a.i() - r12) - this.f4161a.d(r10);
            this.f4163c = this.f4161a.i() - r13;
            if (r13 <= 0) goto L19;
            int r14 = this.f4163c - this.f4161a.e(r10);
            int r15 = this.f4161a.n();
            int r16 = r14 - (r15 + Math.min(this.f4161a.g(r10) - r15, 0));
            if (r16 >= 0) goto L20;
            this.f4163c += Math.min(r13, -r16);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r17 = this.f4161a.g(r10);
            int r18 = r17 - this.f4161a.n();
            this.f4163c = r17;
            if (r18 <= 0) goto L22;
            int r19 = (this.f4161a.i() - Math.min(0, (this.f4161a.i() - r12) - this.f4161a.d(r10))) - (r17 + this.f4161a.e(r10));
            if (r19 >= 0) goto L23;
            this.f4163c -= Math.min(r18, -r19);
            return;
        L23:
            return;
        }

        public boolean d(View r10, RecyclerView.State r11) {
            RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            if (r12.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r12.getViewLayoutPosition() < 0) goto L9;
            if (r12.getViewLayoutPosition() >= r11.c()) goto L9;
            return true;
        }

        public void e() {
            this.f4162b = -1;
            this.f4163c = Integer.MIN_VALUE;
            this.f4164d = false;
            this.f4165e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f4162b + ", mCoordinate=" + this.f4163c + ", mLayoutFromEnd=" + this.f4164d + ", mValid=" + this.f4165e + '}';
        }
    }

    public static class LayoutChunkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4169d;

        public LayoutChunkResult() {
        }

        public void a() {
            this.f4166a = 0;
            this.f4167b = false;
            this.f4168c = false;
            this.f4169d = false;
        }
    }

    public static class LayoutState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4173d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4174e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4175f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4176g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4177h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4178i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f4179j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4180k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f4181l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4182m;

        public LayoutState() {
            this.f4170a = true;
            this.f4177h = 0;
            this.f4178i = 0;
            this.f4179j = false;
            this.f4181l = null;
        }

        public void a() {
            b(null);
        }

        public void b(View r10) {
            View r11 = f(r10);
            if (r11 != null) goto L5;
            this.f4173d = -1;
            return;
        L5:
            this.f4173d = ((RecyclerView.LayoutParams) r11.getLayoutParams()).getViewLayoutPosition();
        }

        public boolean c(RecyclerView.State r10) {
            int r11 = this.f4173d;
            if (r11 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11 >= r10.c()) goto L7;
            return true;
        }

        public View d(RecyclerView.Recycler r10) {
            if (this.f4181l != null) goto L5;
            View r11 = r10.o(this.f4173d);
            this.f4173d += this.f4174e;
            return r11;
        L5:
            return e();
        }

        public final View e() {
            int r10 = this.f4181l.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L12;
            View r12 = ((RecyclerView.ViewHolder) this.f4181l.get(r11)).itemView;
            RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12.getLayoutParams();
            if (r13.isItemRemoved() == true) goto L11;
            if (this.f4173d != r13.getViewLayoutPosition()) goto L11;
            b(r12);
            return r12;
        L11:
            r11 = r11 + 1;
            goto L3
        L12:
            return null;
        }

        public View f(View r10) {
            int r11 = this.f4181l.size();
            View r12 = null;
            int r13 = Channel.UNLIMITED;
            int r14 = 0;
        L3:
            if (r14 >= r11) goto L18;
            View r15 = ((RecyclerView.ViewHolder) this.f4181l.get(r14)).itemView;
            RecyclerView.LayoutParams r16 = (RecyclerView.LayoutParams) r15.getLayoutParams();
            if (r15 == r10) goto L17;
            if (r16.isItemRemoved() == true) goto L17;
            int r17 = (r16.getViewLayoutPosition() - this.f4173d) * this.f4174e;
            if (r17 < 0) goto L17;
            if (r17 >= r13) goto L17;
            r12 = r15;
            if (r17 == 0) goto L18;
            r13 = r17;
        L17:
            r14 = r14 + 1;
        L18:
            return r12;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mAnchorPosition);
            r10.writeInt(this.mAnchorOffset);
            r10.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel r10) {
            this.mAnchorPosition = r10.readInt();
            this.mAnchorOffset = r10.readInt();
            boolean r11 = true;
            if (r10.readInt() == 1) goto L6;
            r11 = false;
        L6:
            this.mAnchorLayoutFromEnd = r11;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState r10) {
            this.mAnchorPosition = r10.mAnchorPosition;
            this.mAnchorOffset = r10.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r10.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context r10) {
        this(r10, 1, false);
    }

    private void recycleChildren(RecyclerView.Recycler r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return;
    L4:
        if (r12 <= r11) goto L8;
        int r13 = r12 - 1;
    L6:
        if (r13 < r11) goto L10;
        removeAndRecycleViewAt(r13, r10);
        r13 = r13 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r11 <= r12) goto L13;
        removeAndRecycleViewAt(r11, r10);
        r11 = r11 - 1;
        goto L8
    }

    public final int a(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return l.a(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String r10) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r10);
        return;
    }

    public final int b(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return l.b(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int c(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return l.c(r10, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State r10, @NonNull int[] r11) {
        int r12 = getExtraLayoutSpace(r10);
        if (this.mLayoutState.f4175f != (-1)) goto L5;
        int r13 = 0;
    L6:
        r11[0] = r12;
        r11[1] = r13;
        return;
    L5:
        r13 = r12;
        r12 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int r10, int r11, RecyclerView.State r12, RecyclerView.LayoutManager.LayoutPrefetchRegistry r13) {
        if (this.mOrientation == 0) goto L7;
        r10 = r11;
    L7:
        if (getChildCount() == 0) goto L16;
        if (r10 == 0) goto L17;
        ensureLayoutState();
        if (r10 <= 0) goto L13;
        int r14 = 1;
    L14:
        t(r14, Math.abs(r10), true, r12);
        collectPrefetchPositionsForLayoutState(r12, this.mLayoutState, r13);
        return;
    L13:
        r14 = -1;
        goto L14
    L17:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int r10, RecyclerView.LayoutManager.LayoutPrefetchRegistry r11) {
        SavedState r12 = this.mPendingSavedState;
        int r13 = -1;
        if (r12 != null) goto L5;
    L7:
        p();
        boolean r14 = this.mShouldReverseLayout;
        int r15 = this.mPendingScrollPosition;
        if (r15 != (-1)) goto L12;
        if (r14 == false) goto L11;
        r15 = r10 - 1;
        goto L12
    L11:
        r15 = 0;
    L12:
        if (r14 == true) goto L15;
        r13 = 1;
    L15:
        int r16 = 0;
    L17:
        if (r16 >= this.mInitialPrefetchItemCount) goto L21;
        if (r15 < 0) goto L25;
        if (r15 >= r10) goto L26;
        r11.addPosition(r15, 0);
        r15 = r15 + r13;
        r16 = r16 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r12.hasValidAnchor() == false) goto L7;
        SavedState r17 = this.mPendingSavedState;
        r14 = r17.mAnchorLayoutFromEnd;
        r15 = r17.mAnchorPosition;
        goto L12
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r10, LayoutState r11, RecyclerView.LayoutManager.LayoutPrefetchRegistry r12) {
        int r13 = r11.f4173d;
        if (r13 >= 0) goto L5;
        return;
    L5:
        if (r13 >= r10.c()) goto L9;
        r12.addPosition(r13, Math.max(0, r11.f4176g));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State r10) {
        return a(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State r10) {
        return b(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State r10) {
        return c(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int r10) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r11 = false;
        int r12 = 1;
        if (r10 >= getPosition(getChildAt(0))) goto L10;
        r11 = true;
    L10:
        if (r11 == this.mShouldReverseLayout) goto L13;
        r12 = -1;
    L13:
        if (this.mOrientation != 0) goto L17;
        return new PointF(r12, 0.0f);
    L17:
        return new PointF(0.0f, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State r10) {
        return a(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State r10) {
        return b(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State r10) {
        return c(r10);
    }

    public int convertFocusDirectionToLayoutDirection(int r10) {
        if (r10 == 1) goto L43;
        if (r10 == 2) goto L36;
        if (r10 == 17) goto L31;
        if (r10 == 33) goto L26;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.mOrientation != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.mOrientation != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.mOrientation != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.mOrientation != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.mOrientation != 1) goto L39;
        return 1;
    L39:
        if (isLayoutRTL() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.mOrientation != 1) goto L46;
        return -1;
    L46:
        if (isLayoutRTL() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public final View d() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    public final View e() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public void ensureLayoutState() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = createLayoutState();
        return;
    }

    public final View f() {
        if (this.mShouldReverseLayout == false) goto L6;
        return d();
    L6:
        return e();
    }

    public int fill(RecyclerView.Recycler r10, LayoutState r11, RecyclerView.State r12, boolean r13) {
        int r14 = r11.f4172c;
        int r15 = r11.f4176g;
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r14 >= 0) goto L6;
        r11.f4176g = r15 + r14;
    L6:
        m(r10, r11);
    L7:
        int r16 = r11.f4172c + r11.f4177h;
        LayoutChunkResult r17 = this.mLayoutChunkResult;
    L9:
        if (r11.f4182m == true) goto L12;
        if (r16 > 0) goto L12;
    L33:
        return r14 - r11.f4172c;
    L12:
        if (r11.c(r12) == false) goto L33;
        r17.a();
        layoutChunk(r10, r12, r11, r17);
        if (r17.f4167b == true) goto L33;
        r11.f4171b += r17.f4166a * r11.f4175f;
        if (r17.f4168c == true) goto L19;
    L22:
        int r18 = r11.f4172c;
        int r19 = r17.f4166a;
        r11.f4172c = r18 - r19;
        r16 = r16 - r19;
    L23:
        int r20 = r11.f4176g;
        if (r20 == Integer.MIN_VALUE) goto L29;
        int r21 = r20 + r17.f4166a;
        r11.f4176g = r21;
        int r22 = r11.f4172c;
        if (r22 >= 0) goto L28;
        r11.f4176g = r21 + r22;
    L28:
        m(r10, r11);
    L29:
        if (r13 == false) goto L9;
        if (r17.f4169d == false) goto L9;
    L19:
        if (r11.f4181l != null) goto L22;
        if (r12.f() == true) goto L23;
        goto L22
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View r10 = findOneVisibleChild(0, getChildCount(), true, false);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public View findFirstVisibleChildClosestToEnd(boolean r10, boolean r11) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(0, getChildCount(), r10, r11);
    L7:
        return findOneVisibleChild(getChildCount() - 1, -1, r10, r11);
    }

    public View findFirstVisibleChildClosestToStart(boolean r10, boolean r11) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(getChildCount() - 1, -1, r10, r11);
    L7:
        return findOneVisibleChild(0, getChildCount(), r10, r11);
    }

    public int findFirstVisibleItemPosition() {
        View r10 = findOneVisibleChild(0, getChildCount(), false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View r10 = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public int findLastVisibleItemPosition() {
        View r10 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r10 != null) goto L6;
        return -1;
    L6:
        return getPosition(r10);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int r10, int r11) {
        ensureLayoutState();
        if (r11 > r10) goto L7;
        if (r11 < r10) goto L7;
        return getChildAt(r10);
    L7:
        if (this.mOrientationHelper.g(getChildAt(r10)) >= this.mOrientationHelper.n()) goto L9;
        int r12 = 16644;
        int r13 = 16388;
    L11:
        if (this.mOrientation != 0) goto L14;
        return this.mHorizontalBoundCheck.a(r10, r11, r12, r13);
    L14:
        return this.mVerticalBoundCheck.a(r10, r11, r12, r13);
    L9:
        r12 = 4161;
        r13 = 4097;
        goto L11
    }

    public View findOneVisibleChild(int r10, int r11, boolean r12, boolean r13) {
        ensureLayoutState();
        int r14 = 320;
        if (r12 == false) goto L5;
        int r15 = 24579;
    L6:
        if (r13 == true) goto L10;
        r14 = 0;
    L10:
        if (this.mOrientation != 0) goto L13;
        return this.mHorizontalBoundCheck.a(r10, r11, r15, r14);
    L13:
        return this.mVerticalBoundCheck.a(r10, r11, r15, r14);
    L5:
        r15 = 320;
        goto L6
    }

    public View findReferenceChild(RecyclerView.Recycler r17, RecyclerView.State r18, boolean r19, boolean r20) {
        ensureLayoutState();
        int r10 = getChildCount();
        if (r20 == false) goto L5;
        int r11 = getChildCount() - 1;
        int r12 = -1;
        int r13 = -1;
    L6:
        int r14 = r18.c();
        int r15 = this.mOrientationHelper.n();
        int r16 = this.mOrientationHelper.i();
        View r21 = null;
        View r110 = null;
        View r111 = null;
    L7:
        if (r11 == r12) goto L37;
        View r112 = getChildAt(r11);
        int r113 = getPosition(r112);
        int r114 = this.mOrientationHelper.g(r112);
        int r115 = this.mOrientationHelper.d(r112);
        if (r113 < 0) goto L36;
        if (r113 >= r14) goto L36;
        if (((RecyclerView.LayoutParams) r112.getLayoutParams()).isItemRemoved() == false) goto L15;
        if (r111 != null) goto L36;
        r111 = r112;
        goto L36
    L15:
        if (r115 > r15) goto L18;
        if (r114 >= r15) goto L18;
        boolean r116 = true;
    L19:
        if (r114 < r16) goto L22;
        if (r115 <= r16) goto L22;
        boolean r117 = true;
    L23:
        if (r116 == true) goto L27;
        if (r117 == true) goto L27;
        return r112;
    L27:
        if (r19 == false) goto L32;
        if (r117 == true) goto L33;
        if (r21 != null) goto L36;
    L35:
        r21 = r112;
    L33:
        r110 = r112;
        goto L36
    L32:
        if (r116 == true) goto L33;
        if (r21 != null) goto L36;
    L22:
        r117 = false;
    L18:
        r116 = false;
    L36:
        r11 = r11 + r13;
        goto L7
    L37:
        if (r21 != null) goto L54;
        if (r110 == null) goto L42;
        return r110;
    L42:
        return r111;
    L54:
        return r21;
    L5:
        r12 = r10;
        r11 = 0;
        r13 = 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int r10) {
        int r11 = getChildCount();
        if (r11 != 0) goto L6;
        return null;
    L6:
        int r12 = r10 - getPosition(getChildAt(0));
        if (r12 < 0) goto L13;
        if (r12 >= r11) goto L13;
        View r13 = getChildAt(r12);
        if (getPosition(r13) != r10) goto L13;
        return r13;
    L13:
        return super.findViewByPosition(r10);
    }

    public final View g() {
        if (this.mShouldReverseLayout == false) goto L6;
        return e();
    L6:
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State r10) {
        if (r10.e() == true) goto L5;
        return 0;
    L5:
        return this.mOrientationHelper.o();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public final int h(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = this.mOrientationHelper.i() - r10;
        if (r14 <= 0) goto L11;
        int r15 = -scrollBy(-r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L10;
        int r17 = this.mOrientationHelper.i() - r16;
        if (r17 <= 0) goto L10;
        this.mOrientationHelper.s(r17);
        return r17 + r15;
    L10:
        return r15;
    L11:
        return 0;
    }

    public final int i(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = r10 - this.mOrientationHelper.n();
        if (r14 <= 0) goto L10;
        int r15 = -scrollBy(r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L12;
        int r17 = r16 - this.mOrientationHelper.n();
        if (r17 <= 0) goto L13;
        this.mOrientationHelper.s(-r17);
        return r15 - r17;
    L13:
        return r15;
    L12:
        return r15;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public final View j() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r10 = 0;
    L7:
        return getChildAt(r10);
    L5:
        r10 = getChildCount() - 1;
        goto L7
    }

    public final View k() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r10 = getChildCount() - 1;
    L7:
        return getChildAt(r10);
    L5:
        r10 = 0;
        goto L7
    }

    public final void l(RecyclerView.Recycler r11, RecyclerView.State r12, int r13, int r14) {
        if (r12.h() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r12.f() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L39;
        List r10 = r11.k();
        int r15 = r10.size();
        int r16 = getPosition(getChildAt(0));
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L12:
        if (r17 >= r15) goto L25;
        RecyclerView.ViewHolder r20 = (RecyclerView.ViewHolder) r10.get(r17);
        if (r20.isRemoved() == true) goto L24;
        if (r20.getLayoutPosition() >= r16) goto L19;
        boolean r21 = true;
    L21:
        if (r21 == this.mShouldReverseLayout) goto L23;
        r18 = r18 + this.mOrientationHelper.e(r20.itemView);
        goto L24
    L23:
        r19 = r19 + this.mOrientationHelper.e(r20.itemView);
        goto L24
    L19:
        r21 = false;
    L24:
        r17 = r17 + 1;
        goto L12
    L25:
        this.mLayoutState.f4181l = r10;
        if (r18 <= 0) goto L28;
        w(getPosition(k()), r13);
        LayoutState r110 = this.mLayoutState;
        r110.f4177h = r18;
        r110.f4172c = 0;
        r110.a();
        fill(r11, this.mLayoutState, r12, false);
    L28:
        if (r19 <= 0) goto L30;
        u(getPosition(j()), r14);
        LayoutState r111 = this.mLayoutState;
        r111.f4177h = r19;
        r111.f4172c = 0;
        r111.a();
        fill(r11, this.mLayoutState, r12, false);
    L30:
        this.mLayoutState.f4181l = null;
        return;
    }

    public void layoutChunk(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutState r12, LayoutChunkResult r13) {
        View r14 = r12.d(r10);
        if (r14 != null) goto L6;
        r13.f4167b = true;
        return;
    L6:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r12.f4181l != null) goto L15;
        boolean r16 = this.mShouldReverseLayout;
        if (r12.f4175f != (-1)) goto L11;
        boolean r17 = true;
    L12:
        if (r16 != r17) goto L14;
        addView(r14);
    L22:
        measureChildWithMargins(r14, 0, 0);
        r13.f4166a = this.mOrientationHelper.e(r14);
        if (this.mOrientation == 1) goto L25;
        int r18 = getPaddingTop();
        int r19 = this.mOrientationHelper.f(r14) + r18;
        if (r12.f4175f != (-1)) goto L35;
        int r110 = r12.f4171b;
        int r20 = r110;
        int r21 = r18;
        int r22 = r19;
        int r23 = r110 - r13.f4166a;
    L36:
        layoutDecoratedWithMargins(r14, r23, r21, r20, r22);
        if (r15.isItemRemoved() == false) goto L39;
    L40:
        r13.f4168c = true;
    L41:
        r13.f4169d = r14.hasFocusable();
        return;
    L39:
        if (r15.isItemChanged() == false) goto L41;
    L35:
        int r111 = r12.f4171b;
        r21 = r18;
        r20 = r13.f4166a + r111;
        r22 = r19;
        r23 = r111;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        int r24 = getWidth() - getPaddingRight();
        r23 = r24 - this.mOrientationHelper.f(r14);
    L29:
        if (r12.f4175f != (-1)) goto L31;
        int r112 = r12.f4171b;
        r22 = r112;
        r20 = r24;
        r21 = r112 - r13.f4166a;
        goto L36
    L31:
        int r113 = r12.f4171b;
        r21 = r113;
        r20 = r24;
        r22 = r13.f4166a + r113;
        goto L36
    L27:
        r23 = getPaddingLeft();
        r24 = this.mOrientationHelper.f(r14) + r23;
        goto L29
    L14:
        addView(r14, 0);
        goto L22
    L11:
        r17 = false;
        goto L12
    L15:
        boolean r25 = this.mShouldReverseLayout;
        if (r12.f4175f != (-1)) goto L18;
        boolean r26 = true;
    L19:
        if (r25 != r26) goto L21;
        addDisappearingView(r14);
        goto L22
    L21:
        addDisappearingView(r14, 0);
        goto L22
    L18:
        r26 = false;
        goto L19
    }

    public final void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        View r11 = getChildAt(r10);
        Log.d(TAG, "item " + getPosition(r11) + ", coord:" + this.mOrientationHelper.g(r11));
        r10 = r10 + 1;
        goto L4
    L6:
        Log.d(TAG, "==============");
    }

    public final void m(RecyclerView.Recycler r10, LayoutState r11) {
        if (r11.f4170a == true) goto L5;
        return;
    L5:
        if (r11.f4182m == true) goto L14;
        int r12 = r11.f4176g;
        int r13 = r11.f4178i;
        if (r11.f4175f != (-1)) goto L10;
        n(r10, r12, r13);
        return;
    L10:
        o(r10, r12, r13);
        return;
    }

    public final void n(RecyclerView.Recycler r10, int r11, int r12) {
        int r13 = getChildCount();
        if (r11 >= 0) goto L5;
        return;
    L5:
        int r14 = (this.mOrientationHelper.h() - r11) + r12;
        if (this.mShouldReverseLayout == false) goto L17;
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L33;
        View r16 = getChildAt(r15);
        if (this.mOrientationHelper.g(r16) < r14) goto L15;
        if (this.mOrientationHelper.r(r16) < r14) goto L15;
        r15 = r15 + 1;
    L15:
        recycleChildren(r10, 0, r15);
        return;
    L33:
        return;
    L17:
        int r17 = r13 - 1;
        int r18 = r17;
    L18:
        if (r18 < 0) goto L34;
        View r19 = getChildAt(r18);
        if (this.mOrientationHelper.g(r19) < r14) goto L25;
        if (this.mOrientationHelper.r(r19) < r14) goto L25;
        r18 = r18 - 1;
    L25:
        recycleChildren(r10, r17, r18);
        return;
    }

    public final void o(RecyclerView.Recycler r10, int r11, int r12) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        int r13 = r11 - r12;
        int r14 = getChildCount();
        if (this.mShouldReverseLayout == false) goto L16;
        int r15 = r14 - 1;
        int r16 = r15;
    L7:
        if (r16 < 0) goto L32;
        View r17 = getChildAt(r16);
        if (this.mOrientationHelper.d(r17) > r13) goto L14;
        if (this.mOrientationHelper.q(r17) > r13) goto L14;
        r16 = r16 - 1;
    L14:
        recycleChildren(r10, r15, r16);
        return;
    L32:
        return;
    L16:
        int r18 = 0;
    L17:
        if (r18 >= r14) goto L33;
        View r19 = getChildAt(r18);
        if (this.mOrientationHelper.d(r19) > r13) goto L24;
        if (this.mOrientationHelper.q(r19) > r13) goto L24;
        r18 = r18 + 1;
    L24:
        recycleChildren(r10, 0, r18);
        return;
    }

    public void onAnchorReady(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12, int r13) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        if (this.mRecycleChildrenOnDetach == false) goto L6;
        removeAndRecycleAllViews(r11);
        r11.c();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        p();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r14 = convertFocusDirectionToLayoutDirection(r11);
        if (r14 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        ensureLayoutState();
        t(r14, (int) (this.mOrientationHelper.o() * MAX_SCROLL_FACTOR), false, r13);
        LayoutState r15 = this.mLayoutState;
        r15.f4176g = Integer.MIN_VALUE;
        r15.f4170a = false;
        fill(r12, r15, r13, true);
        if (r14 != (-1)) goto L11;
        View r16 = g();
    L12:
        if (r14 != (-1)) goto L14;
        View r17 = k();
    L16:
        if (r17.hasFocusable() == false) goto L20;
        if (r16 != null) goto L19;
        return null;
    L19:
        return r17;
    L20:
        return r16;
    L14:
        r17 = j();
        goto L16
    L11:
        r16 = f();
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        if (getChildCount() <= 0) goto L6;
        r10.setFromIndex(findFirstVisibleItemPosition());
        r10.setToIndex(findLastVisibleItemPosition());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        int r12 = -1;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        SavedState r13 = this.mPendingSavedState;
        if (r13 != null) goto L13;
    L15:
        ensureLayoutState();
        this.mLayoutState.f4170a = false;
        p();
        View r14 = getFocusedChild();
        AnchorInfo r15 = this.mAnchorInfo;
        if (r15.f4165e == true) goto L18;
    L28:
        r15.e();
        AnchorInfo r16 = this.mAnchorInfo;
        r16.f4164d = this.mShouldReverseLayout ^ this.mStackFromEnd;
        s(r10, r11, r16);
        this.mAnchorInfo.f4165e = true;
    L29:
        LayoutState r17 = this.mLayoutState;
        if (r17.f4180k < 0) goto L32;
        int r18 = 1;
    L33:
        r17.f4175f = r18;
        int[] r19 = this.mReusableIntPair;
        r19[0] = 0;
        r19[1] = 0;
        calculateExtraLayoutSpace(r11, r19);
        int r20 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.n();
        int r21 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (r11.f() == false) goto L49;
        int r22 = this.mPendingScrollPosition;
        if (r22 == (-1)) goto L49;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L49;
        View r23 = findViewByPosition(r22);
        if (r23 == null) goto L49;
        if (this.mShouldReverseLayout == false) goto L45;
        int r24 = this.mOrientationHelper.i() - this.mOrientationHelper.d(r23);
        int r25 = this.mPendingScrollPositionOffset;
    L44:
        int r26 = r24 - r25;
        if (r26 <= 0) goto L48;
        r20 = r20 + r26;
        goto L49
    L48:
        r21 = r21 - r26;
        goto L49
    L45:
        r25 = this.mOrientationHelper.g(r23) - this.mOrientationHelper.n();
        r24 = this.mPendingScrollPositionOffset;
    L49:
        AnchorInfo r27 = this.mAnchorInfo;
        if (r27.f4164d == false) goto L55;
        if (this.mShouldReverseLayout == false) goto L56;
    L53:
        r12 = 1;
    L56:
        onAnchorReady(r10, r11, r27, r12);
        detachAndScrapAttachedViews(r10);
        this.mLayoutState.f4182m = resolveIsInfinite();
        this.mLayoutState.f4179j = r11.f();
        this.mLayoutState.f4178i = 0;
        AnchorInfo r28 = this.mAnchorInfo;
        if (r28.f4164d == false) goto L64;
        x(r28);
        LayoutState r29 = this.mLayoutState;
        r29.f4177h = r20;
        fill(r10, r29, r11, false);
        LayoutState r30 = this.mLayoutState;
        int r31 = r30.f4171b;
        int r32 = r30.f4173d;
        int r33 = r30.f4172c;
        if (r33 <= 0) goto L61;
        r21 = r21 + r33;
    L61:
        v(this.mAnchorInfo);
        LayoutState r34 = this.mLayoutState;
        r34.f4177h = r21;
        r34.f4173d += r34.f4174e;
        fill(r10, r34, r11, false);
        LayoutState r35 = this.mLayoutState;
        int r36 = r35.f4171b;
        int r37 = r35.f4172c;
        if (r37 <= 0) goto L71;
        w(r32, r31);
        LayoutState r38 = this.mLayoutState;
        r38.f4177h = r37;
        fill(r10, r38, r11, false);
        r31 = this.mLayoutState.f4171b;
    L71:
        if (getChildCount() > 0) goto L73;
    L77:
        l(r10, r11, r31, r36);
        if (r11.f() == true) goto L80;
        this.mOrientationHelper.t();
    L81:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L80:
        this.mAnchorInfo.e();
        goto L81
    L73:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L76;
        int r39 = h(r36, r10, r11, true);
        int r40 = r31 + r39;
        int r41 = r36 + r39;
        int r42 = i(r40, r10, r11, false);
    L75:
        r31 = r40 + r42;
        r36 = r41 + r42;
        goto L77
    L76:
        int r43 = i(r31, r10, r11, true);
        r40 = r31 + r43;
        r41 = r36 + r43;
        r42 = h(r41, r10, r11, false);
        goto L75
    L64:
        v(r28);
        LayoutState r44 = this.mLayoutState;
        r44.f4177h = r21;
        fill(r10, r44, r11, false);
        LayoutState r45 = this.mLayoutState;
        r36 = r45.f4171b;
        int r46 = r45.f4173d;
        int r47 = r45.f4172c;
        if (r47 <= 0) goto L67;
        r20 = r20 + r47;
    L67:
        x(this.mAnchorInfo);
        LayoutState r48 = this.mLayoutState;
        r48.f4177h = r20;
        r48.f4173d += r48.f4174e;
        fill(r10, r48, r11, false);
        LayoutState r49 = this.mLayoutState;
        r31 = r49.f4171b;
        int r50 = r49.f4172c;
        if (r50 <= 0) goto L71;
        u(r46, r36);
        LayoutState r51 = this.mLayoutState;
        r51.f4177h = r50;
        fill(r10, r51, r11, false);
        r36 = this.mLayoutState.f4171b;
        goto L71
    L55:
        if (this.mShouldReverseLayout == false) goto L53;
    L32:
        r18 = -1;
        goto L33
    L18:
        if (this.mPendingScrollPosition != (-1)) goto L28;
        if (this.mPendingSavedState != null) goto L28;
        if (r14 == null) goto L29;
        if (this.mOrientationHelper.g(r14) < this.mOrientationHelper.i()) goto L26;
    L27:
        this.mAnchorInfo.c(r14, getPosition(r14));
        goto L29
    L26:
        if (this.mOrientationHelper.d(r14) > this.mOrientationHelper.n()) goto L29;
    L13:
        if (r13.hasValidAnchor() == false) goto L15;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    L7:
        if (r11.c() != 0) goto L10;
        removeAndRecycleAllViews(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State r10) {
        super.onLayoutCompleted(r10);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == false) goto L9;
        SavedState r11 = (SavedState) r10;
        this.mPendingSavedState = r11;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r11.invalidateAnchor();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r10 = new SavedState();
        if (getChildCount() <= 0) goto L12;
        ensureLayoutState();
        boolean r11 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        r10.mAnchorLayoutFromEnd = r11;
        if (r11 == false) goto L11;
        View r12 = j();
        r10.mAnchorOffset = this.mOrientationHelper.i() - this.mOrientationHelper.d(r12);
        r10.mAnchorPosition = getPosition(r12);
    L13:
        return r10;
    L11:
        View r13 = k();
        r10.mAnchorPosition = getPosition(r13);
        r10.mAnchorOffset = this.mOrientationHelper.g(r13) - this.mOrientationHelper.n();
        goto L13
    L12:
        r10.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    public final void p() {
        if (this.mOrientation != 1) goto L5;
    L8:
        this.mShouldReverseLayout = this.mReverseLayout;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.mShouldReverseLayout = !this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View r10, @NonNull View r11, int r12, int r13) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        p();
        int r14 = getPosition(r10);
        int r15 = getPosition(r11);
        if (r14 >= r15) goto L5;
        byte r16 = 1;
    L7:
        if (this.mShouldReverseLayout == false) goto L11;
        if (r16 != 1) goto L10;
        scrollToPositionWithOffset(r15, this.mOrientationHelper.i() - (this.mOrientationHelper.g(r11) + this.mOrientationHelper.e(r10)));
        return;
    L10:
        scrollToPositionWithOffset(r15, this.mOrientationHelper.i() - this.mOrientationHelper.d(r11));
        return;
    L11:
        if (r16 != (-1)) goto L13;
        scrollToPositionWithOffset(r15, this.mOrientationHelper.g(r11));
        return;
    L13:
        scrollToPositionWithOffset(r15, this.mOrientationHelper.d(r11) - this.mOrientationHelper.e(r10));
        return;
    L5:
        r16 = -1;
        goto L7
    }

    public final boolean q(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12) {
        boolean r13 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r14 = getFocusedChild();
        if (r14 != null) goto L8;
    L11:
        boolean r15 = this.mLastStackFromEnd;
        boolean r16 = this.mStackFromEnd;
        if (r15 == r16) goto L14;
        return false;
    L14:
        View r17 = findReferenceChild(r10, r11, r12.f4164d, r16);
        if (r17 == null) goto L35;
        r12.b(r17, getPosition(r17));
        if (r11.f() == false) goto L19;
    L34:
        return true;
    L19:
        if (supportsPredictiveItemAnimations() == false) goto L34;
        int r18 = this.mOrientationHelper.g(r17);
        int r19 = this.mOrientationHelper.d(r17);
        int r20 = this.mOrientationHelper.n();
        int r21 = this.mOrientationHelper.i();
        if (r19 > r20) goto L24;
        if (r18 >= r20) goto L24;
        boolean r22 = true;
    L25:
        if (r18 < r21) goto L28;
        if (r19 <= r21) goto L28;
        r13 = true;
    L28:
        if (r22 == true) goto L31;
        if (r13 == false) goto L34;
    L31:
        if (r12.f4164d == false) goto L33;
        r20 = r21;
    L33:
        r12.f4163c = r20;
    L24:
        r22 = false;
        goto L25
    L35:
        return false;
    L8:
        if (r12.d(r14, r11) == false) goto L11;
        r12.c(r14, getPosition(r14));
        return true;
    }

    public final boolean r(RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = false;
        if (r10.f() == true) goto L60;
        int r13 = this.mPendingScrollPosition;
        if (r13 == (-1)) goto L60;
        if (r13 >= 0) goto L10;
    L59:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r13 >= r10.c()) goto L59;
        r11.f4162b = this.mPendingScrollPosition;
        SavedState r14 = this.mPendingSavedState;
        if (r14 == null) goto L22;
        if (r14.hasValidAnchor() == false) goto L22;
        boolean r15 = this.mPendingSavedState.mAnchorLayoutFromEnd;
        r11.f4164d = r15;
        if (r15 == false) goto L19;
        r11.f4163c = this.mOrientationHelper.i() - this.mPendingSavedState.mAnchorOffset;
    L20:
        return true;
    L19:
        r11.f4163c = this.mOrientationHelper.n() + this.mPendingSavedState.mAnchorOffset;
    L22:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L54;
        View r16 = findViewByPosition(this.mPendingScrollPosition);
        if (r16 == null) goto L43;
        if (this.mOrientationHelper.e(r16) <= this.mOrientationHelper.o()) goto L30;
        r11.a();
        return true;
    L30:
        if ((this.mOrientationHelper.g(r16) - this.mOrientationHelper.n()) >= 0) goto L34;
        r11.f4163c = this.mOrientationHelper.n();
        r11.f4164d = false;
        return true;
    L34:
        if ((this.mOrientationHelper.i() - this.mOrientationHelper.d(r16)) >= 0) goto L38;
        r11.f4163c = this.mOrientationHelper.i();
        r11.f4164d = true;
        return true;
    L38:
        if (r11.f4164d == false) goto L40;
        int r17 = this.mOrientationHelper.d(r16) + this.mOrientationHelper.p();
    L41:
        r11.f4163c = r17;
    L53:
        return true;
    L40:
        r17 = this.mOrientationHelper.g(r16);
        goto L41
    L43:
        if (getChildCount() > 0) goto L45;
    L52:
        r11.a();
        goto L53
    L45:
        if (this.mPendingScrollPosition >= getPosition(getChildAt(0))) goto L47;
        boolean r18 = true;
    L49:
        if (r18 != this.mShouldReverseLayout) goto L51;
        r12 = true;
    L51:
        r11.f4164d = r12;
        goto L52
    L47:
        r18 = false;
        goto L49
    L54:
        boolean r19 = this.mShouldReverseLayout;
        r11.f4164d = r19;
        if (r19 == false) goto L57;
        r11.f4163c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
    L58:
        return true;
    L57:
        r11.f4163c = this.mOrientationHelper.n() + this.mPendingScrollPositionOffset;
    L60:
        return false;
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.l() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrientationHelper.h() != 0) goto L7;
        return true;
    }

    public final void s(RecyclerView.Recycler r10, RecyclerView.State r11, AnchorInfo r12) {
        if (r(r11, r12) == false) goto L6;
        return;
    L6:
        if (q(r10, r11, r12) == false) goto L8;
        return;
    L8:
        r12.a();
        if (this.mStackFromEnd == false) goto L11;
        int r13 = r11.c() - 1;
    L12:
        r12.f4162b = r13;
        return;
    L11:
        r13 = 0;
        goto L12
    }

    public int scrollBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L17;
        if (r10 == 0) goto L17;
        ensureLayoutState();
        this.mLayoutState.f4170a = true;
        if (r10 <= 0) goto L9;
        int r13 = 1;
    L10:
        int r14 = Math.abs(r10);
        t(r13, r14, true, r12);
        LayoutState r15 = this.mLayoutState;
        int r16 = r15.f4176g + fill(r11, r15, r12, false);
        if (r16 >= 0) goto L13;
        return 0;
    L13:
        if (r14 <= r16) goto L15;
        r10 = r13 * r16;
    L15:
        this.mOrientationHelper.s(-r10);
        this.mLayoutState.f4180k = r10;
        return r10;
    L9:
        r13 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (this.mOrientation != 1) goto L7;
        return 0;
    L7:
        return scrollBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r11.invalidateAnchor();
    L5:
        requestLayout();
    }

    public void scrollToPositionWithOffset(int r10, int r11) {
        this.mPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = r11;
        SavedState r12 = this.mPendingSavedState;
        if (r12 == null) goto L5;
        r12.invalidateAnchor();
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (this.mOrientation != 0) goto L7;
        return 0;
    L7:
        return scrollBy(r10, r11, r12);
    }

    public void setInitialPrefetchItemCount(int r10) {
        this.mInitialPrefetchItemCount = r10;
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r10 == this.mOrientation) goto L11;
    L12:
        OrientationHelper r11 = OrientationHelper.b(this, r10);
        this.mOrientationHelper = r11;
        this.mAnchorInfo.f4161a = r11;
        this.mOrientation = r10;
        requestLayout();
        return;
    L11:
        if (this.mOrientationHelper == null) goto L12;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r10);
    }

    public void setRecycleChildrenOnDetach(boolean r10) {
        this.mRecycleChildrenOnDetach = r10;
    }

    public void setReverseLayout(boolean r10) {
        assertNotInLayoutOrScroll(null);
        if (r10 != this.mReverseLayout) goto L5;
        return;
    L5:
        this.mReverseLayout = r10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean r10) {
        this.mSmoothScrollbarEnabled = r10;
    }

    public void setStackFromEnd(boolean r10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != r10) goto L5;
        return;
    L5:
        this.mStackFromEnd = r10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (getWidthMode() == 1073741824) goto L9;
        if (hasFlexibleChildInBothOrientations() == false) goto L9;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        h r13 = new h(r10.getContext());
        r13.setTargetPosition(r12);
        startSmoothScroll(r13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastStackFromEnd != this.mStackFromEnd) goto L7;
        return true;
    }

    public final void t(int r10, int r11, boolean r12, RecyclerView.State r13) {
        this.mLayoutState.f4182m = resolveIsInfinite();
        this.mLayoutState.f4175f = r10;
        int[] r14 = this.mReusableIntPair;
        boolean r15 = false;
        r14[0] = 0;
        int r16 = 1;
        r14[1] = 0;
        calculateExtraLayoutSpace(r13, r14);
        int r17 = Math.max(0, this.mReusableIntPair[0]);
        int r18 = Math.max(0, this.mReusableIntPair[1]);
        if (r10 != 1) goto L5;
        r15 = true;
    L5:
        LayoutState r19 = this.mLayoutState;
        if (r15 == false) goto L8;
        int r20 = r18;
    L9:
        r19.f4177h = r20;
        if (r15 == true) goto L13;
        r17 = r18;
    L13:
        r19.f4178i = r17;
        if (r15 == false) goto L19;
        r19.f4177h = r20 + this.mOrientationHelper.j();
        View r21 = j();
        LayoutState r22 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L18;
        r16 = -1;
    L18:
        r22.f4174e = r16;
        int r23 = getPosition(r21);
        LayoutState r24 = this.mLayoutState;
        r22.f4173d = r23 + r24.f4174e;
        r24.f4171b = this.mOrientationHelper.d(r21);
        int r25 = this.mOrientationHelper.d(r21) - this.mOrientationHelper.i();
    L24:
        LayoutState r26 = this.mLayoutState;
        r26.f4172c = r11;
        if (r12 == false) goto L27;
        r26.f4172c = r11 - r25;
    L27:
        r26.f4176g = r25;
        return;
    L19:
        View r27 = k();
        this.mLayoutState.f4177h += this.mOrientationHelper.n();
        LayoutState r28 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L23;
        r16 = -1;
    L23:
        r28.f4174e = r16;
        int r29 = getPosition(r27);
        LayoutState r30 = this.mLayoutState;
        r28.f4173d = r29 + r30.f4174e;
        r30.f4171b = this.mOrientationHelper.g(r27);
        r25 = (-this.mOrientationHelper.g(r27)) + this.mOrientationHelper.n();
        goto L24
    L8:
        r20 = r17;
        goto L9
    }

    public final void u(int r10, int r11) {
        this.mLayoutState.f4172c = this.mOrientationHelper.i() - r11;
        LayoutState r12 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L5;
        int r13 = -1;
    L6:
        r12.f4174e = r13;
        r12.f4173d = r10;
        r12.f4175f = 1;
        r12.f4171b = r11;
        r12.f4176g = Integer.MIN_VALUE;
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public final void v(AnchorInfo r10) {
        u(r10.f4162b, r10.f4163c);
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean r10 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r11 = getPosition(getChildAt(0));
        int r12 = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout == false) goto L22;
        int r13 = 1;
    L9:
        if (r13 >= getChildCount()) goto L37;
        View r14 = getChildAt(r13);
        int r15 = getPosition(r14);
        int r16 = this.mOrientationHelper.g(r14);
        if (r15 < r11) goto L12;
        if (r16 > r12) goto L20;
        r13 = r13 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r17 = new StringBuilder();
        r17.append("detected invalid position. loc invalid? ");
        if (r16 < r12) goto L16;
        r10 = false;
    L16:
        r17.append(r10);
        throw new RuntimeException(r17.toString());
    L37:
        return;
    L22:
        int r18 = 1;
    L24:
        if (r18 >= getChildCount()) goto L44;
        View r19 = getChildAt(r18);
        int r20 = getPosition(r19);
        int r21 = this.mOrientationHelper.g(r19);
        if (r20 < r11) goto L27;
        if (r21 < r12) goto L35;
        r18 = r18 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r22 = new StringBuilder();
        r22.append("detected invalid position. loc invalid? ");
        if (r21 < r12) goto L31;
        r10 = false;
    L31:
        r22.append(r10);
        throw new RuntimeException(r22.toString());
    }

    public final void w(int r10, int r11) {
        this.mLayoutState.f4172c = r11 - this.mOrientationHelper.n();
        LayoutState r12 = this.mLayoutState;
        r12.f4173d = r10;
        if (this.mShouldReverseLayout == false) goto L5;
        int r13 = 1;
    L6:
        r12.f4174e = r13;
        r12.f4175f = -1;
        r12.f4171b = r11;
        r12.f4176g = Integer.MIN_VALUE;
        return;
    L5:
        r13 = -1;
        goto L6
    }

    public final void x(AnchorInfo r10) {
        w(r10.f4162b, r10.f4163c);
    }

    public LinearLayoutManager(Context r10, int r11, boolean r12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(r11);
        setReverseLayout(r12);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context r10, AttributeSet r11, int r12, int r13) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties r14 = RecyclerView.LayoutManager.getProperties(r10, r11, r12, r13);
        setOrientation(r14.f4197a);
        setReverseLayout(r14.f4199c);
        setStackFromEnd(r14.f4200d);
    }
}
