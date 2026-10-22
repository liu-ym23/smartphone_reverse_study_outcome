package com.stepos.ailauncher.chat.wake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.wake.C3119f;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import h8.C4148a;
import k5.C4814a;

/* loaded from: classes3.dex */
public class StartBroadcastReceiver extends BroadcastReceiver {
    private static final String ACTION_AI_KEY_WAKE = "com.stepos.ailauncher.action.AI_KEY_WAKE";
    private static final String ACTION_CARD_SEND_TEXT = "com.stepos.ailauncher.action.CARD_SEND_TEXT";
    private static final String ACTION_DISMISS_WAKE = "com.stepos.ailauncher.action.DISMISS_WAKE";
    private static final String ACTION_HIDE_WAKE = "com.stepos.ailauncher.action.HIDE_WAKE";
    private static final String ACTION_OPEN_ALL_TASK = "com.stepos.ailauncher.action.OPEN_ALL_TASK";
    private static final String ACTION_OPEN_ALL_TASK_NOTIFY = "com.stepos.ailauncher.action.OPEN_ALL_TASK_NOTIFY";
    private static final String ACTION_SHOW_WAKE = "com.stepos.ailauncher.action.SHOW_WAKE";
    private static final String EXTRA_CARD_TEXT = "card_text";
    public static final String OOBE_COMPLETE_KEY = "oobe_complete";
    private static final String TAG = "StartBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3119f.a aVarA;
        if (C5.b.a(context, this, "wake_broadcast")) {
            String stringExtra = intent.getStringExtra(C4814a.PARAM_SOURCE);
            C4148a.b(TAG, "onReceive: intent->" + intent + ", params->" + intent.getExtras() + ", source=" + stringExtra);
            String action = intent.getAction();
            if ("com.stepos.ailauncher.action.OPEN_ALL_TASK".equals(action)) {
                C3127h.INSTANCE.c();
                if (AuthManager.INSTANCE.M(context, false)) {
                    ChatActivity.X8(context, SheetHeightMode.FULL_9);
                    return;
                }
                return;
            }
            if ("com.stepos.ailauncher.action.DISMISS_WAKE".equals(action)) {
                WakeService.INSTANCE.Z(context, intent.getBooleanExtra(N5.d.EXTRA_DISMISS_NO_ANIM, false));
                return;
            }
            if ("com.stepos.ailauncher.action.CARD_SEND_TEXT".equals(action)) {
                WakeService.INSTANCE.i1(context, intent.getStringExtra("card_text"));
                return;
            }
            if ("com.stepos.ailauncher.action.HIDE_WAKE".equals(action)) {
                WakeService.INSTANCE.E0(context);
                return;
            }
            if ("com.stepos.ailauncher.action.SHOW_WAKE".equals(action)) {
                WakeService.INSTANCE.x1(context);
                return;
            }
            if (ACTION_AI_KEY_WAKE.equals(action) && (aVarA = C3119f.INSTANCE.a()) != null && aVarA.a(intent)) {
                C4148a.b(TAG, "AI key consumed by OOBE bridge");
                return;
            }
            boolean zHasExtra = intent.hasExtra(OOBE_COMPLETE_KEY);
            int intExtra = intent.getIntExtra(OOBE_COMPLETE_KEY, 1);
            boolean z10 = intExtra == 0;
            C4148a.i(TAG, "event=wake_oobe_gate, action=" + action + ", source=" + stringExtra + ", extra_present=" + zHasExtra + ", oobe_complete=" + intExtra + ", blocked=" + z10);
            if (z10) {
                return;
            }
            WakeService.INSTANCE.J1(context, intent);
        }
    }
}
