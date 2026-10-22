package com.bytedance.android.live.revlink.impl.intercomment;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.android.livesdk.log.filter.m {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.m
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        InteractCommentDataContext r101 = InteractCommentDataContext.Companion.getContext();
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.j<b> r102 = r101.getService();
        if (r102 == null) goto L7;
        b r103 = r102.getValue();
    L8:
        if (r103 == null) goto L12;
        int r104 = 1;
        if (r103.a0() != true) goto L12;
    L13:
        r100.put("is_comment_interflow", String.valueOf(r104));
        return;
    L12:
        r104 = 0;
    L7:
        r103 = null;
        goto L8
    }
}
