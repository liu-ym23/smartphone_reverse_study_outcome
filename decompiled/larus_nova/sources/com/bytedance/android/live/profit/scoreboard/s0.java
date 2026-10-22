package com.bytedance.android.live.profit.scoreboard;

import com.lynx.tasm.LynxError;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s0 implements CompletableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f88966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dv0.f f88967b;

    public static final class a implements com.bytedance.android.livesdk.revenue.service.broadcast.a.InterfaceC2406a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableEmitter f88968a;

        @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a.InterfaceC2406a
        public final void onSuccess() {
            jy0.b.d("ScoreboardInvitationHandler", "loadGame succeeded");
            this.f88968a.onComplete();
        }

        public a(CompletableEmitter r100) {
            this.f88968a = r100;
        }

        @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a.InterfaceC2406a
        public final void onFailure(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            jy0.b.c("ScoreboardInvitationHandler", "loadGame failed: " + r100, null, 4);
            this.f88968a.tryOnError(r100);
        }
    }

    public s0(r0 r100, dv0.f r101) {
        this.f88966a = r100;
        this.f88967b = r101;
    }

    @Override // io.reactivex.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r0 r101 = this.f88966a;
        r101.f88958d.v4(r101.f88956b.getContext(), this.f88967b.getMiniAppId(), new a(r100));
    }
}
