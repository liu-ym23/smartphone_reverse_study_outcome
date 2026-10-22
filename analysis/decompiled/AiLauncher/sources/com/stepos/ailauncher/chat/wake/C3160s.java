package com.stepos.ailauncher.chat.wake;

import android.app.KeyguardManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Set;
import k5.C4814a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/s;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "lockScreenAllowedSources", "Ljava/util/Set;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3160s implements N1 {
    public static final C3160s INSTANCE = new C3160s();
    private static final String name = "Keyguard";
    private static final Set<String> lockScreenAllowedSources = Z8.Y.j("voice_wakeup", "ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_LONG_CLICK_START, C4814a.HEADSET_WAKEUP);

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            return true;
        }
        com.stepos.ailauncher.chat.lockscreen.C c10 = com.stepos.ailauncher.chat.lockscreen.C.INSTANCE;
        if (c10.d(source)) {
            C4148a.d("WakeGuard", "Keyguard: locked SystemUI entry source=" + source + ", run dedicated auth", false, 4, null);
            if (A.INSTANCE.d(context)) {
                c10.a(context, source);
            }
            return false;
        }
        if (source == null || !lockScreenAllowedSources.contains(source)) {
            C4148a.d("WakeGuard", "Keyguard: locked, source=" + source + " deny", false, 4, null);
            return false;
        }
        C4148a.d("WakeGuard", "Keyguard: locked but source=" + source + " whitelisted, allow", false, 4, null);
        return true;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
