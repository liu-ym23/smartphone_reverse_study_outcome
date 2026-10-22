package com.obric.autoaction.app.launcherpage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: AbstractOAutoTipView.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractOAutoTipView extends FrameLayout {
    private b<? super Boolean, x> visibilityListener;

    public AbstractOAutoTipView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AbstractOAutoTipView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ AbstractOAutoTipView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public AbstractOAutoTipView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public void setVisibilityListener(b<? super Boolean, x> r3) {
        b<? super Boolean, x> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.visibilityListener = r4;
    }

    public View asView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void setVisibility(int r4) {
        if (r4 == getVisibility()) goto L5;
        boolean r0 = true;
    L6:
        super.setVisibility(r4);
        if (r0 == false) goto L16;
        if (r4 != 0) goto L12;
        b<? super Boolean, x> r3 = this.visibilityListener;
        if (r3 == null) goto L17;
        r3.invoke(true);
        return;
    L17:
        return;
    L12:
        b<? super Boolean, x> r5 = this.visibilityListener;
        if (r5 == null) goto L19;
        r5.invoke(false);
        return;
    L19:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
