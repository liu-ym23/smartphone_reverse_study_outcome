package com.bytedance.android.live.core.feed;

import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101) {
        LiveFeedType r102 = LiveFeedType.OUT_FLOW;
        String r103 = c.a(r100, r101, r102).getLiveFeedUrl();
        c.b(r100, r101, r102, r103, !StringsKt.contains$default(r103, "channel_id=999999", false, 2, null));
        return r103;
    }
}
