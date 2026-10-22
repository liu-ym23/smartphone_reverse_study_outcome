package com.bytedance.android.gamecp.live_impl;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements IStartLivePreviewController {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onUserInfoChanged(IUserState r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onCreate() {
        IStartLivePreviewController.DefaultImpls.onCreate(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroy() {
        IStartLivePreviewController.DefaultImpls.onDestroy(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroyView() {
        IStartLivePreviewController.DefaultImpls.onDestroyView(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStart() {
        IStartLivePreviewController.DefaultImpls.onStart(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStop() {
        IStartLivePreviewController.DefaultImpls.onStop(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewCreated() {
        IStartLivePreviewController.DefaultImpls.onViewCreated(this);
    }
}
