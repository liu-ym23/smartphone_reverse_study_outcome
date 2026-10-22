package com.obric.oui.tab;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBottomTabBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomTabBar extends OTabLayoutBase {
    public static final a Companion = null;
    private static final com.obric.oui.common.a sdkInit = null;

    /* JADX INFO: compiled from: OBottomTabBar.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OBottomTabBar(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OBottomTabBar(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        setTabMode(1);
        setBackground(androidx.appcompat.a.a.a.b(r7, ZeusTransformUtils.mapRes(R.color.oui_bg_base_2_1_low_elevation, "color", "oui_bg_base_2_1_low_elevation")));
        setTabStripPadding((int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2")), 0, (int) ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2")), 0);
        setShowTopLine(true);
        setShowSelectedIndicator(false);
    }

    @Override // com.obric.oui.tab.OTabLayoutBase, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    static {
        Companion = new a(null);
        sdkInit = new com.obric.oui.common.a();
    }
}
