package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PreferredColorSpace.java */
/* JADX INFO: loaded from: classes.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f3770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f3771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ j[] f3772c = null;

    private j(String r1, int r2) {
        super(r1, r2);
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f3772c.clone(), j[].class, "com.obric.aiagent.plugin");
    }

    static {
        j r0 = new j("SRGB", 0);
        f3770a = r0;
        j r1 = new j("DISPLAY_P3", 1);
        f3771b = r1;
        f3772c = new j[]{r0, r1};
    }
}
