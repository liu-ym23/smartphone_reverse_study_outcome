package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposRecipientDropdownLoadingBinding {
    private final TextView rootView;
    public final TextView text1;

    private SteposRecipientDropdownLoadingBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text1 = textView2;
    }

    public static SteposRecipientDropdownLoadingBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new SteposRecipientDropdownLoadingBinding(textView, textView);
    }

    public static SteposRecipientDropdownLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposRecipientDropdownLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_recipient_dropdown_loading, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public TextView getRoot() {
        return this.rootView;
    }
}
