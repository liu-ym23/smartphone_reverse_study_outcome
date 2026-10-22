package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.ss.android.videoshop.context.VideoContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public abstract class PaidLiveScopeDataProvider implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f159481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f159482b;

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final VideoContext d() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final ReplayPaidInfo getReplayPaidInfo() {
        return null;
    }

    public PaidLiveScopeDataProvider() {
        this.f159481a = PaidLiveScopeDataProvider$episode$1.INSTANCE;
        this.f159482b = PaidLiveScopeDataProvider$showResolutionChangeAnim$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final Function0<Unit> e() {
        return this.f159482b;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final Function0 getEpisode() {
        return this.f159481a;
    }
}
