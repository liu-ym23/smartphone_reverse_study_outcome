package com.bytedance.android.livesdk.revenue.network;

import com.bytedance.android.live.base.model.Extra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {
    public a() {
    }

    public e A(String r100, d r101, int r102, e r103, Extra r104) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r103, "error");
        Intrinsics.checkNotNullParameter(r104, "extra");
        return r103;
    }

    public void E(String r100, d r101, com.bytedance.android.live.network.response.d.b r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "response");
    }

    public String g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originPath");
        return r100;
    }

    public Boolean h() {
        return null;
    }

    public d x(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originalRequest");
        return r101;
    }
}
