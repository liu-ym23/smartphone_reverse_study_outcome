package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f146199d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f146200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f146201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146202c;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "url:" + this.f146200a + ";savePath:" + this.f146202c;
    }

    public t(String r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f146200a = r100;
        this.f146201b = r101;
        this.f146202c = r102;
    }
}
