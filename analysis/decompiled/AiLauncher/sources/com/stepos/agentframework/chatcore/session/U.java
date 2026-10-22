package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/U;", "", "<init>", "()V", "", "", "held", "active", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;Ljava/util/Set;)Ljava/util/Set;", "", "latched", "remainingHeld", "pendingUserDecisionTool", Const.INTENT_KEY_APIKEY, "(ZLjava/util/Set;Z)Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class U {
    public static final U INSTANCE = new U();

    public final boolean a(boolean latched, Set<String> remainingHeld, boolean pendingUserDecisionTool) {
        kotlin.jvm.internal.p.i(remainingHeld, "remainingHeld");
        return latched && remainingHeld.isEmpty() && !pendingUserDecisionTool;
    }

    public final Set<String> b(Set<String> held, Set<String> active) {
        kotlin.jvm.internal.p.i(held, "held");
        kotlin.jvm.internal.p.i(active, "active");
        if (held.isEmpty()) {
            return Z8.Y.e();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : held) {
            if (!active.contains((String) obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }
}
