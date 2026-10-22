package com.android.contacts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import com.android.contacts.PinnedHeaderList.WrapperView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListViewCollapseRunner {
    private static final boolean DEBUG = false;
    private static final long DURATION = 200;
    Paint debugPaint;
    private int endIndex;
    private Animation.AnimationListener mAnimationListener;
    private SparseArray<View> mCachedViews;
    private HashSet<String> mDeletedHeaderSections;
    private int mFirstVisibleItemOffset;
    private boolean mHeaderMode;
    private float mInterpolatedTime;
    private Interpolator mInterpolator;
    private ListView mListView;
    private long mStartTime;
    private VisibleItems mVisibleItems;
    private int startIndex;

    private class VisibleItems {
        private int mFirstVisibleItem;
        private int mItemsCount;
        private int mLastVisibleItem;
        private int mReservedBot;
        private List<Integer> mReservedItems;
        private int mReservedTop;
        private ArrayList<Integer> mVisibleReservedItems;
        final /* synthetic */ ListViewCollapseRunner this$0;

        public VisibleItems(ListViewCollapseRunner r1, int r2, int r3, int r4, List<Integer> r5) {
            this.this$0 = r1;
            this.mVisibleReservedItems = new ArrayList();
            this.mReservedTop = 0;
            this.mReservedBot = 0;
            this.mItemsCount = r4;
            this.mReservedItems = r5;
            reset(r2, r3);
        }

        public void reset(int r2, int r3) {
            this.mFirstVisibleItem = r2;
            this.mLastVisibleItem = r3;
            this.mVisibleReservedItems.clear();
            int r4 = this.mFirstVisibleItem;
        L4:
            if (r4 > this.mLastVisibleItem) goto L9;
            if (this.mReservedItems.contains(Integer.valueOf(r4)) == false) goto L8;
            this.mVisibleReservedItems.add(Integer.valueOf(r4));
        L8:
            r4 = r4 + 1;
            goto L4
        }

        public int getFirstVisibleItem() {
            return this.mFirstVisibleItem;
        }

        public int getLastVisibleItem() {
            return this.mLastVisibleItem;
        }

        public boolean reachTheFirst() {
            if (this.mFirstVisibleItem != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean reachTheLast() {
            if (this.mLastVisibleItem == (this.mItemsCount - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean reservedContains(int r1) {
            return this.mReservedItems.contains(Integer.valueOf(r1));
        }

        public List<Integer> getVislbeItemsList() {
            return this.mVisibleReservedItems;
        }

        public void expandLastVisibleItem() {
            int r0 = getNextReserved(this.mLastVisibleItem);
            if (r0 < 0) goto L5;
            this.mLastVisibleItem = r0;
            this.mVisibleReservedItems.add(Integer.valueOf(r0));
            return;
        L5:
            this.mLastVisibleItem = this.mItemsCount - 1;
        }

        public void expandFirstVisibleItem() {
            if (ListViewCollapseRunner.access$100(this.this$0) == 0) goto L9;
            if (ListViewCollapseRunner.access$200(this.this$0) >= ListViewCollapseRunner.access$300(this.this$0)) goto L7;
            ListViewCollapseRunner r0 = this.this$0;
            ListViewCollapseRunner.access$400(r0, ListViewCollapseRunner.access$200(r0) - ListViewCollapseRunner.access$300(this.this$0));
            return;
        L7:
            ListViewCollapseRunner.access$400(this.this$0, 0);
            return;
        L9:
            if (getFirstVisibleItem() <= 0) goto L18;
            int r1 = getPrevReserved(getFirstVisibleItem());
            if (r1 <= 0) goto L13;
            setFirstVisibleItem(r1);
            this.mVisibleReservedItems.add(0, Integer.valueOf(r1));
        L14:
            ListViewCollapseRunner r2 = this.this$0;
            ListViewCollapseRunner.access$400(r2, -ListViewCollapseRunner.access$500(r2, getFirstVisibleItem()));
            return;
        L13:
            setFirstVisibleItem(0);
            goto L14
        }

        private int getNextReserved(int r6) {
            int r0 = this.mReservedItems.get(this.mReservedBot).intValue();
            int r1 = this.mReservedItems.size();
            if (r0 != r6) goto L11;
            int r7 = this.mReservedBot + 1;
            this.mReservedBot = r7;
            if (r7 < r1) goto L9;
            this.mReservedBot = r1 - 1;
            return -1;
        L9:
            return this.mReservedItems.get(r7).intValue();
        L11:
            if (r6 >= this.mReservedItems.get(0).intValue()) goto L14;
            this.mReservedBot = 0;
            return this.mReservedItems.get(0).intValue();
        L14:
            if (r0 >= r6) goto L22;
            int r2 = this.mReservedBot;
        L16:
            if (r2 >= r1) goto L29;
            int r3 = this.mReservedItems.get(r2).intValue();
            if (r3 > r6) goto L19;
            r2 = r2 + 1;
            goto L16
        L19:
            this.mReservedBot = r2;
            return r3;
        L29:
            return -1;
        L22:
            int r4 = this.mReservedBot;
        L23:
            if (r4 < 0) goto L29;
            if (this.mReservedItems.get(r4).intValue() <= r6) goto L26;
            r4 = r4 - 1;
            goto L23
        L26:
            int r5 = r4 + 1;
            this.mReservedBot = r5;
            return this.mReservedItems.get(r5).intValue();
        }

        private int getPrevReserved(int r5) {
            int r0 = this.mReservedItems.get(this.mReservedTop).intValue();
            if (r0 != r5) goto L10;
            int r6 = this.mReservedTop - 1;
            this.mReservedTop = r6;
            if (r6 >= 0) goto L9;
            this.mReservedTop = 0;
            return -1;
        L9:
            return this.mReservedItems.get(r6).intValue();
        L10:
            List<Integer> r2 = this.mReservedItems;
            if (r5 <= r2.get(r2.size() - 1).intValue()) goto L14;
            int r7 = this.mReservedItems.size() - 1;
            this.mReservedTop = r7;
            return this.mReservedItems.get(r7).intValue();
        L14:
            if (r0 >= r5) goto L22;
            int r1 = this.mReservedItems.size();
            int r3 = this.mReservedTop;
        L16:
            if (r3 >= r1) goto L29;
            if (this.mReservedItems.get(r3).intValue() >= r5) goto L19;
            r3 = r3 + 1;
            goto L16
        L19:
            int r4 = r3 - 1;
            this.mReservedTop = r4;
            return this.mReservedItems.get(r4).intValue();
        L29:
            return -1;
        L22:
            int r8 = this.mReservedTop;
        L23:
            if (r8 < 0) goto L29;
            int r9 = this.mReservedItems.get(r8).intValue();
            if (r9 < r5) goto L26;
            r8 = r8 - 1;
            goto L23
        L26:
            this.mReservedTop = r8;
            return r9;
        }

        private void setFirstVisibleItem(int r1) {
            this.mFirstVisibleItem = r1;
        }
    }

    private void drawDeletedItem(View r1, Canvas r2) {
    }

    static /* synthetic */ Animation.AnimationListener access$000(ListViewCollapseRunner r0) {
        return r0.mAnimationListener;
    }

    static /* synthetic */ int access$100(ListViewCollapseRunner r0) {
        return r0.getFirstItemOffset();
    }

    static /* synthetic */ int access$200(ListViewCollapseRunner r0) {
        return r0.getListHeight();
    }

    static /* synthetic */ int access$300(ListViewCollapseRunner r0) {
        return r0.getVisibleItemsHeight();
    }

    static /* synthetic */ void access$400(ListViewCollapseRunner r0, int r1) {
        r0.setFirstVisibleItemOffset(r1);
    }

    static /* synthetic */ int access$500(ListViewCollapseRunner r0, int r1) {
        return r0.getItemHeight(r1);
    }

    public ListViewCollapseRunner(ListView r8, List<Integer> r9, Animation.AnimationListener r10) {
        this.mHeaderMode = false;
        this.mListView = r8;
        this.mVisibleItems = new VisibleItems(this, this.mListView.getFirstVisiblePosition(), this.mListView.getLastVisiblePosition(), this.mListView.getCount(), r9);
        this.mCachedViews = new SparseArray();
        this.mAnimationListener = r10;
    }

    public void start() {
        resetToInitialState();
        fillViewCache();
        resetToInitialState();
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        onStart();
    }

    private void fillViewCache() {
        setTime(0.0f);
        computeInternal();
    }

    private void resetToInitialState() {
        this.startIndex = this.mListView.getFirstVisiblePosition();
        this.endIndex = this.mListView.getLastVisiblePosition();
        View r0 = this.mListView.getChildAt(0);
        if (r0 == null) goto L5;
        this.mFirstVisibleItemOffset = r0.getTop();
    L5:
        this.mVisibleItems.reset(this.startIndex, this.endIndex);
    }

    private void onStart() {
        Animation.AnimationListener r1 = this.mAnimationListener;
        if (r1 == null) goto L6;
        r1.onAnimationStart(null);
        return;
    }

    public void setInterpolator(Interpolator r1) {
        this.mInterpolator = r1;
    }

    private boolean reachTheEndOfList() {
        return this.mVisibleItems.reachTheLast();
    }

    private boolean reachTheStartOfList() {
        if (this.mVisibleItems.reachTheFirst() == true) goto L5;
    L7:
        return false;
    L5:
        if (getFirstItemOffset() != 0) goto L7;
        return true;
    }

    private int getFirstItemOffset() {
        return this.mFirstVisibleItemOffset;
    }

    public void setTime(float r3) {
        if (r3 <= 1.0f) goto L6;
        this.mInterpolatedTime = 1.0f;
        return;
    L6:
        if (r3 >= 0.0f) goto L8;
        this.mInterpolatedTime = 0.0f;
        return;
    L8:
        Interpolator r0 = this.mInterpolator;
        if (r0 == null) goto L11;
        this.mInterpolatedTime = r0.getInterpolation(r3);
        return;
    L11:
        this.mInterpolatedTime = r3;
    }

    private float getInterpolatedTime() {
        return this.mInterpolatedTime;
    }

    private void setFirstVisibleItemOffset(int r1) {
        this.mFirstVisibleItemOffset = r1;
    }

    private View getItemView(int r5) {
        ListView r0 = this.mListView;
        if (r5 < r0.getFirstVisiblePosition()) goto L9;
        if (r5 > r0.getLastVisiblePosition()) goto L9;
        return r0.getChildAt(r5 - r0.getFirstVisiblePosition());
    L9:
        if (this.mCachedViews.indexOfKey(r5) >= 0) goto L11;
        dumpAdapter(r0.getAdapter());
        View r1 = r0.getAdapter().getView(r5, null, this.mListView);
        r1.measure(View.MeasureSpec.makeMeasureSpec((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r1.layout(0, 0, r1.getMeasuredWidth(), r1.getMeasuredHeight());
        this.mCachedViews.put(r5, r1);
        return r1;
    L11:
        return this.mCachedViews.get(r5);
    }

    private void dumpAdapter(Adapter r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((r2 instanceof WrapperListAdapter) == false) goto L8;
        dumpAdapter(((WrapperListAdapter) r2).getWrappedAdapter());
        return;
    }

    private int getItemHeight(int r4) {
        if (this.mVisibleItems.reservedContains(r4) == true) goto L11;
        View r0 = getItemView(r4);
        if (isHeaderRetain(r0) == false) goto L9;
        return Math.max(Math.round(r0.getMeasuredHeight() * (1.0f - getInterpolatedTime())), ((WrapperView) r0).getHeader().getMeasuredHeight());
    L9:
        return Math.round(getItemView(r4).getMeasuredHeight() * (1.0f - getInterpolatedTime()));
    L11:
        return getItemView(r4).getHeight();
    }

    private int getListHeight() {
        return (this.mListView.getHeight() - this.mListView.getPaddingTop()) - this.mListView.getPaddingBottom();
    }

    public boolean compute() {
        long r0 = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        setTime(r0 / 200.0f);
        computeInternal();
        if (r0 <= 200) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        onEnd();
    L8:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    private void computeInternal() {
    L3:
        if ((getVisibleItemsHeight() + getFirstItemOffset()) >= getListHeight()) goto L10;
        if (reachTheEndOfList() == false) goto L6;
        if (reachTheStartOfList() == true) goto L18;
        this.mVisibleItems.expandFirstVisibleItem();
        goto L3
    L18:
        return;
    L6:
        this.mVisibleItems.expandLastVisibleItem();
        goto L3
    }

    private void onEnd() {
        this.mListView.postOnAnimation(new AnonymousClass1(this));
    }

    private int getVisibleItemsHeight() {
        Iterator<Integer> r0 = this.mVisibleItems.getVislbeItemsList().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + getItemHeight(r0.next().intValue());
        goto L4
    L6:
        return r1;
    }

    public void draw(Canvas r6) {
        int r0 = this.mVisibleItems.getLastVisibleItem();
        r6.save();
        r6.translate(0.0f, getFirstItemOffset());
        int r1 = this.mVisibleItems.getFirstVisibleItem();
    L3:
        if (r1 > r0) goto L17;
        if (this.mVisibleItems.reservedContains(r1) == false) goto L8;
        getItemView(r1).draw(r6);
        r6.translate(0.0f, getItemHeight(r1));
    L16:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r1 < this.startIndex) goto L16;
        if (r1 > this.endIndex) goto L16;
        View r3 = getItemView(r1);
        if (isHeaderRetain(r3) == false) goto L14;
        ((WrapperView) r3).getHeader().draw(r6);
    L15:
        r6.translate(0.0f, getItemHeight(r1));
        goto L16
    L14:
        drawDeletedItem(r3, r6);
        goto L15
    L17:
        r6.restore();
    }

    public void setHeaderMode(boolean r1) {
        this.mHeaderMode = r1;
    }

    public void setDeletedHeaderSection(HashSet<String> r1) {
        this.mDeletedHeaderSections = r1;
    }

    private boolean isHeaderRetain(View r2) {
        if (this.mHeaderMode == false) goto L17;
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2 instanceof WrapperView) == false) goto L22;
        WrapperView r3 = (WrapperView) r2;
        if (r3.hasHeader() == false) goto L23;
        String r4 = (String) r3.getHeader().getTag();
        HashSet<String> r0 = this.mDeletedHeaderSections;
        if (r0 != null) goto L12;
        return true;
    L12:
        if (r0.isEmpty() == false) goto L14;
        return true;
    L14:
        if (this.mDeletedHeaderSections.contains(r4) == true) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L17:
        return false;
    }
}
