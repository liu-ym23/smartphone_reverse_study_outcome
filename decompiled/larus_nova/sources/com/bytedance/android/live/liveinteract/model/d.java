package com.bytedance.android.live.liveinteract.model;

import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicAudienceContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {
    public static final List<String> a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rankUidList");
        boolean r101 = r100 instanceof ListUserLinkmicAudienceContent;
        Object r102 = r100;
        if (r101 == true) goto L5;
        r102 = null;
    L5:
        ListUserLinkmicAudienceContent r103 = (ListUserLinkmicAudienceContent) r102;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.getRankUserIdStrList();
    }
}
