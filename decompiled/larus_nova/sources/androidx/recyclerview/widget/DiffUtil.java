package androidx.recyclerview.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = null;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract boolean areContentsTheSame(int r100, int r101);

        public abstract boolean areItemsTheSame(int r100, int r101);

        public Object getChangePayload(int r100, int r101) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public int[] backingData() {
            return this.mData;
        }

        public CenteredArray(int r100) {
            int[] r101 = new int[r100];
            this.mData = r101;
            this.mMid = r101.length / 2;
        }

        public void fill(int r100) {
            Arrays.fill(this.mData, r100);
        }

        public int get(int r100) {
            return this.mData[r100 + this.mMid];
        }

        public void set(int r100, int r101) {
            this.mData[r100 + this.mMid] = r101;
        }
    }

    public static class Diagonal {
        public final int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f15614x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f15615y;

        public int endX() {
            return this.f15614x + this.size;
        }

        public int endY() {
            return this.f15615y + this.size;
        }

        public Diagonal(int r100, int r101, int r102) {
            this.f15614x = r100;
            this.f15615y = r101;
            this.size = r102;
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

        private void addEdgeDiagonals() {
            if (this.mDiagonals.isEmpty() == false) goto L5;
            Diagonal r100 = null;
        L6:
            if (r100 != null) goto L8;
        L11:
            ListProtector.add(this.mDiagonals, 0, new Diagonal(0, 0, 0));
        L12:
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
            return;
        L8:
            if (r100.f15614x != 0) goto L11;
            if (r100.f15615y == 0) goto L12;
        L5:
            r100 = (Diagonal) ListProtector.get(this.mDiagonals, 0);
            goto L6
        }

        private void findMatchingItems() {
            Iterator<Diagonal> r100 = this.mDiagonals.iterator();
        L4:
            if (r100.hasNext() == false) goto L14;
            Diagonal r101 = r100.next();
            int r102 = 0;
        L7:
            if (r102 >= r101.size) goto L4;
            int r103 = r101.f15614x + r102;
            int r104 = r101.f15615y + r102;
            if (this.mCallback.areContentsTheSame(r103, r104) == false) goto L11;
            int r105 = 1;
        L12:
            this.mOldItemStatuses[r103] = (r104 << 4) | r105;
            this.mNewItemStatuses[r104] = (r103 << 4) | r105;
            r102 = r102 + 1;
            goto L7
        L11:
            r105 = 2;
            goto L12
        L14:
            if (this.mDetectMoves == false) goto L21;
            findMoveMatches();
            return;
        }

        private void findMoveMatches() {
            Iterator<Diagonal> r100 = this.mDiagonals.iterator();
            int r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L13;
            Diagonal r102 = r100.next();
        L7:
            if (r101 >= r102.f15614x) goto L12;
            if (this.mOldItemStatuses[r101] != 0) goto L11;
            findMatchingAddition(r101);
        L11:
            r101 = r101 + 1;
            goto L7
        L12:
            r101 = r102.endX();
            goto L4
        }

        private void findMatchingAddition(int r100) {
            int r101 = this.mDiagonals.size();
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r102 >= r101) goto L19;
            Diagonal r104 = (Diagonal) ListProtector.get(this.mDiagonals, r102);
        L6:
            if (r103 >= r104.f15615y) goto L18;
            if (this.mNewItemStatuses[r103] != 0) goto L17;
            if (this.mCallback.areItemsTheSame(r100, r103) == false) goto L17;
            if (this.mCallback.areContentsTheSame(r100, r103) == false) goto L14;
            int r105 = 8;
        L15:
            this.mOldItemStatuses[r100] = (r103 << 4) | r105;
            this.mNewItemStatuses[r103] = (r100 << 4) | r105;
            return;
        L14:
            r105 = 4;
        L17:
            r103 = r103 + 1;
            goto L6
        L18:
            r103 = r104.endY();
            r102 = r102 + 1;
            goto L3
        }

        public int convertNewPositionToOld(int r100) {
            if (r100 < 0) goto L12;
            if (r100 >= this.mNewListSize) goto L12;
            int r101 = this.mNewItemStatuses[r100];
            if ((r101 & 15) != 0) goto L10;
            return -1;
        L10:
            return r101 >> 4;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r100 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(int r100) {
            if (r100 < 0) goto L12;
            if (r100 >= this.mOldListSize) goto L12;
            int r101 = this.mOldItemStatuses[r100];
            if ((r101 & 15) != 0) goto L10;
            return -1;
        L10:
            return r101 >> 4;
        L12:
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + r100 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(ListUpdateCallback r110) {
            if ((r110 instanceof BatchingListUpdateCallback) == false) goto L5;
            BatchingListUpdateCallback r111 = (BatchingListUpdateCallback) r110;
        L6:
            int r100 = this.mOldListSize;
            ArrayDeque r101 = new ArrayDeque();
            int r102 = this.mOldListSize;
            int r103 = this.mNewListSize;
            int r104 = this.mDiagonals.size() - 1;
        L7:
            if (r104 < 0) goto L38;
            Diagonal r105 = (Diagonal) ListProtector.get(this.mDiagonals, r104);
            int r106 = r105.endX();
            int r107 = r105.endY();
        L9:
            int r108 = 0;
            if (r102 <= r106) goto L20;
            r102 = r102 - 1;
            int r112 = this.mOldItemStatuses[r102];
            if ((r112 & 12) != 0) goto L13;
            r111.onRemoved(r102, 1);
            r100 = r100 - 1;
            goto L9
        L13:
            int r113 = r112 >> 4;
            PostponedUpdate r109 = getPostponedUpdate(r101, r113, false);
            if (r109 != null) goto L15;
            r101.add(new PostponedUpdate(r102, (r100 - r102) - 1, true));
            goto L9
        L15:
            int r114 = (r100 - r109.currentPos) - 1;
            r111.onMoved(r102, r114);
            if ((r112 & 4) == 0) goto L9;
            r111.onChanged(r114, 1, this.mCallback.getChangePayload(r102, r113));
        L20:
            if (r103 <= r107) goto L30;
            r103 = r103 - 1;
            int r115 = this.mNewItemStatuses[r103];
            if ((r115 & 12) != 0) goto L23;
            r111.onInserted(r102, 1);
            r100 = r100 + 1;
            goto L20
        L23:
            int r116 = r115 >> 4;
            PostponedUpdate r117 = getPostponedUpdate(r101, r116, true);
            if (r117 == null) goto L25;
            r111.onMoved((r100 - r117.currentPos) - 1, r102);
            if ((r115 & 4) == 0) goto L20;
            r111.onChanged(r102, 1, this.mCallback.getChangePayload(r116, r103));
            goto L20
        L25:
            r101.add(new PostponedUpdate(r103, r100 - r102, false));
            goto L20
        L30:
            int r118 = r105.f15614x;
            int r119 = r105.f15615y;
        L32:
            if (r108 >= r105.size) goto L37;
            if ((this.mOldItemStatuses[r118] & 15) != 2) goto L36;
            r111.onChanged(r118, 1, this.mCallback.getChangePayload(r118, r119));
        L36:
            r118 = r118 + 1;
            r119 = r119 + 1;
            r108 = r108 + 1;
            goto L32
        L37:
            r102 = r105.f15614x;
            r103 = r105.f15615y;
            r104 = r104 - 1;
            goto L7
        L38:
            r111.dispatchLastEvent();
            return;
        L5:
            r111 = new BatchingListUpdateCallback(r110);
            goto L6
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter r100) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(r100));
        }

        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> r100, int r101, boolean r102) {
            Iterator<PostponedUpdate> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            PostponedUpdate r104 = r103.next();
            if (r104.posInOwnerList != r101) goto L4;
            if (r104.removal != r102) goto L4;
            r103.remove();
        L12:
            if (r103.hasNext() == false) goto L17;
            PostponedUpdate r105 = r103.next();
            if (r102 == true) goto L15;
            r105.currentPos++;
            goto L12
        L15:
            r105.currentPos--;
            goto L12
        L17:
            return r104;
        L10:
            r104 = null;
            goto L12
        }

        public DiffResult(Callback r100, List<Diagonal> r101, int[] r102, int[] r103, boolean r104) {
            this.mDiagonals = r101;
            this.mOldItemStatuses = r102;
            this.mNewItemStatuses = r103;
            Arrays.fill(r102, 0);
            Arrays.fill(r103, 0);
            this.mCallback = r100;
            this.mOldListSize = r100.getOldListSize();
            this.mNewListSize = r100.getNewListSize();
            this.mDetectMoves = r104;
            addEdgeDiagonals();
            findMatchingItems();
        }
    }

    public static abstract class ItemCallback<T> {
        public ItemCallback() {
        }

        public abstract boolean areContentsTheSame(T r100, T r101);

        public abstract boolean areItemsTheSame(T r100, T r101);

        public Object getChangePayload(T r100, T r101) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int r100, int r101, boolean r102) {
            this.posInOwnerList = r100;
            this.currentPos = r101;
            this.removal = r102;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range() {
        }

        public Range(int r100, int r101, int r102, int r103) {
            this.oldListStart = r100;
            this.oldListEnd = r101;
            this.newListStart = r102;
            this.newListEnd = r103;
        }
    }

    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public Snake() {
        }

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            if ((this.endY - this.startY) == (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isAddition() {
            if ((this.endY - this.startY) <= (this.endX - this.startX)) goto L5;
            return true;
        L5:
            return false;
        }

        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval() == true) goto L5;
            int r100 = this.startX;
            return new Diagonal(r100, this.startY, this.endX - r100);
        L5:
            if (this.reverse == false) goto L9;
            return new Diagonal(this.startX, this.startY, diagonalSize());
        L9:
            if (isAddition() == false) goto L13;
            return new Diagonal(this.startX, this.startY + 1, diagonalSize());
        L13:
            return new Diagonal(this.startX + 1, this.startY, diagonalSize());
        }
    }

    static {
        DIAGONAL_COMPARATOR = new AnonymousClass1();
    }

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback r100) {
        return calculateDiff(r100, true);
    }

    public static DiffResult calculateDiff(Callback r100, boolean r110) {
        int r101 = r100.getOldListSize();
        int r102 = r100.getNewListSize();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        r104.add(new Range(0, r101, 0, r102));
        int r105 = ((((r101 + r102) + 1) / 2) * 2) + 1;
        CenteredArray r106 = new CenteredArray(r105);
        CenteredArray r107 = new CenteredArray(r105);
        ArrayList r108 = new ArrayList();
    L4:
        if (r104.isEmpty() == true) goto L16;
        Range r109 = (Range) ListProtector.remove(r104, r104.size() - 1);
        Snake r111 = midPoint(r109, r100, r106, r107);
        if (r111 != null) goto L8;
        r108.add(r109);
        goto L4
    L8:
        if (r111.diagonalSize() <= 0) goto L11;
        r103.add(r111.toDiagonal());
    L11:
        if (r108.isEmpty() == false) goto L13;
        Range r112 = new Range();
    L14:
        r112.oldListStart = r109.oldListStart;
        r112.newListStart = r109.newListStart;
        r112.oldListEnd = r111.startX;
        r112.newListEnd = r111.startY;
        r104.add(r112);
        r109.oldListEnd = r109.oldListEnd;
        r109.newListEnd = r109.newListEnd;
        r109.oldListStart = r111.endX;
        r109.newListStart = r111.endY;
        r104.add(r109);
        goto L4
    L13:
        r112 = (Range) ListProtector.remove(r108, r108.size() - 1);
        goto L14
    L16:
        Collections.sort(r103, DIAGONAL_COMPARATOR);
        return new DiffResult(r100, r103, r106.backingData(), r107.backingData(), r110);
    }

    private static Snake midPoint(Range r100, Callback r101, CenteredArray r102, CenteredArray r103) {
        if (r100.oldSize() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r100.newSize() < 1) goto L16;
        int r104 = ((r100.oldSize() + r100.newSize()) + 1) / 2;
        r102.set(1, r100.oldListStart);
        r103.set(1, r100.oldListEnd);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        Snake r106 = forward(r100, r101, r102, r103, r105);
        if (r106 != null) goto L11;
        Snake r107 = backward(r100, r101, r102, r103, r105);
        if (r107 != null) goto L14;
        r105 = r105 + 1;
        goto L8
    L14:
        return r107;
    L11:
        return r106;
    }

    private static Snake backward(Range r110, Callback r111, CenteredArray r112, CenteredArray r113, int r114) {
        if (((r110.oldSize() - r110.newSize()) % 2) != 0) goto L5;
        boolean r100 = true;
    L6:
        int r101 = r110.oldSize() - r110.newSize();
        int r102 = -r114;
        int r103 = r102;
    L7:
        if (r103 > r114) goto L38;
        if (r103 == r102) goto L14;
        if (r103 != r114) goto L11;
    L13:
        int r104 = r113.get(r103 - 1);
        int r105 = r104 - 1;
    L15:
        int r106 = r110.newListEnd - ((r110.oldListEnd - r105) - r103);
        if (r114 == 0) goto L20;
        if (r105 != r104) goto L20;
        int r107 = r106 + 1;
    L22:
        if (r105 <= r110.oldListStart) goto L28;
        if (r106 <= r110.newListStart) goto L28;
        if (r111.areItemsTheSame(r105 - 1, r106 - 1) == false) goto L28;
        r105 = r105 - 1;
        r106 = r106 - 1;
    L28:
        r113.set(r103, r105);
        if (r100 == false) goto L37;
        int r108 = r101 - r103;
        if (r108 < r102) goto L37;
        if (r108 > r114) goto L37;
        if (r112.get(r108) < r105) goto L37;
        Snake r115 = new Snake();
        r115.startX = r105;
        r115.startY = r106;
        r115.endX = r104;
        r115.endY = r107;
        r115.reverse = true;
        return r115;
    L37:
        r103 = r103 + 2;
    L20:
        r107 = r106;
        goto L22
    L11:
        if (r113.get(r103 + 1) >= r113.get(r103 - 1)) goto L13;
    L14:
        r104 = r113.get(r103 + 1);
        r105 = r104;
        goto L15
    L38:
        return null;
    L5:
        r100 = false;
        goto L6
    }

    private static Snake forward(Range r110, Callback r111, CenteredArray r112, CenteredArray r113, int r114) {
        boolean r100 = true;
        if ((Math.abs(r110.oldSize() - r110.newSize()) % 2) == 1) goto L6;
        r100 = false;
    L6:
        int r101 = r110.oldSize() - r110.newSize();
        int r102 = -r114;
        int r103 = r102;
    L7:
        if (r103 > r114) goto L39;
        if (r103 == r102) goto L14;
        if (r103 != r114) goto L11;
    L13:
        int r104 = r112.get(r103 - 1);
        int r105 = r104 + 1;
    L15:
        int r106 = (r110.newListStart + (r105 - r110.oldListStart)) - r103;
        if (r114 == 0) goto L20;
        if (r105 != r104) goto L20;
        int r107 = r106 - 1;
    L22:
        if (r105 >= r110.oldListEnd) goto L28;
        if (r106 >= r110.newListEnd) goto L28;
        if (r111.areItemsTheSame(r105, r106) == false) goto L28;
        r105 = r105 + 1;
        r106 = r106 + 1;
    L28:
        r112.set(r103, r105);
        if (r100 == false) goto L38;
        int r108 = r101 - r103;
        if (r108 < (r102 + 1)) goto L38;
        if (r108 > (r114 - 1)) goto L38;
        if (r113.get(r108) > r105) goto L38;
        Snake r115 = new Snake();
        r115.startX = r104;
        r115.startY = r107;
        r115.endX = r105;
        r115.endY = r106;
        r115.reverse = false;
        return r115;
    L38:
        r103 = r103 + 2;
    L20:
        r107 = r106;
        goto L22
    L11:
        if (r112.get(r103 + 1) <= r112.get(r103 - 1)) goto L13;
    L14:
        r104 = r112.get(r103 + 1);
        r105 = r104;
        goto L15
    L39:
        return null;
    }
}
