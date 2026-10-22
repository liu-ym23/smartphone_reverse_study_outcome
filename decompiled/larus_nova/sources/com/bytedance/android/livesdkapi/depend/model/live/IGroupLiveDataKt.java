package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002¨\u0006\u0006"}, d2 = {"getCurrentGroupLiveMode", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "getIsGroupLive", "isGroupLiveKmp", "", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IGroupLiveDataKt {
    public static final int getCurrentGroupLiveMode(IGroupLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getCurrentGroupLiveMode");
        return r100.getGroupLiveMode();
    }

    public static final int getIsGroupLive(IGroupLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getIsGroupLive");
        return r100.isGroupLive();
    }

    public static final boolean isGroupLiveKmp(IGroupLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGroupLiveKmp");
        if (r100.isGroupLive() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
