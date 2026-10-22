package com.android.common.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class CompositeCursorAdapter extends BaseAdapter {
    private static final int INITIAL_CAPACITY = 2;
    private boolean mCacheValid;
    private final Context mContext;
    private int mCount;
    private boolean mNotificationNeeded;
    private boolean mNotificationsEnabled;
    private ArrayList<Partition> mPartitions;

    public static class Partition {
        int count;
        Cursor cursor;
        boolean hasHeader;
        int idColumnIndex;
        boolean showIfEmpty;

        public Partition(boolean r1, boolean r2) {
            this.showIfEmpty = r1;
            this.hasHeader = r2;
        }

        public boolean getShowIfEmpty() {
            return this.showIfEmpty;
        }

        public boolean getHasHeader() {
            return this.hasHeader;
        }

        public boolean isEmpty() {
            if (this.count != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    protected void bindHeaderView(View r1, int r2, Cursor r3) {
    }

    protected abstract void bindView(View r1, int r2, Cursor r3, int r4);

    protected int getItemViewType(int r1, int r2) {
        return 1;
    }

    public int getItemViewTypeCount() {
        return 1;
    }

    protected boolean isEnabled(int r1, int r2) {
        return true;
    }

    protected View newHeaderView(Context r1, int r2, Cursor r3, ViewGroup r4) {
        return null;
    }

    protected abstract View newView(Context r1, int r2, Cursor r3, int r4, ViewGroup r5);

    public CompositeCursorAdapter(Context r2) {
        this(r2, 2);
    }

    public CompositeCursorAdapter(Context r1, int r2) {
        this.mCount = 0;
        this.mCacheValid = true;
        this.mNotificationsEnabled = true;
        this.mContext = r1;
        this.mPartitions = new ArrayList();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void addPartition(boolean r2, boolean r3) {
        addPartition(new Partition(r2, r3));
    }

    public void addPartition(Partition r2) {
        this.mPartitions.add(r2);
        invalidate();
        notifyDataSetChanged();
    }

    public void addPartition(int r2, Partition r3) {
        this.mPartitions.add(r2, r3);
        invalidate();
        notifyDataSetChanged();
    }

    public void removePartition(int r3) {
        Cursor r0 = this.mPartitions.get(r3).cursor;
        if (r0 != null) goto L5;
    L7:
        this.mPartitions.remove(r3);
        invalidate();
        notifyDataSetChanged();
        return;
    L5:
        if (r0.isClosed() == true) goto L7;
        r0.close();
        goto L7
    }

    public void clearPartitions() {
        Iterator<Partition> r0 = this.mPartitions.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cursor = null;
        goto L4
    L6:
        invalidate();
        notifyDataSetChanged();
    }

    public void close() {
        Iterator<Partition> r0 = this.mPartitions.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Cursor r1 = r0.next().cursor;
        if (r1 == null) goto L4;
        if (r1.isClosed() == true) goto L4;
        r1.close();
        goto L4
    L10:
        this.mPartitions.clear();
        invalidate();
        notifyDataSetChanged();
    }

    public void setHasHeader(int r2, boolean r3) {
        this.mPartitions.get(r2).hasHeader = r3;
        invalidate();
    }

    public void setShowIfEmpty(int r2, boolean r3) {
        this.mPartitions.get(r2).showIfEmpty = r3;
        invalidate();
    }

    public Partition getPartition(int r1) {
        return this.mPartitions.get(r1);
    }

    protected void invalidate() {
        this.mCacheValid = false;
    }

    public int getPartitionCount() {
        return this.mPartitions.size();
    }

    protected void ensureCacheValid() {
        if (this.mCacheValid == false) goto L5;
        return;
    L5:
        this.mCount = 0;
        Iterator<Partition> r1 = this.mPartitions.iterator();
    L7:
        if (r1.hasNext() == false) goto L22;
        Partition r2 = r1.next();
        Cursor r3 = r2.cursor;
        if (r3 != null) goto L11;
    L14:
        int r4 = 0;
    L16:
        if (r2.hasHeader == false) goto L21;
        if (r4 == 0) goto L19;
    L20:
        r4 = r4 + 1;
        goto L21
    L19:
        if (r2.showIfEmpty == true) goto L20;
    L21:
        r2.count = r4;
        this.mCount += r4;
        goto L7
    L11:
        if (r3.isClosed() == true) goto L14;
        r4 = r3.getCount();
        goto L16
    L22:
        this.mCacheValid = true;
    }

    public boolean hasHeader(int r1) {
        return this.mPartitions.get(r1).hasHeader;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ensureCacheValid();
        return this.mCount;
    }

    public Cursor getCursor(int r1) {
        return this.mPartitions.get(r1).cursor;
    }

    public void changeCursor(int r3, Cursor r4) {
        Cursor r0 = this.mPartitions.get(r3).cursor;
        if (r0 == r4) goto L15;
        if (r0 != null) goto L6;
    L8:
        this.mPartitions.get(r3).cursor = r4;
        if (r4 != null) goto L11;
    L13:
        invalidate();
        notifyDataSetChanged();
        return;
    L11:
        if (r4.isClosed() == true) goto L13;
        Partition r5 = this.mPartitions.get(r3);
        r5.idColumnIndex = r4.getColumnIndex("_id");
        goto L13
    L6:
        if (r0.isClosed() == true) goto L8;
        r0.close();
        goto L8
    }

    public boolean isPartitionEmpty(int r1) {
        Cursor r0 = this.mPartitions.get(r1).cursor;
        if (r0 != null) goto L5;
    L10:
        return true;
    L5:
        if (r0.isClosed() == true) goto L10;
        if (r0.getCount() == 0) goto L10;
        return false;
    }

    public int getPartitionForPosition(int r5) {
        ensureCacheValid();
        int r0 = this.mPartitions.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r3 = this.mPartitions.get(r1).count + r2;
        if (r5 < r2) goto L8;
        if (r5 >= r3) goto L8;
        return r1;
    L8:
        r1 = r1 + 1;
        r2 = r3;
        goto L3
    L9:
        return -1;
    }

    public int getOffsetInPartition(int r4) {
        ensureCacheValid();
        Iterator<Partition> r3 = this.mPartitions.iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Partition r1 = r3.next();
        int r2 = r1.count + r0;
        if (r4 < r0) goto L12;
        if (r4 >= r2) goto L12;
        int r5 = r4 - r0;
        if (r1.hasHeader == true) goto L11;
        return r5;
    L11:
        return r5 - 1;
    L12:
        r0 = r2;
        goto L4
    L13:
        return -1;
    }

    public int getPositionForPartition(int r4) {
        ensureCacheValid();
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L5;
        r1 = r1 + this.mPartitions.get(r0).count;
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return getItemViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r5) {
        ensureCacheValid();
        int r0 = this.mPartitions.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L17;
        int r3 = this.mPartitions.get(r1).count + r2;
        if (r5 < r2) goto L15;
        if (r5 >= r3) goto L15;
        int r6 = r5 - r2;
        if (this.mPartitions.get(r1).hasHeader == false) goto L11;
        r6 = r6 - 1;
    L11:
        if (r6 != (-1)) goto L14;
        return -1;
    L14:
        return getItemViewType(r1, r6);
    L15:
        r1 = r1 + 1;
        r2 = r3;
        goto L3
    L17:
        throw new ArrayIndexOutOfBoundsException(r5);
    }

    @Override // android.widget.Adapter
    public View getView(int r9, View r10, ViewGroup r11) {
        ensureCacheValid();
        int r0 = this.mPartitions.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L24;
        int r3 = this.mPartitions.get(r1).count + r2;
        if (r9 < r2) goto L22;
        if (r9 >= r3) goto L22;
        int r12 = r9 - r2;
        if (this.mPartitions.get(r1).hasHeader == false) goto L11;
        r12 = r12 - 1;
    L11:
        if (r12 != (-1)) goto L14;
        View r8 = getHeaderView(r1, this.mPartitions.get(r1).cursor, r10, r11);
    L16:
        if (r8 == null) goto L19;
        return r8;
    L19:
        throw new NullPointerException("View should not be null, partition: " + r1 + " position: " + r12);
    L14:
        if (this.mPartitions.get(r1).cursor.moveToPosition(r12) == false) goto L21;
        r8 = getView(r1, this.mPartitions.get(r1).cursor, r12, r10, r11);
        goto L16
    L21:
        throw new IllegalStateException("Couldn't move cursor to position " + r12);
    L22:
        r1 = r1 + 1;
        r2 = r3;
        goto L3
    L24:
        throw new ArrayIndexOutOfBoundsException(r9);
    }

    protected View getHeaderView(int r1, Cursor r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L5;
        r3 = newHeaderView(this.mContext, r1, r2, r4);
    L5:
        bindHeaderView(r3, r1, r2);
        return r3;
    }

    protected View getView(int r7, Cursor r8, int r9, View r10, ViewGroup r11) {
        if (r10 != null) goto L5;
        r10 = newView(this.mContext, r7, r8, r9, r11);
    L5:
        bindView(r10, r7, r8, r9);
        return r10;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r5) {
        ensureCacheValid();
        Iterator<Partition> r4 = this.mPartitions.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L24;
        Partition r1 = r4.next();
        int r3 = r1.count + r0;
        if (r5 < r0) goto L23;
        if (r5 >= r3) goto L23;
        int r6 = r5 - r0;
        if (r1.hasHeader == false) goto L12;
        r6 = r6 - 1;
    L12:
        if (r6 != (-1)) goto L14;
        return null;
    L14:
        Cursor r7 = r1.cursor;
        if (r7 != null) goto L17;
    L22:
        return null;
    L17:
        if (r7.isClosed() == true) goto L22;
        if (r7.moveToPosition(r6) == false) goto L22;
        return r7;
    L23:
        r0 = r3;
        goto L4
    L24:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r6) {
        ensureCacheValid();
        Iterator<Partition> r5 = this.mPartitions.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L28;
        Partition r1 = r5.next();
        int r4 = r1.count + r0;
        if (r6 < r0) goto L27;
        if (r6 >= r4) goto L27;
        int r7 = r6 - r0;
        if (r1.hasHeader == false) goto L12;
        r7 = r7 - 1;
    L12:
        if (r7 != (-1)) goto L15;
        return 0;
    L15:
        if (r1.idColumnIndex != (-1)) goto L17;
        return 0;
    L17:
        Cursor r8 = r1.cursor;
        if (r8 != null) goto L20;
    L26:
        return 0;
    L20:
        if (r8.isClosed() == true) goto L26;
        if (r8.moveToPosition(r7) == false) goto L26;
        return r8.getLong(r1.idColumnIndex);
    L27:
        r0 = r4;
        goto L4
    L28:
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        Iterator<Partition> r1 = this.mPartitions.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().hasHeader == false) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r6) {
        ensureCacheValid();
        int r0 = this.mPartitions.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L14;
        int r4 = this.mPartitions.get(r2).count + r3;
        if (r6 < r3) goto L13;
        if (r6 >= r4) goto L13;
        int r7 = r6 - r3;
        if (this.mPartitions.get(r2).hasHeader == false) goto L12;
        if (r7 != 0) goto L12;
        return false;
    L12:
        return isEnabled(r2, r7);
    L13:
        r2 = r2 + 1;
        r3 = r4;
        goto L3
    L14:
        return false;
    }

    public void setNotificationsEnabled(boolean r1) {
        this.mNotificationsEnabled = r1;
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.mNotificationNeeded == false) goto L9;
        notifyDataSetChanged();
        return;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (this.mNotificationsEnabled == false) goto L5;
        this.mNotificationNeeded = false;
        super.notifyDataSetChanged();
        return;
    L5:
        this.mNotificationNeeded = true;
    }
}
