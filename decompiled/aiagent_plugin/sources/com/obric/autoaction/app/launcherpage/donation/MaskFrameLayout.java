package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: MaskFrameLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MaskFrameLayout extends FrameLayout {
    public MaskFrameLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public MaskFrameLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ MaskFrameLayout(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public MaskFrameLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Configuration r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration();
        o.c(r0, "getConfiguration(...)");
        updateBackground(r0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 != null) goto L5;
        r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration();
    L5:
        o.a(r1);
        updateBackground(r1);
    }

    private final void updateBackground(Configuration r7) {
        Resources r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (r7.orientation != 1) goto L5;
        int r8 = ZeusTransformUtils.mapRes(R.drawable.surfaceview_bg, "drawable", "surfaceview_bg");
    L6:
        WindowManager.LayoutParams r2 = null;
        setBackground(androidx.core.content.b.h.a(r1, r8, null));
        WindowManager r9 = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService(WindowManager.class), WindowManager.class, "com.obric.aiagent.plugin");
        int r3 = r9.getCurrentWindowMetrics().getBounds().width();
        int r4 = r9.getCurrentWindowMetrics().getBounds().height();
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, WindowManager.LayoutParams.class) == false) goto L9;
        r2 = (WindowManager.LayoutParams) ZeusTransformUtils.preCheckCast(r5, WindowManager.LayoutParams.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 == null) goto L12;
        r2.width = r3;
        r2.height = r4;
        r9.updateViewLayout((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        return;
    L5:
        r8 = ZeusTransformUtils.mapRes(R.drawable.surfaceview_landscape_bg, "drawable", "surfaceview_landscape_bg");
        goto L6
    }
}
