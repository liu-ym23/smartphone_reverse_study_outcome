package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class AdapterAddressItemBinding {

    @NonNull
    public final TextView district;

    @NonNull
    public final ImageView image;

    @NonNull
    public final TextView name;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ConstraintLayout viewRoot;

    private AdapterAddressItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.district = textView;
        this.image = imageView;
        this.name = textView2;
        this.viewRoot = constraintLayout2;
    }

    @NonNull
    public static AdapterAddressItemBinding bind(@NonNull View view) {
        int i4 = R.id.district;
        TextView textView = (TextView) h.n(i4, view);
        if (textView != null) {
            i4 = R.id.image;
            ImageView imageView = (ImageView) h.n(i4, view);
            if (imageView != null) {
                i4 = R.id.name;
                TextView textView2 = (TextView) h.n(i4, view);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new AdapterAddressItemBinding(constraintLayout, textView, imageView, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AdapterAddressItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdapterAddressItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.adapter_address_item, viewGroup, false);
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
