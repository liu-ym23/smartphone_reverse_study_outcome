package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import kotlin.jvm.internal.Intrinsics;
import xr2.i;

/* JADX INFO: loaded from: classes11.dex */
public final class g {
    public static final i a(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toRevType");
        return new i(r100.getTypeId(), r100.getView(), r100.getBlockingEntryMs(), r100.getIconDesc());
    }
}
