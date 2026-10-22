package com.obric.oui.popover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.popover.PopoverLinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GuidePopoverView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GuidePopoverView extends PopoverLinearLayout {
    private final TextView tvGuide;
    private final TextView tvStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public GuidePopoverView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ GuidePopoverView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public GuidePopoverView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        LinearLayout.inflate(r6, ZeusTransformUtils.mapRes(R.layout.o_popover_guide_view, "layout", "o_popover_guide_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setOrientation(0);
        int r8 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 12);
        setPadding(r8, r8, r8, r8);
        setBackground(a.a(r6, ZeusTransformUtils.mapRes(R.drawable.o_popover_view_bg, "drawable", "o_popover_view_bg")));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_status_text, DbHelper.COL_ID, "tv_status_text"));
        o.c(r9, "findViewById(R.id.tv_status_text)");
        this.tvStatus = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_guide_text, DbHelper.COL_ID, "tv_guide_text"));
        o.c(r10, "findViewById(R.id.tv_guide_text)");
        this.tvGuide = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
    }

    public final TextView getTvStatus() {
        return this.tvStatus;
    }

    public final TextView getTvGuide() {
        return this.tvGuide;
    }

    public final void setStatusText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "charSequence");
        this.tvStatus.setText(r4);
    }

    public final void setGuideText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "charSequence");
        this.tvGuide.setText(r4);
    }
}
