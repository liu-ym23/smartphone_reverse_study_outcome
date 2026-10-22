package com.stepos.ailauncher.contract.api.homegesture;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilityContract;", "", "<init>", "()V", "PROTOCOL_VERSION", "", "AUTHORITY", "", "PATH_HOME_GESTURE_ELIGIBLE", "URI_HOME_GESTURE_ELIGIBLE", "Landroid/net/Uri;", "getURI_HOME_GESTURE_ELIGIBLE", "()Landroid/net/Uri;", "METHOD_HOME_GESTURE_ELIGIBLE", "ACTION_HOME_ELIGIBILITY_CHANGED", "ACTION_CONSUME_HOME_GESTURE", "ACTION_DISMISS_DESKTOP_CHAT", "EXTRA_PROTOCOL_VERSION", "EXTRA_GENERATION", "EXTRA_CONSUMABLE", "EXTRA_SCENE", "EXTRA_ACTION", "EXTRA_TASK_ID", "EXTRA_REASON", "EXTRA_UPDATED_AT_ELAPSED", "SCENE_NONE", "SCENE_DESKTOP", "SCENE_BOARD", "SCENE_HOME_OVERLAY", "ACTION_NONE", "ACTION_DISMISS", "ACTION_OPEN_DESKTOP", "ACTION_COLLAPSE_OVERLAY", "ACTION_NO_OP", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeGestureEligibilityContract {
    public static final int ACTION_COLLAPSE_OVERLAY = 3;
    public static final String ACTION_CONSUME_HOME_GESTURE = "com.stepos.ailauncher.action.CONSUME_HOME_GESTURE";
    public static final int ACTION_DISMISS = 1;
    public static final String ACTION_DISMISS_DESKTOP_CHAT = "com.stepos.ailauncher.action.DISMISS_DESKTOP_CHAT";
    public static final String ACTION_HOME_ELIGIBILITY_CHANGED = "com.stepos.ailauncher.action.HOME_ELIGIBILITY_CHANGED";
    public static final int ACTION_NONE = 0;
    public static final int ACTION_NO_OP = 4;
    public static final int ACTION_OPEN_DESKTOP = 2;
    public static final String AUTHORITY = "com.stepos.ailauncher.state.provider";
    public static final String EXTRA_ACTION = "action";
    public static final String EXTRA_CONSUMABLE = "consumable";
    public static final String EXTRA_GENERATION = "generation";
    public static final String EXTRA_PROTOCOL_VERSION = "protocol_version";
    public static final String EXTRA_REASON = "reason";
    public static final String EXTRA_SCENE = "scene";
    public static final String EXTRA_TASK_ID = "task_id";
    public static final String EXTRA_UPDATED_AT_ELAPSED = "updated_at_elapsed";
    public static final HomeGestureEligibilityContract INSTANCE = new HomeGestureEligibilityContract();
    public static final String METHOD_HOME_GESTURE_ELIGIBLE = "home_gesture_eligible";
    public static final String PATH_HOME_GESTURE_ELIGIBLE = "home_gesture_eligible";
    public static final int PROTOCOL_VERSION = 1;
    public static final int SCENE_BOARD = 2;
    public static final int SCENE_DESKTOP = 1;
    public static final int SCENE_HOME_OVERLAY = 3;
    public static final int SCENE_NONE = 0;
    private static final Uri URI_HOME_GESTURE_ELIGIBLE;

    static {
        Uri uri = Uri.parse("content://com.stepos.ailauncher.state.provider/home_gesture_eligible");
        p.h(uri, "parse(...)");
        URI_HOME_GESTURE_ELIGIBLE = uri;
    }

    private HomeGestureEligibilityContract() {
    }

    public final Uri getURI_HOME_GESTURE_ELIGIBLE() {
        return URI_HOME_GESTURE_ELIGIBLE;
    }
}
