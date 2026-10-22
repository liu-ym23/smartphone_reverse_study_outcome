package com.stepos.ailauncher.taskstore.chat;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/E;", "", "", "fileId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Long;", Const.INTENT_KEY_PKGNAME, "e", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.E, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskResultCodeItem {

    @SerializedName("cloudPath")
    private final String cloudPath;

    @SerializedName(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)
    private final String content;

    @SerializedName("fileId")
    private final String fileId;

    @SerializedName("fileName")
    private final String fileName;

    @SerializedName("language")
    private final String language;

    @SerializedName("mimeType")
    private final String mimeType;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final Long size;

    @SerializedName("title")
    private final String title;

    public TaskResultCodeItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCloudPath() {
        return this.cloudPath;
    }

    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: d, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: e, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultCodeItem)) {
            return false;
        }
        TaskResultCodeItem taskResultCodeItem = (TaskResultCodeItem) other;
        return kotlin.jvm.internal.p.d(this.fileId, taskResultCodeItem.fileId) && kotlin.jvm.internal.p.d(this.cloudPath, taskResultCodeItem.cloudPath) && kotlin.jvm.internal.p.d(this.fileName, taskResultCodeItem.fileName) && kotlin.jvm.internal.p.d(this.title, taskResultCodeItem.title) && kotlin.jvm.internal.p.d(this.mimeType, taskResultCodeItem.mimeType) && kotlin.jvm.internal.p.d(this.size, taskResultCodeItem.size) && kotlin.jvm.internal.p.d(this.content, taskResultCodeItem.content) && kotlin.jvm.internal.p.d(this.language, taskResultCodeItem.language);
    }

    /* renamed from: f, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: g, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = this.fileId.hashCode() * 31;
        String str = this.cloudPath;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode6 = (iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str5 = this.content;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.language;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "TaskResultCodeItem(fileId=" + this.fileId + ", cloudPath=" + this.cloudPath + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", content=" + this.content + ", language=" + this.language + ")";
    }

    public TaskResultCodeItem(String fileId, String str, String str2, String str3, String str4, Long l10, String str5, String str6) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        this.fileId = fileId;
        this.cloudPath = str;
        this.fileName = str2;
        this.title = str3;
        this.mimeType = str4;
        this.size = l10;
        this.content = str5;
        this.language = str6;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ TaskResultCodeItem(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.Long r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.i r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto Lc
            r3 = r0
        Lc:
            r11 = r10 & 4
            if (r11 == 0) goto L11
            r4 = r0
        L11:
            r11 = r10 & 8
            if (r11 == 0) goto L16
            r5 = r0
        L16:
            r11 = r10 & 16
            if (r11 == 0) goto L1b
            r6 = r0
        L1b:
            r11 = r10 & 32
            if (r11 == 0) goto L20
            r7 = r0
        L20:
            r11 = r10 & 64
            if (r11 == 0) goto L25
            r8 = r0
        L25:
            r10 = r10 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L33
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L3c
        L33:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L3c:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.chat.TaskResultCodeItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
