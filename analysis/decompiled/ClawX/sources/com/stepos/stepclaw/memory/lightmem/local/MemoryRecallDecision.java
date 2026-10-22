package com.stepos.stepclaw.memory.lightmem.local;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/MemoryRecallDecision;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "needRecall", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "query", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "thinkContent", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getNeedRecall", "()Z", "getQuery", "()Ljava/lang/String;", "getThinkContent", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MemoryRecallDecision {
    private final boolean needRecall;
    private final String query;
    private final String thinkContent;

    public MemoryRecallDecision(boolean z, String str, String str2) {
        this.needRecall = z;
        this.query = str;
        this.thinkContent = str2;
    }

    public static /* synthetic */ MemoryRecallDecision copy$default(MemoryRecallDecision memoryRecallDecision, boolean z, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = memoryRecallDecision.needRecall;
        }
        if ((i8 & 2) != 0) {
            str = memoryRecallDecision.query;
        }
        if ((i8 & 4) != 0) {
            str2 = memoryRecallDecision.thinkContent;
        }
        return memoryRecallDecision.copy(z, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getNeedRecall() {
        return this.needRecall;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component3, reason: from getter */
    public final String getThinkContent() {
        return this.thinkContent;
    }

    public final MemoryRecallDecision copy(boolean needRecall, String query, String thinkContent) {
        return new MemoryRecallDecision(needRecall, query, thinkContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryRecallDecision)) {
            return false;
        }
        MemoryRecallDecision memoryRecallDecision = (MemoryRecallDecision) other;
        return this.needRecall == memoryRecallDecision.needRecall && p.a(this.query, memoryRecallDecision.query) && p.a(this.thinkContent, memoryRecallDecision.thinkContent);
    }

    public final boolean getNeedRecall() {
        return this.needRecall;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getThinkContent() {
        return this.thinkContent;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.needRecall) * 31;
        String str = this.query;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thinkContent;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.needRecall;
        String str = this.query;
        String str2 = this.thinkContent;
        StringBuilder sb = new StringBuilder("MemoryRecallDecision(needRecall=");
        sb.append(z);
        sb.append(", query=");
        sb.append(str);
        sb.append(", thinkContent=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ MemoryRecallDecision(boolean z, String str, String str2, int i8, i iVar) {
        this(z, str, (i8 & 4) != 0 ? null : str2);
    }
}
