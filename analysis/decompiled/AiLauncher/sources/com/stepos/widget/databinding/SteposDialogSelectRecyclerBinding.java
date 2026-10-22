package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposDialogSelectRecyclerBinding {
    private final RecyclerView rootView;
    public final RecyclerView steposDialogRecyclerView;

    private SteposDialogSelectRecyclerBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.steposDialogRecyclerView = recyclerView2;
    }

    public static SteposDialogSelectRecyclerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) view;
        return new SteposDialogSelectRecyclerBinding(recyclerView, recyclerView);
    }

    public static SteposDialogSelectRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogSelectRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_select_recycler, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }
}
