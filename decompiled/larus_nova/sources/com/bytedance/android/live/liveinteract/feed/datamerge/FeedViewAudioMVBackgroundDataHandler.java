package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class FeedViewAudioMVBackgroundDataHandler extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InteractiveSongMvManager f72930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<IOrderSingMVInfo, Unit> f72931c;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        InteractiveSongMvManager r100 = this.f72930b;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.f72930b = null;
    }

    public FeedViewAudioMVBackgroundDataHandler() {
        this.f72931c = new FeedViewAudioMVBackgroundDataHandler$setMvInfoCallBack$1(this);
    }
}
