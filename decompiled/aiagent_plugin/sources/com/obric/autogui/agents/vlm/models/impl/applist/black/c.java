package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppBlackListCriteria.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27351a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27351a, r6.f27351a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.f27351a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AppBlackListCriteria(packageName=" + this.f27351a + ')';
    }

    public c(String r1) {
        this.f27351a = r1;
    }

    public final String a() {
        return this.f27351a;
    }
}
