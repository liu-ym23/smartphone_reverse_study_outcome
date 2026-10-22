package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public TabItem(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        y r7 = y.a(r5, r6, R.styleable.TabItem);
        this.text = r7.c(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_text, "styleable", "TabItem_android_text"));
        this.icon = r7.a(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_icon, "styleable", "TabItem_android_icon"));
        this.customLayout = r7.g(ZeusTransformUtils.mapRes(R.styleable.TabItem_android_layout, "styleable", "TabItem_android_layout"), 0);
        r7.b();
    }
}
