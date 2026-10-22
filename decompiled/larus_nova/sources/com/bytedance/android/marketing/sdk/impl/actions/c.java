package com.bytedance.android.marketing.sdk.impl.actions;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends com.bytedance.android.marketing.sdk.impl.actions.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final String a() {
        return "ecom.marketing.fetch";
    }

    public c() {
    }

    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final void c(Map<String, ? extends Object> r100, Context r101, p r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        super.c(r100, r101, r102);
        if (r100 == null) goto L6;
        r102.onFailed("暂无实现");
        return;
    }
}
