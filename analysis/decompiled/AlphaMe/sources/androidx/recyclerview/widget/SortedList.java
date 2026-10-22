package androidx.recyclerview.widget;

import B0.g;
import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

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
        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i4, int i5) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i4, int i5) {
            this.mBatchingListUpdateCallback.onInserted(i4, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onMoved(i4, i5);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i4, int i5) {
            this.mBatchingListUpdateCallback.onRemoved(i4, i5);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i4, int i5, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i4, i5, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i4, int i5);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i4, int i5, Object obj) {
            onChanged(i4, i5);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
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

    private void addToData(int i4, T t4) {
        int i5 = this.mSize;
        if (i4 > i5) {
            StringBuilder sbT = g.t("cannot add item to ", i4, " because size is ");
            sbT.append(this.mSize);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        T[] tArr = this.mData;
        if (i5 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i4);
            tArr2[i4] = t4;
            System.arraycopy(this.mData, i4, tArr2, i4 + 1, this.mSize - i4);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i4, tArr, i4 + 1, i5 - i4);
            this.mData[i4] = t4;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t4, T[] tArr, int i4, int i5, int i6) {
        while (i4 < i5) {
            int i7 = (i4 + i5) / 2;
            T t5 = tArr[i7];
            int iCompare = this.mCallback.compare(t5, t4);
            if (iCompare < 0) {
                i4 = i7 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.mCallback.areItemsTheSame(t5, t4)) {
                        return i7;
                    }
                    int iLinearEqualitySearch = linearEqualitySearch(t4, i7, i4, i5);
                    return (i6 == 1 && iLinearEqualitySearch == -1) ? i7 : iLinearEqualitySearch;
                }
                i5 = i7;
            }
        }
        if (i6 == 1) {
            return i4;
        }
        return -1;
    }

    private int findSameItem(T t4, T[] tArr, int i4, int i5) {
        while (i4 < i5) {
            if (this.mCallback.areItemsTheSame(tArr[i4], t4)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t4, int i4, int i5, int i6) {
        T t5;
        for (int i7 = i4 - 1; i7 >= i5; i7--) {
            T t6 = this.mData[i7];
            if (this.mCallback.compare(t6, t4) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t6, t4)) {
                return i7;
            }
        }
        do {
            i4++;
            if (i4 >= i6) {
                return -1;
            }
            t5 = this.mData[i4];
            if (this.mCallback.compare(t5, t4) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t5, t4));
        return i4;
    }

    private void merge(T[] tArr, int i4) {
        boolean z4 = !(this.mCallback instanceof BatchedCallback);
        if (z4) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i5 = 0;
        this.mOldDataStart = 0;
        int i6 = this.mSize;
        this.mOldDataSize = i6;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i6 + i4 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i7 = this.mOldDataStart;
            int i8 = this.mOldDataSize;
            if (i7 >= i8 && i5 >= i4) {
                break;
            }
            if (i7 == i8) {
                int i9 = i4 - i5;
                System.arraycopy(tArr, i5, this.mData, this.mNewDataStart, i9);
                int i10 = this.mNewDataStart + i9;
                this.mNewDataStart = i10;
                this.mSize += i9;
                this.mCallback.onInserted(i10 - i9, i9);
                break;
            }
            if (i5 == i4) {
                int i11 = i8 - i7;
                System.arraycopy(this.mOldData, i7, this.mData, this.mNewDataStart, i11);
                this.mNewDataStart += i11;
                break;
            }
            T t4 = this.mOldData[i7];
            T t5 = tArr[i5];
            int iCompare = this.mCallback.compare(t4, t5);
            if (iCompare > 0) {
                T[] tArr2 = this.mData;
                int i12 = this.mNewDataStart;
                this.mNewDataStart = i12 + 1;
                tArr2[i12] = t5;
                this.mSize++;
                i5++;
                this.mCallback.onInserted(i12, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(t4, t5)) {
                T[] tArr3 = this.mData;
                int i13 = this.mNewDataStart;
                this.mNewDataStart = i13 + 1;
                tArr3[i13] = t5;
                i5++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t4, t5)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                }
            } else {
                T[] tArr4 = this.mData;
                int i14 = this.mNewDataStart;
                this.mNewDataStart = i14 + 1;
                tArr4[i14] = t4;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z4) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i4, boolean z4) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i4 + 1, tArr, i4, (this.mSize - i4) - 1);
        int i5 = this.mSize - 1;
        this.mSize = i5;
        this.mData[i5] = null;
        if (z4) {
            this.mCallback.onRemoved(i4, 1);
        }
    }

    private void replaceAllInsert(T t4) {
        T[] tArr = this.mData;
        int i4 = this.mNewDataStart;
        tArr[i4] = t4;
        this.mNewDataStart = i4 + 1;
        this.mSize++;
        this.mCallback.onInserted(i4, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z4 = !(this.mCallback instanceof BatchedCallback);
        if (z4) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup));
        while (true) {
            int i4 = this.mNewDataStart;
            if (i4 >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 >= i6) {
                int i7 = iSortAndDedup - i4;
                System.arraycopy(tArr, i4, this.mData, i4, i7);
                this.mNewDataStart += i7;
                this.mSize += i7;
                this.mCallback.onInserted(i4, i7);
                break;
            }
            if (i4 >= iSortAndDedup) {
                int i8 = i6 - i5;
                this.mSize -= i8;
                this.mCallback.onRemoved(i4, i8);
                break;
            }
            T t4 = this.mOldData[i5];
            T t5 = tArr[i4];
            int iCompare = this.mCallback.compare(t4, t5);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(t5);
            } else if (this.mCallback.areItemsTheSame(t4, t5)) {
                T[] tArr2 = this.mData;
                int i9 = this.mNewDataStart;
                tArr2[i9] = t5;
                this.mOldDataStart++;
                this.mNewDataStart = i9 + 1;
                if (!this.mCallback.areContentsTheSame(t4, t5)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t4, t5));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t5);
            }
        }
        this.mOldData = null;
        if (z4) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i4 = 0;
        int i5 = 1;
        for (int i6 = 1; i6 < tArr.length; i6++) {
            T t4 = tArr[i6];
            if (this.mCallback.compare(tArr[i4], t4) == 0) {
                int iFindSameItem = findSameItem(t4, tArr, i4, i5);
                if (iFindSameItem != -1) {
                    tArr[iFindSameItem] = t4;
                } else {
                    if (i5 != i6) {
                        tArr[i5] = t4;
                    }
                    i5++;
                }
            } else {
                if (i5 != i6) {
                    tArr[i5] = t4;
                }
                i4 = i5;
                i5++;
            }
        }
        return i5;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t4) {
        throwIfInMutationOperation();
        return add(t4, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z4) {
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
        int i4 = this.mSize;
        if (i4 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i4, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i4);
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

    public T get(int i4) throws IndexOutOfBoundsException {
        int i5;
        if (i4 < this.mSize && i4 >= 0) {
            T[] tArr = this.mOldData;
            return (tArr == null || i4 < (i5 = this.mNewDataStart)) ? this.mData[i4] : tArr[(i4 - i5) + this.mOldDataStart];
        }
        StringBuilder sbT = g.t("Asked to get item at ", i4, " but size is ");
        sbT.append(this.mSize);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public int indexOf(T t4) {
        if (this.mOldData == null) {
            return findIndexOf(t4, this.mData, 0, this.mSize, 4);
        }
        int iFindIndexOf = findIndexOf(t4, this.mData, 0, this.mNewDataStart, 4);
        if (iFindIndexOf != -1) {
            return iFindIndexOf;
        }
        int iFindIndexOf2 = findIndexOf(t4, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (iFindIndexOf2 != -1) {
            return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i4) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t4 = get(i4);
        removeItemAtIndex(i4, false);
        int iAdd = add(t4, false);
        if (i4 != iAdd) {
            this.mCallback.onMoved(i4, iAdd);
        }
    }

    public boolean remove(T t4) {
        throwIfInMutationOperation();
        return remove(t4, true);
    }

    public T removeItemAt(int i4) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t4 = get(i4);
        removeItemAtIndex(i4, true);
        return t4;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z4) {
        throwIfInMutationOperation();
        if (z4) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i4, T t4) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t5 = get(i4);
        boolean z4 = t5 == t4 || !this.mCallback.areContentsTheSame(t5, t4);
        if (t5 != t4 && this.mCallback.compare(t5, t4) == 0) {
            this.mData[i4] = t4;
            if (z4) {
                Callback callback = this.mCallback;
                callback.onChanged(i4, 1, callback.getChangePayload(t5, t4));
                return;
            }
            return;
        }
        if (z4) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i4, 1, callback2.getChangePayload(t5, t4));
        }
        removeItemAtIndex(i4, false);
        int iAdd = add(t4, false);
        if (i4 != iAdd) {
            this.mCallback.onMoved(i4, iAdd);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i4) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i4));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t4, boolean z4) {
        int iFindIndexOf = findIndexOf(t4, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            T t5 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(t5, t4)) {
                if (this.mCallback.areContentsTheSame(t5, t4)) {
                    this.mData[iFindIndexOf] = t4;
                    return iFindIndexOf;
                }
                this.mData[iFindIndexOf] = t4;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(t5, t4));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, t4);
        if (z4) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    private boolean remove(T t4, boolean z4) {
        int iFindIndexOf = findIndexOf(t4, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z4);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
