package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.widget.R;
import com.stepos.widget.panel.StepOSLiteSheetLayout;
import com.stepos.widget.panel.StepOSLiteSheetSurface;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposLiteSheetActivityBinding {
    private final StepOSLiteSheetLayout rootView;
    public final FrameLayout steposLiteSheetContent;
    public final FrameLayout steposLiteSheetGrabber;
    public final StepOSLiteSheetLayout steposLiteSheetRoot;
    public final View steposLiteSheetScrim;
    public final StepOSLiteSheetSurface steposLiteSheetSurface;
    public final StepOSTitleBar steposLiteSheetTitleBar;

    private SteposLiteSheetActivityBinding(StepOSLiteSheetLayout stepOSLiteSheetLayout, FrameLayout frameLayout, FrameLayout frameLayout2, StepOSLiteSheetLayout stepOSLiteSheetLayout2, View view, StepOSLiteSheetSurface stepOSLiteSheetSurface, StepOSTitleBar stepOSTitleBar) {
        this.rootView = stepOSLiteSheetLayout;
        this.steposLiteSheetContent = frameLayout;
        this.steposLiteSheetGrabber = frameLayout2;
        this.steposLiteSheetRoot = stepOSLiteSheetLayout2;
        this.steposLiteSheetScrim = view;
        this.steposLiteSheetSurface = stepOSLiteSheetSurface;
        this.steposLiteSheetTitleBar = stepOSTitleBar;
    }

    public static SteposLiteSheetActivityBinding bind(View view) {
        int i10 = R.id.stepos_lite_sheet_content;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.stepos_lite_sheet_grabber;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                StepOSLiteSheetLayout stepOSLiteSheetLayout = (StepOSLiteSheetLayout) view;
                i10 = R.id.stepos_lite_sheet_scrim;
                View viewA = C5437a.a(view, i10);
                if (viewA != null) {
                    i10 = R.id.stepos_lite_sheet_surface;
                    StepOSLiteSheetSurface stepOSLiteSheetSurface = (StepOSLiteSheetSurface) C5437a.a(view, i10);
                    if (stepOSLiteSheetSurface != null) {
                        i10 = R.id.stepos_lite_sheet_title_bar;
                        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                        if (stepOSTitleBar != null) {
                            return new SteposLiteSheetActivityBinding(stepOSLiteSheetLayout, frameLayout, frameLayout2, stepOSLiteSheetLayout, viewA, stepOSLiteSheetSurface, stepOSTitleBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposLiteSheetActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposLiteSheetActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_lite_sheet_activity, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public StepOSLiteSheetLayout getRoot() {
        return this.rootView;
    }
}
