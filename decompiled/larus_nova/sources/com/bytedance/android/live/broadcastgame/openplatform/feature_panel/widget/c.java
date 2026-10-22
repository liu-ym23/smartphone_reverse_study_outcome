package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.ja;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends GameHonorEffectWidget.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f61706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1 f61707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ja f61708f;

    public final void b() {
        ALogger.i("GameHonorEffectWidget", "session stop, id " + this.f61706d);
        this.f61707e.invoke(this);
    }

    public c(long r100, Function1 r101, ja r102, long r103, ja r104, GameHonorEffectWidget.a r105) {
        this.f61706d = r100;
        this.f61707e = r101;
        this.f61708f = r102;
        super(r103, r104, r105);
    }
}
