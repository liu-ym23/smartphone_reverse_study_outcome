package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f33891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f33892b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ d[] f33893c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f33894d = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f33891a, f33892b};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33891a = new d("CONTAINS", 0);
        f33892b = new d("NOT_CONTAINS", 1);
        d[] r0 = a();
        f33893c = r0;
        f33894d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f33893c.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
