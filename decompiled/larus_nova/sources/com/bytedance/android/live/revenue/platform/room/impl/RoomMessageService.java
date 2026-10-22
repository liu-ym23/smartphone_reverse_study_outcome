package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.tencent.open.SocialConstants;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RoomMessageService extends AsyncService implements yz0.l, yz0.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseRoomMessageService f91587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.message.d f91588e;

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService, com.bytedance.android.scope.o
    public final void onStop() {
        super.onStop();
        BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.b>> r100 = this.f91587d.f91574a;
        sh6.a r101 = sh6.a.f541970a;
        r100.onNext(r101);
        this.f91587d.f91574a.onComplete();
        this.f91587d.f91575b.onNext(r101);
        this.f91587d.f91575b.onComplete();
        this.f91587d.f91576c.onNext(r101);
        this.f91587d.f91576c.onComplete();
        this.f91587d.f91577d.onNext(r101);
        this.f91587d.f91577d.onComplete();
        this.f91587d.f91579f.clear();
        this.f91587d.f91580g.clear();
        this.f91587d.f91581h.clear();
    }

    public RoomMessageService(com.bytedance.android.livesdk.revenue.service.message.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManagerService");
        this.f91588e = r100;
        this.f91587d = new BaseRoomMessageService();
    }

    @Override // yz0.l
    public final void J0(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f91587d.J0(r100);
    }

    @Override // yz0.i
    public final void Lk(Function1<? super com.bytedance.android.livesdk.revenue.message.a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91587d.Lk(r100);
    }

    @Override // yz0.l
    public final void f0(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f91587d.f0(r100);
    }

    @Override // yz0.l
    public final void h(vlc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f91587d.h(r100);
    }

    @Override // yz0.l
    public final Observable nh(yh6.f r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        return this.f91587d.nh(r100);
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r100) {
        if ((r100 instanceof RoomMessageService$onStartAsync$1) == false) goto L7;
        RoomMessageService$onStartAsync$1 r101 = (RoomMessageService$onStartAsync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        RoomMessageService r106 = (RoomMessageService) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        com.bytedance.android.livesdk.revenue.message.i r107 = r106.f91588e.getMessageManager();
        r106.f91587d.f91574a.onNext(sh6.c.a(r107));
        r106.f91587d.f91575b.onNext(sh6.c.a(r106.f91588e.xj()));
        r106.f91587d.f91576c.onNext(sh6.c.a(r106.f91588e.c2()));
        r106.f91587d.f91577d.onNext(sh6.c.a(r106.f91588e.Ih()));
        r106.f91587d.f91578e.onNext(sh6.c.a(r106.f91588e.Kk()));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        com.bytedance.android.livesdk.revenue.service.message.d r108 = this.f91588e;
        r101.L$0 = this;
        r101.label = 1;
        if (r108.g(r101) != r104) goto L17;
        return r104;
    L17:
        r106 = this;
    L7:
        r101 = new RoomMessageService$onStartAsync$1(this, r100);
        goto L8
    }

    @Override // yz0.i
    public final void pe(Function1<? super com.bytedance.android.livesdk.revenue.message.d, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91587d.pe(r100);
    }

    @Override // yz0.i
    public final void ra(Function1<? super com.bytedance.android.livesdk.revenue.message.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f91587d.ra(r100);
    }

    @Override // yz0.l
    public final Observable Dm(yh6.f r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        return this.f91587d.Dm(r100, r101);
    }

    @Override // yz0.l, yz0.f
    public void insert(yh6.c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f91587d.insert(r100, r101);
    }

    @Override // yz0.h
    public final <T extends yh6.c> Observable<T> S4(yh6.b<T> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        return this.f91587d.S4(r100, r101, r102);
    }
}
