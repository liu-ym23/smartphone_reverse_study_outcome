package com.bytedance.android.livesdk.paramtransfer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/paramtransfer/RoomParamsConsumeStage;", "", "DEFAULT", "CREATE_ROOM_FRAGMENT", "SEND_ENTER_REQUEST", "START_FIRST_ROOM", "ROOM_FRAGMENT_HANDLE_INTENT", "PRE_INIT_LOGGER", "POST_INIT_LOGGER", "CHANGE_PAGE_TO_FIRST", "PRE_DO_CHANGE_PAGE", "POST_DO_CHANGE_PAGE", "PLAY_FRAGMENT_CREATE", "LIVEROOM_DESTROY", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RoomParamsConsumeStage extends Enum<RoomParamsConsumeStage> {
    public static final RoomParamsConsumeStage CHANGE_PAGE_TO_FIRST = null;
    public static final RoomParamsConsumeStage CREATE_ROOM_FRAGMENT = null;
    public static final RoomParamsConsumeStage DEFAULT = null;
    public static final RoomParamsConsumeStage LIVEROOM_DESTROY = null;
    public static final RoomParamsConsumeStage PLAY_FRAGMENT_CREATE = null;
    public static final RoomParamsConsumeStage POST_DO_CHANGE_PAGE = null;
    public static final RoomParamsConsumeStage POST_INIT_LOGGER = null;
    public static final RoomParamsConsumeStage PRE_DO_CHANGE_PAGE = null;
    public static final RoomParamsConsumeStage PRE_INIT_LOGGER = null;
    public static final RoomParamsConsumeStage ROOM_FRAGMENT_HANDLE_INTENT = null;
    public static final RoomParamsConsumeStage SEND_ENTER_REQUEST = null;
    public static final RoomParamsConsumeStage START_FIRST_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoomParamsConsumeStage[] f154367a = null;

    static {
        RoomParamsConsumeStage r100 = new RoomParamsConsumeStage("DEFAULT", 0);
        DEFAULT = r100;
        RoomParamsConsumeStage r101 = new RoomParamsConsumeStage("CREATE_ROOM_FRAGMENT", 1);
        CREATE_ROOM_FRAGMENT = r101;
        RoomParamsConsumeStage r102 = new RoomParamsConsumeStage("SEND_ENTER_REQUEST", 2);
        SEND_ENTER_REQUEST = r102;
        RoomParamsConsumeStage r103 = new RoomParamsConsumeStage("START_FIRST_ROOM", 3);
        START_FIRST_ROOM = r103;
        RoomParamsConsumeStage r104 = new RoomParamsConsumeStage("ROOM_FRAGMENT_HANDLE_INTENT", 4);
        ROOM_FRAGMENT_HANDLE_INTENT = r104;
        RoomParamsConsumeStage r105 = new RoomParamsConsumeStage("PRE_INIT_LOGGER", 5);
        PRE_INIT_LOGGER = r105;
        RoomParamsConsumeStage r106 = new RoomParamsConsumeStage("POST_INIT_LOGGER", 6);
        POST_INIT_LOGGER = r106;
        RoomParamsConsumeStage r107 = new RoomParamsConsumeStage("CHANGE_PAGE_TO_FIRST", 7);
        CHANGE_PAGE_TO_FIRST = r107;
        RoomParamsConsumeStage r108 = new RoomParamsConsumeStage("PRE_DO_CHANGE_PAGE", 8);
        PRE_DO_CHANGE_PAGE = r108;
        RoomParamsConsumeStage r109 = new RoomParamsConsumeStage("POST_DO_CHANGE_PAGE", 9);
        POST_DO_CHANGE_PAGE = r109;
        RoomParamsConsumeStage r110 = new RoomParamsConsumeStage("PLAY_FRAGMENT_CREATE", 10);
        PLAY_FRAGMENT_CREATE = r110;
        RoomParamsConsumeStage r111 = new RoomParamsConsumeStage("LIVEROOM_DESTROY", 11);
        LIVEROOM_DESTROY = r111;
        f154367a = new RoomParamsConsumeStage[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public static RoomParamsConsumeStage valueOf(String r100) {
        return (RoomParamsConsumeStage) a.a(RoomParamsConsumeStage.class, r100);
    }

    public static RoomParamsConsumeStage[] values() {
        return (RoomParamsConsumeStage[]) f154367a.clone();
    }

    public RoomParamsConsumeStage(String r100, int r101) {
        super(r100, r101);
    }
}
