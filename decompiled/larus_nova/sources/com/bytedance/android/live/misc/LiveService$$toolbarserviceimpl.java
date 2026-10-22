package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.toolbarservice.ToolbarServiceImpl;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$toolbarserviceimpl {
    public LiveService$$toolbarserviceimpl() {
    }

    public static void registerP1Service() {
        jc1.k.l(IToolbarService.class, new ToolbarServiceImpl());
    }

    public static void registerService() {
        jc1.k.l(IToolbarService.class, new ToolbarServiceImpl());
    }
}
