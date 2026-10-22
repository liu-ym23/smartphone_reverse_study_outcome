package com.stepos.agentframework.chatcore.file;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b+\b\u0087\b\u0018\u0000 [2\u00020\u0001:\u0002\\]B}\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b#\u0010\u0017J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001fJ\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b+\u0010\u0017J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001fJ\u0010\u0010-\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0094\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u001fJ\u0010\u00102\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b2\u0010\u0017J\u001a\u00105\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010:R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00107\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010:R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010@R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010A\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010DR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00107\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010:R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010:R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010:R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010:R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00107\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010:R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010O\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010RR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010A\u001a\u0004\bS\u0010\u0017\"\u0004\bT\u0010DR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00107\u001a\u0004\bU\u0010\u001f\"\u0004\bV\u0010:R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010W\u001a\u0004\bX\u0010.\"\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/stepos/agentframework/chatcore/file/FileInfo;", "Landroid/os/Parcelable;", "", "fileId", "fileName", "Landroid/net/Uri;", "fileUri", "", "fileType", "fileSize", "filePath", "fileUrl", "mimeType", "devicePath", "Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;", "uploadState", "progress", "error", "", "silent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;ILjava/lang/String;Z)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Landroid/net/Uri;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "()Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;", "component11", "component12", "component13", "()Z", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;ILjava/lang/String;Z)Lcom/stepos/agentframework/chatcore/file/FileInfo;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "setFileId", "(Ljava/lang/String;)V", "getFileName", "setFileName", "Landroid/net/Uri;", "getFileUri", "setFileUri", "(Landroid/net/Uri;)V", "I", "getFileType", "setFileType", "(I)V", "getFileSize", "setFileSize", "getFilePath", "setFilePath", "getFileUrl", "setFileUrl", "getMimeType", "setMimeType", "getDevicePath", "setDevicePath", "Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;", "getUploadState", "setUploadState", "(Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;)V", "getProgress", "setProgress", "getError", "setError", "Z", "getSilent", "setSilent", "(Z)V", "Companion", Const.INTENT_KEY_APIKEY, "UploadState", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FileInfo implements Parcelable {
    public static final int FILE_TYPE_CODE = 12;
    public static final int FILE_TYPE_DOC = 3;
    public static final int FILE_TYPE_EXCEL = 9;
    public static final int FILE_TYPE_HTML = 14;
    public static final int FILE_TYPE_IMAGE = 1;
    public static final int FILE_TYPE_IMAGE_URL = 6;
    public static final int FILE_TYPE_MD = 11;
    public static final int FILE_TYPE_PDF = 4;
    public static final int FILE_TYPE_PPT = 7;
    public static final int FILE_TYPE_TXT = 10;
    public static final int FILE_TYPE_UNKNOWN = 5;
    public static final int FILE_TYPE_VIDEO = 2;
    public static final int FILE_TYPE_WORD = 8;
    public static final int FILE_TYPE_ZIP = 13;
    private String devicePath;
    private String error;
    private String fileId;
    private String fileName;
    private String filePath;
    private String fileSize;
    private int fileType;
    private Uri fileUri;
    private String fileUrl;
    private String mimeType;
    private int progress;
    private boolean silent;
    private UploadState uploadState;
    public static final Parcelable.Creator<FileInfo> CREATOR = new b();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatcore/file/FileInfo$UploadState;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "PENDING", "UPLOADING", AMapLocationStaticsEntity.SUCCESS_STATUS, "FAILED", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UploadState implements Parcelable {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ UploadState[] $VALUES;
        public static final Parcelable.Creator<UploadState> CREATOR;
        public static final UploadState PENDING = new UploadState("PENDING", 0);
        public static final UploadState UPLOADING = new UploadState("UPLOADING", 1);
        public static final UploadState SUCCESS = new UploadState(AMapLocationStaticsEntity.SUCCESS_STATUS, 2);
        public static final UploadState FAILED = new UploadState("FAILED", 3);

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<UploadState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final UploadState createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return UploadState.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final UploadState[] newArray(int i10) {
                return new UploadState[i10];
            }
        }

        private static final /* synthetic */ UploadState[] $values() {
            return new UploadState[]{PENDING, UPLOADING, SUCCESS, FAILED};
        }

        static {
            UploadState[] uploadStateArr$values = $values();
            $VALUES = uploadStateArr$values;
            $ENTRIES = kotlin.enums.a.a(uploadStateArr$values);
            CREATOR = new a();
        }

        private UploadState(String str, int i10) {
        }

        public static InterfaceC4149a<UploadState> getEntries() {
            return $ENTRIES;
        }

        public static UploadState valueOf(String str) {
            return (UploadState) Enum.valueOf(UploadState.class, str);
        }

        public static UploadState[] values() {
            return (UploadState[]) $VALUES.clone();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeString(name());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<FileInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FileInfo createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new FileInfo(parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(FileInfo.class.getClassLoader()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), UploadState.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FileInfo[] newArray(int i10) {
            return new FileInfo[i10];
        }
    }

    public FileInfo(String fileId, String fileName, Uri fileUri, int i10, String fileSize, String filePath, String fileUrl, String mimeType, String devicePath, UploadState uploadState, int i11, String str, boolean z10) {
        p.i(fileId, "fileId");
        p.i(fileName, "fileName");
        p.i(fileUri, "fileUri");
        p.i(fileSize, "fileSize");
        p.i(filePath, "filePath");
        p.i(fileUrl, "fileUrl");
        p.i(mimeType, "mimeType");
        p.i(devicePath, "devicePath");
        p.i(uploadState, "uploadState");
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileUri = fileUri;
        this.fileType = i10;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.fileUrl = fileUrl;
        this.mimeType = mimeType;
        this.devicePath = devicePath;
        this.uploadState = uploadState;
        this.progress = i11;
        this.error = str;
        this.silent = z10;
    }

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, String str, String str2, Uri uri, int i10, String str3, String str4, String str5, String str6, String str7, UploadState uploadState, int i11, String str8, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = fileInfo.fileId;
        }
        return fileInfo.copy(str, (i12 & 2) != 0 ? fileInfo.fileName : str2, (i12 & 4) != 0 ? fileInfo.fileUri : uri, (i12 & 8) != 0 ? fileInfo.fileType : i10, (i12 & 16) != 0 ? fileInfo.fileSize : str3, (i12 & 32) != 0 ? fileInfo.filePath : str4, (i12 & 64) != 0 ? fileInfo.fileUrl : str5, (i12 & 128) != 0 ? fileInfo.mimeType : str6, (i12 & 256) != 0 ? fileInfo.devicePath : str7, (i12 & 512) != 0 ? fileInfo.uploadState : uploadState, (i12 & 1024) != 0 ? fileInfo.progress : i11, (i12 & 2048) != 0 ? fileInfo.error : str8, (i12 & 4096) != 0 ? fileInfo.silent : z10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: component10, reason: from getter */
    public final UploadState getUploadState() {
        return this.uploadState;
    }

    /* renamed from: component11, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: component12, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getSilent() {
        return this.silent;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component3, reason: from getter */
    public final Uri getFileUri() {
        return this.fileUri;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFileType() {
        return this.fileType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDevicePath() {
        return this.devicePath;
    }

    public final FileInfo copy(String fileId, String fileName, Uri fileUri, int fileType, String fileSize, String filePath, String fileUrl, String mimeType, String devicePath, UploadState uploadState, int progress, String error, boolean silent) {
        p.i(fileId, "fileId");
        p.i(fileName, "fileName");
        p.i(fileUri, "fileUri");
        p.i(fileSize, "fileSize");
        p.i(filePath, "filePath");
        p.i(fileUrl, "fileUrl");
        p.i(mimeType, "mimeType");
        p.i(devicePath, "devicePath");
        p.i(uploadState, "uploadState");
        return new FileInfo(fileId, fileName, fileUri, fileType, fileSize, filePath, fileUrl, mimeType, devicePath, uploadState, progress, error, silent);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) other;
        return p.d(this.fileId, fileInfo.fileId) && p.d(this.fileName, fileInfo.fileName) && p.d(this.fileUri, fileInfo.fileUri) && this.fileType == fileInfo.fileType && p.d(this.fileSize, fileInfo.fileSize) && p.d(this.filePath, fileInfo.filePath) && p.d(this.fileUrl, fileInfo.fileUrl) && p.d(this.mimeType, fileInfo.mimeType) && p.d(this.devicePath, fileInfo.devicePath) && this.uploadState == fileInfo.uploadState && this.progress == fileInfo.progress && p.d(this.error, fileInfo.error) && this.silent == fileInfo.silent;
    }

    public final String getDevicePath() {
        return this.devicePath;
    }

    public final String getError() {
        return this.error;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileSize() {
        return this.fileSize;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final Uri getFileUri() {
        return this.fileUri;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final UploadState getUploadState() {
        return this.uploadState;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.fileId.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.fileUri.hashCode()) * 31) + Integer.hashCode(this.fileType)) * 31) + this.fileSize.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.fileUrl.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + this.devicePath.hashCode()) * 31) + this.uploadState.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31;
        String str = this.error;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.silent);
    }

    public final void setDevicePath(String str) {
        p.i(str, "<set-?>");
        this.devicePath = str;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final void setFileId(String str) {
        p.i(str, "<set-?>");
        this.fileId = str;
    }

    public final void setFileName(String str) {
        p.i(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFilePath(String str) {
        p.i(str, "<set-?>");
        this.filePath = str;
    }

    public final void setFileSize(String str) {
        p.i(str, "<set-?>");
        this.fileSize = str;
    }

    public final void setFileType(int i10) {
        this.fileType = i10;
    }

    public final void setFileUri(Uri uri) {
        p.i(uri, "<set-?>");
        this.fileUri = uri;
    }

    public final void setFileUrl(String str) {
        p.i(str, "<set-?>");
        this.fileUrl = str;
    }

    public final void setMimeType(String str) {
        p.i(str, "<set-?>");
        this.mimeType = str;
    }

    public final void setProgress(int i10) {
        this.progress = i10;
    }

    public final void setSilent(boolean z10) {
        this.silent = z10;
    }

    public final void setUploadState(UploadState uploadState) {
        p.i(uploadState, "<set-?>");
        this.uploadState = uploadState;
    }

    public String toString() {
        return "FileInfo(fileId=" + this.fileId + ", fileName=" + this.fileName + ", fileUri=" + this.fileUri + ", fileType=" + this.fileType + ", fileSize=" + this.fileSize + ", filePath=" + this.filePath + ", fileUrl=" + this.fileUrl + ", mimeType=" + this.mimeType + ", devicePath=" + this.devicePath + ", uploadState=" + this.uploadState + ", progress=" + this.progress + ", error=" + this.error + ", silent=" + this.silent + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.fileId);
        dest.writeString(this.fileName);
        dest.writeParcelable(this.fileUri, flags);
        dest.writeInt(this.fileType);
        dest.writeString(this.fileSize);
        dest.writeString(this.filePath);
        dest.writeString(this.fileUrl);
        dest.writeString(this.mimeType);
        dest.writeString(this.devicePath);
        this.uploadState.writeToParcel(dest, flags);
        dest.writeInt(this.progress);
        dest.writeString(this.error);
        dest.writeInt(this.silent ? 1 : 0);
    }

    public /* synthetic */ FileInfo(String str, String str2, Uri uri, int i10, String str3, String str4, String str5, String str6, String str7, UploadState uploadState, int i11, String str8, boolean z10, int i12, i iVar) {
        this(str, str2, uri, i10, str3, str4, str5, (i12 & 128) != 0 ? "" : str6, (i12 & 256) != 0 ? "" : str7, (i12 & 512) != 0 ? UploadState.PENDING : uploadState, (i12 & 1024) != 0 ? 0 : i11, (i12 & 2048) != 0 ? null : str8, (i12 & 4096) != 0 ? false : z10);
    }
}
