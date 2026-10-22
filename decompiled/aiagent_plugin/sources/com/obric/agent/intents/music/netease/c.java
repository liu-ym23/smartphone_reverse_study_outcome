package com.obric.agent.intents.music.netease;

import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CMApiManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f14757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f14761e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14757a, r6.f14757a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14758b, r6.f14758b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14759c, r6.f14759c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Bundle r0 = this.f14757a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f14758b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f14759c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public c(Bundle r1, String r2, String r3) {
        this.f14757a = r1;
        this.f14758b = r2;
        this.f14759c = r3;
        this.f14760d = b.a(r1);
        this.f14761e = b.b(r1);
    }

    public final Bundle a() {
        return this.f14757a;
    }

    public final int b() {
        return this.f14760d;
    }

    public String toString() {
        if (ILogDepend.Companion.isDebug() == false) goto L7;
        return "obricCode:" + this.f14760d + ",cmapiCode:" + this.f14761e + ", msg:" + this.f14758b + ", debugMsg:" + this.f14759c + ", data:" + a.a(this.f14757a, 0, 1, null);
    L7:
        return super.toString();
    }
}
