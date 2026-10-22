package com.bytedance.android.marketing.sdk.impl.utils;

import com.bytedance.common.utility.Logger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162819a = 0;

    static {
    }

    public static void a(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "messages");
        Logger.e("MarketingResourceLog", ArraysKt.joinToString$default(r110, tb2.c.DEFAULT_TEXT, null, null, 0, null, null, 62, null));
    }
}
