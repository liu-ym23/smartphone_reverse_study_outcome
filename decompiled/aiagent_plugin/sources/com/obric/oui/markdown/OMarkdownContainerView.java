package com.obric.oui.markdown;

import android.content.Context;
import com.lynx.markdown.MarkdownView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OMarkdownContainerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMarkdownContainerView extends MarkdownView {
    public OMarkdownContainerView(Context r3, MarkdownView.b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        MarkdownView.b r6 = (MarkdownView.b) ZeusTransformUtils.wrapperContextForParams(r4, MarkdownView.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r6, "callback");
        super(r5, r6);
    }

    public final void setDimension(int r1, int r2) {
        setMeasuredDimension(r1, r2);
    }
}
