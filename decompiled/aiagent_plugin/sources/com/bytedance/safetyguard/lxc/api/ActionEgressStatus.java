package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: ActionEgressModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum ActionEgressStatus extends Enum<ActionEgressStatus> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ ActionEgressStatus[] $VALUES = null;
    public static final ActionEgressStatus ACCESS_DENIED = null;
    public static final ActionEgressStatus ALLOWED = null;
    public static final ActionEgressStatus CLARIFICATION_REQUIRED = null;
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ActionEgressModels.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final ActionEgressStatus fromCategories(Set<String> r2, Set<String> r3) {
            Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            o.e(r1, "unapprovedCategories");
            o.e(r4, "deniedCategories");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
            return ActionEgressStatus.ACCESS_DENIED;
        L6:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
            return ActionEgressStatus.CLARIFICATION_REQUIRED;
        L9:
            return ActionEgressStatus.ALLOWED;
        }
    }

    private static final /* synthetic */ ActionEgressStatus[] $values() {
        return new ActionEgressStatus[]{ALLOWED, CLARIFICATION_REQUIRED, ACCESS_DENIED};
    }

    public static a<ActionEgressStatus> getEntries() {
        return $ENTRIES;
    }

    public static ActionEgressStatus valueOf(String r2) {
        return (ActionEgressStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActionEgressStatus.class, r2), ActionEgressStatus.class, "com.obric.aiagent.plugin");
    }

    public static ActionEgressStatus[] values() {
        return (ActionEgressStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActionEgressStatus[].class, "com.obric.aiagent.plugin");
    }

    private ActionEgressStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ALLOWED = new ActionEgressStatus("ALLOWED", 0);
        CLARIFICATION_REQUIRED = new ActionEgressStatus("CLARIFICATION_REQUIRED", 1);
        ACCESS_DENIED = new ActionEgressStatus("ACCESS_DENIED", 2);
        ActionEgressStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        Companion = new Companion(null);
    }
}
