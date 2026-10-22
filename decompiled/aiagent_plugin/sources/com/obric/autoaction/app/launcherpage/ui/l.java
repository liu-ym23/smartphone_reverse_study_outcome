package com.obric.autoaction.app.launcherpage.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SortableTaskAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24449d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (this.f24446a == r6.f24446a) goto L12;
        return false;
    L12:
        if (this.f24447b == r6.f24447b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f24446a) * 31) + Integer.hashCode(this.f24447b);
    }

    public String toString() {
        return "SortRange(fromIndex=" + this.f24446a + ", toIndex=" + this.f24447b + ')';
    }

    public l(int r2, int r3) {
        this.f24446a = r2;
        this.f24447b = r3;
        this.f24448c = Math.min(r2, r3);
        this.f24449d = Math.max(r2, r3);
    }

    public final int a() {
        return this.f24448c;
    }

    public final int b() {
        return this.f24449d;
    }
}
