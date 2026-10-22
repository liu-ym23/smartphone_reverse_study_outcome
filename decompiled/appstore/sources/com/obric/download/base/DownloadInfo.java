package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.UiType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b5\u0018\u0000 Q2\u00020\u0001:\u0001RB«\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010$R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010%\u001a\u0004\b3\u0010\"\"\u0004\b4\u00105R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00106\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b=\u0010$R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b>\u0010$R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b?\u0010$R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b@\u0010$R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\bF\u0010$\"\u0004\bG\u0010HR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010HR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\bK\u0010$\"\u0004\bL\u0010HR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010M\u001a\u0004\b\u0017\u0010N\"\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/obric/download/base/DownloadInfo;", "Landroid/os/Parcelable;", "", "id", "", "url", "", "progress", "", "speed", "status", "", "curBytes", "totalBytes", "tmpFilePath", "targetFilePath", "title", "iconUrl", "errorCode", "errorMsg", "extraInfo", "lastModifiedTime", "", "isForceDownload", "<init>", "(ILjava/lang/String;FDIJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "I", "getId", "Ljava/lang/String;", "getUrl", "F", "getProgress", "()F", "setProgress", "(F)V", "D", "getSpeed", "()D", "setSpeed", "(D)V", "getStatus", "setStatus", "(I)V", "J", "getCurBytes", "()J", "setCurBytes", "(J)V", "getTotalBytes", "setTotalBytes", "getTmpFilePath", "getTargetFilePath", "getTitle", "getIconUrl", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "getErrorMsg", "setErrorMsg", "(Ljava/lang/String;)V", "getExtraInfo", "setExtraInfo", "getLastModifiedTime", "setLastModifiedTime", "Z", "()Z", "setForceDownload", "(Z)V", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class DownloadInfo implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private long curBytes;

    @Nullable
    private Integer errorCode;

    @Nullable
    private String errorMsg;

    @Nullable
    private String extraInfo;

    @Nullable
    private final String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f11860id;
    private boolean isForceDownload;

    @Nullable
    private String lastModifiedTime;
    private float progress;
    private double speed;
    private int status;

    @Nullable
    private final String targetFilePath;

    @Nullable
    private final String title;

    @NotNull
    private final String tmpFilePath;
    private long totalBytes;

    @NotNull
    private final String url;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public DownloadInfo a(Parcel r10) {
            q.g(r10, "parcel");
            return new DownloadInfo(r10);
        }

        public DownloadInfo[] b(int r10) {
            return new DownloadInfo[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public DownloadInfo(int r10, @NotNull String r11, float r12, double r13, int r14, long r15, long r16, @NotNull String r17, @Nullable String r18, @Nullable String r19, @Nullable String r110, @Nullable Integer r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, boolean r24) {
        q.g(r11, "url");
        q.g(r17, "tmpFilePath");
        this.f11860id = r10;
        this.url = r11;
        this.progress = r12;
        this.speed = r13;
        this.status = r14;
        this.curBytes = r15;
        this.totalBytes = r16;
        this.tmpFilePath = r17;
        this.targetFilePath = r18;
        this.title = r19;
        this.iconUrl = r110;
        this.errorCode = r20;
        this.errorMsg = r21;
        this.extraInfo = r22;
        this.lastModifiedTime = r23;
        this.isForceDownload = r24;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getCurBytes() {
        return this.curBytes;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    public final String getExtraInfo() {
        return this.extraInfo;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.f11860id;
    }

    @Nullable
    public final String getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final double getSpeed() {
        return this.speed;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTargetFilePath() {
        return this.targetFilePath;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTmpFilePath() {
        return this.tmpFilePath;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean isForceDownload() {
        return this.isForceDownload;
    }

    public final void setCurBytes(long r10) {
        this.curBytes = r10;
    }

    public final void setErrorCode(@Nullable Integer r10) {
        this.errorCode = r10;
    }

    public final void setErrorMsg(@Nullable String r10) {
        this.errorMsg = r10;
    }

    public final void setExtraInfo(@Nullable String r10) {
        this.extraInfo = r10;
    }

    public final void setForceDownload(boolean r10) {
        this.isForceDownload = r10;
    }

    public final void setLastModifiedTime(@Nullable String r10) {
        this.lastModifiedTime = r10;
    }

    public final void setProgress(float r10) {
        this.progress = r10;
    }

    public final void setSpeed(double r10) {
        this.speed = r10;
    }

    public final void setStatus(int r10) {
        this.status = r10;
    }

    public final void setTotalBytes(long r10) {
        this.totalBytes = r10;
    }

    @NotNull
    public String toString() {
        return "DownloadInfo(id=" + this.f11860id + ", url='" + this.url + "', progress=" + this.progress + ", speed=" + this.speed + ", status=" + this.status + ", curBytes=" + this.curBytes + ", totalBytes=" + this.totalBytes + ", tmpFilePath='" + this.tmpFilePath + "', targetFilePath=" + this.targetFilePath + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", extraInfo=" + this.extraInfo + ", lastModifiedTime=" + this.lastModifiedTime + ", isForceDownload=" + this.isForceDownload + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeInt(this.f11860id);
        r10.writeString(this.url);
        r10.writeFloat(this.progress);
        r10.writeDouble(this.speed);
        r10.writeInt(this.status);
        r10.writeLong(this.curBytes);
        r10.writeLong(this.totalBytes);
        r10.writeString(this.tmpFilePath);
        r10.writeString(this.targetFilePath);
        r10.writeString(this.title);
        r10.writeString(this.iconUrl);
        r10.writeValue(this.errorCode);
        r10.writeString(this.errorMsg);
        r10.writeString(this.extraInfo);
        r10.writeString(this.lastModifiedTime);
        r10.writeBoolean(this.isForceDownload);
    }

    public /* synthetic */ DownloadInfo(int r25, String r26, float r27, double r28, int r30, long r31, long r33, String r35, String r36, String r37, String r38, Integer r39, String r40, String r41, String r42, boolean r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 32) == 0) goto L5;
        long r11 = 0;
    L7:
        if ((r44 & 64) == 0) goto L9;
        long r13 = 0;
    L11:
        if ((r44 & 128) == 0) goto L13;
        String r15 = "";
    L15:
        if ((r44 & 256) == 0) goto L17;
        String r16 = "";
    L19:
        if ((r44 & 512) == 0) goto L21;
        String r17 = "";
    L23:
        if ((r44 & 1024) == 0) goto L25;
        String r18 = "";
    L27:
        if ((r44 & 2048) == 0) goto L29;
        Integer r19 = 0;
    L31:
        if ((r44 & 4096) == 0) goto L33;
        String r20 = "";
    L35:
        if ((r44 & 8192) == 0) goto L37;
        String r21 = "";
    L39:
        if ((r44 & 16384) == 0) goto L41;
        String r22 = "";
    L43:
        if ((r44 & UiType.FLAG_SETTINGS_CARD) == 0) goto L45;
        boolean r23 = false;
    L46:
        this(r25, r26, r27, r28, r30, r11, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        return;
    L45:
        r23 = r43;
        goto L46
    L41:
        r22 = r42;
        goto L43
    L37:
        r21 = r41;
        goto L39
    L33:
        r20 = r40;
        goto L35
    L29:
        r19 = r39;
        goto L31
    L25:
        r18 = r38;
        goto L27
    L21:
        r17 = r37;
        goto L23
    L17:
        r16 = r36;
        goto L19
    L13:
        r15 = r35;
        goto L15
    L9:
        r13 = r33;
        goto L11
    L5:
        r11 = r31;
        goto L7
    }

    public DownloadInfo(@NotNull Parcel r23) {
        q.g(r23, "parcel");
        int r10 = r23.readInt();
        String r11 = r23.readString();
        if (r11 != null) goto L5;
        String r12 = "";
    L6:
        q.f(r12, "parcel.readString() ?: \"\"");
        float r13 = r23.readFloat();
        double r14 = r23.readDouble();
        int r15 = r23.readInt();
        long r16 = r23.readLong();
        long r17 = r23.readLong();
        String r18 = r23.readString();
        if (r18 != null) goto L9;
        r18 = "";
    L9:
        q.f(r18, "parcel.readString() ?: \"\"");
        String r19 = r23.readString();
        String r110 = r23.readString();
        String r111 = r23.readString();
        Object r20 = r23.readValue(Integer.TYPE.getClassLoader());
        if ((r20 instanceof Integer) == true) goto L12;
        r20 = null;
    L12:
        this(r10, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, (Integer) r20, r23.readString(), r23.readString(), r23.readString(), r23.readBoolean());
        return;
    L5:
        r12 = r11;
        goto L6
    }
}
