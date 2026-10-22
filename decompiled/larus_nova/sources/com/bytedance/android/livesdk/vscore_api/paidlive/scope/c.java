package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidScopeContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveBusiness;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public interface c {
    Function0<ILivePlayerClient> a();

    FragmentActivity b();

    Pair<PaidScopeContext, Disposable> c();

    VideoContext d();

    Function0<Unit> e();

    Function0<IPaidLiveBusiness> f();

    LifecycleOwner g();

    DataCenter getDataCenter();

    Function0<Episode> getEpisode();

    ReplayPaidInfo getReplayPaidInfo();

    com.bytedance.android.livesdk.vscore_api.paidlive.d getRoomContext();
}
