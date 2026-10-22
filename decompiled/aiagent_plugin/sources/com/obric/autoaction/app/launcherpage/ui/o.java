package com.obric.autoaction.app.launcherpage.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SortableTaskListController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final /* synthetic */ String a(m r2, int r3, d.h.a.b r4) {
        return b(r2, r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private static final <T extends h> String b(m<T> r4, int r5, d.h.a.b<? super T, String> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        Object r0 = null;
        if (r5 == (-1)) goto L21;
        boolean r2 = false;
        if (r5 >= 0) goto L7;
    L9:
        if (r2 == false) goto L21;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L13
        Object r8 = d.n.f((String) ZeusTransformUtils.preCheckCast(r7.invoke(r4.b(r5)), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
    L16:
        if (d.n.b(r8) == true) goto L20;
        r0 = r8;
    L20:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
    L13:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L16
    L7:
        if (r5 >= r4.a()) goto L9;
        r2 = true;
    L21:
        return null;
    }
}
