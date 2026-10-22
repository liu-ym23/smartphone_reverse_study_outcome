package com.obric.agent.entitysync;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14497c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14495a, r6.f14495a) == true) goto L12;
        return false;
    L12:
        if (this.f14496b == r6.f14496b) goto L15;
        return false;
    L15:
        if (o.a(this.f14497c, r6.f14497c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14495a.hashCode() * 31) + Integer.hashCode(this.f14496b)) * 31) + this.f14497c.hashCode();
    }

    public String toString() {
        return "AppEntityIdentity(packageName=" + this.f14495a + ", type=" + this.f14496b + ", id=" + this.f14497c + ')';
    }

    public c(String r2, int r3, String r4) {
        o.e(r2, "packageName");
        o.e(r4, DbHelper.COL_ID);
        this.f14495a = r2;
        this.f14496b = r3;
        this.f14497c = r4;
    }

    public final String a() {
        return this.f14495a;
    }

    public final int getType() {
        return this.f14496b;
    }

    public final String b() {
        return this.f14497c;
    }
}
