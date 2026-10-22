package com.obric.common.oea.style.scene.qsanim.morph;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f32572b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f32573c = null;

    static {
        a r1 = new a("SCALE_UP", 0);
        f32571a = r1;
        a r2 = new a("SCALE_DOWN", 1);
        f32572b = r2;
        f32573c = new a[]{r1, r2};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f32573c.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }
}
