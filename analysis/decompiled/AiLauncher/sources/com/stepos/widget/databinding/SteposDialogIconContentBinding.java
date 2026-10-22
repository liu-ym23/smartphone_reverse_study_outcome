package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.widget.R;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposDialogIconContentBinding {
    private final LinearLayout rootView;
    public final LinearLayout steposDialogIconContent;
    public final LinearLayout steposDialogIconContentLeft;
    public final ImageView steposDialogIconContentLeftIcon;
    public final FrameLayout steposDialogIconContentLeftIconFrame;
    public final TextView steposDialogIconContentLeftLabel;
    public final LinearLayout steposDialogIconContentRight;
    public final ImageView steposDialogIconContentRightIcon;
    public final FrameLayout steposDialogIconContentRightIconFrame;
    public final TextView steposDialogIconContentRightLabel;

    private SteposDialogIconContentBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout4, ImageView imageView2, FrameLayout frameLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.steposDialogIconContent = linearLayout2;
        this.steposDialogIconContentLeft = linearLayout3;
        this.steposDialogIconContentLeftIcon = imageView;
        this.steposDialogIconContentLeftIconFrame = frameLayout;
        this.steposDialogIconContentLeftLabel = textView;
        this.steposDialogIconContentRight = linearLayout4;
        this.steposDialogIconContentRightIcon = imageView2;
        this.steposDialogIconContentRightIconFrame = frameLayout2;
        this.steposDialogIconContentRightLabel = textView2;
    }

    public static SteposDialogIconContentBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.stepos_dialog_icon_content_left;
        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout2 != null) {
            i10 = R.id.stepos_dialog_icon_content_left_icon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R.id.stepos_dialog_icon_content_left_icon_frame;
                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout != null) {
                    i10 = R.id.stepos_dialog_icon_content_left_label;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.stepos_dialog_icon_content_right;
                        LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout3 != null) {
                            i10 = R.id.stepos_dialog_icon_content_right_icon;
                            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.stepos_dialog_icon_content_right_icon_frame;
                                FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout2 != null) {
                                    i10 = R.id.stepos_dialog_icon_content_right_label;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        return new SteposDialogIconContentBinding(linearLayout, linearLayout, linearLayout2, imageView, frameLayout, textView, linearLayout3, imageView2, frameLayout2, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposDialogIconContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogIconContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_icon_content, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
