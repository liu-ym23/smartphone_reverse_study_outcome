package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f133381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f133382d;

    public d() {
        int r100 = 0;
        this(r100, r100, 15);
    }

    public String toString() {
        return "HeightInfo(expectedHeight=" + this.f133379a + ", bottomMargin=" + this.f133380b + ')';
    }

    public /* synthetic */ d(int r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -10086;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = -10086;
    L9:
        if ((r102 & 8) == 0) goto L11;
        String r103 = "default";
    L12:
        this(r100, r101, 0, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public d(int r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "platformStrategyLevel");
        this.f133379a = r100;
        this.f133380b = r101;
        this.f133381c = r102;
        this.f133382d = r103;
    }
}
