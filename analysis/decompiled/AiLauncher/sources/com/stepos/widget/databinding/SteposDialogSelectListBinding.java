package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.widget.R;
import com.stepos.widget.dialog.StepOSDialogListView;

/* loaded from: classes2.dex */
public final class SteposDialogSelectListBinding {
    private final StepOSDialogListView rootView;
    public final StepOSDialogListView steposDialogListView;

    private SteposDialogSelectListBinding(StepOSDialogListView stepOSDialogListView, StepOSDialogListView stepOSDialogListView2) {
        this.rootView = stepOSDialogListView;
        this.steposDialogListView = stepOSDialogListView2;
    }

    public static SteposDialogSelectListBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        StepOSDialogListView stepOSDialogListView = (StepOSDialogListView) view;
        return new SteposDialogSelectListBinding(stepOSDialogListView, stepOSDialogListView);
    }

    public static SteposDialogSelectListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogSelectListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_select_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public StepOSDialogListView getRoot() {
        return this.rootView;
    }
}
