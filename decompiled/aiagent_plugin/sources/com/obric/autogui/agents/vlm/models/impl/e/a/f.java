package com.obric.autogui.agents.vlm.models.impl.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OperationExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.operator.b.EnumC0777b f27810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f27811c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f27809a, r6.f27809a) == true) goto L12;
        return false;
    L12:
        if (this.f27810b == r6.f27810b) goto L15;
        return false;
    L15:
        if (o.a(this.f27811c, r6.f27811c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f27809a.hashCode() * 31) + this.f27810b.hashCode()) * 31;
        String r2 = this.f27811c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ScriptOpExecFailure(result=" + this.f27809a + ", opType=" + this.f27810b + ", detail=" + this.f27811c + ')';
    }

    public f(String r2, com.obric.autogui.operator.b.EnumC0777b r3, String r4) {
        o.e(r2, "result");
        o.e(r3, "opType");
        this.f27809a = r2;
        this.f27810b = r3;
        this.f27811c = r4;
    }

    public final String a() {
        return this.f27809a;
    }

    public final com.obric.autogui.operator.b.EnumC0777b b() {
        return this.f27810b;
    }

    public final String c() {
        return this.f27811c;
    }
}
