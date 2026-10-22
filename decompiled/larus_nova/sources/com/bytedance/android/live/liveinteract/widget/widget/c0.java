package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.SystemClock;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IRoom f81044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoFriendPairDialog f81045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h0 f81046c;

    public c0(IRoom r100, VideoFriendPairDialog r101, h0 r102) {
        this.f81044a = r100;
        this.f81045b = r101;
        this.f81046c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        com.bytedance.android.livesdk.sharedpref.e<Long> r102 = b6.f65223a0;
        Long r103 = Long.valueOf(SystemClock.elapsedRealtime());
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.f81045b.M0();
        throw null;
    }
}
