package com.bytedance.android.livesdk.chatroom.replay.player;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements jm1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f109566c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f109567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f109568b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f109568b = "REPLAY";
        this.f109567a = LazyKt.lazy(LiveReplayCrashObserver$replayCrashRecorderService$2.INSTANCE);
    }

    @Override // jm1.b
    public final void m00(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        ALogger.i("LiveReplayCrashObserver", hashCode() + ":vs enter");
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a r101 = (com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a) this.f109567a.getValue();
        if (r101 == null) goto L5;
        r101.a(hashCode());
    L5:
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a r102 = (com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a) this.f109567a.getValue();
        if (r102 == null) goto L13;
        Map<String, String> r103 = r102.d(r100);
        if (r103 == null) goto L14;
        r103.put("live_room_source", this.f109568b);
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a r104 = (com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a) this.f109567a.getValue();
        if (r104 == null) goto L15;
        r104.c(r103);
        Unit r105 = Unit.INSTANCE;
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // jm1.b
    public final void fX(long r100, String r101, boolean r102, Episode r103, ls2.e r104) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r104, "endError");
        ALogger.i("LiveReplayCrashObserver", hashCode() + ":vs exit");
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a r105 = (com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a) this.f109567a.getValue();
        if (r105 == null) goto L6;
        r105.f(hashCode());
        return;
    }
}
