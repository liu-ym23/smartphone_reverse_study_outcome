package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillSpellManager.kt */
/* JADX INFO: loaded from: classes2.dex */
final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18235d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18232a, r6.f18232a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18233b, r6.f18233b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f18234c, r6.f18234c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18235d, r6.f18235d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f18232a.hashCode() * 31) + this.f18233b.hashCode()) * 31) + this.f18234c.hashCode()) * 31) + this.f18235d.hashCode();
    }

    public String toString() {
        return "SpellSyncFailedItem(slug=" + this.f18232a + ", packageName=" + this.f18233b + ", appVersion=" + this.f18234c + ", errorCode=" + this.f18235d + ')';
    }

    public al(String r2, String r3, String r4, String r5) {
        d.h.b.o.e(r2, "slug");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r4, "appVersion");
        d.h.b.o.e(r5, "errorCode");
        this.f18232a = r2;
        this.f18233b = r3;
        this.f18234c = r4;
        this.f18235d = r5;
    }

    public final String a() {
        return this.f18232a;
    }

    public final String b() {
        return this.f18233b;
    }

    public final String c() {
        return this.f18234c;
    }

    public final String d() {
        return this.f18235d;
    }
}
