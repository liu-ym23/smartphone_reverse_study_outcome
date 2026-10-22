package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f25497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f25498b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f25499c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f25500d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25501e = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f25497a, f25498b, f25499c};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25497a = new j("Expanded", 0);
        f25498b = new j("Collapsed", 1);
        f25499c = new j("ForceExpand", 2);
        j[] r0 = a();
        f25500d = r0;
        f25501e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f25500d.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
