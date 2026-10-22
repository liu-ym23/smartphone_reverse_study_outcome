package com.fasterxml.jackson.databind.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoercionAction.java */
/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12187c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12188d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b[] f12189e = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f12189e.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("Fail", 0);
        f12185a = r0;
        b r1 = new b("TryConvert", 1);
        f12186b = r1;
        b r3 = new b("AsNull", 2);
        f12187c = r3;
        b r5 = new b("AsEmpty", 3);
        f12188d = r5;
        f12189e = new b[]{r0, r1, r3, r5};
    }
}
