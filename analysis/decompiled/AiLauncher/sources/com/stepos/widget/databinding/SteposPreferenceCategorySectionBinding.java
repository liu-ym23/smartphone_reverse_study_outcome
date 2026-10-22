package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposPreferenceCategorySectionBinding {
    private final TextView rootView;
    public final TextView title;

    private SteposPreferenceCategorySectionBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.title = textView2;
    }

    public static SteposPreferenceCategorySectionBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new SteposPreferenceCategorySectionBinding(textView, textView);
    }

    public static SteposPreferenceCategorySectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposPreferenceCategorySectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_preference_category_section, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public TextView getRoot() {
        return this.rootView;
    }
}
