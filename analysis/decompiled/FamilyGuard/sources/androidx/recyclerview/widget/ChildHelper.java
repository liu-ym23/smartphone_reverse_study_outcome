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

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i5) {
            if (i5 < BITS_PER_WORD) {
                this.mData &= ~(1 << i5);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i5 - BITS_PER_WORD);
            }
        }

        int countOnesBefore(int i5) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i5 >= BITS_PER_WORD) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(((1 << i5) - 1) & this.mData);
            }
            if (i5 >= BITS_PER_WORD) {
                return bucket.countOnesBefore(i5 - BITS_PER_WORD) + Long.bitCount(this.mData);
            }
            return Long.bitCount(((1 << i5) - 1) & this.mData);
        }

        boolean get(int i5) {
            if (i5 < BITS_PER_WORD) {
                return ((1 << i5) & this.mData) != 0;
            }
            ensureNext();
            return this.mNext.get(i5 - BITS_PER_WORD);
        }

        void insert(int i5, boolean z5) {
            if (i5 >= BITS_PER_WORD) {
                ensureNext();
                this.mNext.insert(i5 - BITS_PER_WORD, z5);
                return;
            }
            long j5 = this.mData;
            boolean z6 = (LAST_BIT & j5) != 0;
            long j6 = (1 << i5) - 1;
            this.mData = ((j5 & (~j6)) << 1) | (j5 & j6);
            if (z5) {
                set(i5);
            } else {
                clear(i5);
            }
            if (z6 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z6);
            }
        }

        boolean remove(int i5) {
            if (i5 >= BITS_PER_WORD) {
                ensureNext();
                return this.mNext.remove(i5 - BITS_PER_WORD);
            }
            long j5 = 1 << i5;
            long j6 = this.mData;
            boolean z5 = (j6 & j5) != 0;
            long j7 = j6 & (~j5);
            this.mData = j7;
            long j8 = j5 - 1;
            this.mData = (j7 & j8) | Long.rotateRight((~j8) & j7, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z5;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i5) {
            if (i5 < BITS_PER_WORD) {
                this.mData |= 1 << i5;
            } else {
                ensureNext();
                this.mNext.set(i5 - BITS_PER_WORD);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    interface Callback {
        void addView(View view, int i5);

        void attachViewToParent(View view, int i5, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i5);

        View getChildAt(int i5);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i5);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i5) {
        if (i5 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i6 = i5;
        while (i6 < childCount) {
            int iCountOnesBefore = i5 - (i6 - this.mBucket.countOnesBefore(i6));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i6)) {
                    i6++;
                }
                return i6;
            }
            i6 += iCountOnesBefore;
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

    void addView(View view, boolean z5) {
        addView(view, -1, z5);
    }

    void attachViewToParent(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z5) {
        int childCount = i5 < 0 ? this.mCallback.getChildCount() : getOffset(i5);
        this.mBucket.insert(childCount, z5);
        if (z5) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    void detachViewFromParent(int i5) {
        int offset = getOffset(i5);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    View findHiddenNonRemovedView(int i5) {
        int size = this.mHiddenViews.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.mHiddenViews.get(i6);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i5 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View getChildAt(int i5) {
        return this.mCallback.getChildAt(getOffset(i5));
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int i5) {
        return this.mCallback.getChildAt(i5);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    void removeView(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(iIndexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(iIndexOfChild);
    }

    void removeViewAt(int i5) {
        int offset = getOffset(i5);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    boolean removeViewIfHidden(View view) {
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

    void unhide(View view) {
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

    void addView(View view, int i5, boolean z5) {
        int childCount = i5 < 0 ? this.mCallback.getChildCount() : getOffset(i5);
        this.mBucket.insert(childCount, z5);
        if (z5) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }
}
