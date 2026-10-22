package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/u;", "", "", "fileId", "fileStatus", "fileName", "mime", "", ContentDisposition.Parameters.Size, "url", "previewUrl", "tosFileId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.u, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetFileSyncResponseData {

    @SerializedName("file_id")
    private final String fileId;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_status")
    private final String fileStatus;

    @SerializedName("mime")
    private final String mime;

    @SerializedName("preview_url")
    private final String previewUrl;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final Long size;

    @SerializedName("tos_file_id")
    private final String tosFileId;

    @SerializedName("url")
    private final String url;

    public GetFileSyncResponseData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: b, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileStatus() {
        return this.fileStatus;
    }

    /* renamed from: d, reason: from getter */
    public final String getMime() {
        return this.mime;
    }

    /* renamed from: e, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetFileSyncResponseData)) {
            return false;
        }
        GetFileSyncResponseData getFileSyncResponseData = (GetFileSyncResponseData) other;
        return kotlin.jvm.internal.p.d(this.fileId, getFileSyncResponseData.fileId) && kotlin.jvm.internal.p.d(this.fileStatus, getFileSyncResponseData.fileStatus) && kotlin.jvm.internal.p.d(this.fileName, getFileSyncResponseData.fileName) && kotlin.jvm.internal.p.d(this.mime, getFileSyncResponseData.mime) && kotlin.jvm.internal.p.d(this.size, getFileSyncResponseData.size) && kotlin.jvm.internal.p.d(this.url, getFileSyncResponseData.url) && kotlin.jvm.internal.p.d(this.previewUrl, getFileSyncResponseData.previewUrl) && kotlin.jvm.internal.p.d(this.tosFileId, getFileSyncResponseData.tosFileId);
    }

    /* renamed from: f, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: g, reason: from getter */
    public final String getTosFileId() {
        return this.tosFileId;
    }

    /* renamed from: h, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.fileId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fileStatus;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mime;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode5 = (iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str5 = this.url;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.previewUrl;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.tosFileId;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "GetFileSyncResponseData(fileId=" + this.fileId + ", fileStatus=" + this.fileStatus + ", fileName=" + this.fileName + ", mime=" + this.mime + ", size=" + this.size + ", url=" + this.url + ", previewUrl=" + this.previewUrl + ", tosFileId=" + this.tosFileId + ")";
    }

    public GetFileSyncResponseData(String str, String str2, String str3, String str4, Long l10, String str5, String str6, String str7) {
        this.fileId = str;
        this.fileStatus = str2;
        this.fileName = str3;
        this.mime = str4;
        this.size = l10;
        this.url = str5;
        this.previewUrl = str6;
        this.tosFileId = str7;
    }

    public /* synthetic */ GetFileSyncResponseData(String str, String str2, String str3, String str4, Long l10, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : l10, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7);
    }
}
