package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f20138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f20139b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ o[] f20140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f20141d = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f20138a, f20139b};
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f20138a = new o("DETAIL", 0);
        f20139b = new o("LOAD", 1);
        o[] r0 = a();
        f20140c = r0;
        f20141d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f20140c.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
