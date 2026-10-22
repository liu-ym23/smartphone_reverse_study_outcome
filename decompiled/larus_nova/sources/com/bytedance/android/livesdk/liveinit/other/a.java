package com.bytedance.android.livesdk.liveinit.other;

import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.log.ILoggerLifeManagerService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import jc1.k;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends AbsLiveInitUnit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f153255a = null;

    static {
        f153255a = new a();
    }

    @Override // com.bytedance.android.livesdk.init.AbsLiveInitUnit
    public final void initialize() {
        ILoggerLifeManagerService r100 = (ILoggerLifeManagerService) k.f(ILoggerLifeManagerService.class);
        if (r100 == null) goto L6;
        r100.initConfig();
        return;
    }

    @Override // com.bytedance.android.livesdk.init.AbsLiveInitUnit
    public final InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getEnsureLazy());
    }

    @Override // com.bytedance.android.livesdk.init.AbsLiveInitUnit
    public final long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getEnsureLazyTime();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.init.AbsLiveInitUnit
    public final LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveEnsureLazyUnit;
    }

    @Override // com.bytedance.android.livesdk.init.AbsLiveInitUnit
    public final LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }
}
