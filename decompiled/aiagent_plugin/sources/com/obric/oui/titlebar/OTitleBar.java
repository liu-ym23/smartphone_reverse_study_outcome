package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OTitleBar extends FrameLayout {
    protected static final int DEFAULT_BUTTON_TEXT_SIZE = 15;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 17;
    protected TextView mTitleView;

    public abstract void setDividerLineBackground(int r1);

    public abstract void showDividerLine(boolean r1);

    public OTitleBar(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public OTitleBar(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public OTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r6, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        if (getBackground() != null) goto L6;
        setBackgroundColor(androidx.core.content.a.c(r6, ZeusTransformUtils.mapRes(R.color.BGPrimary, "color", "BGPrimary")));
        return;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        TextView r2 = this.mTitleView;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.setText(r4);
    }

    public void setTitle(int r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setText(r1);
    }

    public void setTitleColor(int r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextColor(r1);
    }

    public void setTitleSize(float r1) {
        TextView r0 = this.mTitleView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTextSize(r1);
    }

    public void setTitleSizePixel(float r2) {
        TextView r1 = this.mTitleView;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setTextSize(0, r2);
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }
}
