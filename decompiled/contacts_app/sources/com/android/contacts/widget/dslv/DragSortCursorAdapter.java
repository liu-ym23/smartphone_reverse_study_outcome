package com.android.contacts.widget.dslv;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DragSortCursorAdapter extends CursorAdapter implements DragSortListView.DragSortListener {
    public static final int REMOVED = -1;
    private SparseIntArray mListMapping;
    private ArrayList<Integer> mRemovedCursorPositions;

    @Override // com.android.contacts.widget.dslv.DragSortListView.DragListener
    public void drag(int r1, int r2) {
    }

    public DragSortCursorAdapter(Context r1, Cursor r2) {
        super(r1, r2);
        this.mListMapping = new SparseIntArray();
        this.mRemovedCursorPositions = new ArrayList();
    }

    public DragSortCursorAdapter(Context r1, Cursor r2, boolean r3) {
        super(r1, r2, r3);
        this.mListMapping = new SparseIntArray();
        this.mRemovedCursorPositions = new ArrayList();
    }

    public DragSortCursorAdapter(Context r1, Cursor r2, int r3) {
        super(r1, r2, r3);
        this.mListMapping = new SparseIntArray();
        this.mRemovedCursorPositions = new ArrayList();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r1) {
        Cursor r2 = super.swapCursor(r1);
        resetMappings();
        return r2;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r1) {
        super.changeCursor(r1);
        resetMappings();
    }

    public void reset() {
        resetMappings();
        notifyDataSetChanged();
    }

    private void resetMappings() {
        this.mListMapping.clear();
        this.mRemovedCursorPositions.clear();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int r2) {
        return super.getItem(this.mListMapping.get(r2, r2));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int r2) {
        return super.getItemId(this.mListMapping.get(r2, r2));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        return super.getDropDownView(this.mListMapping.get(r2, r2), r3, r4);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        return super.getView(this.mListMapping.get(r2, r2), r3, r4);
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.DropListener
    public void drop(int r5, int r6) {
        if (r5 == r6) goto L13;
        int r0 = this.mListMapping.get(r5, r5);
        if (r5 <= r6) goto L7;
    L5:
        if (r5 <= r6) goto L9;
        SparseIntArray r1 = this.mListMapping;
        int r2 = r5 - 1;
        r1.put(r5, r1.get(r2, r2));
        r5 = r5 - 1;
    L9:
        this.mListMapping.put(r6, r0);
        cleanMapping();
        notifyDataSetChanged();
        return;
    L7:
        if (r5 >= r6) goto L9;
        SparseIntArray r3 = this.mListMapping;
        int r4 = r5 + 1;
        r3.put(r5, r3.get(r4, r4));
        r5 = r4;
        goto L7
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.RemoveListener
    public void remove(int r5) {
        int r0 = this.mListMapping.get(r5, r5);
        if (this.mRemovedCursorPositions.contains(Integer.valueOf(r0)) == true) goto L5;
        this.mRemovedCursorPositions.add(Integer.valueOf(r0));
    L5:
        int r1 = getCount();
    L6:
        if (r5 >= r1) goto L8;
        SparseIntArray r2 = this.mListMapping;
        int r3 = r5 + 1;
        r2.put(r5, r2.get(r3, r3));
        r5 = r3;
        goto L6
    L8:
        this.mListMapping.delete(r1);
        cleanMapping();
        notifyDataSetChanged();
    }

    private void cleanMapping() {
        ArrayList r0 = new ArrayList();
        int r1 = this.mListMapping.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (this.mListMapping.keyAt(r3) != this.mListMapping.valueAt(r3)) goto L7;
        r0.add(Integer.valueOf(this.mListMapping.keyAt(r3)));
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        int r4 = r0.size();
    L9:
        if (r2 >= r4) goto L11;
        this.mListMapping.delete(((Integer) r0.get(r2)).intValue());
        r2 = r2 + 1;
        goto L9
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() - this.mRemovedCursorPositions.size();
    }

    public int getCursorPosition(int r1) {
        return this.mListMapping.get(r1, r1);
    }

    public ArrayList<Integer> getCursorPositions() {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= getCount()) goto L6;
        r0.add(Integer.valueOf(this.mListMapping.get(r1, r1)));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public int getListPosition(int r3) {
        if (this.mRemovedCursorPositions.contains(Integer.valueOf(r3)) == false) goto L6;
        return -1;
    L6:
        int r0 = this.mListMapping.indexOfValue(r3);
        if (r0 >= 0) goto L10;
        return r3;
    L10:
        return this.mListMapping.keyAt(r0);
    }
}
