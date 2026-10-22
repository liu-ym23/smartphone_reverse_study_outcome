package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28240b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28239a, r6.f28239a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28240b, r6.f28240b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28239a.hashCode() * 31) + this.f28240b.hashCode();
    }

    public String toString() {
        return "AppCandidate(appName=" + this.f28239a + ", packageName=" + this.f28240b + ')';
    }

    public a(String r2, String r3) {
        d.h.b.o.e(r2, "appName");
        d.h.b.o.e(r3, "packageName");
        this.f28239a = r2;
        this.f28240b = r3;
    }

    public final String a() {
        return this.f28239a;
    }

    public final String b() {
        return this.f28240b;
    }
}
