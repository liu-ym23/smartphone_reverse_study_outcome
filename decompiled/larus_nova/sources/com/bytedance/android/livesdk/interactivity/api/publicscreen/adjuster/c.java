package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f133378e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d
    public final String toString() {
        return "ExtendsHeightInfo(roomChannelHeight=" + this.f133378e + ", expectedHeight=" + this.f133379a + ", bottomMargin=" + this.f133380b + ')';
    }

    public c(int r100, int r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "platformStrategyLevel");
        super(r101, r102, r103, r104);
        this.f133378e = r100;
    }

    public /* synthetic */ c(int r100, int r101, int r102, int r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        int r103 = -10086;
    L7:
        if ((r112 & 8) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r112 & 16) == 0) goto L13;
        r111 = "default";
    L13:
        this(r100, r101, r103, r104, r111);
        return;
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }
}
