package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class AdapterPersonalCommonSingleItemBinding {

    @NonNull
    public final LinearLayout aboutLayout;

    @NonNull
    public final RadioButton btSelect;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView title;

    private AdapterPersonalCommonSingleItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.aboutLayout = linearLayout;
        this.btSelect = radioButton;
        this.title = textView;
    }

    @NonNull
    public static AdapterPersonalCommonSingleItemBinding bind(@NonNull View view) {
        int i4 = R.id.about_layout;
        LinearLayout linearLayout = (LinearLayout) h.n(i4, view);
        if (linearLayout != null) {
            i4 = R.id.bt_select;
            RadioButton radioButton = (RadioButton) h.n(i4, view);
            if (radioButton != null) {
                i4 = R.id.title;
                TextView textView = (TextView) h.n(i4, view);
                if (textView != null) {
                    return new AdapterPersonalCommonSingleItemBinding((ConstraintLayout) view, linearLayout, radioButton, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AdapterPersonalCommonSingleItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdapterPersonalCommonSingleItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.adapter_personal_common_single_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
