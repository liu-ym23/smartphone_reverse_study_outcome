package com.stepos.agentframework.chatcore.audit;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/RevertedSessionGuard;", "", "<init>", "()V", "", "sessionId", "LY8/t;", "c", "(Ljava/lang/String;)V", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "TAG", "Ljava/lang/String;", "", "CAPACITY", "I", "com/stepos/agentframework/chatcore/audit/RevertedSessionGuard$sessions$1", "sessions", "Lcom/stepos/agentframework/chatcore/audit/RevertedSessionGuard$sessions$1;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RevertedSessionGuard {
    private static final int CAPACITY = 64;
    private static final String TAG = "RevertedSessionGuard";
    public static final RevertedSessionGuard INSTANCE = new RevertedSessionGuard();
    private static final RevertedSessionGuard$sessions$1 sessions = new RevertedSessionGuard$sessions$1();

    public final boolean a(String sessionId) {
        boolean zContainsKey;
        p.i(sessionId, "sessionId");
        if (sessionId.length() <= 0) {
            return false;
        }
        RevertedSessionGuard$sessions$1 revertedSessionGuard$sessions$1 = sessions;
        synchronized (revertedSessionGuard$sessions$1) {
            zContainsKey = revertedSessionGuard$sessions$1.containsKey(sessionId);
        }
        return zContainsKey;
    }

    public final void b() {
        RevertedSessionGuard$sessions$1 revertedSessionGuard$sessions$1 = sessions;
        synchronized (revertedSessionGuard$sessions$1) {
            revertedSessionGuard$sessions$1.clear();
            t tVar = t.f7040a;
        }
    }

    public final void c(String sessionId) {
        p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        RevertedSessionGuard$sessions$1 revertedSessionGuard$sessions$1 = sessions;
        synchronized (revertedSessionGuard$sessions$1) {
            revertedSessionGuard$sessions$1.put(sessionId, t.f7040a);
        }
        C4148a.k(TAG, "mark sessionId:" + sessionId, false, 4, null);
    }

    public final void d(String sessionId) {
        boolean z10;
        p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        RevertedSessionGuard$sessions$1 revertedSessionGuard$sessions$1 = sessions;
        synchronized (revertedSessionGuard$sessions$1) {
            z10 = revertedSessionGuard$sessions$1.remove(sessionId) != null;
        }
        if (z10) {
            C4148a.k(TAG, "release sessionId:" + sessionId, false, 4, null);
        }
    }
}
