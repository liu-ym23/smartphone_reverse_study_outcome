package com.obric.oui.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBottomTabItem.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomTabItem extends View {
    private Drawable icon;
    private CharSequence text;

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItem(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OBottomTabItem(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OBottomTabItem(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        y r7 = y.a(r5, r6, R.styleable.OTabItem);
        this.text = r7.c(ZeusTransformUtils.mapRes(R.styleable.OBottomTabItem_android_text, "styleable", "OBottomTabItem_android_text"));
        this.icon = r7.a(ZeusTransformUtils.mapRes(R.styleable.OBottomTabItem_android_icon, "styleable", "OBottomTabItem_android_icon"));
        r7.b();
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setText(CharSequence r3) {
        this.text = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable r1) {
        this.icon = r1;
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
