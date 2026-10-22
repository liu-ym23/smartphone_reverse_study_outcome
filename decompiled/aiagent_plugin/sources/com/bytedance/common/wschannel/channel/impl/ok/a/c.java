package com.bytedance.common.wschannel.channel.impl.ok.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RetryTimesPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6827b;

    public c(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 4);
    }

    c(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        if (r4 >= 0) goto L5;
        r4 = 4;
    L5:
        this.f6826a = r4;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.a.a
    public long a() {
        if (this.f6827b >= this.f6826a) goto L5;
        long r0 = super.a();
    L7:
        if (r0 == (-1)) goto L9;
        this.f6827b++;
    L9:
        return r0;
    L5:
        r0 = -1;
        goto L7
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.f6826a + ", mCurrRetryTime=" + this.f6827b + '}';
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.a.a, com.bytedance.common.wschannel.channel.impl.ok.a.b
    public void c() {
        super.c();
        this.f6827b = 0;
    }
}
