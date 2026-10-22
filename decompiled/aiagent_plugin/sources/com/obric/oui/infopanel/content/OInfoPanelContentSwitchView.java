package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OInfoPanelContentSwitchView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OInfoPanelContentSwitchView extends ConstraintLayout {
    private final OSwitch oSwitch;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentSwitchView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OInfoPanelContentSwitchView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OInfoPanelContentSwitchView(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_info_panel_content_switch_view, "layout", "o_info_panel_content_switch_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-1, -2);
        r9.setMargins(0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.o_info_panel_content_switch_view_bg, "drawable", "o_info_panel_content_switch_view_bg"));
        int r10 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16);
        setPadding(r10, r10, r10, r10);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r11, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.o_switch, DbHelper.COL_ID, "o_switch"));
        o.c(r12, "findViewById(R.id.o_switch)");
        OSwitch r13 = (OSwitch) ZeusTransformUtils.preCheckCast(r12, OSwitch.class, "com.obric.aiagent.plugin");
        this.oSwitch = r13;
        k.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 44));
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final OSwitch getOSwitch() {
        return this.oSwitch;
    }
}
