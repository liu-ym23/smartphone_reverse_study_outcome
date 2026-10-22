package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import b8.z;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f1478x - diagonal2.f1478x;
        }
    };

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i3);

        public abstract boolean areItemsTheSame(int i, int i3);

        public Object getChangePayload(int i, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i) {
            int[] iArr = new int[i];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i) {
            Arrays.fill(this.mData, i);
        }

        public int get(int i) {
            return this.mData[i + this.mMid];
        }

        public void set(int i, int i3) {
            this.mData[i + this.mMid] = i3;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Diagonal {
        public final int size;

        /* renamed from: x, reason: collision with root package name */
        public final int f1478x;

        /* renamed from: y, reason: collision with root package name */
        public final int f1479y;

        public Diagonal(int i, int i3, int i10) {
            this.f1478x = i;
            this.f1479y = i3;
            this.size = i10;
        }

        public int endX() {
            return this.f1478x + this.size;
        }

        public int endY() {
            return this.f1479y + this.size;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t10, T t11);

        public abstract boolean areItemsTheSame(T t10, T t11);

        public Object getChangePayload(T t10, T t11) {
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i3, boolean z10) {
            this.posInOwnerList = i;
            this.currentPos = i3;
            this.removal = z10;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        public Diagonal toDiagonal() {
            if (!hasAdditionOrRemoval()) {
                int i = this.startX;
                return new Diagonal(i, this.startY, this.endX - i);
            }
            if (this.reverse) {
                return new Diagonal(this.startX, this.startY, diagonalSize());
            }
            boolean zIsAddition = isAddition();
            int i3 = this.startX;
            return zIsAddition ? new Diagonal(i3, this.startY + 1, diagonalSize()) : new Diagonal(i3 + 1, this.startY, diagonalSize());
        }
    }

    private DiffUtil() {
    }

    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i3;
        int i10;
        int i11;
        boolean z10 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i12 = -i;
        for (int i13 = i12; i13 <= i; i13 += 2) {
            if (i13 == i12 || (i13 != i && centeredArray2.get(i13 + 1) < centeredArray2.get(i13 - 1))) {
                i3 = centeredArray2.get(i13 + 1);
                i10 = i3;
            } else {
                i3 = centeredArray2.get(i13 - 1);
                i10 = i3 - 1;
            }
            int i14 = range.newListEnd - ((range.oldListEnd - i10) - i13);
            int i15 = (i == 0 || i10 != i3) ? i14 : i14 + 1;
            while (i10 > range.oldListStart && i14 > range.newListStart && callback.areItemsTheSame(i10 - 1, i14 - 1)) {
                i10--;
                i14--;
            }
            centeredArray2.set(i13, i10);
            if (z10 && (i11 = iOldSize - i13) >= i12 && i11 <= i && centeredArray.get(i11) >= i10) {
                Snake snake = new Snake();
                snake.startX = i10;
                snake.startY = i14;
                snake.endX = i3;
                snake.endY = i15;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    public static DiffResult calculateDiff(Callback callback, boolean z10) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i);
        CenteredArray centeredArray2 = new CenteredArray(i);
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
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z10);
    }

    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i3;
        int i10;
        int i11;
        boolean z10 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i12 = -i;
        for (int i13 = i12; i13 <= i; i13 += 2) {
            if (i13 == i12 || (i13 != i && centeredArray.get(i13 + 1) > centeredArray.get(i13 - 1))) {
                i3 = centeredArray.get(i13 + 1);
                i10 = i3;
            } else {
                i3 = centeredArray.get(i13 - 1);
                i10 = i3 + 1;
            }
            int i14 = ((i10 - range.oldListStart) + range.newListStart) - i13;
            int i15 = (i == 0 || i10 != i3) ? i14 : i14 - 1;
            while (i10 < range.oldListEnd && i14 < range.newListEnd && callback.areItemsTheSame(i10, i14)) {
                i10++;
                i14++;
            }
            centeredArray.set(i13, i10);
            if (z10 && (i11 = iOldSize - i13) >= i12 + 1 && i11 <= i - 1 && centeredArray2.get(i11) <= i10) {
                Snake snake = new Snake();
                snake.startX = i3;
                snake.startY = i15;
                snake.endX = i10;
                snake.endY = i14;
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
            for (int i = 0; i < iOldSize; i++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int i, int i3, int i10, int i11) {
            this.oldListStart = i;
            this.oldListEnd = i3;
            this.newListStart = i10;
            this.newListEnd = i11;
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range() {
        }
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z10) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z10;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f1478x != 0 || diagonal.f1479y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Diagonal diagonal = this.mDiagonals.get(i3);
                while (iEndY < diagonal.f1479y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i, iEndY)) {
                        int i10 = this.mCallback.areContentsTheSame(i, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i] = (iEndY << 4) | i10;
                        this.mNewItemStatuses[iEndY] = (i << 4) | i10;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i = 0; i < diagonal.size; i++) {
                    int i3 = diagonal.f1478x + i;
                    int i10 = diagonal.f1479y + i;
                    int i11 = this.mCallback.areContentsTheSame(i3, i10) ? 1 : 2;
                    this.mOldItemStatuses[i3] = (i10 << 4) | i11;
                    this.mNewItemStatuses[i10] = (i3 << 4) | i11;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f1478x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i, boolean z10) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i && next.removal == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z10) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(int i) {
            if (i < 0 || i >= this.mNewListSize) {
                z.i(this.mNewListSize, a.t(i, "Index out of bounds - passed position = ", ", new list size = "));
                return 0;
            }
            int i3 = this.mNewItemStatuses[i];
            if ((i3 & 15) == 0) {
                return -1;
            }
            return i3 >> 4;
        }

        public int convertOldPositionToNew(int i) {
            if (i < 0 || i >= this.mOldListSize) {
                z.i(this.mOldListSize, a.t(i, "Index out of bounds - passed position = ", ", old list size = "));
                return 0;
            }
            int i3 = this.mOldItemStatuses[i];
            if ((i3 & 15) == 0) {
                return -1;
            }
            return i3 >> 4;
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            int i;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i3 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i10 = this.mOldListSize;
            int i11 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i10 <= iEndX) {
                        break;
                    }
                    i10--;
                    int i12 = this.mOldItemStatuses[i10];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i13, false);
                        if (postponedUpdate != null) {
                            int i14 = (i3 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i10, i14);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i14, 1, this.mCallback.getChangePayload(i10, i13));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i10, (i3 - i10) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i10, 1);
                        i3--;
                    }
                }
                while (i11 > iEndY) {
                    i11--;
                    int i15 = this.mNewItemStatuses[i11];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i16, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i11, i3 - i10, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i3 - postponedUpdate2.currentPos) - 1, i10);
                            if ((i15 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i16, i11));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i10, 1);
                        i3++;
                    }
                }
                int i17 = diagonal.f1478x;
                int i18 = diagonal.f1479y;
                for (i = 0; i < diagonal.size; i++) {
                    if ((this.mOldItemStatuses[i17] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i17, 1, this.mCallback.getChangePayload(i17, i18));
                    }
                    i17++;
                    i18++;
                }
                i10 = diagonal.f1478x;
                i11 = diagonal.f1479y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }
    }
}
