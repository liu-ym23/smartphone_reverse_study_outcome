package com.bytedance.common.wschannel.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppState.java */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6794b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f6796d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f6797e = null;

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f6797e.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("STATE_FOREGROUND", 0);
        f6793a = r0;
        a r1 = new a("STATE_BACKGROUND", 1);
        f6794b = r1;
        a r3 = new a("STATE_LIGHT_DOZE", 2);
        f6795c = r3;
        a r5 = new a("STATE_DOZE", 3);
        f6796d = r5;
        f6797e = new a[]{r0, r1, r3, r5};
    }
}
