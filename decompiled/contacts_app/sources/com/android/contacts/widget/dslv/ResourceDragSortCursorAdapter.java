package com.android.contacts.widget.dslv;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResourceDragSortCursorAdapter extends DragSortCursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceDragSortCursorAdapter(Context r1, int r2, Cursor r3) {
        super(r1, r3);
        this.mDropDownLayout = r2;
        this.mLayout = r2;
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
    }

    public ResourceDragSortCursorAdapter(Context r1, int r2, Cursor r3, boolean r4) {
        super(r1, r3, r4);
        this.mDropDownLayout = r2;
        this.mLayout = r2;
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
    }

    public ResourceDragSortCursorAdapter(Context r1, int r2, Cursor r3, int r4) {
        super(r1, r3, r4);
        this.mDropDownLayout = r2;
        this.mLayout = r2;
        this.mInflater = (LayoutInflater) r1.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r1, Cursor r2, ViewGroup r3) {
        return this.mInflater.inflate(this.mLayout, r3, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context r1, Cursor r2, ViewGroup r3) {
        return this.mInflater.inflate(this.mDropDownLayout, r3, false);
    }

    public void setViewResource(int r1) {
        this.mLayout = r1;
    }

    public void setDropDownViewResource(int r1) {
        this.mDropDownLayout = r1;
    }
}
