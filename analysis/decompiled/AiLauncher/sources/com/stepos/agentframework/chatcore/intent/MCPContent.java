package com.stepos.agentframework.chatcore.intent;

import androidx.annotation.Keep;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/MCPContent;", "", "type", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getText", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MCPContent {
    private final String text;
    private final String type;

    public MCPContent(String type, String text) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(text, "text");
        this.type = type;
        this.text = text;
    }

    public static /* synthetic */ MCPContent copy$default(MCPContent mCPContent, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mCPContent.type;
        }
        if ((i10 & 2) != 0) {
            str2 = mCPContent.text;
        }
        return mCPContent.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final MCPContent copy(String type, String text) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(text, "text");
        return new MCPContent(type, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MCPContent)) {
            return false;
        }
        MCPContent mCPContent = (MCPContent) other;
        return kotlin.jvm.internal.p.d(this.type, mCPContent.type) && kotlin.jvm.internal.p.d(this.text, mCPContent.text);
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "MCPContent(type=" + this.type + ", text=" + this.text + ")";
    }
}
