package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/k7;", "", "<init>", "()V", "", "asrAvailable", "slaOnlyActive", Const.INTENT_KEY_APIKEY, "(ZZ)Z", "networkUsable", Const.INTENT_KEY_PKGNAME, "(Z)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.k7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2873k7 {
    public static final C2873k7 INSTANCE = new C2873k7();

    public final boolean a(boolean asrAvailable, boolean slaOnlyActive) {
        return (slaOnlyActive || asrAvailable) ? false : true;
    }

    public final boolean b(boolean networkUsable) {
        return !networkUsable;
    }
}
