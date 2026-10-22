package com.bytedance.android.livesdk.player.log;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/log/LivePlayerTimeParamsAssembler$bindRenderViewObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerTimeParamsAssembler$bindRenderViewObserver$1 implements Observer<IRenderView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerTimeParamsAssembler f155604a;

    public LivePlayerTimeParamsAssembler$bindRenderViewObserver$1(LivePlayerTimeParamsAssembler r100) {
        this.f155604a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((IRenderView) r100) == null) goto L7;
        LivePlayerTimeParamsAssembler r101 = this.f155604a;
        r101.f155582c = SystemClock.elapsedRealtime();
        return;
    }
}
