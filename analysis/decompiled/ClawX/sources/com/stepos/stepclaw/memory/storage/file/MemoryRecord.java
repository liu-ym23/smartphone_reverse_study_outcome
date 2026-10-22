package com.stepos.stepclaw.memory.storage.file;

import a8.b;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003Js\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "date", "confidence", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "profileType", "state", "memoryIndex", "keywords", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getId", "()Ljava/lang/String;", "getContent", "getCreatedAt", "()J", "getCategory", "getDate", "getConfidence", "()D", "getProfileType", "getState", "getMemoryIndex", "getKeywords", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MemoryRecord {
    private final String category;
    private final double confidence;
    private final String content;
    private final long createdAt;
    private final String date;
    private final String id;
    private final List<String> keywords;
    private final long memoryIndex;
    private final String profileType;
    private final String state;

    public MemoryRecord(String id, String content, long j4, String category, String date, double d, String profileType, String state, long j8, List<String> keywords) {
        p.e(id, "id");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        p.e(profileType, "profileType");
        p.e(state, "state");
        p.e(keywords, "keywords");
        this.id = id;
        this.content = content;
        this.createdAt = j4;
        this.category = category;
        this.date = date;
        this.confidence = d;
        this.profileType = profileType;
        this.state = state;
        this.memoryIndex = j8;
        this.keywords = keywords;
    }

    public static /* synthetic */ MemoryRecord copy$default(MemoryRecord memoryRecord, String str, String str2, long j4, String str3, String str4, double d, String str5, String str6, long j8, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = memoryRecord.id;
        }
        return memoryRecord.copy(str, (i8 & 2) != 0 ? memoryRecord.content : str2, (i8 & 4) != 0 ? memoryRecord.createdAt : j4, (i8 & 8) != 0 ? memoryRecord.category : str3, (i8 & 16) != 0 ? memoryRecord.date : str4, (i8 & 32) != 0 ? memoryRecord.confidence : d, (i8 & 64) != 0 ? memoryRecord.profileType : str5, (i8 & 128) != 0 ? memoryRecord.state : str6, (i8 & 256) != 0 ? memoryRecord.memoryIndex : j8, (i8 & 512) != 0 ? memoryRecord.keywords : list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.keywords;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component6, reason: from getter */
    public final double getConfidence() {
        return this.confidence;
    }

    /* renamed from: component7, reason: from getter */
    public final String getProfileType() {
        return this.profileType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component9, reason: from getter */
    public final long getMemoryIndex() {
        return this.memoryIndex;
    }

    public final MemoryRecord copy(String id, String content, long createdAt, String category, String date, double confidence, String profileType, String state, long memoryIndex, List<String> keywords) {
        p.e(id, "id");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        p.e(profileType, "profileType");
        p.e(state, "state");
        p.e(keywords, "keywords");
        return new MemoryRecord(id, content, createdAt, category, date, confidence, profileType, state, memoryIndex, keywords);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryRecord)) {
            return false;
        }
        MemoryRecord memoryRecord = (MemoryRecord) other;
        return p.a(this.id, memoryRecord.id) && p.a(this.content, memoryRecord.content) && this.createdAt == memoryRecord.createdAt && p.a(this.category, memoryRecord.category) && p.a(this.date, memoryRecord.date) && Double.compare(this.confidence, memoryRecord.confidence) == 0 && p.a(this.profileType, memoryRecord.profileType) && p.a(this.state, memoryRecord.state) && this.memoryIndex == memoryRecord.memoryIndex && p.a(this.keywords, memoryRecord.keywords);
    }

    public final String getCategory() {
        return this.category;
    }

    public final double getConfidence() {
        return this.confidence;
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

    public final String getId() {
        return this.id;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final long getMemoryIndex() {
        return this.memoryIndex;
    }

    public final String getProfileType() {
        return this.profileType;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.keywords.hashCode() + b.e(b.f(b.f((Double.hashCode(this.confidence) + b.f(b.f(b.e(b.f(this.id.hashCode() * 31, 31, this.content), 31, this.createdAt), 31, this.category), 31, this.date)) * 31, 31, this.profileType), 31, this.state), 31, this.memoryIndex);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.content;
        long j4 = this.createdAt;
        String str3 = this.category;
        String str4 = this.date;
        double d = this.confidence;
        String str5 = this.profileType;
        String str6 = this.state;
        long j8 = this.memoryIndex;
        List<String> list = this.keywords;
        StringBuilder sbV = b.v("MemoryRecord(id=", str, ", content=", str2, ", createdAt=");
        sbV.append(j4);
        sbV.append(", category=");
        sbV.append(str3);
        sbV.append(", date=");
        sbV.append(str4);
        sbV.append(", confidence=");
        sbV.append(d);
        sbV.append(", profileType=");
        sbV.append(str5);
        sbV.append(", state=");
        sbV.append(str6);
        sbV.append(", memoryIndex=");
        sbV.append(j8);
        sbV.append(", keywords=");
        sbV.append(list);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ MemoryRecord(String str, String str2, long j4, String str3, String str4, double d, String str5, String str6, long j8, List list, int i8, i iVar) {
        this(str, str2, (i8 & 4) != 0 ? System.currentTimeMillis() : j4, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i8 & 16) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4, (i8 & 32) != 0 ? 0.0d : d, (i8 & 64) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str5, (i8 & 128) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str6, (i8 & 256) != 0 ? 0L : j8, (i8 & 512) != 0 ? s.f1092a : list);
    }
}
