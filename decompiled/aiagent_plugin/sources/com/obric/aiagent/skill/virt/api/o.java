package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f21585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f21586b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f21587c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ o[] f21588d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f21589e = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f21585a, f21586b, f21587c};
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f21585a = new o("COMPLETED", 0);
        f21586b = new o("INACTIVITY_RETURN", 1);
        f21587c = new o("HARD_TIMEOUT", 2);
        o[] r0 = a();
        f21588d = r0;
        f21589e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f21588d.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
