package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: WheelRecyclerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WheelRecyclerView extends RecyclerView {
    public WheelRecyclerView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public WheelRecyclerView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return false;
    }

    public /* synthetic */ WheelRecyclerView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public WheelRecyclerView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView
    public boolean startNestedScroll(int r2, int r3) {
        if (r3 != 1) goto L6;
        return false;
    L6:
        return super.startNestedScroll(r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView
    public boolean fling(int r2, int r3) {
        stopNestedScroll(1);
        return super.fling(r2, r3);
    }
}
