package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import android.graphics.Matrix;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f79085a = 0;

    static {
        Matrix r100 = new Matrix();
        r100.preTranslate(0.5f, 0.5f);
        r100.preScale(1.0f, -1.0f);
        r100.preTranslate(-0.5f, -0.5f);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r101 = ILiveWrappedLivePusher.a.b();
        if (r101 == null) goto L6;
        r101.getRendererCommon();
        return;
    }
}
