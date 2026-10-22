package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33882a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f33883b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f33884c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f33885d = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f33882a, f33883b};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33882a = new b("OR", 0);
        f33883b = new b("SEQUENCE", 1);
        b[] r0 = a();
        f33884c = r0;
        f33885d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f33884c.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
