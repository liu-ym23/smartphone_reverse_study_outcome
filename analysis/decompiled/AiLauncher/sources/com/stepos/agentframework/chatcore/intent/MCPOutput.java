package com.stepos.agentframework.chatcore.intent;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/MCPOutput;", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "Lcom/stepos/agentframework/chatcore/intent/MCPContent;", "structuredContent", "isError", "", "meta", "<init>", "(Ljava/util/List;Ljava/lang/Object;ZLjava/lang/Object;)V", "getContent", "()Ljava/util/List;", "getStructuredContent", "()Ljava/lang/Object;", "()Z", "getMeta", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MCPOutput {
    private final List<MCPContent> content;

    @SerializedName("isError")
    private final boolean isError;

    @SerializedName("_meta")
    private final Object meta;

    @SerializedName("structuredContent")
    private final Object structuredContent;

    public MCPOutput(List<MCPContent> content, Object obj, boolean z10, Object obj2) {
        kotlin.jvm.internal.p.i(content, "content");
        this.content = content;
        this.structuredContent = obj;
        this.isError = z10;
        this.meta = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MCPOutput copy$default(MCPOutput mCPOutput, List list, Object obj, boolean z10, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            list = mCPOutput.content;
        }
        if ((i10 & 2) != 0) {
            obj = mCPOutput.structuredContent;
        }
        if ((i10 & 4) != 0) {
            z10 = mCPOutput.isError;
        }
        if ((i10 & 8) != 0) {
            obj2 = mCPOutput.meta;
        }
        return mCPOutput.copy(list, obj, z10, obj2);
    }

    public final List<MCPContent> component1() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getMeta() {
        return this.meta;
    }

    public final MCPOutput copy(List<MCPContent> content, Object structuredContent, boolean isError, Object meta) {
        kotlin.jvm.internal.p.i(content, "content");
        return new MCPOutput(content, structuredContent, isError, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MCPOutput)) {
            return false;
        }
        MCPOutput mCPOutput = (MCPOutput) other;
        return kotlin.jvm.internal.p.d(this.content, mCPOutput.content) && kotlin.jvm.internal.p.d(this.structuredContent, mCPOutput.structuredContent) && this.isError == mCPOutput.isError && kotlin.jvm.internal.p.d(this.meta, mCPOutput.meta);
    }

    public final List<MCPContent> getContent() {
        return this.content;
    }

    public final Object getMeta() {
        return this.meta;
    }

    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        Object obj = this.structuredContent;
        int iHashCode2 = (((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + Boolean.hashCode(this.isError)) * 31;
        Object obj2 = this.meta;
        return iHashCode2 + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final boolean isError() {
        return this.isError;
    }

    public String toString() {
        return "MCPOutput(content=" + this.content + ", structuredContent=" + this.structuredContent + ", isError=" + this.isError + ", meta=" + this.meta + ")";
    }
}
