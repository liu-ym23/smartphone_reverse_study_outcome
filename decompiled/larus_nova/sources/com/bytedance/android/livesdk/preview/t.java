package com.bytedance.android.livesdk.preview;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewCoverView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewFragment;
import com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView;
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsParams;

/* JADX INFO: loaded from: classes11.dex */
public interface t extends IService {
    public static final a Z0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f156602a = null;

        public a() {
        }

        static {
            f156602a = new a();
        }

        public static UnsupportedOperationException a() {
            t r100 = (t) jc1.k.f(t.class);
            StringBuilder r101 = new StringBuilder("暂未支持, enablePreview:true, service is null:");
            if (r100 != null) goto L5;
            boolean r102 = true;
        L6:
            r101.append(r102);
            return new UnsupportedOperationException(r101.toString());
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
        Z0 = a.f156602a;
    }

    ILivePreviewFragment getLivePreviewFragment(LiveMetricsParams r100);

    ILivePreviewCoverView makePreviewCoverView(Context r100);

    ILivePreviewCoverView makePreviewCoverView(Context r100, LiveMetricsParams r101);

    ILivePreviewCoverView makePreviewCoverView(Context r100, LiveMetricsParams r101, Bundle r102);

    ry.k makePreviewCoverView(Context r100, Bundle r101);

    ILivePurePreviewView makePurePreviewView(Context r100, LiveMetricsParams r101);
}
