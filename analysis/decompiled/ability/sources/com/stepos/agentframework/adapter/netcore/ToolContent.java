package com.stepos.agentframework.adapter.netcore;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/ToolContent;", "", "content", "", "Lcom/stepos/agentframework/adapter/netcore/ToolType;", "isError", "", AppAgent.CONSTRUCT, "(Ljava/util/List;Z)V", "getContent", "()Ljava/util/List;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolContent {
    private final List<ToolType> content;
    private final boolean isError;

    public ToolContent(List<ToolType> content, boolean z10) {
        k.f(content, "content");
        this.content = content;
        this.isError = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolContent copy$default(ToolContent toolContent, List list, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            list = toolContent.content;
        }
        if ((i & 2) != 0) {
            z10 = toolContent.isError;
        }
        return toolContent.copy(list, z10);
    }

    public final List<ToolType> component1() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final ToolContent copy(List<ToolType> content, boolean isError) {
        k.f(content, "content");
        return new ToolContent(content, isError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolContent)) {
            return false;
        }
        ToolContent toolContent = (ToolContent) other;
        return k.b(this.content, toolContent.content) && this.isError == toolContent.isError;
    }

    public final List<ToolType> getContent() {
        return this.content;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isError) + (this.content.hashCode() * 31);
    }

    public final boolean isError() {
        return this.isError;
    }

    public String toString() {
        return "ToolContent(content=" + this.content + ", isError=" + this.isError + ")";
    }
}
