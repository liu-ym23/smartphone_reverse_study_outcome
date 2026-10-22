package com.obric.aiagent.skill.manager.impl;

import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerKeva.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cx f19710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f19711b = null;

    /* JADX INFO: renamed from: lambda$eqpuPfi4VYrny-Q6WO2ylhN-SVs, reason: not valid java name */
    public static /* synthetic */ Keva m280lambda$eqpuPfi4VYrnyQ6WO2ylhNSVs() {
        return b();
    }

    private cx() {
    }

    static {
        f19710a = new cx();
        f19711b = d.g.a($$Lambda$cx$eqpuPfi4VYrnyQ6WO2ylhNSVs.INSTANCE);
    }

    public final Keva a() {
        Object r2 = f19711b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (Keva) ZeusTransformUtils.preCheckCast(r2, Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva b() {
        return Keva.getRepo("skill_manager", 1);
    }
}
