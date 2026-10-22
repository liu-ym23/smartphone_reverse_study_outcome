package com.stepos.widget.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposRecipientDropdownItemBinding {
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;

    private SteposRecipientDropdownItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.icon = imageView;
        this.text1 = textView;
        this.text2 = textView2;
    }

    public static SteposRecipientDropdownItemBinding bind(View view) {
        int i10 = R.id.icon;
        ImageView imageView = (ImageView) C5437a.a(view, R.id.icon);
        if (imageView != null) {
            i10 = R.id.text1;
            TextView textView = (TextView) C5437a.a(view, R.id.text1);
            if (textView != null) {
                i10 = R.id.text2;
                TextView textView2 = (TextView) C5437a.a(view, R.id.text2);
                if (textView2 != null) {
                    return new SteposRecipientDropdownItemBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposRecipientDropdownItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposRecipientDropdownItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(com.stepos.widget.R.layout.stepos_recipient_dropdown_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
