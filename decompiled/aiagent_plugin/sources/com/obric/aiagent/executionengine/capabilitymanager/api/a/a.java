package com.obric.aiagent.executionengine.capabilitymanager.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CapabilityType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16400b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f16401c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f16402e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16403d;

    private static final /* synthetic */ a[] b() {
        return new a[]{f16399a, f16400b, f16401c};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f16403d = r3;
    }

    public final int a() {
        return this.f16403d;
    }

    static {
        f16399a = new a("APP_FUNCTION_DSL", 0, 150);
        f16400b = new a("APP_FUNCTION", 1, 100);
        f16401c = new a("APP_INTENT", 2, 50);
        a[] r0 = b();
        f16402e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f16402e.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
