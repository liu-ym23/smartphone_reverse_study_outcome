package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.roomplayer.PlayerClientType;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f156011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f156012b = null;

    static {
        int[] r100 = new int[PlayerClientType.values().length];
        f156011a = r100;
        r100[PlayerClientType.FIRST_SHOW.ordinal()] = 1;
        int[] r101 = new int[IRenderView.RenderViewType.values().length];
        f156012b = r101;
        r101[IRenderView.RenderViewType.KEEP_TEXTURE_RENDER_VIEW.ordinal()] = 1;
        r101[IRenderView.RenderViewType.SURFACE_VIEW.ordinal()] = 2;
    }
}
