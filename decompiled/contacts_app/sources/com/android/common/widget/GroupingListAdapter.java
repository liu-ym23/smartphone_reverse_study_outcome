package com.android.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class GroupingListAdapter extends BaseAdapter {
    private static final long EXPANDED_GROUP_MASK = Long.MIN_VALUE;
    private static final int GROUP_METADATA_ARRAY_INCREMENT = 128;
    private static final int GROUP_METADATA_ARRAY_INITIAL_SIZE = 16;
    private static final long GROUP_OFFSET_MASK = 4294967295L;
    private static final long GROUP_SIZE_MASK = 9223372032559808512L;
    public static final int ITEM_TYPE_GROUP_HEADER = 1;
    public static final int ITEM_TYPE_IN_GROUP = 2;
    public static final int ITEM_TYPE_STANDALONE = 0;
    protected ContentObserver mChangeObserver;
    private Context mContext;
    private int mCount;
    private Cursor mCursor;
    protected DataSetObserver mDataSetObserver;
    private int mGroupCount;
    private long[] mGroupMetadata;
    private int mLastCachedCursorPosition;
    private int mLastCachedGroup;
    private int mLastCachedListPosition;
    private SparseIntArray mPositionCache;
    private PositionMetadata mPositionMetadata;
    private int mRowIdColumnIndex;

    protected static class PositionMetadata {
        int childCount;
        int cursorPosition;
        private int groupPosition;
        boolean isExpanded;
        int itemType;
        private int listPosition;

        protected PositionMetadata() {
            this.listPosition = -1;
        }

        static /* synthetic */ int access$000(PositionMetadata r0) {
            return r0.listPosition;
        }

        static /* synthetic */ int access$002(PositionMetadata r0, int r1) {
            r0.listPosition = r1;
            return r1;
        }

        static /* synthetic */ int access$100(PositionMetadata r0) {
            return r0.groupPosition;
        }

        static /* synthetic */ int access$102(PositionMetadata r0, int r1) {
            r0.groupPosition = r1;
            return r1;
        }
    }

    private int idealByteArraySize(int r2) {
        int r1 = 4;
    L4:
        if (r1 >= 32) goto L9;
        int r0 = (1 << r1) - 12;
        if (r2 <= r0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return r2;
    }

    protected abstract void addGroups(Cursor r1);

    protected abstract void bindChildView(View r1, Context r2, Cursor r3);

    protected abstract void bindGroupView(View r1, Context r2, Cursor r3, int r4, boolean r5);

    protected abstract void bindStandAloneView(View r1, Context r2, Cursor r3);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    protected abstract View newChildView(Context r1, ViewGroup r2);

    protected abstract View newGroupView(Context r1, ViewGroup r2);

    protected abstract View newStandAloneView(Context r1, ViewGroup r2);

    protected void onContentChanged() {
    }

    public GroupingListAdapter(Context r3) {
        this.mPositionCache = new SparseIntArray();
        this.mPositionMetadata = new PositionMetadata();
        final Handler r1 = new Handler();
        this.mChangeObserver = new AnonymousClass1(this, r1);
        this.mDataSetObserver = new AnonymousClass2(this);
        this.mContext = r3;
        resetCache();
    }

    private void resetCache() {
        this.mCount = -1;
        this.mLastCachedListPosition = -1;
        this.mLastCachedCursorPosition = -1;
        this.mLastCachedGroup = -1;
        PositionMetadata.access$002(this.mPositionMetadata, -1);
        this.mPositionCache.clear();
    }

    public void changeCursor(Cursor r3) {
        Cursor r0 = this.mCursor;
        if (r3 != r0) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.unregisterContentObserver(this.mChangeObserver);
        this.mCursor.unregisterDataSetObserver(this.mDataSetObserver);
        this.mCursor.close();
    L7:
        this.mCursor = r3;
        resetCache();
        findGroups();
        if (r3 == null) goto L10;
        r3.registerContentObserver(this.mChangeObserver);
        r3.registerDataSetObserver(this.mDataSetObserver);
        this.mRowIdColumnIndex = r3.getColumnIndexOrThrow("_id");
        notifyDataSetChanged();
        return;
    L10:
        notifyDataSetInvalidated();
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    private void findGroups() {
        this.mGroupCount = 0;
        this.mGroupMetadata = new long[16];
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L5;
        return;
    L5:
        addGroups(r0);
    }

    protected void addGroup(int r5, int r6, boolean r7) {
        int r0 = this.mGroupCount;
        long[] r1 = this.mGroupMetadata;
        if (r0 < r1.length) goto L5;
        long[] r2 = new long[idealLongArraySize(r1.length + 128)];
        System.arraycopy(this.mGroupMetadata, 0, r2, 0, this.mGroupCount);
        this.mGroupMetadata = r2;
    L5:
        long r8 = r5 | (((long) r6) << 32);
        if (r7 == false) goto L8;
        r8 = r8 | Long.MIN_VALUE;
    L8:
        long[] r9 = this.mGroupMetadata;
        int r3 = this.mGroupCount;
        this.mGroupCount = r3 + 1;
        r9[r3] = r8;
    }

    private int idealLongArraySize(int r1) {
        return idealByteArraySize(r1 * 8) / 8;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mCursor != null) goto L5;
        return 0;
    L5:
        int r0 = this.mCount;
        if (r0 == (-1)) goto L8;
        return r0;
    L8:
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L10:
        if (r1 >= this.mGroupCount) goto L20;
        long r4 = this.mGroupMetadata[r1];
        int r6 = (int) (GROUP_OFFSET_MASK & r4);
        if ((Long.MIN_VALUE & r4) == 0) goto L14;
        boolean r7 = true;
    L15:
        int r5 = (int) ((r4 & GROUP_SIZE_MASK) >> 32);
        int r8 = r2 + (r6 - r3);
        if (r7 == false) goto L18;
        r2 = r8 + (r5 + 1);
    L19:
        r3 = r6 + r5;
        r1 = r1 + 1;
        goto L10
    L18:
        r2 = r8 + 1;
        goto L19
    L14:
        r7 = false;
        goto L15
    L20:
        int r9 = (r2 + this.mCursor.getCount()) - r3;
        this.mCount = r9;
        return r9;
    }

    public void obtainPositionMetadata(PositionMetadata r19, int r20) {
        if (PositionMetadata.access$000(r19) != r20) goto L5;
        return;
    L5:
        int r3 = this.mLastCachedListPosition;
        if (r3 == (-1)) goto L15;
        if (r20 > r3) goto L16;
        int r4 = this.mPositionCache.indexOfKey(r20);
        if (r4 >= 0) goto L13;
        r4 = (~r4) - 1;
        if (r4 < this.mPositionCache.size()) goto L13;
        r4 = r4 - 1;
    L13:
        if (r4 < 0) goto L15;
        int r6 = this.mPositionCache.keyAt(r4);
        int r5 = this.mPositionCache.valueAt(r4);
        int r9 = (int) (this.mGroupMetadata[r5] & GROUP_OFFSET_MASK);
    L18:
        if (r5 >= this.mGroupCount) goto L41;
        long r10 = this.mGroupMetadata[r5];
        int r12 = (int) (r10 & GROUP_OFFSET_MASK);
        int r7 = r6 + (r12 - r9);
        if (r5 <= this.mLastCachedGroup) goto L22;
        this.mPositionCache.append(r7, r5);
        this.mLastCachedListPosition = r7;
        this.mLastCachedCursorPosition = r12;
        this.mLastCachedGroup = r5;
    L22:
        if (r20 < r7) goto L23;
        if ((Long.MIN_VALUE & r10) == 0) goto L28;
        boolean r11 = true;
    L29:
        int r13 = (int) ((r10 & GROUP_SIZE_MASK) >> 32);
        if (r20 == r7) goto L31;
        if (r11 == true) goto L35;
        r6 = r7 + 1;
    L40:
        r9 = r12 + r13;
        r5 = r5 + 1;
        goto L18
    L35:
        if (r20 < ((r7 + r13) + 1)) goto L36;
        r6 = r7 + (r13 + 1);
        goto L40
    L36:
        r19.itemType = 2;
        r19.cursorPosition = (r12 + (r20 - r7)) - 1;
        return;
    L31:
        r19.itemType = 1;
        PositionMetadata.access$102(r19, r5);
        r19.isExpanded = r11;
        r19.childCount = r13;
        r19.cursorPosition = r12;
        return;
    L28:
        r11 = false;
        goto L29
    L23:
        r19.itemType = 0;
        r19.cursorPosition = r12 - (r7 - r20);
        return;
    L41:
        r19.itemType = 0;
        r19.cursorPosition = r9 + (r20 - r6);
        return;
    L16:
        int r8 = this.mLastCachedGroup;
        r9 = this.mLastCachedCursorPosition;
        r6 = r3;
        r5 = r8;
    L15:
        r5 = 0;
        r6 = 0;
        r9 = 0;
        goto L18
    }

    public boolean isGroupHeader(int r2) {
        obtainPositionMetadata(this.mPositionMetadata, r2);
        if (this.mPositionMetadata.itemType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getGroupSize(int r2) {
        obtainPositionMetadata(this.mPositionMetadata, r2);
        return this.mPositionMetadata.childCount;
    }

    public void toggleGroup(int r6) {
        obtainPositionMetadata(this.mPositionMetadata, r6);
        if (this.mPositionMetadata.itemType != 1) goto L11;
        if (this.mPositionMetadata.isExpanded == false) goto L7;
        long[] r7 = this.mGroupMetadata;
        int r0 = PositionMetadata.access$100(this.mPositionMetadata);
        r7[r0] = r7[r0] & Long.MAX_VALUE;
    L8:
        resetCache();
        notifyDataSetChanged();
        return;
    L7:
        long[] r8 = this.mGroupMetadata;
        int r1 = PositionMetadata.access$100(this.mPositionMetadata);
        r8[r1] = r8[r1] | Long.MIN_VALUE;
        goto L8
    L11:
        throw new IllegalArgumentException("Not a group at position " + r6);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r2) {
        obtainPositionMetadata(this.mPositionMetadata, r2);
        return this.mPositionMetadata.itemType;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r3) {
        if (this.mCursor != null) goto L5;
        return null;
    L5:
        obtainPositionMetadata(this.mPositionMetadata, r3);
        if (this.mCursor.moveToPosition(this.mPositionMetadata.cursorPosition) == true) goto L8;
        return null;
    L8:
        return this.mCursor;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        if (getItem(r1) != null) goto L5;
        return -1;
    L5:
        return this.mCursor.getLong(this.mRowIdColumnIndex);
    }

    @Override // android.widget.Adapter
    public View getView(int r8, View r9, ViewGroup r10) {
        obtainPositionMetadata(this.mPositionMetadata, r8);
        if (r9 != null) goto L12;
        int r1 = this.mPositionMetadata.itemType;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L12;
        r9 = newChildView(this.mContext, r10);
        goto L12
    L10:
        r9 = newGroupView(this.mContext, r10);
        goto L12
    L11:
        r9 = newStandAloneView(this.mContext, r10);
    L12:
        this.mCursor.moveToPosition(this.mPositionMetadata.cursorPosition);
        int r11 = this.mPositionMetadata.itemType;
        if (r11 == 0) goto L19;
        if (r11 == 1) goto L18;
        if (r11 != 2) goto L20;
        bindChildView(r9, this.mContext, this.mCursor);
    L20:
        return r9;
    L18:
        View r2 = r9;
        bindGroupView(r2, this.mContext, this.mCursor, this.mPositionMetadata.childCount, this.mPositionMetadata.isExpanded);
        goto L20
    L19:
        bindStandAloneView(r9, this.mContext, this.mCursor);
        goto L20
    }
}
