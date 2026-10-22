package com.bytedance.android.livesdk.player.monitor;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/monitor/LivePlayerTraceMonitor$stopObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerTraceMonitor$stopObserver$1 implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerTraceMonitor f155713a;

    public LivePlayerTraceMonitor$stopObserver$1(LivePlayerTraceMonitor r100) {
        this.f155713a = r100;
    }

    public final void a(Boolean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, Boolean.FALSE) == true) goto L18;
        LivePlayerTraceMonitor r101 = this.f155713a;
        if (r101.f155704b == false) goto L10;
        return;
    L10:
        if (r101.f155705c != 0) goto L13;
        return;
    L13:
        if (r101.f155703a.getEnableStartOrEndEventReport() == false) goto L15;
        this.f155713a.reportTrace("ttlive_live_player_play_end", null, null);
        this.f155713a.f155704b = true;
    L15:
        this.f155713a.f155705c = 0;
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        a((Boolean) r100);
    }
}
