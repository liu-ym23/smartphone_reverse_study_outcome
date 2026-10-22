package com.bytedance.android.livesdkapi.depend.model.live.linker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0006\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t*\n\u0010\n\"\u00020\u00022\u00020\u0002¨\u0006\u000b"}, d2 = {"fromUserId", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContentKt;", "getFromUserId", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;)Ljava/lang/String;", "kickOutSourceKt", "", "getKickOutSourceKt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerKickOutContent;)I", "ILinkerKickOutContentKt", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ILinkerKickOutContentKtKt {
    public static final String getFromUserId(ILinkerKickOutContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fromUserId");
        String r101 = ILinkerKickOutContentKt.getFromUserIdString(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static final int getKickOutSourceKt(ILinkerKickOutContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$kickOutSourceKt");
        return r100.getKickOutSource();
    }
}
