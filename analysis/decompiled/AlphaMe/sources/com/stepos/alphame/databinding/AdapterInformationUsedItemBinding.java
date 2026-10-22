package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;
import com.stepos.common.widget.Switch;

/* loaded from: classes.dex */
public final class AdapterInformationUsedItemBinding {

    @NonNull
    public final TextView informationUsedSummary;

    @NonNull
    public final Switch informationUsedSwitch;

    @NonNull
    public final TextView informationUsedTitle;

    @NonNull
    private final ConstraintLayout rootView;

    private AdapterInformationUsedItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull Switch r32, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.informationUsedSummary = textView;
        this.informationUsedSwitch = r32;
        this.informationUsedTitle = textView2;
    }

    @NonNull
    public static AdapterInformationUsedItemBinding bind(@NonNull View view) {
        int i4 = R.id.information_used_summary;
        TextView textView = (TextView) h.n(i4, view);
        if (textView != null) {
            i4 = R.id.information_used_switch;
            Switch r22 = (Switch) h.n(i4, view);
            if (r22 != null) {
                i4 = R.id.information_used_title;
                TextView textView2 = (TextView) h.n(i4, view);
                if (textView2 != null) {
                    return new AdapterInformationUsedItemBinding((ConstraintLayout) view, textView, r22, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AdapterInformationUsedItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdapterInformationUsedItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.adapter_information_used_item, viewGroup, false);
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
