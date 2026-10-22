package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f25904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f25905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f25906c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f25907d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25908e = null;

    private static final /* synthetic */ j[] a() {
        return new j[]{f25904a, f25905b, f25906c};
    }

    private j(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25904a = new j("Expanded", 0);
        f25905b = new j("Collapsed", 1);
        f25906c = new j("ForceExpand", 2);
        j[] r0 = a();
        f25907d = r0;
        f25908e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f25907d.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
