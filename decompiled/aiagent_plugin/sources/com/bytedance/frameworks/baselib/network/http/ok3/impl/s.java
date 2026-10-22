package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes.dex */
final enum s extends Enum<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f8564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f8565b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f8566c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f8567d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s f8568e = null;
    private static final /* synthetic */ s[] f = null;

    static {
        s r0 = new s("UNKNOWN", 0);
        f8564a = r0;
        s r1 = new s("SUCCESS", 1);
        f8565b = r1;
        s r3 = new s("IO_PENDING", 2);
        f8566c = r3;
        s r5 = new s("CANCELED", 3);
        f8567d = r5;
        s r7 = new s("FAILED", 4);
        f8568e = r7;
        f = new s[]{r0, r1, r3, r5, r7};
    }

    private s(String r1, int r2) {
        super(r1, r2);
    }

    public static s valueOf(String r2) {
        return (s) ZeusTransformUtils.preCheckCast(Enum.valueOf(s.class, r2), s.class, "com.obric.aiagent.plugin");
    }

    public static s[] values() {
        return (s[]) ZeusTransformUtils.preCheckCast(f.clone(), s[].class, "com.obric.aiagent.plugin");
    }
}
