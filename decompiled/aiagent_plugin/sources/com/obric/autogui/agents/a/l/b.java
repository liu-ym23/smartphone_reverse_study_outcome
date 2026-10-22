package com.obric.autogui.agents.a.l;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectSnapshotModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f26538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26540e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f26536a == r6.f26536a) goto L12;
        return false;
    L12:
        if (this.f26537b == r6.f26537b) goto L15;
        return false;
    L15:
        if (o.a(this.f26538c, r6.f26538c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26539d, r6.f26539d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26540e, r6.f26540e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.f26536a) * 31) + Boolean.hashCode(this.f26537b)) * 31;
        ComponentName r1 = this.f26538c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f26539d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f26540e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectForegroundTaskFacts(taskId=" + this.f26536a + ", isVisible=" + this.f26537b + ", topComponent=" + this.f26538c + ", realOwnerPackage=" + this.f26539d + ", baseOwnerPackage=" + this.f26540e + ')';
    }

    public b(int r1, boolean r2, ComponentName r3, String r4, String r5) {
        this.f26536a = r1;
        this.f26537b = r2;
        this.f26538c = r3;
        this.f26539d = r4;
        this.f26540e = r5;
    }

    public final boolean a() {
        return this.f26537b;
    }

    public final ComponentName b() {
        return this.f26538c;
    }

    public final String c() {
        return this.f26539d;
    }

    public final String d() {
        return this.f26540e;
    }
}
