package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f141657a = null;

    public c() {
    }

    static {
        f141657a = new c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.layout.f
    public final int a(int r100, int r101) {
        if (r101 < 5) goto L6;
        r100 = Math.abs(r100 - 2);
    L9:
        return r101 - r100;
    L6:
        if (r101 < 3) goto L9;
        r100 = Math.abs(r100 - 1);
        goto L9
    }
}
