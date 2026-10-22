package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;
import com.stepos.common.picker.TimePicker2;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public final class ActivityPersonalCommonTimePickerBinding {

    @NonNull
    public final NestedScrollView actionBarContainer;

    @NonNull
    public final TextView autoLearningTimeTitle;

    @NonNull
    public final ConstraintLayout autoLearningTimeTitleLayout;

    @NonNull
    public final RadioButton autoTimeBtSelect;

    @NonNull
    public final TextView autoTimeContent;

    @NonNull
    public final TextView cancel;

    @NonNull
    public final RadioButton customTimeBtSelect;

    @NonNull
    public final TextView customTimeTitle;

    @NonNull
    public final ConstraintLayout customTimeTitleLayout;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final TextView save;

    @NonNull
    public final TimePicker2 timePicker;

    @NonNull
    public final Toolbar titleBar;

    @NonNull
    public final TextView toolbarTitle;

    private ActivityPersonalCommonTimePickerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull RadioButton radioButton, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RadioButton radioButton2, @NonNull TextView textView4, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView5, @NonNull TimePicker2 timePicker2, @NonNull Toolbar toolbar, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.actionBarContainer = nestedScrollView;
        this.autoLearningTimeTitle = textView;
        this.autoLearningTimeTitleLayout = constraintLayout2;
        this.autoTimeBtSelect = radioButton;
        this.autoTimeContent = textView2;
        this.cancel = textView3;
        this.customTimeBtSelect = radioButton2;
        this.customTimeTitle = textView4;
        this.customTimeTitleLayout = constraintLayout3;
        this.save = textView5;
        this.timePicker = timePicker2;
        this.titleBar = toolbar;
        this.toolbarTitle = textView6;
    }

    @NonNull
    public static ActivityPersonalCommonTimePickerBinding bind(@NonNull View view) {
        int i4 = R.id.action_bar_container;
        NestedScrollView nestedScrollView = (NestedScrollView) h.n(i4, view);
        if (nestedScrollView != null) {
            i4 = R.id.auto_learning_time_title;
            TextView textView = (TextView) h.n(i4, view);
            if (textView != null) {
                i4 = R.id.auto_learning_time_title_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) h.n(i4, view);
                if (constraintLayout != null) {
                    i4 = R.id.auto_time_bt_select;
                    RadioButton radioButton = (RadioButton) h.n(i4, view);
                    if (radioButton != null) {
                        i4 = R.id.auto_time_content;
                        TextView textView2 = (TextView) h.n(i4, view);
                        if (textView2 != null) {
                            i4 = R.id.cancel;
                            TextView textView3 = (TextView) h.n(i4, view);
                            if (textView3 != null) {
                                i4 = R.id.custom_time_bt_select;
                                RadioButton radioButton2 = (RadioButton) h.n(i4, view);
                                if (radioButton2 != null) {
                                    i4 = R.id.custom_time_title;
                                    TextView textView4 = (TextView) h.n(i4, view);
                                    if (textView4 != null) {
                                        i4 = R.id.custom_time_title_layout;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) h.n(i4, view);
                                        if (constraintLayout2 != null) {
                                            i4 = R.id.save;
                                            TextView textView5 = (TextView) h.n(i4, view);
                                            if (textView5 != null) {
                                                i4 = R.id.time_picker;
                                                TimePicker2 timePicker2 = (TimePicker2) h.n(i4, view);
                                                if (timePicker2 != null) {
                                                    i4 = R.id.title_bar;
                                                    Toolbar toolbar = (Toolbar) h.n(i4, view);
                                                    if (toolbar != null) {
                                                        i4 = R.id.toolbar_title;
                                                        TextView textView6 = (TextView) h.n(i4, view);
                                                        if (textView6 != null) {
                                                            return new ActivityPersonalCommonTimePickerBinding((ConstraintLayout) view, nestedScrollView, textView, constraintLayout, radioButton, textView2, textView3, radioButton2, textView4, constraintLayout2, textView5, timePicker2, toolbar, textView6);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityPersonalCommonTimePickerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPersonalCommonTimePickerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_personal_common_time_picker, viewGroup, false);
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
