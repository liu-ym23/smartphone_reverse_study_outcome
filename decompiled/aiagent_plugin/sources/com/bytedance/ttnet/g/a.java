package com.bytedance.ttnet.g;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ModeDefault.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends i.a {
    @Override // com.bytedance.ttnet.g.i.a
    public void a() {
    }

    @Override // com.bytedance.ttnet.g.i.a
    public void b() {
    }

    public a() {
    }

    private int d(com.bytedance.retrofit2.b.c r5) {
        List<com.bytedance.retrofit2.b.b> r4 = r5.b("x-tt-request-tag");
        if (r4 != null) goto L5;
    L9:
        String r6 = "";
    L11:
        return l.a().a(r5.b(), r6);
    L5:
        if (r4.size() < 1) goto L9;
        if (TextUtils.isEmpty(((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r4.get(0), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).b()) == true) goto L9;
        r6 = ((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r4.get(0), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).b();
        goto L11
    }

    @Override // com.bytedance.retrofit2.f.a
    public void a(com.bytedance.retrofit2.b.c r8) {
        long r5 = d(r8);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeDefault", "get tag delay time " + r5 + " " + r8.o());
    L5:
        this.f11483a.a(r8, true, false, r5);
    }

    @Override // com.bytedance.retrofit2.f.a
    public boolean a(com.bytedance.retrofit2.b.c r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.aiagent.plugin");
        long r5 = d(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeDefault", "get tag delay time " + r5 + " " + r10.o());
    L6:
        return this.f11483a.a(r10, true, r5, r7, r8);
    }

    @Override // com.bytedance.ttnet.g.i.a
    i.b c() {
        return i.b.f11489a;
    }
}
