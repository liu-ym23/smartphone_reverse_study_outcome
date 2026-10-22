package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a)\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aG\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "", "c", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Z", "floatingWake", "callUiCovering", Const.INTENT_KEY_PKGNAME, "(ZZ)Z", "", "layerIndex", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", Const.INTENT_KEY_APIKEY, "(ILcom/stepos/ailauncher/sheet/SheetSettleState;)Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "circleSelectActive", "wakeFloating", "minify", "e", "(ZZZ)Z", "lockScreenMode", "holdToTalk", "Lcom/stepos/ailauncher/chat/activity/ChatScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "overlayOpen", Const.INTENT_KEY_UMID, "(ZZZZLcom/stepos/ailauncher/chat/activity/ChatScene;Z)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G0 {
    public static final SheetExitAnim a(int i10, SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        return i10 > 1 ? SheetExitAnim.SLIDE_DOWN : c(state) ? SheetExitAnim.NONE : SheetExitAnim.SPRING_SCALE_DOWN;
    }

    public static final boolean b(boolean z10, boolean z11) {
        return z10 && z11;
    }

    public static final boolean c(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        return state == SheetSettleState.MINIFY;
    }

    public static final boolean d(boolean z10, boolean z11, boolean z12, boolean z13, ChatScene scene, boolean z14) {
        kotlin.jvm.internal.p.i(scene, "scene");
        if (z10 || z13) {
            return false;
        }
        if ((z11 || z12) && !scene.isHomeFollowing()) {
            return (scene == ChatScene.DESKTOP && z14) ? false : true;
        }
        return false;
    }

    public static final boolean e(boolean z10, boolean z11, boolean z12) {
        if (z10) {
            return z11 || z12;
        }
        return false;
    }
}
