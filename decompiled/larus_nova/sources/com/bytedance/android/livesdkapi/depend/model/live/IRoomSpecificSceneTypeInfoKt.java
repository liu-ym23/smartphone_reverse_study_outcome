package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isLandscapeVertical", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IRoomSpecificSceneTypeInfoKt {
    public static final boolean isLandscapeVertical(IRoomSpecificSceneTypeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLandscapeVertical");
        if (r100.isLandscapeVerticalRoom() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
