package com.obric.autogui.common.b;

/* JADX INFO: compiled from: AutoOperateTaskCatalogueNumber.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29000a = null;

    static {
        f29000a = new a();
    }

    public final int a(int r1) {
        return r1 & 255;
    }

    public final int a(int r1, int r2, boolean r3) {
        int r0 = 1 << (r2 + 16);
        if (r3 == false) goto L6;
        return r0 | r1;
    L6:
        return (~r0) & r1;
    }

    public final boolean a(int r1, int r2) {
        if (((r1 >> (r2 + 16)) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int b(int r1) {
        return r1 & 240;
    }

    private a() {
    }
}
