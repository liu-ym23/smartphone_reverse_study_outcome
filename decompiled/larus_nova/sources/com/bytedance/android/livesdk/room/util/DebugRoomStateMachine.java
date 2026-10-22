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
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class DebugRoomStateMachine implements ISaasLiveRoomController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f157823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Exception f157824b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/room/util/DebugRoomStateMachine$State;", "", "another", "", "ifBefore", "ifAfter", "ifEqual", "", "checkState", "PRE_ENTER_ROOM", "UI_CREATED", "UI_ACTIVITY_CREATED", "CONTEXT_ATTACHED", "UI_STARTED", "UI_STOPPED", "PLAYER_EVENT_HUB_ATTACHED", "MESSAGE_HANDLER_ATTACHED", "FUNCTION_HANDLER_ATTACHED", "VIEW_HANDLER_ATTACHED", "ROOM_STATUS_CHANGED", "WIDGET_LOAD_FINISHED", "LIVE_FINISHED", "UI_DESTROY_VIEW", "UI_DESTROYED", "POST_EXIT_ROOM", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CONTEXT_ATTACHED = null;
        public static final State FUNCTION_HANDLER_ATTACHED = null;
        public static final State LIVE_FINISHED = null;
        public static final State MESSAGE_HANDLER_ATTACHED = null;
        public static final State PLAYER_EVENT_HUB_ATTACHED = null;
        public static final State POST_EXIT_ROOM = null;
        public static final State PRE_ENTER_ROOM = null;
        public static final State ROOM_STATUS_CHANGED = null;
        public static final State UI_ACTIVITY_CREATED = null;
        public static final State UI_CREATED = null;
        public static final State UI_DESTROYED = null;
        public static final State UI_DESTROY_VIEW = null;
        public static final State UI_STARTED = null;
        public static final State UI_STOPPED = null;
        public static final State VIEW_HANDLER_ATTACHED = null;
        public static final State WIDGET_LOAD_FINISHED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f157825a = null;

        static {
            State r100 = new State("PRE_ENTER_ROOM", 0);
            PRE_ENTER_ROOM = r100;
            State r101 = new State("UI_CREATED", 1);
            UI_CREATED = r101;
            State r102 = new State("UI_ACTIVITY_CREATED", 2);
            UI_ACTIVITY_CREATED = r102;
            State r103 = new State("CONTEXT_ATTACHED", 3);
            CONTEXT_ATTACHED = r103;
            State r104 = new State("UI_STARTED", 4);
            UI_STARTED = r104;
            State r105 = new State("UI_STOPPED", 5);
            UI_STOPPED = r105;
            State r106 = new State("PLAYER_EVENT_HUB_ATTACHED", 6);
            PLAYER_EVENT_HUB_ATTACHED = r106;
            State r107 = new State("MESSAGE_HANDLER_ATTACHED", 7);
            MESSAGE_HANDLER_ATTACHED = r107;
            State r108 = new State("FUNCTION_HANDLER_ATTACHED", 8);
            FUNCTION_HANDLER_ATTACHED = r108;
            State r109 = new State("VIEW_HANDLER_ATTACHED", 9);
            VIEW_HANDLER_ATTACHED = r109;
            State r110 = new State("ROOM_STATUS_CHANGED", 10);
            ROOM_STATUS_CHANGED = r110;
            State r111 = new State("WIDGET_LOAD_FINISHED", 11);
            WIDGET_LOAD_FINISHED = r111;
            State r112 = new State("LIVE_FINISHED", 12);
            LIVE_FINISHED = r112;
            State r113 = new State("UI_DESTROY_VIEW", 13);
            UI_DESTROY_VIEW = r113;
            State r114 = new State("UI_DESTROYED", 14);
            UI_DESTROYED = r114;
            State r115 = new State("POST_EXIT_ROOM", 15);
            POST_EXIT_ROOM = r115;
            f157825a = new State[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f157825a.clone();
        }

        public final void a(String r100) {
            String r101 = "current " + name() + ": msg = " + r100;
            b0 r102 = b0.o();
            IllegalStateException r103 = new IllegalStateException(r101);
            r102.getClass();
            com.bytedance.android.live.core.log.g.d("ttlive_room_controller", r101, r103);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }

        public final void checkState(State r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "another");
            Intrinsics.checkNotNullParameter(r101, "ifBefore");
            Intrinsics.checkNotNullParameter(r102, "ifAfter");
            Intrinsics.checkNotNullParameter(r103, "ifEqual");
            boolean r104 = true;
            if (ordinal() <= r100.ordinal()) goto L11;
            if (r102.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == false) goto L11;
            a(r102);
            goto L11
        L7:
            r105 = false;
        L11:
            if (ordinal() >= r100.ordinal()) goto L19;
            if (r101.length() <= 0) goto L15;
            boolean r106 = true;
        L16:
            if (r106 == false) goto L19;
            a(r101);
            goto L19
        L15:
            r106 = false;
        L19:
            if (ordinal() == r100.ordinal()) goto L21;
            return;
        L21:
            if (r103.length() > 0) goto L24;
            r104 = false;
        L24:
            if (r104 == false) goto L28;
            a(r103);
            return;
        }

        public static /* synthetic */ void checkState$default(State r100, State r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = "";
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = "";
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = "";
        L11:
            r100.checkState(r101, r102, r103, r104);
        }
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "debug";
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onLiveFinished(Context r100, IRoomState r101) {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController
    public final void onUserStatusChanged(UserState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        State r100 = State.UI_ACTIVITY_CREATED;
        this.f157823a = r100;
        State.checkState$default(r100, State.UI_CREATED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onCreate() {
        State r100 = State.UI_CREATED;
        this.f157823a = r100;
        State.checkState$default(r100, State.PRE_ENTER_ROOM, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        State r100 = State.UI_DESTROYED;
        this.f157823a = r100;
        State.checkState$default(r100, State.UI_DESTROY_VIEW, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroyView() {
        State r100 = State.UI_DESTROY_VIEW;
        this.f157823a = r100;
        State.checkState$default(r100, State.UI_STOPPED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onEnterRoomPrepared() {
        if (this.f157823a == State.POST_EXIT_ROOM) goto L5;
        String r100 = "current " + this.f157823a + ": msg = " + ("onPreEnter's preview state expect postExit, but: " + this.f157823a.name());
        b0 r101 = b0.o();
        IllegalStateException r102 = new IllegalStateException(r100);
        r101.getClass();
        com.bytedance.android.live.core.log.g.d("ttlive_room_controller", r100, r102);
    L5:
        this.f157823a = State.PRE_ENTER_ROOM;
        this.f157824b = null;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        State r100 = this.f157823a;
        State r101 = State.POST_EXIT_ROOM;
        if (r100 != r101) goto L5;
        b0 r102 = b0.o();
        Exception r103 = this.f157824b;
        r102.getClass();
        com.bytedance.android.live.core.log.g.d("ttlive_room_controller", "call onPostExitRoom twice,first", r103);
    L5:
        State.checkState$default(this.f157823a, r101, null, null, "duplicated", 6, null);
        this.f157823a = r101;
        this.f157824b = new IllegalStateException("first call");
        State.checkState$default(this.f157823a, State.ROOM_STATUS_CHANGED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStart() {
        State r100 = State.UI_STARTED;
        this.f157823a = r100;
        State.checkState$default(r100, State.UI_ACTIVITY_CREATED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStop() {
        State r100 = State.UI_STOPPED;
        this.f157823a = r100;
        State.checkState$default(r100, State.UI_STARTED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        State r100 = State.WIDGET_LOAD_FINISHED;
        this.f157823a = r100;
        State.checkState$default(r100, State.ROOM_STATUS_CHANGED, "too early", null, null, 12, null);
    }

    public DebugRoomStateMachine() {
        this.f157823a = State.POST_EXIT_ROOM;
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

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        State r101 = State.CONTEXT_ATTACHED;
        this.f157823a = r101;
        State.checkState$default(r101, State.UI_CREATED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onFunctionHandlerAttached(IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        State r101 = State.FUNCTION_HANDLER_ATTACHED;
        this.f157823a = r101;
        State.checkState$default(r101, State.MESSAGE_HANDLER_ATTACHED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onMessageHandlerAttached(ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        State r101 = State.MESSAGE_HANDLER_ATTACHED;
        this.f157823a = r101;
        State.checkState$default(r101, State.PLAYER_EVENT_HUB_ATTACHED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomEventHubAttached(IRoomEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        State r101 = State.PLAYER_EVENT_HUB_ATTACHED;
        this.f157823a = r101;
        State.checkState$default(r101, State.CONTEXT_ATTACHED, "too early", null, null, 12, null);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomStatusChanged(IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        State r101 = State.ROOM_STATUS_CHANGED;
        this.f157823a = r101;
        State.checkState$default(r101, State.VIEW_HANDLER_ATTACHED, "too early", null, null, 12, null);
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

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onVideoEventHubAttached(IVideoEventHub r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        ISaasLiveRoomController.DefaultImpls.onVideoEventHubAttached(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        State r101 = State.VIEW_HANDLER_ATTACHED;
        this.f157823a = r101;
        State.checkState$default(r101, State.FUNCTION_HANDLER_ATTACHED, "too early", null, null, 12, null);
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
