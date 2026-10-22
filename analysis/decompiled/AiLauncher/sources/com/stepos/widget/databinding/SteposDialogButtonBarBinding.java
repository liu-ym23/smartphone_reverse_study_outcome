package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposDialogButtonBarBinding {
    private final ScrollView rootView;
    public final ConstraintLayout steposDialogButtonBar;
    public final StepOSButton steposDialogButtonNegative;
    public final StepOSButton steposDialogButtonNeutral;
    public final ScrollView steposDialogButtonPanel;
    public final StepOSButton steposDialogButtonPositive;

    private SteposDialogButtonBarBinding(ScrollView scrollView, ConstraintLayout constraintLayout, StepOSButton stepOSButton, StepOSButton stepOSButton2, ScrollView scrollView2, StepOSButton stepOSButton3) {
        this.rootView = scrollView;
        this.steposDialogButtonBar = constraintLayout;
        this.steposDialogButtonNegative = stepOSButton;
        this.steposDialogButtonNeutral = stepOSButton2;
        this.steposDialogButtonPanel = scrollView2;
        this.steposDialogButtonPositive = stepOSButton3;
    }

    public static SteposDialogButtonBarBinding bind(View view) {
        int i10 = R.id.stepos_dialog_button_bar;
        ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.stepos_dialog_button_negative;
            StepOSButton stepOSButton = (StepOSButton) C5437a.a(view, i10);
            if (stepOSButton != null) {
                i10 = R.id.stepos_dialog_button_neutral;
                StepOSButton stepOSButton2 = (StepOSButton) C5437a.a(view, i10);
                if (stepOSButton2 != null) {
                    ScrollView scrollView = (ScrollView) view;
                    i10 = R.id.stepos_dialog_button_positive;
                    StepOSButton stepOSButton3 = (StepOSButton) C5437a.a(view, i10);
                    if (stepOSButton3 != null) {
                        return new SteposDialogButtonBarBinding(scrollView, constraintLayout, stepOSButton, stepOSButton2, scrollView, stepOSButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposDialogButtonBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogButtonBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_button_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
