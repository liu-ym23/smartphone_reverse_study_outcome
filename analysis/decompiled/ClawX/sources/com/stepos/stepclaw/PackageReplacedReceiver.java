package com.stepos.stepclaw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/PackageReplacedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lb5/a0;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PackageReplacedReceiver extends BroadcastReceiver {
    private static final String TAG = "PackageReplacedReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p.e(context, "context");
        p.e(intent, "intent");
        if (p.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            Log.i(TAG, "Package replaced, requesting GatewayForegroundService start");
            UserSetupCompletionGate userSetupCompletionGate = UserSetupCompletionGate.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            p.d(applicationContext, "getApplicationContext(...)");
            userSetupCompletionGate.startGatewayWhenComplete(applicationContext, "package_replaced");
        }
    }
}
