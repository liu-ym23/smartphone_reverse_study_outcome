package com.bytedance.android.livesdk.room.state;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ts2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\u0001\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/room/state/LiveRoomNewState;", "", "Lts2/b;", "", "toString", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "containerLifecycle", "Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "getContainerLifecycle", "()Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "setContainerLifecycle", "(Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;)V", "Lts2/a;", "extraContainerData", "Lts2/a;", "getExtraContainerData", "()Lts2/a;", "setExtraContainerData", "(Lts2/a;)V", "Lcom/bytedance/android/livesdk/room/state/RoomStateChangeLifecycle;", "roomStateChangeLifecycle", "Lcom/bytedance/android/livesdk/room/state/RoomStateChangeLifecycle;", "getRoomStateChangeLifecycle", "()Lcom/bytedance/android/livesdk/room/state/RoomStateChangeLifecycle;", "setRoomStateChangeLifecycle", "(Lcom/bytedance/android/livesdk/room/state/RoomStateChangeLifecycle;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ROOM_CONTAINER_INIT", "ROOM_CONTAINER_FINISH", "ROOM_DATA_READY", "ROOM_BEFORE_PRE_ENTER_ROOM", "ROOM_AFTER_PRE_ENTER_ROOM", "ROOM_START_ENTER_ROOM_FINISH", "ROOM_CONTAINER_STATE_CHANGED", "ROOM_STREAM_READY", "ROOM_STATE_CHANGE", "ROOM_WIDGET_LOAD_START", "ROOM_WIDGET_LOAD_FINISH", "ROOM_STOP_ROOM_FINISH", "PRELOAD_ROOM_STOP_FINISH", "ROOM_START_STOP", "PRELOAD_ROOM_START_STOP", "ROOM_START_LOAD_INTERACTION", "ROOM_PLAYER_BIND_FINISH", "ROOM_START_ENTER_ROOM", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRoomNewState extends Enum<LiveRoomNewState> implements b {
    public static final a Companion = null;
    public static final LiveRoomNewState PRELOAD_ROOM_START_STOP = null;
    public static final LiveRoomNewState PRELOAD_ROOM_STOP_FINISH = null;
    public static final LiveRoomNewState ROOM_AFTER_PRE_ENTER_ROOM = null;
    public static final LiveRoomNewState ROOM_BEFORE_PRE_ENTER_ROOM = null;
    public static final LiveRoomNewState ROOM_CONTAINER_FINISH = null;
    public static final LiveRoomNewState ROOM_CONTAINER_INIT = null;
    public static final LiveRoomNewState ROOM_CONTAINER_STATE_CHANGED = null;
    public static final LiveRoomNewState ROOM_DATA_READY = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法不建议使用,这里标识播放器绑定完成的回调，考虑使用ROOM_START_ENTER_ROOM_FINISH来替代", replaceWith = @ReplaceWith(expression = "startEnterRoomFinish", imports = {}))
    public static final LiveRoomNewState ROOM_PLAYER_BIND_FINISH = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法不建议使用，请使用ROOM_START_ENTER_ROOM_FINISH来替代", replaceWith = @ReplaceWith(expression = "startEnterRoomFinish", imports = {}))
    public static final LiveRoomNewState ROOM_START_ENTER_ROOM = null;
    public static final LiveRoomNewState ROOM_START_ENTER_ROOM_FINISH = null;
    public static final LiveRoomNewState ROOM_START_LOAD_INTERACTION = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法不建议使用,这里标识播放器绑定完成的回调，考虑使用ROOM_STOP_ROOM_FINISH来替代", replaceWith = @ReplaceWith(expression = "exitRoom", imports = {}))
    public static final LiveRoomNewState ROOM_START_STOP = null;
    public static final LiveRoomNewState ROOM_STATE_CHANGE = null;
    public static final LiveRoomNewState ROOM_STOP_ROOM_FINISH = null;
    public static final LiveRoomNewState ROOM_STREAM_READY = null;
    public static final LiveRoomNewState ROOM_WIDGET_LOAD_FINISH = null;
    public static final LiveRoomNewState ROOM_WIDGET_LOAD_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRoomNewState[] f157817a = null;
    private ContainerLifecycle containerLifecycle;
    private final String des;
    private ts2.a extraContainerData;
    private RoomStateChangeLifecycle roomStateChangeLifecycle;

    public static final class a {
        public a() {
        }

        public static LiveRoomNewState a(ContainerLifecycle r100) {
            Intrinsics.checkNotNullParameter(r100, "containerLifecycle");
            LiveRoomNewState r101 = LiveRoomNewState.ROOM_CONTAINER_STATE_CHANGED;
            r101.setContainerLifecycle(r100);
            return r101;
        }

        public static LiveRoomNewState b(ContainerLifecycle r100, ts2.a r101) {
            Intrinsics.checkNotNullParameter(r100, "containerLifecycle");
            LiveRoomNewState r102 = LiveRoomNewState.ROOM_CONTAINER_STATE_CHANGED;
            r102.setContainerLifecycle(r100);
            r102.setExtraContainerData(r101);
            return r102;
        }
    }

    public LiveRoomNewState() {
        throw null;
    }

    public static LiveRoomNewState valueOf(String r100) {
        return (LiveRoomNewState) r27.a.a(LiveRoomNewState.class, r100);
    }

    public static LiveRoomNewState[] values() {
        return (LiveRoomNewState[]) f157817a.clone();
    }

    static {
        LiveRoomNewState r110 = new LiveRoomNewState("ROOM_CONTAINER_INIT", 0, "room_container_init", null, null, null, 14, null);
        ROOM_CONTAINER_INIT = r110;
        LiveRoomNewState r100 = new LiveRoomNewState("ROOM_CONTAINER_FINISH", 1, "container_create", null, null, null, 14, null);
        ROOM_CONTAINER_FINISH = r100;
        LiveRoomNewState r101 = new LiveRoomNewState("ROOM_DATA_READY", 2, "room_data_ready", null, null, null, 14, null);
        ROOM_DATA_READY = r101;
        LiveRoomNewState r102 = new LiveRoomNewState("ROOM_BEFORE_PRE_ENTER_ROOM", 3, "before_pre_enter_room", null, null, null, 14, null);
        ROOM_BEFORE_PRE_ENTER_ROOM = r102;
        LiveRoomNewState r103 = new LiveRoomNewState("ROOM_AFTER_PRE_ENTER_ROOM", 4, "after_pre_enter_room", null, null, null, 14, null);
        ROOM_AFTER_PRE_ENTER_ROOM = r103;
        LiveRoomNewState r104 = new LiveRoomNewState("ROOM_START_ENTER_ROOM_FINISH", 5, "start_enter_room", null, null, null, 14, null);
        ROOM_START_ENTER_ROOM_FINISH = r104;
        LiveRoomNewState r105 = new LiveRoomNewState("ROOM_CONTAINER_STATE_CHANGED", 6, "container_changed", null, null, null, 14, null);
        ROOM_CONTAINER_STATE_CHANGED = r105;
        LiveRoomNewState r106 = new LiveRoomNewState("ROOM_STREAM_READY", 7, "stream_ready", null, null, null, 14, null);
        ROOM_STREAM_READY = r106;
        LiveRoomNewState r107 = new LiveRoomNewState("ROOM_STATE_CHANGE", 8, "room_change", null, null, null, 14, null);
        ROOM_STATE_CHANGE = r107;
        LiveRoomNewState r108 = new LiveRoomNewState("ROOM_WIDGET_LOAD_START", 9, "widget_load_start", null, null, null, 14, null);
        ROOM_WIDGET_LOAD_START = r108;
        LiveRoomNewState r109 = new LiveRoomNewState("ROOM_WIDGET_LOAD_FINISH", 10, "widget_load", null, null, null, 14, null);
        ROOM_WIDGET_LOAD_FINISH = r109;
        LiveRoomNewState r111 = new LiveRoomNewState("ROOM_STOP_ROOM_FINISH", 11, "room_stop_finish", null, null, null, 14, null);
        ROOM_STOP_ROOM_FINISH = r111;
        LiveRoomNewState r112 = new LiveRoomNewState("PRELOAD_ROOM_STOP_FINISH", 12, "preload_room_stop_finish", null, null, null, 14, null);
        PRELOAD_ROOM_STOP_FINISH = r112;
        LiveRoomNewState r113 = new LiveRoomNewState("ROOM_START_STOP", 13, "room_stop_start", null, null, null, 14, null);
        ROOM_START_STOP = r113;
        LiveRoomNewState r114 = new LiveRoomNewState("PRELOAD_ROOM_START_STOP", 14, "preload_room_start_stop", null, null, null, 14, null);
        PRELOAD_ROOM_START_STOP = r114;
        LiveRoomNewState r115 = new LiveRoomNewState("ROOM_START_LOAD_INTERACTION", 15, "start_load_interaction", null, null, null, 14, null);
        ROOM_START_LOAD_INTERACTION = r115;
        LiveRoomNewState r116 = new LiveRoomNewState("ROOM_PLAYER_BIND_FINISH", 16, "player_bind_finish", null, null, null, 14, null);
        ROOM_PLAYER_BIND_FINISH = r116;
        LiveRoomNewState r117 = new LiveRoomNewState("ROOM_START_ENTER_ROOM", 17, "enter_room_start", null, null, null, 14, null);
        ROOM_START_ENTER_ROOM = r117;
        f157817a = new LiveRoomNewState[]{r110, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r111, r112, r113, r114, r115, r116, r117};
        Companion = new a();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(name());
        r100.append(" ->> ");
        Object r101 = this.containerLifecycle;
        Object r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(", ");
        Object r103 = this.extraContainerData;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.append(r103);
        r100.append(", ");
        RoomStateChangeLifecycle r104 = this.roomStateChangeLifecycle;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.append(r102);
        return r100.toString();
    }

    public final ContainerLifecycle getContainerLifecycle() {
        return this.containerLifecycle;
    }

    public final String getDes() {
        return this.des;
    }

    public final ts2.a getExtraContainerData() {
        return this.extraContainerData;
    }

    public final RoomStateChangeLifecycle getRoomStateChangeLifecycle() {
        return this.roomStateChangeLifecycle;
    }

    public final void setContainerLifecycle(ContainerLifecycle r100) {
        this.containerLifecycle = r100;
    }

    public final void setExtraContainerData(ts2.a r100) {
        this.extraContainerData = r100;
    }

    public final void setRoomStateChangeLifecycle(RoomStateChangeLifecycle r100) {
        this.roomStateChangeLifecycle = r100;
    }

    public LiveRoomNewState(String r100, int r101, String r102, ContainerLifecycle r103, ts2.a r104, RoomStateChangeLifecycle r105, int r106, DefaultConstructorMarker r107) {
        if ((r106 & 1) == 0) goto L6;
        r102 = "";
    L6:
        if ((r106 & 2) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 8) == 0) goto L14;
        r105 = null;
    L14:
        super(r100, r101);
        this.des = r102;
        this.containerLifecycle = r103;
        this.extraContainerData = r104;
        this.roomStateChangeLifecycle = r105;
    }
}
