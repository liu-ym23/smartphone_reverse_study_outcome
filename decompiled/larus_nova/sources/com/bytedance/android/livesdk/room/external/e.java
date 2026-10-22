package com.bytedance.android.livesdk.room.external;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.TopRightRow4thWidget;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends AbsLiveRoomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f157643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f157644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f157645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f157646d;

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "TopRightRoomInfoWidgetController";
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        super.onActivityCreated();
        this.f157644b = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        super.onDestroy();
        if (this.f157645c == false) goto L6;
        this.f157645c = false;
        TopRightRoomInfoControllerProvider$roomControllerCache$1 r100 = TopRightRoomInfoControllerProvider.f157626a;
        String r101 = this.f157646d;
        Intrinsics.checkNotNullParameter(r101, "roomId");
        TopRightRoomInfoControllerProvider.f157626a.remove(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        super.onWidgetLoadFinished();
        if (this.f157643a == true) goto L5;
        return;
    L5:
        if (this.f157644b == true) goto L8;
        return;
    L8:
        if (isContextAttached() == true) goto L10;
        return;
    L10:
        if (isViewHandlerAttached() == false) goto L17;
        TopRightRoomInfoWidget r100 = new TopRightRoomInfoWidget(getContext(), getHandler(), this.f157646d);
        r100.f157633f.provideWidget(r100, TopRightRow4thWidget.INSTANCE);
        r100.f157633f.requestShow(r100);
        return;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f157646d = r100;
        this.f157645c = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onContextAttached(r100);
        this.f157643a = true;
    }
}
