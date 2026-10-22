package com.obric.common.oea.foundation.animation.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RunMode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f32345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f32346c = null;

    static {
        b r1 = new b("PARALLEL", 0);
        f32344a = r1;
        b r2 = new b("SERIAL", 1);
        f32345b = r2;
        f32346c = new b[]{r1, r2};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f32346c.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }
}
