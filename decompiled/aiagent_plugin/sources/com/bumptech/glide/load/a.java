package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataSource.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3350b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3351c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3352d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3353e = null;
    private static final /* synthetic */ a[] f = null;

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("LOCAL", 0);
        f3349a = r0;
        a r1 = new a("REMOTE", 1);
        f3350b = r1;
        a r3 = new a("DATA_DISK_CACHE", 2);
        f3351c = r3;
        a r5 = new a("RESOURCE_DISK_CACHE", 3);
        f3352d = r5;
        a r7 = new a("MEMORY_CACHE", 4);
        f3353e = r7;
        f = new a[]{r0, r1, r3, r5, r7};
    }
}
