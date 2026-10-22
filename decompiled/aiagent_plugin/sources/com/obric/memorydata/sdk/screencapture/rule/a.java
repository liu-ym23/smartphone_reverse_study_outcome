package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScreenshotOption.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f33878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f33879c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f33880d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f33881e = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f33877a, f33878b, f33879c};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33877a = new a("NO_CACHE", 0);
        f33878b = new a("CACHE_WITH_ROOT_NODE", 1);
        f33879c = new a("CACHE_WITH_UNIQUE_NODE", 2);
        a[] r0 = a();
        f33880d = r0;
        f33881e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f33880d.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
