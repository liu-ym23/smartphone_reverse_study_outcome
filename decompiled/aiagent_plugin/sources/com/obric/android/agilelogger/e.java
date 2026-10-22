package com.obric.android.agilelogger;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LibLoader.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements com.obric.android.alog.a {
    e() {
    }

    @Override // com.obric.android.alog.a
    public void a(String r3) {
        com.bytedance.librarian.a.a("oalog", (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f22354a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("oalog");
    }
}
