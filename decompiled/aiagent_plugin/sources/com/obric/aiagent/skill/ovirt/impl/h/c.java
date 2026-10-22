package com.obric.aiagent.skill.ovirt.impl.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActiveTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21453a;

    public static String a(String r0) {
        return r0;
    }

    public static boolean a(String r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, c.class) == true) goto L6;
        return false;
    L6:
        if (o.a(r3, ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static int b(String r0) {
        return r0.hashCode();
    }

    public static String c(String r1) {
        o.e(r1, "value");
        return r1;
    }

    public final /* synthetic */ String a() {
        return this.f21453a;
    }

    public boolean equals(Object r1) {
        return a(this.f21453a, r1);
    }

    public int hashCode() {
        return b(this.f21453a);
    }

    public String toString() {
        return a(this.f21453a);
    }
}
