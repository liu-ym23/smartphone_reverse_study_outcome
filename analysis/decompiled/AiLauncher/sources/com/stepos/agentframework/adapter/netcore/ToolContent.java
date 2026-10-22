package com.stepos.agentframework.adapter.netcore;

import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0006\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/D;", "", "", "Lcom/stepos/agentframework/adapter/netcore/G;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "isError", "<init>", "(Ljava/util/List;Z)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "Z", "()Z", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.D, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ToolContent {
    private final List<ToolType> content;
    private final boolean isError;

    public ToolContent(List<ToolType> content, boolean z10) {
        kotlin.jvm.internal.p.i(content, "content");
        this.content = content;
        this.isError = z10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolContent)) {
            return false;
        }
        ToolContent toolContent = (ToolContent) other;
        return kotlin.jvm.internal.p.d(this.content, toolContent.content) && this.isError == toolContent.isError;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + Boolean.hashCode(this.isError);
    }

    public String toString() {
        return "ToolContent(content=" + this.content + ", isError=" + this.isError + ")";
    }
}
