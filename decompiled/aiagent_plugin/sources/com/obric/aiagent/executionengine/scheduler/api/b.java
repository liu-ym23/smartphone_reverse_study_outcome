package com.obric.aiagent.executionengine.scheduler.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IEventManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17954a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f17955b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f17956c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f17957d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b[] f17958e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f17954a, f17955b, f17956c, f17957d};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f17954a = new b("UNDEF", 0);
        f17955b = new b("TIME", 1);
        f17956c = new b("LOCATION", 2);
        f17957d = new b("TEMPERATURE", 3);
        b[] r0 = a();
        f17958e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f17958e.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
