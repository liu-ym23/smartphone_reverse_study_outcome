package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/m;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", x5.d.EXTRA_ENABLED, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Z)V", "", "KEY_AMOO_SPACE_ENABLED", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2708m {
    public static final C2708m INSTANCE = new C2708m();
    public static final String KEY_AMOO_SPACE_ENABLED = "amoo_space_enabled";

    public final boolean a() {
        return C5009a.g(C5009a.INSTANCE, KEY_AMOO_SPACE_ENABLED, true, false, 4, null);
    }

    public final void b(boolean enabled) {
        C5009a.y(C5009a.INSTANCE, KEY_AMOO_SPACE_ENABLED, enabled, false, 4, null);
    }
}
