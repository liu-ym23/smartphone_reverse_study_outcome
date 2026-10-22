package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public class LabelTextLayout extends RelativeLayout implements View.OnClickListener {
    private OnCustomClickListener customClickListener;
    private ImageView leftImageView;
    private ImageView rightImageView;
    private TextView rightTextView;
    private RelativeLayout rootView;
    private TextView titleTextView;

    public interface OnCustomClickListener {
        void onClickListener(View r100);
    }

    public ImageView getLeftImageView() {
        setVisible(this.leftImageView, true);
        return this.leftImageView;
    }

    public ImageView getRightImage() {
        return this.rightImageView;
    }

    public TextView getRightText() {
        return this.rightTextView;
    }

    public TextView gettitleText() {
        return this.titleTextView;
    }

    public LabelTextLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_widget_LabelTextLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void iniView(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_common_titlebar_layout, this, true);
        this.leftImageView = (ImageView) findViewById(R.id.cj_pay_back_view);
        this.rightImageView = (ImageView) findViewById(R.id.cj_pay_right_view);
        this.titleTextView = (TextView) findViewById(R.id.cj_pay_title_view);
        this.rightTextView = (TextView) findViewById(R.id.cj_pay_right_text_view);
        this.rootView = (RelativeLayout) findViewById(R.id.cj_pay_titlebar_layout);
    }

    public void addViewClickListener(OnCustomClickListener r100) {
        this.leftImageView.setOnClickListener(this);
        this.rightImageView.setOnClickListener(this);
        this.rightTextView.setOnClickListener(this);
        this.customClickListener = r100;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        this.customClickListener.onClickListener(r100);
    }

    public void setLayoutBackground(Object r100) {
        if ((r100 instanceof Integer) == false) goto L5;
        this.rootView.setBackgroundColor(((Integer) r100).intValue());
        return;
    L5:
        this.rootView.setBackgroundColor(0);
    }

    public void setLeftImageMarginRight(int r100) {
        ((LinearLayout.LayoutParams) this.leftImageView.getLayoutParams()).setMargins(0, 0, r100, 0);
    }

    public void setLeftImageView(int r100) {
        ImageView r101 = this.leftImageView;
        if (r101 == null) goto L6;
        r101.setImageResource(r100);
        return;
    }

    public void setLeftImageVisible(boolean r100) {
        setVisible(this.leftImageView, r100);
    }

    public void setRightImageVisible(boolean r100) {
        setVisible(this.rightImageView, r100);
    }

    public void setRightText(String r100) {
        if (r100 == null) goto L5;
        this.rightTextView.setText(r100);
        return;
    }

    public void setRightTextColor(Object r100) {
        if ((r100 instanceof Integer) == false) goto L5;
        this.rightTextView.setTextColor(((Integer) r100).intValue());
        return;
    L5:
        this.rightTextView.setTextColor((ColorStateList) r100);
    }

    public void setRightTextVisible(boolean r100) {
        setVisible(this.rightTextView, r100);
    }

    public void setTitleTextDrawable(int r100) {
        if (getContext() != null) goto L5;
        return;
    L5:
        if (getContext().getResources() == null) goto L11;
        if (r100 != 0) goto L8;
        this.titleTextView.setBackgroundDrawable(null);
        return;
    L8:
        this.titleTextView.setBackgroundDrawable(getContext().getResources().getDrawable(r100));
        this.titleTextView.setVisibility(0);
        return;
    }

    public void settitleText(String r100) {
        if (r100 == null) goto L5;
        this.titleTextView.setText(r100);
        this.titleTextView.setVisibility(0);
        return;
    }

    public void settitleTextColor(Object r100) {
        if ((r100 instanceof Integer) == false) goto L5;
        this.titleTextView.setTextColor(((Integer) r100).intValue());
        return;
    L5:
        this.titleTextView.setTextColor((ColorStateList) r100);
    }

    public void setLayoutBackground(int r100) {
        this.rootView.setBackgroundResource(r100);
    }

    public LabelTextLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static float dp2px(Context r100, float r101) {
        return TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_widget_LabelTextLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    private void setVisible(View r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.setVisibility(0);
        return;
    L4:
        r100.setVisibility(8);
    }

    public LabelTextLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        iniView(r100);
    }
}
