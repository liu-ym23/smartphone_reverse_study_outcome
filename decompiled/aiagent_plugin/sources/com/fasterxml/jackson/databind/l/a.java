package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AccessPattern.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12995b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12996c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f12997d = null;

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f12997d.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("ALWAYS_NULL", 0);
        f12994a = r0;
        a r1 = new a("CONSTANT", 1);
        f12995b = r1;
        a r3 = new a("DYNAMIC", 2);
        f12996c = r3;
        f12997d = new a[]{r0, r1, r3};
    }
}
