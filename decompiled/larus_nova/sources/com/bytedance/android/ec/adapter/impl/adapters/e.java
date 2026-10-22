package com.bytedance.android.ec.adapter.impl.adapters;

import android.content.Context;
import com.bytedance.android.ec.adapter.impl.converter.n;
import com.bytedance.android.ec.adapter.impl.utils.RoomStateExtensionsKt;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements IStartLivePreviewController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd.c f42754a;

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onCreate() {
        IStartLivePreviewController.DefaultImpls.onCreate(this);
        this.f42754a.onCreate();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroy() {
        IStartLivePreviewController.DefaultImpls.onDestroy(this);
        this.f42754a.onDestroy();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroyView() {
        IStartLivePreviewController.DefaultImpls.onDestroyView(this);
        this.f42754a.onDestroyView();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStart() {
        IStartLivePreviewController.DefaultImpls.onStart(this);
        this.f42754a.onStart();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStop() {
        IStartLivePreviewController.DefaultImpls.onStop(this);
        this.f42754a.onStop();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewCreated() {
        IStartLivePreviewController.DefaultImpls.onViewCreated(this);
        this.f42754a.onViewCreated();
    }

    public e(rd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "realController");
        this.f42754a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f42754a.onContextAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onUserInfoChanged(IUserState r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
        this.f42754a.a(RoomStateExtensionsKt.b((UserState) r100));
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        rd.c r101 = this.f42754a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2EC");
        r101.b(n.f42790b.a(r100));
    }
}
