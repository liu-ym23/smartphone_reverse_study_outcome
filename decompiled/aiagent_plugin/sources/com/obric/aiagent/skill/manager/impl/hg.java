package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillUpdateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum hg extends Enum<hg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hg f20101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final hg f20102b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ hg[] f20103e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f20104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.au f20105d;

    private static final /* synthetic */ hg[] c() {
        return new hg[]{f20101a, f20102b};
    }

    private hg(String r1, int r2, o r3, com.obric.aiagent.skill.manager.api.au r4) {
        super(r1, r2);
        this.f20104c = r3;
        this.f20105d = r4;
    }

    public final o a() {
        return this.f20104c;
    }

    public final com.obric.aiagent.skill.manager.api.au b() {
        return this.f20105d;
    }

    static {
        f20101a = new hg("LOAD", 0, o.f20139b, com.obric.aiagent.skill.manager.api.au.h);
        f20102b = new hg("DETAIL", 1, o.f20138a, com.obric.aiagent.skill.manager.api.au.g);
        hg[] r0 = c();
        f20103e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static hg valueOf(String r2) {
        return (hg) ZeusTransformUtils.preCheckCast(Enum.valueOf(hg.class, r2), hg.class, "com.obric.aiagent.plugin");
    }

    public static hg[] values() {
        return (hg[]) ZeusTransformUtils.preCheckCast(f20103e.clone(), hg[].class, "com.obric.aiagent.plugin");
    }
}
