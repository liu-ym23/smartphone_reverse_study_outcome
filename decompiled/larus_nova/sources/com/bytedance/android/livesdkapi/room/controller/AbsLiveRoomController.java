package com.bytedance.android.livesdkapi.room.controller;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0004J\b\u0010)\u001a\u00020(H\u0004J\b\u0010*\u001a\u00020(H\u0004J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u00020,H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u00103\u001a\u00020,2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020,H\u0016J\b\u00108\u001a\u00020,H\u0016J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0010\u0010;\u001a\u00020,2\u0006\u00104\u001a\u000205H\u0016J\b\u0010<\u001a\u00020,H\u0016J\b\u0010=\u001a\u00020,H\u0016J\u0010\u0010>\u001a\u00020,2\u0006\u0010:\u001a\u00020\"H\u0016J\u0010\u0010?\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u00020,H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/AbsLiveRoomController;", "Lcom/bytedance/android/livesdkapi/room/controller/AbsLiveRoomStateController;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "functionHandler", "Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "getFunctionHandler", "()Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", "setFunctionHandler", "(Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;)V", "handler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "getHandler", "()Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", "setHandler", "(Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;)V", "messageHandler", "Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "getMessageHandler", "()Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;", "setMessageHandler", "(Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomMessageHandler;)V", "roomEventHub", "Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "getRoomEventHub", "()Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;", "setRoomEventHub", "(Lcom/bytedance/android/livesdkapi/roomplayer/IRoomEventHub;)V", "videoEventHub", "Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "getVideoEventHub", "()Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "setVideoEventHub", "(Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;)V", "isContextAttached", "", "isFunctionHandlerAttached", "isViewHandlerAttached", "onActivityCreated", "", "onContextAttached", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "onExitRoom", "onFunctionHandlerAttached", "onLiveFinished", "state", "Lcom/bytedance/android/livesdkapi/room/state/IRoomState;", "onMessageHandlerAttached", "onPause", "onResume", "onRoomEventHubAttached", "eventHub", "onRoomStatusChanged", WidgetCostModule.TYPE_ON_START, "onStop", "onVideoEventHubAttached", "onViewHandlerAttached", "onWidgetLoadFinished", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveRoomController extends AbsLiveRoomStateController {
    protected Context context;
    protected IBaseLiveRoomFunctionHandler functionHandler;
    protected ILiveRoomViewHandler handler;
    private ILiveRoomMessageHandler messageHandler;
    private IRoomEventHub roomEventHub;
    private IVideoEventHub videoEventHub;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController$isContextAttached$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        public AnonymousClass1(AbsLiveRoomController r100) {
            super(r100, AbsLiveRoomController.class, PerfLog.PARAM_KEY_CONTEXT_ID, "getContext()Landroid/content/Context;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((AbsLiveRoomController) this.receiver).getContext();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController$isFunctionHandlerAttached$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C102501 extends PropertyReference0Impl {
        public C102501(AbsLiveRoomController r100) {
            super(r100, AbsLiveRoomController.class, "functionHandler", "getFunctionHandler()Lcom/bytedance/android/livesdkapi/room/handler/IBaseLiveRoomFunctionHandler;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((AbsLiveRoomController) this.receiver).getFunctionHandler();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController$isViewHandlerAttached$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C102511 extends PropertyReference0Impl {
        public C102511(AbsLiveRoomController r100) {
            super(r100, AbsLiveRoomController.class, "handler", "getHandler()Lcom/bytedance/android/livesdkapi/room/handler/ILiveRoomViewHandler;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((AbsLiveRoomController) this.receiver).getHandler();
        }
    }

    public final Context getContext() {
        Context r100 = this.context;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final IBaseLiveRoomFunctionHandler getFunctionHandler() {
        IBaseLiveRoomFunctionHandler r100 = this.functionHandler;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("functionHandler");
    L5:
        return r100;
    }

    public final ILiveRoomViewHandler getHandler() {
        ILiveRoomViewHandler r100 = this.handler;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        return r100;
    }

    public final boolean isContextAttached() {
        if (this.context == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFunctionHandlerAttached() {
        if (this.functionHandler == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isViewHandlerAttached() {
        if (this.handler == null) goto L5;
        return true;
    L5:
        return false;
    }

    public AbsLiveRoomController() {
    }

    public final ILiveRoomMessageHandler getMessageHandler() {
        return this.messageHandler;
    }

    public final IRoomEventHub getRoomEventHub() {
        return this.roomEventHub;
    }

    public final IVideoEventHub getVideoEventHub() {
        return this.videoEventHub;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onActivityCreated() {
        super.onActivityCreated();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onExitRoom() {
        super.onExitRoom();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onStart() {
        super.onStart();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onStop() {
        super.onStop();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onWidgetLoadFinished() {
        super.onWidgetLoadFinished();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        this.functionHandler = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onMessageHandlerAttached(ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        this.messageHandler = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onRoomEventHubAttached(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        super.onRoomEventHubAttached(r100);
        this.roomEventHub = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        super.updateCurrentRoomState(r100);
        ALogger.i("AbsLiveRoomController", "onRoomStatusChanged->currentRoomState =" + m8276getCurrentRoomState() + "， " + m8276getCurrentRoomState().hashCode() + ", " + hashCode() + ' ' + m8276getCurrentRoomState().getRoomId());
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onVideoEventHubAttached(IVideoEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        super.onVideoEventHubAttached(r100);
        this.videoEventHub = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.handler = r100;
    }

    public final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.context = r100;
    }

    public final void setFunctionHandler(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.functionHandler = r100;
    }

    public final void setHandler(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.handler = r100;
    }

    public final void setMessageHandler(ILiveRoomMessageHandler r100) {
        this.messageHandler = r100;
    }

    public final void setRoomEventHub(IRoomEventHub r100) {
        this.roomEventHub = r100;
    }

    public final void setVideoEventHub(IVideoEventHub r100) {
        this.videoEventHub = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public void onLiveFinished(Context r100, IRoomState r101) {
        if (r101 == null) goto L4;
        super.updateCurrentRoomState(r101);
        ALogger.i("AbsLiveRoomController", "onLiveFinished，  " + m8276getCurrentRoomState().hashCode());
    L4:
        if (r100 == null) goto L7;
        this.context = r100;
        return;
    }
}
