package com.obric.autoaction.vdplayer.components.panel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TouchTargetUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    /* JADX INFO: renamed from: lambda$9UR-x-YDFJMy72vs_sQlXtNXLVM, reason: not valid java name */
    public static /* synthetic */ void m679lambda$9URxYDFJMy72vs_sQlXtNXLVM(View r0, View r1) {
        a(r0, r1);
    }

    public static final void a(final View r3) {
        o.e(r3, "<this>");
        ViewParent r0 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        final View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.post(new $$Lambda$d$9URxYDFJMy72vs_sQlXtNXLVM(r3, r1));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void a(View r5, View r6) {
        if (r5.getParent() == r6) goto L6;
        return;
    L6:
        if (r5.getVisibility() == 0) goto L9;
        r6.setTouchDelegate(null);
        return;
    L9:
        Rect r0 = new Rect();
        r5.getHitRect(r0);
        float r2 = 16;
        r0.right += d.i.a.a(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
        r0.top -= d.i.a.a(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
        r0.bottom += d.i.a.a(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
        r6.setTouchDelegate((TouchDelegate) ZeusTransformUtils.preCheckCast(new VisibleTouchDelegate(r0, r5), TouchDelegate.class, "com.obric.aiagent.plugin"));
    }
}
