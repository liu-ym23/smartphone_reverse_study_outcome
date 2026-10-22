package com.obric.autogui.agents.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f26447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f26448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26449c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f26447a == r6.f26447a) goto L12;
        return false;
    L12:
        if (o.a(this.f26448b, r6.f26448b) == true) goto L15;
        return false;
    L15:
        if (this.f26449c == r6.f26449c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f26447a.hashCode() * 31) + this.f26448b.hashCode()) * 31) + Boolean.hashCode(this.f26449c);
    }

    public String toString() {
        return "ActionEffectCompletionPlan(route=" + this.f26447a + ", original=" + this.f26448b + ", applyEvaluationResult=" + this.f26449c + ')';
    }

    public a(d r2, g r3, boolean r4) {
        o.e(r2, "route");
        o.e(r3, "original");
        this.f26447a = r2;
        this.f26448b = r3;
        this.f26449c = r4;
    }

    public final d a() {
        return this.f26447a;
    }

    public final g b() {
        return this.f26448b;
    }

    public final boolean c() {
        return this.f26449c;
    }
}
