package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LarkDeviceTokenPollStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10347a = null;

    static {
        f10347a = new e();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
        return false;
    L9:
        e r2 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        return true;
    }

    public int hashCode() {
        return 2080913109;
    }

    public String toString() {
        return "DeviceTokenPollState";
    }

    private e() {
    }
}
