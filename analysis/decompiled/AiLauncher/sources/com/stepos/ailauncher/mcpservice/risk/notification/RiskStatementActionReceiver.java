package com.stepos.ailauncher.mcpservice.risk.notification;

import La.H;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.mcpservice.risk.f;
import com.stepos.ailauncher.mcpservice.risk.q;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/notification/RiskStatementActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Companion", Const.INTENT_KEY_APIKEY, "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RiskStatementActionReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.stepos.ailauncher.mcpservice.risk.ACTION_USER_CHOICE";
    public static final String EXTRA_BUTTON_ID = "extra_button_id";
    public static final String EXTRA_NOTIFICATION_ID = "extra_notification_id";
    public static final String EXTRA_REQUEST_ID = "extra_request_id";
    private static final String TAG = "RiskStatementActionRcv";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p.i(context, "context");
        p.i(intent, "intent");
        String stringExtra = intent.getStringExtra("extra_request_id");
        if (stringExtra == null || H.x0(stringExtra)) {
            C4148a.u(TAG, "missing requestId, ignore", false, 4, null);
            return;
        }
        String stringExtra2 = intent.getStringExtra(EXTRA_BUTTON_ID);
        int intExtra = intent.getIntExtra(EXTRA_NOTIFICATION_ID, -1);
        q chosen = (stringExtra2 == null || H.x0(stringExtra2)) ? q.a.INSTANCE : new q.Chosen(stringExtra2);
        C4148a.k(TAG, "notification action | requestId=" + stringExtra + ", buttonId=" + stringExtra2 + ", notificationId=" + intExtra + ", result=" + chosen, false, 4, null);
        f.INSTANCE.d(stringExtra, chosen);
        if (intExtra > 0) {
            Object systemService = context.getSystemService("notification");
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                notificationManager.cancel(intExtra);
            }
        }
    }
}
