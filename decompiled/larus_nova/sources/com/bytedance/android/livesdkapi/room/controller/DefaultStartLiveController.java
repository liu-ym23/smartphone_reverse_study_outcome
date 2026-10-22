package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/DefaultStartLiveController;", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "()V", "onContextAttached", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onUserInfoChanged", UserInfo.USERSTATE, "Lcom/bytedance/android/livesdkapi/room/state/IUserState;", "onViewHandlerAttached", "handler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultStartLiveController implements IStartLivePreviewController {
    public DefaultStartLiveController() {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onUserInfoChanged(IUserState r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onCreate() {
        IStartLivePreviewController.DefaultImpls.onCreate(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onDestroy() {
        IStartLivePreviewController.DefaultImpls.onDestroy(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onDestroyView() {
        IStartLivePreviewController.DefaultImpls.onDestroyView(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onStart() {
        IStartLivePreviewController.DefaultImpls.onStart(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onStop() {
        IStartLivePreviewController.DefaultImpls.onStop(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public void onViewCreated() {
        IStartLivePreviewController.DefaultImpls.onViewCreated(this);
    }
}
