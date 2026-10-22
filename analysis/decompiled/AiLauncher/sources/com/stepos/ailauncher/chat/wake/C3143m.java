package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import h8.C4148a;
import java.util.Set;
import k5.C4814a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/m;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "blockedSources", "Ljava/util/Set;", "dismissSources", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3143m implements N1 {
    public static final C3143m INSTANCE = new C3143m();
    private static final String name = "CircleSelectActive";
    private static final Set<String> blockedSources = Z8.Y.j(C4814a.HEADSET_WAKEUP, "voice_wakeup");
    private static final Set<String> dismissSources = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK);

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        if (source != null) {
            CircleSelectController.Companion companion = CircleSelectController.INSTANCE;
            if (companion.d()) {
                if (C3146n.INSTANCE.a(source, true, companion.g())) {
                    C4148a.d("WakeGuard", "CircleSelectActive: suppressed source=" + source + " (circle interaction)", false, 4, null);
                    return false;
                }
                if (blockedSources.contains(source)) {
                    if (companion.f()) {
                        C4148a.d("WakeGuard", "CircleSelectActive: suppressed source=" + source + " (stroke in progress)", false, 4, null);
                        return false;
                    }
                    C4148a.d("WakeGuard", "CircleSelectActive: dismissing circle select for source=" + source + " (not drawing)", false, 4, null);
                    InterfaceC5063a<Y8.t> interfaceC5063aB = companion.b();
                    if (interfaceC5063aB != null) {
                        interfaceC5063aB.invoke();
                    }
                    return true;
                }
                if (dismissSources.contains(source)) {
                    C4148a.d("WakeGuard", "CircleSelectActive: dismissing circle select for source=" + source, false, 4, null);
                    InterfaceC5063a<Y8.t> interfaceC5063aB2 = companion.b();
                    if (interfaceC5063aB2 != null) {
                        interfaceC5063aB2.invoke();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
