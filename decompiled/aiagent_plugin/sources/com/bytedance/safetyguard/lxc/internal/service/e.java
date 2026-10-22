package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f11008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11009b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f11008a, r6.f11008a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f11009b, r6.f11009b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11008a.hashCode() * 31) + this.f11009b.hashCode();
    }

    public String toString() {
        return "AttachmentKey(clientToken=" + this.f11008a + ", attachmentId=" + this.f11009b + ')';
    }

    public e(IBinder r3, String r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "clientToken");
        d.h.b.o.e(r4, "attachmentId");
        this.f11008a = r5;
        this.f11009b = r4;
    }

    public final IBinder a() {
        return this.f11008a;
    }

    public final String b() {
        return this.f11009b;
    }
}
