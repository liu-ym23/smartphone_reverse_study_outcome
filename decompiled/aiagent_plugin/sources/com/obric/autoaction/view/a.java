package com.obric.autoaction.view;

import android.os.SystemClock;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX INFO: renamed from: lambda$d8oRKPjVGcTd3lN-Cy8ftKXtdmU, reason: not valid java name */
    public static /* synthetic */ void m708lambda$d8oRKPjVGcTd3lNCy8ftKXtdmU(long r0, b r2, View r3) {
        a(r0, r2, r3);
    }

    public static /* synthetic */ void a(View r1, long r2, b r4, int r5, Object r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L5;
        r2 = 300;
    L5:
        a(r1, r2, r7);
    }

    public static final void a(View r2, final long r3, b<? super View, x> r5) {
        final b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r6, "onClick");
        r2.setOnClickListener(new $$Lambda$a$d8oRKPjVGcTd3lNCy8ftKXtdmU(r3, r6));
    }

    private static final void a(long r5, b r7, View r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        Object r2 = r8.getTag(-10001);
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L5;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        long r3 = r1.longValue();
    L9:
        long r4 = SystemClock.elapsedRealtime();
        if ((r4 - r3) < r5) goto L13;
        r8.setTag(-10001, Long.valueOf(r4));
        o.a(r8);
        r9.invoke(r8);
        return;
    L13:
        return;
    L8:
        r3 = 0;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
