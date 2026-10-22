package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.SimpleColorFilter;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OPanelPadHeaderView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPanelPadHeaderView extends ConstraintLayout {
    private final ODivider dividerView;
    private final ImageView ivBack;
    private final AppCompatImageView ivClose;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OPanelPadHeaderView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OPanelPadHeaderView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OPanelPadHeaderView(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10);
        ConstraintLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_basic_panel_pad_header, "layout", "o_basic_panel_pad_header"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.obric.oui.common.util.b.f34567a.a(r9, ZeusTransformUtils.mapRes(R.attr.oui_PanelDefaultHeaderHeight, "attr", "oui_PanelDefaultHeaderHeight"), ZeusTransformUtils.mapRes(R.dimen.oui_panel_default_header_height, "dimen", "oui_panel_default_header_height"))));
        setBackgroundColor(0);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_close, DbHelper.COL_ID, "iv_close"));
        o.c(r11, "findViewById(R.id.iv_close)");
        this.ivClose = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r11, AppCompatImageView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r12, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_back, DbHelper.COL_ID, "iv_back"));
        o.c(r13, "findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.aiagent.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"));
        o.c(r14, "findViewById(R.id.divider)");
        this.dividerView = (ODivider) ZeusTransformUtils.preCheckCast(r14, ODivider.class, "com.obric.aiagent.plugin");
    }

    public final AppCompatImageView getCloseIconView() {
        return this.ivClose;
    }

    public final TextView getTitleView() {
        return this.tvTitle;
    }

    public final void switchToWhiteIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse")));
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_basic_panel_normal_header_close_bg_light, "drawable", "o_basic_panel_normal_header_close_bg_light"));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    public final void switchToBlackIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse")));
        Drawable r1 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_basic_panel_normal_header_close_bg_dark, "drawable", "o_basic_panel_normal_header_close_bg_dark"));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    public final void switchToPadIconStyle() {
        SimpleColorFilter r0 = new SimpleColorFilter(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse")));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.aiagent.plugin"));
        this.ivBack.setBackground((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.aiagent.plugin"));
        this.ivClose.setBackground((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.aiagent.plugin"));
    }
}
