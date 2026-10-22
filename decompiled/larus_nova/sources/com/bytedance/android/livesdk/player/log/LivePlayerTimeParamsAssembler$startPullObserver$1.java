package com.bytedance.android.livesdk.player.log;

import android.os.SystemClock;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/log/LivePlayerTimeParamsAssembler$startPullObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerTimeParamsAssembler$startPullObserver$1 implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerTimeParamsAssembler f155609a;

    public LivePlayerTimeParamsAssembler$startPullObserver$1(LivePlayerTimeParamsAssembler r100) {
        this.f155609a = r100;
    }

    public final void a(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L9;
        LivePlayerTimeParamsAssembler r101 = this.f155609a;
        if (r101.f155580a > 0) goto L10;
        r101.f155580a = SystemClock.elapsedRealtime();
        r101.f155584e = 0;
        r101.f155585f = 0;
        r101.f155586g = 0;
        r101.f155581b++;
        r101.f155602w = null;
        return;
    L10:
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        a((Boolean) r100);
    }
}
