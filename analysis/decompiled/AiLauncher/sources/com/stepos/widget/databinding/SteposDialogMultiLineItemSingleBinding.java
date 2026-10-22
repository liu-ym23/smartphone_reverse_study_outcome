package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.stepos.widget.R;
import com.stepos.widget.dialog.StepOSCheckableLayout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposDialogMultiLineItemSingleBinding {
    private final StepOSCheckableLayout rootView;
    public final ImageView steposDialogMultiLineCheckMark;
    public final TextView steposDialogMultiLineDetail;
    public final TextView steposDialogMultiLineTitle;

    private SteposDialogMultiLineItemSingleBinding(StepOSCheckableLayout stepOSCheckableLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = stepOSCheckableLayout;
        this.steposDialogMultiLineCheckMark = imageView;
        this.steposDialogMultiLineDetail = textView;
        this.steposDialogMultiLineTitle = textView2;
    }

    public static SteposDialogMultiLineItemSingleBinding bind(View view) {
        int i10 = R.id.stepos_dialog_multi_line_check_mark;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R.id.stepos_dialog_multi_line_detail;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R.id.stepos_dialog_multi_line_title;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    return new SteposDialogMultiLineItemSingleBinding((StepOSCheckableLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposDialogMultiLineItemSingleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogMultiLineItemSingleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_multi_line_item_single, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public StepOSCheckableLayout getRoot() {
        return this.rootView;
    }
}
