package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/k;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/utils/i;", "meta", "Lcom/stepos/agentframework/chatcore/utils/i;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/utils/i;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.utils.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FunctionCallWidgetPayload {
    private final Object content;
    private final FunctionCallWidgetMeta meta;

    /* renamed from: a, reason: from getter */
    public final Object getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final FunctionCallWidgetMeta getMeta() {
        return this.meta;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCallWidgetPayload)) {
            return false;
        }
        FunctionCallWidgetPayload functionCallWidgetPayload = (FunctionCallWidgetPayload) other;
        return p.d(this.content, functionCallWidgetPayload.content) && p.d(this.meta, functionCallWidgetPayload.meta);
    }

    public int hashCode() {
        Object obj = this.content;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        FunctionCallWidgetMeta functionCallWidgetMeta = this.meta;
        return iHashCode + (functionCallWidgetMeta != null ? functionCallWidgetMeta.hashCode() : 0);
    }

    public String toString() {
        return "FunctionCallWidgetPayload(content=" + this.content + ", meta=" + this.meta + ")";
    }
}
