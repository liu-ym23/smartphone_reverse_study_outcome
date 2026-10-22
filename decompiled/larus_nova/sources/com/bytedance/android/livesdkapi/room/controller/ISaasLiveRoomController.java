package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ISaasLiveRoomController;", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "onUserStatusChanged", "", "state", "Lcom/bytedance/android/livesdkapi/room/state/UserState;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISaasLiveRoomController extends ILiveRoomController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String businessType(ISaasLiveRoomController r100) {
            return ILiveRoomController.DefaultImpls.businessType(r100);
        }

        public static void onActivityCreated(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onActivityCreated(r100);
        }

        public static void onCreate(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onCreate(r100);
        }

        public static void onDestroy(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onDestroy(r100);
        }

        public static void onDestroyView(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onDestroyView(r100);
        }

        public static void onEnterRoomPrepared(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onEnterRoomPrepared(r100);
        }

        public static void onExitRoom(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onExitRoom(r100);
        }

        public static void onFirstFrame(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onFirstFrame(r100);
        }

        public static void onFunctionHandlerAttached(ISaasLiveRoomController r100, IBaseLiveRoomFunctionHandler r101) {
            Intrinsics.checkNotNullParameter(r101, "functionHandler");
            ILiveRoomController.DefaultImpls.onFunctionHandlerAttached(r100, r101);
        }

        public static void onLiveFinished(ISaasLiveRoomController r100, Context r101, IRoomState r102) {
            ILiveRoomController.DefaultImpls.onLiveFinished(r100, r101, r102);
        }

        public static void onP0WidgetLoadFinished(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onP0WidgetLoadFinished(r100);
        }

        public static void onRoomEventHubAttached(ISaasLiveRoomController r100, IRoomEventHub r101) {
            Intrinsics.checkNotNullParameter(r101, "eventHub");
            ILiveRoomController.DefaultImpls.onRoomEventHubAttached(r100, r101);
        }

        public static void onRoomStatusChanged(ISaasLiveRoomController r100, IRoomState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
            ILiveRoomController.DefaultImpls.onRoomStatusChanged(r100, r101);
        }

        public static void onRoomVisible(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onRoomVisible(r100);
        }

        @Deprecated(message = "请使用onSpecificBehaviorLoad，extraData 为上车消息携带业务参数", replaceWith = @ReplaceWith(expression = "onSpecificBehaviorLoad(behaviorClassName, isFold, isFromMsg, \"\")", imports = {"com.bytedance.android.livesdkapi.room.controller.ILiveRoomController.onSpecificBehaviorLoad"}))
        public static void onSpecificBehaviorLoad(ISaasLiveRoomController r100, String r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
            ILiveRoomController.DefaultImpls.onSpecificBehaviorLoad(r100, r101, r102, r103);
        }

        public static void onSpecificBehaviorLoad(ISaasLiveRoomController r100, String r101, boolean r102, boolean r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
            Intrinsics.checkNotNullParameter(r104, ControlRule.KEY_EXTRA_DATA);
            ILiveRoomController.DefaultImpls.onSpecificBehaviorLoad(r100, r101, r102, r103, r104);
        }

        public static void onSpecificBehaviorUnload(ISaasLiveRoomController r100, String r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
            ILiveRoomController.DefaultImpls.onSpecificBehaviorUnload(r100, r101, r102, r103);
        }

        public static void onSpecificViewAttached(ISaasLiveRoomController r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "viewClassName");
            ILiveRoomController.DefaultImpls.onSpecificViewAttached(r100, r101);
        }

        public static void onSpecificWidgetLoadFinished(ISaasLiveRoomController r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "widgetClassName");
            ILiveRoomController.DefaultImpls.onSpecificWidgetLoadFinished(r100, r101);
        }

        public static void onStart(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onStart(r100);
        }

        public static void onStop(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onStop(r100);
        }

        public static void onUserStatusChanged(ISaasLiveRoomController r100, UserState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
        }

        public static void onVideoEventHubAttached(ISaasLiveRoomController r100, IVideoEventHub r101) {
            Intrinsics.checkNotNullParameter(r101, "eventHub");
            ILiveRoomController.DefaultImpls.onVideoEventHubAttached(r100, r101);
        }

        public static void onWidgetLoadFinished(ISaasLiveRoomController r100) {
            ILiveRoomController.DefaultImpls.onWidgetLoadFinished(r100);
        }
    }

    void onUserStatusChanged(UserState r100);
}
