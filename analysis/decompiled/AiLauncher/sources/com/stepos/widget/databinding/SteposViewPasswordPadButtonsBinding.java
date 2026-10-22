package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposViewPasswordPadButtonsBinding {
    private final LinearLayout rootView;
    public final StepOSButton steposPasswordPadLeftButton;
    public final StepOSButton steposPasswordPadRightButton;

    private SteposViewPasswordPadButtonsBinding(LinearLayout linearLayout, StepOSButton stepOSButton, StepOSButton stepOSButton2) {
        this.rootView = linearLayout;
        this.steposPasswordPadLeftButton = stepOSButton;
        this.steposPasswordPadRightButton = stepOSButton2;
    }

    public static SteposViewPasswordPadButtonsBinding bind(View view) {
        int i10 = R.id.stepos_password_pad_left_button;
        StepOSButton stepOSButton = (StepOSButton) C5437a.a(view, i10);
        if (stepOSButton != null) {
            i10 = R.id.stepos_password_pad_right_button;
            StepOSButton stepOSButton2 = (StepOSButton) C5437a.a(view, i10);
            if (stepOSButton2 != null) {
                return new SteposViewPasswordPadButtonsBinding((LinearLayout) view, stepOSButton, stepOSButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposViewPasswordPadButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposViewPasswordPadButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_view_password_pad_buttons, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
