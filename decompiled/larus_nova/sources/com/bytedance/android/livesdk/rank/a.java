package com.bytedance.android.livesdk.rank;

import com.bytedance.android.live.base.abtest.ClientABTestKey;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClientABTestKey<Integer> f156943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ClientABTestKey<String> f156944b = null;

    static {
        f156943a = new ClientABTestKey("live_audience_list_opt_type", Integer.TYPE, 0, 1);
        f156944b = new ClientABTestKey("live_audience_list_avatar_format", String.class, "normal", 0);
    }
}
