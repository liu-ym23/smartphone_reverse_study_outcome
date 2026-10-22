package com.bytedance.android.live.broadcastgame.common.ui;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.interactgame.h;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.common.BottomConfirmAlertDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/common/ui/GameExitConformDialog;", "Lcom/bytedance/android/livesdk/common/BottomConfirmAlertDialog;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameExitConformDialog extends BottomConfirmAlertDialog implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59581d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.common.BottomConfirmAlertDialog, com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_bottom_confirm;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        ALogger.i("GameExitConformDialog", "show exit dialog from " + this.f59581d);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public GameExitConformDialog(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "from");
        super(r100, s1.B(R.string.ttlive_game_exit_conform_dialog_title), s1.B(R.string.ttlive_game_exit_conform_dialog_exit), s1.B(R.string.ttlive_game_exit_conform_dialog_cancel));
        this.f59581d = r101;
    }
}
