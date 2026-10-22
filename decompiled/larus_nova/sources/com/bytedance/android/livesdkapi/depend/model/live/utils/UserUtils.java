package com.bytedance.android.livesdkapi.depend.model.live.utils;

import com.bytedance.android.live.base.model.user.o0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/utils/UserUtils;", "", "()V", "getUserIdStr", "", "userId", "openID", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserUtils {
    public static final UserUtils INSTANCE = null;

    private UserUtils() {
    }

    static {
        INSTANCE = new UserUtils();
    }

    public final String getUserIdStr(String r100, String r101) {
        o0.f58946a.getClass();
        if (r101 != null) goto L6;
        return "0";
    L6:
        return r101;
    }
}
