package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import b8.z;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import k0.a;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i, int i3);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i3, Object obj) {
            onChanged(i, i3);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t10, boolean z10) {
        int iFindIndexOf = findIndexOf(t10, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            T t11 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(t11, t10)) {
                boolean zAreContentsTheSame = this.mCallback.areContentsTheSame(t11, t10);
                T[] tArr = this.mData;
                if (zAreContentsTheSame) {
                    tArr[iFindIndexOf] = t10;
                    return iFindIndexOf;
                }
                tArr[iFindIndexOf] = t10;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(t11, t10));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, t10);
        if (z10) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iSortAndDedup = sortAndDedup(tArr);
        if (this.mSize != 0) {
            merge(tArr, iSortAndDedup);
            return;
        }
        this.mData = tArr;
        this.mSize = iSortAndDedup;
        this.mCallback.onInserted(0, iSortAndDedup);
    }

    private void addToData(int i, T t10) {
        int i3 = this.mSize;
        if (i > i3) {
            z.i(this.mSize, a.t(i, "cannot add item to ", " because size is "));
            return;
        }
        T[] tArr = this.mData;
        if (i3 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i);
            tArr2[i] = t10;
            System.arraycopy(this.mData, i, tArr2, i + 1, this.mSize - i);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i, tArr, i + 1, i3 - i);
            this.mData[i] = t10;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t10, T[] tArr, int i, int i3, int i10) {
        while (i < i3) {
            int i11 = (i + i3) / 2;
            T t11 = tArr[i11];
            int iCompare = this.mCallback.compare(t11, t10);
            if (iCompare < 0) {
                i = i11 + 1;
            } else {
                if (iCompare == 0) {
                    if (!this.mCallback.areItemsTheSame(t11, t10)) {
                        int iLinearEqualitySearch = linearEqualitySearch(t10, i11, i, i3);
                        if (i10 != 1 || iLinearEqualitySearch != -1) {
                            return iLinearEqualitySearch;
                        }
                    }
                    return i11;
                }
                i3 = i11;
            }
        }
        if (i10 == 1) {
            return i;
        }
        return -1;
    }

    private int findSameItem(T t10, T[] tArr, int i, int i3) {
        while (i < i3) {
            if (this.mCallback.areItemsTheSame(tArr[i], t10)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t10, int i, int i3, int i10) {
        T t11;
        for (int i11 = i - 1; i11 >= i3; i11--) {
            T t12 = this.mData[i11];
            if (this.mCallback.compare(t12, t10) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t12, t10)) {
                return i11;
            }
        }
        do {
            i++;
            if (i >= i10) {
                return -1;
            }
            t11 = this.mData[i];
            if (this.mCallback.compare(t11, t10) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t11, t10));
        return i;
    }

    private void merge(T[] tArr, int i) {
        boolean z10 = this.mCallback instanceof BatchedCallback;
        if (!z10) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i3 = 0;
        this.mOldDataStart = 0;
        int i10 = this.mSize;
        this.mOldDataSize = i10;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i10 + i + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i11 = this.mOldDataStart;
            int i12 = this.mOldDataSize;
            if (i11 >= i12 && i3 >= i) {
                break;
            }
            if (i11 == i12) {
                int i13 = i - i3;
                System.arraycopy(tArr, i3, this.mData, this.mNewDataStart, i13);
                int i14 = this.mNewDataStart + i13;
                this.mNewDataStart = i14;
                this.mSize += i13;
                this.mCallback.onInserted(i14 - i13, i13);
                break;
            }
            T[] tArr2 = this.mOldData;
            if (i3 == i) {
                int i15 = i12 - i11;
                System.arraycopy(tArr2, i11, this.mData, this.mNewDataStart, i15);
                this.mNewDataStart += i15;
                break;
            }
            T t10 = tArr2[i11];
            T t11 = tArr[i3];
            int iCompare = this.mCallback.compare(t10, t11);
            if (iCompare > 0) {
                T[] tArr3 = this.mData;
                int i16 = this.mNewDataStart;
                this.mNewDataStart = i16 + 1;
                tArr3[i16] = t11;
                this.mSize++;
                i3++;
                this.mCallback.onInserted(i16, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(t10, t11)) {
                T[] tArr4 = this.mData;
                int i17 = this.mNewDataStart;
                this.mNewDataStart = i17 + 1;
                tArr4[i17] = t11;
                i3++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t10, t11)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t10, t11));
                }
            } else {
                T[] tArr5 = this.mData;
                int i18 = this.mNewDataStart;
                this.mNewDataStart = i18 + 1;
                tArr5[i18] = t10;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z10) {
            return;
        }
        endBatchedUpdates();
    }

    private boolean remove(T t10, boolean z10) {
        int iFindIndexOf = findIndexOf(t10, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z10);
        return true;
    }

    private void removeItemAtIndex(int i, boolean z10) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i + 1, tArr, i, (this.mSize - i) - 1);
        int i3 = this.mSize - 1;
        this.mSize = i3;
        this.mData[i3] = null;
        if (z10) {
            this.mCallback.onRemoved(i, 1);
        }
    }

    private void replaceAllInsert(T t10) {
        T[] tArr = this.mData;
        int i = this.mNewDataStart;
        tArr[i] = t10;
        this.mNewDataStart = i + 1;
        this.mSize++;
        this.mCallback.onInserted(i, 1);
    }

    private void replaceAllInternal(T[] tArr) {
        boolean z10 = this.mCallback instanceof BatchedCallback;
        if (!z10) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup));
        while (true) {
            int i = this.mNewDataStart;
            if (i >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i3 = this.mOldDataStart;
            int i10 = this.mOldDataSize;
            if (i3 >= i10) {
                int i11 = iSortAndDedup - i;
                System.arraycopy(tArr, i, this.mData, i, i11);
                this.mNewDataStart += i11;
                this.mSize += i11;
                this.mCallback.onInserted(i, i11);
                break;
            }
            if (i >= iSortAndDedup) {
                int i12 = i10 - i3;
                this.mSize -= i12;
                this.mCallback.onRemoved(i, i12);
                break;
            }
            T t10 = this.mOldData[i3];
            T t11 = tArr[i];
            int iCompare = this.mCallback.compare(t10, t11);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(t11);
            } else if (this.mCallback.areItemsTheSame(t10, t11)) {
                T[] tArr2 = this.mData;
                int i13 = this.mNewDataStart;
                tArr2[i13] = t11;
                this.mOldDataStart++;
                this.mNewDataStart = i13 + 1;
                if (!this.mCallback.areContentsTheSame(t10, t11)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t10, t11));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t11);
            }
        }
        this.mOldData = null;
        if (z10) {
            return;
        }
        endBatchedUpdates();
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i = 0;
        int i3 = 1;
        for (int i10 = 1; i10 < tArr.length; i10++) {
            T t10 = tArr[i10];
            if (this.mCallback.compare(tArr[i], t10) == 0) {
                int iFindSameItem = findSameItem(t10, tArr, i, i3);
                if (iFindSameItem != -1) {
                    tArr[iFindSameItem] = t10;
                } else {
                    if (i3 != i10) {
                        tArr[i3] = t10;
                    }
                    i3++;
                }
            } else {
                if (i3 != i10) {
                    tArr[i3] = t10;
                }
                i = i3;
                i3++;
            }
        }
        return i3;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
            return;
        }
        f.e("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public void addAll(T[] tArr, boolean z10) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z10) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i = this.mSize;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i) {
        int i3;
        if (i >= this.mSize || i < 0) {
            z.i(this.mSize, a.t(i, "Asked to get item at ", " but size is "));
            return null;
        }
        T[] tArr = this.mOldData;
        return (tArr == null || i < (i3 = this.mNewDataStart)) ? this.mData[i] : tArr[(i - i3) + this.mOldDataStart];
    }

    public int indexOf(T t10) {
        T[] tArr = this.mOldData;
        T[] tArr2 = this.mData;
        if (tArr == null) {
            return findIndexOf(t10, tArr2, 0, this.mSize, 4);
        }
        int iFindIndexOf = findIndexOf(t10, tArr2, 0, this.mNewDataStart, 4);
        if (iFindIndexOf != -1) {
            return iFindIndexOf;
        }
        int iFindIndexOf2 = findIndexOf(t10, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (iFindIndexOf2 != -1) {
            return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i) {
        throwIfInMutationOperation();
        T t10 = get(i);
        removeItemAtIndex(i, false);
        int iAdd = add(t10, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    public T removeItemAt(int i) {
        throwIfInMutationOperation();
        T t10 = get(i);
        removeItemAtIndex(i, true);
        return t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i, T t10) {
        throwIfInMutationOperation();
        T t11 = get(i);
        boolean z10 = t11 == t10 || !this.mCallback.areContentsTheSame(t11, t10);
        if (t11 != t10 && this.mCallback.compare(t11, t10) == 0) {
            this.mData[i] = t10;
            if (z10) {
                Callback callback = this.mCallback;
                callback.onChanged(i, 1, callback.getChangePayload(t11, t10));
                return;
            }
            return;
        }
        if (z10) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i, 1, callback2.getChangePayload(t11, t10));
        }
        removeItemAtIndex(i, false);
        int iAdd = add(t10, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i3) {
            this.mBatchingListUpdateCallback.onChanged(i, i3, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i3) {
            this.mBatchingListUpdateCallback.onInserted(i, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i3) {
            this.mBatchingListUpdateCallback.onMoved(i, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i3) {
            this.mBatchingListUpdateCallback.onRemoved(i, i3);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i3, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i, i3, obj);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(T... tArr) {
        replaceAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public boolean remove(T t10) {
        throwIfInMutationOperation();
        return remove(t10, true);
    }

    public void replaceAll(T[] tArr, boolean z10) {
        throwIfInMutationOperation();
        if (z10) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int add(T t10) {
        throwIfInMutationOperation();
        return add(t10, true);
    }
}
