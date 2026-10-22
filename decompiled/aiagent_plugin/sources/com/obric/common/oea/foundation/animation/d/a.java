package com.obric.common.oea.foundation.animation.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RepeatMode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f32341b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f32342c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f32343d = null;

    static {
        a r1 = new a("NORMAL", 0);
        f32340a = r1;
        a r2 = new a("LOOP", 1);
        f32341b = r2;
        a r3 = new a("REVERSE", 2);
        f32342c = r3;
        f32343d = new a[]{r1, r2, r3};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f32343d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }
}
