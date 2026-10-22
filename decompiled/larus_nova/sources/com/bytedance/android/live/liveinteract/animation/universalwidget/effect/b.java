package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import ca0.h;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f71355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f71356b;

    public b(long r100, Function1 r101) {
        this.f71355a = r100;
        this.f71356b = r101;
    }

    @Override // ca0.h
    public final void onResult(int r100) {
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "appendComposer.session:" + this.f71355a + ". onResult:" + r100);
        this.f71356b.invoke(Boolean.TRUE);
    }
}
