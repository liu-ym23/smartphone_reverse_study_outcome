package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f35391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f35392b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ f[] f35393d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f35394c;

    private static final /* synthetic */ f[] a() {
        return new f[]{f35391a, f35392b};
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f35393d.clone(), f[].class, "com.obric.aiagent.plugin");
    }

    private f(String r1, int r2, float r3) {
        super(r1, r2);
        this.f35394c = r3;
    }

    static {
        f35391a = new f("FORWARD", 0, -1.0f);
        f35392b = new f("BACKWARD", 1, 1.0f);
        f35393d = a();
    }

    public final float a(float r1) {
        return this.f35394c * r1;
    }
}
