package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f17439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f17440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnTitleBarClickListener f17441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f17442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f17443f;

    public ONormalTitleBar(Context r10) {
        this(r10, null);
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_view_normal_title_bar, this);
        this.f17439b = (ImageView) findViewById(R$id.back_btn);
        this.f17452a = (TextView) findViewById(R$id.title);
        this.f17440c = (ImageView) findViewById(R$id.right_btn);
        this.f17442e = findViewById(R$id.line);
        this.f17443f = (TextView) findViewById(R$id.text_left);
        this.f17439b.setOnClickListener(this);
        this.f17440c.setOnClickListener(this);
        this.f17443f.setOnClickListener(this);
        uc.a r11 = new uc.a(0.5f, 1.0f);
        this.f17439b.setOnTouchListener(r11);
        this.f17440c.setOnTouchListener(r11);
        this.f17443f.setOnTouchListener(r11);
    }

    private void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ONormalTitleBar);
        String r13 = r12.getString(R$styleable.ONormalTitleBar_oui_centerText);
        float r14 = r12.getDimension(R$styleable.ONormalTitleBar_oui_centerTextSize, f.i(17));
        int r15 = r12.getColor(R$styleable.ONormalTitleBar_oui_centerTextColor, ContextCompat.b(r10, R$color.TextPrimary));
        this.f17452a.setText(r13);
        int r16 = 0;
        this.f17452a.setTextSize(0, r14);
        this.f17452a.setTextColor(r15);
        Drawable r17 = r12.getDrawable(R$styleable.ONormalTitleBar_oui_rightDrawable);
        int r18 = R$styleable.ONormalTitleBar_oui_rightDrawableTint;
        if (r12.hasValue(r18) == false) goto L6;
        if (r17 == null) goto L6;
        int r19 = r12.getColor(r18, 0);
        r17 = r17.mutate();
        o.a.h(r17, r19);
    L6:
        if (r17 == null) goto L8;
        this.f17440c.setImageDrawable(r17);
    L8:
        boolean r20 = r12.getBoolean(R$styleable.ONormalTitleBar_oui_dividerVisible, true);
        View r21 = this.f17442e;
        if (r20 == true) goto L12;
        r16 = 8;
    L12:
        r21.setVisibility(r16);
        this.f17442e.setBackgroundColor(r12.getColor(R$styleable.ONormalTitleBar_oui_dividerColor, ContextCompat.b(r10, R$color.LinePrimary)));
        r12.recycle();
    }

    public ImageView getEndBtn() {
        return this.f17440c;
    }

    public ImageView getStartBtn() {
        return this.f17439b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        l.d(getStartBtn(), f.i(44), f.i(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        l.d(getEndBtn(), f.i(44), f.i(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.f17441d != null) goto L5;
        return;
    L5:
        if (r10.getId() != R$id.back_btn) goto L7;
    L12:
        this.f17441d.onBackClick(r10);
        return;
    L7:
        if (r10.getId() == R$id.text_left) goto L12;
        if (r10.getId() != R$id.right_btn) goto L15;
        this.f17441d.onEndBtnClick(r10);
        return;
    }

    public void setCenterText(CharSequence r10) {
        this.f17452a.setText(r10);
    }

    public void setDividerHeight(int r10) {
        ViewGroup.LayoutParams r11 = this.f17442e.getLayoutParams();
        r11.height = r10;
        this.f17442e.setLayoutParams(r11);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f17442e.setBackgroundColor(r10);
    }

    public void setEndBtnIcon(@DrawableRes int r10) {
        this.f17440c.setImageResource(r10);
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r10) {
        this.f17441d = r10;
    }

    public void setStartBtnIcon(@DrawableRes int r10) {
        this.f17439b.setImageResource(r10);
    }

    public void setStartText(String r10) {
        this.f17439b.setVisibility(8);
        this.f17443f.setVisibility(0);
        this.f17443f.setText(r10);
    }

    public void setStartTextSize(float r10) {
        this.f17443f.setTextSize(0, r10);
    }

    public ONormalTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ONormalTitleBar(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }
}
