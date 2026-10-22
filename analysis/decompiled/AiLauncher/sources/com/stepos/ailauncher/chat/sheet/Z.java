package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/Z;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_APIKEY, "hiddenForRecents", "landedOnThirdParty", "c", "(ZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    public static final Z INSTANCE = new Z();

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return true;
    }

    public final boolean c(boolean hiddenForRecents, boolean landedOnThirdParty) {
        return hiddenForRecents && landedOnThirdParty;
    }
}
