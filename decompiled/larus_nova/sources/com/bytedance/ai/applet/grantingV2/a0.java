package com.bytedance.ai.applet.grantingV2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class a0 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f34670a;

    public a0(String r100) {
        this.f34670a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        com.bytedance.ai.utils.g.f37637a.w("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus scope canceled for " + this.f34670a);
        return Unit.INSTANCE;
    }
}
