package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public final class ActivityPersonalCommonSelectedBinding {

    @NonNull
    public final NestedScrollView actionBarContainer;

    @NonNull
    public final StepOSRecyclerView addressListview;

    @NonNull
    public final TextView cancel;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView save;

    @NonNull
    public final Toolbar titleBar;

    @NonNull
    public final TextView toolbarTitle;

    @NonNull
    public final TextView tvTip;

    private ActivityPersonalCommonSelectedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull NestedScrollView nestedScrollView, @NonNull StepOSRecyclerView stepOSRecyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Toolbar toolbar, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.actionBarContainer = nestedScrollView;
        this.addressListview = stepOSRecyclerView;
        this.cancel = textView;
        this.save = textView2;
        this.titleBar = toolbar;
        this.toolbarTitle = textView3;
        this.tvTip = textView4;
    }

    @NonNull
    public static ActivityPersonalCommonSelectedBinding bind(@NonNull View view) {
        int i4 = R.id.action_bar_container;
        NestedScrollView nestedScrollView = (NestedScrollView) h.n(i4, view);
        if (nestedScrollView != null) {
            i4 = R.id.address_listview;
            StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) h.n(i4, view);
            if (stepOSRecyclerView != null) {
                i4 = R.id.cancel;
                TextView textView = (TextView) h.n(i4, view);
                if (textView != null) {
                    i4 = R.id.save;
                    TextView textView2 = (TextView) h.n(i4, view);
                    if (textView2 != null) {
                        i4 = R.id.title_bar;
                        Toolbar toolbar = (Toolbar) h.n(i4, view);
                        if (toolbar != null) {
                            i4 = R.id.toolbar_title;
                            TextView textView3 = (TextView) h.n(i4, view);
                            if (textView3 != null) {
                                i4 = R.id.tv_tip;
                                TextView textView4 = (TextView) h.n(i4, view);
                                if (textView4 != null) {
                                    return new ActivityPersonalCommonSelectedBinding((ConstraintLayout) view, nestedScrollView, stepOSRecyclerView, textView, textView2, toolbar, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityPersonalCommonSelectedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPersonalCommonSelectedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_personal_common_selected, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
