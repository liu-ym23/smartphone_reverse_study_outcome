package com.obric.autoaction.app.launcherpage.main;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IMainTab.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23967b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23966a, r6.f23966a) == true) goto L12;
        return false;
    L12:
        if (this.f23967b == r6.f23967b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f23966a.hashCode() * 31) + Integer.hashCode(this.f23967b);
    }

    public String toString() {
        return "TabConfig(title=" + this.f23966a + ", iconRes=" + this.f23967b + ')';
    }

    public c(String r2, int r3) {
        o.e(r2, DBDefinition.TITLE);
        this.f23966a = r2;
        this.f23967b = r3;
    }

    public final String a() {
        return this.f23966a;
    }

    public final int b() {
        return this.f23967b;
    }
}
