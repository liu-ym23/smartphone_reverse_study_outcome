package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.stepos.widget.R;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import s1.C5437a;

/* loaded from: classes2.dex */
public final class SteposDialogAlertBinding {
    private final StepOSAlertDialogLayout rootView;
    public final FrameLayout steposDialogContentPanel;
    public final FrameLayout steposDialogCustom;
    public final NestedScrollView steposDialogCustomPanel;
    public final ImageView steposDialogIcon;
    public final ImageView steposDialogIconBadge;
    public final FrameLayout steposDialogIconGroup;
    public final TextView steposDialogMessage;
    public final LinearLayout steposDialogMiddlePanel;
    public final StepOSAlertDialogLayout steposDialogParentPanel;
    public final NestedScrollView steposDialogScrollView;
    public final TextView steposDialogTitle;
    public final ConstraintLayout steposDialogTitleTemplate;
    public final NestedScrollView steposDialogTopPanel;

    private SteposDialogAlertBinding(StepOSAlertDialogLayout stepOSAlertDialogLayout, FrameLayout frameLayout, FrameLayout frameLayout2, NestedScrollView nestedScrollView, ImageView imageView, ImageView imageView2, FrameLayout frameLayout3, TextView textView, LinearLayout linearLayout, StepOSAlertDialogLayout stepOSAlertDialogLayout2, NestedScrollView nestedScrollView2, TextView textView2, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView3) {
        this.rootView = stepOSAlertDialogLayout;
        this.steposDialogContentPanel = frameLayout;
        this.steposDialogCustom = frameLayout2;
        this.steposDialogCustomPanel = nestedScrollView;
        this.steposDialogIcon = imageView;
        this.steposDialogIconBadge = imageView2;
        this.steposDialogIconGroup = frameLayout3;
        this.steposDialogMessage = textView;
        this.steposDialogMiddlePanel = linearLayout;
        this.steposDialogParentPanel = stepOSAlertDialogLayout2;
        this.steposDialogScrollView = nestedScrollView2;
        this.steposDialogTitle = textView2;
        this.steposDialogTitleTemplate = constraintLayout;
        this.steposDialogTopPanel = nestedScrollView3;
    }

    public static SteposDialogAlertBinding bind(View view) {
        int i10 = R.id.stepos_dialog_content_panel;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.stepos_dialog_custom;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R.id.stepos_dialog_custom_panel;
                NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                if (nestedScrollView != null) {
                    i10 = R.id.stepos_dialog_icon;
                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.stepos_dialog_icon_badge;
                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.stepos_dialog_icon_group;
                            FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout3 != null) {
                                i10 = R.id.stepos_dialog_message;
                                TextView textView = (TextView) C5437a.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.stepos_dialog_middle_panel;
                                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout != null) {
                                        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) view;
                                        i10 = R.id.stepos_dialog_scroll_view;
                                        NestedScrollView nestedScrollView2 = (NestedScrollView) C5437a.a(view, i10);
                                        if (nestedScrollView2 != null) {
                                            i10 = R.id.stepos_dialog_title;
                                            TextView textView2 = (TextView) C5437a.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R.id.stepos_dialog_title_template;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                                                if (constraintLayout != null) {
                                                    i10 = R.id.stepos_dialog_top_panel;
                                                    NestedScrollView nestedScrollView3 = (NestedScrollView) C5437a.a(view, i10);
                                                    if (nestedScrollView3 != null) {
                                                        return new SteposDialogAlertBinding(stepOSAlertDialogLayout, frameLayout, frameLayout2, nestedScrollView, imageView, imageView2, frameLayout3, textView, linearLayout, stepOSAlertDialogLayout, nestedScrollView2, textView2, constraintLayout, nestedScrollView3);
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

    public static SteposDialogAlertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposDialogAlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_dialog_alert, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public StepOSAlertDialogLayout getRoot() {
        return this.rootView;
    }
}
