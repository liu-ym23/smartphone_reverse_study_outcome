package com.stepos.ailauncher.chat.wake;

import android.app.ActivityManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/B;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B implements N1 {
    public static final B INSTANCE = new B();
    private static final String name = "LockTask";

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        int lockTaskModeState = activityManager != null ? activityManager.getLockTaskModeState() : 0;
        if (lockTaskModeState == 0) {
            return true;
        }
        C4148a.d("WakeGuard", "LockTask: state=" + lockTaskModeState + ", deny source=" + source, false, 4, null);
        if (Q1.g(source)) {
            com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
            String string = context.getString(R$string.lock_task_ai_disabled);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            com.stepos.ailauncher.chat.lockscreen.H.k(h10, context, string, 0L, 4, null);
        }
        return false;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
