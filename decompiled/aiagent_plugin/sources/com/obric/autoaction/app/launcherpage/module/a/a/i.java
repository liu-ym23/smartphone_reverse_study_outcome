package com.obric.autoaction.app.launcherpage.module.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskListViewObjectCreator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24025b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24024a, r6.f24024a) == true) goto L12;
        return false;
    L12:
        if (this.f24025b == r6.f24025b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f24024a.hashCode() * 31) + Integer.hashCode(this.f24025b);
    }

    public String toString() {
        return "EndOfTaskData(summary=" + this.f24024a + ", endType=" + this.f24025b + ')';
    }

    public i(String r2, int r3) {
        o.e(r2, "summary");
        this.f24024a = r2;
        this.f24025b = r3;
    }

    public final String a() {
        return this.f24024a;
    }

    public final int b() {
        return this.f24025b;
    }
}
