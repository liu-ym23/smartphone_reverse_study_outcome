package com.bytedance.android.livesdkapi.depend.message.crossroom;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"#\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"userInfoString", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/UserInfo;", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "getUserInfoString", "(Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;)Ljava/util/Map;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class CrossRoomLinkmicUIInfoMainKt {
    public static final Map<String, UserInfo> getUserInfoString(CrossRoomLinkmicUIInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userInfoString");
        Map<Long, UserInfo> r101 = r100.getUserInfos();
        if (r101 == null) goto L5;
        MapsKt.toMutableMap(r101);
    L5:
        Map<String, UserInfo> r102 = r100.getOpenUserInfos();
        if (r102 != null) goto L10;
        return null;
    L10:
        return MapsKt.toMutableMap(r102);
    }
}
