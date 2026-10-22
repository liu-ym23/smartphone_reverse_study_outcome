package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum ah extends Enum<ah> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah f10936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ah f10937b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ah f10938c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ ah[] f10939d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f10940e = null;

    private static final /* synthetic */ ah[] a() {
        return new ah[]{f10936a, f10937b, f10938c};
    }

    public static ah valueOf(String r2) {
        return (ah) ZeusTransformUtils.preCheckCast(Enum.valueOf(ah.class, r2), ah.class, "com.obric.aiagent.plugin");
    }

    public static ah[] values() {
        return (ah[]) ZeusTransformUtils.preCheckCast(f10939d.clone(), ah[].class, "com.obric.aiagent.plugin");
    }

    private ah(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10936a = new ah("STARTING", 0);
        f10937b = new ah("RUNNING", 1);
        f10938c = new ah("TERMINATING", 2);
        ah[] r0 = a();
        f10939d = r0;
        f10940e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
