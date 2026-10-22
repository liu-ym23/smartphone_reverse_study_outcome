package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StreamReadCapability.java */
/* JADX INFO: loaded from: classes.dex */
public final enum r extends Enum<r> implements com.fasterxml.jackson.a.h.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f12158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f12159b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f12160c = null;
    private static final /* synthetic */ r[] f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f12161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12162e;

    public static r valueOf(String r2) {
        return (r) ZeusTransformUtils.preCheckCast(Enum.valueOf(r.class, r2), r.class, "com.obric.aiagent.plugin");
    }

    public static r[] values() {
        return (r[]) ZeusTransformUtils.preCheckCast(f.clone(), r[].class, "com.obric.aiagent.plugin");
    }

    static {
        r r0 = new r("DUPLICATE_PROPERTIES", 0, false);
        f12158a = r0;
        r r1 = new r("SCALARS_AS_OBJECTS", 1, false);
        f12159b = r1;
        r r3 = new r("UNTYPED_SCALARS", 2, false);
        f12160c = r3;
        f = new r[]{r0, r1, r3};
    }

    private r(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f12161d = r3;
        this.f12162e = 1 << ordinal();
    }

    @Override // com.fasterxml.jackson.a.h.h
    public boolean b() {
        return this.f12161d;
    }

    @Override // com.fasterxml.jackson.a.h.h
    public int c() {
        return this.f12162e;
    }
}
