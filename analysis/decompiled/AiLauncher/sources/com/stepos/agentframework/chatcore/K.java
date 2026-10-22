package com.stepos.agentframework.chatcore;

import Z8.X;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.M0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "currentSessionId", "currentTempSessionId", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30738e, "Lcom/stepos/agentframework/chatcore/ModerationApplyTarget;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/ModerationApplyTarget;", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class K {
    public static final boolean a(String currentSessionId, String currentTempSessionId, String str) {
        kotlin.jvm.internal.p.i(currentSessionId, "currentSessionId");
        kotlin.jvm.internal.p.i(currentTempSessionId, "currentTempSessionId");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                if (kotlin.jvm.internal.p.d(str, currentSessionId) || kotlin.jvm.internal.p.d(str, currentTempSessionId)) {
                    return true;
                }
                Set setB = X.b();
                if (currentSessionId.length() > 0) {
                    setB.add(currentSessionId);
                }
                if (currentTempSessionId.length() > 0) {
                    setB.add(currentTempSessionId);
                }
                Set setA = X.a(setB);
                if (setA.isEmpty()) {
                    return false;
                }
                Set set = setA;
                boolean z10 = set instanceof Collection;
                if (!z10 || !set.isEmpty()) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        if (M0.INSTANCE.a(str).contains((String) it.next())) {
                            return true;
                        }
                    }
                }
                if (z10 && set.isEmpty()) {
                    return false;
                }
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (M0.INSTANCE.a((String) it2.next()).contains(str)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static final ModerationApplyTarget b(String currentSessionId, String currentTempSessionId, String str) {
        kotlin.jvm.internal.p.i(currentSessionId, "currentSessionId");
        kotlin.jvm.internal.p.i(currentTempSessionId, "currentTempSessionId");
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return a(currentSessionId, currentTempSessionId, str) ? ModerationApplyTarget.FOREGROUND : ModerationApplyTarget.BACKGROUND;
            }
        }
        return ModerationApplyTarget.MISSING_SESSION;
    }
}
