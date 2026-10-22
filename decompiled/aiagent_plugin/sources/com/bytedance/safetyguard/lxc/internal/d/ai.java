package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ActionContextToken;
import com.bytedance.safetyguard.lxc.api.ActionEgressResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionInterceptionController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActionContextToken f10170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ActionEgressResult f10171c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ai.class) == true) goto L8;
        return false;
    L8:
        ai r6 = (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f10169a, r6.f10169a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f10170b, r6.f10170b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f10171c, r6.f10171c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f10169a.hashCode() * 31) + this.f10170b.hashCode()) * 31) + this.f10171c.hashCode();
    }

    public String toString() {
        return "TerminalActionSnapshot(ownerId=" + this.f10169a + ", token=" + this.f10170b + ", result=" + this.f10171c + ')';
    }

    public ai(String r2, ActionContextToken r3, ActionEgressResult r4) {
        d.h.b.o.e(r2, "ownerId");
        d.h.b.o.e(r3, "token");
        d.h.b.o.e(r4, "result");
        this.f10169a = r2;
        this.f10170b = r3;
        this.f10171c = r4;
    }

    public final String a() {
        return this.f10169a;
    }

    public final ActionContextToken b() {
        return this.f10170b;
    }

    public final ActionEgressResult c() {
        return this.f10171c;
    }
}
