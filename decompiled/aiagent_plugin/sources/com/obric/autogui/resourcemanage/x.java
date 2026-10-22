package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ResourceDownloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum x extends Enum<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f30692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f30693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f30694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f30695d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f30696e = null;
    public static final x f = null;
    public static final x g = null;
    public static final x h = null;
    public static final x i = null;
    private static final /* synthetic */ x[] j = null;
    private static final /* synthetic */ d.d.a k = null;

    private static final /* synthetic */ x[] a() {
        return new x[]{f30692a, f30693b, f30694c, f30695d, f30696e, f, g, h, i};
    }

    private x(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f30692a = new x("SKIPPED_POLICY", 0);
        f30693b = new x("CHECK_FAILED", 1);
        f30694c = new x("NO_UPDATE", 2);
        f30695d = new x("DEFERRED_NETWORK", 3);
        f30696e = new x("DOWNLOAD_FAILED", 4);
        f = new x("INSTALL_FAILED", 5);
        g = new x("INSTALLED", 6);
        h = new x("UNINSTALLED", 7);
        i = new x("REVERTED", 8);
        x[] r0 = a();
        j = r0;
        k = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static x valueOf(String r2) {
        return (x) ZeusTransformUtils.preCheckCast(Enum.valueOf(x.class, r2), x.class, "com.obric.aiagent.plugin");
    }

    public static x[] values() {
        return (x[]) ZeusTransformUtils.preCheckCast(j.clone(), x[].class, "com.obric.aiagent.plugin");
    }
}
