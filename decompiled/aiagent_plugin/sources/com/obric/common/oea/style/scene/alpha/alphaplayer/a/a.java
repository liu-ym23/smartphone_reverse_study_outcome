package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f32483b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f32484c = null;

    static {
        a r1 = new a("GL_TEXTURE_VIEW", 0);
        f32482a = r1;
        a r2 = new a("GL_SURFACE_VIEW", 1);
        f32483b = r2;
        f32484c = new a[]{r1, r2};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f32484c.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }
}
