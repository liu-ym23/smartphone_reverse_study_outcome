package com.obric.autogui.agents.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SettingsActionEffectPolicyProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.a f26504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26506c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f26504a == r6.f26504a) goto L12;
        return false;
    L12:
        if (this.f26505b == r6.f26505b) goto L15;
        return false;
    L15:
        if (this.f26506c == r6.f26506c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f26504a.hashCode() * 31) + Boolean.hashCode(this.f26505b)) * 31) + Boolean.hashCode(this.f26506c);
    }

    public String toString() {
        return "ActionEffectRollout(action=" + this.f26504a + ", observeEnabled=" + this.f26505b + ", retryWaitEnabled=" + this.f26506c + ')';
    }

    public d(com.obric.autogui.agents.a.f.a r2, boolean r3, boolean r4) {
        o.e(r2, "action");
        this.f26504a = r2;
        this.f26505b = r3;
        this.f26506c = r4;
    }

    public final com.obric.autogui.agents.a.f.a a() {
        return this.f26504a;
    }

    public final boolean b() {
        return this.f26505b;
    }

    public final boolean c() {
        return this.f26506c;
    }
}
