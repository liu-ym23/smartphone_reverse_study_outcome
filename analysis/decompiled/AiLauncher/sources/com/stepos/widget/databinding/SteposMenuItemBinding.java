package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.widget.R;
import com.stepos.widget.menu.StepOSMenuPressOverlayView;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposMenuItemBinding {
    private final FrameLayout rootView;
    public final View steposMenuItemBadge;
    public final ImageView steposMenuItemCheckbox;
    public final LinearLayout steposMenuItemContent;
    public final ImageView steposMenuItemIcon;
    public final ImageView steposMenuItemMark;
    public final StepOSMenuPressOverlayView steposMenuItemPressOverlay;
    public final TextView steposMenuItemSubtitle;
    public final TextView steposMenuItemTag;
    public final LinearLayout steposMenuItemText;
    public final TextView steposMenuItemTitle;
    public final ImageView steposMenuItemTrailingIcon;
    public final ImageView steposMenuItemUnfold;

    private SteposMenuItemBinding(FrameLayout frameLayout, View view, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, StepOSMenuPressOverlayView stepOSMenuPressOverlayView, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, ImageView imageView4, ImageView imageView5) {
        this.rootView = frameLayout;
        this.steposMenuItemBadge = view;
        this.steposMenuItemCheckbox = imageView;
        this.steposMenuItemContent = linearLayout;
        this.steposMenuItemIcon = imageView2;
        this.steposMenuItemMark = imageView3;
        this.steposMenuItemPressOverlay = stepOSMenuPressOverlayView;
        this.steposMenuItemSubtitle = textView;
        this.steposMenuItemTag = textView2;
        this.steposMenuItemText = linearLayout2;
        this.steposMenuItemTitle = textView3;
        this.steposMenuItemTrailingIcon = imageView4;
        this.steposMenuItemUnfold = imageView5;
    }

    public static SteposMenuItemBinding bind(View view) {
        int i10 = R.id.stepos_menu_item_badge;
        View viewA = C5437a.a(view, i10);
        if (viewA != null) {
            i10 = R.id.stepos_menu_item_checkbox;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R.id.stepos_menu_item_content;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.stepos_menu_item_icon;
                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.stepos_menu_item_mark;
                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                        if (imageView3 != null) {
                            i10 = R.id.stepos_menu_item_press_overlay;
                            StepOSMenuPressOverlayView stepOSMenuPressOverlayView = (StepOSMenuPressOverlayView) C5437a.a(view, i10);
                            if (stepOSMenuPressOverlayView != null) {
                                i10 = R.id.stepos_menu_item_subtitle;
                                TextView textView = (TextView) C5437a.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.stepos_menu_item_tag;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.stepos_menu_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.stepos_menu_item_title;
                                            TextView textView3 = (TextView) C5437a.a(view, i10);
                                            if (textView3 != null) {
                                                i10 = R.id.stepos_menu_item_trailing_icon;
                                                ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                                if (imageView4 != null) {
                                                    i10 = R.id.stepos_menu_item_unfold;
                                                    ImageView imageView5 = (ImageView) C5437a.a(view, i10);
                                                    if (imageView5 != null) {
                                                        return new SteposMenuItemBinding((FrameLayout) view, viewA, imageView, linearLayout, imageView2, imageView3, stepOSMenuPressOverlayView, textView, textView2, linearLayout2, textView3, imageView4, imageView5);
                                                    }
                                                }
                                            }
                                        }
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

    public static SteposMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_menu_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
