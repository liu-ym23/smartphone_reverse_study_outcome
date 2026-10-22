package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.InterruptedRoundRow;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0003R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0017j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/e0;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatcore/session/db/B0;", "rounds", "LY8/t;", "e", "(Ljava/util/List;)V", "", "sessionId", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "c", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "TAG", "Ljava/lang/String;", "", "CAPACITY", "I", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", AuthSessionDto.STATUS_PENDING, "Ljava/util/LinkedHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.e0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1927e0 {
    private static final int CAPACITY = 16;
    private static final String TAG = "InterruptedRoundRegistry";
    public static final C1927e0 INSTANCE = new C1927e0();
    private static final LinkedHashMap<String, String> pending = new LinkedHashMap<>();

    public static final boolean f(InterruptedRoundRow it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId().length() > 0 && it.getMessageId().length() > 0;
    }

    public final void b() {
        LinkedHashMap<String, String> linkedHashMap = pending;
        synchronized (linkedHashMap) {
            linkedHashMap.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final String c(String sessionId) {
        String strRemove;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return null;
        }
        LinkedHashMap<String, String> linkedHashMap = pending;
        synchronized (linkedHashMap) {
            strRemove = linkedHashMap.remove(sessionId);
        }
        if (strRemove != null) {
            C4148a.k(TAG, "consume sessionId=" + sessionId + " messageId=" + strRemove, false, 4, null);
        }
        return strRemove;
    }

    public final boolean d(String sessionId) {
        boolean zContainsKey;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return false;
        }
        LinkedHashMap<String, String> linkedHashMap = pending;
        synchronized (linkedHashMap) {
            zContainsKey = linkedHashMap.containsKey(sessionId);
        }
        return zContainsKey;
    }

    public final void e(List<InterruptedRoundRow> rounds) {
        kotlin.jvm.internal.p.i(rounds, "rounds");
        if (rounds.isEmpty()) {
            return;
        }
        synchronized (pending) {
            try {
                for (InterruptedRoundRow interruptedRoundRow : SequencesKt___SequencesKt.F(Z8.F.d0(rounds), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.d0
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C1927e0.f((InterruptedRoundRow) obj));
                    }
                })) {
                    LinkedHashMap<String, String> linkedHashMap = pending;
                    if (linkedHashMap.size() < 16 || linkedHashMap.containsKey(interruptedRoundRow.getSessionId())) {
                        linkedHashMap.putIfAbsent(interruptedRoundRow.getSessionId(), interruptedRoundRow.getMessageId());
                    }
                }
                C4148a.k(TAG, "registered " + pending.size() + " interrupted round(s) from " + rounds.size() + " row(s)", false, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
