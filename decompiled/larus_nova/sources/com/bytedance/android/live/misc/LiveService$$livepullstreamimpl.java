package com.bytedance.android.live.misc;

import com.bytedance.android.live.livepullstream.PullStreamService;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$livepullstreamimpl {
    public LiveService$$livepullstreamimpl() {
    }

    public static void registerService() {
        jc1.k.l(IPullStreamService.class, new PullStreamService());
        jc1.k.l(gl0.a.class, new PullStreamService());
    }
}
