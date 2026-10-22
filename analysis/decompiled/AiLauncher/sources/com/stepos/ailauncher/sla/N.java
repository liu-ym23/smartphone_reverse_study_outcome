package com.stepos.ailauncher.sla;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a;\u0010\b\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", "currentPriority", "", "currentOwner", "", "currentLive", "incomingOwner", "incomingPriority", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;Ljava/lang/Object;ZLjava/lang/Object;Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;)Z", "sla_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {
    public static final boolean a(SlaVoiceBridge.GateBindPriority gateBindPriority, Object obj, boolean z10, Object incomingOwner, SlaVoiceBridge.GateBindPriority incomingPriority) {
        kotlin.jvm.internal.p.i(incomingOwner, "incomingOwner");
        kotlin.jvm.internal.p.i(incomingPriority, "incomingPriority");
        return gateBindPriority == SlaVoiceBridge.GateBindPriority.CHAT && incomingPriority == SlaVoiceBridge.GateBindPriority.VOICE_ONLY && obj != incomingOwner && z10;
    }
}
