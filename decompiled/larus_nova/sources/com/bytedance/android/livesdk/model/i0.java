package com.bytedance.android.livesdk.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f153940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f153941b;

    public i0() {
        this(0);
    }

    public /* synthetic */ i0(int r100) {
        this("", false);
    }

    public i0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "panelUrl");
        this.f153940a = r100;
        this.f153941b = r101;
    }
}
