package com.bytedance.android.livesdkapi.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.platformplayer.layout.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&R\u0014\u0010\f\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IFeedRevenueContext;", "", "", "hasPkBar", "", "pkBarHeightInPx", "transForReserve", "topReserveHeightInPx", "", "requestPlayerRelayout", "getInnerMovePlayer", "()Z", "innerMovePlayer", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/platformplayer/layout/e;", "getPlayerEvent", "()Landroidx/lifecycle/LiveData;", "playerEvent", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFeedRevenueContext {
    boolean getInnerMovePlayer();

    LiveData<e> getPlayerEvent();

    void requestPlayerRelayout(boolean r100, int r101, boolean r102, int r103);
}
