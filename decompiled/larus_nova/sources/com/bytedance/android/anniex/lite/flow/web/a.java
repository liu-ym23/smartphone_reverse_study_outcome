package com.bytedance.android.anniex.lite.flow.web;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.android.anniex.lite.flow.base.a r101 = com.bytedance.android.anniex.lite.flow.base.a.f40919a;
        if (r101.a(r100) != null) goto L5;
    L7:
        return null;
    L5:
        if ((r101.a(r100) instanceof b) == false) goto L7;
        Object r102 = r101.a(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider");
        return (b) r102;
    }
}
