package com.stepos.stepclaw.memory.lightmem.local;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/ThinkParseResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "think", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getThink", "()Ljava/lang/String;", "getContent", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ThinkParseResult {
    private final String content;
    private final String think;

    public ThinkParseResult(String str, String content) {
        p.e(content, "content");
        this.think = str;
        this.content = content;
    }

    public static /* synthetic */ ThinkParseResult copy$default(ThinkParseResult thinkParseResult, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = thinkParseResult.think;
        }
        if ((i8 & 2) != 0) {
            str2 = thinkParseResult.content;
        }
        return thinkParseResult.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getThink() {
        return this.think;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ThinkParseResult copy(String think, String content) {
        p.e(content, "content");
        return new ThinkParseResult(think, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThinkParseResult)) {
            return false;
        }
        ThinkParseResult thinkParseResult = (ThinkParseResult) other;
        return p.a(this.think, thinkParseResult.think) && p.a(this.content, thinkParseResult.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getThink() {
        return this.think;
    }

    public int hashCode() {
        String str = this.think;
        return this.content.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        return b.q("ThinkParseResult(think=", this.think, ", content=", this.content, ")");
    }
}
