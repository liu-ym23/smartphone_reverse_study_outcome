package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.stepos.widget.R;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposSwipeActionBinding {
    private final View rootView;
    public final ImageView steposSwipeActionDeleteIcon;
    public final FrameLayout steposSwipeActionDeleteTarget;
    public final LinearLayout steposSwipeActionPanel;
    public final ImageView steposSwipeActionPrimaryIcon;
    public final FrameLayout steposSwipeActionPrimaryTarget;
    public final ImageView steposSwipeActionSecondaryIcon;
    public final FrameLayout steposSwipeActionSecondaryTarget;

    private SteposSwipeActionBinding(View view, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView2, FrameLayout frameLayout2, ImageView imageView3, FrameLayout frameLayout3) {
        this.rootView = view;
        this.steposSwipeActionDeleteIcon = imageView;
        this.steposSwipeActionDeleteTarget = frameLayout;
        this.steposSwipeActionPanel = linearLayout;
        this.steposSwipeActionPrimaryIcon = imageView2;
        this.steposSwipeActionPrimaryTarget = frameLayout2;
        this.steposSwipeActionSecondaryIcon = imageView3;
        this.steposSwipeActionSecondaryTarget = frameLayout3;
    }

    public static SteposSwipeActionBinding bind(View view) {
        int i10 = R.id.stepos_swipe_action_delete_icon;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R.id.stepos_swipe_action_delete_target;
            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.stepos_swipe_action_panel;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.stepos_swipe_action_primary_icon;
                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.stepos_swipe_action_primary_target;
                        FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                        if (frameLayout2 != null) {
                            i10 = R.id.stepos_swipe_action_secondary_icon;
                            ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                            if (imageView3 != null) {
                                i10 = R.id.stepos_swipe_action_secondary_target;
                                FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout3 != null) {
                                    return new SteposSwipeActionBinding(view, imageView, frameLayout, linearLayout, imageView2, frameLayout2, imageView3, frameLayout3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static SteposSwipeActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.stepos_swipe_action, viewGroup);
        return bind(viewGroup);
    }

    public View getRoot() {
        return this.rootView;
    }
}
