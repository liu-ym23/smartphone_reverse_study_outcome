package com.obric.oui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public class ODividerLine extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f14505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f14506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14507c;

    public ODividerLine(Context r10) {
        this(r10, null);
    }

    public void a(Context r10, AttributeSet r11) {
        Log.d("SETTING", "getBaseStyle() called with: context = [" + r10 + "], attrs = [" + r11 + "]");
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.ODividerLine);
        if (r12.getBoolean(R$styleable.ODividerLine_oui_hideLine, false) == false) goto L5;
        this.f14507c.setVisibility(8);
    L5:
        this.f14507c.setBackgroundColor(ContextCompat.b(r10, R$color.LinePrimary));
        this.f14505a.setBackgroundColor(ContextCompat.b(r10, R$color.BGPrimary));
        String r13 = r12.getString(R$styleable.ODividerLine_oui_startText);
        if (TextUtils.isEmpty(r13) == true) goto L8;
        this.f14506b.setText(r13);
    L9:
        this.f14506b.setTextColor(ContextCompat.b(r10, R$color.TextTertiary));
        if (r12.getBoolean(R$styleable.ODividerLine_oui_isStartAllCap, false) == false) goto L12;
        this.f14506b.setAllCaps(true);
    L12:
        r12.recycle();
        return;
    L8:
        this.f14506b.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) this.f14507c.getLayoutParams()).bottomMargin = f.i(4);
        goto L9
    }

    public void b(Context r10) {
        View r11 = View.inflate(r10, R$layout.o_view_divider_line, this);
        this.f14505a = r11;
        this.f14506b = (TextView) r11.findViewById(R$id.tv_left_text);
        this.f14507c = this.f14505a.findViewById(R$id.underline);
        this.f14505a.setBackgroundColor(ContextCompat.b(r10, R$color.BGPrimary));
    }

    public TextView getTxtLeft() {
        return this.f14506b;
    }

    public ODividerLine(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ODividerLine(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        b(r10);
        a(r10, r11);
    }
}
