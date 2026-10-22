package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x {
    public static final boolean a(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isValid");
        if (IRoomKtKt.getId(r100) > 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.getOwnerKt() == null) goto L7;
        return true;
    }
}
