package com.obric.aiagent.assistant_card.provider_core.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16360b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ a[] f16361d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f16362e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16363c;

    private static final /* synthetic */ a[] a() {
        return new a[]{f16359a, f16360b};
    }

    private a(String r1, int r2, String r3) {
        super(r1, r2);
        this.f16363c = r3;
    }

    public final String getType() {
        return this.f16363c;
    }

    static {
        f16359a = new a("ACTION_ON_CLICK", 0, "on_click");
        f16360b = new a("ACTION_ON_LONG_CLICK", 1, "on_long_click");
        a[] r0 = a();
        f16361d = r0;
        f16362e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f16361d.clone(), a[].class, "com.obric.aiagent.plugin");
    }
}
