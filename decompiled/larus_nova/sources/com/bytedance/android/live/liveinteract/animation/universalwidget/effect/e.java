package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import ca0.h;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f71359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f71360b;

    public e(long r100, Function1 r101) {
        this.f71359a = r100;
        this.f71360b = r101;
    }

    @Override // ca0.h
    public final void onResult(int r100) {
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "removeComposer.session:" + this.f71359a + ". onResult:" + r100);
        this.f71360b.invoke(Boolean.TRUE);
    }
}
