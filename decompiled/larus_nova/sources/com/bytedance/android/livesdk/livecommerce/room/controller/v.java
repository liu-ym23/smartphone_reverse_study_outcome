package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class v implements IStartLivePreviewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.api.g f151718a;

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onCreate() {
        this.f151718a.onCreate();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroy() {
        this.f151718a.onDestroy();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroyView() {
        this.f151718a.onDestroyView();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStart() {
        this.f151718a.onStart();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStop() {
        this.f151718a.onStop();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewCreated() {
        this.f151718a.onViewCreated();
    }

    public v(RealStartLiveController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f151718a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f151718a.onContextAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onUserInfoChanged(IUserState r110) {
        Intrinsics.checkNotNullParameter(r110, UserInfo.USERSTATE);
        com.bytedance.android.livesdk.livecommerce.room.api.g r100 = this.f151718a;
        Intrinsics.checkNotNullParameter(r110, "$this$trans");
        r100.a(new com.bytedance.android.ec.adapter.api.state.c(r110.getUid(), r110.getSecUid(), "", "", r110.isLoginFunc(), r110.getReportParams(), r110.getExtra()));
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f151718a.b(new ak2.j(r100));
    }
}
