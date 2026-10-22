package com.obric.memorydata.sdk.entity.search.userprofile;

import android.content.Context;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: UserProfileMemorySearch.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileMemorySearch {
    public static final UserProfileMemorySearch INSTANCE = null;

    static {
        INSTANCE = new UserProfileMemorySearch();
    }

    private UserProfileMemorySearch() {
    }

    public final UserProfileMemoryResult queryUserProfileMemory(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "profileKey");
        MemoryResponse<UserProfileMemoryResult> r4 = a.f33793a.a(r1, r3);
        UserProfileMemoryResult r5 = (UserProfileMemoryResult) ZeusTransformUtils.preCheckCast(r4.getData(), UserProfileMemoryResult.class, "com.obric.aiagent.plugin");
        if (r4.getCode() != 0) goto L7;
        if (r5 == null) goto L7;
        return r5;
    L7:
        return new UserProfileMemoryResult(r4.getCode(), r4.getMessage(), null);
    }
}
