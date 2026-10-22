package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdkapi.interact.data.FlavorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"userIdString", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;", "getUserIdString", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerSysKickOutContent;)Ljava/lang/String;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class LinkerSysKickOutContentKt {
    public static final String getUserIdString(LinkerSysKickOutContent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userIdString");
        if (FlavorKt.isSaas() == false) goto L6;
        return r100.getOpenId();
    L6:
        return String.valueOf(r100.getUserId());
    }
}
