package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u000f\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\r\u001a?\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010!\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0000¢\u0006\u0004\b!\u0010\n\u001a\u001f\u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/activity/ChatScene;)Z", Const.INTENT_KEY_UMID, "userDismissed", "boardPresent", "pendingRestoreThirdParty", "f", "(ZZZ)Z", "boardHomeExitRunning", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)Z", "isLockScreenScene", "finishing", "destroyed", "resumed", RobotInfo.STATUS_STARTED, "overlayOpen", Const.INTENT_KEY_PKGNAME, "(ZZZZZZ)Z", "", "taskId", "overlayOpenAtPeek", "minusOneSheetCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(IZZI)Z", "coverUi", "c", "(ZZI)Z", "overlayOpenNow", "peekIdleFromExplicitWake", Const.INTENT_KEY_BACKGROUND_COMMAND, "recentsIsOverview", "e", "(ZZ)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2732c {
    public static final boolean a(ChatScene scene) {
        kotlin.jvm.internal.p.i(scene, "scene");
        return scene.isStandaloneTask() && !scene.isLockScreen();
    }

    public static final boolean b(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return (z11 || z12 || z10) ? false : true;
    }

    public static final boolean c(boolean z10, boolean z11, int i10) {
        return (z10 || z11 || i10 > 0) ? false : true;
    }

    public static final boolean d(ChatScene scene) {
        kotlin.jvm.internal.p.i(scene, "scene");
        return scene == ChatScene.BOARD || scene == ChatScene.TRANSIENT;
    }

    public static final boolean e(boolean z10, boolean z11) {
        return (z10 || z11) ? false : true;
    }

    public static final boolean f(boolean z10, boolean z11, boolean z12) {
        return (!z10 || z11 || z12) ? false : true;
    }

    public static final boolean g(boolean z10, boolean z11, boolean z12) {
        return (!z10 || z11 || z12) ? false : true;
    }

    public static final boolean h(boolean z10) {
        return !z10;
    }

    public static final boolean i(int i10, boolean z10, boolean z11, int i11) {
        return i10 > 0 && !z10 && !z11 && i11 <= 0;
    }
}
