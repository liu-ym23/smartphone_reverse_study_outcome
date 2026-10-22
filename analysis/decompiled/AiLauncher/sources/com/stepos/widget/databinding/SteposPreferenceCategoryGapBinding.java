package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposPreferenceCategoryGapBinding {
    private final View rootView;

    private SteposPreferenceCategoryGapBinding(View view) {
        this.rootView = view;
    }

    public static SteposPreferenceCategoryGapBinding bind(View view) {
        if (view != null) {
            return new SteposPreferenceCategoryGapBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    public static SteposPreferenceCategoryGapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public View getRoot() {
        return this.rootView;
    }

    public static SteposPreferenceCategoryGapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_preference_category_gap, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
