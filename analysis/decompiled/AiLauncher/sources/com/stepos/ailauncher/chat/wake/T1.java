package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/T1;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", x5.d.EXTRA_ENABLED, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Z)V", "", "TAG", "Ljava/lang/String;", "KEY_ROUTE_WAKE_TO_CHAT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T1 {
    public static final T1 INSTANCE = new T1();
    private static final String KEY_ROUTE_WAKE_TO_CHAT = "wake_routing_route_wake_to_chat";
    private static final String TAG = "WakeRoutingConfig";

    public final boolean a() {
        return C5009a.g(C5009a.INSTANCE, KEY_ROUTE_WAKE_TO_CHAT, true, false, 4, null);
    }

    public final void b(boolean enabled) {
        C5009a.y(C5009a.INSTANCE, KEY_ROUTE_WAKE_TO_CHAT, enabled, false, 4, null);
        C4148a.k(TAG, "setRouteWakeToChatEnabled enabled=" + enabled, false, 4, null);
    }
}
