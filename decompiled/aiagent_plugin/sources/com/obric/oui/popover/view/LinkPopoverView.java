package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.popover.PopoverLinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LinkPopoverView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class LinkPopoverView extends PopoverLinearLayout {
    private final ImageView ivArrow;
    private final ImageView ivIcon;
    private final TextView tvTips;

    /* JADX WARN: Multi-variable type inference failed */
    public LinkPopoverView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LinkPopoverView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public LinkPopoverView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        LinearLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_popover_link_view, "layout", "o_popover_link_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setOrientation(0);
        int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        setPadding(r8, r8, r8, r8);
        setBackground(a.a(r6, ZeusTransformUtils.mapRes(R.drawable.o_popover_view_bg, "drawable", "o_popover_view_bg")));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon"));
        o.c(r9, "findViewById(R.id.iv_icon)");
        this.ivIcon = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_tips, DbHelper.COL_ID, "tv_tips"));
        o.c(r10, "findViewById(R.id.tv_tips)");
        this.tvTips = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_arrow, DbHelper.COL_ID, "iv_arrow"));
        o.c(r11, "findViewById(R.id.iv_arrow)");
        this.ivArrow = (ImageView) ZeusTransformUtils.preCheckCast(r11, ImageView.class, "com.obric.aiagent.plugin");
    }

    public final ImageView getIvIcon() {
        return this.ivIcon;
    }

    public final TextView getTvTips() {
        return this.tvTips;
    }

    public final ImageView getIvArrow() {
        return this.ivArrow;
    }

    public void setLeftIcon(int r2) {
        this.ivIcon.setImageResource(r2);
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
    }

    public void setLeftIcon(Drawable r2) {
        this.ivIcon.setImageDrawable(r2);
        k.a((View) ZeusTransformUtils.preCheckCast(this.ivIcon, View.class, "com.obric.aiagent.plugin"));
    }

    public final void setTips(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "charSequence");
        this.tvTips.setText(r4);
    }
}
