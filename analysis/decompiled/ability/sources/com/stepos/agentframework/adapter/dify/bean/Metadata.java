package com.stepos.agentframework.adapter.dify.bean;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.k;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/bean/Metadata;", "", "usage", "Lcom/stepos/agentframework/adapter/dify/bean/Usage;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/dify/bean/Usage;)V", "getUsage", "()Lcom/stepos/agentframework/adapter/dify/bean/Usage;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Metadata {

    @SerializedName("usage")
    private final Usage usage;

    public Metadata(Usage usage) {
        k.f(usage, "usage");
        this.usage = usage;
    }

    public static /* synthetic */ Metadata copy$default(Metadata metadata, Usage usage, int i, Object obj) {
        if ((i & 1) != 0) {
            usage = metadata.usage;
        }
        return metadata.copy(usage);
    }

    /* renamed from: component1, reason: from getter */
    public final Usage getUsage() {
        return this.usage;
    }

    public final Metadata copy(Usage usage) {
        k.f(usage, "usage");
        return new Metadata(usage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Metadata) && k.b(this.usage, ((Metadata) other).usage);
    }

    public final Usage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        return this.usage.hashCode();
    }

    public String toString() {
        return "Metadata(usage=" + this.usage + ")";
    }
}
