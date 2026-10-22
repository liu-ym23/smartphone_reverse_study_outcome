package com.stepos.ailauncher.chat.media;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "saved", Const.INTENT_KEY_APIKEY, "(I)I", "usage", "", Const.INTENT_KEY_PKGNAME, "(I)Z", "c", "hasNewMovie", "hasNewLongMedia", "hasAlertPlayback", "Lcom/stepos/ailauncher/chat/media/TtsNewPlaybackGuard;", Const.INTENT_KEY_UMID, "(ZZZ)Lcom/stepos/ailauncher/chat/media/TtsNewPlaybackGuard;", "", "ALARM_DUCK_RATIO", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    public static final float ALARM_DUCK_RATIO = 0.3f;

    public static final int a(int i10) {
        return i10 <= 1 ? i10 : C5685n.n(C5227b.b(i10 * 0.3f), 1, i10 - 1);
    }

    public static final boolean b(int i10) {
        return i10 == 4;
    }

    public static final boolean c(int i10) {
        return i10 == 6 || i10 == 7 || i10 == 3;
    }

    public static final TtsNewPlaybackGuard d(boolean z10, boolean z11, boolean z12) {
        return z10 ? TtsNewPlaybackGuard.STOP : (!z11 || z12) ? TtsNewPlaybackGuard.IGNORE : TtsNewPlaybackGuard.DUCK;
    }
}
