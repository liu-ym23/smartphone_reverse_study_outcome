package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.stepos.widget.R;

/* loaded from: classes2.dex */
public final class SteposDialogSelectItemSingleBinding {
    private final CheckedTextView rootView;
    public final CheckedTextView steposDialogListItemText;

    private SteposDialogSelectItemSingleBinding(CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = checkedTextView;
        this.steposDialogListItemText = checkedTextView2;
    }

    public static SteposDialogSelectItemSingleBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CheckedTextView checkedTextView = (CheckedTextView) view;
        return new SteposDialogSelectItemSingleBinding(checkedTextView, checkedTextView);
    }

    public static SteposDialogSelectItemSingleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogSelectItemSingleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_select_item_single, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public CheckedTextView getRoot() {
        return this.rootView;
    }
}
