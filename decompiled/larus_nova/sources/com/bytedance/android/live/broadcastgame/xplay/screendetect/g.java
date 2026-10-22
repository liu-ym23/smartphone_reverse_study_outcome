package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayAudienceScreenDetector f62385a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 2) goto L16;
        this.f62385a.b("receive msg, start detect");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        XplayAudienceScreenDetector.h(this.f62385a, this);     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        final Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        XplayAudienceScreenDetector r104 = this.f62385a;
        r104.getClass();
        a.d(r104, "ttlive_xplay_audience_screen_detect", a.a(r104, new XplayAudienceScreenDetector$reportDetectFailed$1(r103)));
    L12:
        sendEmptyMessageDelayed(2, this.f62385a.i().a());
        return;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public g(XplayAudienceScreenDetector r100, Looper r101) {
        this.f62385a = r100;
        super(r101);
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.getCallback() == null) goto L7;
        r100.getCallback().run();
        return true;
    L7:
        return super.sendMessageAtTime(r100, r101);
    }
}
