package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes9.dex */
public interface c {
    m<? extends Long> getChannelId();

    m<? extends String> getLinkerId();

    n<? extends MultiChannelInfo> getMultiChannelInfo();

    m<? extends Integer> getWindowCount();
}
