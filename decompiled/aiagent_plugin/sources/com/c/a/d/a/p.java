package com.c.a.d.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SPMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends com.c.a.d.a {
    @Override // com.c.a.d.a
    public String b() {
        return "sp";
    }

    public p() {
    }

    @Override // com.c.a.d.a
    public synchronized boolean d(com.c.a.c.a r5) {
        monitor-enter(this);
        File r0 = com.c.a.e.b.a.g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        a("sp文件拷贝失败", r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L8:
        com.c.a.g.b.a().a(r5, r0.getParentFile(), "default_sp_file_type");     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }
}
