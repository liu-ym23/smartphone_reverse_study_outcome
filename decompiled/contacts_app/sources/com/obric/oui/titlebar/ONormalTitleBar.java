package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.common.widget.ClickEffectTouchListener;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {
    private ImageView mEndBtn;
    private View mLine;
    private OnTitleBarClickListener mOnTitleBarClickListener;
    private ImageView mStartBtn;
    private TextView mStartText;

    public ONormalTitleBar(Context r2) {
        this(r2, null);
    }

    public ONormalTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ONormalTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
        if (r2 == null) goto L6;
        initAttrs(r1, r2);
        return;
    }

    private void initAttrs(Context r5, AttributeSet r6) {
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ONormalTitleBar);
        String r0 = r7.getString(R.styleable.ONormalTitleBar_oui_centerText);
        float r1 = r7.getDimension(R.styleable.ONormalTitleBar_oui_centerTextSize, OUnitExtensionKt.dp2px(17));
        int r2 = r7.getColor(R.styleable.ONormalTitleBar_oui_centerTextColor, ContextCompat.getColor(r5, R.color.TextPrimary));
        this.mTitleView.setText(r0);
        int r3 = 0;
        this.mTitleView.setTextSize(0, r1);
        this.mTitleView.setTextColor(r2);
        Drawable r4 = r7.getDrawable(R.styleable.ONormalTitleBar_oui_rightDrawable);
        if (r7.hasValue(R.styleable.ONormalTitleBar_oui_rightDrawableTint) == false) goto L6;
        if (r4 == null) goto L6;
        int r8 = r7.getColor(R.styleable.ONormalTitleBar_oui_rightDrawableTint, 0);
        r4 = r4.mutate();
        DrawableCompat.setTint(r4, r8);
    L6:
        if (r4 == null) goto L8;
        this.mEndBtn.setImageDrawable(r4);
    L8:
        boolean r9 = r7.getBoolean(R.styleable.ONormalTitleBar_oui_dividerVisible, true);
        View r10 = this.mLine;
        if (r9 == true) goto L12;
        r3 = 8;
    L12:
        r10.setVisibility(r3);
        this.mLine.setBackgroundColor(r7.getColor(R.styleable.ONormalTitleBar_oui_dividerColor, ContextCompat.getColor(r5, R.color.LinePrimary)));
        r7.recycle();
    }

    private void init(Context r3) {
        inflate(r3, R.layout.o_view_normal_title_bar, this);
        this.mStartBtn = (ImageView) findViewById(R.id.back_btn);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mEndBtn = (ImageView) findViewById(R.id.right_btn);
        this.mLine = findViewById(R.id.line);
        this.mStartText = (TextView) findViewById(R.id.text_left);
        this.mStartBtn.setOnClickListener(this);
        this.mEndBtn.setOnClickListener(this);
        this.mStartText.setOnClickListener(this);
        ClickEffectTouchListener r4 = new ClickEffectTouchListener(0.5f, 1.0f);
        this.mStartBtn.setOnTouchListener(r4);
        this.mEndBtn.setOnTouchListener(r4);
        this.mStartText.setOnTouchListener(r4);
    }

    public void setStartBtnIcon(int r1) {
        this.mStartBtn.setImageResource(r1);
    }

    public void setEndBtnIcon(int r1) {
        this.mEndBtn.setImageResource(r1);
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.mOnTitleBarClickListener = r1;
    }

    public void setStartText(String r3) {
        this.mStartBtn.setVisibility(8);
        this.mStartText.setVisibility(0);
        this.mStartText.setText(r3);
    }

    public void setStartTextSize(float r2) {
        this.mStartText.setTextSize(0, r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mOnTitleBarClickListener != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L7;
    L12:
        this.mOnTitleBarClickListener.onBackClick(r3);
        return;
    L7:
        if (r3.getId() == R.id.text_left) goto L12;
        if (r3.getId() != R.id.right_btn) goto L15;
        this.mOnTitleBarClickListener.onEndBtnClick(r3);
        return;
    }

    public ImageView getStartBtn() {
        return this.mStartBtn;
    }

    public ImageView getEndBtn() {
        return this.mEndBtn;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void showDividerLine(boolean r1) {
        View r0 = this.mLine;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.mLine.setBackgroundColor(r1);
    }

    public void setDividerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.mLine.getLayoutParams();
        r0.height = r2;
        this.mLine.setLayoutParams(r0);
    }

    public void setCenterText(CharSequence r1) {
        this.mTitleView.setText(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        ViewExtensionsKt.expandTouchArea(getStartBtn(), OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        ViewExtensionsKt.expandTouchArea(getEndBtn(), OUnitExtensionKt.dp2px(44), OUnitExtensionKt.dp2px(44), false);
        return;
    }
}
