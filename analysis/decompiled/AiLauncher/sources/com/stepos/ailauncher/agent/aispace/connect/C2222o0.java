package com.stepos.ailauncher.agent.aispace.connect;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/o0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "deviceId", "agentType", "deviceName", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2222o0 {
    public static final C2222o0 INSTANCE = new C2222o0();

    public final Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void b(Context context, String deviceId, String agentType, String deviceName) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(deviceName, "deviceName");
        Activity activityA = a(context);
        com.stepos.ailauncher.sheet.S s10 = activityA instanceof com.stepos.ailauncher.sheet.S ? (com.stepos.ailauncher.sheet.S) activityA : null;
        if (!DesktopChatResidentController.M0(agentType, deviceId, deviceName)) {
            com.stepos.ailauncher.container.l0.INSTANCE.f();
            C2739j.z(context, null, SheetHeightMode.FULL_9, null, agentType, deviceId, deviceName, 10, null);
        }
        if (s10 != null) {
            s10.g1();
        }
    }
}
