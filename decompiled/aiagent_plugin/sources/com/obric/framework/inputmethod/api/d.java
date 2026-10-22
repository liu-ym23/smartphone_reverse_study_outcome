package com.obric.framework.inputmethod.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricInjectTextResponseCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f33239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f33240b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f33241c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f33242d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d[] f33243e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ d[] a() {
        return new d[]{f33239a, f33240b, f33241c, f33242d};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f33239a = new d("NORMAL", 0);
        f33240b = new d("ABNORMAL", 1);
        f33241c = new d("SECURE", 2);
        f33242d = new d("UNKNOWN", 3);
        d[] r0 = a();
        f33243e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f33243e.clone(), d[].class, "com.obric.aiagent.plugin");
    }
}
