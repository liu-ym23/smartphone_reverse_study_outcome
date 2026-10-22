package com.bytedance.android.live.misc;

import com.bytedance.android.live.multilink.external.api.IMultiLinkService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$multilinkintegration {
    private static final zm0.b serviceInitializer = null;

    public LiveService$$multilinkintegration() {
    }

    static {
        serviceInitializer = new zm0.b();
    }

    public static void registerP0Service() {
        jc1.k.l(IMultiLinkService.class, new zm0.a());
        serviceInitializer.a();
    }

    public static void registerP1Service() {
        serviceInitializer.b();
    }

    public static void registerP2Service() {
        serviceInitializer.c();
    }

    public static void registerService() {
        jc1.k.l(IMultiLinkService.class, new zm0.a());
        serviceInitializer.a();
    }
}
