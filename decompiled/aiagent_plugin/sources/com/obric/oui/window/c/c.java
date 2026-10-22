package com.obric.oui.window.c;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f36884a;

    public c(b r2) {
        o.e(r2, "_bounds");
        this.f36884a = r2;
    }

    public c(Rect r2) {
        o.e(r2, "bounds");
        this(new b(r2));
    }

    public final Rect a() {
        return this.f36884a.a();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (o.a(getClass(), r3.getClass()) == false) goto L13;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        return o.a(this.f36884a, r4.f36884a);
    L13:
        return false;
    }

    public int hashCode() {
        return this.f36884a.hashCode();
    }
}
