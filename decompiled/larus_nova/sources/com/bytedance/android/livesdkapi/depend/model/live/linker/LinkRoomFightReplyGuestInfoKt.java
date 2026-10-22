package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.base.model.user.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"userIdString", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "getUserIdString", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;)Ljava/lang/String;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class LinkRoomFightReplyGuestInfoKt {
    public static final String getUserIdString(LinkRoomFightReplyGuestInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userIdString");
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(r100.getUserId());
        String r103 = r100.getOpenId();
        r101.getClass();
        return o0.a.g(r102, r103);
    }
}
