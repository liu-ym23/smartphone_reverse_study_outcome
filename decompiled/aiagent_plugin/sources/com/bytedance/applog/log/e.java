package com.bytedance.applog.log;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GlobalLoggerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends m {
    public e() {
    }

    @Override // com.bytedance.applog.log.b, com.bytedance.applog.log.f
    public void a(String r2) {
        e("You should not set appId on global logger instance", new Object[0]);
    }

    @Override // com.bytedance.applog.log.b
    public void a(int r3, int r4, List<String> r5, Throwable r6, String r7, Object... r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (k.a() == false) goto L5;
        return;
    L5:
        h r2 = h.a().b(r3).a(r4).b(Thread.currentThread().getName()).a(r6).a(a(r9)).c(a(r7, r8)).a();
        k.a(r2);
        Iterator<g> r10 = k.c();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.aiagent.plugin")).a(r2);
        goto L7
    }
}
