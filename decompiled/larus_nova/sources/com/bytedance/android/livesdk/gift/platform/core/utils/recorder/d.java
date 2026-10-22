package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorNo f132068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f132069b;

    public final String toString() {
        return "[" + this.f132068a + "]:" + this.f132069b;
    }

    public d(ErrorNo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errCode");
        Intrinsics.checkNotNullParameter(r101, "errTitle");
        this.f132068a = r100;
        this.f132069b = r101;
    }
}
