package com.obric.aiagent.skill.ovirt.impl.reporting;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;

/* JADX INFO: compiled from: OVirtReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21455b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f21456c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f21457d = null;
    private static final /* synthetic */ a[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f21458e;

    private static final /* synthetic */ a[] b() {
        return new a[]{f21454a, f21455b, f21456c, f21457d};
    }

    private a(String r1, int r2, String r3) {
        super(r1, r2);
        this.f21458e = r3;
    }

    public final String a() {
        return this.f21458e;
    }

    static {
        f21454a = new a("MANAGER_SPI_UNAVAILABLE", 0, "manager_spi_unavailable");
        f21455b = new a("MANAGER_UNAVAILABLE", 1, "manager_unavailable");
        f21456c = new a("MANAGER_PROJECTION_FAILED", 2, "manager_projection_failed");
        f21457d = new a("PROJECTION_EXCEPTION", 3, "projection_exception");
        a[] r0 = b();
        f = r0;
        g = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
