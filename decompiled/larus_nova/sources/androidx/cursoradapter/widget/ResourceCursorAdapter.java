package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    public void setDropDownViewResource(int r100) {
        this.mDropDownLayout = r100;
    }

    public void setViewResource(int r100) {
        this.mLayout = r100;
    }

    public ResourceCursorAdapter(Context r100, int r101, Cursor r102) {
        super(r100, r102);
        this.mDropDownLayout = r101;
        this.mLayout = r101;
        this.mInflater = (LayoutInflater) r100.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context r100, Cursor r101, ViewGroup r102) {
        return this.mInflater.inflate(this.mDropDownLayout, r102, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r100, Cursor r101, ViewGroup r102) {
        return this.mInflater.inflate(this.mLayout, r102, false);
    }

    public ResourceCursorAdapter(Context r100, int r101, Cursor r102, int r103) {
        super(r100, r102, r103);
        this.mDropDownLayout = r101;
        this.mLayout = r101;
        this.mInflater = (LayoutInflater) r100.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context r100, int r101, Cursor r102, boolean r103) {
        super(r100, r102, r103);
        this.mDropDownLayout = r101;
        this.mLayout = r101;
        this.mInflater = (LayoutInflater) r100.getSystemService("layout_inflater");
    }
}
