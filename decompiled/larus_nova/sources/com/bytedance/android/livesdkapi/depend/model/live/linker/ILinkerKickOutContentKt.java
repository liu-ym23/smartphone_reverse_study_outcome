package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.base.model.user.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getFromUserIdString", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ILinkerKickOutContentKt {
    public static final String getFromUserIdString(ILinkerKickOutContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFromUserIdString");
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(r100.getFromUserId());
        String r103 = r100.getFromUserOpenId();
        r101.getClass();
        return o0.a.g(r102, r103);
    }
}
