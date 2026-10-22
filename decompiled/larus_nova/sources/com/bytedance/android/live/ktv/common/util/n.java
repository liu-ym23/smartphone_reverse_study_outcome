package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class n {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceUrlHost");
        if (StringsKt.contains$default(r100, "sf1-ttcdn-tos.pstatp.com", false, 2, null) == true) goto L5;
        return r100;
    L5:
        return StringsKt.replace$default(r100, "sf1-ttcdn-tos.pstatp.com", LiveCommonConstants.INSTANCE.getObjectTosPath(), false, 4, null);
    }
}
