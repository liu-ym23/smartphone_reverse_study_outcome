package com.obric.autoaction.presentation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: LockableScrollView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LockableScrollView extends ScrollView {
    private boolean isScrollable;

    /* JADX WARN: Multi-variable type inference failed */
    public LockableScrollView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LockableScrollView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public LockableScrollView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        this.isScrollable = true;
    }

    public final boolean isScrollable() {
        return this.isScrollable;
    }

    public final void setScrollable(boolean r1) {
        this.isScrollable = r1;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.isScrollable == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.isScrollable == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }
}
