package com.gyf.immersionbar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BarHide.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f13827b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f13828c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13829d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b[] f13830e = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f13830e.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("FLAG_HIDE_STATUS_BAR", 0);
        f13826a = r0;
        b r1 = new b("FLAG_HIDE_NAVIGATION_BAR", 1);
        f13827b = r1;
        b r3 = new b("FLAG_HIDE_BAR", 2);
        f13828c = r3;
        b r5 = new b("FLAG_SHOW_BAR", 3);
        f13829d = r5;
        f13830e = new b[]{r0, r1, r3, r5};
    }
}
