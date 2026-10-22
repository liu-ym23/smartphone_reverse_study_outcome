package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "", "onContextAttached", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", WidgetCostModule.TYPE_ON_START, "onStop", "onUserInfoChanged", UserInfo.USERSTATE, "Lcom/bytedance/android/livesdkapi/room/state/IUserState;", "onViewCreated", "onViewHandlerAttached", "handler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IStartLivePreviewController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onCreate(IStartLivePreviewController r100) {
        }

        public static void onDestroy(IStartLivePreviewController r100) {
        }

        public static void onDestroyView(IStartLivePreviewController r100) {
        }

        public static void onStart(IStartLivePreviewController r100) {
        }

        public static void onStop(IStartLivePreviewController r100) {
        }

        public static void onViewCreated(IStartLivePreviewController r100) {
        }
    }

    void onContextAttached(Context r100);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onStart();

    void onStop();

    void onUserInfoChanged(IUserState r100);

    void onViewCreated();

    void onViewHandlerAttached(ILiveRoomViewHandler r100);
}
