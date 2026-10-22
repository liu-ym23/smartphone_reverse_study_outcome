package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: AlphabetView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AlphabetView extends TextView {
    public AlphabetView(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    public AlphabetView(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), 0, 4, null);
    }

    public /* synthetic */ AlphabetView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public AlphabetView(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        init();
    }

    private final void init() {
        setGravity(17);
        setTextSize(0, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.bytedance_quickbarex_gridview_font_size, "dimen", "bytedance_quickbarex_gridview_font_size")));
        setTypeface(null, 1);
        setTextColor(Color.parseColor("#80000000"));
    }
}
