package com.obric.autoaction.presentation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.obric.oui.common.style.i;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TouchAwareConstrainLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TouchAwareConstraintLayout extends OUIConstraintLayout {
    private a<x> onTouchDownListener;

    public TouchAwareConstraintLayout(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, null, 14, null);
    }

    public TouchAwareConstraintLayout(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, null, 12, null);
    }

    public TouchAwareConstraintLayout(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r12, null, 8, null);
    }

    public /* synthetic */ TouchAwareConstraintLayout(Context r2, AttributeSet r3, int r4, i r5, int r6, h r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = new i(r8, r9, r4, 0);
    L11:
        this(r8, r9, r4, r5);
    }

    public TouchAwareConstraintLayout(Context r3, AttributeSet r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r6, "provider");
        super(r7, r8, r5, r6);
    }

    public final a<x> getOnTouchDownListener() {
        return this.onTouchDownListener;
    }

    public final void setOnTouchDownListener(a<x> r3) {
        this.onTouchDownListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        if (r2.getAction() != 0) goto L8;
        a<x> r0 = this.onTouchDownListener;
        if (r0 == null) goto L8;
        r0.invoke();
    L8:
        return super.dispatchTouchEvent(r2);
    }
}
