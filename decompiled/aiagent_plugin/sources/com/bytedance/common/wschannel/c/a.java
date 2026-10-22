package com.bytedance.common.wschannel.c;

import android.os.Handler;
import com.bytedance.common.wschannel.c.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseHeartBeatPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends com.bytedance.common.wschannel.c.a.b> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f6792a;

    public abstract void a(c r1, Handler r2);

    public a(T r3) {
        this.f6792a = (T) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.c.a.b.class, "com.obric.aiagent.plugin");
    }
}
