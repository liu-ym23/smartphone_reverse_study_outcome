package com.obric.autogui.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f26103b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f26104c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f26105d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f26106e = null;
    public static final b f = null;
    private static final /* synthetic */ b[] h = null;
    private static final /* synthetic */ d.d.a i = null;
    private final int g;

    private static final /* synthetic */ b[] b() {
        return new b[]{f26102a, f26103b, f26104c, f26105d, f26106e, f};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.g = r3;
    }

    public final int a() {
        return this.g;
    }

    static {
        f26102a = new b("UNKNOWN", 0, -1);
        f26103b = new b("UN_QUEUED", 1, 0);
        f26104c = new b("QUEUED", 2, 1);
        f26105d = new b("PROCESSING", 3, 2);
        f26106e = new b("COMPLETED", 4, 3);
        f = new b("FAILED", 5, 4);
        b[] r0 = b();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(h.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
