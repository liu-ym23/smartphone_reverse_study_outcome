package com.bytedance.applog.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataIsolateKey.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5646a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f5647c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5648b;

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f5647c.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("USER_ID", 0, "user_id");
        f5646a = r0;
        f5647c = new a[]{r0};
    }

    private a(String r1, int r2, String r3) {
        super(r1, r2);
        this.f5648b = r3;
    }

    public String a() {
        return this.f5648b;
    }

    public static a a(String r5) {
        a[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        a r3 = r0[r2];
        if (r3.a().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }
}
