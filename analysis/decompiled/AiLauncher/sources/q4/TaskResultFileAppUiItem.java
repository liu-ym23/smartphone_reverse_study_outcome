package q4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lq4/e;", "", "", "fileId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "f", Const.INTENT_KEY_UMID, "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.e, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskResultFileAppUiItem {

    @SerializedName("cloudPath")
    private final String cloudPath;

    @SerializedName("fileId")
    private final String fileId;

    @SerializedName("fileName")
    private final String fileName;

    @SerializedName("mimeType")
    private final String mimeType;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final Long size;

    @SerializedName("title")
    private final String title;

    public TaskResultFileAppUiItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCloudPath() {
        return this.cloudPath;
    }

    /* renamed from: b, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: d, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: e, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultFileAppUiItem)) {
            return false;
        }
        TaskResultFileAppUiItem taskResultFileAppUiItem = (TaskResultFileAppUiItem) other;
        return p.d(this.fileId, taskResultFileAppUiItem.fileId) && p.d(this.cloudPath, taskResultFileAppUiItem.cloudPath) && p.d(this.fileName, taskResultFileAppUiItem.fileName) && p.d(this.title, taskResultFileAppUiItem.title) && p.d(this.mimeType, taskResultFileAppUiItem.mimeType) && p.d(this.size, taskResultFileAppUiItem.size);
    }

    /* renamed from: f, reason: from getter */
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
        return iHashCode5 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        return "TaskResultFileAppUiItem(fileId=" + this.fileId + ", cloudPath=" + this.cloudPath + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ")";
    }

    public TaskResultFileAppUiItem(String fileId, String str, String str2, String str3, String str4, Long l10) {
        p.i(fileId, "fileId");
        this.fileId = fileId;
        this.cloudPath = str;
        this.fileName = str2;
        this.title = str3;
        this.mimeType = str4;
        this.size = l10;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ TaskResultFileAppUiItem(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.Long r7, int r8, kotlin.jvm.internal.i r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = r0
        L11:
            r9 = r8 & 8
            if (r9 == 0) goto L16
            r5 = r0
        L16:
            r9 = r8 & 16
            if (r9 == 0) goto L1b
            r6 = r0
        L1b:
            r8 = r8 & 32
            if (r8 == 0) goto L27
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L27:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.TaskResultFileAppUiItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, int, kotlin.jvm.internal.i):void");
    }
}
