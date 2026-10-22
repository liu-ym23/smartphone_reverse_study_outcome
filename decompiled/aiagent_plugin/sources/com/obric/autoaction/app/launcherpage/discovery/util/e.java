package com.obric.autoaction.app.launcherpage.discovery.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PromptSlotParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f23662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23663b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23662a, r6.f23662a) == true) goto L12;
        return false;
    L12:
        if (this.f23663b == r6.f23663b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f23662a.hashCode() * 31) + Integer.hashCode(this.f23663b);
    }

    public String toString() {
        return "SpanGroup(span=" + this.f23662a + ", flag=" + this.f23663b + ')';
    }

    public e(Object r2, int r3) {
        o.e(r2, "span");
        this.f23662a = r2;
        this.f23663b = r3;
    }

    public final Object a() {
        return this.f23662a;
    }

    public final int b() {
        return this.f23663b;
    }
}
