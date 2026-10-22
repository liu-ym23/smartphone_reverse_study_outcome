package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MemoryCategory.java */
/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f3273b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f3274c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d[] f3275e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f3276d;

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f3275e.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("LOW", 0, 0.5f);
        f3272a = r0;
        d r1 = new d("NORMAL", 1, 1.0f);
        f3273b = r1;
        d r3 = new d("HIGH", 2, 1.5f);
        f3274c = r3;
        f3275e = new d[]{r0, r1, r3};
    }

    private d(String r1, int r2, float r3) {
        super(r1, r2);
        this.f3276d = r3;
    }

    public float a() {
        return this.f3276d;
    }
}
