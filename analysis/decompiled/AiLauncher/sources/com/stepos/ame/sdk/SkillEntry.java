package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/stepos/ame/sdk/SkillEntry;", "", "skillId", "", "vector", "", "filePath", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "docType", "<init>", "(Ljava/lang/String;[FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSkillId", "()Ljava/lang/String;", "getVector", "()[F", "getFilePath", "getContent", "getDocType", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillEntry {
    private final String content;
    private final String docType;
    private final String filePath;
    private final String skillId;
    private final float[] vector;

    public SkillEntry(String skillId, float[] vector, String filePath, String content, String docType) {
        p.i(skillId, "skillId");
        p.i(vector, "vector");
        p.i(filePath, "filePath");
        p.i(content, "content");
        p.i(docType, "docType");
        this.skillId = skillId;
        this.vector = vector;
        this.filePath = filePath;
        this.content = content;
        this.docType = docType;
    }

    public static /* synthetic */ SkillEntry copy$default(SkillEntry skillEntry, String str, float[] fArr, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = skillEntry.skillId;
        }
        if ((i10 & 2) != 0) {
            fArr = skillEntry.vector;
        }
        if ((i10 & 4) != 0) {
            str2 = skillEntry.filePath;
        }
        if ((i10 & 8) != 0) {
            str3 = skillEntry.content;
        }
        if ((i10 & 16) != 0) {
            str4 = skillEntry.docType;
        }
        String str5 = str4;
        String str6 = str2;
        return skillEntry.copy(str, fArr, str6, str3, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSkillId() {
        return this.skillId;
    }

    /* renamed from: component2, reason: from getter */
    public final float[] getVector() {
        return this.vector;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDocType() {
        return this.docType;
    }

    public final SkillEntry copy(String skillId, float[] vector, String filePath, String content, String docType) {
        p.i(skillId, "skillId");
        p.i(vector, "vector");
        p.i(filePath, "filePath");
        p.i(content, "content");
        p.i(docType, "docType");
        return new SkillEntry(skillId, vector, filePath, content, docType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillEntry)) {
            return false;
        }
        SkillEntry skillEntry = (SkillEntry) other;
        return p.d(this.skillId, skillEntry.skillId) && Arrays.equals(this.vector, skillEntry.vector) && p.d(this.filePath, skillEntry.filePath) && p.d(this.content, skillEntry.content) && p.d(this.docType, skillEntry.docType);
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

    public final String getSkillId() {
        return this.skillId;
    }

    public final float[] getVector() {
        return this.vector;
    }

    public int hashCode() {
        return (((((((this.skillId.hashCode() * 31) + Arrays.hashCode(this.vector)) * 31) + this.filePath.hashCode()) * 31) + this.content.hashCode()) * 31) + this.docType.hashCode();
    }

    public String toString() {
        return "SkillEntry(skillId=" + this.skillId + ", vector=" + Arrays.toString(this.vector) + ", filePath=" + this.filePath + ", content=" + this.content + ", docType=" + this.docType + ")";
    }

    public /* synthetic */ SkillEntry(String str, float[] fArr, String str2, String str3, String str4, int i10, i iVar) {
        this(str, fArr, str2, str3, (i10 & 16) != 0 ? SkillStoreKt.SKILL_DOC_TYPE_ROOT : str4);
    }
}
