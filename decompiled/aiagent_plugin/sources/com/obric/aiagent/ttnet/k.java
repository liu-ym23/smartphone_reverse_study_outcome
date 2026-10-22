package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ITTNetFileTransfer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f22276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f22277b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f22278c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f22279d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f22280e = null;
    public static final k f = null;
    public static final k g = null;
    public static final k h = null;
    private static final /* synthetic */ k[] i = null;
    private static final /* synthetic */ d.d.a j = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f22276a, f22277b, f22278c, f22279d, f22280e, f, g, h};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f22276a = new k("INVALID_REQUEST", 0);
        f22277b = new k("URL_POLICY_REJECTED", 1);
        f22278c = new k("TOO_MANY_REDIRECTS", 2);
        f22279d = new k("RESPONSE_TOO_LARGE", 3);
        f22280e = new k("HTTP_ERROR", 4);
        f = new k("NETWORK_ERROR", 5);
        g = new k("IO_ERROR", 6);
        h = new k("INTERNAL_ERROR", 7);
        k[] r0 = a();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(i.clone(), k[].class, "com.obric.aiagent.plugin");
    }
}
