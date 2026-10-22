package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import k5.C4814a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/j;", "", "<init>", "()V", "", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "listening", "manualVoice", "listenStartPending", Const.INTENT_KEY_PKGNAME, "(ZZZZ)Z", "", "wakeSource", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "seenNotAnswered", "answeredNow", "voiceActive", "Lcom/stepos/ailauncher/chat/wake/i;", Const.INTENT_KEY_APIKEY, "(ZZZ)Lcom/stepos/ailauncher/chat/wake/i;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3134j {
    public static final C3134j INSTANCE = new C3134j();

    public static /* synthetic */ boolean c(C3134j c3134j, boolean z10, boolean z11, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z13 = false;
        }
        return c3134j.b(z10, z11, z12, z13);
    }

    public final AnsweredCallEdge a(boolean seenNotAnswered, boolean answeredNow, boolean voiceActive) {
        return new AnsweredCallEdge(seenNotAnswered && answeredNow && voiceActive, true ^ answeredNow);
    }

    public final boolean b(boolean recording, boolean listening, boolean manualVoice, boolean listenStartPending) {
        return recording || listening || manualVoice || listenStartPending;
    }

    public final boolean d(String wakeSource) {
        return C4814a.INSTANCE.c(wakeSource);
    }
}
