package com.bytedance.android.livesdkapi.depend.message.crossroom;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toString", "", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class CrossRoomLinkmicUIInfoKt {
    public static final String toString(CrossRoomLinkmicUIInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toString");
        StringBuilder r101 = new StringBuilder("[");
        Map<String, UserInfo> r102 = CrossRoomLinkmicUIInfoMainKt.getUserInfoString(r100);
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, UserInfo>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, UserInfo> r104 = r103.next();
        r101.append("<uid: " + r104.getKey() + ", position: " + r104.getValue().getClientPosition() + ">,");
    L8:
        r101.append("]");
        return r101.toString();
    }
}
