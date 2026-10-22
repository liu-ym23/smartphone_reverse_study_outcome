package com.a.c.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: FieldDefinition.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b.b f3111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.b.a.a f3112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3113c;

    public static /* synthetic */ int lambda$fQbX5KgdomtArveiL2khPWt35YU(c r0) {
        return a(r0);
    }

    public c(com.a.c.b.b r3, com.a.c.b.a.a r4, boolean r5) {
        this.f3111a = (com.a.c.b.b) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r3, "CronFieldName must not be null"), com.a.c.b.b.class, "com.obric.aiagent.plugin");
        this.f3112b = (com.a.c.b.a.a) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r4, "FieldConstraints must not be null"), com.a.c.b.a.a.class, "com.obric.aiagent.plugin");
        this.f3113c = r5;
    }

    public com.a.c.b.b b() {
        return this.f3111a;
    }

    public com.a.c.b.a.a c() {
        return this.f3112b;
    }

    public boolean d() {
        return this.f3113c;
    }

    private static /* synthetic */ int a(c r0) {
        return r0.b().a();
    }

    public static Comparator<c> e() {
        return Comparator.comparingInt($$Lambda$c$fQbX5KgdomtArveiL2khPWt35YU.INSTANCE);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f3113c != r6.f3113c) goto L18;
        if (this.f3111a != r6.f3111a) goto L18;
        if (this.f3112b.equals(r6.f3112b) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f3111a, this.f3112b, Boolean.valueOf(this.f3113c)});
    }
}
