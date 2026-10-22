package androidx.recyclerview.widget;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes17.dex */
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
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        public BatchedCallback(Callback<T2> r100) {
            this.mWrappedCallback = r100;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(r100);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 r100, T2 r101) {
            return this.mWrappedCallback.areContentsTheSame(r100, r101);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 r100, T2 r101) {
            return this.mWrappedCallback.areItemsTheSame(r100, r101);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 r100, T2 r101) {
            return this.mWrappedCallback.compare(r100, r101);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public Object getChangePayload(T2 r100, T2 r101) {
            return this.mWrappedCallback.getChangePayload(r100, r101);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int r100, int r101) {
            this.mBatchingListUpdateCallback.onChanged(r100, r101, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r100, int r101) {
            this.mBatchingListUpdateCallback.onInserted(r100, r101);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r100, int r101) {
            this.mBatchingListUpdateCallback.onMoved(r100, r101);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r100, int r101) {
            this.mBatchingListUpdateCallback.onRemoved(r100, r101);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r100, int r101, Object r102) {
            this.mBatchingListUpdateCallback.onChanged(r100, r101, r102);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(T2 r100, T2 r101);

        public abstract boolean areItemsTheSame(T2 r100, T2 r101);

        @Override // java.util.Comparator
        public abstract int compare(T2 r100, T2 r101);

        public Object getChangePayload(T2 r100, T2 r101) {
            return null;
        }

        public abstract void onChanged(int r100, int r101);

        public void onChanged(int r100, int r101, Object r102) {
            onChanged(r100, r101);
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r100 = this.mCallback;
        if ((r100 instanceof BatchedCallback) == false) goto L6;
        return;
    L6:
        if (this.mBatchedCallback != null) goto L8;
        this.mBatchedCallback = new BatchedCallback(r100);
    L8:
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int r100 = this.mSize;
        if (r100 != 0) goto L5;
        return;
    L5:
        Arrays.fill(this.mData, 0, r100, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, r100);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback r100 = this.mCallback;
        if ((r100 instanceof BatchedCallback) == false) goto L5;
        ((BatchedCallback) r100).dispatchLastEvent();
    L5:
        Callback r101 = this.mCallback;
        BatchedCallback r102 = this.mBatchedCallback;
        if (r101 != r102) goto L9;
        this.mCallback = r102.mWrappedCallback;
        return;
    }

    public int size() {
        return this.mSize;
    }

    private void addAllInternal(T[] r100) {
        if (r100.length >= 1) goto L5;
        return;
    L5:
        int r101 = sortAndDedup(r100);
        if (this.mSize != 0) goto L8;
        this.mData = r100;
        this.mSize = r101;
        this.mCallback.onInserted(0, r101);
        return;
    L8:
        merge(r100, r101);
    }

    private T[] copyArray(T[] r100) {
        T[] r101 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r100.length));
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    private void replaceAllInsert(T r100) {
        T[] r101 = this.mData;
        int r102 = this.mNewDataStart;
        r101[r102] = r100;
        int r103 = r102 + 1;
        this.mNewDataStart = r103;
        this.mSize++;
        this.mCallback.onInserted(r103 - 1, 1);
    }

    private void replaceAllInternal(T[] r100) {
        boolean r101 = !(this.mCallback instanceof BatchedCallback);
        if (r101 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int r102 = sortAndDedup(r100);
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, r102));
    L6:
        int r103 = this.mNewDataStart;
        if (r103 >= r102) goto L9;
    L10:
        int r104 = this.mOldDataStart;
        int r105 = this.mOldDataSize;
        if (r104 >= r105) goto L12;
        if (r103 >= r102) goto L14;
        T r106 = this.mOldData[r104];
        T r107 = r100[r103];
        int r108 = this.mCallback.compare(r106, r107);
        if (r108 < 0) goto L21;
        if (r108 > 0) goto L23;
        if (this.mCallback.areItemsTheSame(r106, r107) == false) goto L26;
        T[] r109 = this.mData;
        int r110 = this.mNewDataStart;
        r109[r110] = r107;
        this.mOldDataStart++;
        this.mNewDataStart = r110 + 1;
        if (this.mCallback.areContentsTheSame(r106, r107) == true) goto L6;
        Callback r111 = this.mCallback;
        r111.onChanged(this.mNewDataStart - 1, 1, r111.getChangePayload(r106, r107));
        goto L6
    L26:
        replaceAllRemove();
        replaceAllInsert(r107);
        goto L6
    L23:
        replaceAllInsert(r107);
        goto L6
    L21:
        replaceAllRemove();
        goto L6
    L14:
        int r112 = r105 - r104;
        this.mSize -= r112;
        this.mCallback.onRemoved(r103, r112);
    L15:
        this.mOldData = null;
        if (r101 == false) goto L46;
        endBatchedUpdates();
        return;
    L46:
        return;
    L12:
        int r113 = r102 - r103;
        System.arraycopy(r100, r103, this.mData, r103, r113);
        this.mNewDataStart += r113;
        this.mSize += r113;
        this.mCallback.onInserted(r103, r113);
        goto L15
    L9:
        if (this.mOldDataStart >= this.mOldDataSize) goto L15;
        goto L10
    }

    private int sortAndDedup(T[] r100) {
        if (r100.length != 0) goto L5;
        return 0;
    L5:
        Arrays.sort(r100, this.mCallback);
        int r101 = 1;
        int r102 = 1;
        int r103 = 0;
    L7:
        if (r101 >= r100.length) goto L20;
        T r104 = r100[r101];
        if (this.mCallback.compare(r100[r103], r104) != 0) goto L16;
        int r105 = findSameItem(r104, r100, r103, r102);
        if (r105 == (-1)) goto L13;
        r100[r105] = r104;
    L19:
        r101 = r101 + 1;
        goto L7
    L13:
        if (r102 == r101) goto L15;
        r100[r102] = r104;
    L15:
        r102 = r102 + 1;
        goto L19
    L16:
        if (r102 == r101) goto L18;
        r100[r102] = r104;
    L18:
        r103 = r102;
        r102 = r102 + 1;
        goto L19
    L20:
        return r102;
    }

    public int add(T r100) {
        throwIfInMutationOperation();
        return add(r100, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> r100) {
        addAll(r100.toArray((Object[]) Array.newInstance(this.mTClass, r100.size())), true);
    }

    public T get(int r100) throws IndexOutOfBoundsException {
        if (r100 >= this.mSize) goto L14;
        if (r100 < 0) goto L14;
        T[] r101 = this.mOldData;
        if (r101 == null) goto L12;
        int r102 = this.mNewDataStart;
        if (r100 < r102) goto L12;
        return r101[(r100 - r102) + this.mOldDataStart];
    L12:
        return this.mData[r100];
    L14:
        throw new IndexOutOfBoundsException("Asked to get item at " + r100 + " but size is " + this.mSize);
    }

    public int indexOf(T r100) {
        if (this.mOldData == null) goto L13;
        int r101 = findIndexOf(r100, this.mData, 0, this.mNewDataStart, 4);
        if (r101 == (-1)) goto L7;
        return r101;
    L7:
        int r102 = findIndexOf(r100, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (r102 != (-1)) goto L10;
        return -1;
    L10:
        return (r102 - this.mOldDataStart) + this.mNewDataStart;
    L13:
        return findIndexOf(r100, this.mData, 0, this.mSize, 4);
    }

    public void recalculatePositionOfItemAt(int r100) {
        throwIfInMutationOperation();
        T r101 = get(r100);
        removeItemAtIndex(r100, false);
        int r102 = add(r101, false);
        if (r100 == r102) goto L6;
        this.mCallback.onMoved(r100, r102);
        return;
    }

    public boolean remove(T r100) {
        throwIfInMutationOperation();
        return remove(r100, true);
    }

    public T removeItemAt(int r100) {
        throwIfInMutationOperation();
        T r101 = get(r100);
        removeItemAtIndex(r100, true);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(Collection<T> r100) {
        replaceAll(r100.toArray((Object[]) Array.newInstance(this.mTClass, r100.size())), true);
    }

    public void addAll(T... r100) {
        addAll(r100, false);
    }

    public void replaceAll(T... r100) {
        replaceAll(r100, false);
    }

    public SortedList(Class<T> r100, Callback<T> r101) {
        this(r100, r101, 10);
    }

    private int add(T r100, boolean r101) {
        int r102 = findIndexOf(r100, this.mData, 0, this.mSize, 1);
        if (r102 != (-1)) goto L6;
        r102 = 0;
    L15:
        addToData(r102, r100);
        if (r101 == false) goto L18;
        this.mCallback.onInserted(r102, 1);
    L18:
        return r102;
    L6:
        if (r102 >= this.mSize) goto L15;
        T r103 = this.mData[r102];
        if (this.mCallback.areItemsTheSame(r103, r100) == false) goto L15;
        if (this.mCallback.areContentsTheSame(r103, r100) == false) goto L13;
        this.mData[r102] = r100;
        return r102;
    L13:
        this.mData[r102] = r100;
        Callback r104 = this.mCallback;
        r104.onChanged(r102, 1, r104.getChangePayload(r103, r100));
        return r102;
    }

    private void addToData(int r100, T r101) {
        int r102 = this.mSize;
        if (r100 > r102) goto L11;
        T[] r103 = this.mData;
        if (r102 != r103.length) goto L7;
        T[] r104 = (T[]) ((Object[]) Array.newInstance(this.mTClass, r103.length + 10));
        System.arraycopy(this.mData, 0, r104, 0, r100);
        r104[r100] = r101;
        System.arraycopy(this.mData, r100, r104, r100 + 1, this.mSize - r100);
        this.mData = r104;
    L8:
        this.mSize++;
        return;
    L7:
        System.arraycopy(r103, r100, r103, r100 + 1, r102 - r100);
        this.mData[r100] = r101;
        goto L8
    L11:
        throw new IndexOutOfBoundsException("cannot add item to " + r100 + " because size is " + this.mSize);
    }

    private void merge(T[] r100, int r110) {
        boolean r101 = !(this.mCallback instanceof BatchedCallback);
        if (r101 == false) goto L5;
        beginBatchedUpdates();
    L5:
        this.mOldData = this.mData;
        int r102 = 0;
        this.mOldDataStart = 0;
        int r103 = this.mSize;
        this.mOldDataSize = r103;
        this.mData = (T[]) ((Object[]) Array.newInstance(this.mTClass, (r103 + r110) + 10));
        this.mNewDataStart = 0;
    L6:
        int r104 = this.mOldDataStart;
        int r105 = this.mOldDataSize;
        if (r104 < r105) goto L9;
        if (r102 < r110) goto L9;
    L13:
        this.mOldData = null;
        if (r101 == false) goto L41;
        endBatchedUpdates();
        return;
    L41:
        return;
    L9:
        if (r104 == r105) goto L10;
        if (r102 == r110) goto L12;
        T r106 = this.mOldData[r104];
        T r107 = r100[r102];
        int r108 = this.mCallback.compare(r106, r107);
        if (r108 > 0) goto L19;
        if (r108 != 0) goto L26;
        if (this.mCallback.areItemsTheSame(r106, r107) == false) goto L26;
        T[] r109 = this.mData;
        int r111 = this.mNewDataStart;
        this.mNewDataStart = r111 + 1;
        r109[r111] = r107;
        r102 = r102 + 1;
        this.mOldDataStart++;
        if (this.mCallback.areContentsTheSame(r106, r107) == true) goto L6;
        Callback r112 = this.mCallback;
        r112.onChanged(this.mNewDataStart - 1, 1, r112.getChangePayload(r106, r107));
    L26:
        T[] r113 = this.mData;
        int r114 = this.mNewDataStart;
        this.mNewDataStart = r114 + 1;
        r113[r114] = r106;
        this.mOldDataStart++;
        goto L6
    L19:
        T[] r115 = this.mData;
        int r116 = this.mNewDataStart;
        int r117 = r116 + 1;
        this.mNewDataStart = r117;
        r115[r116] = r107;
        this.mSize++;
        r102 = r102 + 1;
        this.mCallback.onInserted(r117 - 1, 1);
        goto L6
    L12:
        int r118 = r105 - r104;
        System.arraycopy(this.mOldData, r104, this.mData, this.mNewDataStart, r118);
        this.mNewDataStart += r118;
        goto L13
    L10:
        int r119 = r110 - r102;
        System.arraycopy(r100, r102, this.mData, this.mNewDataStart, r119);
        int r120 = this.mNewDataStart + r119;
        this.mNewDataStart = r120;
        this.mSize += r119;
        this.mCallback.onInserted(r120 - r119, r119);
        goto L13
    }

    private boolean remove(T r100, boolean r101) {
        int r102 = findIndexOf(r100, this.mData, 0, this.mSize, 2);
        if (r102 != (-1)) goto L6;
        return false;
    L6:
        removeItemAtIndex(r102, r101);
        return true;
    }

    private void removeItemAtIndex(int r100, boolean r101) {
        T[] r102 = this.mData;
        System.arraycopy(r102, r100 + 1, r102, r100, (this.mSize - r100) - 1);
        int r103 = this.mSize - 1;
        this.mSize = r103;
        this.mData[r103] = null;
        if (r101 == false) goto L6;
        this.mCallback.onRemoved(r100, 1);
        return;
    }

    public void addAll(T[] r100, boolean r101) {
        throwIfInMutationOperation();
        if (r100.length != 0) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        addAllInternal(r100);
        return;
    L7:
        addAllInternal(copyArray(r100));
    }

    public void replaceAll(T[] r100, boolean r101) {
        throwIfInMutationOperation();
        if (r101 == false) goto L5;
        replaceAllInternal(r100);
        return;
    L5:
        replaceAllInternal(copyArray(r100));
    }

    public void updateItemAt(int r100, T r101) {
        throwIfInMutationOperation();
        T r102 = get(r100);
        if (r102 != r101) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r102 != r101) goto L11;
    L16:
        if (r103 == false) goto L18;
        Callback r104 = this.mCallback;
        r104.onChanged(r100, 1, r104.getChangePayload(r102, r101));
    L18:
        removeItemAtIndex(r100, false);
        int r105 = add(r101, false);
        if (r100 == r105) goto L23;
        this.mCallback.onMoved(r100, r105);
        return;
    L23:
        return;
    L11:
        if (this.mCallback.compare(r102, r101) != 0) goto L16;
        this.mData[r100] = r101;
        if (r103 == false) goto L22;
        Callback r106 = this.mCallback;
        r106.onChanged(r100, 1, r106.getChangePayload(r102, r101));
        return;
    L22:
        return;
    L5:
        if (this.mCallback.areContentsTheSame(r102, r101) == false) goto L8;
        r103 = false;
        goto L9
    }

    public SortedList(Class<T> r100, Callback<T> r101, int r102) {
        this.mTClass = r100;
        this.mData = (T[]) ((Object[]) Array.newInstance(r100, r102));
        this.mCallback = r101;
        this.mSize = 0;
    }

    private int findSameItem(T r100, T[] r101, int r102, int r103) {
    L2:
        if (r102 >= r103) goto L7;
        if (this.mCallback.areItemsTheSame(r101[r102], r100) == true) goto L5;
        r102 = r102 + 1;
        goto L2
    L5:
        return r102;
    L7:
        return -1;
    }

    private int linearEqualitySearch(T r100, int r101, int r102, int r103) {
        int r104 = r101 - 1;
    L3:
        if (r104 < r102) goto L11;
        T r105 = this.mData[r104];
        if (this.mCallback.compare(r105, r100) != 0) goto L11;
        if (this.mCallback.areItemsTheSame(r105, r100) == true) goto L9;
        r104 = r104 - 1;
        goto L3
    L9:
        return r104;
    L11:
        r101 = r101 + 1;
        if (r101 >= r103) goto L19;
        T r106 = this.mData[r101];
        if (this.mCallback.compare(r106, r100) != 0) goto L29;
        if (this.mCallback.areItemsTheSame(r106, r100) == false) goto L11;
        return r101;
    L29:
        return -1;
    L19:
        return -1;
    }

    private int findIndexOf(T r100, T[] r101, int r102, int r103, int r110) {
    L3:
        if (r102 >= r103) goto L19;
        int r104 = (r102 + r103) / 2;
        T r105 = r101[r104];
        int r106 = this.mCallback.compare(r105, r100);
        if (r106 < 0) goto L6;
        if (r106 == 0) goto L9;
        r103 = r104;
        goto L3
    L9:
        if (this.mCallback.areItemsTheSame(r105, r100) == false) goto L11;
        return r104;
    L11:
        int r107 = linearEqualitySearch(r100, r104, r102, r103);
        if (r110 != 1) goto L17;
        if (r107 != (-1)) goto L16;
        return r104;
    L16:
        return r107;
    L17:
        return r107;
    L6:
        r102 = r104 + 1;
        goto L3
    L19:
        if (r110 == 1) goto L31;
        return -1;
    L31:
        return r102;
    }
}
