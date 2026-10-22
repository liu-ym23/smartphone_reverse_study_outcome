package com.stepos.ailauncher.chat.media;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/media/f;", "", "<init>", "()V", "", "reason", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "", "coverAgeMs", Const.INTENT_KEY_APIKEY, "(J)Z", "SYSTEM_DIALOG_REASON_SCREENSHOT", "Ljava/lang/String;", "COVER_GRACE_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    private static final long COVER_GRACE_MS = 1200;
    public static final f INSTANCE = new f();
    private static final String SYSTEM_DIALOG_REASON_SCREENSHOT = "screenshot";

    public final boolean a(long coverAgeMs) {
        return coverAgeMs >= 1200;
    }

    public final boolean b(String reason) {
        return D.L(SYSTEM_DIALOG_REASON_SCREENSHOT, reason, true);
    }
}
