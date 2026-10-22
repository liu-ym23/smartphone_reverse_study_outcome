package com.bytedance.android.livesdk.player.log;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/log/LivePlayerTimeParamsAssembler$stopObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerTimeParamsAssembler$stopObserver$1 implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerTimeParamsAssembler f155610a;

    public LivePlayerTimeParamsAssembler$stopObserver$1(LivePlayerTimeParamsAssembler r100) {
        this.f155610a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        this.f155610a.b();
        return;
    }
}
