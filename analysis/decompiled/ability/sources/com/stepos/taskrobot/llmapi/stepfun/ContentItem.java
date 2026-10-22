package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ContentItem;", "", "index", "", "type", "content", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIndex", "()Ljava/lang/String;", "getType", "getContent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContentItem {
    private final String content;
    private final String index;
    private final String type;

    public ContentItem(String index, String type, String content) {
        kotlin.jvm.internal.k.f(index, "index");
        kotlin.jvm.internal.k.f(type, "type");
        kotlin.jvm.internal.k.f(content, "content");
        this.index = index;
        this.type = type;
        this.content = content;
    }

    public static /* synthetic */ ContentItem copy$default(ContentItem contentItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentItem.index;
        }
        if ((i & 2) != 0) {
            str2 = contentItem.type;
        }
        if ((i & 4) != 0) {
            str3 = contentItem.content;
        }
        return contentItem.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ContentItem copy(String index, String type, String content) {
        kotlin.jvm.internal.k.f(index, "index");
        kotlin.jvm.internal.k.f(type, "type");
        kotlin.jvm.internal.k.f(content, "content");
        return new ContentItem(index, type, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentItem)) {
            return false;
        }
        ContentItem contentItem = (ContentItem) other;
        return kotlin.jvm.internal.k.b(this.index, contentItem.index) && kotlin.jvm.internal.k.b(this.type, contentItem.type) && kotlin.jvm.internal.k.b(this.content, contentItem.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.content.hashCode() + B7.a.c(this.index.hashCode() * 31, 31, this.type);
    }

    public String toString() {
        String str = this.index;
        String str2 = this.type;
        return B7.a.q(B7.a.w("ContentItem(index=", str, ", type=", str2, ", content="), this.content, ")");
    }
}
