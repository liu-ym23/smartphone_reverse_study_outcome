package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DecodeFormat.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3394a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3395b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f3396c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ b[] f3397d = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f3397d.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("PREFER_ARGB_8888", 0);
        f3394a = r0;
        b r1 = new b("PREFER_RGB_565", 1);
        f3395b = r1;
        f3397d = new b[]{r0, r1};
        f3396c = r0;
    }
}
