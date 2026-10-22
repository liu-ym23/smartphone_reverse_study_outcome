package n7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.stepos.core.model.manager.i;
import java.util.Map;
import x7.b;
import y7.c;
import y7.d;
import y7.e;
import z7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b extends BroadcastReceiver implements z7.b {
    private final String tag = getClass().getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceive$0(Context context, Intent intent) {
        onHandleIntent(context.getApplicationContext(), intent);
    }

    private void onHandleIntent(Context context, Intent intent) {
        z7.a aVar = a.C0182a.f14277a;
        String str = aVar.f14275a;
        s7.a.b(str, "processMessage start");
        try {
            for (Map.Entry<String, b8.a<?>> entry : aVar.f14276b.entrySet()) {
                s7.a.a(str, "processMessage, method: " + entry.getKey());
                if (entry.getValue().e(context, intent, this)) {
                    return;
                }
            }
        } catch (Exception e10) {
            s7.a.c(str, "processMessage error " + e10.getMessage());
        }
    }

    public void onMessage(Context context, String str, String str2) {
        s7.a.b(this.tag, "onMessage, message: " + str + ", platformExtra: " + str2);
    }

    public void onNotificationArrived(Context context, u7.a aVar) {
        s7.a.b(this.tag, "onNotificationArrived, PushMessage: " + aVar);
    }

    public void onNotificationClicked(Context context, u7.a aVar) {
        s7.a.b(this.tag, "onNotificationClicked,  PushMessage: " + aVar);
    }

    public void onNotificationDeleted(Context context, u7.a aVar) {
        s7.a.b(this.tag, "onNotificationDeleted, PushMessage: " + aVar);
    }

    @Override // z7.b
    public void onPushStatus(Context context, y7.a aVar) {
        s7.a.b(this.tag, "onPushStatus, pushSwitchStatus: " + aVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        s7.a.b(this.tag, "onReceive intent: " + intent);
        b.a.f13758a.execute(new i(this, context, intent, 7));
    }

    public void onRegisterStatus(Context context, y7.b bVar) {
        s7.a.b(this.tag, "onRegisterStatus, registerStatus: " + bVar);
    }

    @Override // z7.b
    public void onSubAliasStatus(Context context, c cVar) {
        s7.a.b(this.tag, "onSubAliasStatus, subAliasStatus: " + cVar);
    }

    @Override // z7.b
    public void onSubTagsStatus(Context context, d dVar) {
        s7.a.b(this.tag, "onSubTagsStatus, subTagsStatus: " + dVar);
    }

    @Override // z7.b
    public void onUnRegisterStatus(Context context, e eVar) {
        s7.a.b(this.tag, "onUnRegisterStatus, unRegisterStatus: " + eVar);
    }
}
