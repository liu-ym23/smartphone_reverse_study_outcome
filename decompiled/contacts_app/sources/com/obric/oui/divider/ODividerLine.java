package com.obric.oui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;

/* JADX INFO: loaded from: classes3.dex */
public class ODividerLine extends LinearLayout {
    private TextView txtLeft;
    private View underLine;
    private View view;

    public ODividerLine(Context r2) {
        this(r2, null);
    }

    public ODividerLine(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ODividerLine(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initView(r1);
        getBaseStyle(r1, r2);
    }

    protected void initView(Context r3) {
        View r0 = View.inflate(r3, R.layout.o_view_divider_line, this);
        this.view = r0;
        this.txtLeft = (TextView) r0.findViewById(R.id.tv_left_text);
        this.underLine = this.view.findViewById(R.id.underline);
        this.view.setBackgroundColor(ContextCompat.getColor(r3, R.color.BGPrimary));
    }

    protected void getBaseStyle(Context r5, AttributeSet r6) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("SETTING", "getBaseStyle() called with: context = [" + r5 + "], attrs = [" + r6 + "]");
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.ODividerLine);
        if (r7.getBoolean(R.styleable.ODividerLine_oui_hideLine, false) == false) goto L5;
        this.underLine.setVisibility(8);
    L5:
        this.underLine.setBackgroundColor(ContextCompat.getColor(r5, R.color.LinePrimary));
        this.view.setBackgroundColor(ContextCompat.getColor(r5, R.color.BGPrimary));
        String r0 = r7.getString(R.styleable.ODividerLine_oui_startText);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        this.txtLeft.setText(r0);
    L9:
        this.txtLeft.setTextColor(ContextCompat.getColor(r5, R.color.TextTertiary));
        if (r7.getBoolean(R.styleable.ODividerLine_oui_isStartAllCap, false) == false) goto L12;
        this.txtLeft.setAllCaps(true);
    L12:
        r7.recycle();
        return;
    L8:
        this.txtLeft.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) this.underLine.getLayoutParams()).bottomMargin = OUnitExtensionKt.dp2px(4);
        goto L9
    }

    public TextView getTxtLeft() {
        return this.txtLeft;
    }
}
