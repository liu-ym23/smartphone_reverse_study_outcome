package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashPermissionInfoResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashPermissionInfoResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CoreRequests$queryFlashPermissionInfo$1 extends FunctionReferenceImpl implements Function1<ECFlashPermissionInfoResponse, Unit> {
    public CoreRequests$queryFlashPermissionInfo$1(v0 r100) {
        super(1, r100, v0.class, "onSuccess", "onSuccess(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ECFlashPermissionInfoResponse r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ECFlashPermissionInfoResponse r100) {
        ((v0) this.receiver).onSuccess(r100);
    }
}
