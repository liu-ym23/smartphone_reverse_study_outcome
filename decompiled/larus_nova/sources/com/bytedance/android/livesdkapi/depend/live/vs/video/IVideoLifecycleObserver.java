package com.bytedance.android.livesdkapi.depend.live.vs.video;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.depend.model.live.EnterExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import kotlin.Metadata;
import ls2.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J2\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/video/IVideoLifecycleObserver;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/EnterExtra;", "enterExtra", "", "onEnter", "", "itemId", "userId", "", "fromNotification", "Lls2/e;", "endError", d.f25928r, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoLifecycleObserver {
    void onEnter(Episode r100, EnterExtra r101);

    void onExit(long r100, long r101, boolean r102, Episode r103, e r104);
}
