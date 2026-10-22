package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposDialogSelectItemBinding {
    private final TextView rootView;
    public final TextView steposDialogListItemText;

    private SteposDialogSelectItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.steposDialogListItemText = textView2;
    }

    public static SteposDialogSelectItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new SteposDialogSelectItemBinding(textView, textView);
    }

    public static SteposDialogSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_select_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public TextView getRoot() {
        return this.rootView;
    }
}
