package com.bytedance.android.livesdk.room.util;

import android.content.Context;
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
public final class a implements ISaasLiveRoomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DebugRoomStateMachine f157826a;

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "debug";
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        this.f157826a.onActivityCreated();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onCreate() {
        this.f157826a.onCreate();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        this.f157826a.onDestroy();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroyView() {
        this.f157826a.onDestroyView();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onEnterRoomPrepared() {
        this.f157826a.onEnterRoomPrepared();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        this.f157826a.onExitRoom();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStart() {
        this.f157826a.onStart();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStop() {
        this.f157826a.onStop();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        this.f157826a.onWidgetLoadFinished();
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

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f157826a = new DebugRoomStateMachine();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f157826a.onContextAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        this.f157826a.onFunctionHandlerAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onMessageHandlerAttached(ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        this.f157826a.onMessageHandlerAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomEventHubAttached(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        this.f157826a.onRoomEventHubAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f157826a.onRoomStatusChanged(r100);
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
        this.f157826a.getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onVideoEventHubAttached(IVideoEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        ISaasLiveRoomController.DefaultImpls.onVideoEventHubAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f157826a.onViewHandlerAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onLiveFinished(Context r100, IRoomState r101) {
        this.f157826a.getClass();
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
