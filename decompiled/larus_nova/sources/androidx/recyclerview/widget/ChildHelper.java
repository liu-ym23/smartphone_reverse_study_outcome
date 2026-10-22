package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext != null) goto L6;
            this.mNext = new Bucket();
            return;
        }

        public void reset() {
            this.mData = 0;
            Bucket r100 = this.mNext;
            if (r100 == null) goto L6;
            r100.reset();
            return;
        }

        public String toString() {
            if (this.mNext != null) goto L6;
            return Long.toBinaryString(this.mData);
        L6:
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }

        public Bucket() {
            this.mData = 0;
        }

        public void clear(int r100) {
            if (r100 < 64) goto L7;
            Bucket r101 = this.mNext;
            if (r101 == null) goto L9;
            r101.clear(r100 - 64);
            return;
        L9:
            return;
        L7:
            this.mData &= ~(1 << r100);
        }

        public int countOnesBefore(int r100) {
            Bucket r101 = this.mNext;
            if (r101 != null) goto L9;
            if (r100 < 64) goto L8;
            return Long.bitCount(this.mData);
        L8:
            return Long.bitCount(this.mData & ((1 << r100) - 1));
        L9:
            if (r100 >= 64) goto L13;
            return Long.bitCount(this.mData & ((1 << r100) - 1));
        L13:
            return r101.countOnesBefore(r100 - 64) + Long.bitCount(this.mData);
        }

        public boolean get(int r100) {
            if (r100 < 64) goto L7;
            ensureNext();
            return this.mNext.get(r100 - 64);
        L7:
            if ((this.mData & (1 << r100)) == 0) goto L9;
            return true;
        L9:
            return false;
        }

        public boolean remove(int r110) {
            if (r110 < 64) goto L6;
            ensureNext();
            return this.mNext.remove(r110 - 64);
        L6:
            long r100 = 1 << r110;
            long r101 = this.mData;
            if ((r101 & r100) == 0) goto L9;
            boolean r102 = true;
        L10:
            long r103 = r101 & (~r100);
            this.mData = r103;
            long r104 = r100 - 1;
            this.mData = (r103 & r104) | Long.rotateRight((~r104) & r103, 1);
            Bucket r111 = this.mNext;
            if (r111 != null) goto L13;
        L16:
            return r102;
        L13:
            if (r111.get(0) == false) goto L15;
            set(63);
        L15:
            this.mNext.remove(0);
            goto L16
        L9:
            r102 = false;
            goto L10
        }

        public void set(int r100) {
            if (r100 < 64) goto L5;
            ensureNext();
            this.mNext.set(r100 - 64);
            return;
        L5:
            this.mData |= 1 << r100;
        }

        public void insert(int r110, boolean r111) {
            if (r110 < 64) goto L5;
            ensureNext();
            this.mNext.insert(r110 - 64, r111);
            return;
        L5:
            long r100 = this.mData;
            if ((Long.MIN_VALUE & r100) == 0) goto L8;
            boolean r101 = true;
        L9:
            long r102 = (1 << r110) - 1;
            long r103 = r100 & r102;
            this.mData = ((r100 & (~r102)) << 1) | r103;
            if (r111 == false) goto L12;
            set(r110);
        L13:
            if (r101 == false) goto L15;
        L16:
            ensureNext();
            this.mNext.insert(0, r101);
            return;
        L15:
            if (this.mNext != null) goto L16;
            return;
        L12:
            clear(r110);
            goto L13
        L8:
            r101 = false;
            goto L9
        }
    }

    public interface Callback {
        void addView(View r100, int r101);

        void attachViewToParent(View r100, int r101, ViewGroup.LayoutParams r102);

        void detachViewFromParent(int r100);

        View getChildAt(int r100);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View r100);

        int indexOfChild(View r100);

        void onEnteredHiddenState(View r100);

        void onLeftHiddenState(View r100);

        void removeAllViews();

        void removeViewAt(int r100);
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        int r100 = this.mHiddenViews.size() - 1;
    L3:
        if (r100 < 0) goto L5;
        this.mCallback.onLeftHiddenState((View) ListProtector.get(this.mHiddenViews, r100));
        ListProtector.remove(this.mHiddenViews, r100);
        r100 = r100 - 1;
        goto L3
    L5:
        this.mCallback.removeAllViews();
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public ChildHelper(Callback r100) {
        this.mCallback = r100;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int r100) {
        if (r100 >= 0) goto L5;
        return -1;
    L5:
        int r101 = this.mCallback.getChildCount();
        int r102 = r100;
    L6:
        if (r102 >= r101) goto L14;
        int r103 = r100 - (r102 - this.mBucket.countOnesBefore(r102));
        if (r103 == 0) goto L10;
        r102 = r102 + r103;
    L10:
        if (this.mBucket.get(r102) == false) goto L12;
        r102 = r102 + 1;
        goto L10
    L12:
        return r102;
    L14:
        return -1;
    }

    private void hideViewInternal(View r100) {
        this.mHiddenViews.add(r100);
        this.mCallback.onEnteredHiddenState(r100);
    }

    private boolean unhideViewInternal(View r100) {
        if (this.mHiddenViews.remove(r100) == false) goto L6;
        this.mCallback.onLeftHiddenState(r100);
        return true;
    L6:
        return false;
    }

    public void detachViewFromParent(int r100) {
        int r101 = getOffset(r100);
        this.mBucket.remove(r101);
        this.mCallback.detachViewFromParent(r101);
    }

    public View findHiddenNonRemovedView(int r100) {
        int r101 = this.mHiddenViews.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        View r103 = (View) ListProtector.get(this.mHiddenViews, r102);
        RecyclerView.ViewHolder r104 = this.mCallback.getChildViewHolder(r103);
        if (r104.getLayoutPosition() != r100) goto L11;
        if (r104.isInvalid() == true) goto L11;
        if (r104.isRemoved() == true) goto L11;
        return r103;
    L11:
        r102 = r102 + 1;
        goto L3
    L12:
        return null;
    }

    public View getChildAt(int r100) {
        int r101 = getOffset(r100);
        return this.mCallback.getChildAt(r101);
    }

    public View getUnfilteredChildAt(int r100) {
        return this.mCallback.getChildAt(r100);
    }

    public void hide(View r100) {
        int r101 = this.mCallback.indexOfChild(r100);
        if (r101 < 0) goto L7;
        this.mBucket.set(r101);
        hideViewInternal(r100);
        return;
    L7:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r100);
    }

    public int indexOfChild(View r100) {
        int r101 = this.mCallback.indexOfChild(r100);
        if (r101 != (-1)) goto L6;
        return -1;
    L6:
        if (this.mBucket.get(r101) == false) goto L9;
        return -1;
    L9:
        return r101 - this.mBucket.countOnesBefore(r101);
    }

    public boolean isHidden(View r100) {
        return this.mHiddenViews.contains(r100);
    }

    public void removeView(View r100) {
        int r101 = this.mCallback.indexOfChild(r100);
        if (r101 >= 0) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r101) == false) goto L8;
        unhideViewInternal(r100);
    L8:
        this.mCallback.removeViewAt(r101);
    }

    public void removeViewAt(int r100) {
        int r101 = getOffset(r100);
        View r102 = this.mCallback.getChildAt(r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.mBucket.remove(r101) == false) goto L8;
        unhideViewInternal(r102);
    L8:
        this.mCallback.removeViewAt(r101);
    }

    public boolean removeViewIfHidden(View r100) {
        int r101 = this.mCallback.indexOfChild(r100);
        if (r101 != (-1)) goto L7;
        unhideViewInternal(r100);
        return true;
    L7:
        if (this.mBucket.get(r101) == false) goto L10;
        this.mBucket.remove(r101);
        unhideViewInternal(r100);
        this.mCallback.removeViewAt(r101);
        return true;
    L10:
        return false;
    }

    public void unhide(View r100) {
        int r101 = this.mCallback.indexOfChild(r100);
        if (r101 < 0) goto L11;
        if (this.mBucket.get(r101) == false) goto L9;
        this.mBucket.clear(r101);
        unhideViewInternal(r100);
        return;
    L9:
        throw new RuntimeException("trying to unhide a view that was not hidden" + r100);
    L11:
        throw new IllegalArgumentException("view is not a child, cannot hide " + r100);
    }

    public void addView(View r100, boolean r101) {
        addView(r100, -1, r101);
    }

    public void addView(View r100, int r101, boolean r102) {
        if (r101 >= 0) goto L4;
        int r103 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r103, r102);
        if (r102 == false) goto L8;
        hideViewInternal(r100);
    L8:
        this.mCallback.addView(r100, r103);
        return;
    L4:
        r103 = getOffset(r101);
        goto L5
    }

    public void attachViewToParent(View r100, int r101, ViewGroup.LayoutParams r102, boolean r103) {
        if (r101 >= 0) goto L4;
        int r104 = this.mCallback.getChildCount();
    L5:
        this.mBucket.insert(r104, r103);
        if (r103 == false) goto L8;
        hideViewInternal(r100);
    L8:
        this.mCallback.attachViewToParent(r100, r104, r102);
        return;
    L4:
        r104 = getOffset(r101);
        goto L5
    }
}
