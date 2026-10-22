package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SettingsTrailingView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SettingsTrailingView extends LinearLayout {
    private ImageView iconImageView;
    private TextView textView;

    public SettingsTrailingView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public SettingsTrailingView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ SettingsTrailingView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public SettingsTrailingView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.o_settings_trailing_view_2, "layout", "o_settings_trailing_view_2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        r10.gravity = 8388629;
        addView(r9, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingText, DbHelper.COL_ID, "trailingText"));
        o.c(r11, "findViewById(R.id.trailingText)");
        this.textView = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.trailingImage, DbHelper.COL_ID, "trailingImage"));
        o.c(r12, "findViewById(R.id.trailingImage)");
        ImageView r13 = (ImageView) ZeusTransformUtils.preCheckCast(r12, ImageView.class, "com.obric.aiagent.plugin");
        this.iconImageView = r13;
        r13.setImageDrawable(r7.getDrawable(ZeusTransformUtils.mapRes(R.drawable.ic_arrow_forward_list_item, "drawable", "ic_arrow_forward_list_item")));
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(TextView r2) {
        o.e(r2, "<set-?>");
        this.textView = r2;
    }

    public final ImageView getIconImageView() {
        return this.iconImageView;
    }

    public final void setIconImageView(ImageView r2) {
        o.e(r2, "<set-?>");
        this.iconImageView = r2;
    }

    public final void setTrailingText(String r3) {
        o.e(r3, "text");
        this.textView.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final void setTrailingImage(Drawable r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.iconImageView.setImageDrawable(r1);
    }

    public final void showTrailingImageView(boolean r1) {
        if (r1 == false) goto L4;
        this.iconImageView.setVisibility(0);
        return;
    L4:
        this.iconImageView.setVisibility(8);
    }
}
