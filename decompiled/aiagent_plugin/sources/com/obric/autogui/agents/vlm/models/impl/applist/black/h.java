package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: AppBlackBean.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(IBdInstall.PARAM_APP_NAME)
    private final String f27409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("package_name")
    private final String f27410b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27409a, r6.f27409a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f27410b, r6.f27410b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f27409a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f27410b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppWhiteBean(appName=" + this.f27409a + ", packageName=" + this.f27410b + ')';
    }

    public final String a() {
        return this.f27410b;
    }
}
