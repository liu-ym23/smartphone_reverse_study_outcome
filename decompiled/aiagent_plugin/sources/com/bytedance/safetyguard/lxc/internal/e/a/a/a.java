package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10298b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ a[] f10299c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f10300d = null;

    private static final /* synthetic */ a[] a() {
        return new a[]{f10297a, f10298b};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f10299c.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f10297a = new a("IMMEDIATE", 0);
        f10298b = new a("WAIT_INTERVAL", 1);
        a[] r0 = a();
        f10299c = r0;
        f10300d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
