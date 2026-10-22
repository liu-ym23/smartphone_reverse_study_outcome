package com.bytedance.applog.monitor.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExceptionScene.java */
/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f5740b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f5741c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f5742d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d[] f5743e = null;

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(f5743e.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        d r0 = new d("Common", 0);
        f5739a = r0;
        d r1 = new d("DataCollection", 1);
        f5740b = r1;
        d r3 = new d("DataPackaging", 2);
        f5741c = r3;
        d r5 = new d("DataUpload", 3);
        f5742d = r5;
        f5743e = new d[]{r0, r1, r3, r5};
    }
}
