package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f33900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f33901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f33902c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f33903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f33904e = null;
    public static final g f = null;
    private static final /* synthetic */ g[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    private static final /* synthetic */ g[] a() {
        return new g[]{f33900a, f33901b, f33902c, f33903d, f33904e, f};
    }

    private g(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33900a = new g("EQUALS", 0);
        f33901b = new g("CONTAINS", 1);
        f33902c = new g("REGEX", 2);
        f33903d = new g("WILDCARD", 3);
        f33904e = new g("NOT_CONTAINS", 4);
        f = new g("CHANGED", 5);
        g[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static g valueOf(String r2) {
        return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
    }

    public static g[] values() {
        return (g[]) ZeusTransformUtils.preCheckCast(g.clone(), g[].class, "com.obric.aiagent.plugin");
    }
}
