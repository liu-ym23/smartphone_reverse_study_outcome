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
import androidx.core.content.a;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class ODividerLine extends LinearLayout {
    private TextView txtLeft;
    private View underLine;
    private View view;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public ODividerLine(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ODividerLine(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ODividerLine(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        initView(r6);
        getBaseStyle(r6, r7);
    }

    public void initView(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        View r0 = ZeusTransformUtils.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_view_divider_line, "layout", "o_view_divider_line"), this, "com.obric.aiagent.plugin");
        this.view = r0;
        this.txtLeft = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.tv_left_text, DbHelper.COL_ID, "tv_left_text")), TextView.class, "com.obric.aiagent.plugin");
        this.underLine = this.view.findViewById(ZeusTransformUtils.mapRes(R.id.underline, DbHelper.COL_ID, "underline"));
        this.view.setBackgroundColor(a.c(r7, ZeusTransformUtils.mapRes(R.color.BGPrimary, "color", "BGPrimary")));
    }

    public void getBaseStyle(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_oui_divider_ODividerLine_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("SETTING", "getBaseStyle() called with: context = [" + r11 + "], attrs = [" + r12 + "]");
        TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ODividerLine);
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_hideLine, "styleable", "ODividerLine_oui_hideLine"), false) == false) goto L5;
        this.underLine.setVisibility(8);
    L5:
        this.underLine.setBackgroundColor(a.c(r11, ZeusTransformUtils.mapRes(R.color.LinePrimary, "color", "LinePrimary")));
        this.view.setBackgroundColor(a.c(r11, ZeusTransformUtils.mapRes(R.color.BGPrimary, "color", "BGPrimary")));
        String r0 = r13.getString(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_startText, "styleable", "ODividerLine_oui_startText"));
        if (TextUtils.isEmpty(r0) == true) goto L8;
        this.txtLeft.setText(r0);
    L9:
        this.txtLeft.setTextColor(a.c(r11, ZeusTransformUtils.mapRes(R.color.TextTertiary, "color", "TextTertiary")));
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_isStartAllCap, "styleable", "ODividerLine_oui_isStartAllCap"), false) == false) goto L12;
        this.txtLeft.setAllCaps(true);
    L12:
        r13.recycle();
        return;
    L8:
        this.txtLeft.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.underLine.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin = g.a(4);
        goto L9
    }

    public TextView getTxtLeft() {
        return this.txtLeft;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_divider_ODividerLine_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
