package androidx.recyclerview.widget;

import B0.g;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
            return diagonal.f4176x - diagonal2.f4176x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i4, int i5);

        public abstract boolean areItemsTheSame(int i4, int i5);

        @Nullable
        public Object getChangePayload(int i4, int i5) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i4) {
            int[] iArr = new int[i4];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i4) {
            Arrays.fill(this.mData, i4);
        }

        public int get(int i4) {
            return this.mData[i4 + this.mMid];
        }

        public void set(int i4, int i5) {
            this.mData[i4 + this.mMid] = i5;
        }
    }

    public static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f4176x;

        /* renamed from: y, reason: collision with root package name */
        public final int f4177y;

        public Diagonal(int i4, int i5, int i6) {
            this.f4176x = i4;
            this.f4177y = i5;
            this.size = i6;
        }

        public int endX() {
            return this.f4176x + this.size;
        }

        public int endY() {
            return this.f4177y + this.size;
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

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z4) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z4;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f4176x != 0 || diagonal.f4177y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i4) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Diagonal diagonal = this.mDiagonals.get(i5);
                while (iEndY < diagonal.f4177y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i4, iEndY)) {
                        int i6 = this.mCallback.areContentsTheSame(i4, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i4] = (iEndY << 4) | i6;
                        this.mNewItemStatuses[iEndY] = (i4 << 4) | i6;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i4 = 0; i4 < diagonal.size; i4++) {
                    int i5 = diagonal.f4176x + i4;
                    int i6 = diagonal.f4177y + i4;
                    int i7 = this.mCallback.areContentsTheSame(i5, i6) ? 1 : 2;
                    this.mOldItemStatuses[i5] = (i6 << 4) | i7;
                    this.mNewItemStatuses[i6] = (i5 << 4) | i7;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f4176x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i4, boolean z4) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i4 && next.removal == z4) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z4) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i4) {
            if (i4 < 0 || i4 >= this.mNewListSize) {
                StringBuilder sbT = g.t("Index out of bounds - passed position = ", i4, ", new list size = ");
                sbT.append(this.mNewListSize);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            int i5 = this.mNewItemStatuses[i4];
            if ((i5 & 15) == 0) {
                return -1;
            }
            return i5 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i4) {
            if (i4 < 0 || i4 >= this.mOldListSize) {
                StringBuilder sbT = g.t("Index out of bounds - passed position = ", i4, ", old list size = ");
                sbT.append(this.mOldListSize);
                throw new IndexOutOfBoundsException(sbT.toString());
            }
            int i5 = this.mOldItemStatuses[i4];
            if ((i5 & 15) == 0) {
                return -1;
            }
            return i5 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i4;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i5 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i6 = this.mOldListSize;
            int i7 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i6 <= iEndX) {
                        break;
                    }
                    i6--;
                    int i8 = this.mOldItemStatuses[i6];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i9, false);
                        if (postponedUpdate != null) {
                            int i10 = (i5 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i6, i10);
                            if ((i8 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i6, i9));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i6, (i5 - i6) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i6, 1);
                        i5--;
                    }
                }
                while (i7 > iEndY) {
                    i7--;
                    int i11 = this.mNewItemStatuses[i7];
                    if ((i11 & 12) != 0) {
                        int i12 = i11 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i12, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i7, i5 - i6, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i5 - postponedUpdate2.currentPos) - 1, i6);
                            if ((i11 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i6, 1, this.mCallback.getChangePayload(i12, i7));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i6, 1);
                        i5++;
                    }
                }
                int i13 = diagonal.f4176x;
                int i14 = diagonal.f4177y;
                for (i4 = 0; i4 < diagonal.size; i4++) {
                    if ((this.mOldItemStatuses[i13] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i13, 1, this.mCallback.getChangePayload(i13, i14));
                    }
                    i13++;
                    i14++;
                }
                i6 = diagonal.f4176x;
                i7 = diagonal.f4177y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t4, @NonNull T t5);

        public abstract boolean areItemsTheSame(@NonNull T t4, @NonNull T t5);

        @Nullable
        public Object getChangePayload(@NonNull T t4, @NonNull T t5) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i4, int i5, boolean z4) {
            this.posInOwnerList = i4;
            this.currentPos = i5;
            this.removal = z4;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i4, int i5, int i6, int i7) {
            this.oldListStart = i4;
            this.oldListEnd = i5;
            this.newListStart = i6;
            this.newListEnd = i7;
        }
    }

    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i4 = this.startX;
            return new Diagonal(i4, this.startY, this.endX - i4);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z4 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i8 = -i4;
        for (int i9 = i8; i9 <= i4; i9 += 2) {
            if (i9 == i8 || (i9 != i4 && centeredArray2.get(i9 + 1) < centeredArray2.get(i9 - 1))) {
                i5 = centeredArray2.get(i9 + 1);
                i6 = i5;
            } else {
                i5 = centeredArray2.get(i9 - 1);
                i6 = i5 - 1;
            }
            int i10 = range.newListEnd - ((range.oldListEnd - i6) - i9);
            int i11 = (i4 == 0 || i6 != i5) ? i10 : i10 + 1;
            while (i6 > range.oldListStart && i10 > range.newListStart && callback.areItemsTheSame(i6 - 1, i10 - 1)) {
                i6--;
                i10--;
            }
            centeredArray2.set(i9, i6);
            if (z4 && (i7 = iOldSize - i9) >= i8 && i7 <= i4 && centeredArray.get(i7) >= i6) {
                Snake snake = new Snake();
                snake.startX = i6;
                snake.startY = i10;
                snake.endX = i5;
                snake.endY = i11;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z4 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i8 = -i4;
        for (int i9 = i8; i9 <= i4; i9 += 2) {
            if (i9 == i8 || (i9 != i4 && centeredArray.get(i9 + 1) > centeredArray.get(i9 - 1))) {
                i5 = centeredArray.get(i9 + 1);
                i6 = i5;
            } else {
                i5 = centeredArray.get(i9 - 1);
                i6 = i5 + 1;
            }
            int i10 = ((i6 - range.oldListStart) + range.newListStart) - i9;
            int i11 = (i4 == 0 || i6 != i5) ? i10 : i10 - 1;
            while (i6 < range.oldListEnd && i10 < range.newListEnd && callback.areItemsTheSame(i6, i10)) {
                i6++;
                i10++;
            }
            centeredArray.set(i9, i6);
            if (z4 && (i7 = iOldSize - i9) >= i8 + 1 && i7 <= i4 - 1 && centeredArray2.get(i7) <= i6) {
                Snake snake = new Snake();
                snake.startX = i5;
                snake.startY = i11;
                snake.endX = i6;
                snake.endY = i10;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i4 = 0; i4 < iOldSize; i4++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i4);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i4);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z4) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i4 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i4);
        CenteredArray centeredArray2 = new CenteredArray(i4);
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
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z4);
    }
}
