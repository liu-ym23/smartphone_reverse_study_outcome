package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    c() {
    }

    static RectF a(TabLayout.TabView r5, int r6) {
        int r0 = r5.getContentWidth();
        int r1 = r5.getContentHeight();
        int r7 = (int) r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
        if (r0 >= r7) goto L5;
        r0 = r7;
    L5:
        int r8 = (r5.getLeft() + r5.getRight()) / 2;
        int r2 = (r5.getTop() + r5.getBottom()) / 2;
        int r3 = r0 / 2;
        return new RectF(r8 - r3, r2 - (r1 / 2), r3 + r8, r2 + (r8 / 2));
    }

    static RectF a(TabLayout r3, View r4) {
        if (r4 != null) goto L6;
        return new RectF();
    L6:
        if (r3.isTabIndicatorFullWidth() == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, TabLayout.TabView.class) == false) goto L12;
        return a((TabLayout.TabView) ZeusTransformUtils.preCheckCast(r4, TabLayout.TabView.class, "com.obric.aiagent.plugin"), 24);
    L12:
        return new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    void a(TabLayout r2, View r3, Drawable r4) {
        RectF r1 = a(r2, r3);
        r4.setBounds((int) r1.left, r4.getBounds().top, (int) r1.right, r4.getBounds().bottom);
    }

    void a(TabLayout r1, View r2, View r3, float r4, Drawable r5) {
        RectF r0 = a(r1, r2);
        RectF r6 = a(r1, r3);
        r5.setBounds(com.google.android.material.animation.a.a((int) r0.left, (int) r6.left, r4), r5.getBounds().top, com.google.android.material.animation.a.a((int) r0.right, (int) r6.right, r4), r5.getBounds().bottom);
    }
}
