package com.obric.agent.intents.skill.d;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SystemSkillFailure.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15170b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f15169a, r6.f15169a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f15170b, r6.f15170b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f15169a.hashCode() * 31) + this.f15170b.hashCode();
    }

    public String toString() {
        return "SystemSkillFailure(code=" + this.f15169a + ", message=" + this.f15170b + ')';
    }

    public g(String r2, String r3) {
        o.e(r2, MonitorConstants.CODE);
        o.e(r3, "message");
        this.f15169a = r2;
        this.f15170b = r3;
    }

    public final String a() {
        return this.f15169a;
    }

    public final String b() {
        return this.f15170b;
    }
}
