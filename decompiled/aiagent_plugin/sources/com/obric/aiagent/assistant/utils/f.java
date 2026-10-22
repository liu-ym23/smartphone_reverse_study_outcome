package com.obric.aiagent.assistant.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f16325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f16326b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f16327c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f16328d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f16329e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ f[] a() {
        return new f[]{f16325a, f16326b, f16327c, f16328d};
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f16325a = new f("CannotObtain", 0);
        f16326b = new f("Timeout", 1);
        f16327c = new f("NotApproved", 2);
        f16328d = new f("Approved", 3);
        f[] r0 = a();
        f16329e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f16329e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
