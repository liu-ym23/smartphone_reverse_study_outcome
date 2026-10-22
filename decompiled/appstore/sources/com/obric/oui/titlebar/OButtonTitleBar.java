package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f17367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f17368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnTitleBarClickListener f17369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f17370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f17371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17373h;

    public OButtonTitleBar(@NonNull Context r10) {
        this(r10, null);
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_view_button_title_bar, this);
        this.f17367b = (ImageView) findViewById(R$id.back_btn);
        this.f17452a = (TextView) findViewById(R$id.title);
        this.f17368c = (TextView) findViewById(R$id.right_btn);
        this.f17371f = findViewById(R$id.line);
        this.f17367b.setOnClickListener(this);
        this.f17368c.setOnClickListener(this);
        uc.a r11 = new uc.a(0.5f, 1.0f);
        this.f17367b.setOnTouchListener(r11);
        this.f17368c.setOnTouchListener(r11);
    }

    public final void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OButtonTitleBar);
        String r13 = r12.getString(R$styleable.OButtonTitleBar_oui_centerText);
        float r14 = r12.getDimension(R$styleable.OButtonTitleBar_oui_centerTextSize, f.i(17));
        int r15 = R$styleable.OButtonTitleBar_oui_centerTextColor;
        int r16 = R$color.TextPrimary;
        int r17 = r12.getColor(r15, ContextCompat.b(r10, r16));
        this.f17452a.setText(r13);
        int r18 = 0;
        this.f17452a.setTextSize(0, r14);
        this.f17452a.setTextColor(r17);
        String r19 = r12.getString(R$styleable.OButtonTitleBar_oui_rightButtonText);
        int r20 = r12.getInt(R$styleable.OButtonTitleBar_oui_rightButtonType, 1);
        float r21 = r12.getDimension(R$styleable.OButtonTitleBar_oui_rightButtonTextSize, f.g(17.0f));
        int r22 = r12.getColor(R$styleable.OButtonTitleBar_oui_rightButtonTextColor, 0);
        this.f17370e = r12.getDrawable(R$styleable.OButtonTitleBar_oui_rightButtonTextBackground);
        int r23 = r12.getInt(R$styleable.OButtonTitleBar_oui_rightButtonVisible, 0);
        this.f17368c.setText(r19);
        this.f17373h = r20;
        if (r20 != 1) goto L5;
        this.f17368c.setTypeface(Typeface.defaultFromStyle(1));
        this.f17368c.setTextColor(ContextCompat.b(r10, R$color.Primary));
    L6:
        this.f17368c.setTextSize(0, r21);
        if (r22 == 0) goto L9;
        this.f17368c.setTextColor(r22);
    L9:
        Drawable r24 = this.f17370e;
        if (r24 == null) goto L12;
        this.f17368c.setBackground(r24);
    L12:
        this.f17368c.setVisibility(r23);
        boolean r25 = r12.getBoolean(R$styleable.OButtonTitleBar_oui_dividerVisible, false);
        View r26 = this.f17371f;
        if (r25 == true) goto L16;
        r18 = 4;
    L16:
        r26.setVisibility(r18);
        int r110 = r12.getColor(R$styleable.OButtonTitleBar_oui_dividerColor, ContextCompat.b(r10, R$color.LinePrimary));
        this.f17372g = r110;
        this.f17371f.setBackgroundColor(r110);
        r12.recycle();
        return;
    L5:
        this.f17368c.setTypeface(Typeface.defaultFromStyle(0));
        this.f17368c.setTextColor(ContextCompat.b(r10, r16));
        goto L6
    }

    public TextView getEndBtn() {
        return this.f17368c;
    }

    public int getEndButtonType() {
        return this.f17373h;
    }

    public ImageView getStartBtn() {
        return this.f17367b;
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
        if (this.f17369d != null) goto L5;
        return;
    L5:
        if (r10.getId() != R$id.back_btn) goto L8;
        this.f17369d.onBackClick(r10);
        return;
    L8:
        if (r10.getId() != R$id.right_btn) goto L13;
        this.f17369d.onEndBtnClick(r10);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f17371f.setBackgroundColor(r10);
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r10) {
        this.f17369d = r10;
    }

    public OButtonTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OButtonTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f17373h = 0;
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }
}
