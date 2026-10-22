package com.obric.memorydata.sdk.awareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocationType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f33824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f33825b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ e[] f33826d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f33827e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33828c;

    private static final /* synthetic */ e[] b() {
        return new e[]{f33824a, f33825b};
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
        this.f33828c = r3;
    }

    public final String a() {
        return this.f33828c;
    }

    static {
        f33824a = new e("HOME", 0, "location_home_gps");
        f33825b = new e("COMPANY", 1, "location_company_gps");
        e[] r0 = b();
        f33826d = r0;
        f33827e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f33826d.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
