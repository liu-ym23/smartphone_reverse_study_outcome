package com.bytedance.android.livesdk.player;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/player/LivePlayerAppLogger$stopObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerAppLogger$stopObserver$1 implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePlayerAppLogger f154892a;

    public LivePlayerAppLogger$stopObserver$1(LivePlayerAppLogger r100) {
        this.f154892a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == true) goto L10;
        LivePlayerAppLogger.a(this.f154892a);
        return;
    }
}
