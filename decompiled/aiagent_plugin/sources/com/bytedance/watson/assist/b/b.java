package com.bytedance.watson.assist.b;

import android.content.Context;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f11822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f11823b;

    public void a() {
    }

    public b(Context r3, c r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        this.f11822a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f11823b = r6;
    }
}
