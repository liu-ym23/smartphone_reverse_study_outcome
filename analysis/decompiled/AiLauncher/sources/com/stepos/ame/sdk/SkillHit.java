package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006'"}, d2 = {"Lcom/stepos/ame/sdk/SkillHit;", "", "rank", "", "vectorId", "", "skillId", "", "score", "", "filePath", "docType", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(IJLjava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRank", "()I", "getVectorId", "()J", "getSkillId", "()Ljava/lang/String;", "getScore", "()F", "getFilePath", "getDocType", "getContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillHit {
    private final String content;
    private final String docType;
    private final String filePath;
    private final int rank;
    private final float score;
    private final String skillId;
    private final long vectorId;

    public SkillHit(int i10, long j10, String skillId, float f10, String filePath, String docType, String content) {
        p.i(skillId, "skillId");
        p.i(filePath, "filePath");
        p.i(docType, "docType");
        p.i(content, "content");
        this.rank = i10;
        this.vectorId = j10;
        this.skillId = skillId;
        this.score = f10;
        this.filePath = filePath;
        this.docType = docType;
        this.content = content;
    }

    public static /* synthetic */ SkillHit copy$default(SkillHit skillHit, int i10, long j10, String str, float f10, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = skillHit.rank;
        }
        if ((i11 & 2) != 0) {
            j10 = skillHit.vectorId;
        }
        if ((i11 & 4) != 0) {
            str = skillHit.skillId;
        }
        if ((i11 & 8) != 0) {
            f10 = skillHit.score;
        }
        if ((i11 & 16) != 0) {
            str2 = skillHit.filePath;
        }
        if ((i11 & 32) != 0) {
            str3 = skillHit.docType;
        }
        if ((i11 & 64) != 0) {
            str4 = skillHit.content;
        }
        String str5 = str4;
        String str6 = str2;
        String str7 = str;
        return skillHit.copy(i10, j10, str7, f10, str6, str3, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component2, reason: from getter */
    public final long getVectorId() {
        return this.vectorId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSkillId() {
        return this.skillId;
    }

    /* renamed from: component4, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDocType() {
        return this.docType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SkillHit copy(int rank, long vectorId, String skillId, float score, String filePath, String docType, String content) {
        p.i(skillId, "skillId");
        p.i(filePath, "filePath");
        p.i(docType, "docType");
        p.i(content, "content");
        return new SkillHit(rank, vectorId, skillId, score, filePath, docType, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillHit)) {
            return false;
        }
        SkillHit skillHit = (SkillHit) other;
        return this.rank == skillHit.rank && this.vectorId == skillHit.vectorId && p.d(this.skillId, skillHit.skillId) && Float.compare(this.score, skillHit.score) == 0 && p.d(this.filePath, skillHit.filePath) && p.d(this.docType, skillHit.docType) && p.d(this.content, skillHit.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDocType() {
        return this.docType;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final int getRank() {
        return this.rank;
    }

    public final float getScore() {
        return this.score;
    }

    public final String getSkillId() {
        return this.skillId;
    }

    public final long getVectorId() {
        return this.vectorId;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.rank) * 31) + Long.hashCode(this.vectorId)) * 31) + this.skillId.hashCode()) * 31) + Float.hashCode(this.score)) * 31) + this.filePath.hashCode()) * 31) + this.docType.hashCode()) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "SkillHit(rank=" + this.rank + ", vectorId=" + this.vectorId + ", skillId=" + this.skillId + ", score=" + this.score + ", filePath=" + this.filePath + ", docType=" + this.docType + ", content=" + this.content + ")";
    }
}
