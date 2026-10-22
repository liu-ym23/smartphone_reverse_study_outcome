package com.stepos.ailauncher.speech.asr;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/b;", "", "<init>", "()V", "", "vibratedAtMs", Const.INTENT_KEY_PKGNAME, "(J)J", "nowMs", "skipUntilMs", "", Const.INTENT_KEY_APIKEY, "(JJ)Z", "SKIP_MS", "J", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    public static final long SKIP_MS = 80;

    public final boolean a(long nowMs, long skipUntilMs) {
        return skipUntilMs > 0 && nowMs < skipUntilMs;
    }

    public final long b(long vibratedAtMs) {
        return vibratedAtMs + 80;
    }
}
