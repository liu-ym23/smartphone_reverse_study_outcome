package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
final class fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MonitorConstants.CODE)
    private final long f19861a;

    public fa() {
        this(0, 1, null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, fa.class) == true) goto L8;
        return false;
    L8:
        fa r8 = (fa) ZeusTransformUtils.preCheckCast(r7, fa.class, "com.obric.aiagent.plugin");
        if (this.f19861a == r8.f19861a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f19861a);
    }

    public String toString() {
        return "SkillServerTrackingResponse(code=" + this.f19861a + ')';
    }

    public fa(long r1) {
        this.f19861a = r1;
    }

    public /* synthetic */ fa(long r1, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = Long.MIN_VALUE;
    L5:
        this(r1);
    }

    public final long a() {
        return this.f19861a;
    }
}
