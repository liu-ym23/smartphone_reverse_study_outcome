package com.gyf.immersionbar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NavigationBarType.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f13862b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f13863c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f13864d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f13865e = null;
    private static final /* synthetic */ j[] g = null;
    private final int f;

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(g.clone(), j[].class, "com.obric.aiagent.plugin");
    }

    static {
        j r0 = new j("CLASSIC", 0, 0);
        f13861a = r0;
        j r1 = new j("GESTURES", 1, 1);
        f13862b = r1;
        j r3 = new j("GESTURES_THREE_STAGE", 2, 2);
        f13863c = r3;
        j r5 = new j("DOUBLE", 3, 3);
        f13864d = r5;
        j r7 = new j("UNKNOWN", 4, -1);
        f13865e = r7;
        g = new j[]{r0, r1, r3, r5, r7};
    }

    private j(String r1, int r2, int r3) {
        super(r1, r2);
        this.f = r3;
    }

    public int getType() {
        return this.f;
    }
}
