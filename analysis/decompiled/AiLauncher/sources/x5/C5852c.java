package x5;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "nowMs", "lastAcceptedMs", "", Const.INTENT_KEY_APIKEY, "(JJ)Z", "VOICE_WAKE_DUPLICATE_WINDOW_MS", "J", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: x5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5852c {
    public static final long VOICE_WAKE_DUPLICATE_WINDOW_MS = 500;

    public static final boolean a(long j10, long j11) {
        if (j11 == 0) {
            return false;
        }
        long j12 = j10 - j11;
        return 0 <= j12 && j12 < 500;
    }
}
