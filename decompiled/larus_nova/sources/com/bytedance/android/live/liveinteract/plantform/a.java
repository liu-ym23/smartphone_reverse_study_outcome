package com.bytedance.android.live.liveinteract.plantform;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.interact.data.LinkmicAIGuestType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static final boolean a(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAIGuest");
        if (r100.getAiGuestType() <= LinkmicAIGuestType.None.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }
}
