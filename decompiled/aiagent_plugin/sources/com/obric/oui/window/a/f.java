package com.obric.oui.window.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowSizeClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f36863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f36864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f36865c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f36866d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f36867e = null;
    public static final f f = null;
    public static final f g = null;
    public static final f h = null;
    public static final f i = null;
    private static final /* synthetic */ f[] l = null;
    private final int j;
    private final c k;

    private static final /* synthetic */ f[] b() {
        return new f[]{f36863a, f36864b, f36865c, f36866d, f36867e, f, g, h, i};
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(l.clone(), f[].class, "com.obric.aiagent.plugin");
    }

    private f(String r1, int r2, int r3, c r4) {
        super(r1, r2);
        this.j = r3;
        this.k = r4;
    }

    public final c a() {
        return this.k;
    }

    static {
        f36863a = new f("MINUS_ERROR_SIZE", 0, -1, new c("MINUS_ERROR_SIZE", new b(1), new d(0), new e(0)));
        f36864b = new f("FLOATING_WINDOW", 1, 0, new c("FLOATING_WINDOW", new b(12), new d(11), new e(12)));
        f36865c = new f("SMALL_SPLIT_SCREEN", 2, 375, new c("SMALL_SPLIT_SCREEN", new b(12), new d(12), new e(12)));
        f36866d = new f("SMALLER_ANDROID_SCREEN", 3, 516, new c("SMALLER_ANDROID_SCREEN", new b(12), new d(12), new e(16)));
        f36867e = new f("SMALL", 4, 640, new c("SMALL", new b(12), new d(12), new e(16)));
        f = new f("STANDARD", 5, 768, new c("STANDARD", new b(12), new d(12), new e(24)));
        g = new f("NORMAL", 6, 834, new c("NORMAL", new b(12), new d(12), new e(24)));
        h = new f("LARGE", 7, 1024, new c("LARGE", new b(20), new d(16), new e(32)));
        i = new f("OVERSIZE", 8, 1366, new c("OVERSIZE", new b(24), new d(16), new e(32)));
        l = b();
    }
}
