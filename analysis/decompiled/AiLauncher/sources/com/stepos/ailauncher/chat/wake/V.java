package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/V;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V implements N1 {
    public static final V INSTANCE = new V();
    private static final String name = "TempPowerLow";

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        TempPowerLowChecker tempPowerLowChecker = TempPowerLowChecker.INSTANCE;
        if (!tempPowerLowChecker.f()) {
            return true;
        }
        C4148a.d("WakeGuard", "TempPowerLow: restricted, deny source=" + source, false, 4, null);
        if (Q1.g(source)) {
            com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
            String string = context.getString(tempPowerLowChecker.j(tempPowerLowChecker.c()));
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
