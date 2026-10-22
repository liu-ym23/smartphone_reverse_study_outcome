package com.obric.aiagent.executionengine.scheduler.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: IEventManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17959a;

    public c() {
        this(0, 1, null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
        return false;
    L8:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin");
        if (this.f17959a == r8.f17959a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f17959a);
    }

    public String toString() {
        return "TimeEventInput(time=" + this.f17959a + ')';
    }

    public /* synthetic */ c(long r1, int r3, h r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = -1;
    L5:
        this(r1);
    }

    public final long e() {
        return this.f17959a;
    }

    public c(long r10) {
        super(null, 0, 0, 0, 15, null);
        this.f17959a = r10;
    }
}
