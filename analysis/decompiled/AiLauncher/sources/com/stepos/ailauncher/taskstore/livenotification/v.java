package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/r;", "other", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/livenotification/r;Lcom/stepos/ailauncher/taskstore/livenotification/r;)Z", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    public static final boolean a(SessionLiveState sessionLiveState, SessionLiveState other) {
        kotlin.jvm.internal.p.i(sessionLiveState, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return kotlin.jvm.internal.p.d(sessionLiveState.getSessionId(), other.getSessionId()) && sessionLiveState.getCategory() == other.getCategory() && kotlin.jvm.internal.p.d(sessionLiveState.getTitle(), other.getTitle()) && sessionLiveState.getPhase() == other.getPhase() && kotlin.jvm.internal.p.d(sessionLiveState.getDynamicText(), other.getDynamicText()) && kotlin.jvm.internal.p.d(sessionLiveState.getIconRes(), other.getIconRes()) && kotlin.jvm.internal.p.d(sessionLiveState.getRiskRequestId(), other.getRiskRequestId()) && kotlin.jvm.internal.p.d(sessionLiveState.j(), other.j()) && kotlin.jvm.internal.p.d(sessionLiveState.getRiskBody(), other.getRiskBody()) && kotlin.jvm.internal.p.d(sessionLiveState.getRiskLevel(), other.getRiskLevel()) && sessionLiveState.getContinueTaskAfterTakeover() == other.getContinueTaskAfterTakeover();
    }
}
