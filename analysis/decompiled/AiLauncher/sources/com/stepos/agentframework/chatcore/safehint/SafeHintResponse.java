package com.stepos.agentframework.chatcore.safehint;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/c;", "", "", "is_risky", "<init>", "(Ljava/lang/Boolean;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Boolean;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.safehint.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SafeHintResponse {
    private final Boolean is_risky;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeHintResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final Boolean getIs_risky() {
        return this.is_risky;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SafeHintResponse) && p.d(this.is_risky, ((SafeHintResponse) other).is_risky);
    }

    public int hashCode() {
        Boolean bool = this.is_risky;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "SafeHintResponse(is_risky=" + this.is_risky + ")";
    }

    public SafeHintResponse(Boolean bool) {
        this.is_risky = bool;
    }

    public /* synthetic */ SafeHintResponse(Boolean bool, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : bool);
    }
}
