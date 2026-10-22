package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;
import tc.f;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f17444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f17445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnTitleBarClickListener f17446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f17447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f17450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17451i;

    public OTextTitleBar(@NonNull Context r10) {
        this(r10, null);
    }

    private void a(Context r10) {
        FrameLayout.inflate(r10, R$layout.o_view_text_title_bar, this);
        this.f17444b = (TextView) findViewById(R$id.text_left);
        this.f17452a = (TextView) findViewById(R$id.title);
        this.f17445c = (TextView) findViewById(R$id.text_right);
        this.f17447e = (ImageView) findViewById(R$id.back_btn);
        this.f17450h = findViewById(R$id.line);
        this.f17447e.setOnClickListener(this);
        this.f17444b.setOnClickListener(this);
        this.f17445c.setOnClickListener(this);
        uc.a r11 = new uc.a(0.5f, 1.0f);
        this.f17447e.setOnTouchListener(r11);
        this.f17444b.setOnTouchListener(r11);
        this.f17445c.setOnTouchListener(r11);
    }

    private void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OTextTitleBar);
        String r13 = r12.getString(R$styleable.OTextTitleBar_oui_centerText);
        float r14 = r12.getDimension(R$styleable.OTextTitleBar_oui_centerTextSize, f.i(17));
        int r15 = R$styleable.OTextTitleBar_oui_centerTextColor;
        int r16 = R$color.TextPrimary;
        int r17 = r12.getColor(r15, ContextCompat.b(r10, r16));
        this.f17452a.setText(r13);
        this.f17452a.setTextSize(0, r14);
        this.f17452a.setTextColor(r17);
        this.f17448f = r12.getBoolean(R$styleable.OTextTitleBar_oui_useBackIcon, false);
        boolean r18 = r12.getBoolean(R$styleable.OTextTitleBar_oui_useCloseIcon, false);
        this.f17449g = r18;
        if (this.f17448f == false) goto L5;
        this.f17447e.setVisibility(0);
        this.f17444b.setVisibility(8);
        this.f17447e.setContentDescription(r10.getString(R$string.oui_iv_back_desc));
    L8:
        int r19 = r12.getInt(R$styleable.OTextTitleBar_oui_rightButtonType, 1);
        this.f17451i = r19;
        if (r19 != 1) goto L11;
        this.f17445c.setTextColor(ContextCompat.b(r10, R$color.Primary));
    L12:
        String r20 = r12.getString(R$styleable.OTextTitleBar_oui_rightButtonText);
        float r21 = r12.getDimension(R$styleable.OTextTitleBar_oui_rightTextSize, f.i(15));
        int r22 = R$styleable.OTextTitleBar_oui_rightTextColor;
        int r23 = r12.getColor(r22, ContextCompat.b(r10, r16));
        int r24 = r12.getInt(R$styleable.OTextTitleBar_oui_rightTextVisible, 0);
        this.f17445c.setText(r20);
        this.f17445c.setTextSize(0, r21);
        if (r12.hasValue(r22) == false) goto L15;
        this.f17445c.setTextColor(r23);
    L15:
        this.f17445c.setVisibility(r24);
        this.f17450h.setVisibility(r12.getInt(R$styleable.OTextTitleBar_oui_dividerVisible, 0));
        this.f17450h.setBackgroundColor(r12.getColor(R$styleable.OTextTitleBar_oui_dividerColor, ContextCompat.b(r10, R$color.LinePrimary)));
        r12.recycle();
        return;
    L11:
        this.f17445c.setTextColor(ContextCompat.b(r10, r16));
        goto L12
    L5:
        if (r18 == false) goto L7;
        this.f17447e.setVisibility(0);
        this.f17447e.setImageResource(R$drawable.o_ic_titlebar_close);
        this.f17444b.setVisibility(8);
        this.f17447e.setContentDescription(r10.getString(R$string.oui_iv_close_desc));
        goto L8
    L7:
        String r25 = r12.getString(R$styleable.OTextTitleBar_oui_leftButtonText);
        float r26 = r12.getDimension(R$styleable.OTextTitleBar_oui_leftTextSize, f.i(15));
        int r27 = r12.getColor(R$styleable.OTextTitleBar_oui_leftTextColor, ContextCompat.b(r10, r16));
        this.f17447e.setVisibility(8);
        this.f17444b.setVisibility(0);
        this.f17444b.setText(r25);
        this.f17444b.setTextSize(0, r26);
        this.f17444b.setTextColor(r27);
        goto L8
    }

    public ImageView getBackBtn() {
        return this.f17447e;
    }

    public int getEndButtonType() {
        return this.f17451i;
    }

    public TextView getEndText() {
        return this.f17445c;
    }

    public TextView getStartText() {
        return this.f17444b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r10 = this.f17444b;
        if (r10 == null) goto L5;
        l.d(r10, f.i(44), f.i(44), false);
    L5:
        TextView r11 = this.f17445c;
        if (r11 == null) goto L9;
        l.d(r11, f.i(44), f.i(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (this.f17446d != null) goto L5;
        return;
    L5:
        if (r10.getId() != R$id.back_btn) goto L7;
    L12:
        this.f17446d.onBackClick(r10);
        return;
    L7:
        if (r10.getId() == R$id.text_left) goto L12;
        if (r10.getId() != R$id.text_right) goto L15;
        this.f17446d.onEndBtnClick(r10);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r10 = f.n(getContext());
        int r11 = ((r10 / 2) - Math.max(this.f17444b.getMeasuredWidth(), this.f17445c.getMeasuredWidth())) * 2;
        this.f17452a.setMaxWidth(Math.max(r11, f.i(112)));
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r10) {
        this.f17450h.setBackgroundColor(r10);
    }

    public void setEndText(CharSequence r10) {
        this.f17445c.setText(r10);
    }

    public void setEndTextColor(@ColorInt int r10) {
        this.f17445c.setTextColor(r10);
    }

    public void setEndTextSize(float r10) {
        this.f17445c.setTextSize(r10);
    }

    public void setLineBackground(@ColorInt int r10) {
        this.f17450h.setBackgroundColor(r10);
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r10) {
        this.f17446d = r10;
    }

    public void setStartText(CharSequence r10) {
        this.f17444b.setText(r10);
    }

    public void setStartTextColor(@ColorInt int r10) {
        this.f17444b.setTextColor(r10);
    }

    public void setStartTextSize(float r10) {
        this.f17444b.setTextSize(r10);
    }

    public void setUseBackIcon(boolean r10) {
        if (this.f17448f == r10) goto L14;
        this.f17448f = r10;
        ImageView r11 = this.f17447e;
        int r12 = 8;
        if (r10 == false) goto L7;
        int r13 = 0;
    L8:
        r11.setVisibility(r13);
        this.f17447e.setImageResource(R$drawable.o_ic_titlebar_back);
        TextView r14 = this.f17444b;
        if (this.f17448f == true) goto L12;
        r12 = 0;
    L12:
        r14.setVisibility(r12);
        this.f17447e.setContentDescription(getContext().getString(R$string.oui_iv_back_desc));
        return;
    L7:
        r13 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r10) {
        if (this.f17449g == r10) goto L14;
        this.f17449g = r10;
        ImageView r11 = this.f17447e;
        int r12 = 8;
        if (r10 == false) goto L7;
        int r13 = 0;
    L8:
        r11.setVisibility(r13);
        this.f17447e.setImageResource(R$drawable.o_ic_titlebar_close);
        TextView r14 = this.f17444b;
        if (this.f17449g == true) goto L12;
        r12 = 0;
    L12:
        r14.setVisibility(r12);
        this.f17447e.setContentDescription(getContext().getString(R$string.oui_iv_close_desc));
        return;
    L7:
        r13 = 8;
        goto L8
    }

    public OTextTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public void setEndText(@StringRes int r10) {
        this.f17445c.setText(r10);
    }

    public void setStartText(@StringRes int r10) {
        this.f17444b.setText(r10);
    }

    public OTextTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f17451i = 0;
        a(r10);
        if (r11 == null) goto L6;
        b(r10, r11);
        return;
    }
}
