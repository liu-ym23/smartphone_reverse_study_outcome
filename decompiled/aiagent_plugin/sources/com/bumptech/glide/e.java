package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Priority.java */
/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3295b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f3296c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f3297d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ e[] f3298e = null;

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f3298e.clone(), e[].class, "com.obric.aiagent.plugin");
    }

    static {
        e r0 = new e("IMMEDIATE", 0);
        f3294a = r0;
        e r1 = new e("HIGH", 1);
        f3295b = r1;
        e r3 = new e("NORMAL", 2);
        f3296c = r3;
        e r5 = new e("LOW", 3);
        f3297d = r5;
        f3298e = new e[]{r0, r1, r3, r5};
    }
}
