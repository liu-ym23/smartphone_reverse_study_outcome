package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f42757a = null;

    static {
        int[] r100 = new int[IECPlayerViewService.RenderViewType.values().length];
        f42757a = r100;
        r100[IECPlayerViewService.RenderViewType.TEXTURE_VIEW.ordinal()] = 1;
        r100[IECPlayerViewService.RenderViewType.SURFACE_VIEW.ordinal()] = 2;
        r100[IECPlayerViewService.RenderViewType.KEEP_TEXTURE_RENDER_VIEW.ordinal()] = 3;
    }
}
