package com.obric.aiagent.assistant.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16304b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f16305c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f16306d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f16307e = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f16303a, f16304b, f16305c};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f16303a = new a("NoInstalled", 0);
        f16304b = new a("AppDisabled", 1);
        f16305c = new a("Enabled", 2);
        a[] r0 = a();
        f16306d = r0;
        f16307e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f16306d.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
