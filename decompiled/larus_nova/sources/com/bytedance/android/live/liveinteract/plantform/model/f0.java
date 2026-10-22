package com.bytedance.android.live.liveinteract.plantform.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f0 {
    public static final String a(IMessageBoardInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getMsgBoardContent");
        String r101 = r100.getContent();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
