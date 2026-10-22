package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.R;
import com.stepos.widget.menu.StepOSMenuPanel;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposMenuBinding {
    private final FrameLayout rootView;
    public final FrameLayout steposMenuListContainer;
    public final StepOSMenuPanel steposMenuPanel;
    public final RecyclerView steposMenuRecycler;
    public final FrameLayout steposMenuRoot;
    public final View steposMenuScrollbar;

    private SteposMenuBinding(FrameLayout frameLayout, FrameLayout frameLayout2, StepOSMenuPanel stepOSMenuPanel, RecyclerView recyclerView, FrameLayout frameLayout3, View view) {
        this.rootView = frameLayout;
        this.steposMenuListContainer = frameLayout2;
        this.steposMenuPanel = stepOSMenuPanel;
        this.steposMenuRecycler = recyclerView;
        this.steposMenuRoot = frameLayout3;
        this.steposMenuScrollbar = view;
    }

    public static SteposMenuBinding bind(View view) {
        int i10 = R.id.stepos_menu_list_container;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.stepos_menu_panel;
            StepOSMenuPanel stepOSMenuPanel = (StepOSMenuPanel) C5437a.a(view, i10);
            if (stepOSMenuPanel != null) {
                i10 = R.id.stepos_menu_recycler;
                RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                if (recyclerView != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view;
                    i10 = R.id.stepos_menu_scrollbar;
                    View viewA = C5437a.a(view, i10);
                    if (viewA != null) {
                        return new SteposMenuBinding(frameLayout2, frameLayout, stepOSMenuPanel, recyclerView, frameLayout2, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
