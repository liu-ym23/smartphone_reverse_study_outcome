package com.bytedance.android.shopping.new_cart.router;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f179170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f179171b;

    public a(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter("first_enter", "queryScene");
        this.f179170a = r100;
        this.f179171b = r101;
    }
}
