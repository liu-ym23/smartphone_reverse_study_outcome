package com.bytedance.android.livehostapi.foundation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/VideoContext;", "Lcom/bytedance/android/livehostapi/foundation/IVideoContext;", "()V", "getAuthToastTimeWithId", "", "openId", "", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public class VideoContext implements IVideoContext {
    public VideoContext() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IVideoContext
    public long getAuthToastTimeWithId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        return -1;
    }
}
