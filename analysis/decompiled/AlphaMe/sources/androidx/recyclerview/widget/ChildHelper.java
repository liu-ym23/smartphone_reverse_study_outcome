package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i4) {
            if (i4 < 64) {
                this.mData &= ~(1 << i4);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i4 - 64);
            }
        }

        public int countOnesBefore(int i4) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i4 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(((1 << i4) - 1) & this.mData);
            }
            if (i4 < 64) {
                return Long.bitCount(((1 << i4) - 1) & this.mData);
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(i4 - 64);
        }

        public boolean get(int i4) {
            if (i4 < 64) {
                return ((1 << i4) & this.mData) != 0;
            }
            ensureNext();
            return this.mNext.get(i4 - 64);
        }

        public void insert(int i4, boolean z4) {
            if (i4 >= 64) {
                ensureNext();
                this.mNext.insert(i4 - 64, z4);
                return;
            }
            long j4 = this.mData;
            boolean z5 = (Long.MIN_VALUE & j4) != 0;
            long j5 = (1 << i4) - 1;
            this.mData = ((j4 & (~j5)) << 1) | (j4 & j5);
            if (z4) {
                set(i4);
            } else {
                clear(i4);
            }
            if (z5 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z5);
            }
        }

        public boolean remove(int i4) {
            if (i4 >= 64) {
                ensureNext();
                return this.mNext.remove(i4 - 64);
            }
            long j4 = 1 << i4;
            long j5 = this.mData;
            boolean z4 = (j5 & j4) != 0;
            long j6 = j5 & (~j4);
            this.mData = j6;
            long j7 = j4 - 1;
            this.mData = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z4;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i4) {
            if (i4 < 64) {
                this.mData |= 1 << i4;
            } else {
                ensureNext();
                this.mNext.set(i4 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
        void addView(View view, int i4);

        void attachViewToParent(View view, int i4, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i4);

        View getChildAt(int i4);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i4);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i5 = i4;
        while (i5 < childCount) {
            int iCountOnesBefore = i4 - (i5 - this.mBucket.countOnesBefore(i5));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += iCountOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, boolean z4) {
        addView(view, -1, z4);
    }

    public void attachViewToParent(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z4) {
        int childCount = i4 < 0 ? this.mCallback.getChildCount() : getOffset(i4);
        this.mBucket.insert(childCount, z4);
        if (z4) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i4) {
        int offset = getOffset(i4);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i4) {
        int size = this.mHiddenViews.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mHiddenViews.get(i5);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i4 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i4) {
        return this.mCallback.getChildAt(getOffset(i4));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i4) {
        return this.mCallback.getChildAt(i4);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(iIndexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(iIndexOfChild);
    }

    public void removeViewAt(int i4) {
        int offset = getOffset(i4);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(iIndexOfChild)) {
            return false;
        }
        this.mBucket.remove(iIndexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(iIndexOfChild);
        return true;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(iIndexOfChild)) {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public void addView(View view, int i4, boolean z4) {
        int childCount = i4 < 0 ? this.mCallback.getChildCount() : getOffset(i4);
        this.mBucket.insert(childCount, z4);
        if (z4) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }
}
