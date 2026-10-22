package com.obric.capabilitykit.entity.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f32137b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f32138c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32139d;

    static {
        f32136a = new b("AVAILABLE", 0, 0);
        f32137b = new b("UNAVAILABLE", 1, 1);
        f32138c = a();
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.f32139d = r3;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{f32136a, f32137b};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f32138c.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
