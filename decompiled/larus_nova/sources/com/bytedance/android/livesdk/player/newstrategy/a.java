package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f155929a;

    public a(Ref.ObjectRef r100) {
        this.f155929a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = c.f155931a;
        if (c.f155933c == false) goto L9;
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L7;
        r103.switchResolution((String) this.f155929a.element);
    L7:
        c.f155935e = true;
        return;
    }
}
