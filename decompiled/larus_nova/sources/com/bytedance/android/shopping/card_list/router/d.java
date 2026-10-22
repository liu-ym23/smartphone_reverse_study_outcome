package com.bytedance.android.shopping.card_list.router;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f171743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e f171744b;

    public d(String r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter("first_enter", "queryScene");
        this.f171743a = r100;
        this.f171744b = r101;
    }
}
