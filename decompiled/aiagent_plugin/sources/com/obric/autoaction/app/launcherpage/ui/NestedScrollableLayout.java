package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NestedScrollableLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NestedScrollableLayout extends FrameLayout {
    public NestedScrollableLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public NestedScrollableLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ NestedScrollableLayout(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public NestedScrollableLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        d.h.b.o.e(r4, "ev");
        int r0 = r4.getAction();
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
    L11:
        getParent().requestDisallowInterceptTouchEvent(false);
    L14:
        return super.onInterceptTouchEvent(r4);
    L6:
        if (r0 != 2) goto L8;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L14
    L8:
        if (r0 == 3) goto L11;
    L12:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L14
    }
}
