package com.obric.agent.entitysync;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonObject f14531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14532b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14531a, r6.f14531a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14532b, r6.f14532b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f14531a.hashCode() * 31) + this.f14532b.hashCode();
    }

    public String toString() {
        return "AppEntityUpdate(entityInfo=" + this.f14531a + ", updateType=" + this.f14532b + ')';
    }

    public j(JsonObject r2, String r3) {
        o.e(r2, "entityInfo");
        o.e(r3, "updateType");
        this.f14531a = r2;
        this.f14532b = r3;
    }

    public final JsonObject a() {
        return this.f14531a;
    }

    public final String b() {
        return this.f14532b;
    }
}
