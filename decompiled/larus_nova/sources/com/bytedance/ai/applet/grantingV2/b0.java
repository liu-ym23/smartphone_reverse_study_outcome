package com.bytedance.ai.applet.grantingV2;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
public final class b0 implements Function2<Boolean, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f34673a;

    public b0(kotlinx.coroutines.j r100) {
        this.f34673a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Boolean r100, String r101) {
        boolean r102 = r100.booleanValue();
        String r103 = r101;
        if (this.f34673a.isActive() == false) goto L9;
        if (r103 != null) goto L7;
        com.bytedance.ai.utils.g.f37637a.i("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus callback: " + r102);
        this.f34673a.resumeWith(Result.m9449constructorimpl(Boolean.valueOf(r102)));
        goto L9
    L7:
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus callback error: ".concat(r103));
        kotlinx.coroutines.i<Boolean> r104 = this.f34673a;
        Result.Companion r105 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
    L9:
        return Unit.INSTANCE;
    }
}
