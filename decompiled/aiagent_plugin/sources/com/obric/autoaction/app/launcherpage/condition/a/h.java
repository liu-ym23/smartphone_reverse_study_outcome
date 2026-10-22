package com.obric.autoaction.app.launcherpage.condition.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22931a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f22931a == r6.f22931a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Integer.hashCode(this.f22931a);
    }

    public String toString() {
        return "WeekItem(number=" + this.f22931a + ')';
    }

    public int a() {
        return this.f22931a;
    }

    public String b() {
        return f.a(a());
    }
}
