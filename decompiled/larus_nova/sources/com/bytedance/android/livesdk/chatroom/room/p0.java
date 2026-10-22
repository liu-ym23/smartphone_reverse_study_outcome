package com.bytedance.android.livesdk.chatroom.room;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdkapi.player.LiveZygoteBaseEventHub;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes7.dex */
public final class p0 extends LiveZygoteBaseEventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<hl0.a> f111118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<EnterRoomInfoResult> f111119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<APMEvent> f111120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<jx1.a> f111121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NextLiveData<jx1.d> f111122e;

    public p0() {
        this.f111118a = new MutableLiveData();
        this.f111119b = new NextLiveData();
        this.f111120c = new MutableLiveData();
        this.f111121d = new NextLiveData();
        this.f111122e = new NextLiveData();
    }
}
