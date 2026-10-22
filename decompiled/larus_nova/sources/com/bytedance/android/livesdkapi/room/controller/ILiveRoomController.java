package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0017J(\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0003H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0005H\u0016¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "", "businessType", "", "onActivityCreated", "", "onContextAttached", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "onEnterRoomPrepared", "onExitRoom", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "onFunctionHandlerAttached", "functionHandler", "Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "onLiveFinished", "state", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "onMessageHandlerAttached", "messageHandler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "onP0WidgetLoadFinished", "onRoomEventHubAttached", "eventHub", "Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "onRoomStatusChanged", "onRoomVisible", "onSpecificBehaviorLoad", "behaviorClassName", "isFold", "", "isFromMsg", ControlRule.KEY_EXTRA_DATA, "onSpecificBehaviorUnload", "onSpecificViewAttached", "viewClassName", "onSpecificWidgetLoadFinished", "widgetClassName", WidgetCostModule.TYPE_ON_START, "onStop", "onVideoEventHubAttached", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "onViewHandlerAttached", "handler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "onWidgetLoadFinished", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String businessType(ILiveRoomController r100) {
            return "";
        }

        public static void onActivityCreated(ILiveRoomController r100) {
        }

        public static void onCreate(ILiveRoomController r100) {
        }

        public static void onDestroy(ILiveRoomController r100) {
        }

        public static void onDestroyView(ILiveRoomController r100) {
        }

        public static void onEnterRoomPrepared(ILiveRoomController r100) {
        }

        public static void onExitRoom(ILiveRoomController r100) {
        }

        public static void onFirstFrame(ILiveRoomController r100) {
        }

        public static void onFunctionHandlerAttached(ILiveRoomController r100, IBaseLiveRoomFunctionHandler r101) {
            Intrinsics.checkNotNullParameter(r101, "functionHandler");
        }

        public static void onLiveFinished(ILiveRoomController r100, Context r101, IRoomState r102) {
        }

        public static void onP0WidgetLoadFinished(ILiveRoomController r100) {
        }

        public static void onRoomEventHubAttached(ILiveRoomController r100, IRoomEventHub r101) {
            Intrinsics.checkNotNullParameter(r101, "eventHub");
        }

        public static void onRoomStatusChanged(ILiveRoomController r100, IRoomState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
        }

        public static void onRoomVisible(ILiveRoomController r100) {
        }

        @Deprecated(message = "请使用onSpecificBehaviorLoad，extraData 为上车消息携带业务参数", replaceWith = @ReplaceWith(expression = "onSpecificBehaviorLoad(behaviorClassName, isFold, isFromMsg, \"\")", imports = {"com.bytedance.android.livesdkapi.room.controller.ILiveRoomController.onSpecificBehaviorLoad"}))
        public static void onSpecificBehaviorLoad(ILiveRoomController r100, String r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
        }

        public static void onSpecificBehaviorUnload(ILiveRoomController r100, String r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
        }

        public static void onSpecificViewAttached(ILiveRoomController r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "viewClassName");
        }

        public static void onSpecificWidgetLoadFinished(ILiveRoomController r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "widgetClassName");
        }

        public static void onStart(ILiveRoomController r100) {
        }

        public static void onStop(ILiveRoomController r100) {
        }

        public static void onVideoEventHubAttached(ILiveRoomController r100, IVideoEventHub r101) {
            Intrinsics.checkNotNullParameter(r101, "eventHub");
        }

        public static void onWidgetLoadFinished(ILiveRoomController r100) {
        }

        public static void onSpecificBehaviorLoad(ILiveRoomController r100, String r101, boolean r102, boolean r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "behaviorClassName");
            Intrinsics.checkNotNullParameter(r104, ControlRule.KEY_EXTRA_DATA);
            r100.onSpecificBehaviorLoad(r101, r102, r103);
        }
    }

    String businessType();

    void onActivityCreated();

    void onContextAttached(Context r100);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onEnterRoomPrepared();

    void onExitRoom();

    void onFirstFrame();

    void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100);

    void onLiveFinished(Context r100, IRoomState r101);

    void onMessageHandlerAttached(ILiveRoomMessageHandler r100);

    void onP0WidgetLoadFinished();

    void onRoomEventHubAttached(IRoomEventHub r100);

    void onRoomStatusChanged(IRoomState r100);

    void onRoomVisible();

    @Deprecated(message = "请使用onSpecificBehaviorLoad，extraData 为上车消息携带业务参数", replaceWith = @ReplaceWith(expression = "onSpecificBehaviorLoad(behaviorClassName, isFold, isFromMsg, \"\")", imports = {"com.bytedance.android.livesdkapi.room.controller.ILiveRoomController.onSpecificBehaviorLoad"}))
    void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102);

    void onSpecificBehaviorLoad(String r100, boolean r101, boolean r102, String r103);

    void onSpecificBehaviorUnload(String r100, boolean r101, boolean r102);

    void onSpecificViewAttached(String r100);

    void onSpecificWidgetLoadFinished(String r100);

    void onStart();

    void onStop();

    void onVideoEventHubAttached(IVideoEventHub r100);

    void onViewHandlerAttached(ILiveRoomViewHandler r100);

    void onWidgetLoadFinished();
}
