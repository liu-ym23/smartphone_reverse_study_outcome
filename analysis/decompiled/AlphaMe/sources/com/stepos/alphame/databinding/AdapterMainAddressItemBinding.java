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
public final class AdapterMainAddressItemBinding {

    @NonNull
    public final RadioButton mainAddressSelect;

    @NonNull
    public final TextView mainDistrict;

    @NonNull
    public final TextView mainName;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ConstraintLayout viewRoot;

    private AdapterMainAddressItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RadioButton radioButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.mainAddressSelect = radioButton;
        this.mainDistrict = textView;
        this.mainName = textView2;
        this.viewRoot = constraintLayout2;
    }

    @NonNull
    public static AdapterMainAddressItemBinding bind(@NonNull View view) {
        int i4 = R.id.main_address_select;
        RadioButton radioButton = (RadioButton) h.n(i4, view);
        if (radioButton != null) {
            i4 = R.id.main_district;
            TextView textView = (TextView) h.n(i4, view);
            if (textView != null) {
                i4 = R.id.main_name;
                TextView textView2 = (TextView) h.n(i4, view);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new AdapterMainAddressItemBinding(constraintLayout, radioButton, textView, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AdapterMainAddressItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdapterMainAddressItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.adapter_main_address_item, viewGroup, false);
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
