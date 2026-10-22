package com.obric.autogui.agents.scripted.a;

import com.google.gson.annotations.SerializedName;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ScriptStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final String f26852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("args")
    private final List<Object> f26853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(VDPlayerEffectProviderImpl.KEY_THOUGHT)
    private String f26854c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26852a, r6.f26852a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26853b, r6.f26853b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26854c, r6.f26854c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26852a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Object> r4 = this.f26853b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f26854c;
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

    public String toString() {
        return "ActionDescriptor(type=" + this.f26852a + ", args=" + this.f26853b + ", thought=" + this.f26854c + ')';
    }

    public final String getType() {
        return this.f26852a;
    }

    public final List<Object> a() {
        return this.f26853b;
    }

    public final String b() {
        return this.f26854c;
    }
}
