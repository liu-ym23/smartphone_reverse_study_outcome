package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/j;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/utils/k;", "payload", "Lcom/stepos/agentframework/chatcore/utils/k;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/utils/k;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.utils.j, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FunctionCallWidgetOutput {
    private final FunctionCallWidgetPayload payload;

    /* renamed from: a, reason: from getter */
    public final FunctionCallWidgetPayload getPayload() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FunctionCallWidgetOutput) && p.d(this.payload, ((FunctionCallWidgetOutput) other).payload);
    }

    public int hashCode() {
        FunctionCallWidgetPayload kVar = this.payload;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public String toString() {
        return "FunctionCallWidgetOutput(payload=" + this.payload + ")";
    }
}
