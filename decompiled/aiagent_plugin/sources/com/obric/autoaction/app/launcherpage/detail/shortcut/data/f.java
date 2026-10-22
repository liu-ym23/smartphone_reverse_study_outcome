package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f23534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f23535b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f23536e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23538d;

    private static final /* synthetic */ f[] b() {
        return new f[]{f23534a, f23535b};
    }

    private f(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.f23537c = r3;
        this.f23538d = r4;
    }

    public final int a() {
        return this.f23537c;
    }

    static {
        f23534a = new f("STANDARD", 0, 0, "标准");
        f23535b = new f("PRO", 1, 1, "Pro");
        f[] r0 = b();
        f23536e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f23536e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
