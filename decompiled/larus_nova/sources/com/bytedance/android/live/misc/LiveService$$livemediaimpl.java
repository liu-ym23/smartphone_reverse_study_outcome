package com.bytedance.android.live.misc;

import com.bytedance.android.live.media.api.IMediaService;
import com.bytedance.android.live.media.impl.MediaService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$livemediaimpl {
    public LiveService$$livemediaimpl() {
    }

    public static void registerService() {
        jc1.k.l(IMediaService.class, new MediaService());
    }
}
