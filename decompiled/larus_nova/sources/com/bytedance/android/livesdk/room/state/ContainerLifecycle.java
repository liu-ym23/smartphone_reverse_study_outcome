package com.bytedance.android.livesdk.room.state;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b&\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/room/state/ContainerLifecycle;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "ON_CREATE_VIEW", "ON_VIEW_CREATE", "ON_ATTACH", "ON_ACTIVITY_CREATED", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY_VIEW", "ON_BEFORE_DESTROY", "ON_DESTROY", "ON_ROOM_DATA_CHANGED", "ON_CONFIGURATION_CHANGED", "TRY_USER_CLOSE", "ON_JUMP_OTHER_ROOM", "ON_PICTURE_IN_PICTURE_MODE_CHANGED", "ON_BACK_PRESSED", "ON_SET_USER_VISIBLE_HINT", "ON_SAVE_INSTANCE_STATE", "ON_PAGE_SCROLL_STATE_CHANGED_CALL_BACK", "ON_PAGE_SELECTED", "ON_CURRENT_PAGE_SELECTED", "ON_DRAWER_OPENED", "ON_DRAWER_CLOSE", "ROOM_DISPOSE_CONTEXT", "ON_STOP_ROOM_WITHOUT_RELEASE_PLAYER", "ON_VIEW_MODULE_PREPARED", "ON_INTERACTION_CREATE", "ON_BEFORE_INTERACTION_COMMIT", "ON_AFTER_INTERACTION_COMMIT", "ON_BEFORE_INTERACTION_REMOVED", "ON_AFTER_INTERACTION_REMOVE", "ON_INTERACTION_UPDATE_ROOM", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerLifecycle extends Enum<ContainerLifecycle> {
    public static final ContainerLifecycle ON_ACTIVITY_CREATED = null;
    public static final ContainerLifecycle ON_AFTER_INTERACTION_COMMIT = null;
    public static final ContainerLifecycle ON_AFTER_INTERACTION_REMOVE = null;
    public static final ContainerLifecycle ON_ATTACH = null;
    public static final ContainerLifecycle ON_BACK_PRESSED = null;
    public static final ContainerLifecycle ON_BEFORE_DESTROY = null;
    public static final ContainerLifecycle ON_BEFORE_INTERACTION_COMMIT = null;
    public static final ContainerLifecycle ON_BEFORE_INTERACTION_REMOVED = null;
    public static final ContainerLifecycle ON_CONFIGURATION_CHANGED = null;
    public static final ContainerLifecycle ON_CREATE_VIEW = null;
    public static final ContainerLifecycle ON_CURRENT_PAGE_SELECTED = null;
    public static final ContainerLifecycle ON_DESTROY = null;
    public static final ContainerLifecycle ON_DESTROY_VIEW = null;
    public static final ContainerLifecycle ON_DRAWER_CLOSE = null;
    public static final ContainerLifecycle ON_DRAWER_OPENED = null;
    public static final ContainerLifecycle ON_INTERACTION_CREATE = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "临时兼容旧的代码，该方法不建议使用，请使用 enterRoomV2 来替代", replaceWith = @ReplaceWith(expression = "enterRoomV2", imports = {}))
    public static final ContainerLifecycle ON_INTERACTION_UPDATE_ROOM = null;
    public static final ContainerLifecycle ON_JUMP_OTHER_ROOM = null;
    public static final ContainerLifecycle ON_PAGE_SCROLL_STATE_CHANGED_CALL_BACK = null;
    public static final ContainerLifecycle ON_PAGE_SELECTED = null;
    public static final ContainerLifecycle ON_PAUSE = null;
    public static final ContainerLifecycle ON_PICTURE_IN_PICTURE_MODE_CHANGED = null;
    public static final ContainerLifecycle ON_RESUME = null;
    public static final ContainerLifecycle ON_ROOM_DATA_CHANGED = null;
    public static final ContainerLifecycle ON_SAVE_INSTANCE_STATE = null;
    public static final ContainerLifecycle ON_SET_USER_VISIBLE_HINT = null;
    public static final ContainerLifecycle ON_START = null;
    public static final ContainerLifecycle ON_STOP = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法不建议使用，请使用 exitRoom 来替代", replaceWith = @ReplaceWith(expression = "exitRoom", imports = {}))
    public static final ContainerLifecycle ON_STOP_ROOM_WITHOUT_RELEASE_PLAYER = null;
    public static final ContainerLifecycle ON_VIEW_CREATE = null;
    public static final ContainerLifecycle ON_VIEW_MODULE_PREPARED = null;

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法不建议使用，请使用 exitRoom 来替代", replaceWith = @ReplaceWith(expression = "exitRoom", imports = {}))
    public static final ContainerLifecycle ROOM_DISPOSE_CONTEXT = null;
    public static final ContainerLifecycle TRY_USER_CLOSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerLifecycle[] f157815a = null;
    private final String des;

    public static ContainerLifecycle valueOf(String r100) {
        return (ContainerLifecycle) a.a(ContainerLifecycle.class, r100);
    }

    public static ContainerLifecycle[] values() {
        return (ContainerLifecycle[]) f157815a.clone();
    }

    static {
        ContainerLifecycle r100 = new ContainerLifecycle("ON_CREATE_VIEW", 0, "fragment->onCreateView");
        ON_CREATE_VIEW = r100;
        ContainerLifecycle r101 = new ContainerLifecycle("ON_VIEW_CREATE", 1, "fragment->onViewCreate");
        ON_VIEW_CREATE = r101;
        ContainerLifecycle r102 = new ContainerLifecycle("ON_ATTACH", 2, "fragment->onAttach");
        ON_ATTACH = r102;
        ContainerLifecycle r103 = new ContainerLifecycle("ON_ACTIVITY_CREATED", 3, "fragment->onActivityCreated");
        ON_ACTIVITY_CREATED = r103;
        ContainerLifecycle r104 = new ContainerLifecycle("ON_START", 4, "fragment->onStart");
        ON_START = r104;
        ContainerLifecycle r105 = new ContainerLifecycle("ON_RESUME", 5, "fragment->onResume");
        ON_RESUME = r105;
        ContainerLifecycle r106 = new ContainerLifecycle("ON_PAUSE", 6, "fragment->onPause");
        ON_PAUSE = r106;
        ContainerLifecycle r107 = new ContainerLifecycle("ON_STOP", 7, "fragment->onStop");
        ON_STOP = r107;
        ContainerLifecycle r108 = new ContainerLifecycle("ON_DESTROY_VIEW", 8, "fragment->onDestroyView");
        ON_DESTROY_VIEW = r108;
        ContainerLifecycle r109 = new ContainerLifecycle("ON_BEFORE_DESTROY", 9, "fragment->onBeforeDestroy");
        ON_BEFORE_DESTROY = r109;
        ContainerLifecycle r110 = new ContainerLifecycle("ON_DESTROY", 10, "fragment->onDestroy");
        ON_DESTROY = r110;
        ContainerLifecycle r111 = new ContainerLifecycle("ON_ROOM_DATA_CHANGED", 11, "viewpager->notifyDataSetChanged");
        ON_ROOM_DATA_CHANGED = r111;
        ContainerLifecycle r112 = new ContainerLifecycle("ON_CONFIGURATION_CHANGED", 12, "fragment->onConfigurationChanged");
        ON_CONFIGURATION_CHANGED = r112;
        ContainerLifecycle r113 = new ContainerLifecycle("TRY_USER_CLOSE", 13, "fragment->tryUserClose");
        TRY_USER_CLOSE = r113;
        ContainerLifecycle r114 = new ContainerLifecycle("ON_JUMP_OTHER_ROOM", 14, "fragment->jump2Other");
        ON_JUMP_OTHER_ROOM = r114;
        ContainerLifecycle r115 = new ContainerLifecycle("ON_PICTURE_IN_PICTURE_MODE_CHANGED", 15, "fragment->onPictureInPictureModeChanged");
        ON_PICTURE_IN_PICTURE_MODE_CHANGED = r115;
        ContainerLifecycle r116 = new ContainerLifecycle("ON_BACK_PRESSED", 16, "activity->onBackPressed");
        ON_BACK_PRESSED = r116;
        ContainerLifecycle r117 = new ContainerLifecycle("ON_SET_USER_VISIBLE_HINT", 17, "fragment->setUserVisibleHint");
        ON_SET_USER_VISIBLE_HINT = r117;
        ContainerLifecycle r118 = new ContainerLifecycle("ON_SAVE_INSTANCE_STATE", 18, "activity->onSaveInstanceState");
        ON_SAVE_INSTANCE_STATE = r118;
        ContainerLifecycle r119 = new ContainerLifecycle("ON_PAGE_SCROLL_STATE_CHANGED_CALL_BACK", 19, "roomFragment->onPageScrollStateChanged");
        ON_PAGE_SCROLL_STATE_CHANGED_CALL_BACK = r119;
        ContainerLifecycle r120 = new ContainerLifecycle("ON_PAGE_SELECTED", 20, "roomFragment->onPageSelect");
        ON_PAGE_SELECTED = r120;
        ContainerLifecycle r121 = new ContainerLifecycle("ON_CURRENT_PAGE_SELECTED", 21, "playFragment->onSelect");
        ON_CURRENT_PAGE_SELECTED = r121;
        ContainerLifecycle r122 = new ContainerLifecycle("ON_DRAWER_OPENED", 22, "直播侧滑打开");
        ON_DRAWER_OPENED = r122;
        ContainerLifecycle r123 = new ContainerLifecycle("ON_DRAWER_CLOSE", 23, "直播侧滑关闭");
        ON_DRAWER_CLOSE = r123;
        ContainerLifecycle r124 = new ContainerLifecycle("ROOM_DISPOSE_CONTEXT", 24, "LivePlayFragment->disposeContext");
        ROOM_DISPOSE_CONTEXT = r124;
        ContainerLifecycle r125 = new ContainerLifecycle("ON_STOP_ROOM_WITHOUT_RELEASE_PLAYER", 25, "LivePlayFragment->stopRoomWithoutReleasePlayer");
        ON_STOP_ROOM_WITHOUT_RELEASE_PLAYER = r125;
        ContainerLifecycle r126 = new ContainerLifecycle("ON_VIEW_MODULE_PREPARED", 26, "OnViewModulePrepared");
        ON_VIEW_MODULE_PREPARED = r126;
        ContainerLifecycle r127 = new ContainerLifecycle("ON_INTERACTION_CREATE", 27, "OnInteractionCrteate");
        ON_INTERACTION_CREATE = r127;
        ContainerLifecycle r128 = new ContainerLifecycle("ON_BEFORE_INTERACTION_COMMIT", 28, "OnBeforeInteractionCommit");
        ON_BEFORE_INTERACTION_COMMIT = r128;
        ContainerLifecycle r129 = new ContainerLifecycle("ON_AFTER_INTERACTION_COMMIT", 29, "OnAfterInteractionCommit");
        ON_AFTER_INTERACTION_COMMIT = r129;
        ContainerLifecycle r130 = new ContainerLifecycle("ON_BEFORE_INTERACTION_REMOVED", 30, "OnBeforeInteractionRemove");
        ON_BEFORE_INTERACTION_REMOVED = r130;
        ContainerLifecycle r131 = new ContainerLifecycle("ON_AFTER_INTERACTION_REMOVE", 31, "OnAfterInteractioRemove");
        ON_AFTER_INTERACTION_REMOVE = r131;
        ContainerLifecycle r132 = new ContainerLifecycle("ON_INTERACTION_UPDATE_ROOM", 32, "setRoom");
        ON_INTERACTION_UPDATE_ROOM = r132;
        f157815a = new ContainerLifecycle[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132};
    }

    public final String getDes() {
        return this.des;
    }

    public ContainerLifecycle(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
