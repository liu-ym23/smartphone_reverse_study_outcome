package com.obric.autoaction.app.launcherpage.discovery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.autoaction.app.launcherpage.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: DiscoveryErrorView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DiscoveryErrorView extends FrameLayout {
    private final n binding;

    public DiscoveryErrorView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public DiscoveryErrorView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$NO8fzMeBrz_41p7JcqdrNXSgmVU(d.h.a.a r0, View r1) {
        bindRefresh$lambda$0(r0, r1);
    }

    public /* synthetic */ DiscoveryErrorView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public DiscoveryErrorView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        n r8 = n.a(LayoutInflater.from(r6), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        o.c(r8, "inflate(...)");
        this.binding = r8;
    }

    public final void bindRefresh(d.h.a.a<x> r3) {
        final d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "onRefresh");
        this.binding.f22840b.setOnClickListener(new $$Lambda$DiscoveryErrorView$NO8fzMeBrz_41p7JcqdrNXSgmVU(r4));
    }

    private static final void bindRefresh$lambda$0(d.h.a.a r1, View r2) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
    }
}
