package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\"R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b#\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b*\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b+\u0010\u0018R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b,\u0010\u0018R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b-\u0010\u0018R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b.\u0010\u0018R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b2\u0010\u0018R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u0010\u001aR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b5\u0010\u0018R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b6\u0010\u0018¨\u00067"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/c;", "", "", "partId", "status", "Lcom/stepos/agentframework/adapter/netcore/BusPartType;", "type", "Lcom/stepos/agentframework/adapter/netcore/BusContentType;", "contentType", "fileId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "sha256", "", "taskVersion", "errorReason", "errorDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/BusPartType;Lcom/stepos/agentframework/adapter/netcore/BusContentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "setPartId", "(Ljava/lang/String;)V", "k", "Lcom/stepos/agentframework/adapter/netcore/BusPartType;", "n", "()Lcom/stepos/agentframework/adapter/netcore/BusPartType;", "Lcom/stepos/agentframework/adapter/netcore/BusContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/BusContentType;", "e", Const.INTENT_KEY_APIKEY, "f", "m", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "I", "l", Const.INTENT_KEY_UMID, "c", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class BusPart {
    private final String content;
    private final BusContentType contentType;
    private final String errorDetail;
    private final String errorReason;
    private final String fileId;
    private final String fileName;
    private final String mimeType;
    private String partId;
    private final String sha256;
    private final Long size;
    private final String status;
    private final int taskVersion;
    private final String title;
    private final BusPartType type;

    public BusPart(String str, String str2, BusPartType type, BusContentType contentType, String str3, String content, String str4, String str5, String str6, Long l10, String str7, int i10, String str8, String str9) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        kotlin.jvm.internal.p.i(content, "content");
        this.partId = str;
        this.status = str2;
        this.type = type;
        this.contentType = contentType;
        this.fileId = str3;
        this.content = content;
        this.fileName = str4;
        this.title = str5;
        this.mimeType = str6;
        this.size = l10;
        this.sha256 = str7;
        this.taskVersion = i10;
        this.errorReason = str8;
        this.errorDetail = str9;
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final BusContentType getContentType() {
        return this.contentType;
    }

    /* renamed from: c, reason: from getter */
    public final String getErrorDetail() {
        return this.errorDetail;
    }

    /* renamed from: d, reason: from getter */
    public final String getErrorReason() {
        return this.errorReason;
    }

    /* renamed from: e, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusPart)) {
            return false;
        }
        BusPart busPart = (BusPart) other;
        return kotlin.jvm.internal.p.d(this.partId, busPart.partId) && kotlin.jvm.internal.p.d(this.status, busPart.status) && this.type == busPart.type && this.contentType == busPart.contentType && kotlin.jvm.internal.p.d(this.fileId, busPart.fileId) && kotlin.jvm.internal.p.d(this.content, busPart.content) && kotlin.jvm.internal.p.d(this.fileName, busPart.fileName) && kotlin.jvm.internal.p.d(this.title, busPart.title) && kotlin.jvm.internal.p.d(this.mimeType, busPart.mimeType) && kotlin.jvm.internal.p.d(this.size, busPart.size) && kotlin.jvm.internal.p.d(this.sha256, busPart.sha256) && this.taskVersion == busPart.taskVersion && kotlin.jvm.internal.p.d(this.errorReason, busPart.errorReason) && kotlin.jvm.internal.p.d(this.errorDetail, busPart.errorDetail);
    }

    /* renamed from: f, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: g, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: h, reason: from getter */
    public final String getPartId() {
        return this.partId;
    }

    public int hashCode() {
        String str = this.partId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31) + this.contentType.hashCode()) * 31;
        String str3 = this.fileId;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.content.hashCode()) * 31;
        String str4 = this.fileName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mimeType;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode7 = (iHashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str7 = this.sha256;
        int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31;
        String str8 = this.errorReason;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.errorDetail;
        return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    /* renamed from: j, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: k, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: l, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: m, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: n, reason: from getter */
    public final BusPartType getType() {
        return this.type;
    }

    public String toString() {
        return "BusPart(partId=" + this.partId + ", status=" + this.status + ", type=" + this.type + ", contentType=" + this.contentType + ", fileId=" + this.fileId + ", content=" + this.content + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", sha256=" + this.sha256 + ", taskVersion=" + this.taskVersion + ", errorReason=" + this.errorReason + ", errorDetail=" + this.errorDetail + ")";
    }
}
