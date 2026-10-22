package com.ss.android.agilelogger;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LibLoader.java */
/* JADX INFO: loaded from: classes4.dex */
class e implements com.bytedance.android.alog.b {
    e() {
    }

    @Override // com.bytedance.android.alog.b
    public void a(String r3) {
        com.bytedance.librarian.a.a("alog", (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f37047a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("alog");
    }
}
