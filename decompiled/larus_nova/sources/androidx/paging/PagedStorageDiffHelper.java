package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

/* JADX INFO: loaded from: classes17.dex */
class PagedStorageDiffHelper {

    public static class OffsettingListUpdateCallback implements ListUpdateCallback {
        private final ListUpdateCallback mCallback;
        private final int mOffset;

        public OffsettingListUpdateCallback(int r100, ListUpdateCallback r101) {
            this.mOffset = r100;
            this.mCallback = r101;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int r100, int r101) {
            this.mCallback.onInserted(r100 + this.mOffset, r101);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int r100, int r101) {
            ListUpdateCallback r102 = this.mCallback;
            int r103 = this.mOffset;
            r102.onMoved(r100 + r103, r101 + r103);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int r100, int r101) {
            this.mCallback.onRemoved(r100 + this.mOffset, r101);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int r100, int r101, Object r102) {
            this.mCallback.onChanged(r100 + this.mOffset, r101, r102);
        }
    }

    private PagedStorageDiffHelper() {
    }

    public static <T> DiffUtil.DiffResult computeDiff(final PagedStorage<T> r100, final PagedStorage<T> r101, final DiffUtil.ItemCallback<T> r110) {
        final int r102 = r100.computeLeadingNulls();
        int r103 = r101.computeLeadingNulls();
        final int r104 = (r100.size() - r102) - r100.computeTrailingNulls();
        final int r105 = (r101.size() - r103) - r101.computeTrailingNulls();
        return DiffUtil.calculateDiff(new AnonymousClass1(r100, r102, r101, r110, r104, r105), true);
    }

    public static <T> void dispatchDiff(ListUpdateCallback r100, PagedStorage<T> r101, PagedStorage<T> r102, DiffUtil.DiffResult r103) {
        int r104 = r101.computeTrailingNulls();
        int r105 = r102.computeTrailingNulls();
        int r106 = r101.computeLeadingNulls();
        int r107 = r102.computeLeadingNulls();
        if (r104 != 0) goto L9;
        if (r105 != 0) goto L9;
        if (r106 != 0) goto L9;
        if (r107 != 0) goto L9;
        r103.dispatchUpdatesTo(r100);
        return;
    L9:
        if (r104 <= r105) goto L11;
        int r108 = r104 - r105;
        r100.onRemoved(r101.size() - r108, r108);
    L14:
        if (r106 <= r107) goto L16;
        r100.onRemoved(0, r106 - r107);
    L18:
        if (r107 == 0) goto L20;
        r103.dispatchUpdatesTo(new OffsettingListUpdateCallback(r107, r100));
        return;
    L20:
        r103.dispatchUpdatesTo(r100);
        return;
    L16:
        if (r106 >= r107) goto L18;
        r100.onInserted(0, r107 - r106);
        goto L18
    L11:
        if (r104 >= r105) goto L14;
        r100.onInserted(r101.size(), r105 - r104);
        goto L14
    }

    public static int transformAnchorIndex(DiffUtil.DiffResult r100, PagedStorage r101, PagedStorage r102, int r110) {
        int r103 = r101.computeLeadingNulls();
        int r104 = r110 - r103;
        int r105 = (r101.size() - r103) - r101.computeTrailingNulls();
        if (r104 < 0) goto L24;
        if (r104 >= r105) goto L24;
        int r106 = 0;
    L7:
        if (r106 >= 30) goto L24;
        int r107 = r106 / 2;
        if ((r106 % 2) != 1) goto L11;
        int r108 = -1;
    L12:
        int r109 = (r107 * r108) + r104;
        if (r109 < 0) goto L22;
        if (r109 >= r101.getStorageCount()) goto L22;
        int r111 = r100.convertOldPositionToNew(r109);     // Catch: IndexOutOfBoundsException -> L25
        if (r111 == (-1)) goto L22;
        return r111 + r102.getLeadingNullCount();
    L22:
        r106 = r106 + 1;
        goto L7
    L11:
        r108 = 1;
    L24:
        return Math.max(0, Math.min(r110, r102.size() - 1));
    }
}
