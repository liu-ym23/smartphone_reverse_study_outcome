package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/uxsense/parse/ChatMessageKeyMapping;", "", "text", "", "at", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getAt", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatMessageKeyMapping {
    private final String at;
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatMessageKeyMapping() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ChatMessageKeyMapping copy$default(ChatMessageKeyMapping chatMessageKeyMapping, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatMessageKeyMapping.text;
        }
        if ((i & 2) != 0) {
            str2 = chatMessageKeyMapping.at;
        }
        return chatMessageKeyMapping.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAt() {
        return this.at;
    }

    public final ChatMessageKeyMapping copy(String text, String at) {
        k.f(text, "text");
        k.f(at, "at");
        return new ChatMessageKeyMapping(text, at);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessageKeyMapping)) {
            return false;
        }
        ChatMessageKeyMapping chatMessageKeyMapping = (ChatMessageKeyMapping) other;
        return k.b(this.text, chatMessageKeyMapping.text) && k.b(this.at, chatMessageKeyMapping.at);
    }

    public final String getAt() {
        return this.at;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return this.at.hashCode() + (this.text.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChatMessageKeyMapping(text=");
        sb.append(this.text);
        sb.append(", at=");
        return B7.a.g(')', this.at, sb);
    }

    public ChatMessageKeyMapping(String text, String at) {
        k.f(text, "text");
        k.f(at, "at");
        this.text = text;
        this.at = at;
    }

    public /* synthetic */ ChatMessageKeyMapping(String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? "text" : str, (i & 2) != 0 ? "at" : str2);
    }
}
