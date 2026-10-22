package com.bytedance.android.livesdk.revenue.service.message;

import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.bytedance.android.livesdk.revenue.message.RevRoomDataSyncModelAdapter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public final class RevWrdsServiceImpl extends AsyncService implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vh6.d<RoomDataSyncModel> f157413f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ylc.e f157414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f157415e;

    public static final class a {
    }

    static {
        f157413f = new vh6.d(Reflection.getOrCreateKotlinClass(RoomDataSyncModel.class));
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService, com.bytedance.android.scope.o
    public final void onStop() {
        super.onStop();
        this.f157414d = null;
    }

    public RevWrdsServiceImpl(com.bytedance.android.live.revenue.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f157415e = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.g
    public final <T extends com.bytedance.android.livesdk.revenue.message.k> T ga(final Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        ylc.e r101 = this.f157414d;
        Intrinsics.checkNotNull(r101);
        RoomDataSyncModel r102 = dc2.b.a(r101, new RevWrdsServiceImpl$createRoomDataSyncModel$modelAdapter$1(this, r100));
        if (r102 == null) goto L10;
        T r103 = (T) ((RevRoomDataSyncModelAdapter) r102).getOriginal();
        if (r103 == null) goto L8;
        return r103;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.message.RevRoomDataSyncModelAdapter");
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r100) {
        if ((r100 instanceof RevWrdsServiceImpl$onStartAsync$1) == false) goto L7;
        RevWrdsServiceImpl$onStartAsync$1 r101 = (RevWrdsServiceImpl$onStartAsync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        RevWrdsServiceImpl r106 = (RevWrdsServiceImpl) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        r106.f157414d = n3.g((MiddlewareRoomContext) r103);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        vh6.a r107 = this.f157415e.a();
        vh6.d<RoomContext> r108 = vp2.a.f556608a;
        r101.L$0 = this;
        r101.label = 1;
        r103 = r107.a(r108, r101);
        if (r103 != r104) goto L17;
        return r104;
    L17:
        r106 = this;
    L7:
        r101 = new RevWrdsServiceImpl$onStartAsync$1(this, r100);
        goto L8
    }
}
