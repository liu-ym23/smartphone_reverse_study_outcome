package com.bytedance.android.livesdk.action;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.ov0;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes7.dex */
public class DebugUtils {
    public static final String TAG = "LiveAction";
    private static boolean debug;

    static {
        LocalTestManager.a(new Class[]{wy.a.class});
        debug = false;
    }

    public DebugUtils() {
    }

    public static /* synthetic */ void a(DialogInterface r100, int r101) {
        lambda$showDebugInfoDialog$0(r100, r101);
    }

    public static void i(String r100) {
    }

    public static boolean canShowUIDebugDialog() {
        if (v.a() == true) goto L5;
    L9:
        return false;
    L5:
        if (jc1.a.c() == false) goto L9;
        if (ov0.f120935a.getValue().booleanValue() == false) goto L9;
        return true;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_action_DebugUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(x0 r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    private static /* synthetic */ void lambda$showDebugInfoDialog$0(DialogInterface r100, int r101) {
        r100.dismiss();
    }

    public static void showDebugInfoDialog(Context r100, String r101, String r102) {
        x0.d r103 = new x0.d();
        r103.f162243b = r100;
        r103.f162242a = 0;
        r103.f162244c = r101;
        r103.f162245d = r102;
        DialogInterface.OnClickListener r104 = new a();
        x0.c[] r105 = r103.f162248g;
        x0.c r106 = r105[2];
        if (r106 != null) goto L5;
        r106 = new x0.c();
        r105[2] = r106;
    L5:
        r106.f162239a = "确定";
        r106.f162240b = r104;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_action_DebugUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new x0(r103.f162243b, r103));
    }
}
