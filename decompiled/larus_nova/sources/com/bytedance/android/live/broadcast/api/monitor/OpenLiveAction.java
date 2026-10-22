package com.bytedance.android.live.broadcast.api.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/monitor/OpenLiveAction;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CLICK_LIVE_BUTTON", "PERMISSION_DIALOG_SHOW", "PERMISSION_DIALOG_HIDE", "START_ACTIVITY", "SHELL_FRAGMENT_CREATE", "SUB_SHELL_FRAGMENT_CREATE", "SHOW_INTERACTION_START", "SHOW_INTERACTION_END", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenLiveAction extends Enum<OpenLiveAction> {
    public static final OpenLiveAction CLICK_LIVE_BUTTON = null;
    public static final OpenLiveAction PERMISSION_DIALOG_HIDE = null;
    public static final OpenLiveAction PERMISSION_DIALOG_SHOW = null;
    public static final OpenLiveAction SHELL_FRAGMENT_CREATE = null;
    public static final OpenLiveAction SHOW_INTERACTION_END = null;
    public static final OpenLiveAction SHOW_INTERACTION_START = null;
    public static final OpenLiveAction START_ACTIVITY = null;
    public static final OpenLiveAction SUB_SHELL_FRAGMENT_CREATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenLiveAction[] f59058a = null;
    private final String value;

    public static OpenLiveAction valueOf(String r100) {
        return (OpenLiveAction) r27.a.a(OpenLiveAction.class, r100);
    }

    public static OpenLiveAction[] values() {
        return (OpenLiveAction[]) f59058a.clone();
    }

    static {
        OpenLiveAction r100 = new OpenLiveAction("CLICK_LIVE_BUTTON", 0, "click_live_button");
        CLICK_LIVE_BUTTON = r100;
        OpenLiveAction r101 = new OpenLiveAction("PERMISSION_DIALOG_SHOW", 1, "permission_dialog_show");
        PERMISSION_DIALOG_SHOW = r101;
        OpenLiveAction r102 = new OpenLiveAction("PERMISSION_DIALOG_HIDE", 2, "permission_dialog_hide");
        PERMISSION_DIALOG_HIDE = r102;
        OpenLiveAction r103 = new OpenLiveAction("START_ACTIVITY", 3, "start_activity");
        START_ACTIVITY = r103;
        OpenLiveAction r104 = new OpenLiveAction("SHELL_FRAGMENT_CREATE", 4, "shell_fragment_create");
        SHELL_FRAGMENT_CREATE = r104;
        OpenLiveAction r105 = new OpenLiveAction("SUB_SHELL_FRAGMENT_CREATE", 5, "sub_shell_fragment_create");
        SUB_SHELL_FRAGMENT_CREATE = r105;
        OpenLiveAction r106 = new OpenLiveAction("SHOW_INTERACTION_START", 6, "show_interaction_start");
        SHOW_INTERACTION_START = r106;
        OpenLiveAction r107 = new OpenLiveAction("SHOW_INTERACTION_END", 7, "show_interaction_end");
        SHOW_INTERACTION_END = r107;
        f59058a = new OpenLiveAction[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getValue() {
        return this.value;
    }

    public OpenLiveAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
