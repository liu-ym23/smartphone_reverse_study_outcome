package com.obric.autoaction.app.launcherpage.module.datasource;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TimerTaskRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f24203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f24205c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
        return false;
    L8:
        d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin");
        if (this.f24203a == r10.f24203a) goto L12;
        return false;
    L12:
        if (this.f24204b == r10.f24204b) goto L15;
        return false;
    L15:
        if (this.f24205c == r10.f24205c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f24203a) * 31) + Long.hashCode(this.f24204b)) * 31) + Long.hashCode(this.f24205c);
    }

    public String toString() {
        return "SimplyTaskForPreview(success=" + this.f24203a + ", gmtStartedMillis=" + this.f24204b + ", execDurationMillis=" + this.f24205c + ')';
    }

    public d(boolean r1, long r2, long r4) {
        this.f24203a = r1;
        this.f24204b = r2;
        this.f24205c = r4;
    }

    public final long a() {
        return this.f24204b;
    }
}
