package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/AbsLiveRoomStateController;", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveMergeRoomController;", "()V", "currentRoomState", "Lcom/bytedance/android/livesdkapi/room/state/RoomState;", "getCurrentRoomState", "()Lcom/bytedance/android/livesdkapi/room/state/RoomState;", "setCurrentRoomState", "(Lcom/bytedance/android/livesdkapi/room/state/RoomState;)V", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "isRoomStateAttached", "", "updateCurrentRoomState", "", "state", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveRoomStateController implements ILiveMergeRoomController {
    protected RoomState currentRoomState;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController$isRoomStateAttached$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        public AnonymousClass1(AbsLiveRoomStateController r100) {
            super(r100, AbsLiveRoomStateController.class, "currentRoomState", "getCurrentRoomState()Lcom/bytedance/android/livesdkapi/room/state/RoomState;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((AbsLiveRoomStateController) this.receiver).m8276getCurrentRoomState();
        }
    }

    public AbsLiveRoomStateController() {
    }

    public final IRoomState getCurrentRoomState() {
        RoomState r100 = this.currentRoomState;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentRoomState");
    L5:
        return r100;
    }

    public final boolean isRoomStateAttached() {
        if (this.currentRoomState == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public String businessType() {
        return ILiveMergeRoomController.DefaultImpls.businessType(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onActivityCreated() {
        ILiveMergeRoomController.DefaultImpls.onActivityCreated(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onCreate() {
        ILiveMergeRoomController.DefaultImpls.onCreate(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onDestroy() {
        ILiveMergeRoomController.DefaultImpls.onDestroy(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onDestroyView() {
        ILiveMergeRoomController.DefaultImpls.onDestroyView(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onEnterRoomPrepared() {
        ILiveMergeRoomController.DefaultImpls.onEnterRoomPrepared(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onExitRoom() {
        ILiveMergeRoomController.DefaultImpls.onExitRoom(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onFirstFrame() {
        ILiveMergeRoomController.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onP0WidgetLoadFinished() {
        ILiveMergeRoomController.DefaultImpls.onP0WidgetLoadFinished(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public void onPause() {
        ILiveMergeRoomController.DefaultImpls.onPause(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public void onResume() {
        ILiveMergeRoomController.DefaultImpls.onResume(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onRoomVisible() {
        ILiveMergeRoomController.DefaultImpls.onRoomVisible(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onStart() {
        ILiveMergeRoomController.DefaultImpls.onStart(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onStop() {
        ILiveMergeRoomController.DefaultImpls.onStop(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onWidgetLoadFinished() {
        ILiveMergeRoomController.DefaultImpls.onWidgetLoadFinished(this);
    }

    /* JADX INFO: renamed from: getCurrentRoomState, reason: collision with other method in class */
    public final RoomState m8276getCurrentRoomState() {
        RoomState r100 = this.currentRoomState;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentRoomState");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        ILiveMergeRoomController.DefaultImpls.onFunctionHandlerAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onRoomEventHubAttached(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        ILiveMergeRoomController.DefaultImpls.onRoomEventHubAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ILiveMergeRoomController.DefaultImpls.onRoomStatusChanged(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onSpecificViewAttached(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassName");
        ILiveMergeRoomController.DefaultImpls.onSpecificViewAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onSpecificWidgetLoadFinished(String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        ILiveMergeRoomController.DefaultImpls.onSpecificWidgetLoadFinished(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onVideoEventHubAttached(IVideoEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        ILiveMergeRoomController.DefaultImpls.onVideoEventHubAttached(this, r100);
    }

    public final void setCurrentRoomState(RoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentRoomState = r100;
    }

    public final void updateCurrentRoomState(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof RoomState) == true) goto L5;
        r100 = null;
    L5:
        RoomState r101 = (RoomState) r100;
        if (r101 == null) goto L9;
        this.currentRoomState = r101;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onLiveFinished(Context r100, IRoomState r101) {
        ILiveMergeRoomController.DefaultImpls.onLiveFinished(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    @Deprecated(message = "请使用onSpecificBehaviorLoad，extraData 为上车消息携带业务参数", replaceWith = @ReplaceWith(expression = "onSpecificBehaviorLoad(behaviorClassName, isFold, isFromMsg, \"\")", imports = {"com.bytedance.android.livesdkapi.room.controller.ILiveRoomController.onSpecificBehaviorLoad"}))
    public void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        ILiveMergeRoomController.DefaultImpls.onSpecificBehaviorLoad(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        ILiveMergeRoomController.DefaultImpls.onSpecificBehaviorUnload(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
        ILiveMergeRoomController.DefaultImpls.onSpecificBehaviorLoad(this, r100, r101, r102, r103);
    }
}
