package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f155930a = null;

    static {
        f155930a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Disposable r102 = c.f155931a;
        if (c.f155933c == true) goto L13;
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L7;
        String r104 = r103.getCurrentResolution();
    L9:
        if ((!Intrinsics.areEqual(r104, c.f155934d)) == false) goto L13;
        ILivePlayerClient r105 = LivePlatformPlayerManager.f();
        if (r105 == null) goto L17;
        r105.switchResolution(c.f155934d);
        return;
    L17:
        return;
    L7:
        r104 = null;
    L13:
        Disposable r106 = c.f155932b;
        if (r106 == null) goto L19;
        r106.dispose();
        return;
    }
}
