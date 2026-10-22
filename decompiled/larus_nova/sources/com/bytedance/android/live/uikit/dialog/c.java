package com.bytedance.android.live.uikit.dialog;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends CursorAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f102177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f102178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecycleListView f102179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f102180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a.b f102181e;

    @Override // android.widget.CursorAdapter
    public final void bindView(View r100, Context r101, Cursor r102) {
        ((CheckedTextView) r100.findViewById(R.id.text1)).setText(r102.getString(this.f102177a));
        RecycleListView r103 = this.f102179c;
        int r104 = r102.getPosition();
        boolean r105 = true;
        if (r102.getInt(this.f102178b) == 1) goto L6;
        r105 = false;
    L6:
        r103.setItemChecked(r104, r105);
    }

    @Override // android.widget.CursorAdapter
    public final View newView(Context r100, Cursor r101, ViewGroup r102) {
        return this.f102181e.f102149b.inflate(this.f102180d.H, r102, false);
    }

    public c(a.b r100, Context r101, Cursor r102, RecycleListView r103, a r104) {
        this.f102181e = r100;
        this.f102179c = r103;
        this.f102180d = r104;
        super(r101, r102, false);
        Cursor r105 = getCursor();
        this.f102177a = r105.getColumnIndexOrThrow(r100.H);
        this.f102178b = r105.getColumnIndexOrThrow(r100.I);
    }
}
