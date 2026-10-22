package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8405b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8406c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f8407d = null;

    static {
        a r0 = new a("ADDRESS_FAMILY_UNSPECIFIED", 0);
        f8404a = r0;
        a r1 = new a("ADDRESS_FAMILY_IPV4", 1);
        f8405b = r1;
        a r3 = new a("ADDRESS_FAMILY_IPV6", 2);
        f8406c = r3;
        f8407d = new a[]{r0, r1, r3};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f8407d.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
