package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import com.stepos.widget.R;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposListItemBinding {
    private final View rootView;
    public final ImageView steposListItemAccessory;
    public final View steposListItemBadge;
    public final ImageView steposListItemLeadingIcon;
    public final View steposListItemRightBadge;
    public final TextView steposListItemSubtitle;
    public final TextView steposListItemTitle;
    public final TextView steposListItemTitleEnd;
    public final FrameLayout steposListItemTrailing;
    public final Barrier steposListItemTrailingBarrier;
    public final TextView steposListItemValue;

    private SteposListItemBinding(View view, ImageView imageView, View view2, ImageView imageView2, View view3, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, Barrier barrier, TextView textView4) {
        this.rootView = view;
        this.steposListItemAccessory = imageView;
        this.steposListItemBadge = view2;
        this.steposListItemLeadingIcon = imageView2;
        this.steposListItemRightBadge = view3;
        this.steposListItemSubtitle = textView;
        this.steposListItemTitle = textView2;
        this.steposListItemTitleEnd = textView3;
        this.steposListItemTrailing = frameLayout;
        this.steposListItemTrailingBarrier = barrier;
        this.steposListItemValue = textView4;
    }

    public static SteposListItemBinding bind(View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.stepos_list_item_accessory;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null && (viewA = C5437a.a(view, (i10 = R.id.stepos_list_item_badge))) != null) {
            i10 = R.id.stepos_list_item_leading_icon;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null && (viewA2 = C5437a.a(view, (i10 = R.id.stepos_list_item_right_badge))) != null) {
                i10 = R.id.stepos_list_item_subtitle;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R.id.stepos_list_item_title;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.stepos_list_item_title_end;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.stepos_list_item_trailing;
                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout != null) {
                                i10 = R.id.stepos_list_item_trailing_barrier;
                                Barrier barrier = (Barrier) C5437a.a(view, i10);
                                if (barrier != null) {
                                    i10 = R.id.stepos_list_item_value;
                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                    if (textView4 != null) {
                                        return new SteposListItemBinding(view, imageView, viewA, imageView2, viewA2, textView, textView2, textView3, frameLayout, barrier, textView4);
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

    public static SteposListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.stepos_list_item, viewGroup);
        return bind(viewGroup);
    }

    public View getRoot() {
        return this.rootView;
    }
}
