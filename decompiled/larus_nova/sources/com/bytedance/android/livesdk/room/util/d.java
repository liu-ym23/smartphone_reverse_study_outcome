package com.bytedance.android.livesdk.room.util;

import android.content.Context;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements ISaasLiveRoomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157829a;

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "debug";
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        b0 r100 = b0.o();
        String r101 = "call onActivityCreated on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onCreate() {
        b0 r100 = b0.o();
        String r101 = "call onCreate on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        b0 r100 = b0.o();
        String r101 = "call onDestroy on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroyView() {
        b0 r100 = b0.o();
        String r101 = "call onDestroyView on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onEnterRoomPrepared() {
        b0 r100 = b0.o();
        String r101 = "call onPreEnterRoom on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        b0 r100 = b0.o();
        String r101 = "call onPostExitRoom on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStart() {
        b0 r100 = b0.o();
        String r101 = "call onStart on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStop() {
        b0 r100 = b0.o();
        String r101 = "call onStop on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        b0 r100 = b0.o();
        String r101 = "call onWidgetLoadFinished on roomId:" + this.f157829a;
        r100.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onFirstFrame() {
        ISaasLiveRoomController.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onP0WidgetLoadFinished() {
        ISaasLiveRoomController.DefaultImpls.onP0WidgetLoadFinished(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomVisible() {
        ISaasLiveRoomController.DefaultImpls.onRoomVisible(this);
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f157829a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b0 r101 = b0.o();
        String r102 = "call onContextAttached on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        b0 r101 = b0.o();
        String r102 = "call onFunctionHandlerAttached on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onMessageHandlerAttached(ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        b0 r101 = b0.o();
        String r102 = "call onMessageHandlerAttached on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomEventHubAttached(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        b0 r101 = b0.o();
        String r102 = "call onRoomEventHubAttached on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        b0 r101 = b0.o();
        String r102 = "call onRoomStatusChanged on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificViewAttached(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificViewAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificWidgetLoadFinished(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController
    public final void onUserStatusChanged(UserState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        b0 r101 = b0.o();
        String r102 = "call onUserStatusChanged on roomId:" + this.f157829a + ',' + r100;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onVideoEventHubAttached(IVideoEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        ISaasLiveRoomController.DefaultImpls.onVideoEventHubAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        b0 r101 = b0.o();
        String r102 = "call onViewHandlerAttached on roomId:" + this.f157829a;
        r101.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onLiveFinished(Context r100, IRoomState r101) {
        b0 r102 = b0.o();
        String r103 = "call onLiveFinished on roomId:" + this.f157829a;
        r102.getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_room_controller", r103);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    @Deprecated(message = "请使用onSpecificBehaviorLoad，extraData 为上车消息携带业务参数", replaceWith = @ReplaceWith(expression = "onSpecificBehaviorLoad(behaviorClassName, isFold, isFromMsg, \"\")", imports = {"com.bytedance.android.livesdkapi.room.controller.ILiveRoomController.onSpecificBehaviorLoad"}))
    public final void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificBehaviorLoad(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        ISaasLiveRoomController.DefaultImpls.onSpecificBehaviorUnload(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
        ISaasLiveRoomController.DefaultImpls.onSpecificBehaviorLoad(this, r100, r101, r102, r103);
    }
}
