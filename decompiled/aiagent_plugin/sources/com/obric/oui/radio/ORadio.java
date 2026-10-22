package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ORadio.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ORadio extends AppCompatRadioButton {
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean isFitOld;
    private int style;

    public ORadio(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, false, 14, null);
    }

    public ORadio(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, false, 12, null);
    }

    public ORadio(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, false, 8, null);
    }

    public /* synthetic */ ORadio(Context r2, AttributeSet r3, int r4, boolean r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r8, r9, r4, r5);
    }

    public ORadio(Context r3, AttributeSet r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r5);
        this.isFitOld = r6;
        this.adaptForCSR = true;
        if (r8 == null) goto L6;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.ORadio, r5, 0);
        o.c(r9, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.isFitOld = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_fitOld, "styleable", "ORadio_oui_fitOld"), this.isFitOld);
        this.style = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_radioStyle, "styleable", "ORadio_oui_radioStyle"), 0);
        this.adaptForCSR = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_adapt_for_csr, "styleable", "ORadio_oui_adapt_for_csr"), true);
        this.alwaysLight = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_radioAlwaysLight, "styleable", "ORadio_oui_radioAlwaysLight"), false);
        r9.recycle();
    L6:
        if (this.isFitOld == true) goto L8;
        applyStyle();
        return;
    L8:
        setClickable(true);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.adaptForCSR == false) goto L9;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 44));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L12;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        setVisibility(r4);
        return;
    L9:
        r4 = 4;
        goto L10
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        super.setText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void setStyle(int r2) {
        if (this.isFitOld == false) goto L5;
        return;
    L5:
        this.style = r2;
        applyStyle();
    }

    private final void applyStyle() {
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L9;
        setButtonDrawable(ZeusTransformUtils.mapRes(R.drawable.o_ic_radio_tick_checked, "drawable", "o_ic_radio_tick_checked"));
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.alwaysLight == false) goto L11;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_radio_round_always_light, "drawable", "o_radio_round_always_light");
    L12:
        setButtonDrawable(r0);
        goto L13
    L11:
        r0 = ZeusTransformUtils.mapRes(R.drawable.o_radio_round, "drawable", "o_radio_round");
        goto L12
    }
}
