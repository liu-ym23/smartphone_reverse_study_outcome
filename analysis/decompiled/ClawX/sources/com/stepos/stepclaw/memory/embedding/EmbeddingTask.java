package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingTask;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "category", "date", "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDocId", "()Ljava/lang/String;", "getContent", "getCategory", "getDate", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class EmbeddingTask {
    private final String category;
    private final String content;
    private final long createdAt;
    private final String date;
    private final String docId;

    public EmbeddingTask(String docId, String content, String category, String date, long j4) {
        p.e(docId, "docId");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        this.docId = docId;
        this.content = content;
        this.category = category;
        this.date = date;
        this.createdAt = j4;
    }

    public static /* synthetic */ EmbeddingTask copy$default(EmbeddingTask embeddingTask, String str, String str2, String str3, String str4, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = embeddingTask.docId;
        }
        if ((i8 & 2) != 0) {
            str2 = embeddingTask.content;
        }
        if ((i8 & 4) != 0) {
            str3 = embeddingTask.category;
        }
        if ((i8 & 8) != 0) {
            str4 = embeddingTask.date;
        }
        if ((i8 & 16) != 0) {
            j4 = embeddingTask.createdAt;
        }
        long j8 = j4;
        return embeddingTask.copy(str, str2, str3, str4, j8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final EmbeddingTask copy(String docId, String content, String category, String date, long createdAt) {
        p.e(docId, "docId");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        return new EmbeddingTask(docId, content, category, date, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbeddingTask)) {
            return false;
        }
        EmbeddingTask embeddingTask = (EmbeddingTask) other;
        return p.a(this.docId, embeddingTask.docId) && p.a(this.content, embeddingTask.content) && p.a(this.category, embeddingTask.category) && p.a(this.date, embeddingTask.date) && this.createdAt == embeddingTask.createdAt;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDocId() {
        return this.docId;
    }

    public int hashCode() {
        return Long.hashCode(this.createdAt) + a8.b.f(a8.b.f(a8.b.f(this.docId.hashCode() * 31, 31, this.content), 31, this.category), 31, this.date);
    }

    public String toString() {
        String str = this.docId;
        String str2 = this.content;
        String str3 = this.category;
        String str4 = this.date;
        long j4 = this.createdAt;
        StringBuilder sbV = a8.b.v("EmbeddingTask(docId=", str, ", content=", str2, ", category=");
        a8.b.A(sbV, str3, ", date=", str4, ", createdAt=");
        return a8.b.r(sbV, j4, ")");
    }
}
