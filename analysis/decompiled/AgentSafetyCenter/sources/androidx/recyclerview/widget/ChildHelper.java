package androidx.recyclerview.widget;

import ad.o;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import g5.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        public void clear(int i) {
            if (i < 64) {
                this.mData &= ~(1 << i);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i - 64);
            }
        }

        public int countOnesBefore(int i) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                long j10 = this.mData;
                return i >= 64 ? Long.bitCount(j10) : Long.bitCount(((1 << i) - 1) & j10);
            }
            if (i < 64) {
                return Long.bitCount(((1 << i) - 1) & this.mData);
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(i - 64);
        }

        public boolean get(int i) {
            if (i < 64) {
                return ((1 << i) & this.mData) != 0;
            }
            ensureNext();
            return this.mNext.get(i - 64);
        }

        public void insert(int i, boolean z10) {
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z10);
                return;
            }
            long j10 = this.mData;
            boolean z11 = (LAST_BIT & j10) != 0;
            long j11 = (1 << i) - 1;
            this.mData = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                set(i);
            } else {
                clear(i);
            }
            if (z11 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z11);
            }
        }

        public boolean remove(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j10 = 1 << i;
            long j11 = this.mData;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.mData = j12;
            long j13 = j10 - 1;
            this.mData = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z10;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i) {
            if (i < 64) {
                this.mData |= 1 << i;
            } else {
                ensureNext();
                this.mNext.set(i - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Callback {
        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i3 = i;
        while (i3 < childCount) {
            int iCountOnesBefore = i - (i3 - this.mBucket.countOnesBefore(i3));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iCountOnesBefore;
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

    public void addView(View view, int i, boolean z10) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int childCount = i < 0 ? this.mCallback.getChildCount() : getOffset(i);
        this.mBucket.insert(childCount, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i) {
        int size = this.mHiddenViews.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.mHiddenViews.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i) {
        return this.mCallback.getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i) {
        return this.mCallback.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            f.p(view, "view is not a child, cannot hide ");
        } else {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
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
        int size = this.mHiddenViews.size();
        while (true) {
            size--;
            Callback callback = this.mCallback;
            if (size < 0) {
                callback.removeAllViews();
                return;
            } else {
                callback.onLeftHiddenState(this.mHiddenViews.get(size));
                this.mHiddenViews.remove(size);
            }
        }
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

    public void removeViewAt(int i) {
        int offset = getOffset(i);
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
            f.p(view, "view is not a child, cannot hide ");
        } else if (!this.mBucket.get(iIndexOfChild)) {
            o.k(view, "trying to unhide a view that was not hidden");
        } else {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        }
    }

    public void addView(View view, boolean z10) {
        addView(view, -1, z10);
    }
}
