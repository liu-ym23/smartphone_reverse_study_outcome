package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class AdapterPersonalCommonDoubleItemBinding {

    @NonNull
    public final RadioButton btSelect;

    @NonNull
    public final TextView content;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView title;

    private AdapterPersonalCommonDoubleItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RadioButton radioButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.btSelect = radioButton;
        this.content = textView;
        this.title = textView2;
    }

    @NonNull
    public static AdapterPersonalCommonDoubleItemBinding bind(@NonNull View view) {
        int i4 = R.id.bt_select;
        RadioButton radioButton = (RadioButton) h.n(i4, view);
        if (radioButton != null) {
            i4 = R.id.content;
            TextView textView = (TextView) h.n(i4, view);
            if (textView != null) {
                i4 = R.id.title;
                TextView textView2 = (TextView) h.n(i4, view);
                if (textView2 != null) {
                    return new AdapterPersonalCommonDoubleItemBinding((ConstraintLayout) view, radioButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AdapterPersonalCommonDoubleItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdapterPersonalCommonDoubleItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.adapter_personal_common_double_item, viewGroup, false);
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
