package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f11337x - diagonal2.f11337x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i5, int i6);

        public abstract boolean areItemsTheSame(int i5, int i6);

        public Object getChangePayload(int i5, int i6) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int i5) {
            int[] iArr = new int[i5];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        int[] backingData() {
            return this.mData;
        }

        public void fill(int i5) {
            Arrays.fill(this.mData, i5);
        }

        int get(int i5) {
            return this.mData[i5 + this.mMid];
        }

        void set(int i5, int i6) {
            this.mData[i5 + this.mMid] = i6;
        }
    }

    static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f11337x;

        /* renamed from: y, reason: collision with root package name */
        public final int f11338y;

        Diagonal(int i5, int i6, int i7) {
            this.f11337x = i5;
            this.f11338y = i6;
            this.size = i7;
        }

        int endX() {
            return this.f11337x + this.size;
        }

        int endY() {
            return this.f11338y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z5) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z5;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f11337x != 0 || diagonal.f11338y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i5) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Diagonal diagonal = this.mDiagonals.get(i6);
                while (iEndY < diagonal.f11338y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i5, iEndY)) {
                        int i7 = this.mCallback.areContentsTheSame(i5, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i5] = (iEndY << 4) | i7;
                        this.mNewItemStatuses[iEndY] = (i5 << 4) | i7;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i5 = 0; i5 < diagonal.size; i5++) {
                    int i6 = diagonal.f11337x + i5;
                    int i7 = diagonal.f11338y + i5;
                    int i8 = this.mCallback.areContentsTheSame(i6, i7) ? 1 : 2;
                    this.mOldItemStatuses[i6] = (i7 << 4) | i8;
                    this.mNewItemStatuses[i7] = (i6 << 4) | i8;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f11337x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i5, boolean z5) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i5 && next.removal == z5) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z5) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(int i5) {
            if (i5 >= 0 && i5 < this.mNewListSize) {
                int i6 = this.mNewItemStatuses[i5];
                if ((i6 & FLAG_MASK) == 0) {
                    return -1;
                }
                return i6 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i5 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(int i5) {
            if (i5 >= 0 && i5 < this.mOldListSize) {
                int i6 = this.mOldItemStatuses[i5];
                if ((i6 & FLAG_MASK) == 0) {
                    return -1;
                }
                return i6 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i5 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            int i5;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i6 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i7 = this.mOldListSize;
            int i8 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i7 <= iEndX) {
                        break;
                    }
                    i7--;
                    int i9 = this.mOldItemStatuses[i7];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i10, false);
                        if (postponedUpdate != null) {
                            int i11 = (i6 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i7, i11);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i11, 1, this.mCallback.getChangePayload(i7, i10));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i7, (i6 - i7) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i7, 1);
                        i6--;
                    }
                }
                while (i8 > iEndY) {
                    i8--;
                    int i12 = this.mNewItemStatuses[i8];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i13, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i8, i6 - i7, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i6 - postponedUpdate2.currentPos) - 1, i7);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i7, 1, this.mCallback.getChangePayload(i13, i8));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i7, 1);
                        i6++;
                    }
                }
                int i14 = diagonal.f11337x;
                int i15 = diagonal.f11338y;
                for (i5 = 0; i5 < diagonal.size; i5++) {
                    if ((this.mOldItemStatuses[i14] & FLAG_MASK) == 2) {
                        batchingListUpdateCallback.onChanged(i14, 1, this.mCallback.getChangePayload(i14, i15));
                    }
                    i14++;
                    i15++;
                }
                i7 = diagonal.f11337x;
                i8 = diagonal.f11338y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t5, T t6);

        public abstract boolean areItemsTheSame(T t5, T t6);

        public Object getChangePayload(T t5, T t6) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i5, int i6, boolean z5) {
            this.posInOwnerList = i5;
            this.currentPos = i6;
            this.removal = z5;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i5, int i6, int i7, int i8) {
            this.oldListStart = i5;
            this.oldListEnd = i6;
            this.newListStart = i7;
            this.newListEnd = i8;
        }
    }

    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i5 = this.startX;
            return new Diagonal(i5, this.startY, this.endX - i5);
        }
    }

    private DiffUtil() {
    }

    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i5) {
        int i6;
        int i7;
        int i8;
        boolean z5 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && centeredArray2.get(i10 + 1) < centeredArray2.get(i10 - 1))) {
                i6 = centeredArray2.get(i10 + 1);
                i7 = i6;
            } else {
                i6 = centeredArray2.get(i10 - 1);
                i7 = i6 - 1;
            }
            int i11 = range.newListEnd - ((range.oldListEnd - i7) - i10);
            int i12 = (i5 == 0 || i7 != i6) ? i11 : i11 + 1;
            while (i7 > range.oldListStart && i11 > range.newListStart && callback.areItemsTheSame(i7 - 1, i11 - 1)) {
                i7--;
                i11--;
            }
            centeredArray2.set(i10, i7);
            if (z5 && (i8 = iOldSize - i10) >= i9 && i8 <= i5 && centeredArray.get(i8) >= i7) {
                Snake snake = new Snake();
                snake.startX = i7;
                snake.startY = i11;
                snake.endX = i6;
                snake.endY = i12;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i5) {
        int i6;
        int i7;
        int i8;
        boolean z5 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && centeredArray.get(i10 + 1) > centeredArray.get(i10 - 1))) {
                i6 = centeredArray.get(i10 + 1);
                i7 = i6;
            } else {
                i6 = centeredArray.get(i10 - 1);
                i7 = i6 + 1;
            }
            int i11 = (range.newListStart + (i7 - range.oldListStart)) - i10;
            int i12 = (i5 == 0 || i7 != i6) ? i11 : i11 - 1;
            while (i7 < range.oldListEnd && i11 < range.newListEnd && callback.areItemsTheSame(i7, i11)) {
                i7++;
                i11++;
            }
            centeredArray.set(i10, i7);
            if (z5 && (i8 = iOldSize - i10) >= i9 + 1 && i8 <= i5 - 1 && centeredArray2.get(i8) <= i7) {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i12;
                snake.endX = i7;
                snake.endY = i11;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i5 = 0; i5 < iOldSize; i5++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i5);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i5);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    public static DiffResult calculateDiff(Callback callback, boolean z5) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i5 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i5);
        CenteredArray centeredArray2 = new CenteredArray(i5);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeMidPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (snakeMidPoint != null) {
                if (snakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(snakeMidPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snakeMidPoint.startX;
                range2.newListEnd = snakeMidPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snakeMidPoint.endX;
                range.newListStart = snakeMidPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z5);
    }
}
