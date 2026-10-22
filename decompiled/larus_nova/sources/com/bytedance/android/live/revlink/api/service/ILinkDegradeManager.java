package com.bytedance.android.live.revlink.api.service;

import com.bytedance.android.live.revlink.impl.perf.LinkRtcDegradeTask;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public interface ILinkDegradeManager {

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/api/service/ILinkDegradeManager$DegradeFlag;", "", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public @interface DegradeFlag {
    }

    void c(LinkRtcDegradeTask r100);

    void d();
}
