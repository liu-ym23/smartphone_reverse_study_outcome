package com.alibaba.android.vlayout;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        static final int TYPE_ADD = 1;
        static final int TYPE_CHANGE = 3;
        static final int TYPE_MOVE = 4;
        static final int TYPE_NONE = 0;
        static final int TYPE_REMOVE = 2;
        int mLastEventCount;
        int mLastEventPosition;
        int mLastEventType;
        private final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> r10) {
            this.mLastEventType = 0;
            this.mLastEventPosition = -1;
            this.mLastEventCount = -1;
            this.mWrappedCallback = r10;
        }

        public static /* synthetic */ Callback access$000(BatchedCallback r10) {
            return r10.mWrappedCallback;
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public boolean areContentsTheSame(T2 r10, T2 r11) {
            return this.mWrappedCallback.areContentsTheSame(r10, r11);
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public boolean areItemsTheSame(T2 r10, T2 r11) {
            return this.mWrappedCallback.areItemsTheSame(r10, r11);
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public int compare(T2 r10, T2 r11) {
            return this.mWrappedCallback.compare(r10, r11);
        }

        public void dispatchLastEvent() {
            int r10 = this.mLastEventType;
            if (r10 != 0) goto L6;
            return;
        L6:
            if (r10 != 1) goto L8;
            this.mWrappedCallback.onInserted(this.mLastEventPosition, this.mLastEventCount);
        L15:
            this.mLastEventType = 0;
            return;
        L8:
            if (r10 != 2) goto L10;
            this.mWrappedCallback.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            goto L15
        L10:
            if (r10 != 3) goto L15;
            this.mWrappedCallback.onChanged(this.mLastEventPosition, this.mLastEventCount);
            goto L15
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public void onChanged(int r10, int r11) {
            if (this.mLastEventType != 3) goto L10;
            int r12 = this.mLastEventPosition;
            int r13 = this.mLastEventCount;
            if (r10 > (r12 + r13)) goto L10;
            int r14 = r10 + r11;
            if (r14 < r12) goto L10;
            this.mLastEventPosition = Math.min(r10, r12);
            this.mLastEventCount = Math.max(r13 + r12, r14) - this.mLastEventPosition;
            return;
        L10:
            dispatchLastEvent();
            this.mLastEventPosition = r10;
            this.mLastEventCount = r11;
            this.mLastEventType = 3;
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public void onInserted(int r10, int r11) {
            if (this.mLastEventType != 1) goto L10;
            int r12 = this.mLastEventPosition;
            if (r10 < r12) goto L10;
            int r13 = this.mLastEventCount;
            if (r10 > (r12 + r13)) goto L10;
            this.mLastEventCount = r13 + r11;
            this.mLastEventPosition = Math.min(r10, r12);
            return;
        L10:
            dispatchLastEvent();
            this.mLastEventPosition = r10;
            this.mLastEventCount = r11;
            this.mLastEventType = 1;
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public void onMoved(int r10, int r11) {
            dispatchLastEvent();
            this.mWrappedCallback.onMoved(r10, r11);
        }

        @Override // com.alibaba.android.vlayout.SortedList.Callback
        public void onRemoved(int r10, int r11) {
            if (this.mLastEventType == 2) goto L5;
        L8:
            dispatchLastEvent();
            this.mLastEventPosition = r10;
            this.mLastEventCount = r11;
            this.mLastEventType = 2;
            return;
        L5:
            if (this.mLastEventPosition != r10) goto L8;
            this.mLastEventCount += r11;
        }
    }

    public static abstract class Callback<T2> {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(T2 r10, T2 r11);

        public abstract boolean areItemsTheSame(T2 r10, T2 r11);

        public abstract int compare(T2 r10, T2 r11);

        public abstract void onChanged(int r10, int r11);

        public abstract void onInserted(int r10, int r11);

        public abstract void onMoved(int r10, int r11);

        public abstract void onRemoved(int r10, int r11);
    }

    public SortedList(Class<T> r10, Callback<T> r11) {
        this(r10, r11, 10);
    }

    private void addToData(int r10, T r11) {
        int r12 = this.mSize;
        if (r10 > r12) goto L11;
        T[] r13 = this.mData;
        if (r12 != r13.length) goto L7;
        T[] r14 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r13.length + 10));
        System.arraycopy(this.mData, 0, r14, 0, r10);
        r14[r10] = r11;
        System.arraycopy(this.mData, r10, r14, r10 + 1, this.mSize - r10);
        this.mData = r14;
    L8:
        this.mSize++;
        return;
    L7:
        System.arraycopy(r13, r10, r13, r10 + 1, r12 - r10);
        this.mData[r10] = r11;
        goto L8
    L11:
        throw new IndexOutOfBoundsException("cannot add item to " + r10 + " because size is " + this.mSize);
    }

    private int findIndexOf(T r10, int r11) {
        int r12 = this.mSize;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L20;
        int r14 = (r13 + r12) / 2;
        T r15 = this.mData[r14];
        int r16 = this.mCallback.compare(r15, r10);
        if (r16 < 0) goto L7;
        if (r16 == 0) goto L10;
        r12 = r14;
        goto L4
    L10:
        if (this.mCallback.areItemsTheSame(r15, r10) == false) goto L12;
        return r14;
    L12:
        int r17 = linearEqualitySearch(r10, r14, r13, r12);
        if (r11 != 1) goto L18;
        if (r17 != (-1)) goto L17;
        return r14;
    L17:
        return r17;
    L18:
        return r17;
    L7:
        r13 = r14 + 1;
        goto L4
    L20:
        if (r11 != 1) goto L23;
        return r13;
    L23:
        return -1;
    }

    private int linearEqualitySearch(T r10, int r11, int r12, int r13) {
        int r14 = r11 - 1;
    L3:
        if (r14 < r12) goto L11;
        T r15 = this.mData[r14];
        if (this.mCallback.compare(r15, r10) != 0) goto L11;
        if (this.mCallback.areItemsTheSame(r15, r10) == true) goto L9;
        r14 = r14 - 1;
        goto L3
    L9:
        return r14;
    L11:
        r11 = r11 + 1;
        if (r11 >= r13) goto L19;
        T r16 = this.mData[r11];
        if (this.mCallback.compare(r16, r10) != 0) goto L29;
        if (this.mCallback.areItemsTheSame(r16, r10) == false) goto L11;
        return r11;
    L29:
        return -1;
    L19:
        return -1;
    }

    private void removeItemAtIndex(int r10, boolean r11) {
        T[] r12 = this.mData;
        System.arraycopy(r12, r10 + 1, r12, r10, (this.mSize - r10) - 1);
        int r13 = this.mSize - 1;
        this.mSize = r13;
        this.mData[r13] = null;
        if (r11 == false) goto L6;
        this.mCallback.onRemoved(r10, 1);
        return;
    }

    public int add(T r10) {
        return add(r10, true);
    }

    public void beginBatchedUpdates() {
        Callback r10 = this.mCallback;
        if ((r10 instanceof BatchedCallback) == false) goto L6;
        return;
    L6:
        if (this.mBatchedCallback != null) goto L8;
        this.mBatchedCallback = new BatchedCallback(r10);
    L8:
        this.mCallback = this.mBatchedCallback;
    }

    public void endBatchedUpdates() {
        Callback r10 = this.mCallback;
        if ((r10 instanceof BatchedCallback) == false) goto L5;
        ((BatchedCallback) r10).dispatchLastEvent();
    L5:
        Callback r11 = this.mCallback;
        BatchedCallback r12 = this.mBatchedCallback;
        if (r11 != r12) goto L9;
        this.mCallback = BatchedCallback.access$000(r12);
        return;
    }

    public T get(int r10) throws IndexOutOfBoundsException {
        if (r10 >= this.mSize) goto L8;
        if (r10 < 0) goto L8;
        return this.mData[r10];
    L8:
        throw new IndexOutOfBoundsException("Asked to get item at " + r10 + " but size is " + this.mSize);
    }

    public int indexOf(T r10) {
        return findIndexOf(r10, 4);
    }

    public void recalculatePositionOfItemAt(int r10) {
        T r11 = get(r10);
        removeItemAtIndex(r10, false);
        int r12 = add(r11, false);
        if (r10 == r12) goto L6;
        this.mCallback.onMoved(r10, r12);
        return;
    }

    public boolean remove(T r10) {
        return remove(r10, true);
    }

    public T removeItemAt(int r10) {
        T r11 = get(r10);
        removeItemAtIndex(r10, true);
        return r11;
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int r10, T r11) {
        T r12 = get(r10);
        if (r12 != r11) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r12 != r11) goto L11;
    L16:
        if (r13 == false) goto L18;
        this.mCallback.onChanged(r10, 1);
    L18:
        removeItemAtIndex(r10, false);
        int r14 = add(r11, false);
        if (r10 == r14) goto L23;
        this.mCallback.onMoved(r10, r14);
        return;
    L23:
        return;
    L11:
        if (this.mCallback.compare(r12, r11) != 0) goto L16;
        this.mData[r10] = r11;
        if (r13 == false) goto L22;
        this.mCallback.onChanged(r10, 1);
        return;
    L22:
        return;
    L5:
        if (this.mCallback.areContentsTheSame(r12, r11) == false) goto L8;
        r13 = false;
        goto L9
    }

    public SortedList(Class<T> r10, Callback<T> r11, int r12) {
        this.mTClass = r10;
        this.mData = (T[]) ((Object[]) Array.newInstance(r10, r12));
        this.mCallback = r11;
        this.mSize = 0;
    }

    private int add(T r10, boolean r11) {
        int r12 = findIndexOf(r10, 1);
        if (r12 != (-1)) goto L6;
        r12 = 0;
    L15:
        addToData(r12, r10);
        if (r11 == false) goto L18;
        this.mCallback.onInserted(r12, 1);
    L18:
        return r12;
    L6:
        if (r12 >= this.mSize) goto L15;
        T r13 = this.mData[r12];
        if (this.mCallback.areItemsTheSame(r13, r10) == false) goto L15;
        if (this.mCallback.areContentsTheSame(r13, r10) == false) goto L13;
        this.mData[r12] = r10;
        return r12;
    L13:
        this.mData[r12] = r10;
        this.mCallback.onChanged(r12, 1);
        return r12;
    }

    private boolean remove(T r10, boolean r11) {
        int r12 = findIndexOf(r10, 2);
        if (r12 != (-1)) goto L6;
        return false;
    L6:
        removeItemAtIndex(r12, r11);
        return true;
    }
}
