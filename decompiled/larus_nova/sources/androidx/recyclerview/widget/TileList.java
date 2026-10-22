package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes17.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles;

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public boolean containsPosition(int r100) {
            int r101 = this.mStartPosition;
            if (r101 <= r100) goto L5;
        L7:
            return false;
        L5:
            if (r100 >= (r101 + this.mItemCount)) goto L7;
            return true;
        }

        public T getByPosition(int r100) {
            return this.mItems[r100 - this.mStartPosition];
        }

        public Tile(Class<T> r100, int r101) {
            this.mItems = (T[]) ((Object[]) Array.newInstance(r100, r101));
        }
    }

    public void clear() {
        this.mTiles.clear();
    }

    public int size() {
        return this.mTiles.size();
    }

    public TileList(int r100) {
        this.mTiles = new SparseArray(10);
        this.mTileSize = r100;
    }

    public Tile<T> addOrReplace(Tile<T> r100) {
        int r101 = this.mTiles.indexOfKey(r100.mStartPosition);
        if (r101 >= 0) goto L6;
        this.mTiles.put(r100.mStartPosition, r100);
        return null;
    L6:
        Tile<T> r102 = this.mTiles.valueAt(r101);
        this.mTiles.setValueAt(r101, r100);
        if (this.mLastAccessedTile != r102) goto L9;
        this.mLastAccessedTile = r100;
    L9:
        return r102;
    }

    public Tile<T> getAtIndex(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.mTiles.size()) goto L7;
        return null;
    L7:
        return this.mTiles.valueAt(r100);
    }

    public T getItemAt(int r100) {
        Tile<T> r101 = this.mLastAccessedTile;
        if (r101 != null) goto L5;
    L6:
        int r102 = r100 - (r100 % this.mTileSize);
        int r103 = this.mTiles.indexOfKey(r102);
        if (r103 >= 0) goto L10;
        return null;
    L10:
        this.mLastAccessedTile = this.mTiles.valueAt(r103);
    L12:
        return this.mLastAccessedTile.getByPosition(r100);
    L5:
        if (r101.containsPosition(r100) == true) goto L12;
        goto L6
    }

    public Tile<T> removeAtPos(int r100) {
        Tile<T> r101 = this.mTiles.get(r100);
        if (this.mLastAccessedTile != r101) goto L5;
        this.mLastAccessedTile = null;
    L5:
        this.mTiles.delete(r100);
        return r101;
    }
}
