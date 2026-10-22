package com.obric.oui.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class OTabItem extends View {
    final int mCustomLayout;
    final Drawable mIcon;
    final CharSequence mText;

    public OTabItem(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OTabItem(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        y r7 = y.a(r5, r6, R.styleable.OTabItem);
        this.mText = r7.c(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_text, "styleable", "OTabItem_android_text"));
        this.mIcon = r7.a(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_icon, "styleable", "OTabItem_android_icon"));
        this.mCustomLayout = r7.g(ZeusTransformUtils.mapRes(R.styleable.OTabItem_android_layout, "styleable", "OTabItem_android_layout"), 0);
        r7.b();
    }
}
